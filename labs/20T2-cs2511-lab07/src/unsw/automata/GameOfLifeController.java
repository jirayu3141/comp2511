package unsw.automata;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 * A JavaFX controller for the Conway's Game of Live Application.
 *
 * @author Robert Clifton-Everest
 *
 */
public class GameOfLifeController {
    // --- linking fx:id ----
    @FXML
    private Button tickBtn;
    @FXML
    private Button playBtn;
    @FXML
    private GridPane grid;
    @FXML
    private CheckBox lifeTickBox;

    private GameOfLife gol;
    private final Timeline timeline;

    public GameOfLifeController() {
        this.gol = new GameOfLife();
        this.timeline = new Timeline();
        this.timeline.setCycleCount(Animation.INDEFINITE);
        final KeyFrame fk = new KeyFrame(Duration.millis(500), e -> this.gol.tick());   //after 500ms do the event handler
        timeline.getKeyFrames().add(fk);
        
    }

    // bind lifeBox with 
    @FXML
    public void initialize() {
        for (int i = 0; i < grid.getRowCount(); i++) {
            for (int j = 0; j < grid.getColumnCount(); j++) {
                CheckBox box = new CheckBox();
                gol.getLifeAtCell(i, j).bindBidirectional(box.selectedProperty());
                grid.add(box, j, i);
            }
        }
    }
    
    @FXML
    void handlePlayBtn(ActionEvent event) {
        if (timeline.getStatus().equals(Animation.Status.STOPPED)) {
			timeline.play();
			playBtn.setText("Stop");
		} else {
			timeline.stop();
			playBtn.setText("Play");
		}
    }

    @FXML
    void handleTickBtn(ActionEvent event) {
        gol.tick();
    }

	

} 

