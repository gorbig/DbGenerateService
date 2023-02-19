package com.example.endtermnosql.service;

import com.example.endtermnosql.model.Gun;
import com.example.endtermnosql.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GunServiceInterface {
    public void save(Gun gun);
    public boolean isExist(String newsTitle);
    public List<Gun> getAllUsers();

    void deleteGun(Long id);
}
