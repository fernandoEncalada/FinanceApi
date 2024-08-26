package com.fernando.finance.model.dbmo;

import com.fernando.finance.model.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Table(name = "loan")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @PrePersist
    private void onCreate(){
        createdAt = new java.util.Date();
        updatedAt = new java.util.Date();
    }
}
