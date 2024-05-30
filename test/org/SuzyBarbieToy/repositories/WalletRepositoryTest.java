package org.SuzyBarbieToy.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.SuzyBarbieToy.models.Wallet;
import org.SuzyBarbieToy.repositories.db.DatabaseConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WalletRepositoryTest {

    private final WalletRepository walletRepository = new WalletRepository();

    @Test
    void testSave() {
        Wallet wallet = new Wallet();
        wallet.setBalance(new BigDecimal(1000));
        wallet = walletRepository.save(wallet);
        assertNotNull(wallet);
        assertNotNull(wallet.getId());
    }

    @Test
    public void testFindById(){
        Connection connection = DatabaseConnectionManager.getInstance().getConnection();
        Optional<Wallet> foundWallet = walletRepository.findById(connection,1L);
        assertTrue(foundWallet.isPresent());
    }

}