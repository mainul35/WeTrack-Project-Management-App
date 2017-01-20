/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.ConnectionManager;
import com.JDBC.JDBCManager;
import java.util.ArrayList;
import java.util.HashMap;
import model.User;
import model.UserList;

/**
 *
 * @author Mainul35
 */
public class UserAccessController {

    public static UserList getAllUser() {
        return UserList.getUserList();
    }

    public static User getUser(String email) {
        String sql = "SELECT * FROM User WHERE email = ?;";
        JDBCManager manager = ConnectionManager.getConnection();
        User user = new User();
        ArrayList<HashMap<String, String>> hm = manager.getQueryData(sql, email);
        try {
            user.setName(hm.get(0).get("name"));
            user.setEmail(hm.get(0).get("email"));
            user.setPassword(hm.get(0).get("password"));
            user.setAvailabilityDuration(Double.parseDouble(hm.get(0).get("availabilityDuration")));            
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return user;
    }

    public static boolean userExists(String email){
        String sql = "SELECT * FROM User WHERE email = ?;";
        JDBCManager manager = ConnectionManager.getConnection();
        if(manager.contains(sql, email)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean register(User user) {
        JDBCManager manager = ConnectionManager.getConnection();
        String sql = "insert into user(`name`, `email`, `password`, `availabilityDuration`)\n"
                + "values(?,?,?,?);";
        return manager.insertData(sql, user.getName(), user.getEmail(), user.getPassword(), user.getAvailabilityDuration());
    }
    
    
}
