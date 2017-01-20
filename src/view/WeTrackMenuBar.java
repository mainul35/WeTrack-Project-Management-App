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
        MenuItem newPhase = new MenuItem("New Phase");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(newProject, newPhase, exit);

        Menu editMenu = new Menu("Edit");
        MenuItem editProfile = new MenuItem("Edit Profile");
        MenuItem addSkill = new MenuItem("Add skill");
        editMenu.getItems().addAll(editProfile, addSkill);

        Menu logOutMenu = new Menu("Log out");

        this.getMenus().addAll(fileMenu, editMenu, logOutMenu);
    }

    public static WeTrackMenuBar getMenuBar() {
        if (menuBar == null) {
            menuBar = new WeTrackMenuBar();
            menuBar.setStyle("-fx-background-color: #aaaaaa;");
            
        }
        return menuBar;
    }
}
