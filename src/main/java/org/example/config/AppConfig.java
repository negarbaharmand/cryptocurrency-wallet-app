package org.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//We need to config the IOC container (Tell Spring framework try to config this package)
@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
   /* Way2:
    @Bean
    public TransactionDaoImpl transactionDao() {
        return new TransactionDaoImpl();
    }

    @Bean
    public WalletDaoImpl walletDao() {
        return new WalletDaoImpl();
    }

    @Bean
    public TransactionManagementImpl transactionManagement() {
        return new TransactionManagementImpl(walletDao(), transactionDao());
    }

    @Bean
    public WalletManagementImpl walletManagement() {
        return new WalletManagementImpl(walletDao());
    } */
}
