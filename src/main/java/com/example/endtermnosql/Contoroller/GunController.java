package com.example.endtermnosql.Contoroller;

import com.example.endtermnosql.model.Gun;
import com.example.endtermnosql.repo.GunsRepository;
import com.example.endtermnosql.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GunController {
    @Autowired
    NewsService newsService;
    GunsRepository gunsRepository;
    @PutMapping(value="/add")
    public String addUser(@RequestBody Gun gun){
        newsService.save(gun);
        return "added Successfully";
    }

    @GetMapping(value="/getusers")
    public List<Gun> getUsers()
    {
      return   newsService.getAllUsers();
    }

//    @GetMapping(value = "/getuser/{id}")
//    public Optional<Gun> getuser(@PathVariable Long id)
//    {
//        return gunsRepository.findById(id);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        newsService.deleteGun(id);

        return "Deleted Successfully";
    }




}
