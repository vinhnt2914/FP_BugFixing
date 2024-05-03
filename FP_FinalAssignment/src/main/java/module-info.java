module com.vinh.fp_finalassignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires jakarta.persistence;

    opens com.vinh.fp_finalassignment to javafx.fxml;
    exports com.vinh.fp_finalassignment;
}