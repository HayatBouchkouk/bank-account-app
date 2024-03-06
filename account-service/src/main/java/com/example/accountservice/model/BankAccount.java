package com.example.accountservice.model;

import com.example.accountservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDateTime createdAt;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;

    private Long customerId;

}
