package org.danielsa.proiect_ps.presenters;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.Getter;
import org.danielsa.proiect_ps.models.LoginModel;
import org.danielsa.proiect_ps.models.LoginModelInterface;
import org.danielsa.proiect_ps.views.*;

@Getter
public class LoginPresenter {
    private final LoginViewInterface view;
    private final LoginModelInterface model;

    public LoginPresenter(LoginView view) {
        this.view = view;
        model = new LoginModel(view.getDatabaseService());
    }

    @SuppressWarnings("CastCanBeRemovedNarrowingVariableType")
    public void openRegisterWindow() {
        RegisterViewInterface view = new RegisterView(model.getDatabaseService());
        Stage registerStage = new Stage();

        registerStage.setScene((RegisterView) view);
        registerStage.setTitle("Register");
        registerStage.show();
    }

    @SuppressWarnings("CastCanBeRemovedNarrowingVariableType")
    public void showLoginResult(Label resultLabel, boolean success) {
        if (success) {
            GameViewInterface view = new GameView(model.getDatabaseService());
            Stage gameStage = new Stage();

            gameStage.setScene((GameView) view);
            gameStage.setTitle("Arrow Game");
            gameStage.show();
        } else {
            resultLabel.setText("Login failed. Please try again.");
        }
    }

    public boolean authenticate(String username, String password) {
        return model.authenticate(username, password);
    }
}
