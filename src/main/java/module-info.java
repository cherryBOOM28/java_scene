module com.example.myfirstapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.myfirstapp to javafx.fxml;
    exports com.example.myfirstapp;
}