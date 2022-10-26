package com.AJTech.account.numbering.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountService service;
    @GetMapping("/account")
    public AccountGeneration getAccountNumber(AccountGeneration accountNumber){
        return service.generateAccountNumber(accountNumber.setAccountNumber(accountNumber.getAccountNumber()));
    }
}
