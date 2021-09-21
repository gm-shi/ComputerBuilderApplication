package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Build;
import model.Catalogue;
import model.Part;

import java.io.IOException;

public class CatalogueController extends Controller<Catalogue> {
    @FXML private TableView<Part> catalogueTv;
    @FXML private TableColumn<Part, String> priceClm;
    @FXML private Button removeBtn;
    @FXML private Button addBtn;
    @FXML private TextField typeTf;
    @FXML private TextField minTf;
    @FXML private TextField maxTf;

    @FXML public void handleAddNewPart(ActionEvent event) throws Exception{
        ViewLoader.showStage(model, "/view/addtocatalogue.fxml", "Add New Part to Catalogue", new Stage());
    }

    @FXML public void handleClose(ActionEvent event) {
        stage.close();
    }
    public final Catalogue getCatalogue() {
        return model;
    }
    @FXML public void initialize() {
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
        catalogueTv.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                removeBtn.setDisable(newValue == null));
        catalogueTv.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                addBtn.setDisable(newValue == null));


    }

    private Part getSelectedPart() {
        return catalogueTv.getSelectionModel().getSelectedItem();
    }
    @FXML public void handleRemove(ActionEvent event){
        model.remove(getSelectedPart());
    }

    @FXML public void handleAddToBuild(ActionEvent event) {
        model.addToBuild(getSelectedPart());

    }

    @FXML public void handleFilter(ActionEvent event) throws IOException {
        model.filterList(typeTf.getText(), minTf.getText(), maxTf.getText());
    }
}
