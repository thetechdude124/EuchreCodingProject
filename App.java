import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class App extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // Setups
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);
        
        // Icon & title
        Image icon = new Image("among us.png");
        stage.getIcons().add(icon);
        stage.setTitle("among us");

        // Screen size & position
        stage.setWidth(420);
        stage.setWidth(420);
        stage.setResizable(false);
        stage.setX(50);
        stage.setY(50);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("F for unfullscreen");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("f"));

        // Display code
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}