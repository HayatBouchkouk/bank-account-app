package com.example.accountservice.controller;


import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.model.BankAccount;
import com.example.accountservice.model.Customer;
import com.example.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;


    @GetMapping("/accounts")
    public List<BankAccount> accountList()
    {
        List<BankAccount> bankAccountList= bankAccountList= accountRepository.findAll();
            bankAccountList.forEach(acc->
            {
                acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
            });

        return bankAccountList;
    }


    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id)
    {
        BankAccount bankAccount =accountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());

        bankAccount.setCustomer(customer);

        return bankAccount;


    }
}
