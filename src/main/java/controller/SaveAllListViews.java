package controller;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveAllListViews {

    public SaveAllListViews() {

    }

    public void SaveAllListViews(List<ListView<HBox>> listViews) {

        try {
            // Create a FileChooser to let the user choose the output location
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Outputs Content");
            fileChooser.setInitialFileName("output.csv");
            File file = fileChooser.showSaveDialog(null);

//            // Write the content of each ListView to the file
//            if (file != null) {
//                FileWriter fileWriter = new FileWriter(file);
//                for (ListView listView : listViews) {
//                    ObservableList items = listView.getItems();
//                    if (!items.isEmpty()) {
//                        for (Object item : items) {
//                            fileWriter.write(item.toString());
//                            fileWriter.write(",");
//                        }
//                        fileWriter.write("\n");
//                    }
//                }
//                fileWriter.close();
//            }

            if (file != null) {
                FileWriter fileWriter = new FileWriter(file);

                for (int i = 0; i < listViews.size(); i++) {
                    // Get the output of each tab Output listview
                    ObservableList<HBox> items = listViews.get(i).getItems();

                    if(i == 0){

                        fileWriter.write("--- Text hashing output ---");
                        fileWriter.write("\n");
                        if (!items.isEmpty()) {

                            for (int j = 0; j < items.size(); j++) {
                                HBox hbox = items.get(j);

                                ObservableList<Node> children = hbox.getChildren();
                                for (Node child: children) {
                                    if (child instanceof Label) {
                                        Label label = (Label) child;
                                        fileWriter.write(label.getText());
                                        fileWriter.write(";");
                                    }
                                }
                                fileWriter.write("\n");
                            }
                            fileWriter.write("\n");
                        }

                    } else if (i == 1) {

                        fileWriter.write("--- File hashing output ---");
                        fileWriter.write("\n");
                        if (!items.isEmpty()) {

                            for (int j = 0; j < items.size(); j++) {
                                HBox hbox = items.get(j);

                                ObservableList<Node> children = hbox.getChildren();
                                for (Node child: children) {
                                    if (child instanceof Label) {
                                        Label label = (Label) child;
                                        fileWriter.write(label.getText());
                                        fileWriter.write(";");
                                    }
                                }
                                fileWriter.write("\n");
                            }
                            fileWriter.write("\n");
                        }

                    } else if (i == 2) {

                        fileWriter.write("--- Directory hashing output ---");
                        fileWriter.write("\n");
                        if (!items.isEmpty()) {

                            for (int j = 0; j < items.size(); j++) {
                                HBox hbox = items.get(j);

                                ObservableList<Node> children = hbox.getChildren();
                                for (Node child: children) {
                                    if (child instanceof Label) {
                                        Label label = (Label) child;
                                        fileWriter.write(label.getText());
                                        fileWriter.write(";");
                                    }
                                }
                                fileWriter.write("\n");
                            }
                            fileWriter.write("\n");
                        }

                    } else if (i == 3) {

                        fileWriter.write("--- Multi File hashing output ---");
                        fileWriter.write("\n");
                        if (!items.isEmpty()) {

                            for (int j = 0; j < items.size(); j++) {
                                HBox hbox = items.get(j);

                                ObservableList<Node> children = hbox.getChildren();
                                for (Node child: children) {
                                    if (child instanceof Label) {
                                        Label label = (Label) child;
                                        fileWriter.write(label.getText());
                                        fileWriter.write(";");
                                    }
                                }
                                fileWriter.write("\n");
                            }
                            fileWriter.write("\n");
                        }

                    } else if (i == 4) {

                        fileWriter.write("--- Compare Files hashing output [Input A] ---");
                        fileWriter.write("\n");
                        if (!items.isEmpty()) {

                            for (int j = 0; j < items.size(); j++) {
                                HBox hbox = items.get(j);

                                ObservableList<Node> children = hbox.getChildren();
                                for (Node child: children) {
                                    if (child instanceof Label) {
                                        Label label = (Label) child;
                                        fileWriter.write(label.getText());
                                        fileWriter.write(";");
                                    }
                                }
                                fileWriter.write("\n");
                            }
                            fileWriter.write("\n");
                        }

                    } else if (i == 5) {

                        fileWriter.write("--- Compare Files hashing output [Input B] ---");
                        fileWriter.write("\n");
                        if (!items.isEmpty()) {

                            for (int j = 0; j < items.size(); j++) {
                                HBox hbox = items.get(j);

                                ObservableList<Node> children = hbox.getChildren();
                                for (Node child: children) {
                                    if (child instanceof Label) {
                                        Label label = (Label) child;
                                        fileWriter.write(label.getText());
                                        fileWriter.write(";");
                                    }
                                }
                                fileWriter.write("\n");
                            }
                            fileWriter.write("\n");
                        }

                    } else if (i == 6) {

                        fileWriter.write("--- Compare Directory hashing output [Input A] ---");
                        fileWriter.write("\n");
                        if (!items.isEmpty()) {

                            for (int j = 0; j < items.size(); j++) {
                                HBox hbox = items.get(j);

                                ObservableList<Node> children = hbox.getChildren();
                                for (Node child: children) {
                                    if (child instanceof Label) {
                                        Label label = (Label) child;
                                        fileWriter.write(label.getText());
                                        fileWriter.write(";");
                                    }
                                }
                                fileWriter.write("\n");
                            }
                            fileWriter.write("\n");
                        }

                    } else if (i == 7) {

                        fileWriter.write("--- Compare Directory hashing output [Input B] ---");
                        fileWriter.write("\n");
                        if (!items.isEmpty()) {

                            for (int j = 0; j < items.size(); j++) {
                                HBox hbox = items.get(j);

                                ObservableList<Node> children = hbox.getChildren();
                                for (Node child: children) {
                                    if (child instanceof Label) {
                                        Label label = (Label) child;
                                        fileWriter.write(label.getText());
                                        fileWriter.write(";");
                                    }
                                }
                                fileWriter.write("\n");
                            }
                            fileWriter.write("\n");
                        }

                    }

                }
                fileWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
