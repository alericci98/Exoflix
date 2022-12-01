package com.example.exoflix.services;

import com.example.exoflix.pojos.Abbonamento;
import com.example.exoflix.repos.AbbonamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbbonamentoService {

    @Autowired
    private AbbonamentoRepository abbonamentoRepository;

    public List<Abbonamento> findAll(){
        return abbonamentoRepository.findAll();
    }

    public Abbonamento findOne(Integer id){
        return abbonamentoRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
