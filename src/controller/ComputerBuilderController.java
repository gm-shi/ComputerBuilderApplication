package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Catalogue;
import model.ComputerBuilder;

public class ComputerBuilderController extends Controller<ComputerBuilder> {

    @FXML private Button viewCatalogueBtn;
    @FXML private Button viewBuildBtn;
    public final ComputerBuilder getComputerBuilder() {
        return model;
    }
    @FXML private void handleViewCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(model.getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }
    @FXML private void handleViewBuild(ActionEvent event) throws Exception {
        ViewLoader.showStage(model.getBuild(), "/view/build.fxml", "Current Build", new Stage());
    }

    @FXML public void handleClose(ActionEvent event) {
        stage.close();
    }

    @FXML public void initialize() {
        viewCatalogueBtn.setText("View\nCatalogue");
        viewBuildBtn.setText("View\nBuild");
    }
}