package com.fernando.finance.model.dbmo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "person")
@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column
    private String name;

    @OneToMany(mappedBy = "person")
    private List<Loan> loans;
}
