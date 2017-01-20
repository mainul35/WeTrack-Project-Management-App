/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

/**
 *
 * @author Mainul35
 */
public class WelcomeScreen extends Label{
    private static final String DEFAULT_MESSAGE = "Welcome to WeTrack.\n";
    public WelcomeScreen() {
        this.setText(DEFAULT_MESSAGE);
        this.setPadding(new Insets(50));
    }
}

