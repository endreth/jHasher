package controller;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ClearOutput {

    private ListView listview;
    private Label label;
    private String message;

    public ClearOutput(ListView listview, Label label) {
        this.listview = listview;
        this.label = label;
        this.message = "Output field cleared!";
    }

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public void removeText() {
        this.listview.getItems().clear();
        this.label.setText(this.message);
        this.label.setStyle("-fx-text-fill: green;");
    }

}
