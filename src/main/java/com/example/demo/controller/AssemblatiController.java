package com.example.demo.controller;

import com.example.demo.model.Assemblati;
import com.example.demo.service.AssemblatiService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class AssemblatiController{

    @Autowired

    private AssemblatiService assemblatiService;

    @GetMapping("/get-assemblati")
    public List<Assemblati> getAssemblati(){
        return assemblatiService.getAssemblati();
    }

    @GetMapping("/get-assemblati/{id}")
    public Assemblati getAssemblatiById(@PathVariable("id") Integer id){
        return assemblatiService.getAssemblatiById(id);
    }

    @PostMapping("/save-assemblati")
    public void saveAssemblati(@RequestBody @NotNull List<Assemblati> assemblati){
        assemblatiService.saveOrUpdateAssemblati(assemblati);
    }

    @DeleteMapping("/cancella-assemblati")
    public void deleteAssemblati(@RequestBody @NotNull List<Assemblati> assemblati){
        assemblatiService.deleteAssemblati(assemblati);
    }

    @DeleteMapping("/cancella-assemblati/{id}")
    public void deleteAssemblatiById(@PathVariable("id") Integer id){
        assemblatiService.deleteAssemblatiById(id);
    }

}