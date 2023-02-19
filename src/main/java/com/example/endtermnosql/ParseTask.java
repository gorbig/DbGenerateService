package com.example.endtermnosql;

import com.example.endtermnosql.model.Goods;
import com.example.endtermnosql.model.Gun;
import com.example.endtermnosql.repo.GunsRepository;
import com.example.endtermnosql.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Array;

@Component
public class ParseTask {

    @Autowired
    NewsService newsService;
    @Autowired
    GunsRepository gunsRepository;
    @Scheduled(fixedDelay = 90000)
    public void parseNewNews()
    {
        String url = "https://airsoft-rus.ru/catalog/1029/?PAGEN_1=2";
        try {


            Document doc = Jsoup.connect(url).get();
            Elements guns = doc.select("div.text-place");
            Long i= Long.valueOf(gunsRepository.findAll().size());
            String title;
            String articul;
            String produce;
            String oldCost;
            int oldCostInt;
            String cost;
            int costInt;
            for (Element gun:guns)
            {



                    title = gun.select("div.link-wrap").select("a").eachText().toString();
                    articul = gun.select("div.description").select("span").first().ownText();
                    produce = gun.select("div.description").select("span").last().ownText();
                    oldCost = gun.select("mark.old-price").eachText().toString();
                    cost = gun.select("mark.price").eachText().toString();
                    title = title.substring(1, title.length() - 1);
                    articul = articul.substring(9);
                    produce = produce.substring(15);
                    if (oldCost.length() > 4) {
                        oldCostInt = Integer.parseInt(oldCost.substring(1, oldCost.length() - 4).replaceAll("\\s", ""));
                    } else {
                        oldCostInt = 0;
                    }
                    if (cost.length() > 4) {
                        costInt = Integer.parseInt(cost.substring(1, cost.length() - 4).replaceAll("\\s", ""));
                    } else {
                        costInt = 0;
                    }
                if(!newsService.isExist(title)) {
                    Gun gun1 = new Gun();
                    gun1.setId(i++);
                    gun1.setTitle(title);
                    gun1.setArticul(articul);
                    gun1.setProduce(produce);
                    gun1.setOldcost(oldCostInt);
                    gun1.setCost(costInt);
                    newsService.save(gun1);
                }
//                System.out.println(title.substring(1,title.length()-1));
//                System.out.println(articul);
//                System.out.println(produce);
//                System.out.println(oldCostInt);
//                System.out.println(costInt);
            }


        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
