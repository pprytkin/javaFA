package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class HelloController {
    @FXML
    private Label resText;

    @FXML
    private DatePicker datePicker;

    @FXML
    protected void onHelloButtonClick() {
        LocalDate localDate = datePicker.getValue();
        WeekFields weekFields = WeekFields.of(Locale.US);
        int weekNumber = localDate.get(weekFields.weekOfWeekBasedYear());
        resText.setText(Integer.toString(weekNumber));
    }
}