package org.example.service;

import org.example.model.CryptoCurrency;
import org.example.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionManagement {
    Transaction createDepositTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description);

    Transaction createWithdraTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description);

    List<Transaction> getTransactionsByWalletId(String walletId);
}
