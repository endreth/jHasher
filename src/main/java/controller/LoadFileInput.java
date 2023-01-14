package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import view.GUI;

import java.io.File;
import java.io.IOException;

public class LoadFileInput {

    private TextArea textarea;
    private Label label;
    private String message;
    private final long maxSize;

    public LoadFileInput(TextArea textarea, Label label) {
        this.textarea = textarea;
        this.label = label;
        this.message = "Input file loaded!";
        this.maxSize = (3 * (1024L*1024L*1024L)); // 3 GiB
    }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public void chooseFile() throws IOException {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File selectedFile = fileChooser.showOpenDialog(GUI.getpStage());
        if (selectedFile != null) {
            String content = selectedFile.getAbsolutePath();

            // Get the size of the file in MB
            FileSizeChecker fsc = new FileSizeChecker();
            String size = fsc.getSizeString(selectedFile);
            long realSize = selectedFile.length();

            if(realSize < maxSize){

                this.textarea.setText(content+"\t"+size);

                this.label.setText(this.message);
                this.label.setStyle("-fx-text-fill: green;");

            }

        }
    }
}
