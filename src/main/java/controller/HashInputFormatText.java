package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.text.Normalizer;

public class HashInputFormatText {

    private String originalWithSpace;
    private String originalMixCase;
    private String originalUnNorm;

    public HashInputFormatText() {
    }

    public String getOriginalWithSpace() {
        return originalWithSpace;
    }

    public void setOriginalWithSpace(String originalWithSpace) {
        this.originalWithSpace = originalWithSpace;
    }

    public String getOriginalMixCase() {
        return originalMixCase;
    }

    public void setOriginalMixCase(String originalMixCase) {
        this.originalMixCase = originalMixCase;
    }

    public String getOriginalUnNorm() {
        return originalUnNorm;
    }

    public void setOriginalUnNorm(String originalUnNorm) {
        this.originalUnNorm = originalUnNorm;
    }

    // Keep original and Remove all white spaces from the input string
    public void remspace(Label lbStatus, TextArea taInput){
        this.originalWithSpace = taInput.getText();
        String spacefree = taInput.getText().replaceAll("\\s", "");

        //System.out.println(spacefree);
        taInput.setText(spacefree);

        lbStatus.setText("Whitespaces removed from input.");
        lbStatus.setStyle("-fx-text-fill: green;");
    }

    // Keep original and Turn input string to lowercase
    public void lowc(Label lbStatus, TextArea taInput){
        this.originalMixCase = taInput.getText();
        String lowerc = taInput.getText().toLowerCase();

        //System.out.println(lowerc);
        taInput.setText(lowerc);

        lbStatus.setText("Input turned to lowercase.");
        lbStatus.setStyle("-fx-text-fill: green;");
    }

    // Normalize text by removing accents and diacritics
    public void norm(Label lbStatus, TextArea taInput){
        this.originalUnNorm = taInput.getText();

        String norm = Normalizer.normalize(taInput.getText(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        taInput.setText(norm);

        lbStatus.setText("Input accents and diacritics removed.");
        lbStatus.setStyle("-fx-text-fill: green;");
    }
}
