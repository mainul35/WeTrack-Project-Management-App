/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.ConnectionManager;
import com.JDBC.JDBCManager;

/**
 *
 * @author Mainul35
 */
public class ProjectController {
    public static boolean createProject(long miliSec, String projectName, String userEmail){
        String sql = "insert into project(`projectId`,`projectName`, `userEmail`) values(?, ?, ?);";
        JDBCManager manager = ConnectionManager.getConnection();
        return manager.insertData(sql, miliSec, projectName, userEmail);
    }
    
//    public static String getProjectName(){}
}
