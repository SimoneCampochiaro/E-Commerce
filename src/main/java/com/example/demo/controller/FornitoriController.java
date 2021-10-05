package com.example.demo.controller;


import com.example.demo.model.Fornitori;
import com.example.demo.service.FornitoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class FornitoriController {

    @Autowired
    private FornitoriService fornitoriService;

    @GetMapping("/get-fornitori")
    public List<Fornitori> getFornitori() {
        return fornitoriService.getFornitori();
    }
}
