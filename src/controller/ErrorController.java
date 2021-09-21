package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ErrorController extends Controller<Exception> {
    @FXML private Button okayBtn;
    public final Exception getException() {
        return model;
    }

    @FXML public void handleOk(ActionEvent event) {
        stage.close();
    }
}
