package it.exolab.controllers;

import it.exolab.pojos.Registi;
import it.exolab.repos.RegistiRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/registi")
public class RegistiController {

    private final RegistiRepository repo;

    @GetMapping("/registiFindAll")
    public List<Registi> allRegisti(){

        return repo.findAll();
    }

    @GetMapping("/registi/{id}")
    public Registi oneRegisti(@PathVariable Integer id){
        return repo.findById(id).orElseThrow(NullPointerException::new);
    }



}
