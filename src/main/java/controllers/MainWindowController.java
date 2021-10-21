package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    private ComboBox tFor;
    @FXML
    private ComboBox tOwner;
    @FXML
    private ComboBox tExecutor;
    @FXML
    private ComboBox tSupervisor;
    public DatePicker tStartDate;
    public DatePicker tEndDate;
    @FXML
    private Spinner tNumber;
    @FXML
    public ComboBox tEndTime;
    @FXML
    public ComboBox tStartTime;
    @FXML
    private Button tCreateButton;
    @FXML
    private TextArea tDescription;
    @FXML
    public CheckBox tToday;
    private static Integer taskNumberInitValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskNumberInitValue = 2;
        initializetNumber(taskNumberInitValue);
        checkParamsOnStart();
        initializetNumber(taskNumberInitValue);
    }

    @FXML
    public void tTodayActionClicked(MouseEvent mouseEvent) {
        setDateFieldsEnabled(!tToday.isSelected());
    }

    private void checkParamsOnStart() {
        setDateFieldsEnabled(false);
        fillTimeFields();
    }

    private void fillTimeFields() {
        tStartTime.setItems(setTimeList());
        tEndTime.setItems(setTimeList());
        tStartTime.setValue("08:00");
        tEndTime.setValue("17:00");
    }

    private ObservableList<String> setTimeList() {
        ObservableList<String> tempList = FXCollections.observableArrayList();
        for (int i = 8; i < 25; i++) {
            if (i < 10) {
                tempList.add("0" + i + ":00");
                if (i < 24) tempList.add("0" + i + ":30");
            } else {
                if (i == 24) tempList.add("00:00"); else tempList.add(i + ":00");
                if (i < 24) tempList.add(i + ":30");
            }
        }
        return tempList;
    }

    private void setDateFieldsEnabled(boolean enableValue) {
           if (!enableValue) {
               tStartDate.setDisable(true);
               tEndDate.setDisable(true);
               tStartDate.setValue(LocalDate.now());
               tEndDate.setValue(LocalDate.now());
           } else {
               tStartDate.setDisable(false);
               tEndDate.setDisable(false);
               tStartDate.setValue(null);
               tEndDate.setValue(null);
           }
    }

    private void initializetNumber(Integer initValue) {
        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,
                10000, initValue);
        tNumber.setValueFactory(svf);
    }


}
