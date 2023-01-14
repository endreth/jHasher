package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;
import view.GUI;

import java.io.File;
import java.io.IOException;

public class LoadTextInput {

    private TextArea textarea;
    private Label label;

    public LoadTextInput(TextArea textarea, Label label) {
        this.textarea = textarea;
        this.label = label;
    }

    public void chooseFile() throws IOException {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setInitialFileName("myfile.txt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
                /*new FileChooser.ExtensionFilter("PDF Files", "*.pdf") for later improvement,*/
                );

        //Stage stage = (Stage) GUI. getScene().getWindow();

        File selectedFile = fileChooser.showOpenDialog(GUI.getpStage());

        if (selectedFile != null) {
            String content = FileUtils.readFileToString(selectedFile, "UTF-8");

            // Keep only 5000 characters.
            if (content.length() > 5000) {
                content = content.substring(0, 5000);
            }

            this.textarea.setText(content);
            this.label.setText("Input file loaded!");
            this.label.setStyle("-fx-text-fill: green;");
        }
    }
}
