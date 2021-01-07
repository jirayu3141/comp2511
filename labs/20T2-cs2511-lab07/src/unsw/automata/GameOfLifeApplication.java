/**
 *
 */
package unsw.automata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Conway's Game of Life Application
 *
 * @author Robert Clifton-Everest
 *
 */
public class GameOfLifeApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Conway's Game of Life"); // 1. set the stage's title

        GameOfLifeController controller = new GameOfLifeController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOfLifeView.fxml"));
        loader.setController(controller);
        
        Parent root = loader.load();    // load the loader (all the element + controller) into scene


        Scene scene = new Scene(root);  // 2. set the stage's scene

        primaryStage.setScene(scene);

        primaryStage.show();       // 3. show
    }



    public static void main(String[] args) {
        launch(args);
    }

}
