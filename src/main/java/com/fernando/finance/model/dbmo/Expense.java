package com.fernando.finance.model.dbmo;

import com.fernando.finance.model.StatusType;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Table(name = "expense")
@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column
    private String description;

    @Basic
    @Column
    private double amount;

    @Basic
    @Column(name = "created_at")
    private Date createdAt;

    @Basic
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "expense")
    private List<Category> categories;
}
