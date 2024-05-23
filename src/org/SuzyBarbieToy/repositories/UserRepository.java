package org.SuzyBarbieToy.repositories;

import org.SuzyBarbieToy.models.User;

import java.sql.*;



public class UserRepository {



    public static Connection connect() {
        String url = "jdbc:postgresql://localhost:5432/suzies Store";

        // TODO: mysql --> jdbc:mysql://localhost:3306,
        // TODO: postgresql --> jdbc:postgresql://localhost:5432,


        String username = "postgres";
        String password = "password";


        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
            throw new RuntimeException(e);
       }
}
    public User saveUser(User user) {
        String getIdSqlStatement = "select  count(*) from users";
        String sql = "insert into users (id,wallet_id)values (?, ?)";
        try(Connection connection = connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(getIdSqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long currentId = resultSet.getLong(1);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,currentId+1);
//            preparedStatement.setLong(2,user.getWalletId());
            if(user.getWalletId() != null){
                preparedStatement.setLong(2,user.getWalletId());
            }
            preparedStatement.execute();
            return getUserBy(currentId+1);
        }catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Failed to connect to database");
        }

    }

    private User getUserBy(Long id){
        String sql = "select * from users where id=?";
        try(Connection connection = connect()){
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            var resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long userId = resultSet.getLong(1);
            long walletId = resultSet.getLong(2);
            User user = new User();
            user.setId(userId);
            user.setWalletId(walletId);
            return user;
        }catch(SQLException e){
            System.err.println(e.getMessage());
            throw new RuntimeException("Failed To Connect to database");
        }

    }

}

