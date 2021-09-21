package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Catalogue;

import java.io.IOException;


public class AddToCatalogueController extends Controller<Catalogue> {
    @FXML private TextField typeTf;
    @FXML private TextField nameTf;
    @FXML private TextField priceTf;

    private String getType() {
        return typeTf.getText();
    }
    private String getName() {
        return nameTf.getText();
    }
    private double getPrice() {
        return Double.parseDouble(priceTf.getText());
    }

    //not completed
    @FXML public void handleAdd(ActionEvent event) throws IOException {
        try {
            model.addPart(getName(), getType(), getPrice());
        } catch (Exception e) {
            ViewLoader.showStage(e, "/view/error.fxml", "Incorrect Input", new Stage());
        }
        stage.close();
    }
}
