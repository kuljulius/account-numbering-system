package com.AJTech.account.numbering.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountGeneration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String accountNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountGeneration setAccountNumber(String accountNumber) {
        this.accountNumber = String.valueOf(accountNumber);
        return new AccountGeneration(id, getAccountNumber());
    }
}
