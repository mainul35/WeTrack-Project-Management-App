/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Mainul35
 */
import Controller.UserAccessController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.User;
import static view.Main.borderPane;

/**
 *
 * @author Mainul35
 */
public class LogInForm extends GridPane {

    private static LogInForm LoginForm = null;

    private TextField txtEmail;
    private PasswordField password;
    private final Button btnBack;
    private final Button btnLogin;

    private static User currentSessionUser = null;

    private LogInForm() {
        Main.setTop(Main.getTopPane("Log in for WeTrack"));
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(10));
        Label lblEmail = new Label("Email");
        Label lblPassword = new Label("Password");

        password = new PasswordField();
        txtEmail = new TextField();
        btnBack = new Button("Go Back");
        btnLogin = new Button("Log in");

        lblPassword.setPadding(new Insets(5));
        lblPassword.setMinWidth(15);
        lblEmail.setPadding(new Insets(5));
        lblEmail.setMinWidth(15);

        password.setPadding(new Insets(5));
        password.setMinWidth(90);
        txtEmail.setPadding(new Insets(5));
        txtEmail.setMinWidth(90);
        btnLogin.setPadding(new Insets(5));
        btnBack.setMinWidth(170);
        btnLogin.setMinWidth(170);

        this.setAlignment(Pos.CENTER);
        this.add(lblEmail, 2, 3);
        this.add(lblPassword, 2, 4);
        this.add(txtEmail, 3, 3);
        this.add(password, 3, 4);
        this.add(btnLogin, 3, 5);
        this.add(btnBack, 3, 6);

        btnBack.setOnAction(e -> {
            Main.getMainScreen().setCenter(RegisterForm.getRegistrationForm());
            Main.setTop(Main.getTopPane("Sign up for We Track"));
        });

        btnLogin.setOnAction(e -> {
            try {
                if (UserAccessController.getUser(this.txtEmail.getText()).getPassword().equals(this.password.getText())) {
                    currentSessionUser = UserAccessController.getUser(this.txtEmail.getText());
                    WeTrackMenuBar.getMenuBar().prefWidthProperty().bind(Main.getStage().widthProperty());
                    borderPane.setTop(WeTrackMenuBar.getMenuBar());
                    borderPane.setCenter(new WelcomeScreen());
                }else{
                    Main.showMessageDialog(Alert.AlertType.WARNING, "Warning", null, "Email or password missmatched.");
                }
            } catch (NullPointerException ex) {
                Main.showMessageDialog(Alert.AlertType.ERROR, "Error", null, "Sorry, this user was not found in database.");
            }
        });
    }

    public static LogInForm getLoginForm() {
        if (LoginForm == null) {
            synchronized (LogInForm.class) {
                LoginForm = new LogInForm();
            }
            return LoginForm;
        } else {
            return LoginForm;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object readResolve() {
        return LoginForm;
    }

    public static User getCurrentSessionUser() {
        return currentSessionUser;
    }
}
