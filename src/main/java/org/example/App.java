package org.example;


import org.example.config.AppConfig;
import org.example.model.CryptoCurrency;
import org.example.model.Transaction;
import org.example.model.Wallet;
import org.example.service.TransactionManagement;
import org.example.service.WalletManagement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
       /* WalletDao walletDao = new WalletDaoImpl();
        TransactionDao transactionDao = new TransactionDaoImpl();

        WalletManagement walletManagement = new WalletManagementImpl(walletDao);
        TransactionManagement transactionManagement = new TransactionManagementImpl(walletDao, transactionDao);*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WalletManagement walletManagement = context.getBean(WalletManagement.class);
        TransactionManagement transactionManagement = context.getBean(TransactionManagement.class);

        Wallet myWallet = walletManagement.create("My first Wallet");
        Transaction depositTransactionForBTC = transactionManagement.createDepositTransaction(
                myWallet.getId(),
                CryptoCurrency.BTC,
                new BigDecimal(1),
                "Test");

        System.out.println(walletManagement.getById(myWallet.getId()));

    }
}
