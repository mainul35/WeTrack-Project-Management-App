/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Config.ConnectionManager;
import com.JDBC.JDBCManager;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author Mainul35
 */
public class AddSkillWindow extends TextInputDialog {

    public AddSkillWindow() {
        this.setTitle("Add a skill");
        this.setHeaderText(null);
        this.setContentText("Please enter a skill name:");
        Optional<String> result = this.showAndWait();

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> {
            save();
        });
    }

    public TextField getTextField() {
        return this.getEditor();
    }

    private void save() {
        if (this.getTextField().getText().isEmpty() == false) {
            long skillId = System.currentTimeMillis();
            String sql = "insert into skill (`skillId`, `skillName`) values('" + skillId + "', '" + this.getTextField().getText() + "');";
            JDBCManager manager = ConnectionManager.getConnection();
            manager.insertData(sql);
            sql = "insert into skillsOfUser(`skillId`, `userEmail`) \n"
                    + "values('" + skillId + "', '" + LogInForm.getCurrentSessionUser().getEmail() + "');";
            if (manager.insertData(sql)) {
            } else {
                Main.showMessageDialog(Alert.AlertType.ERROR, "Failure", null, "Sorry, Couldn't add skill");
            }
        } else {
            Main.showMessageDialog(Alert.AlertType.ERROR, "Error", null, "A project must have a name");
        }

    }
}
