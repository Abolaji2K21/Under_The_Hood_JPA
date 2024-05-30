package org.SuzyBarbieToy.repositories;

import org.junit.jupiter.api.Test;
import org.SuzyBarbieToy.repositories.UserRepository;
import org.SuzyBarbieToy.repositories.db.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RepositoryTest {

    @Test
    public void testDatabaseConnection(){
        try(Connection connection = DatabaseConnectionManager.getInstance().getConnection()){
            assertNotNull(connection);
            System.out.println("connection--> "+connection);
        }catch (SQLException ex){
            assertNull(ex);
            ex.printStackTrace();
        }
    }
}