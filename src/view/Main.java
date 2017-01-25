/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 *
 * @author Mainul35
 */
public class Main extends Application {

    private static boolean loggedIn = false;
    private static Stage stage = null;
    private final static String BANNER_BACKGROUND = "-fx-background-color:#BFF196";
    private final static String LEFT_CONTAINER_BACKGROUND = "-fx-background-color:#4195FF;"
            + "-fx-text-fill:white";
    private final static Font BANNER_FONT = Font.font("Calibri", FontPosture.REGULAR, 24);
    private final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private final static double SCREEN_WIDTH = SCREEN_SIZE.getWidth();
    private final static double SCREEN_HEIGHT = SCREEN_SIZE.getHeight();
    private static Label lblBanner = null;
//    static ExtendedLabel[] lblMEnuItems = null;
    static BorderPane borderPane = new BorderPane();

    public Main() {

    }

    /**
     * @return the loggedIn
     */
    public static boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param aLoggedIn the loggedIn to set
     */
    public static void setLoggedIn(boolean aLoggedIn) {
        loggedIn = aLoggedIn;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.stage = primaryStage;
        Scene scene = new Scene(Main.getMainScreen());
        borderPane.setTop(Main.getTopPane("Sign up for WeTrack"));
        stage.setScene(scene);
        stage.show();
    }

    public static BorderPane getMainScreen() {
        stage.setMinHeight(500);
        stage.setMinWidth(680);
        stage.setMaxHeight(SCREEN_HEIGHT);
        stage.setMaxWidth(SCREEN_WIDTH / 3);
        borderPane.setTop(Main.getTopPane(""));

        if (isLoggedIn() == false) {
            borderPane.setCenter(RegisterForm.getRegistrationForm());
        } else {
            borderPane.setLeft(getLeftPane());
        }
        return borderPane;
    }

    public static void setTop(Pane p) {
        borderPane.setTop(p);
    }

    public static GridPane getTopPane(String bannerText) {
        GridPane topPane = new GridPane();
        lblBanner = new Label();
        lblBanner.setMinWidth(SCREEN_WIDTH / 2);
        lblBanner.setMinHeight(100);
        lblBanner.setStyle(BANNER_BACKGROUND);
        lblBanner.setFont(BANNER_FONT);
        lblBanner.setText(bannerText);
        lblBanner.setAlignment(Pos.CENTER);
        topPane.getChildren().add(lblBanner);
        return topPane;
    }

    public static Stage getStage() {
        return stage;
    }

    public static Pane getLeftPane() {
        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(600);
        gridPane.setMinWidth(220);
        gridPane.setStyle(LEFT_CONTAINER_BACKGROUND);
        return gridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void showMessageDialog(Alert.AlertType alertType, String title, String headerText, String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(alertType);
                alert.setTitle(title);
                alert.setHeaderText(headerText);
                alert.setContentText(message);
                alert.showAndWait();
            }
        });

    }

}
