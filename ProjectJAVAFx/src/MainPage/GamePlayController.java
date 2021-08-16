package MainPage;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class GamePlayController implements Initializable {

    private static int starCollected;
    private static final long serialVersionUID=42L;


    @FXML
    private Line godLine;
    @FXML
    private Arc arcd1,arcd2,arcd3,arcd4;
    @FXML
    private Arc arcd5,arcd6,arcd7,arcd8;

    @FXML
    private Group circleObs1, circleObs2,squareObs;
    @FXML
    private Group colorSwitcher, colorSwitcher1, colorSwitcher2, colorSwitcher3, colorSwitcher4;
    @FXML
    private Arc arc11,arc21,arc31,arc41;
    @FXML
    private Arc arc12,arc22,arc32,arc42;

    @FXML
    private Group doubleInnerCircle;
    @FXML
    private Group doubleCircle;
    @FXML
    private Line downLine,sqLine1,sqLine2,sqLine3,sqLine4;
    @FXML
    private Group plusObstacle;
    @FXML
    private Line line2;
    @FXML
    private Line line4;
    @FXML
    private Line line3;
    @FXML
    private Line line1;
    @FXML
    private Circle blackCircle;

    @FXML
    private Line invisibleLine;
    @FXML
    private Text scoreText;
    @FXML
    private ImageView star0, star, star1, star2, star3;
    @FXML
    private ImageView pauseBtn;
    @FXML
    private Button pauseButton;

    @FXML
    private AnchorPane gamePlayPane;
    @FXML
    private Circle ball;
    @FXML
    private Group circleObs;
    @FXML
    private static AnimationTimer anim_timer;

    @FXML
    private Arc arc1,arc2,arc3,arc4;
    @FXML
    private Line obsLine;
    private boolean buttonClicked = false;

    public static ArrayList<ArrayList<Double>> obstacles;
    public static ArrayList<ArrayList<Double>> colorSwitchList;
    public static ArrayList<ArrayList<Double>> starsList;
    public static CircleObstacle circleObstacle, doubleCircleObstacle, circleObstacle1,circleObstacle2;
    public static SquareObstacle squareObstacle;
    public static PlusObstacle pluObstacle;

    private static int currentBallColor;


    public static AnimationTimer getAnim_timer() {
        return anim_timer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    @FXML
    public void initData(ArrayList<ArrayList<Double>> obstaclesList,ArrayList<ArrayList<Double>> colorSwitchL,ArrayList<ArrayList<Double>> starsL,double BposX,double BposY, boolean newGame, ArrayList<Double> ballColorRGB, int starFromSave){
        currentBallColor = 0;
        obstacles = new ArrayList<ArrayList<Double>>();
        colorSwitchList = new ArrayList<ArrayList<Double>>();
        starsList = new ArrayList<ArrayList<Double>>();

        circleObstacle = new CircleObstacle(circleObs.getLayoutX(),circleObs.getLayoutY(),circleObs.getRotate());
        doubleCircleObstacle = new CircleObstacle(doubleCircle.getLayoutX(),doubleCircle.getLayoutY(),doubleCircle.getRotate());
        circleObstacle1 = new CircleObstacle(circleObs1.getLayoutX(),circleObs1.getLayoutY(),circleObs1.getRotate());
        circleObstacle2 = new CircleObstacle(circleObs2.getLayoutX(),circleObs2.getLayoutY(),circleObs2.getRotate());
        squareObstacle = new SquareObstacle(squareObs.getLayoutX(),squareObs.getLayoutY(),squareObs.getRotate());
        pluObstacle = new PlusObstacle(plusObstacle.getLayoutX(),plusObstacle.getLayoutY(),plusObstacle.getRotate());
        obstacles.add(new ArrayList<Double>());
        obstacles.add(new ArrayList<Double>());
        obstacles.add(new ArrayList<Double>());
        obstacles.add(new ArrayList<Double>());
        obstacles.add(new ArrayList<Double>());
        obstacles.add(new ArrayList<Double>());

        starsList.add(new ArrayList<Double>());
        starsList.add(new ArrayList<Double>());
        starsList.add(new ArrayList<Double>());
        starsList.add(new ArrayList<Double>());
        starsList.add(new ArrayList<Double>());

        colorSwitchList.add((new ArrayList<Double>()));
        colorSwitchList.add((new ArrayList<Double>()));
        colorSwitchList.add((new ArrayList<Double>()));
        colorSwitchList.add((new ArrayList<Double>()));
        colorSwitchList.add((new ArrayList<Double>()));


        obstacles.get(0).add(circleObstacle.getPosX());
        obstacles.get(0).add(circleObstacle.getPosY());
        obstacles.get(0).add(circleObstacle.getAngle());


        obstacles.get(1).add(pluObstacle.getPosX());
        obstacles.get(1).add(pluObstacle.getPosY());
        obstacles.get(1).add(pluObstacle.getAngle());

        obstacles.get(2).add(circleObstacle1.getPosX());
        obstacles.get(2).add(circleObstacle1.getPosY());
        obstacles.get(2).add(circleObstacle1.getAngle());

        obstacles.get(3).add(circleObstacle2.getPosX());
        obstacles.get(3).add(circleObstacle2.getPosY());
        obstacles.get(3).add(circleObstacle2.getAngle());

        obstacles.get(4).add(doubleCircleObstacle.getPosX());
        obstacles.get(4).add(doubleCircleObstacle.getPosY());
        obstacles.get(4).add(doubleCircleObstacle.getAngle());

        obstacles.get(5).add(squareObstacle.getPosX());
        obstacles.get(5).add(squareObstacle.getPosY());
        obstacles.get(5).add(squareObstacle.getAngle());

        if(!newGame){
            setLayoutObstacle(circleObs,0,obstaclesList);
            setLayoutObstacle(plusObstacle,1,obstaclesList);
            setLayoutObstacle(doubleCircle,2,obstaclesList);
            setLayoutObstacle(circleObs1,3,obstaclesList);
            setLayoutObstacle(circleObs2,4,obstaclesList);
            setLayoutObstacle(squareObs,5,obstaclesList);

            setLayoutStarASwitch(starsL,star,0);
            setLayoutStarASwitch(starsL,star0,1);
            setLayoutStarASwitch(starsL,star1,2);
            setLayoutStarASwitch(starsL,star2,3);
            setLayoutStarASwitch(starsL,star3,4);

            setLayoutStarASwitch(colorSwitchL,colorSwitcher,0);
            setLayoutStarASwitch(colorSwitchL,colorSwitcher1,1);
            setLayoutStarASwitch(colorSwitchL,colorSwitcher2,2);
            setLayoutStarASwitch(colorSwitchL,colorSwitcher3,3);
            setLayoutStarASwitch(colorSwitchL,colorSwitcher4,4);

            ball.setLayoutX(BposX);
            ball.setLayoutY(BposY);

            starCollected = starFromSave;
            scoreText.setText(String.valueOf(starFromSave));
            ball.setFill(Color.color(ballColorRGB.get(0),ballColorRGB.get(1),ballColorRGB.get(2)));
//            System.out.println(ballColorRGB.get(0));
//            System.out.println(ballColorRGB.get(1));
//            System.out.println(ballColorRGB.get(2));

        }

        starCollected = 0;
        gameProgress(obstaclesList,colorSwitchL,starsL,BposX,BposY);

    }

    public void gameProgress(ArrayList<ArrayList<Double>> obstaclesList,ArrayList<ArrayList<Double>> colorSwitchL,ArrayList<ArrayList<Double>> starsL,double BposX,double BposY){
        anim_timer = new AnimationTimer() {
            @Override
            public void handle(long l) {


                circleObs.setRotate(circleObs.getRotate()+1.5);
                circleObs1.setRotate(circleObs1.getRotate()+2);
                circleObs2.setRotate(circleObs2.getRotate()-2);
                plusObstacle.setRotate(plusObstacle.getRotate()+1);
                doubleCircle.setRotate(doubleCircle.getRotate()-1);
                squareObs.setRotate(squareObs.getRotate()+1);


                ballMovement();

                ballStarSwitchCollision();

                objectDownMovement();

                objectRelocation();

                if(ball.getBoundsInParent().intersects(downLine.getBoundsInParent())){
                    anim_timer.stop();
                    Pane pane = null;
                    updateData();
                    updateArrayList();
                    try {
                        loadHitMenu();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(((Path)Shape.intersect(ball,arc1)).getElements().size() > 0|| ((Path)Shape.intersect(ball,arc2)).getElements().size() > 0 ||((Path)Shape.intersect(ball,arc3)).getElements().size() > 0||((Path)Shape.intersect(ball,arc4)).getElements().size() > 0){
                    try {
                        hitCircleObstacle();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    anim_timer.stop();
                }else if(((Path)Shape.intersect(ball,line1)).getElements().size() > 0|| ((Path)Shape.intersect(ball,line2)).getElements().size() > 0 ||((Path)Shape.intersect(ball,line3)).getElements().size() > 0||((Path)Shape.intersect(ball,line4)).getElements().size() > 0){
                    try {
                        hitplusObstacle(line1,line2,line3,line4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    anim_timer.stop();
                }else if(((Path)Shape.intersect(ball,arc11)).getElements().size() > 0|| ((Path)Shape.intersect(ball,arc21)).getElements().size() > 0 ||((Path)Shape.intersect(ball,arc31)).getElements().size() > 0||((Path)Shape.intersect(ball,arc41)).getElements().size() > 0 || ((Path)Shape.intersect(ball,arc12)).getElements().size() > 0|| ((Path)Shape.intersect(ball,arc22)).getElements().size() > 0 ||((Path)Shape.intersect(ball,arc32)).getElements().size() > 0||((Path)Shape.intersect(ball,arc42)).getElements().size() > 0){
                    try {
                        hitDoubleCircle(arc11,arc21,arc31,arc41,arc12,arc22,arc32,arc42);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    anim_timer.stop();
                }else if(((Path)Shape.intersect(ball,arcd1)).getElements().size() > 0|| ((Path)Shape.intersect(ball,arcd2)).getElements().size() > 0 ||((Path)Shape.intersect(ball,arcd3)).getElements().size() > 0||((Path)Shape.intersect(ball,arcd4)).getElements().size() > 0 || ((Path)Shape.intersect(ball,arcd5)).getElements().size() > 0|| ((Path)Shape.intersect(ball,arcd6)).getElements().size() > 0 ||((Path)Shape.intersect(ball,arcd7)).getElements().size() > 0||((Path)Shape.intersect(ball,arcd8)).getElements().size() > 0){
                    try {
                        hitDoubleCircle(arcd1,arcd2,arcd3,arcd4,arcd5,arcd6,arcd7,arcd8);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    anim_timer.stop();
                }else if(((Path)Shape.intersect(ball,sqLine1)).getElements().size() > 0|| ((Path)Shape.intersect(ball,sqLine2)).getElements().size() > 0 ||((Path)Shape.intersect(ball,sqLine3)).getElements().size() > 0||((Path)Shape.intersect(ball,sqLine4)).getElements().size() > 0){
                    try {
                        hitplusObstacle(sqLine1,sqLine2,sqLine3,sqLine4);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    anim_timer.stop();
                }
            }
        };
        anim_timer.start();
    }

    @FXML
    public void pause(MouseEvent actionEvent) throws Exception {
        anim_timer.stop();
        updateData();
        updateArrayList();
        ArrayList<Double> ballColour = new ArrayList<>();
        Color ballC = (Color) ball.getFill();

//        System.out.println(ballC.getRed());
//        System.out.println(ballC.getGreen());
//        System.out.println(((Color) ball.getFill()).getBlue());
        ballColour.add(ballC.getRed());
        ballColour.add(ballC.getGreen());
        ballColour.add(ballC.getBlue());
        DataStore dataStore = new DataStore(obstacles,colorSwitchList,starsList,ball.getLayoutX(),ball.getLayoutY(),ballColour);
        dataStore.setCurrentStars(starCollected);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pause Menu.fxml"));
        AnchorPane panez =fxmlLoader.load();
        PauseMenuController controller = fxmlLoader.<PauseMenuController>getController();
        controller.initData(dataStore);
        gamePlayPane.getChildren().setAll(panez);

    }



    @FXML
    EventHandler<KeyEvent> ballHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            if(keyEvent.getCode()== KeyCode.SPACE){
                ball.setLayoutY(ball.getLayoutY()-40);
            }
        }
    };

    @FXML
    public void ballMovement(){

        ball.setLayoutY(ball.getLayoutY()+1.5);



    }

    @FXML
    public void upBallMovement(MouseEvent actionEvent) throws Exception{
        ball.setLayoutY(ball.getLayoutY()-40);

    }

    public void updateScore(){
        scoreText.setText(String.valueOf(starCollected));
    }

    public void changeColorOfBall(){
        Random random = new Random();
        int randInt = random.nextInt(4);

        while (randInt == 0 || randInt == currentBallColor){
            randInt = random.nextInt(4);
        }
        if(randInt == 1){
            ball.setFill(Color.rgb(31,255,59));
            currentBallColor = 1;
        }else if(randInt == 2){
            ball.setFill(Color.rgb(243,255,31));
            currentBallColor = 2;
        }else if(randInt == 3){
            ball.setFill(Color.rgb(57,31,255));
            currentBallColor = 3;
        }else if(randInt == 4){
            ball.setFill(Color.rgb(255,33,81));
            currentBallColor = 4;
        }


    }

    boolean colourCompare(Color c, Color c1) {
        return c.getBlue() == c1.getBlue() && c.getGreen() == c1.getGreen() && c.getRed() == c1.getRed();
    }


    public void hitCircleObstacle() throws Exception{
        Paint ballPaint;
        Color ballColour;
        ballPaint = ball.getFill();
        ballColour = (Color)ballPaint;
        Color arc1Colour = (Color)arc1.getFill();
        Color arc2Colour = (Color)arc2.getFill();
        Color arc3Colour = (Color)arc3.getFill();
        Color arc4Colour = (Color)arc4.getFill();

        if((!colourCompare(ballColour,arc4Colour) && ((Path)Shape.intersect(ball,arc4)).getElements().size() > 0) || (((Path)Shape.intersect(ball,arc1)).getElements().size() > 0 && !colourCompare(ballColour,arc1Colour)) || (((Path)Shape.intersect(ball,arc2)).getElements().size() > 0  && !colourCompare(ballColour,arc2Colour)) || (((Path)Shape.intersect(ball,arc3)).getElements().size() > 0 && !colourCompare(ballColour,arc3Colour))){
            updateData();
            updateArrayList();
            anim_timer.stop();
            loadHitMenu();
        }
    }

    public void hitplusObstacle(Line lf1,Line lf2,Line lf3,Line lf4) throws Exception{
        Paint ballPaint;
        Color ballColour;
        ballPaint = ball.getFill();
        ballColour = (Color)ballPaint;
        Color arc1Colour = (Color)lf1.getFill();
        Color arc2Colour = (Color)lf2.getFill();
        Color arc3Colour = (Color)lf3.getFill();
        Color arc4Colour = (Color)lf4.getFill();

        if((!colourCompare(ballColour,arc4Colour) && ((Path)Shape.intersect(ball,lf4)).getElements().size() > 0) || (((Path)Shape.intersect(ball,lf1)).getElements().size() > 0 && !colourCompare(ballColour,arc1Colour)) || (((Path)Shape.intersect(ball,lf2)).getElements().size() > 0  && !colourCompare(ballColour,arc2Colour)) || (((Path)Shape.intersect(ball,lf3)).getElements().size() > 0 && !colourCompare(ballColour,arc3Colour))){
            updateData();
            updateArrayList();
            anim_timer.stop();
            loadHitMenu();
        }
    }

    public void hitDoubleCircle(Arc arcf1, Arc arcf2, Arc arcf3, Arc arcf4, Arc arcf5, Arc arcf6, Arc arcf7, Arc arcf8) throws Exception{
        Paint ballPaint;
        Color ballColour;
        ballPaint = ball.getFill();
        ballColour = (Color)ballPaint;
        Color arcf1Colour = (Color)arcf1.getFill();
        Color arcf2Colour = (Color)arcf2.getFill();
        Color arcf3Colour = (Color)arcf3.getFill();
        Color arcf4Colour = (Color)arcf4.getFill();
        Color arcf5Colour = (Color)arcf5.getFill();
        Color arcf6Colour = (Color)arcf6.getFill();
        Color arcf7Colour = (Color)arcf7.getFill();
        Color arcf8Colour = (Color)arcf8.getFill();

        if((!colourCompare(ballColour,arcf1Colour) && ((Path)Shape.intersect(ball,arcf1)).getElements().size() > 0) || (((Path)Shape.intersect(ball,arcf2)).getElements().size() > 0 && !colourCompare(ballColour,arcf2Colour)) || (((Path)Shape.intersect(ball,arcf3)).getElements().size() > 0  && !colourCompare(ballColour,arcf3Colour)) || (((Path)Shape.intersect(ball,arcf4)).getElements().size() > 0 && !colourCompare(ballColour,arcf4Colour)) || (!colourCompare(ballColour,arcf5Colour) && ((Path)Shape.intersect(ball,arcf5)).getElements().size() > 0) || (((Path)Shape.intersect(ball,arcf6)).getElements().size() > 0 && !colourCompare(ballColour,arcf6Colour)) || (((Path)Shape.intersect(ball,arcf7)).getElements().size() > 0  && !colourCompare(ballColour,arcf7Colour)) || (((Path)Shape.intersect(ball,arcf8)).getElements().size() > 0 && !colourCompare(ballColour,arcf8Colour))){
            updateData();
            updateArrayList();
            anim_timer.stop();
            loadHitMenu();
        }
    }

    public void loadHitMenu() throws IOException {


        updateData();
        updateArrayList();
        ArrayList<Double> ballColour = new ArrayList<>();
        Color ballC = (Color) ball.getFill();
        ballColour.add(ballC.getRed());
        ballColour.add(ballC.getGreen());
        ballColour.add(ballC.getBlue());
        DataStore dataStore = new DataStore(obstacles,colorSwitchList,starsList,ball.getLayoutX(),ball.getLayoutY(),ballColour);
        dataStore.setCurrentStars(starCollected);

        Main.getCurrentDatabase().setBestScore(starCollected);


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Hit Menu.fxml"));
        AnchorPane panez =fxmlLoader.load();
        HitMenuController controller = fxmlLoader.<HitMenuController>getController();
        controller.initData(dataStore);
        gamePlayPane.getChildren().setAll(panez);
    }

    public void ballStarSwitchCollision(){
        if(ball.getBoundsInParent().intersects(colorSwitcher.getBoundsInParent())){
            colorSwitcher.setVisible(false);
            colorSwitcher.relocate(colorSwitcher.getLayoutX()+100,colorSwitcher.getLayoutY());
            changeColorOfBall();
        }else if (ball.getBoundsInParent().intersects(colorSwitcher1.getBoundsInParent())){
            colorSwitcher1.setVisible(false);
            colorSwitcher1.relocate(colorSwitcher1.getLayoutX()+100,colorSwitcher1.getLayoutY());
            changeColorOfBall();
        }else if (ball.getBoundsInParent().intersects(colorSwitcher2.getBoundsInParent())){
            colorSwitcher2.setVisible(false);
            colorSwitcher2.relocate(colorSwitcher2.getLayoutX()+100,colorSwitcher2.getLayoutY());
            changeColorOfBall();
        }else if (ball.getBoundsInParent().intersects(colorSwitcher3.getBoundsInParent())){
            colorSwitcher3.setVisible(false);
            colorSwitcher3.relocate(colorSwitcher3.getLayoutX()+100,colorSwitcher3.getLayoutY());
            changeColorOfBall();
        }else if (ball.getBoundsInParent().intersects(colorSwitcher4.getBoundsInParent())){
            colorSwitcher4.setVisible(false);
            colorSwitcher4.relocate(colorSwitcher4.getLayoutX()+100,colorSwitcher4.getLayoutY());
            changeColorOfBall();
        }else if(ball.getBoundsInParent().intersects(star0.getBoundsInParent())){
            star0.setVisible(false);
            star0.relocate(star0.getLayoutX()+100,star0.getLayoutY());
            starCollected += 1;
            Main.getCurrentDatabase().setTotalStar(Main.getCurrentDatabase().getTotalStar()+1);
            updateScore();
        }else if(ball.getBoundsInParent().intersects(star.getBoundsInParent())){
            star.setVisible(false);
            star.relocate(star.getLayoutX()+100,star.getLayoutY());
            starCollected += 1;
            Main.getCurrentDatabase().setTotalStar(Main.getCurrentDatabase().getTotalStar()+1);
            updateScore();
        }else if(ball.getBoundsInParent().intersects(star1.getBoundsInParent())){
            star1.setVisible(false);
            star1.relocate(star1.getLayoutX()+100,star1.getLayoutY());
            starCollected += 1;
            Main.getCurrentDatabase().setTotalStar(Main.getCurrentDatabase().getTotalStar()+1);
            updateScore();
        }else if(ball.getBoundsInParent().intersects(star2.getBoundsInParent())){
            star2.setVisible(false);
            star2.relocate(star2.getLayoutX()+100,star2.getLayoutY());
            starCollected += 1;
            Main.getCurrentDatabase().setTotalStar(Main.getCurrentDatabase().getTotalStar()+1);
            updateScore();
        }else if(ball.getBoundsInParent().intersects(star3.getBoundsInParent())){
            star3.setVisible(false);
            star3.relocate(star3.getLayoutX()+100,star3.getLayoutY());
            starCollected += 1;
            Main.getCurrentDatabase().setTotalStar(Main.getCurrentDatabase().getTotalStar()+1);
            updateScore();
        }

    }

    public void objectDownMovement(){
        if(ball.getBoundsInParent().intersects(invisibleLine.getBoundsInParent())){
            circleObs.setLayoutY(circleObs.getLayoutY() + 20);
            circleObs1.setLayoutY(circleObs1.getLayoutY() + 20);
            circleObs2.setLayoutY(circleObs2.getLayoutY() + 20);
            plusObstacle.setLayoutY(plusObstacle.getLayoutY() + 20);
            doubleCircle.setLayoutY(doubleCircle.getLayoutY() + 20);
            star0.setLayoutY(star0.getLayoutY()+20);
            star.setLayoutY(star.getLayoutY()+20);
            star1.setLayoutY(star1.getLayoutY()+20);
            star2.setLayoutY(star2.getLayoutY()+20);
            star3.setLayoutY(star3.getLayoutY()+20);
            colorSwitcher1.setLayoutY(colorSwitcher1.getLayoutY() + 20);
            colorSwitcher.setLayoutY(colorSwitcher.getLayoutY() + 20);
            colorSwitcher2.setLayoutY(colorSwitcher2.getLayoutY() + 20);
            colorSwitcher3.setLayoutY(colorSwitcher3.getLayoutY()+ 20);
            colorSwitcher4.setLayoutY(colorSwitcher4.getLayoutY() + 20);
            ball.setLayoutY(ball.getLayoutY() + 10);
            squareObs.setLayoutY(squareObs.getLayoutY()+20);
        }
    }

    public void objectRelocation(){
        if(colorSwitcher.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            colorSwitcher.relocate(colorSwitcher.getLayoutX()-120,colorSwitcher.getLayoutY());
            colorSwitcher.setVisible(true);
            colorSwitcher.setLayoutY(squareObs.getLayoutY()-270);
        }else if(colorSwitcher1.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            colorSwitcher1.relocate(colorSwitcher1.getLayoutX()-120,colorSwitcher1.getLayoutY());
            colorSwitcher1.setVisible(true);
            colorSwitcher1.setLayoutY(circleObs.getLayoutY()-200);
        }else if(colorSwitcher2.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            colorSwitcher2.relocate(colorSwitcher2.getLayoutX()-120,colorSwitcher2.getLayoutY());
            colorSwitcher2.setVisible(true);
            colorSwitcher2.setLayoutY(plusObstacle.getLayoutY()-200);
        }else if(colorSwitcher3.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            colorSwitcher3.relocate(colorSwitcher3.getLayoutX()-120,colorSwitcher3.getLayoutY());
            colorSwitcher3.setVisible(true);
            colorSwitcher3.setLayoutY(doubleCircle.getLayoutY()-200);
        }else if(colorSwitcher4.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            colorSwitcher4.relocate(colorSwitcher4.getLayoutX()-120,colorSwitcher4.getLayoutY());
            colorSwitcher4.setVisible(true);
            colorSwitcher4.setLayoutY(circleObs1.getLayoutY()-200);
        }else if(star0.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            star0.relocate(star0.getLayoutX()-100,star0.getLayoutY());
            star0.setVisible(true);
            star0.setLayoutY(squareObs.getLayoutY()-200);
        }else if(star.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            star.relocate(star.getLayoutX()-100,star.getLayoutY());
            star.setVisible(true);
            star.setLayoutY(circleObs.getLayoutY()-150);
        }else if(star1.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            star1.relocate(star1.getLayoutX()-100,star1.getLayoutY());
            star1.setVisible(true);
            star1.setLayoutY(plusObstacle.getLayoutY()-150);
        }else if(star2.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            star2.relocate(star2.getLayoutX()-100,star2.getLayoutY());
            star2.setVisible(true);
            star2.setLayoutY(doubleCircle.getLayoutY()-150);
        }else if(star3.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            star3.relocate(star3.getLayoutX()-100,star3.getLayoutY());
            star3.setVisible(true);
            star3.setLayoutY(circleObs1.getLayoutY()-150);
        }else if(circleObs.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            circleObs.setLayoutY(squareObs.getLayoutY()-400);
        }else if(plusObstacle.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            plusObstacle.setLayoutY(circleObs.getLayoutY()-400);
        }else if(doubleCircle.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            doubleCircle.setLayoutY(plusObstacle.getLayoutY()-500);
        }else if(circleObs1.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            circleObs1.setLayoutY(doubleCircle.getLayoutY()-400);
            circleObs2.setLayoutY(doubleCircle.getLayoutY()-400);
        }else if(squareObs.getBoundsInParent().intersects(obsLine.getBoundsInParent())){
            squareObs.setLayoutY(circleObs1.getLayoutY()-400);
        }
    }

    public double checkVisibile(Node n){
        if(n.isVisible()){
            return 1;
        }
        return 0;
    }
    public void updateArrayList(){
        obstacles.get(0).set(0,circleObstacle.getPosX());
        obstacles.get(0).set(1,circleObstacle.getPosY());
        obstacles.get(0).set(2,circleObstacle.getAngle());

        obstacles.get(1).set(0,pluObstacle.getPosX());
        obstacles.get(1).set(1,pluObstacle.getPosY());
        obstacles.get(1).set(2,pluObstacle.getAngle());

        obstacles.get(2).set(0,doubleCircleObstacle.getPosX());
        obstacles.get(2).set(1,doubleCircleObstacle.getPosY());
        obstacles.get(2).set(2,doubleCircleObstacle.getAngle());

        obstacles.get(3).set(0,circleObstacle1.getPosX());
        obstacles.get(3).set(1,circleObstacle1.getPosY());
        obstacles.get(3).set(2,circleObstacle1.getAngle());

        obstacles.get(4).set(0,circleObstacle2.getPosX());
        obstacles.get(4).set(1,circleObstacle2.getPosY());
        obstacles.get(4).set(2,circleObstacle2.getAngle());

        obstacles.get(5).set(0,squareObstacle.getPosX());
        obstacles.get(5).set(1,squareObstacle.getPosY());
        obstacles.get(5).set(2,squareObstacle.getAngle());

        colorSwitchList.get(0).add(colorSwitcher.getLayoutX());
        colorSwitchList.get(0).add(colorSwitcher.getLayoutY());
        colorSwitchList.get(0).add(checkVisibile(colorSwitcher));

        colorSwitchList.get(1).add(colorSwitcher1.getLayoutX());
        colorSwitchList.get(1).add(colorSwitcher1.getLayoutY());
        colorSwitchList.get(1).add(checkVisibile(colorSwitcher1));

        colorSwitchList.get(2).add(colorSwitcher2.getLayoutX());
        colorSwitchList.get(2).add(colorSwitcher2.getLayoutY());
        colorSwitchList.get(2).add(checkVisibile(colorSwitcher2));

        colorSwitchList.get(3).add(colorSwitcher3.getLayoutX());
        colorSwitchList.get(3).add(colorSwitcher3.getLayoutY());
        colorSwitchList.get(3).add(checkVisibile(colorSwitcher3));

        colorSwitchList.get(4).add(colorSwitcher4.getLayoutX());
        colorSwitchList.get(4).add(colorSwitcher4.getLayoutY());
        colorSwitchList.get(4).add(checkVisibile(colorSwitcher4));

        starsList.get(0).add(star.getLayoutX());
        starsList.get(0).add(star.getLayoutY());
        starsList.get(0).add(checkVisibile(star));

        starsList.get(1).add(star0.getLayoutX());
        starsList.get(1).add(star0.getLayoutY());
        starsList.get(1).add(checkVisibile(star0));

        starsList.get(2).add(star1.getLayoutX());
        starsList.get(2).add(star1.getLayoutY());
        starsList.get(2).add(checkVisibile(star1));

        starsList.get(3).add(star2.getLayoutX());
        starsList.get(3).add(star2.getLayoutY());
        starsList.get(3).add(checkVisibile(star2));

        starsList.get(4).add(star3.getLayoutX());
        starsList.get(4).add(star3.getLayoutY());
        starsList.get(4).add(checkVisibile(star3));





    }

    public void updateData(){

        circleObstacle.setPosX(circleObs.getLayoutX());
        circleObstacle.setPosY(circleObs.getLayoutY());
        circleObstacle.setAngle(circleObs.getRotate());

        circleObstacle1.setPosX(circleObs1.getLayoutX());
        circleObstacle1.setPosY(circleObs1.getLayoutY());
        circleObstacle1.setAngle(circleObs1.getRotate());

        circleObstacle2.setPosX(circleObs2.getLayoutX());
        circleObstacle2.setPosY(circleObs2.getLayoutY());
        circleObstacle2.setAngle(circleObs2.getRotate());

        doubleCircleObstacle.setPosX(doubleCircle.getLayoutX());
        doubleCircleObstacle.setPosY(doubleCircle.getLayoutY());
        doubleCircleObstacle.setAngle(doubleCircle.getRotate());

        pluObstacle.setPosX(plusObstacle.getLayoutX());
        pluObstacle.setPosY(plusObstacle.getLayoutY());
        pluObstacle.setAngle(plusObstacle.getRotate());

        squareObstacle.setPosX(squareObs.getLayoutX());
        squareObstacle.setPosY(squareObs.getLayoutY());
        squareObstacle.setAngle(squareObs.getRotate());
    }

    public void setLayoutObstacle(Node node, int num, ArrayList<ArrayList<Double>> obstaclesList){
        node.setLayoutX(obstaclesList.get(num).get(0));
        node.setLayoutY(obstaclesList.get(num).get(1));
        node.setRotate(obstaclesList.get(num).get(2));
    }

    public void setLayoutStarASwitch(ArrayList<ArrayList<Double>> starsLs,Node n, int num ){
        if(starsLs.get(num).get(2)==0) {
            n.setVisible(false);
        }
        n.setLayoutX(starsLs.get(num).get(0));
        n.setLayoutY(starsLs.get(num).get(1));

    }

}