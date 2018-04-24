/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.sql.DataSource;

/**
 *
 * @author Henri
 */
@Singleton
public class Users implements UsersLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Resource(name = "jdbc/LostAndFound")
    private DataSource ds;
    
    public void retrieveData() {
        try {
            Connection connection = ds.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM USERS");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString("email"));
                System.out.println(resultSet.getString("password"));
            }
            connection.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
