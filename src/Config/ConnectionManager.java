/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import com.JDBC.JDBCManager;

/**
 *
 * @author Mainul35
 */
public class ConnectionManager {
    private final JDBCManager manager = new JDBCManager();

    private ConnectionManager() {
        manager.initSqliteConnection("wetrack.db");
    }
    
    public static JDBCManager getConnection(){
        ConnectionManager cm = new ConnectionManager();
        return cm.manager;
    }
}
