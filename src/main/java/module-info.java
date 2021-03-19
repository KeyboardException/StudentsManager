module com.github.belivipro9x99.studentsmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.belivipro9x99.studentsmanager to javafx.fxml;

    opens com.github.belivipro9x99.studentsmanager.Controllers
        to  com.github.belivipro9x99.studentsmanager.Objects,
            javafx.fxml,
            javafx.controls;

    opens com.github.belivipro9x99.studentsmanager.Objects to javafx.base;

    exports com.github.belivipro9x99.studentsmanager;
    exports com.github.belivipro9x99.studentsmanager.Controllers;
    exports com.github.belivipro9x99.studentsmanager.Objects;
}
