module com.github.belivipro9x99.studentsmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.belivipro9x99.studentsmanager to javafx.fxml;
    exports com.github.belivipro9x99.studentsmanager;

    opens com.github.belivipro9x99.studentsmanager.Controllers to javafx.fxml;
    exports com.github.belivipro9x99.studentsmanager.Controllers;
}
