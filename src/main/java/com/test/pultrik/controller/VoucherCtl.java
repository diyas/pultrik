package com.test.pultrik.controller;

import com.test.pultrik.exception.NotFound;
import com.test.pultrik.model.Voucher;
import com.test.pultrik.model.payload.Response;
import com.test.pultrik.repository.OperatorRepo;
import com.test.pultrik.repository.VoucherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VoucherCtl {
    @Autowired
    VoucherRepo voucherRepo;

    @Autowired
    OperatorRepo operatorRepo;


    @PostMapping("/voucher/{id_operator}")
    public ResponseEntity createUser(@PathVariable(name = "id_operator") long idOperator, @RequestBody Voucher voucher){
        Voucher result = operatorRepo.findById(idOperator).map(operator -> {
            voucher.setOperator(operator);
            return voucherRepo.save(voucher);
        }).orElseThrow(() -> new NotFound(""));
        return ResponseEntity.ok(new Response("0", "Sukses", result));
    }

    @GetMapping("/voucher/{id_operator}")
    public ResponseEntity getAllVoucher(@PathVariable(name = "id_operator") long idOperator){
        List<Voucher> lst = voucherRepo.findByOperatorIdOperator(idOperator);
        return ResponseEntity.ok(new Response("0", "Sukses", lst));
    }

}
