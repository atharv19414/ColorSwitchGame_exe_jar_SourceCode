
package MainPage;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class PauseMenuController implements Initializable {

    @FXML
    private Button restartGame;
    @FXML
    private Button saveExit;
    @FXML
    private ImageView homeBtn;
    @FXML
    private AnchorPane pauseMenuPane;
    @FXML
    private Button resumeBtn;
    @FXML
    private Circle c3;
    @FXML
    private Circle c4;
    @FXML
    private Circle c31;
    @FXML
    private Circle c41;

    private DataStore data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setRotate(c3,360);
        setRotate(c4,360);
        setRotate(c31,-360);
        setRotate(c41,-360);
    }

    public void initData(DataStore dataStore){
        data = dataStore;
    }

    private void setRotate(Circle c,int angle){
        RotateTransition rt = new RotateTransition(javafx.util.Duration.seconds(5),c);

        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.play();
    }

    @FXML
    public void resume(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(data.getObstaclesList(),data.getColorSwitchList(),data.getStarsList(),data.getPosballX(),data.getPosballY(),false,data.getBallRGB(), data.getCurrentStars());
        pauseMenuPane.getChildren().setAll(pane);
    }

    @FXML
    public void restart(ActionEvent actionEvent) throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(null,null,null,0,0,true,null,0);
        pauseMenuPane.getChildren().setAll(pane);

    }

    @FXML
    public void saveAndExit(ActionEvent actionEvent) throws Exception {
        if(Main.getCurrentDatabase().getDataBaseList().size() < 5){
            Main.getCurrentDatabase().removeData(data);
            Main.getCurrentDatabase().getDataBaseList().add(data);
            Main.serialize();
        }else {
            Main.getCurrentDatabase().removeData(data);
            Main.getCurrentDatabase().getDataBaseList().set(0,data);
            Main.serialize();
        }
        Pane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        pauseMenuPane.getChildren().setAll(pane);
//        System.exit(0);
    }

    @FXML
    public void goToHome(MouseEvent actionEvent) throws Exception {

        Pane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        pauseMenuPane.getChildren().setAll(pane);

    }





}
