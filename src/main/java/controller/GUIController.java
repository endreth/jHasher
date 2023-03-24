package controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.*;


public class GUIController {

    public Label lbCPUload;
	public Label lbMEMORYload;
	public Label lbStatus;
	public Label lbExTime;
	public Label lbInfoBar;
	public ProgressBar pBar;
	private SystemLoadCPU slc;
	private SystemLoadMEM slm;
	private HashInputFormatText hif;
	private HashTextActionTask htat;
	private HashFileActionTask hfat;
	private HashDirActionTask hdat;
	private HashMultiFileActionTask hmfat;
	private HashCompFileActionTask hcfat;
	private HashCompDirActionTask hcdat;
	public MenuItem MenuItemSave;
	public MenuItem MenuItemClose;
	public MenuItem MenuItemManual;
	public MenuItem MenuItemAbout;
	// On Text tab
    public ComboBox<String> cbAlgorithms;
	public CheckBox cbAddPepper;
	public CheckBox cbAddSalt;
	public CheckBox cbParallelize;
	public CheckBox cbLowercase;
	public CheckBox cbRemSpaces;
	public CheckBox cbNormalize;
	public CheckBox cbLineByLine;
	public VBox vboxAlgorithm;
	public VBox vboxInputOptions;
	public VBox vboxInputOptions2;
	public Button btnLoadFile;
	public Button btnHash;
	public Button btnClearInput;
	public Button btnClearOutput;
	public TextArea taInput;
	public TextField tfSeparator;
	public ListView<HBox> lvOutput;
	// On File tab
	public VBox vboxAlgorithm_f;
	public ComboBox<String> cbAlgorithms_f;
	public CheckBox cbAddSalt_f;
	public CheckBox cbAddPepper_f;
	public CheckBox cbParallelize_f;
	public VBox vboxInputOptions2_f;
	public Button btnLoadFile_f;
	public Button btnClearInput_f;
	public Button btnClearOutput_f;
	public TextArea taInput_f;
	public ListView<HBox> lvOutput_f;
	public Button btnHash_f;
	// On Dir tab
	public VBox vboxAlgorithm_d;
	public ComboBox<String> cbAlgorithms_d;
	public CheckBox cbAddSalt_d;
	public CheckBox cbAddPepper_d;
	public CheckBox cbParallelize_d;
	public VBox vboxInputOptions2_d;
	public Button btnLoadDir_d;
	public Button btnClearInput_d;
	public Button btnClearOutput_d;
	public Button btnHash_d;
	public TextArea taInput_d;
	public ListView<HBox> lvOutput_d;
	// On MultiFile tab
	public VBox vboxAlgorithm_mf;
	public ComboBox<String> cbAlgorithms_mf;
	public CheckBox cbAddSalt_mf;
	public CheckBox cbAddPepper_mf;
	public CheckBox cbParallelize_mf;
	public VBox vboxInputOptions2_mf;
	public Button btnLoadDir_mf;
	public Button btnClearInput_mf;
	public Button btnClearOutput_mf;
	public TextArea taInput_mf;
	public ListView<HBox> lvOutput_mf;
	public Button btnHash_mf;
	// On CompFile tab
	public VBox vboxAlgorithm_cf;
	public ComboBox<String> cbAlgorithms_cf;
	public CheckBox cbAddSalt_cf;
	public CheckBox cbAddPepper_cf;
	public CheckBox cbParallelize_cf;
	public VBox vboxInputOptions2_A_cf;
	public Button btnLoadFile_A_cf;
	public Button btnClearInput_A_cf;
	public Button btnClearOutput_A_cf;
	public VBox vboxInputOptions2_B_cf;
	public Button btnLoadFile_B_cf;
	public Button btnClearInput_B_cf;
	public Button btnClearOutput_B_cf;
	public Button btnHash_cf;
	public TextArea taInput_A_cf;
	public ListView<HBox> lvOutput_A_cf;
	public TextArea taInput_B_cf;
	public ListView<HBox> lvOutput_B_cf;
	public ArrayList<HBox> compFileList_A;
	public ArrayList<HBox> compFileList_B;
	// On CompDir tab
	public VBox vboxAlgorithm_cd;
	public ComboBox<String> cbAlgorithms_cd;
	public CheckBox cbAddSalt_cd;
	public CheckBox cbAddPepper_cd;
	public CheckBox cbParallelize_cd;
	public VBox vboxInputOptions2_A_cd;
	public Button btnLoadFile_A_cd;
	public Button btnClearInput_A_cd;
	public Button btnClearOutput_A_cd;
	public VBox vboxInputOptions2_B_cd;
	public Button btnLoadFile_B_cd;
	public Button btnClearInput_B_cd;
	public Button btnClearOutput_B_cd;
	public Button btnHash_cd;
	public TextArea taInput_A_cd;
	public ListView<HBox> lvOutput_A_cd;
	public TextArea taInput_B_cd;
	public ListView<HBox> lvOutput_B_cd;
	public ArrayList<HBox> compDirList_A;
	public ArrayList<HBox> compDirList_B;

	public GUIController(){

	}

