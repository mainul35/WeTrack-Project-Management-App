/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.ProjectController;
import Controller.UserAccessController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.User;

/**
 *
 * @author Mainul35
 */
public class RegisterForm extends GridPane {

    private static RegisterForm registerForm = null;

    private final TextField txtName;
    private final TextField txtEmail;
    private final PasswordField password;
    private final Button btnAddUser;
    private final Button btnLogin;

    RegisterForm() {
        Main.setTop(Main.getTopPane("Sign up for We Track"));
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(10));
        Label lblName = new Label("Name");
        Label lblEmail = new Label("Email");
        Label lblPassword = new Label("Password");
        Label lblOr = new Label("Or");

        password = new PasswordField();
        txtEmail = new TextField();
        txtName = new TextField();
        btnAddUser = new Button("Sign up");
        btnLogin = new Button("Log in");

        lblPassword.setPadding(new Insets(5));
        lblPassword.setMinWidth(15);
        lblName.setPadding(new Insets(5));
        lblName.setMinWidth(15);
        lblEmail.setPadding(new Insets(5));
        lblEmail.setMinWidth(15);
        lblOr.setMinWidth(15);
        txtName.setPadding(new Insets(5));
        txtName.setMinWidth(80);
        password.setPadding(new Insets(5));
        password.setMinWidth(90);
        txtEmail.setPadding(new Insets(5));
        txtEmail.setMinWidth(90);
        btnLogin.setPadding(new Insets(5));
        btnAddUser.setMinWidth(170);
        btnLogin.setMinWidth(170);

        this.setAlignment(Pos.CENTER);
        this.add(lblName, 2, 2);
        this.add(lblEmail, 2, 3);
        this.add(lblPassword, 2, 4);
        this.add(lblOr, 2, 6);
        this.add(txtName, 3, 2);
        this.add(txtEmail, 3, 3);
        this.add(password, 3, 4);
        this.add(btnAddUser, 3, 5);
        this.add(btnLogin, 3, 6);

        btnAddUser.setOnAction(e -> {
            User user = new User();
            user.setName(this.txtName.getText());
            user.setEmail(this.txtEmail.getText());
            user.setPassword(this.password.getText());
            user.setAvailabilityDuration(7);
            if (UserAccessController.userExists(this.txtEmail.getText())) {
                Main.showMessageDialog(Alert.AlertType.INFORMATION, "Information", "Ops...!", "This email is already registered!");
            } else {
                if(txtName.getText().isEmpty() || txtEmail.getText().isEmpty() || password.getText().isEmpty()){
                    Main.showMessageDialog(Alert.AlertType.WARNING, "Warning", "One or more empty field found.", "No fields can be left empty.");
                }
                else if (UserAccessController.register(user) == true) {
                Main.showMessageDialog(Alert.AlertType.CONFIRMATION, "Success", null, "Congrats, a user account has been created with your email.");
                }
            }
            });

            btnLogin.setOnAction(e -> {
                Main.getMainScreen().setCenter(LogInForm.getLoginForm());
                Main.setTop(Main.getTopPane("Log in for We Track"));
            });
        }

    public static RegisterForm getRegistrationForm() {
        if (registerForm == null) {
            synchronized (RegisterForm.class) {
                registerForm = new RegisterForm();
            }
            return registerForm;
        } else {
            return registerForm;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object readResolve() {
        return registerForm;
    }
}
