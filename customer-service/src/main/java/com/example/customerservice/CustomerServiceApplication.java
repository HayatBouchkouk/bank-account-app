package com.example.customerservice;

import com.example.customerservice.config.GlobalConfig;
import com.example.customerservice.model.Customer;
import com.example.customerservice.repository.CustomerRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository)
    {
        return args ->
        {


            Customer customer=Customer.builder()
                    .firstName("Hayat")
                    .lastName("Bouchkouk")
                    .email("hayat@gmail.com")
                    .build();


            Customer customer1=Customer.builder()
                    .firstName("Rajae")
                    .lastName("Bouchkouk")
                    .email("rajae@gmail.com")
                    .build();

            List<Customer> customerList=List.of(customer,customer1);

            customerRepository.saveAll(customerList);

        };
    }

}
