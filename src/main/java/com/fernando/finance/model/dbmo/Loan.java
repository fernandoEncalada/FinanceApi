package com.fernando.finance.model.dbmo;

import com.fernando.finance.model.StatusType;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Table(name = "loan")
@Entity
@Data
public class Loan {

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
