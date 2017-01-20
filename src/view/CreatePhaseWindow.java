/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author Mainul35
 */
public class CreatePhaseWindow extends TextInputDialog {

    public CreatePhaseWindow() {
        this.setTitle("Create P");
        this.setHeaderText(null);
        this.setContentText("Please enter your Project Name:");
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
        if(this.getTextField().getText().isEmpty()==false){
        if (Controller.ProjectController.createProject(System.currentTimeMillis(), this.getTextField().getText(), LogInForm.getCurrentSessionUser().getEmail()) == true) {
            Main.showMessageDialog(Alert.AlertType.CONFIRMATION, "Congrats", null, "Project created successfully.");
        } else {
            Main.showMessageDialog(Alert.AlertType.ERROR, "Failure", null, "Sorry, project creation failed!");
        }
        }else{
            Main.showMessageDialog(Alert.AlertType.ERROR, "Error", null, "A project must have a name");
        }
        
    }
}
