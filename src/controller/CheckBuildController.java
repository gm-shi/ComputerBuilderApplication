package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Build;

public class CheckBuildController extends Controller<Build> {
    @FXML private Text compeletTxt;

    @FXML public void handleOK(ActionEvent event) {
        stage.close();
    }
    public Build getBuild() {
        return model;
    }

    public void setText(String sentence) {
        compeletTxt.setText(sentence);
    }
    @FXML public void initialize() {
        String message = "";
        if(model.isValid())
            message += "The build is valid.";
        else {
            if(!(model.hasPartOfType("cpu")))
                message += "The build is missing a CPU.\n";
            if(!(model.hasPartOfType("motherboard")))
                message += "The build is missing a motherboard.\n";
            if(!(model.hasPartOfType("memory")))
                message += "The build is missing RAM.\n";
            if(!(model.hasPartOfType("case")))
                message += "The build is missing a case.\n";
            if(!(model.hasPartOfType("storage")))
                message += "The build is missing a storage.\n";
        }
        setText(message);
    }
}
