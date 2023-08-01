package com.fernando.finance.model.dbmo;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "category")
@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Expense expense;
}
