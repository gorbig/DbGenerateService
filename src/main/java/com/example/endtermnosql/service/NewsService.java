package com.example.endtermnosql.service;

import com.example.endtermnosql.model.Gun;


import com.example.endtermnosql.repo.GunsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements GunServiceInterface{
    @Autowired
    GunsRepository repository;


    @Override
    public void save(Gun gun) {
        repository.save(gun);
    }

    @Override
    public boolean isExist(String salonName) {
        List<Gun> goods = repository.findAll();
        for(Gun n : goods)
        {
            if(n.getTitle().equals(salonName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Gun> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void deleteGun(Long id) {
        repository.deleteById(id);
    }


}
