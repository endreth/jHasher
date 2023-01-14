package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import view.GUI;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LoadDirInput {

    private TextArea textarea;
    private Label label;
    private final long maxSize;

    public LoadDirInput(TextArea textarea, Label label) {
        this.textarea = textarea;
        this.label = label;
        this.maxSize = (3 * (1024L*1024L*1024L)); // 3 GiB
    }

    public void chooseDir() throws IOException {
        DirectoryChooser dirChooser = new DirectoryChooser();

        dirChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File selectedDirectory = dirChooser.showDialog(GUI.getpStage());
        if (selectedDirectory != null) {
            String content = selectedDirectory.getAbsolutePath();

            // Get the size of the directory in MB
            FileSizeChecker fsc = new FileSizeChecker();
            String size = fsc.getSizeString(selectedDirectory);

            this.textarea.setText(content+"\t"+size);

            // List files in the directory
            for (File f: Objects.requireNonNull(selectedDirectory.listFiles())) {
                if(f.isFile()){

                    long realSize = f.length();
                    if(realSize < maxSize){

                        this.textarea.appendText("\n"+"\t"+f.getAbsolutePath());

                    }
                }
            }

            this.label.setText("Input directory loaded!");
            this.label.setStyle("-fx-text-fill: green;");
        }
    }

}
