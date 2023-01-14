package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ClearInput {

    private TextArea textarea;
    private Label label;
    private String message;

    public ClearInput(TextArea textarea, Label label) {
        this.textarea = textarea;
        this.label = label;
        this.message = "Input field cleared!";
    }

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}

    public void removeText() {
        this.textarea.clear();
        this.label.setText(this.message);
        this.label.setStyle("-fx-text-fill: green;");
    }

}
