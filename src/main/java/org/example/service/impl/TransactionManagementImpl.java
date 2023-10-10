package org.example.service.impl;

import org.example.dao.TransactionDao;
import org.example.dao.WalletDao;
import org.example.exception.WalletNotFoundException;
import org.example.model.CryptoCurrency;
import org.example.model.Transaction;
import org.example.model.Wallet;
import org.example.service.TransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//We make this class a bean in IOC container by writing @Container
@Component
public class TransactionManagementImpl implements TransactionManagement {

    private WalletDao walletDao;
    private TransactionDao transactionDao;

    @Autowired

    public TransactionManagementImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;

    }

    @Override
    public Transaction createDepositTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {
        // Validate the params that should not be null
        // Check if wallet id exists
        // Validate amount
        // Call deposit method in wallet object
        // Create transaction and save it to storage and return it
        if (walletId == null || cryptoCurrency == null || amount == null)
            throw new IllegalArgumentException("Wallet params are not valid");

        Optional<Wallet> optionalWallet = walletDao.findWallet(walletId);
        if (optionalWallet.isEmpty()) throw new WalletNotFoundException("Wallet not found.");

        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptoCurrency, amount);

        Transaction transaction = new Transaction("DEPOSIT", amount, walletId, cryptoCurrency.getName());
        transaction.setDescription(description);

        Transaction createdTransaction = transactionDao.createTransaction(transaction);

        return createdTransaction;
    }

    @Override
    public Transaction createWithdraTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(String walletId) {
        return null;
    }
}
