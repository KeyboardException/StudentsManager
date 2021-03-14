package com.github.belivipro9x99.studentsmanager.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.github.belivipro9x99.studentsmanager.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("app");
    }
}