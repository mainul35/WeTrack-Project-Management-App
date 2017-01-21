/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Mainul35
 */
public class CreatePhaseWindow extends ScrollPane {
    
    private static CreatePhaseWindow window = null;
    public CreatePhaseWindow(long projectId) {
        window = this;
        this.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        GridPane gp = new GridPane();
        gp.setMinSize(600, 220);
        
        
        gp.setAlignment(Pos.CENTER);

        this.setContent(gp);
        Main.borderPane.setTop(WeTrackMenuBar.getMenuBar());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //javaFX operations should go here
                SwingNode sn = new SwingNode();
                sn.setContent(new CreatePhaseSwing(projectId));
                gp.getChildren().add(sn);
                Main.borderPane.setCenter(CreatePhaseWindow.window);
            }
        });
    }

    private void save() {
        
    }
}
