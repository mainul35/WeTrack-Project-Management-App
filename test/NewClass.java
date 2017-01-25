
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mainul35
 */
public class NewClass {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:wetrack.db");
            String sql = "insert into phase(phaseId, phaseName, projectId)\n"
                    + " values(?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setObject(1, "");
            stmt.setObject(2, "");
            stmt.setObject(3, "");
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
