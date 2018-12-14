package com.test.pultrik.controller;

import com.test.pultrik.model.Operator;
import com.test.pultrik.model.payload.Response;
import com.test.pultrik.repository.OperatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OperatorCtl {

    @Autowired
    OperatorRepo operatorRepo;

    @PostMapping("/operator")
    public ResponseEntity createUser(@RequestBody Operator operator){
        Operator o = operatorRepo.save(operator);
        return ResponseEntity.ok(new Response("0", "Sukses", o));
    }

    @GetMapping("/operator")
    @ModelAttribute(name = "all_operator")
    public ResponseEntity getAllOperator(){
        List<Operator> lst = operatorRepo.findAll();
        return ResponseEntity.ok(new Response("0", "Sukses", lst));
    }
}
