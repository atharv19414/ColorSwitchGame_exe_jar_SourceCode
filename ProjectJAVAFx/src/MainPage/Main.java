package MainPage;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    public static MediaPlayer mediaPlayer;
    private static Database currentDatabase;

    @Override
    public void start(Stage primaryStage) throws Exception{
        deserialize();
        addMusic();
        Parent mainPage = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene mainScene = new Scene(mainPage,450,700);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public void addMusic() {
        Media sound = new Media(getClass().getResource("/media/track.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static Database getCurrentDatabase() {
        return currentDatabase;
    }

    public static void serialize(){
        String filename = "saveGame.ser";

        try
        {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(currentDatabase);

            out.close();
            file.close();

        }

        catch(IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public static void deserialize() throws FileNotFoundException,ClassNotFoundException,IOException{
        currentDatabase = null;
        String filename = "saveGame.ser";
        try
        {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            currentDatabase = (Database) in.readObject();
            in.close();
            file.close();
        }

        catch(FileNotFoundException ex)
        {
            currentDatabase = new Database();
        }

        catch(NullPointerException ex)
        {
            currentDatabase = new Database();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }


}