package MainPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadGameController implements Initializable {

    @FXML
    private Text gameNotDound;
    @FXML
    private ImageView backButton;
    @FXML
    private AnchorPane loadGamePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameNotDound.setVisible(false);
    }

    @FXML
    public void goBack(MouseEvent actionEvent) throws Exception {
        Pane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        loadGamePane.getChildren().setAll(pane);
    }

    public void game1(ActionEvent actionEvent) throws IOException {
        if(Main.getCurrentDatabase().getDataBaseList().size() >= 1){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
            AnchorPane pane=fxmlLoader.load();
            GamePlayController controller = fxmlLoader.<GamePlayController>getController();
            DataStore dataStore = Main.getCurrentDatabase().getDataBaseList().get(0);
            controller.initData(dataStore.getObstaclesList(),dataStore.getColorSwitchList(),dataStore.getStarsList(),dataStore.getPosballX(),dataStore.getPosballY(),false,dataStore.getBallRGB(),dataStore.getCurrentStars());
            loadGamePane.getChildren().setAll(pane);
        }else {
            gameNotDound.setVisible(true);
        }
    }

    public void game2(ActionEvent actionEvent) throws IOException {
        if(Main.getCurrentDatabase().getDataBaseList().size() >= 2){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
            AnchorPane pane=fxmlLoader.load();
            GamePlayController controller = fxmlLoader.<GamePlayController>getController();
            DataStore dataStore = Main.getCurrentDatabase().getDataBaseList().get(1);
            controller.initData(dataStore.getObstaclesList(),dataStore.getColorSwitchList(),dataStore.getStarsList(),dataStore.getPosballX(),dataStore.getPosballY(),false,dataStore.getBallRGB(),dataStore.getCurrentStars());
            loadGamePane.getChildren().setAll(pane);
        }else {
            gameNotDound.setVisible(true);
        }
    }

    public void game3(ActionEvent actionEvent) throws IOException {
        if(Main.getCurrentDatabase().getDataBaseList().size() >= 3){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
            AnchorPane pane=fxmlLoader.load();
            GamePlayController controller = fxmlLoader.<GamePlayController>getController();
            DataStore dataStore = Main.getCurrentDatabase().getDataBaseList().get(2);
            controller.initData(dataStore.getObstaclesList(),dataStore.getColorSwitchList(),dataStore.getStarsList(),dataStore.getPosballX(),dataStore.getPosballY(),false,dataStore.getBallRGB(),dataStore.getCurrentStars());
            loadGamePane.getChildren().setAll(pane);
        }else {
            gameNotDound.setVisible(true);
        }
    }

    public void game4(ActionEvent actionEvent) throws IOException {
        if(Main.getCurrentDatabase().getDataBaseList().size() >= 4){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
            AnchorPane pane=fxmlLoader.load();
            GamePlayController controller = fxmlLoader.<GamePlayController>getController();
            DataStore dataStore = Main.getCurrentDatabase().getDataBaseList().get(3);
            controller.initData(dataStore.getObstaclesList(),dataStore.getColorSwitchList(),dataStore.getStarsList(),dataStore.getPosballX(),dataStore.getPosballY(),false,dataStore.getBallRGB(),dataStore.getCurrentStars());
            loadGamePane.getChildren().setAll(pane);
        }else {
            gameNotDound.setVisible(true);
        }
    }

    public void game5(ActionEvent actionEvent) throws IOException {
        if(Main.getCurrentDatabase().getDataBaseList().size() >= 5){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
            AnchorPane pane=fxmlLoader.load();
            GamePlayController controller = fxmlLoader.<GamePlayController>getController();
            DataStore dataStore = Main.getCurrentDatabase().getDataBaseList().get(4);
            controller.initData(dataStore.getObstaclesList(),dataStore.getColorSwitchList(),dataStore.getStarsList(),dataStore.getPosballX(),dataStore.getPosballY(),false,dataStore.getBallRGB(),dataStore.getCurrentStars());
            loadGamePane.getChildren().setAll(pane);
        }else {
            gameNotDound.setVisible(true);
        }
    }
}
