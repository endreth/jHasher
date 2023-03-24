package view;

import com.github.mouse0w0.darculafx.DarculaFX;
import controller.GUIController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUI extends Application {

	private static Stage pStage;
	private static Scene pScene;
	private GUIController gc;

	@Override
	public void start(Stage primaryStage) {
		
		try {

			FXMLLoader loader = new FXMLLoader();
			BorderPane root = loader.load(getClass().getClassLoader().getResourceAsStream("GUI.fxml"));
			this.gc = loader.getController();

			pStage =primaryStage;
			pStage.setTitle("jHasher v1.0.2");
			pStage.getIcons().add(new Image("favpng_lightgray.png"));

			pScene = new Scene(root, 800, 600);

			// Apply DraculaFX theme
			DarculaFX.applyDarculaStyle(pScene);
			pStage.setScene(pScene);

			pStage.show();

			// Bind the ListView scroll property, MultiComp tab
			Node n1 = gc.lvOutput_A_cf.lookup(".scroll-bar");
			if (n1 instanceof ScrollBar) {
				final ScrollBar bar1 = (ScrollBar) n1;
				Node n2 = gc.lvOutput_B_cf.lookup(".scroll-bar");
				if (n2 instanceof ScrollBar) {
					final ScrollBar bar2 = (ScrollBar) n2;
					bar1.valueProperty().bindBidirectional(bar2.valueProperty());
				}
			}
			Node n3 = gc.lvOutput_A_cd.lookup(".scroll-bar");
			if (n3 instanceof ScrollBar) {
				final ScrollBar bar1 = (ScrollBar) n3;
				Node n4 = gc.lvOutput_B_cd.lookup(".scroll-bar");
				if (n4 instanceof ScrollBar) {
					final ScrollBar bar2 = (ScrollBar) n4;
					bar1.valueProperty().bindBidirectional(bar2.valueProperty());
				}
			}

			// Set close operation
			pStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent e) {
					gc.dispose(); // Shut down thread
					Platform.exit(); // Shut down GUI thread
					System.exit(0); // Shut down system, kill JVM
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Stage getpStage() { return pStage; }

	public static void setpStage(Stage pStage) {
		GUI.pStage = pStage;
	}

	public static Scene getpScene() { return pScene; }

	public static void setpScene(Scene pScene) { GUI.pScene = pScene; }
}
