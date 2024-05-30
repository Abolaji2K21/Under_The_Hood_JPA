package org.SuzyBarbieToy.services;

import org.SuzyBarbieToy.models.Wallet;
import org.SuzyBarbieToy.repositories.WalletRepository;

import java.sql.Connection;

public class WalletService {
    private final WalletRepository walletRepository = new WalletRepository();


    public Wallet update(Connection connection, Wallet wallet){
        return walletRepository.updateWallet(connection,wallet.getId(), wallet.getBalance());
    }


    public Wallet getWalletBy(Connection connection, Long id){
        return walletRepository.findById(connection, id)
                .orElseThrow(()->new RuntimeException("Wallet not found"));
    }
}
