package controller;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class HashTextActionTask extends Task<Void> {
    private final List<String> listToHash;
    private final String algorithm;
    private final CheckBox cbAddSalt;

    public ObjectProperty<ArrayList> HBoxListProperty = new SimpleObjectProperty<>();
    public ObjectProperty<ArrayList> outHBoxListProperty(){
        return HBoxListProperty;
    }
    public void updateHBoxList(ArrayList HBoxList){
        Platform.runLater(() -> HBoxListProperty.set(HBoxList));
    }

    public HashTextActionTask(List<String> listToHash, String algorithm, CheckBox cbAddSalt) {
        this.listToHash = listToHash;
        this.algorithm = algorithm;
        this.cbAddSalt = cbAddSalt;
    }

    @Override
    protected Void call() throws Exception {

        String inprogressTask = "Hashing in progress. Please wait!";
        updateMessage(inprogressTask);

        // Set salt parameter
        boolean isSalted;
        String isSaltedString;
        if (!this.cbAddSalt.isSelected()) {
            isSalted = false;
            isSaltedString = "Non-Salted: ";
        } else {
            isSalted = true;
            isSaltedString = "Salted:         ";
        }

//        // Set parallelize parameter
//        int nthr;
//        if(this.cbParallelize.isSelected()){
//            nthr = this.th.getNumberOfThreads();
//        } else {
//            nthr = 1;
//        }

        // Set ProgressBar
        double totalsize = this.listToHash.size();

        // Measuring execution time
        StopWatch etime = new StopWatch();
        etime.start();

        ArrayList<HBox> hboxList = new ArrayList<>();
        for (int i = 0; i < this.listToHash.size(); i++) {
            if(isCancelled()){
                System.out.println("Task has been cancelled");
                break;
            }

            String item = FactoryProducer.getFactory(isSalted).getHashType(algorithm).encrypt(new HashInput(this.listToHash.get(i)).inputparser("TXT"));
            if (item == null) {
                System.out.println("Item is null, thus it is skipped!");
            }

            HBox hbox = new HBox(4);

            Label a_label = new Label(algorithm);
            a_label.setStyle("-fx-background-color: #439eb8; -fx-text-fill: #2d2f30; -fx-background-radius: 6,6,6,6; -fx-border-radius: 6;");
            a_label.setPrefWidth(60);
            a_label.setAlignment(Pos.CENTER);
            hbox.getChildren().add(a_label);

            Label ns_label = new Label(isSaltedString);
            ns_label.setStyle("-fx-text-fill: #439eb8; -fx-font-style: italic;");
            hbox.getChildren().add(ns_label);

            Label i_label = new Label(item);
            i_label.setStyle("-fx-text-fill: white;");
            hbox.getChildren().add(i_label);

            Label i_name_label = new Label(this.listToHash.get(i));
            i_name_label.setStyle("-fx-text-fill: grey;");
            hbox.getChildren().add(i_name_label);

            // Return HBox
            //updateValue(hbox);
            hboxList.add(hbox);

            // Return progressbar
            double startp = 0;
            double endp = totalsize;
            if (totalsize == 1){
                startp =1;
                endp = totalsize;
            } else {
                startp = i;
                endp = totalsize-1;
            }
            updateProgress(startp, endp);
        }
        updateHBoxList(hboxList);

        etime.stop();
        long ms = etime.getTotalTimeMillis();
        float sec = ms / 1000.0f;
        String s = String.format("%.5f", sec);
        String measured_time = Long.toString(ms) + "ms " + "[" + s + "sec]";

        updateTitle(measured_time);

        String completedTask = "Hashing successful!";
        updateMessage(completedTask);

        return null;
    }

}
