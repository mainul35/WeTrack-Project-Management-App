/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Mainul35
 */
public class WeTrackMenuBar extends javafx.scene.control.MenuBar {

    private static WeTrackMenuBar menuBar = null;

    private WeTrackMenuBar() {
        Menu fileMenu = new Menu("File");
        MenuItem newProject = new MenuItem("New Project");
        newProject.setOnAction(action->{
            CreateProjectWindow cpw = new CreateProjectWindow();
        });
        MenuItem openProject = new MenuItem("Open Project");
        openProject.setOnAction(value->{
            OpenProject op = new OpenProject();
            op.setVisible(true);
        });
        MenuItem logOut = new MenuItem("Log out");
        logOut.setOnAction(e->{
            Main.setTop(Main.getTopPane("WeTrack Login"));
            LogInForm.getCurrentSessionUser().setAvailabilityDuration(0);
            LogInForm.getCurrentSessionUser().setEmail("");
            LogInForm.getCurrentSessionUser().setName("");
            LogInForm.getCurrentSessionUser().setPassword("");
            Main.getMainScreen().setCenter(LogInForm.getLoginForm());
        });
        
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e->{
            System.exit(0);
        });
        fileMenu.getItems().addAll(newProject, openProject, logOut, exit);

        Menu editMenu = new Menu("Edit");
        MenuItem editProfile = new MenuItem("Edit Profile");
        MenuItem addSkill = new MenuItem("Add skill");
        addSkill.setOnAction(value->{
            AddSkillWindow asw = new AddSkillWindow();
        });
        editMenu.getItems().addAll(editProfile, addSkill);
        

        this.getMenus().addAll(fileMenu, editMenu);
    }

    public static WeTrackMenuBar getMenuBar() {
        if (menuBar == null) {
            menuBar = new WeTrackMenuBar();
            menuBar.setStyle("-fx-background-color: #aaaaaa;");
            
        }
        return menuBar;
    }
}
