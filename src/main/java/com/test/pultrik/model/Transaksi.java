package com.test.pultrik.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaksi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    //@JsonIgnore
    private User user;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_voucher", nullable = false)
    //@JsonIgnore
    private Voucher voucher;
    @Column(name = "no_hp")
    private String noHp;
    private String harga;

}
