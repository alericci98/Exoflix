package com.example.exoflix.services;

import com.example.exoflix.pojos.Regista;
import com.example.exoflix.repos.RegistiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistiService {
    @Autowired
    private RegistiRepository registiRepo;


    public List<Regista> allRegisti() {

        return registiRepo.findAll();
    }


    public Regista oneRegisti(Integer id) {


        return registiRepo.findById(id).orElseThrow(NullPointerException::new);
    }

}
