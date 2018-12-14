package com.test.pultrik.controller;

import com.test.pultrik.model.User;
import com.test.pultrik.model.payload.Login;
import com.test.pultrik.model.payload.LoginResponse;
import com.test.pultrik.model.payload.Response;
import com.test.pultrik.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class UserCtl {

    @Autowired
    UserRepo userRepo;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login login){
        String userName = login.getUsername();
        String password = login.getPassword();
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(login.getUsername());
        if (!match.matches())
            return ResponseEntity.ok(new Response("1", "Username harus terdiri dari Huruf saja"));
        if (userName.length() < 6)
            return ResponseEntity.ok(new Response("1", "Username harus minimal 6 huruf"));
        User user = userRepo.findByUsernameAndPassword(login.getUsername(), login.getPassword());
        if (user == null){
            return ResponseEntity.ok(new Response("1", "Gagal"));
        }
        return ResponseEntity.ok(new Response("0","Sukses", new LoginResponse(user.getIdUser())));
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user){
        User u = userRepo.save(user);
        return ResponseEntity.ok(new Response("0", "Sukses", u));
    }

    @GetMapping("/user")
    public ResponseEntity getAllUser(){
        List<User> lst = userRepo.findAll();
        return ResponseEntity.ok(new Response("0", "Sukses", lst));
    }


}
