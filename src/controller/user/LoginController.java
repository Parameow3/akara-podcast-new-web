package controller.user;

import controller.main.MainFormController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private BorderPane loginPane;

    @FXML
    private Button loginButton;

    @FXML
    private TextField tf_Email;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_showPassword;

    @FXML
    private CheckBox checkToShowPassword;

    @FXML
    private Label alertLabel;

    @FXML
    private Button button_forget_password;

    @FXML
    public void loginClicked(MouseEvent event) throws IOException {
        loginPane.setTop(null);
        BorderPane profile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/user/Profile.fxml")));
        loginPane.setCenter(profile);

        // check theme for user
//        if (!DbUtils.isRetrievedTheme()) {
//            MainFormController.setDarkMode();
//        } else {
//            MainFormController.setLightMode();
//        }
    }

    @FXML
    public void signUpClicked(MouseEvent event) throws IOException {
        loginPane.setTop(null);
        BorderPane profile = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/user/SignUp.fxml")));
        loginPane.setCenter(profile);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                DbUtils.logInUser(event, alertLabel, tf_Email.getText(), pf_password.getText());
            }
        });

        // show passwords
        pf_password.textProperty().bindBidirectional(tf_showPassword.textProperty());
        checkToShowPassword.setSelected(false);

        checkToShowPassword.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                tf_showPassword.toFront();
            } else {
                pf_password.toFront();
            }
        });
    }


    //#region FORGOT_BTN
    @FXML
    public void forgotClicked(MouseEvent mouseEvent) throws IOException {
        loginPane.setTop(null);
        BorderPane forget = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/user/Forget.fxml")));
        loginPane.setCenter(forget);
    }

    @FXML
    public void underLine(MouseEvent mouseEvent) {
        button_forget_password.setUnderline(true);
    }

    @FXML
    public void removeUnderLine(MouseEvent mouseEvent) {
        button_forget_password.setUnderline(false);
    }

    //#endregion
}
