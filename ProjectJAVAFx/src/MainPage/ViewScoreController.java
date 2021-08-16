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

public class ViewScoreController implements Initializable {

    @FXML
    private Text textFScore;
    @FXML
    private Button totalStars,bestScore;
    @FXML
    private ImageView backButton;
    @FXML
    private Circle cir1;
    @FXML
    private Circle cir2;
    @FXML
    private Circle cir3;
    @FXML
    private Circle cir4;
    @FXML
    private AnchorPane viewScorePane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRotate(cir1,360);
        setRotate(cir2,-360);
        setRotate(cir3,360);
        setRotate(cir4,-360);
    }

    private void setRotate(Circle c, int angle){
        RotateTransition rt = new RotateTransition(Duration.seconds(5),c);

        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.play();
    }

    public void goBack(MouseEvent actionEvent) throws Exception {
        Pane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        viewScorePane.getChildren().setAll(pane);
    }

    public void viewTotalStars(ActionEvent actionEvent) {
        textFScore.setText(String.valueOf(Main.getCurrentDatabase().getTotalStar()));
    }

    public void viewBestScore(ActionEvent actionEvent) {
        textFScore.setText(String.valueOf(Main.getCurrentDatabase().getBestScore()));


    }
}
