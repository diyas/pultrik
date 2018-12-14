package com.test.pultrik.model.payload;

import lombok.Data;

@Data
public class TransactionForm {

    private String idOperator;
    private String idVoucher;
    private String noHp;
    private String harga;

}
