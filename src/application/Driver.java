package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Driver extends Application {
	static TreeBinarySearch<District> district = new TreeBinarySearch<>();
	@Override
	public void start(Stage primaryStage) throws Exception {

		 Button start = new Button();
	        start.setShape(new javafx.scene.shape.Rectangle(30, 80)); 
	        start.setMinSize(220, 100); 
	        start.setMaxSize(220, 100);
	        start.setLayoutX(300);
	        start.setLayoutY(350);
	        Image image = new Image("file:/C:/Users/HP/Pictures/Screenshots/nemer4.png"); 
	        
	        start.setGraphic(new ImageView(image));
	        start.setPrefSize(100, 50); 
	       

	        Pane stackpane = new Pane();
	        stackpane.getChildren().addAll(start);

	        String imagePath = "file:/C:/Users/HP/Pictures/Screenshots/nemer3.png";
	      

	        
	        
	        
	        

	        Scene choose = new Scene(stackpane, 800, 800);
	        primaryStage.setScene(choose);
	        primaryStage.show();
		      

		start.setOnAction(e -> {
			try {
				Scanner s1 = write(primaryStage);
				if (s1 == null) {
					return;
				}
				s1.nextLine();
				while (s1.hasNext()) {
					String[] part = s1.nextLine().split(",");
					if (part.length != 6)// to cheak the data is valid
						continue;
					try {
						Integer.parseInt(part[2]);
					} catch (Exception x) {
						part[2] = "0";
					}

					Martyr m1 = new Martyr(part[0].trim(), Integer.parseInt(part[2].trim()),
							part[5].toLowerCase().trim().charAt(0));

					District d1 = new District();
					d1.setName(part[4].trim());

					if (district.find(d1) == null) // to cheake the District is exist
					{
						district.insert(d1);
					}
					Location location = new Location();
					location.setNameofLocation(part[3].trim());
					d1 = district.find(d1).getData();
					if (d1.getLocation().find(location) == null)// to cheake the Location is exist
					{
						d1.getLocation().insert(location);
					}
					location = d1.getLocation().find(location).getData();

					int year = Integer.parseInt(part[1].split("/")[2]);
					int moanth = Integer.parseInt(part[1].split("/")[0]);
					int day = Integer.parseInt(part[1].split("/")[1]);

					Date_Record date = new Date_Record(year, moanth, day);

					if (location.get_martyr_date().find(date) == null)// to cheake the Location is exist
					{
						location.get_martyr_date().insert(date);

					}
					date = location.get_martyr_date().find(date).getData();
					date.getMartyr().insert(m1); // martyr.

				}

		

				Fx_Scene fx=new Fx_Scene();
				fx.setDistrict(district);
			    fx.getvBox(primaryStage);

			} catch (Exception e2) {
				// TODO: handle exception
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}



	public static Scanner write(Stage pri) throws FileNotFoundException {
		FileChooser filechoser = new FileChooser();
		File file = filechoser.showOpenDialog(pri);
		if (file == null || !file.getName().equals("data_2 (1).csv"))
			{
			Alert alert1=new Alert(AlertType.ERROR);
			alert1.setHeaderText("please enter valid data");
		alert1.show();
			return null;
			}
		Scanner s1 = new Scanner(file);
		return s1;
	}

}
