package com.example.accountservice;

import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.enums.AccountType;
import com.example.accountservice.model.BankAccount;
import com.example.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient )
    {
        return args ->
        {
            customerRestClient.allCustomers().forEach(c->
            {
                BankAccount account= BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random()*90000)
                        .currency("euro")
                        .createdAt(LocalDateTime.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();


                BankAccount account1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random()*900)
                        .currency("euro")
                        .createdAt(LocalDateTime.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(c.getId())
                        .build();


                accountRepository.save(account1);
                accountRepository.save(account);
            });




        };
    }

}