	@FXML
	public void initialize(){
		this.slc = new SystemLoadCPU(lbCPUload);
		this.slc.start();
		this.slm = new SystemLoadMEM(lbMEMORYload);
		this.slm.start();
		// On Text tab
		this.vboxAlgorithm.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions2.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.btnHash.setStyle("-fx-background-color: #439eb8;" +
				"-fx-text-fill: #2d2f30");
		this.lbInfoBar.setStyle("-fx-text-fill: #439eb8;");
		// Limit textarea to 5000 characters
		int MAX_CHARS = 5000 ;
		this.taInput.setTextFormatter(new TextFormatter<String>(change ->
				change.getControlNewText().length() <= MAX_CHARS ? change : null));
		// On File tab
		this.vboxAlgorithm_f.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions2_f.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.btnHash_f.setStyle("-fx-background-color: #439eb8;" +
				"-fx-text-fill: #2d2f30");
		// On Dir tab
		this.vboxAlgorithm_d.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions2_d.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.btnHash_d.setStyle("-fx-background-color: #439eb8;" +
				"-fx-text-fill: #2d2f30");
		// On MultiFile tab
		this.vboxAlgorithm_mf.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions2_mf.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.btnHash_mf.setStyle("-fx-background-color: #439eb8;" +
				"-fx-text-fill: #2d2f30");
		// On CompFile tab
		this.compFileList_A = new ArrayList<>();
		this.compFileList_B = new ArrayList<>();
		this.vboxAlgorithm_cf.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions2_A_cf.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions2_B_cf.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.btnHash_cf.setStyle("-fx-background-color: #439eb8;" +
				"-fx-text-fill: #2d2f30");
		// On CompDir tab
		this.compDirList_A = new ArrayList<>();
		this.compDirList_B = new ArrayList<>();
		this.vboxAlgorithm_cd.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions2_A_cd.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.vboxInputOptions2_B_cd.setStyle("-fx-border-color: #bbbbbb;" +
				"-fx-border-width: 0.5;" +
				"-fx-border-style: solid;" +
				"-fx-border-radius: 6;");
		this.btnHash_cd.setStyle("-fx-background-color: #439eb8;" +
				"-fx-text-fill: #2d2f30");

		// Password hashing examples:
		// Argon2,bcrypt,bcrypt-SHA256,scrypt,PBKDF2 (Password-Based Key Derivation Function 2),Argon2i,Argon2id

		// File hashing examples:
		// MD5 (Message-Digest Algorithm 5), SHA-1 (Secure Hash Algorithm 1), SHA-2 (includes SHA-224, SHA-256, SHA-384, and SHA-512),
		// SHA-3 (includes SHA3-224, SHA3-256, SHA3-384, and SHA3-512) another name is Keccak, BLAKE2, Tiger, Whirlpool

		String[] passwHashes = {
				"SHA-1","SHA-224","SHA-256","SHA-384","SHA-512",	//with and without salt
				"SHA3-224","SHA3-256","SHA3-384","SHA3-512",		//with and without salt
				"MD2","MD5",										//with and without salt
				"TIGER","Blake2b","Blake3",							//with and without salt
				"Argon2id","PBKDF2","BCrypt","SCrypt"};				//only with salt

		String[] fileDirHashes = {
				"SHA-1","SHA-224","SHA-256","SHA-384","SHA-512",	//with and without salt
				"SHA3-224","SHA3-256","SHA3-384","SHA3-512",		//with and without salt
				"MD5",												//with and without salt
				"TIGER","Blake2b","Blake3"							//with and without salt
				};													//only with salt

		// On Text tab
		this.cbAlgorithms.getItems().addAll(FXCollections.observableArrayList(passwHashes));
		// On File tab
		this.cbAlgorithms_f.getItems().addAll(FXCollections.observableArrayList(fileDirHashes));
		// On Dir tab
		this.cbAlgorithms_d.getItems().addAll(FXCollections.observableArrayList(fileDirHashes));
		// On MultiFile tab
		this.cbAlgorithms_mf.getItems().addAll(FXCollections.observableArrayList(fileDirHashes));
		// On CompFile tab
		this.cbAlgorithms_cf.getItems().addAll(FXCollections.observableArrayList(fileDirHashes));
		// On CompDir tab
		this.cbAlgorithms_cd.getItems().addAll(FXCollections.observableArrayList(fileDirHashes));

		// On Text tab
		//this.cbAddSalt.setDisable(true);
		this.cbAddPepper.setDisable(true);
		this.cbParallelize.setDisable(true);
		this.hif = new HashInputFormatText();
		this.cbAlgorithms.getSelectionModel().select(0);
		setContextMenu(lvOutput);

		// On File tab
		//this.cbAddSalt_f.setDisable(true);
		this.cbAddPepper_f.setDisable(true);
		this.cbParallelize_f.setDisable(true);
		this.taInput_f.setEditable(false);
		this.cbAlgorithms_f.getSelectionModel().select(0);
		setContextMenu(lvOutput_f);

		// On Dir tab
		//this.cbAddSalt_d.setDisable(true);
		this.cbAddPepper_d.setDisable(true);
		this.cbParallelize_d.setDisable(true);
		this.taInput_d.setEditable(false);
		this.cbAlgorithms_d.getSelectionModel().select(0);
		setContextMenu(lvOutput_d);

		// On MultiFile tab
		//this.cbAddSalt_mf.setDisable(true);
		this.cbAddPepper_mf.setDisable(true);
		this.cbParallelize_mf.setDisable(true);
		this.taInput_mf.setEditable(false);
		this.cbAlgorithms_mf.getSelectionModel().select(0);
		setContextMenu(lvOutput_mf);

		// On CompFile tab
		//this.cbAddSalt_cf.setDisable(true);
		this.cbAddPepper_cf.setDisable(true);
		this.cbParallelize_cf.setDisable(true);
		this.taInput_A_cf.setEditable(false);
		this.taInput_B_cf.setEditable(false);
		this.cbAlgorithms_cf.getSelectionModel().select(0);
		setContextMenu(lvOutput_A_cf);
		setContextMenu(lvOutput_B_cf);

		// On CompDir tab
		//this.cbAddSalt_cd.setDisable(true);
		this.cbAddPepper_cd.setDisable(true);
		this.cbParallelize_cd.setDisable(true);
		this.taInput_A_cd.setEditable(false);
		this.taInput_B_cd.setEditable(false);
		this.cbAlgorithms_cd.getSelectionModel().select(0);
		setContextMenu(lvOutput_A_cd);
		setContextMenu(lvOutput_B_cd);

		// On main
		this.lbStatus.setText("Load data and define input parameters.");
		this.lbStatus.setStyle("-fx-text-fill: white;");
		this.lbExTime.setText("---");

	}

