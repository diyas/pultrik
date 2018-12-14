package com.test.pultrik.controller;


import com.test.pultrik.Utility;
import com.test.pultrik.exception.NotFound;
import com.test.pultrik.model.Transaksi;
import com.test.pultrik.model.User;
import com.test.pultrik.model.Voucher;
import com.test.pultrik.model.payload.Response;
import com.test.pultrik.repository.TransaksiRepo;
import com.test.pultrik.repository.UserRepo;
import com.test.pultrik.repository.VoucherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransaksiCtl {

    @Autowired
    UserRepo userRepo;

    @Autowired
    VoucherRepo voucherRepo;

    @Autowired
    TransaksiRepo transaksiRepo;

    @PostMapping("/transaksi/{id_user}/{id_voucher}")
    public ResponseEntity addTransaksi(@PathVariable(name = "id_user") long idUser,@PathVariable(name = "id_voucher") long idVoucher, @RequestBody Transaksi transaksi){

        if (!Utility.validateForm("^[0-9]+$",transaksi.getNoHp()))
            return ResponseEntity.ok(new Response("1", "No Handphone harus terdiri dari Angka saja"));
        User user = userRepo.findById(idUser).orElseThrow(() -> new NotFound(""));
        Voucher voucher = voucherRepo.findById(idVoucher).orElseThrow(() -> new NotFound(""));
        transaksi.setUser(user);
        transaksi.setVoucher(voucher);
        Transaksi result = transaksiRepo.save(transaksi);
        return ResponseEntity.ok(new Response("0", "Sukses", result));
    }

    @GetMapping("/transaksi/{id_user}/{id_voucher}")
    @ModelAttribute(name = "all_voucher")
    public ResponseEntity getTransaksi(@PathVariable(name = "id_user") long idUser,@PathVariable(name = "id_voucher") long idVoucher){

        User user = userRepo.findById(idUser).orElseThrow(() -> new NotFound(""));
        Voucher voucher = voucherRepo.findById(idVoucher).orElseThrow(() -> new NotFound(""));
        List<Transaksi> lst = transaksiRepo.findByUserAndVoucher(user, voucher);
        return ResponseEntity.ok(new Response("0", "Sukses", lst));
    }

    @GetMapping("/transaksi/{id_user}")
    @ModelAttribute(name = "all_voucher")
    public ResponseEntity getAllTransaksi(@PathVariable(name = "id_user") long idUser){
        User user = userRepo.findById(idUser).orElseThrow(() -> new NotFound(""));
        List<Transaksi> lst = transaksiRepo.findByUser(user);
        return ResponseEntity.ok(new Response("0", "Sukses", lst));
    }
}
