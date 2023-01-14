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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HashCompFileActionTask extends Task<HBox> {

    private List<String> listToHash_A;
    private List<String> listToHash_B;
    private final String algorithm;
    private final CheckBox cbAddSalt_cf;
    public ObjectProperty<HBox> hbox1Property;
    public ObjectProperty<HBox> hbox2Property;

    public HashCompFileActionTask(List<String> listToHash_A, List<String> listToHash_B, String algorithm, CheckBox cbAddSalt_cf) {
        this.listToHash_A = listToHash_A;
        this.listToHash_B = listToHash_B;
        this.algorithm = algorithm;
        this.cbAddSalt_cf = cbAddSalt_cf;
        this.hbox1Property = new SimpleObjectProperty<>();
        this.hbox2Property = new SimpleObjectProperty<>();
    }

/*    public List<String> getListToHash_A() {
        return this.listToHash_A;
    }
    public List<String> getListToHash_B() {
        return this.listToHash_B;
    }
    public ObjectProperty<HBox> outProperty1(){
        return hbox1Property;
    }
    public ObjectProperty<HBox> outProperty2(){
        return hbox2Property;
    }
    public void updateHBox1(HBox hbox1) {
        //hbox1Property.set(hbox1);
        Platform.runLater(() -> hbox1Property.set(hbox1));
    }
    public void updateHBox2(HBox hbox2) {
        //hbox2Property.set(hbox2);
        Platform.runLater(() -> hbox2Property.set(hbox2));
    }*/
    public ObjectProperty<ArrayList> HBoxList1Property = new SimpleObjectProperty<>();
    public ObjectProperty<ArrayList> outHBoxList1Property(){
        return HBoxList1Property;
    }
    public void updateHBoxList1(ArrayList HBoxList1){
        Platform.runLater(() -> HBoxList1Property.set(HBoxList1));
    }
    public ObjectProperty<ArrayList> HBoxList2Property = new SimpleObjectProperty<>();
    public ObjectProperty<ArrayList> outHBoxList2Property(){
        return HBoxList2Property;
    }
    public void updateHBoxList2(ArrayList HBoxList2){
        Platform.runLater(() -> HBoxList2Property.set(HBoxList2));
    }

    @Override
    protected HBox call() throws Exception {

        String inprogressTask = "Hashing in progress. Please wait!";
        updateMessage(inprogressTask);

        // Set salt parameter
        boolean isSalted;
        String isSaltedString;
        if (!this.cbAddSalt_cf.isSelected()) {
            isSalted = false;
            isSaltedString = "Non-Salted: ";
        } else {
            isSalted = true;
            isSaltedString = "Salted:         ";
        }

        // Set ProgressBar
        double endp = this.listToHash_A.size() + this.listToHash_B.size();
        double startp = 0;

        // Measuring execution time
        StopWatch etime = new StopWatch();
        etime.start();

        // Return list A
        ArrayList<HBox> hboxList1 = new ArrayList<>();
        for (int i = 0; i < this.listToHash_A.size(); i++) {
            if(isCancelled()){break;}
            String item = FactoryProducer.getFactory(isSalted).getHashType(this.algorithm).encrypt(new HashInput(this.listToHash_A.get(i)).inputparser("FILE"));

            HBox hbox1 = new HBox(4);

            Label a_label = new Label(algorithm);
            a_label.setStyle("-fx-background-color: #439eb8; -fx-text-fill: #2d2f30; -fx-background-radius: 6,6,6,6; -fx-border-radius: 6;");
            a_label.setPrefWidth(60);
            a_label.setAlignment(Pos.CENTER);
            hbox1.getChildren().add(a_label);

            Label ns_label = new Label(isSaltedString);
            ns_label.setStyle("-fx-text-fill: #439eb8; -fx-font-style: italic;");
            hbox1.getChildren().add(ns_label);

            Label i_label = new Label(item);
            i_label.setStyle("-fx-text-fill: white;");
            hbox1.getChildren().add(i_label);

            Label i_name_label = new Label(new File(this.listToHash_A.get(i)).getName());
            i_name_label.setStyle("-fx-text-fill: grey;");
            hbox1.getChildren().add(i_name_label);

            // Return HBox
            hboxList1.add(hbox1);

            // Return progressbar
            updateProgress(startp, endp-1);
            startp++;
        }

        // Return list B
        ArrayList<HBox> hboxList2 = new ArrayList<>();
        for (int i = 0; i < this.listToHash_A.size(); i++) {
            if(isCancelled()){break;}
            String item = FactoryProducer.getFactory(isSalted).getHashType(this.algorithm).encrypt(new HashInput(this.listToHash_B.get(i)).inputparser("FILE"));

            HBox hbox2 = new HBox(4);

            Label a_label = new Label(algorithm);
            a_label.setStyle("-fx-background-color: #439eb8; -fx-text-fill: #2d2f30; -fx-background-radius: 6,6,6,6; -fx-border-radius: 6;");
            a_label.setPrefWidth(60);
            a_label.setAlignment(Pos.CENTER);
            hbox2.getChildren().add(a_label);

            Label ns_label = new Label(isSaltedString);
            ns_label.setStyle("-fx-text-fill: #439eb8; -fx-font-style: italic;");
            hbox2.getChildren().add(ns_label);

            Label i_label = new Label(item);
            i_label.setStyle("-fx-text-fill: white;");
            hbox2.getChildren().add(i_label);

            Label i_name_label = new Label(new File(this.listToHash_B.get(i)).getName());
            i_name_label.setStyle("-fx-text-fill: grey;");
            hbox2.getChildren().add(i_name_label);

            // Return HBox
            hboxList2.add(hbox2);

            // Return progressbar
            startp++;
            updateProgress(startp, endp);

        }

        // Color hboxList1 and 2, then update
        for (int i = 0; i < hboxList1.size(); i++){
            for (int n = 0; n < hboxList2.size(); n++){
                HBox hbox1 = hboxList1.get(i);
                HBox hbox2 = hboxList2.get(n);
                Label label1 = (Label) hbox1.getChildren().get(2);
                Label label2 = (Label) hbox2.getChildren().get(2);
                if (!label1.getText().equals(label2.getText())) {
                    // Color the unmatching labels green
                    label1.setStyle("-fx-background-color: green");
                    label2.setStyle("-fx-background-color: green");
                } else {
                    // Color matching labels red
                    label1.setStyle("-fx-background-color: red");
                    label2.setStyle("-fx-background-color: red");
                }
            }
        }
        updateHBoxList1(hboxList1);
        updateHBoxList2(hboxList2);

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


