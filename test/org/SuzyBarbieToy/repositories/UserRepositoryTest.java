package org.SuzyBarbieToy.repositories;

import org.SuzyBarbieToy.models.User;
import org.SuzyBarbieToy.repositories.db.DatabaseConnectionManager;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    private  final UserRepository userRepository = new UserRepository();


    @Test
    public void testSaveUser(){
        User user= new User();
        User saveUser = userRepository.saveUser(user);
        assertNotNull(saveUser);
    }


    @Test
    public void testUpdateUser(){
        Long userId = 4L;
        Long walletId = 200L;
        Connection connection = DatabaseConnectionManager.getInstance().getConnection();
        User user = userRepository.updateUser(connection,userId, walletId);
        assertNotNull(user);
        assertEquals(200L, user.getWalletId());
    }



    @Test
    public void testFindUserById(){
        Connection connection = DatabaseConnectionManager.getInstance().getConnection();
        User user = userRepository.findById(connection, 3L).orElseThrow();
        assertNotNull(user);
        assertEquals(3L, user.getId());
    }


    @Test
    public void testDeleteUserOne(){
        Connection connection = DatabaseConnectionManager.getInstance().getConnection();
        userRepository.deleteById(1L);
        Optional<User> user = userRepository.findById(connection,1L);
        assertTrue(user.isEmpty());
    }
    @Test
    public void findAllUser(){
            List<User> users = userRepository.findAll();
            System.out.println("users: "+users);
            assertNotNull(users);
            assertEquals(16, users.size());
        }
}