package com.github.belivipro9x99.studentsmanager.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import com.github.belivipro9x99.studentsmanager.App;

public class MainController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}