	private void setContextMenu(ListView<HBox> listView) {
		ContextMenu contextMenu = new ContextMenu();
		MenuItem menuItem1 = new MenuItem("Copy hash");

		menuItem1.setOnAction((event) -> {
			// Get the selected cell:
			HBox hbox = (HBox) listView.getSelectionModel().getSelectedItem();
			Label label = (Label) hbox.getChildren().get(2);
			// Get the text of the Label:
			String selectedText = label.getText();
			final Clipboard clipboard = Clipboard.getSystemClipboard();
			final ClipboardContent content = new ClipboardContent();
			content.putString(selectedText);
			clipboard.setContent(content);

		});
		contextMenu.getItems().addAll(menuItem1);
		listView.setContextMenu(contextMenu);
	}


	/* TEXT TAB */
	@FXML
	public void HashTextAction(ActionEvent actionEvent) {
		invokeHashTextActionTask();
	}
	private void invokeHashTextActionTask() {

		// Check input
		List<String> listToHash = new ArrayList<>();
		if (!this.cbAlgorithms.getSelectionModel().isEmpty()) {
			// Check input area
			if (this.taInput.getText().length() > 0) {
				// Check Line-by-line option
				if (this.cbLineByLine.isSelected()) {
					// Check separator
					if (!this.tfSeparator.getText().isBlank()) {
						// Attention, for example, | and . (dot) are special characters in regular expressions. To escape them use "//|" or "//."
						listToHash = Arrays.asList(this.taInput.getText().split(this.tfSeparator.getText())); // Split lines selected
						// Test if split works properly
						//listToHash.forEach(System.out::println);
					} else {
						this.lbStatus.setText("Separator not defined!");
						this.lbStatus.setStyle("-fx-text-fill: red;");
					}
				} else {
					listToHash = Collections.singletonList(taInput.getText()); // Single input line
				}
			} else {
				this.lbStatus.setText("Add input data, hashing aborted!");
				this.lbStatus.setStyle("-fx-text-fill: red;");
			}
		} else {
			this.lbStatus.setText("Algorithm specification is missing!");
			this.lbStatus.setStyle("-fx-text-fill: red;");
		}

		// Process input
		String alg = this.cbAlgorithms.getSelectionModel().getSelectedItem();
		if (!listToHash.isEmpty()) {

			if(htat!=null && htat.isRunning()){
				htat.cancel();
			}
			htat = new HashTextActionTask(listToHash,alg,cbAddSalt);

            htat.outHBoxListProperty().addListener(new ChangeListener<ArrayList>() {
                @Override
                public void changed(ObservableValue<? extends ArrayList> observableValue, ArrayList oldAL, ArrayList newAL) {
                    if(newAL != null){
                        lvOutput.getItems().addAll(newAL);
                    }
                }
            });
			htat.titleProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbExTime.setText(newString);
				}
			});
			htat.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbStatus.setText(newString);
					lbStatus.setStyle("-fx-text-fill: green;");
				}
			});
			pBar.progressProperty().bind(htat.progressProperty());
			Thread th = new Thread(htat);
			th.setDaemon(true);
			th.start();


		}
	}
	@FXML
	public void LoadTextAction(ActionEvent actionEvent) throws IOException {
		LoadTextInput lip = new LoadTextInput(taInput, lbStatus);
		lip.chooseFile();
	}
	@FXML
	public void ClearInputAction(ActionEvent actionEvent) {
		ClearInput ci = new ClearInput(taInput, lbStatus);
		ci.removeText();
	}
	@FXML
	public void ClearOutputAction(ActionEvent actionEvent) {
		ClearOutput co = new ClearOutput(lvOutput, lbStatus);
		co.removeText();
	}
	@FXML
	public void cbAlgorithmsAction(ActionEvent actionEvent) {
		String alg = this.cbAlgorithms.getSelectionModel().getSelectedItem();
		if(alg.equals("MD2") || alg.equals("MD5") || alg.equals("SHA-1") || alg.equals("SHA-224") ||
				alg.equals("SHA-256") || alg.equals("SHA-384") || alg.equals("SHA-512") || alg.equals("SHA3-224") ||
				alg.equals("SHA3-256") || alg.equals("SHA3-384") || alg.equals("SHA3-512") || alg.equals("TIGER") ||
				alg.equals("Blake3") || alg.equals("Blake2b") ) {
			this.cbAddSalt.setDisable(false);	// DO NOT disable!
		} else if(alg.equals("PBKDF2") || alg.equals("BCrypt") || alg.equals("SCrypt") || alg.equals("Argon2id")) {
			this.cbAddSalt.setSelected(true);	// Only salted exists
			this.cbAddSalt.setDisable(true);	// DISABLE!
		}
	}
	@FXML
	public void LowercaseAction(ActionEvent actionEvent) {
		if(this.cbLowercase.isSelected()){
			this.hif.lowc(this.lbStatus,this.taInput);
		} else {
			this.taInput.clear();
			this.taInput.setText(this.hif.getOriginalMixCase());
		}
	}
	@FXML
	public void RemSpacesAction(ActionEvent actionEvent) {
		if(this.cbRemSpaces.isSelected()){
			this.hif.remspace(this.lbStatus,this.taInput);
		} else {
			this.taInput.clear();
			this.taInput.setText(this.hif.getOriginalWithSpace());
		}
	}
	@FXML
	public void NormAction(ActionEvent actionEvent) {
		if(this.cbNormalize.isSelected()){
			this.hif.norm(this.lbStatus,this.taInput);
		} else {
			this.taInput.clear();
			this.taInput.setText(this.hif.getOriginalUnNorm());
		}
	}
	@FXML
	public void LineByLineAction(ActionEvent actionEvent) {
		if(this.cbLineByLine.isSelected()){
			this.cbParallelize.setDisable(true);
		} else {
			this.cbParallelize.setDisable(true);
		}
	}

	/* FILE TAB */
	public void HashFileAction(ActionEvent actionEvent) {
		invokeHashFileActionTask();
	}
	private void invokeHashFileActionTask() {
		// Check input
		List<String> listToHash = new ArrayList<>();
		if(!cbAlgorithms_cf.getSelectionModel().isEmpty()) {
			// Check input area
			if (this.taInput_f.getText().length() > 0) {
				File file = new File(this.taInput_f.getText().split("\n")[0].split("\t")[0]); // Get only the firs part of the first line from the TextArea
				// Check if file path is absolute
				if (file.isAbsolute()) {
					// Check if File is not directory
					if (!file.isDirectory()) {

						// Only add if file size <3 GiB
						if( (file.length()) < (3 * (1024L*1024L*1024L)) ) {
							listToHash = List.of(file.getAbsolutePath());
						}

					} else {
						this.lbStatus.setText("Only a single file allowed!");
						this.lbStatus.setStyle("-fx-text-fill: red;");
					}
				} else {
					this.lbStatus.setText("Path is not absolute!");
					this.lbStatus.setStyle("-fx-text-fill: red;");
				}
			} else {
				this.lbStatus.setText("Add input data, hashing aborted!");
				this.lbStatus.setStyle("-fx-text-fill: red;");
			}
		} else {
			this.lbStatus.setText("Algorithm specification is missing!");
			this.lbStatus.setStyle("-fx-text-fill: red;");
		}

		// Process input
		String alg = this.cbAlgorithms_f.getSelectionModel().getSelectedItem();
		if (listToHash != null && !listToHash.isEmpty()) {

			if(hfat!=null && hfat.isRunning()){
				hfat.cancel();
			}

			hfat = new HashFileActionTask(listToHash,alg,cbAddSalt_f);
			hfat.valueProperty().addListener(new ChangeListener<HBox>() {
				@Override
				public void changed(ObservableValue<? extends HBox> observableValue, HBox oldHBox, HBox newHBox) {
					if(newHBox != null){
						lvOutput_f.getItems().add(newHBox);
					}
				}
			});
			hfat.titleProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbExTime.setText(newString);
				}
			});
			hfat.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbStatus.setText(newString);
					lbStatus.setStyle("-fx-text-fill: green;");
				}
			});
			pBar.progressProperty().bind(hfat.progressProperty());
			Thread th = new Thread(hfat);
			th.setDaemon(true);
			th.start();

		}
	}
	@FXML
	public void LoadFileAction_f(ActionEvent actionEvent) throws IOException {
		LoadFileInput lip = new LoadFileInput(taInput_f, lbStatus);
		lip.chooseFile();
	}
	@FXML
	public void ClearInputAction_f(ActionEvent actionEvent) {
		ClearInput ci = new ClearInput(taInput_f, lbStatus);
		ci.removeText();
	}
	@FXML
	public void ClearOutputAction_f(ActionEvent actionEvent) {
		ClearOutput co = new ClearOutput(lvOutput_f, lbStatus);
		co.removeText();
	}
	@FXML
	public void cbAlgorithmsAction_f(ActionEvent actionEvent) {
		String alg = this.cbAlgorithms_f.getSelectionModel().getSelectedItem();
		if(alg.equals("MD2") || alg.equals("MD5") || alg.equals("SHA-1") || alg.equals("SHA-224") ||
				alg.equals("SHA-256") || alg.equals("SHA-384") || alg.equals("SHA-512") || alg.equals("SHA3-224") ||
				alg.equals("SHA3-256") || alg.equals("SHA3-384") || alg.equals("SHA3-512") || alg.equals("TIGER") ||
				alg.equals("Blake3") || alg.equals("Blake2b") ) {
			this.cbAddSalt_f.setDisable(false);	// DO NOT disable! Both salted and non-salted possible.
		} else if(alg.equals("PBKDF2") || alg.equals("BCrypt") || alg.equals("SCrypt") || alg.equals("Argon2id")) {
			this.cbAddSalt_f.setSelected(true);	// Only salted exists
			this.cbAddSalt_f.setDisable(true);	// DISABLE!
		}
	}

	/* DIR TAB */
	public void HashDirAction(ActionEvent actionEvent) {
		invokeHashDirActionTask();
	}
	private void invokeHashDirActionTask() {
		// Check input
		List<String> listToHash = new ArrayList<>();
		if(!cbAlgorithms_d.getSelectionModel().isEmpty()) {
			// Check input area
			if (this.taInput_d.getText().length() > 0) {
				File files = new File(this.taInput_d.getText().split("\n")[0].split("\t")[0]); // Get only the firs part of the first line from the TextArea
				// Check if file path is absolute
				if (files.isAbsolute()) {
					// Check if File is not directory
					if (files.isDirectory()) {
						for (File f : Objects.requireNonNull(files.listFiles())) {
							// Only add files, subdirectories will be skipped
							if (f.isFile()) {

								// Only add if file size <3 GiB
								if( (f.length()) < (3 * (1024L*1024L*1024L)) ) {
									listToHash.add(f.getAbsolutePath());
								}

							}
						}
					} else {
						this.lbStatus.setText("Only a single folder allowed!");
						this.lbStatus.setStyle("-fx-text-fill: red;");
					}
				} else {
					this.lbStatus.setText("Path is not absolute!");
					this.lbStatus.setStyle("-fx-text-fill: red;");
				}
			} else {
				this.lbStatus.setText("Add input data, hashing aborted!");
				this.lbStatus.setStyle("-fx-text-fill: red;");
			}
		} else {
			this.lbStatus.setText("Algorithm specification is missing!");
			this.lbStatus.setStyle("-fx-text-fill: red;");
		}

		// Process input
		String alg = this.cbAlgorithms_d.getSelectionModel().getSelectedItem();
		if (listToHash != null && !listToHash.isEmpty()) {

			if(hdat!=null && hdat.isRunning()){
				hdat.cancel();
			}

			hdat = new HashDirActionTask(listToHash,alg,cbAddSalt_d);
			hdat.valueProperty().addListener(new ChangeListener<HBox>() {
				@Override
				public void changed(ObservableValue<? extends HBox> observableValue, HBox oldHBox, HBox newHBox) {
					if(newHBox != null){
						lvOutput_d.getItems().add(newHBox);
					}
				}
			});
			hdat.titleProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbExTime.setText(newString);
				}
			});
			hdat.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbStatus.setText(newString);
					lbStatus.setStyle("-fx-text-fill: green;");
				}
			});
			pBar.progressProperty().bind(hdat.progressProperty());
			Thread th = new Thread(hdat);
			th.setDaemon(true);
			th.start();

		}
	}
	@FXML
	public void LoadDirAction_d(ActionEvent actionEvent) throws IOException {
		LoadDirInput lid = new LoadDirInput(taInput_d, lbStatus);
		lid.chooseDir();
	}
	@FXML
	public void ClearInputAction_d(ActionEvent actionEvent) {
		ClearInput ci = new ClearInput(taInput_d, lbStatus);
		ci.removeText();
	}
	@FXML
	public void ClearOutputAction_d(ActionEvent actionEvent) {
		ClearOutput co = new ClearOutput(lvOutput_d, lbStatus);
		co.removeText();
	}
	@FXML
	public void cbAlgorithmsAction_d(ActionEvent actionEvent) {
		String alg = this.cbAlgorithms_d.getSelectionModel().getSelectedItem();
		if(alg.equals("MD2") || alg.equals("MD5") || alg.equals("SHA-1") || alg.equals("SHA-224") ||
				alg.equals("SHA-256") || alg.equals("SHA-384") || alg.equals("SHA-512") || alg.equals("SHA3-224") ||
				alg.equals("SHA3-256") || alg.equals("SHA3-384") || alg.equals("SHA3-512") || alg.equals("TIGER") ||
				alg.equals("Blake3") || alg.equals("Blake2b") ) {
			this.cbAddSalt_d.setDisable(false);	// DO NOT disable! Both salted and non-salted possible.
		} else if(alg.equals("PBKDF2") || alg.equals("BCrypt") || alg.equals("SCrypt") || alg.equals("Argon2id")) {
			this.cbAddSalt_d.setSelected(true);	// Only salted exists
			this.cbAddSalt_d.setDisable(true);	// DISABLE!
		}
	}

	/* MULTIFILE TAB */
	public void HashMultiFileAction(ActionEvent actionEvent) {
		invokeHashMultiFileActionTask();
	}
	private void invokeHashMultiFileActionTask() {
		// Check input
		List<String> listToHash = new ArrayList<>();
		if(!cbAlgorithms_mf.getSelectionModel().isEmpty()) {
			// Check input area
			if (this.taInput_mf.getText().length() > 0) {
				File files = new File(this.taInput_mf.getText().split("\n")[0].split("\t")[0]); // Get only the firs part of the first line from the TextArea
				// Check if file path is absolute
				if (files.isAbsolute()) {
					// Check if File is not directory
					if (files.isDirectory()) {
						for (File f : Objects.requireNonNull(files.listFiles())) {
							// Only add files, subdirectories will be skipped
							if (f.isFile()) {

								// Only add if file size <3 GiB
								if( (f.length()) < (3 * (1024L*1024L*1024L)) ) {
									listToHash.add(f.getAbsolutePath());
								}

							}
						}
					} else {
						this.lbStatus.setText("Only a single folder allowed!");
						this.lbStatus.setStyle("-fx-text-fill: red;");
					}
				} else {
					this.lbStatus.setText("Path is not absolute!");
					this.lbStatus.setStyle("-fx-text-fill: red;");
				}
			} else {
				this.lbStatus.setText("Add input data, hashing aborted!");
				this.lbStatus.setStyle("-fx-text-fill: red;");
			}
		} else {
			this.lbStatus.setText("Algorithm specification is missing!");
			this.lbStatus.setStyle("-fx-text-fill: red;");
		}

		// Process input
		String alg = this.cbAlgorithms_mf.getSelectionModel().getSelectedItem();
		if (listToHash != null && !listToHash.isEmpty()) {

			if(hmfat!=null && hmfat.isRunning()){
				hmfat.cancel();
			}

			hmfat = new HashMultiFileActionTask(listToHash,alg,cbAddSalt_mf);

			hmfat.outHBoxListProperty().addListener(new ChangeListener<ArrayList>() {
				@Override
				public void changed(ObservableValue<? extends ArrayList> observableValue, ArrayList oldAL, ArrayList newAL) {
					if(newAL != null){
						lvOutput_mf.getItems().addAll(newAL);
					}
				}
			});
			hmfat.titleProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbExTime.setText(newString);
				}
			});
			hmfat.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbStatus.setText(newString);
					lbStatus.setStyle("-fx-text-fill: green;");
				}
			});
			pBar.progressProperty().bind(hmfat.progressProperty());
			Thread th = new Thread(hmfat);
			th.setDaemon(true);
			th.start();

		}
	}
	@FXML
	public void LoadMultiFileAction_mf(ActionEvent actionEvent) throws IOException {
		LoadMultiFileInput lmfd = new LoadMultiFileInput(taInput_mf, lbStatus);
		lmfd.chooseDir();
	}
	@FXML
	public void ClearInputAction_mf(ActionEvent actionEvent) {
		ClearInput ci = new ClearInput(taInput_mf, lbStatus);
		ci.removeText();
	}
	@FXML
	public void ClearOutputAction_mf(ActionEvent actionEvent) {
		ClearOutput co = new ClearOutput(lvOutput_mf, lbStatus);
		co.removeText();
	}
	@FXML
	public void cbAlgorithmsAction_mf(ActionEvent actionEvent) {
		String alg = this.cbAlgorithms_mf.getSelectionModel().getSelectedItem();
		if(alg.equals("MD2") || alg.equals("MD5") || alg.equals("SHA-1") || alg.equals("SHA-224") ||
				alg.equals("SHA-256") || alg.equals("SHA-384") || alg.equals("SHA-512") || alg.equals("SHA3-224") ||
				alg.equals("SHA3-256") || alg.equals("SHA3-384") || alg.equals("SHA3-512") || alg.equals("TIGER") ||
				alg.equals("Blake3") || alg.equals("Blake2b") ) {
			this.cbAddSalt_mf.setDisable(false);	// DO NOT disable! Both salted and non-salted possible.
		} else if(alg.equals("PBKDF2") || alg.equals("BCrypt") || alg.equals("SCrypt") || alg.equals("Argon2id")) {
			this.cbAddSalt_mf.setSelected(true);	// Only salted exists
			this.cbAddSalt_mf.setDisable(true);	// DISABLE!
		}
	}

	/* COMPFILE TAB */
	public void HashCompFileAction(ActionEvent actionEvent) {
		invokeHashCompFileActionTask();
	}
	private void invokeHashCompFileActionTask() {
		// Check input
		List<String> listToHash_A = new ArrayList<>();
		List<String> listToHash_B = new ArrayList<>();
		if(!this.cbAlgorithms_cf.getSelectionModel().isEmpty()) {

			if ((this.taInput_A_cf.getText().length() > 0) && (this.taInput_B_cf.getText().length() > 0)) {

				File fileA = new File(this.taInput_A_cf.getText().split("\n")[0].split("\t")[0]); // Get only the firs part of the first line from the TextArea A
				File fileB = new File(this.taInput_B_cf.getText().split("\n")[0].split("\t")[0]); // Get only the firs part of the first line from the TextArea B

				if (fileA.isAbsolute() && fileB.isAbsolute()) {

					if (!fileA.isDirectory() && !fileB.isDirectory()) {

						// Only add if file size <3 GiB
						if( (fileA.length()) < (3 * (1024L*1024L*1024L)) ) {
							listToHash_A = List.of(fileA.getAbsolutePath());
						}
						if( (fileB.length()) < (3 * (1024L*1024L*1024L)) ) {
							listToHash_B = List.of(fileB.getAbsolutePath());
						}

					} else {
						this.lbStatus.setText("Only single files are allowed!");
						this.lbStatus.setStyle("-fx-text-fill: red;");
					}
				} else {
					this.lbStatus.setText("Path is not absolute!");
					this.lbStatus.setStyle("-fx-text-fill: red;");
				}
			} else {
				this.lbStatus.setText("Add input data, hashing aborted!");
				this.lbStatus.setStyle("-fx-text-fill: red;");
			}
		} else {
			this.lbStatus.setText("Algorithm specification is missing!");
			this.lbStatus.setStyle("-fx-text-fill: red;");
		}

		// Process input
		String alg = this.cbAlgorithms_cf.getSelectionModel().getSelectedItem();
		Thread th = new Thread();
		if (listToHash_A != null && !listToHash_A.isEmpty() && listToHash_B != null && !listToHash_B.isEmpty()) {

			if(hcfat!=null && hcfat.isRunning()){
				hcfat.cancel();
			}

			hcfat = new HashCompFileActionTask(listToHash_A, listToHash_B,alg,cbAddSalt_cf);

			// Get hashes for comparison
/*			// HBox returns from Task
			hcfat.outProperty1().addListener(new ChangeListener<HBox>() {
				@Override
				public void changed(ObservableValue<? extends HBox> observableValue, HBox oldHBox, HBox newHBox) {
					if(newHBox != null){
						lvOutput_A_cf.getItems().add(newHBox);
					}
				}
			});*/
			// ArrayList returns from Task
			hcfat.outHBoxList1Property().addListener(new ChangeListener<ArrayList>() {
				@Override
				public void changed(ObservableValue<? extends ArrayList> observableValue, ArrayList oldAL, ArrayList newAL) {
					if(newAL != null){
						lvOutput_A_cf.getItems().addAll(newAL);
					}
				}
			});
/*			// HBox returns from Task
			hcfat.outProperty2().addListener(new ChangeListener<HBox>() {
				@Override
				public void changed(ObservableValue<? extends HBox> observableValue, HBox oldHBox, HBox newHBox) {
					if(newHBox != null){
						lvOutput_B_cf.getItems().add(newHBox);
					}
				}
			});*/
			// ArrayList returns from Task
			hcfat.outHBoxList2Property().addListener(new ChangeListener<ArrayList>() {
				@Override
				public void changed(ObservableValue<? extends ArrayList> observableValue, ArrayList oldAL, ArrayList newAL) {
					if(newAL != null){
						lvOutput_B_cf.getItems().addAll(newAL);
					}
				}
			});
			hcfat.titleProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbExTime.setText(newString);
				}
			});
			hcfat.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbStatus.setText(newString);
					lbStatus.setStyle("-fx-text-fill: green;");
				}
			});
			pBar.progressProperty().bind(hcfat.progressProperty());
			th = new Thread(hcfat);
			th.setDaemon(true);
			th.start();

		}
	}
	public void LoadFileAction_A_cf(ActionEvent actionEvent) throws IOException {
		LoadFileInput lip = new LoadFileInput(taInput_A_cf, lbStatus);
		lip.setMessage("[A] Input file loaded!");
		lip.chooseFile();
	}
	public void LoadFileAction_B_cf(ActionEvent actionEvent) throws IOException {
		LoadFileInput lip = new LoadFileInput(taInput_B_cf, lbStatus);
		lip.setMessage("[B] Input file loaded!");
		lip.chooseFile();
	}
	public void ClearInputAction_A_cf(ActionEvent actionEvent) {
		ClearInput ci = new ClearInput(taInput_A_cf, lbStatus);
		ci.setMessage("[A] Input field cleared!");
		ci.removeText();
	}
	public void ClearInputAction_B_cf(ActionEvent actionEvent) {
		ClearInput ci = new ClearInput(taInput_B_cf, lbStatus);
		ci.setMessage("[B] Input field cleared!");
		ci.removeText();
	}
	public void ClearOutputAction_A_cf(ActionEvent actionEvent) {
		ClearOutput co = new ClearOutput(lvOutput_A_cf, lbStatus);
		co.setMessage("[A] Output field cleared!");
		co.removeText();
	}
	public void ClearOutputAction_B_cf(ActionEvent actionEvent) {
		ClearOutput co = new ClearOutput(lvOutput_B_cf, lbStatus);
		co.setMessage("[B] Output field cleared!");
		co.removeText();
	}
	public void cbAlgorithmsAction_cf(ActionEvent actionEvent) {
		String alg = this.cbAlgorithms_cf.getSelectionModel().getSelectedItem();
		if(alg.equals("MD2") || alg.equals("MD5") || alg.equals("SHA-1") || alg.equals("SHA-224") ||
				alg.equals("SHA-256") || alg.equals("SHA-384") || alg.equals("SHA-512") || alg.equals("SHA3-224") ||
				alg.equals("SHA3-256") || alg.equals("SHA3-384") || alg.equals("SHA3-512") || alg.equals("TIGER") ||
				alg.equals("Blake3") || alg.equals("Blake2b") ) {
			this.cbAddSalt_cf.setDisable(false);	// DO NOT disable! Both salted and non-salted possible.
		} else if(alg.equals("PBKDF2") || alg.equals("BCrypt") || alg.equals("SCrypt") || alg.equals("Argon2id")) {
			this.cbAddSalt_cf.setSelected(true);	// Only salted exists
			this.cbAddSalt_cf.setDisable(true);	// DISABLE!
		}
	}

	/* COMPDIR TAB */
	public void HashCompDirAction(ActionEvent actionEvent) {
		invokeHashCompDirActionTask();
	}

	public void invokeHashCompDirActionTask() {
		// Check input
		List<String> listToHash_A = new ArrayList<>();
		List<String> listToHash_B = new ArrayList<>();
		if(!this.cbAlgorithms_cd.getSelectionModel().isEmpty()) {

			if ((this.taInput_A_cd.getText().length() > 0) && (this.taInput_B_cd.getText().length() > 0)) {

				File fileA = new File(this.taInput_A_cd.getText().split("\n")[0].split("\t")[0]); // Get only the firs part of the first line from the TextArea A
				File fileB = new File(this.taInput_B_cd.getText().split("\n")[0].split("\t")[0]); // Get only the firs part of the first line from the TextArea B

				if (fileA.isAbsolute() && fileB.isAbsolute()) {

					if (fileA.isDirectory() && fileB.isDirectory()) {

						for (File f : Objects.requireNonNull(fileA.listFiles())) {
							// Only add files, subdirectories will be skipped
							if (f.isFile()) {

								// Only add if file size <3 GiB
								if( (f.length()) < (3 * (1024L*1024L*1024L)) ) {
									listToHash_A.add(f.getAbsolutePath());
								}
							}
						}
						for (File f : Objects.requireNonNull(fileB.listFiles())) {
							// Only add files, subdirectories will be skipped
							if (f.isFile()) {

								// Only add if file size <3 GiB
								if( (f.length()) < (3 * (1024L*1024L*1024L)) ) {
									listToHash_B.add(f.getAbsolutePath());
								}
							}
						}

					} else {
						this.lbStatus.setText("Only a single folder allowed!");
						this.lbStatus.setStyle("-fx-text-fill: red;");
					}
				} else {
					this.lbStatus.setText("Path is not absolute!");
					this.lbStatus.setStyle("-fx-text-fill: red;");
				}
			} else {
				this.lbStatus.setText("Add input data, hashing aborted!");
				this.lbStatus.setStyle("-fx-text-fill: red;");
			}
		} else {
			this.lbStatus.setText("Algorithm specification is missing!");
			this.lbStatus.setStyle("-fx-text-fill: red;");
		}

		// Process input
		String alg = this.cbAlgorithms_cd.getSelectionModel().getSelectedItem();
		Thread th = new Thread();
		if (listToHash_A != null && !listToHash_A.isEmpty() && listToHash_B != null && !listToHash_B.isEmpty()) {

			if(hcdat!=null && hcdat.isRunning()){
				hcdat.cancel();
			}
			hcdat = new HashCompDirActionTask(listToHash_A, listToHash_B,alg,cbAddSalt_cd);

			// ArrayList returns from Task
			hcdat.outHBoxList1Property().addListener(new ChangeListener<ArrayList>() {
				@Override
				public void changed(ObservableValue<? extends ArrayList> observableValue, ArrayList oldAL, ArrayList newAL) {
					if(newAL != null){
						lvOutput_A_cd.getItems().addAll(newAL);
					}
				}
			});
			// ArrayList returns from Task
			hcdat.outHBoxList2Property().addListener(new ChangeListener<ArrayList>() {
				@Override
				public void changed(ObservableValue<? extends ArrayList> observableValue, ArrayList oldAL, ArrayList newAL) {
					if(newAL != null){
						lvOutput_B_cd.getItems().addAll(newAL);
					}
				}
			});
			hcdat.titleProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbExTime.setText(newString);
				}
			});
			hcdat.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String oldString, String newString) {
					lbStatus.setText(newString);
					lbStatus.setStyle("-fx-text-fill: green;");
				}
			});
			pBar.progressProperty().bind(hcdat.progressProperty());
			th = new Thread(hcdat);
			th.setDaemon(true);
			th.start();

		}
	}

	public void LoadDirAction_A_cd(ActionEvent actionEvent) throws IOException {
		LoadMultiFileInput lmfd = new LoadMultiFileInput(taInput_A_cd, lbStatus);
		lmfd.chooseDir();
	}
	public void LoadDirAction_B_cd(ActionEvent actionEvent) throws IOException {
		LoadMultiFileInput lmfd = new LoadMultiFileInput(taInput_B_cd, lbStatus);
		lmfd.chooseDir();
	}
	public void ClearInputAction_A_cd(ActionEvent actionEvent) {
		ClearInput ci = new ClearInput(taInput_A_cd, lbStatus);
		ci.setMessage("[A] Input field cleared!");
		ci.removeText();
	}
	public void ClearInputAction_B_cd(ActionEvent actionEvent) {
		ClearInput ci = new ClearInput(taInput_B_cd, lbStatus);
		ci.setMessage("[B] Input field cleared!");
		ci.removeText();
	}
	public void ClearOutputAction_A_cd(ActionEvent actionEvent) {
		ClearOutput co = new ClearOutput(lvOutput_A_cd, lbStatus);
		co.setMessage("[A] Output field cleared!");
		co.removeText();
	}
	public void ClearOutputAction_B_cd(ActionEvent actionEvent) {
		ClearOutput co = new ClearOutput(lvOutput_B_cd, lbStatus);
		co.setMessage("[B] Output field cleared!");
		co.removeText();
	}
	public void cbAlgorithmsAction_cd(ActionEvent actionEvent) {
		String alg = this.cbAlgorithms_cd.getSelectionModel().getSelectedItem();
		if(alg.equals("MD2") || alg.equals("MD5") || alg.equals("SHA-1") || alg.equals("SHA-224") ||
				alg.equals("SHA-256") || alg.equals("SHA-384") || alg.equals("SHA-512") || alg.equals("SHA3-224") ||
				alg.equals("SHA3-256") || alg.equals("SHA3-384") || alg.equals("SHA3-512") || alg.equals("TIGER") ||
				alg.equals("Blake3") || alg.equals("Blake2b") ) {
			this.cbAddSalt_cd.setDisable(false);	// DO NOT disable! Both salted and non-salted possible.
		} else if(alg.equals("PBKDF2") || alg.equals("BCrypt") || alg.equals("SCrypt") || alg.equals("Argon2id")) {
			this.cbAddSalt_cd.setSelected(true);	// Only salted exists
			this.cbAddSalt_cd.setDisable(true);	// DISABLE!
		}
	}

	// Menu options
	public void MenuItemSaveAction(ActionEvent actionEvent) {

		List<ListView<HBox>> listViews = new ArrayList<>();

		// Initialize the ListViews
		listViews.add(lvOutput);
		listViews.add(lvOutput_f);
		listViews.add(lvOutput_d);
		listViews.add(lvOutput_mf);
		listViews.add(lvOutput_A_cf);
		listViews.add(lvOutput_B_cf);
		listViews.add(lvOutput_A_cd);
		listViews.add(lvOutput_B_cd);

		SaveAllListViews salv = new SaveAllListViews();
		salv.SaveAllListViews(listViews);
	}

	public void MenuItemCloseAction(ActionEvent actionEvent) {
		Platform.exit();
	}

	public void MenuItemManualAction(ActionEvent actionEvent) {
		try {
			// Open the manual in the default web browser
			Desktop.getDesktop().browse(new URL("https://github.com/endreth/jHasher").toURI());
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void MenuItemAboutAction(ActionEvent actionEvent) {

		// Shows about information
		Alert aboutDialog = new Alert(Alert.AlertType.INFORMATION);
		aboutDialog.setTitle("About");
		aboutDialog.setHeaderText("jHasher v1.0.2");
		aboutDialog.setContentText("Endre Gy. Toth\nDennis Gabor College, Budapest (Hungary)\nCopyright 2023\nAll rights reserved.");

		// Show the dialog box
		aboutDialog.showAndWait();
	}

	// On program termination
	public void dispose() {
		this.slc.setExit(true);
		this.slm.setExit(true);
	}
}
