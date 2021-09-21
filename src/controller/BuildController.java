package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Build;
import model.Part;

import java.text.DecimalFormat;


public class BuildController extends Controller<Build> {
    @FXML private TableView<Part> buildTv;
    @FXML private TableColumn<Part, String> priceClm;
    @FXML private Text totalTxt;
    @FXML private Button removeBtn;
    public final Build getBuild() {
        return model;
    }
    @FXML public void handleClose(ActionEvent event) {
        stage.close();
    }
    @FXML private void initialize() {
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
        buildTv.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> removeBtn.setDisable(newValue == null));
        totalTxt.textProperty().bind(model.totalProperty().asString("$%.2f"));
    }
    private Part getSelectedPart() {
        return buildTv.getSelectionModel().getSelectedItem();
    }
    @FXML public void handleRemove(ActionEvent event) {
        model.remove(getSelectedPart());
    }

    @FXML public void handleCheck(ActionEvent event) throws Exception{
        ViewLoader.showStage(model, "/view/buildcheck.fxml", "Build Validity Status", new Stage());
    }
}
