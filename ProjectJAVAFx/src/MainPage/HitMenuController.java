/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HitMenuController implements Initializable {

    @FXML
    private Text starInsufficient;
    @FXML
    private ImageView homeBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private AnchorPane hitMenuPane;
    @FXML
    private Circle c3;
    @FXML
    private Circle c4;
    @FXML
    private Circle c31;
    @FXML
    private Circle c41;

    private DataStore dataS;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        starInsufficient.setVisible(false);
        setRotate(c3,360);
        setRotate(c4,360);
        setRotate(c31,-360);
        setRotate(c41,-360);
    }

    public void initData(DataStore dataStore){
        dataS = dataStore;

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
    public void resumeFromHit(ActionEvent actionEvent) throws Exception {
        System.out.println(Main.getCurrentDatabase().getTotalStar());

        if(Main.getCurrentDatabase().getTotalStar() >= 10){
            Main.getCurrentDatabase().setTotalStar(Main.getCurrentDatabase().getTotalStar()-10);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
            AnchorPane pane=fxmlLoader.load();
            GamePlayController controller = fxmlLoader.<GamePlayController>getController();

            dataS.setPosballY(dataS.getPosballY() + 30);

            controller.initData(dataS.getObstaclesList(),dataS.getColorSwitchList(),dataS.getStarsList(),dataS.getPosballX(),dataS.getPosballY(),false,dataS.getBallRGB(), dataS.getCurrentStars());
            hitMenuPane.getChildren().setAll(pane);
        }else {
            starInsufficient.setVisible(true);

        }




    }

    @FXML
    public void restartFromHit(ActionEvent actionEvent) throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane pane=fxmlLoader.load();
        GamePlayController controller = fxmlLoader.<GamePlayController>getController();
        controller.initData(null,null,null,0,0,true,null,0);
        hitMenuPane.getChildren().setAll(pane);

    }

    @FXML
    public void goToHome(MouseEvent actionEvent) throws Exception {
        Pane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        hitMenuPane.getChildren().setAll(pane);

    }
    
}
