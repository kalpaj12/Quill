import javafx.application.*;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.scene.*;
import javafx.scene.media.*;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.File;
import javafx.beans.property.*;


	public class Quill extends Application {

	public static void main(String[] args) {
	Application.launch(args);//args is already passed,change as required
	}
	
	@Override
	public void start(Stage stage) throws Exception {

	Group group = new Group();
	Scene scene = new Scene(group,640,480);
	stage.setScene(scene);
	stage.setFullScreen(true);


	File file = new File("C:/Users/Kalpaj's PC/Desktop/test.mp4");
	Media media = new Media(file.toURI().toString());
	MediaPlayer mediaPlayer = new MediaPlayer(media);

	Button playButton = new Button("Play");
	Button pauseButton = new Button("Pause");
	Button stopButton = new Button("Stop");

	playButton.setLayoutX(500);
	playButton.setLayoutY(730);

	pauseButton.setLayoutX(600);
	pauseButton.setLayoutY(730);

	stopButton.setLayoutX(700);
	stopButton.setLayoutY(730);

	playButton.addEventHandler(ActionEvent.ACTION, e -> {
	mediaPlayer.play();
	});

	pauseButton.addEventHandler(ActionEvent.ACTION, e -> {
	mediaPlayer.pause();
	});

	stopButton.addEventHandler(ActionEvent.ACTION, e -> {
	mediaPlayer.stop();
	});

	stage.setTitle("Quill");
	stage.setScene(scene);

	MediaView mediaView = new MediaView(mediaPlayer);
	((Group) scene.getRoot()).getChildren().add(mediaView);
	group.getChildren().addAll(playButton,pauseButton,stopButton);
	stage.show();
	}

}
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/media/MediaPlayer.html
