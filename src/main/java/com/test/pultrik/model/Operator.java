package com.test.pultrik.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operator")
    private long idOperator;
    private String nama;
}
