package MainPage;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private Circle c4;

    @FXML
    private Button newGame;
    @FXML
    private Button loadGame;
    @FXML
    private Button viewScore;
    @FXML
    private Button exitGame;
    @FXML
    private Pane mainRoot;

    public static GamePlayController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRotate(c1,360);
        setRotate(c2,-360);
        setRotate(c3,360);
        setRotate(c4,-360);

    }

    private void setRotate(Circle c,int angle){
        RotateTransition rt = new RotateTransition(Duration.seconds(5),c);

        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.play();
    }

    @FXML
    public void newGame(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(null,null,null,0,0,true,null,0);
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    public void loadGame(javafx.event.ActionEvent actionEvent) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoadGame.fxml"));
        AnchorPane pane=fxmlLoader.load();

        mainRoot.getChildren().setAll(pane);
    }


    @FXML
    public void viewScore(javafx.event.ActionEvent actionEvent) throws Exception {
        Pane pane= FXMLLoader.load(getClass().getResource("ViewScore.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    public void exitGame(javafx.event.ActionEvent actionEvent) {

        Main.serialize();
        System.exit(0);
    }
}
