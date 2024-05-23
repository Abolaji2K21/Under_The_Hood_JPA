package org.SuzyBarbieToy.repositories;

import org.SuzyBarbieToy.models.User;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {

    private  final UserRepository userRepository = new UserRepository();

    @Test
    public void testDataBaseConnection(){
        try(Connection connection = UserRepository.connect()){
            assertNotNull(connection);
            System.out.println("connection -> " + connection);
        } catch (SQLException ex){
            assertNull(ex);
            ex.printStackTrace();
        };
    }

    @Test
    public void testSaveUser(){
        User user= new User();
        user.setId(1L);
        user.setWalletId(1L);
        User saveUser = userRepository.saveUser(user);
        assertNotNull(saveUser);
    }

}