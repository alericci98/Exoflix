package com.example.exoflix.services;

import com.example.exoflix.pojos.Registi;
import com.example.exoflix.repos.RegistiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistiService {
    @Autowired
    private RegistiRepository registiRepo;


    public List<Registi> allRegisti() {

        return registiRepo.findAll();
    }


    public Registi oneRegisti(Integer id) {
        return registiRepo.findById(id).orElseThrow(NullPointerException::new);
    }

}
