package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Fx_Scene extends Application {

	static TreeBinarySearch<District> district = new TreeBinarySearch<>();
	District negativ;
	Location loc1;
	Scene choose;
	District toload;
	TNode<Location> loc;
	TNode<Date_Record> date;
	ImageView imag = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\plus.png");
	ImageView ubd = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\ubp.png");
	ImageView neg = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\neg.png");
	ImageView imag1 = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\nemer.jpeg");
	ImageView left = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\left.png");
 ImageView left1 = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\left.png");
  Alert alert1 = new Alert(AlertType.ERROR);
	ComboBox<String> districtComboBox;
	ComboBox<String> locationComboBox;

	public static TreeBinarySearch<District> getDistrict() {
		return district;
	}

	public static void setDistrict(TreeBinarySearch<District> district) {
		Fx_Scene.district = district;
	}


	public Pane getvBox(Stage primaryStage) {
		alert1.setTitle("Error Dialog");
		alert1.setHeaderText("the name of city is not valied");
		loc = district.root.getData().getLocation().root;
		
		 Button b1 = new Button("Choose to District screen");
	        b1.setShape(new javafx.scene.shape.Ellipse(85, 40)); // Creating an oval shape
	        b1.setMinSize(170, 80); 
	        b1.setMaxSize(170, 80);
	        b1.setLayoutX(100);
	        b1.setLayoutY(20);
	       
	        b1.setStyle("-fx-background-color: #B0BEC5; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");

	     

		Button b2 = new Button("Choose to location screne");
		   b2.setShape(new javafx.scene.shape.Ellipse(85, 40)); // Creating an oval shape
	        b2.setMinSize(170, 80); 
	        b2.setMaxSize(170, 80);
	        b2.setLayoutX(100);
	        b2.setLayoutY(120);
	       
	        b2.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");

	     
		Button b3 = new Button("Choose to martyr screne");
		   b3.setShape(new javafx.scene.shape.Ellipse(85, 40)); // Creating an oval shape
	        b3.setMinSize(170, 80); 
	        b3.setMaxSize(170, 80);
	        b3.setLayoutX(100);
	        b3.setLayoutY(220);
	       
	        b3.setStyle("-fx-background-color: #E0E0E0; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");


	     
		Button b4 = new Button("Load to file");
		
		b4.setShape(new javafx.scene.shape.Ellipse(85, 40)); // Creating an oval shape
        b4.setMinSize(170, 80); 
        b4.setMaxSize(170, 80);
        b4.setLayoutX(100);
        b4.setLayoutY(320);
		
		
		
		
		
		
		b4.setStyle("-fx-background-color: #F0F0F0; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");

		imag1.setFitWidth(800);
		imag1.setFitHeight(450);
		Pane v2 = new Pane();
		
		v2.getChildren().addAll(b1, b2, b3, b4);
		
	
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("please enter valid data ");
		alert.setContentText("Hello, World!");
		 String imagePath = "file:/C:/Users/HP/Pictures/Screenshots/nemer.jpeg";
	        Image image = new Image(imagePath);

	        BackgroundSize backgroundSize = new BackgroundSize(800, 800, false, false, false, false);
	        BackgroundImage backgroundImage = new BackgroundImage(image,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundRepeat.NO_REPEAT,
	                BackgroundPosition.DEFAULT,
	                backgroundSize);
	        
	        Background background = new Background(backgroundImage);   
	        v2.setBackground(background);
		
		
		
		
		
		choose = new Scene(v2, 800, 800);
		primaryStage.setScene(choose);
toload=district.root.getData();
		b1.setOnAction(e1 -> {
			District_Scene district1 = new District_Scene();
			district1.setDistrict(district);

			district1.abload();
			district1.setNegativ(district1.getQueue().getfront());

			TextField textField1 = new TextField();
			Label l1 = new Label("please Enter district");
			textField1.setPrefWidth(80);
			textField1.setPrefHeight(20);
			textField1.setPromptText("insert any text field");
			HBox h1 = new HBox();
			h1.setSpacing(10);
			h1.getChildren().addAll(textField1);
			VBox v1 = new VBox();
			v1.setSpacing(10);
			HBox root = new HBox();
			TextField textField = new TextField();
			textField.setPrefWidth(130);
			textField.setPromptText("insert any text field");
			Label ll = new Label("Please Enter name of District:");
			ll.setFont(new Font(22));
			root.getChildren().addAll(ll, textField);
			root.setSpacing(10);
			textField.setStyle("-fx-background-radius: 100em;");
			textField1.setPromptText("insert any text field");
			imag.setFitHeight(20);
			imag.setFitWidth(20);
			Button insert = new Button("insert a new District", imag);
			insert.setPrefWidth(180);
			insert.setPrefHeight(40);
			insert.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			VBox pane = new VBox();
			pane.setSpacing(20);
			root.setAlignment(Pos.CENTER);
			pane.setAlignment(Pos.CENTER);

			neg.setFitHeight(20);
			neg.setFitWidth(20);
			Button delet = new Button("Delet a new District", neg);
			delet.setPrefWidth(180);
			delet.setPrefHeight(40);
			delet.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			ComboBox<String> dist=new ComboBox<>();
			dist.setPromptText("choose any district");
			abloaddis(district.root, dist);
			Label hek=new Label("                                           ");
			HBox delete=new HBox();
			delete.getChildren().addAll(hek,delet,dist);
			delete.setSpacing(20);
			delete.setAlignment(Pos.CENTER);

			ubd.setFitHeight(20);
			ubd.setFitWidth(20);
			Button ubdat = new Button("Ubdate the District", ubd);
			ubdat.setPrefWidth(180);
			ubdat.setPrefHeight(40);
			ubdat.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			ImageView ent = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\enter.jpeg");
			ent.setFitHeight(20);
			ent.setFitWidth(20);
			Button enter = new Button("load", ent);
			enter.setPrefWidth(180);
			enter.setPrefHeight(40);
			enter.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			Label disply = new Label("number of martyr =");
			disply.setFont(new Font(15));
			Label nameof = new Label("Name of district:");
			nameof.setFont(new Font(20));
			HBox h2 = new HBox();

			Label nameofdistrict = new Label(district1.getNegativ().getName() + "");
			h2.setAlignment(Pos.CENTER);
			h2.getChildren().addAll(nameof, nameofdistrict);
			pane.getChildren().addAll(h2, root, insert, delete, ubdat, enter, disply);

			BorderPane porderPane = new BorderPane();
			porderPane.setCenter(pane);

			Button back = new Button("Back");
			porderPane.setTop(back);
			porderPane.setAlignment(back, Pos.CENTER);
			back.setOnAction(t -> {

				primaryStage.setScene(choose);

			});

			left.setFitHeight(30);
			left.setFitWidth(30);
			Button button = new Button("", left);
			porderPane.setLeft(button);
			porderPane.setAlignment(button, Pos.CENTER);
			Button button1 = new Button("", left1);
			left1.setFitHeight(30);
			left1.setFitWidth(30);
			button.setRotate(180);
			porderPane.setRight(button1);
			porderPane.setAlignment(button1, Pos.CENTER);

			disply.setText("number of martyr = " + district1.number_of_martyr(district1.getNegativ()) + "");
			button1.setOnAction(e2 -> {
				District d1 = district1.next();
				if (d1 != null) {
					district1.setNegativ(d1);
					nameofdistrict.setText(district1.getNegativ().getName() + "");
					disply.setText("number of martyr = " + district1.number_of_martyr(district1.getNegativ()) + "");
				}

			});
			button.setOnAction(e2 -> {
				District d1 = district1.prev();
				if (d1 != null) {
					district1.setNegativ(d1);
					nameofdistrict.setText(district1.getNegativ().getName() + "");
					disply.setText("number of martyr = " + district1.number_of_martyr(district1.getNegativ()) + "");
				}

			});

			enter.setOnAction(e2 -> {
				try {
					toload=district1.getNegativ();
					loc = district1.getNegativ().getLocation().root;
					
				
				} catch (Exception e) {
					date = null;
				}

			});
			insert.setOnAction(e2 -> {
				if (textField.getText() != "") {
					district1.addDistrict(textField.getText());
					district1.setQueue(new Queue<>());
					district1.setStack(new Stack_Linked_list<>());
					district1.abload();
					district1.fromto();
					textField.setText("");
					dist.getItems().clear();
                    abloaddis(district.getRoot(), dist);
					return;
				}
				alert.showAndWait();
			});

			delet.setOnAction(e2 -> {
				if (dist.getValue() !=null) {
					District d;
					try {
						d = district1.deletDistrict(dist.getValue());
						dist.getItems().clear();
                        abloaddis(district.getRoot(), dist);
					} catch (Exception e) {
						alert1.showAndWait();
						return;
					}

					if (d.getName().equals(district1.getNegativ().getName())) {
						District d1 = district1.getQueue().dequeue();
						
						if (district1.getQueue().getfront() == null) {
							district1.prev();
						}

						district1.setNegativ(district1.getQueue().getfront());
						
						nameofdistrict.setText(district1.getNegativ().getName() + "");
						disply.setText("number of martyr = " + district1.number_of_martyr(district1.getNegativ()) + "");
						if(toload.equals(d))
						{
							toload=district1.getNegativ();
							loc = district1.getNegativ().getLocation().root;
						}
						textField.setText("");
						return;
					}
					district1.setQueue(new Queue<>());
					district1.setStack(new Stack_Linked_list<>());
					district1.abload();
					district1.fromto();
					textField.setText("");
				}
				else {
				
					alert1.show();
				}
			});
			  
			porderPane.setStyle("-fx-background-color: #B0BEC5; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
			Scene choosee = new Scene(porderPane, 800, 800);
			ubdat.setOnAction(e2 -> {

				ComboBox<String> districtComboBox1 = new ComboBox<>();

				districtComboBox1.setPromptText("Old city name");

				abloaddis(district.root, districtComboBox1);
				TextField t2 = new TextField();

				t2.setPromptText("New city name");
				Button B1 = new Button("Ubdate");
				HBox ubdate = new HBox(districtComboBox1, t2);
				ubdate.setAlignment(Pos.CENTER);
				ubdate.setSpacing(10);
				VBox vv = new VBox(ubdate, B1);
				vv.setAlignment(Pos.CENTER);
				vv.setSpacing(20);
				Button back1 = new Button("Back");
				BorderPane bordar = new BorderPane();
				bordar.setTop(back1);
				bordar.setAlignment(back1, Pos.CENTER);
				bordar.setCenter(vv);
				bordar.setAlignment(bordar, Pos.CENTER);
				
				Scene choose1 = new Scene(bordar, 800, 800);
				primaryStage.setScene(choose1);
				primaryStage.show();
				B1.setOnAction(r -> {
					if (districtComboBox1.getValue() != null && t2.getText() != "") {
						if (district1.ubdate(districtComboBox1.getValue(), t2.getText().trim()) == true) {
							district1.setQueue(new Queue<>());
							district1.setStack(new Stack_Linked_list<>());
							district1.abload();
							district1.setNegativ(district1.getQueue().getfront());
							nameofdistrict.setText(district1.getNegativ().getName());
							// district1.fromto();
							textField.setText("");
							districtComboBox1.getItems().clear();
							districtComboBox1.setPromptText("Old city name");
							abloaddis(district.root, districtComboBox1);
							dist.getItems().clear();
	                        abloaddis(district.getRoot(), dist);
							return;
						}
						
						alert1.show();
					}
				});
				back1.setOnAction(e3 -> {
					primaryStage.setScene(choosee);

				});
			});	
			primaryStage.setScene(choosee);
		});
		b2.setOnAction(r -> {
			Location_Scene loction = new Location_Scene();
			loction.setLocation(toload.getLocation().root);
			loction.abload();
			loction.setNegativ(loction.getQueue().getfront());
			TextField textField1 = new TextField();
			Label l1 = new Label("please Enter Location");
			textField1.setPrefWidth(80);
			textField1.setPrefHeight(20);
			textField1.setPromptText("insert any text field");
			HBox h1 = new HBox();
			h1.setSpacing(10);
			h1.getChildren().addAll(textField1);
			VBox v1 = new VBox();
			v1.setSpacing(10);
			HBox root = new HBox();
			TextField textField = new TextField();
			textField.setPrefWidth(130);
			textField.setPrefHeight(40);
			textField.setPromptText("insert any text field");
			Label ll = new Label("Please Enter name of Location:");
			ll.setFont(new Font(22));
			root.getChildren().addAll(ll, textField);
			root.setSpacing(10);
			textField.setStyle("-fx-background-radius: 100em;");
			textField1.setPromptText("insert any text field");
			imag.setFitHeight(20);
			imag.setFitWidth(20);
			Button insert = new Button("insert a new Location", imag);
			insert.setPrefWidth(180);
			insert.setPrefHeight(40);
			insert.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			VBox pane = new VBox();
			pane.setSpacing(20);
			root.setAlignment(Pos.CENTER);
			pane.setAlignment(Pos.CENTER);
			ImageView neg = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\neg.png");
			neg.setFitHeight(20);
			neg.setFitWidth(20);
			Button delet = new Button("Delet a new Location", neg);
			delet.setPrefWidth(180);
			delet.setPrefHeight(40);
			delet.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			ComboBox<String> dist=new ComboBox<>();
			dist.setPrefWidth(140);
			dist.setPromptText("choose any location");
			abload(toload.getLocation().root, dist);
			Label hek=new Label("                                          ");
			HBox delete=new HBox();
			delete.getChildren().addAll(hek,delet,dist);
			delete.setSpacing(20);
			delete.setAlignment(Pos.CENTER);
			ImageView ubd = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\ubp.png");
			ubd.setFitHeight(20);
			ubd.setFitWidth(20);
			Button ubdat = new Button("Ubdate the Location", ubd);
			ubdat.setPrefWidth(180);
			ubdat.setPrefHeight(40);
			ubdat.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			ImageView ent = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\enter.jpeg");
			ent.setFitHeight(20);
			ent.setFitWidth(20);
			Button enter = new Button("load", ent);
			enter.setPrefWidth(180);
			enter.setPrefHeight(40);
			enter.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			Label disply1 = new Label("The earliest date =");
			disply1.setFont(new Font(15));

			Label disply2 = new Label("The latest dates =");
			disply2.setFont(new Font(15));
			Label disply3 = new Label("Date of maximum number of martyrs =");
			disply3.setFont(new Font(15));
			Label nameof = new Label("Name of Location:");
			nameof.setFont(new Font(20));
			HBox h2 = new HBox();
			Label nameofdistrict1 = new Label("");
			try {
				nameofdistrict1.setText(loction.getNegativ().getNameofLocation() + "");
				disply1.setText("The earliest date =" + loction.old());
				disply2.setText("The latest date =" + loction.young());
				disply3.setText("Date of maximum number of martyrs =" + loction.max());

			} catch (Exception e1) {
				// TODO: handle exception
			}

			h2.setAlignment(Pos.CENTER);
			h2.getChildren().addAll(nameof, nameofdistrict1);
			pane.getChildren().addAll(h2, root, insert, delete, ubdat, enter, disply1, disply2, disply3);

			BorderPane porderPane = new BorderPane();
			porderPane.setCenter(pane);

			left.setFitHeight(30);
			left.setFitWidth(30);
			Button button = new Button("", left);
			porderPane.setLeft(button);
			porderPane.setAlignment(button, Pos.CENTER);
			Button back = new Button("Back");
			porderPane.setTop(back);
			porderPane.setAlignment(back, Pos.CENTER);
			Button button1 = new Button("", left1);
			left1.setFitHeight(30);
			left1.setFitWidth(30);
			button.setRotate(180);
			back.setOnAction(u -> {
				primaryStage.setScene(choose);
			});
			porderPane.setRight(button1);
			porderPane.setAlignment(button1, Pos.CENTER);
			loction.getLocation().traverceInOreder();
			if (loction.getLocation().root == null) {
				button.setDisable(true);
				button1.setDisable(true);
			}
			button1.setOnAction(e2 -> {

				Location d1 = loction.next();
				if (d1 != null) {
					loction.setNegativ(d1);
					nameofdistrict1.setText(loction.getNegativ().getNameofLocation() + "");
					disply1.setText("The earliest date =" + loction.old());
					disply2.setText("The latest date =" + loction.young());
					disply3.setText("Date of maximum number of martyrs =" + loction.max());
				}
			});
			button.setOnAction(e2 -> {

				Location d1 = loction.prev();
				if (d1 != null) {
					loction.setNegativ(d1);
					nameofdistrict1.setText(loction.getNegativ().getNameofLocation() + "");

					disply1.setText("The earliest date =" + loction.old());
					disply2.setText("The latest date =" + loction.young());
					disply3.setText("Date of maximum number of martyrs =" + loction.max());

				}

			});
			insert.setOnAction(e2 -> {

				if (textField.getText() != "") {

					if (toload.getLocation().getRoot() != null) {
						loction.addLocation(textField.getText());
						loction.setQueue(new Queue<>());
						loction.setStack(new Stack_Linked_list<>());
						loction.abload();
						try {
							loction.fromto();
						} catch (Exception e1) {
							// TODO: handle exception
						}
						textField.setText("");

					} else {
						TNode<Location> tn = new TNode<>();
						Location newn = new Location();
						newn.setNameofLocation(textField.getText().trim());
						tn.setData(newn);
						loc = tn;
						toload.getLocation().insert(loc.getData());
						textField.setText("");
						loction.setLocation(toload.getLocation().root);
						loction.abload();
						loction.setNegativ(loc.getData());
						nameofdistrict1.setText(loction.getNegativ().getNameofLocation() + "");
						button.setDisable(false);
						button1.setDisable(false);

					}
					dist.getItems().clear();					
                    abload(toload.getLocation().root, dist);
					return;

				}
				alert1.showAndWait();
			});
			enter.setOnAction(t -> {
				loc1 = loction.getNegativ();
				date = loction.getNegativ().get_martyr_date().root;

			});
			porderPane.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-border-color: black; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
			Scene loct = new Scene(porderPane, 800, 800);
			primaryStage.setScene(loct);
			delet.setOnAction(e2 -> {
				if (dist.getValue() != null) {

					Location d;
					try {
						d = loction.deletLocation(dist.getValue());
						toload.getLocation().root=loction.getLocation().root;
						dist.getItems().clear();
                        abload(toload.getLocation().root, dist);
					} catch (Exception e) {
						alert1.setHeaderText("Plese enter location name");
						alert1.showAndWait();
						return;
					}

					if (d.getNameofLocation().toLowerCase().equals(loction.getNegativ().getNameofLocation().toLowerCase())) {
						Location d1 = loction.getQueue().dequeue();
						if (loction.getQueue().getfront() == null) {
							loction.prev();
						}
						loction.setNegativ(loction.getQueue().getfront());
						try {
							nameofdistrict1.setText(loction.getNegativ().getNameofLocation() + "");
							disply1.setText("The earliest date =" + loction.old());
							disply2.setText("The latest date =" + loction.young());
							disply3.setText("Date of maximum number of martyrs =" + loction.max());
						} catch (Exception em) {
							nameofdistrict1.setText("");
						}
						textField.setText("");
						if (loction.getLocation().root == null) {
							button.setDisable(true);
							button1.setDisable(true);
						}
						
						if(d.equals(loc1))
						{
							loc1 = loction.getNegativ();
							date = loction.getNegativ().get_martyr_date().root;
						}
						return;
					}
					
					if(d.equals(loc1))
					{
						loc1 = loction.getNegativ();
						date = loction.getNegativ().get_martyr_date().root;
					}
					loction.setQueue(new Queue<>());
					loction.setStack(new Stack_Linked_list<>());
					loction.abload();
					try {
						loction.fromto();
					} catch (Exception e1) {

					}
					textField.setText("");
				} else {
					alert1.setHeaderText("the data is not valid");
					alert1.show();
				}
			});

			ubdat.setOnAction(e2 -> {
				ComboBox<String> dis = new ComboBox<>();
				dis.setPromptText("Old city name");
				TextField t2 = new TextField();
				abload(loction.getLocation().root, dis);
				t2.setPromptText("New city name");
				Button B1 = new Button("Ubdate");
				HBox ubdate = new HBox(dis, t2);
				ubdate.setAlignment(Pos.CENTER);
				ubdate.setSpacing(10);
				VBox vv = new VBox(ubdate, B1);
				vv.setAlignment(Pos.CENTER);
				vv.setSpacing(20);
				Button back1 = new Button("Back");
				BorderPane bordar = new BorderPane();
				bordar.setTop(back1);
				bordar.setAlignment(back, Pos.CENTER);
				bordar.setAlignment(back1, Pos.CENTER);

				bordar.setCenter(vv);
				bordar.setAlignment(bordar, Pos.CENTER);
				Scene choose1 = new Scene(bordar, 800, 800);
				primaryStage.setScene(choose1);
				primaryStage.show();

				B1.setOnAction(r1 -> {

					if (dis.getValue() != null && t2.getText() != "") {

						if (loction.ubdate(dis.getValue().trim(), t2.getText().trim()) == true) {

							loction.setQueue(new Queue<>());
							loction.setStack(new Stack_Linked_list<>());
							loction.abload();
							loction.setNegativ(loction.getQueue().getfront());
							nameofdistrict1.setText(loction.getNegativ().getNameofLocation());
							// district1.fromto();
							t2.setText("");
							dis.getItems().clear();
							dis.setPromptText("Old city name");
							abload(toload.getLocation().root, dis);
							dist.getItems().clear();
			                abload(toload.getLocation().root, dist);
							return;
						}

					}
					alert1.setHeaderText("the data is not valid");
					alert1.show();
				});
				
				back1.setOnAction(e3 -> {
					primaryStage.setScene(loct);

				});
			});

		});
		b3.setOnAction(e3 -> {
			if(date==null) {
				try {
					date = toload.getLocation().getRoot().getData().get_martyr_date().root;	
				}catch (Exception e) {
					// TODO: handle exception
				}
			
			}
			
			Date_scene date1 = new Date_scene();
			date1.setDate(date);
			try {
				date1.abload();

			} catch (Exception er) {
				
			}
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(20));
			grid.setHgap(10);
			grid.setVgap(10);

			Label nameLabel = new Label("Name:");
			TextField nameField = new TextField();
			nameField.setPromptText("Enter name");

			Label ageLabel = new Label("Age:");
			ComboBox<Integer> ageComboBox = new ComboBox<>();
			for (int i = 0; i < 120; i++) {
				ageComboBox.getItems().add(i);
			}
			ageComboBox.setPromptText("Select age");
			ageComboBox.setValue(10);

			Label genderLabel = new Label("Gender:");
			ToggleGroup genderToggleGroup = new ToggleGroup();
			RadioButton maleRadioButton = new RadioButton("Male");
			maleRadioButton.setToggleGroup(genderToggleGroup);
			RadioButton femaleRadioButton = new RadioButton("Female");
			femaleRadioButton.setToggleGroup(genderToggleGroup);
			HBox genderBox = new HBox(10, maleRadioButton, femaleRadioButton);
			maleRadioButton.setSelected(true);
			Label dateLabel = new Label("Date:");
			DatePicker datePicker = new DatePicker();

			Label districtLabel = new Label("District:");
//				districtComboBox = new ComboBox<>();
//
//				districtComboBox.setPromptText("Select district");
//				Label locationLabel = new Label("Location:");
//				locationComboBox = new ComboBox<>();
//				locationComboBox.setPromptText("Select location");
//				abloaddis(district.root, districtComboBox);
//
//				districtComboBox.setOnAction(event -> {
//					District locat = new District();
//					locationComboBox.getItems().clear();
//					locat.setName(districtComboBox.getValue().trim());
//					TNode<District> tn = district.find(locat);
//
//					if (tn != null) {
//						abload(tn.getData().getLocation().root, locationComboBox);
//					}
//				});
			grid.addColumn(0, nameLabel, ageLabel, genderLabel, dateLabel);
			grid.addColumn(1, nameField, ageComboBox, genderBox, datePicker);
			VBox v1 = new VBox();
			v1.setSpacing(10);
			HBox root = new HBox();

			imag.setFitHeight(20);
			imag.setFitWidth(20);
			Button insert = new Button("insert a new Martyr", imag);
			insert.setPrefWidth(180);
			insert.setPrefHeight(40);
			insert.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			VBox pane = new VBox();
			pane.setSpacing(20);
			Label l1 = new Label("The Date");
			try {
				l1.setText(("The Date :" + date.getData().getDate()));

				l1.setFont(new Font(20));
			} catch (Exception e1) {
				// TODO: handle exception
			}

			l1.setFont(new Font(20));

			root.setAlignment(Pos.CENTER);
			pane.setAlignment(Pos.CENTER);
			ImageView neg = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\neg.png");
			neg.setFitHeight(20);
			neg.setFitWidth(20);
			Button delet = new Button("Delet Martyr", neg);
			delet.setPrefWidth(180);
			delet.setPrefHeight(40);
			delet.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			ImageView ubd = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\ubp.png");
			ubd.setFitHeight(20);
			ubd.setFitWidth(20);
			Button ubdat = new Button("Ubdate the Martyr", ubd);
			ubdat.setPrefWidth(180);
			ubdat.setPrefHeight(40);
			ubdat.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");

			ImageView ent = new ImageView("File:C:\\Users\\HP\\Pictures\\Screenshots\\enter.jpeg");
			ent.setFitHeight(20);
			ent.setFitWidth(20);
			Button enter = new Button("search", ent);
			enter.setPrefWidth(180);
			enter.setPrefHeight(40);
			enter.setStyle(
					"-fx-shape: 'M50 0 A50 50 0 1 0 100 50 A50 50 0 1 0 50 100 A50 50 0 1 0 0 50 A50 50 0 1 0 50 0 Z';");
			grid.setAlignment(Pos.CENTER);
			Label disply1 = new Label("Avg ages :");
			Label disply2 = new Label("The youngest :");
			Label disply3 = new Label("The oldest :");
			TableView<Martyr> table = new TableView<>();
			TableColumn<Martyr, String> nameColumn = new TableColumn<>("Name");
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			nameColumn.setPrefWidth(400);
			TableColumn<Martyr, Integer> ageColumn = new TableColumn<>("Age");
			ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
			ageColumn.setPrefWidth(100);
			TableColumn<Martyr, Character> genderColumn = new TableColumn<>("Gender");
			genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
			genderColumn.setPrefWidth(100);
			table.getColumns().addAll(nameColumn, ageColumn, genderColumn);
			table.setMaxWidth(600);
			pane.getChildren().addAll(l1, grid, insert, delet, enter, table, disply1, disply2, disply3);

			BorderPane porderPane = new BorderPane();
			porderPane.setCenter(pane);

			left.setFitHeight(30);
			left.setFitWidth(30);
			Button button = new Button("", left);
			porderPane.setLeft(button);
			porderPane.setAlignment(button, Pos.CENTER);
			Button back = new Button("Back");
			porderPane.setTop(back);
			porderPane.setAlignment(back, Pos.CENTER);
			Button button1 = new Button("", left1);
			left1.setFitHeight(30);
			left1.setFitWidth(30);
			button.setRotate(180);
			porderPane.setStyle("-fx-background-color: #E0E0E0; -fx-text-fill: black; -fx-border-color: transparent; -fx-border-radius: 50; -fx-background-radius: 50; -fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
			

		     

			insert.setOnAction(r -> {
				String name = nameField.getText().trim();
				if (name.equals("")) {
					alert1.show();
					return;
				}
				LocalDate d1 = datePicker.getValue();
				int age = ageComboBox.getValue();
				char gender;
				if (maleRadioButton.isSelected()) {
					gender = 'M';
				} else {
					gender = 'F';
				}
				Martyr m1 = new Martyr(name, age, gender);
				if (date1.getNegativ() != null) {
					District dd = new District();

					int year = d1.getYear();
					int moanth = d1.getMonthValue();
					int day = d1.getDayOfMonth();
					Date_Record date = new Date_Record(year, moanth, day);
					if (date1.getDate().find(date) == null) {
						date1.getDate().insert(date);
					}

					date1.getDate().find(date).getData().getMartyr().insert(m1);
					date1.setQueue(new Queue<>());
					date1.setStack(new Stack_Linked_list<>());
					date1.abload();
					
					date1.fromto();
					l1.setText("The date :" + date1.getNegativ().getDate());
					disply1.setText("The avg date =" + date1.avg());
					disply2.setText("The youngest :" + date1.youngest());
					disply3.setText("The oldest :" + date1.oldest());
					table.getItems().clear();
					date1.name(table);
					nameField.setText("");
					datePicker.setValue(null);
					ageComboBox.setValue(10);
				} else {
					try {
						int year = d1.getYear();
						int moanth = d1.getMonthValue();
						int day = d1.getDayOfMonth();
						Date_Record date2 = new Date_Record(year, moanth, day);
						date2.getMartyr().insert(m1);
						TNode<Date_Record> r1 = new TNode<>();
						r1.setData(date2);
						loc1.get_martyr_date().insert(date2);
						date1.setDate(loc1.get_martyr_date().getRoot());
						date1.abload();
						date1.setNegativ(date1.getQueue().getfront());
						l1.setText("The date :" + date1.getNegativ().getDate());
						disply1.setText("The avg date =" + date1.avg());
						disply2.setText("The youngest :" + date1.youngest());
						disply3.setText("The oldest :" + date1.oldest());
						date1.name(table);
						button.setDisable(false);
						button1.setDisable(false);
						nameField.setText("");
						datePicker.setValue(null);
						ageComboBox.setValue(10);	
					} catch (Exception e) {
						alert1.setHeaderText("the data is not valid");
						alert1.show();
					}

				}
			});
			Date_Record dd = date1.getQueue().getfront();
			date1.setNegativ(dd);
			if (dd != null) {

				l1.setText("The date :" + date1.getNegativ().getDate());
				disply1.setText("The avg date =" + date1.avg());
				disply2.setText("The youngest :" + date1.youngest());
				disply3.setText("The oldest :" + date1.oldest());

				date1.name(table);
			}
			button1.setOnAction(e2 -> {
				Date_Record d1 = date1.next();
				if (d1 != null) {
					table.getItems().clear();
					date1.setNegativ(d1);
					l1.setText("The date :" + date1.getNegativ().getDate());
					disply1.setText("The avg date =" + date1.avg());
					disply2.setText("The youngest :" + date1.youngest());
					disply3.setText("The oldest :" + date1.oldest());
					date1.name(table);

				}
			});
			button.setOnAction(e2 -> {
				Date_Record d1 = date1.prev();
				if (d1 != null) {
					table.getItems().clear();
					date1.setNegativ(d1);
					l1.setText("The date :" + date1.getNegativ().getDate());
					disply1.setText("The avg date =" + date1.avg());
					disply2.setText("The youngest :" + date1.youngest());
					disply3.setText("The oldest :" + date1.oldest());
					date1.name(table);

					
					
					
				}

			});
			delet.setOnAction(r -> {
			date1.prev();
			alert1.setHeaderText("the data is not valid");
				String name = nameField.getText().trim();
				if (name.equals("")) {
					
					alert1.show();
					return;
				}
				Martyr m1 = new Martyr();
				m1.setName(name);

				if (date1.deletmartyr(m1) == false) {
					alert1.show();
					return;
				}
				
				if(date1.getNegativ().getMartyr().getHead()==null)
				{
					Date_Record d1=date1.getNegativ();
					date1.setNegativ(date1.next());
					Date_Record d2=date1.getNegativ();
					if(d1==d2)
					{
			      		date1.setNegativ(date1.prev());
					}
				}
				date1.setQueue(new Queue<>());
				date1.setStack(new Stack_Linked_list<>());
				date1.abload();
				date1.fromto();
				l1.setText("The date :" + date1.getNegativ().getDate());
				disply1.setText("The avg date =" + date1.avg());
				disply2.setText("The youngest :" + date1.youngest());
				disply3.setText("The oldest :" + date1.oldest());
				table.getItems().clear();
				date1.name(table);
				nameField.setText("");
				datePicker.setValue(null);
				ageComboBox.setValue(10);
			});

			Scene scene = new Scene(porderPane, 800, 800);
			table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		           
				if (newValue != null) {
	              
	          
	                TextField t1=new TextField(newValue.getName());
	                ComboBox<Integer> age=new ComboBox<>();
	                for(int i=0;i<120;i++)
	                {
	                	age.getItems().add(i);
	                }
	                age.setValue(newValue.getAge());
	                RadioButton r1=new RadioButton("M");
	                RadioButton r2=new RadioButton("F");
	                ToggleGroup tog=new ToggleGroup();
	                r1.setToggleGroup(tog);
	                r2.setToggleGroup(tog);
	                if(newValue.getGender()=='m')
	                r1.setSelected(true);
	                else {
	                	r2.setSelected(true);
	                }
	              Button done=new Button("Ubdate");
	              
	              GridPane gg=new GridPane();
	              gg.add(new Label("the name"), 0, 0);
	              gg.add(t1, 1, 0);
	              gg.add(new Label("The Gender"), 0, 2);
	              gg.add(r1, 1, 2);
	              gg.add(r2, 2, 2);
	              gg.add(new Label("The age"), 0, 1);
	              gg.add(age, 1, 1);
	              gg.setAlignment(Pos.CENTER);
	              gg.setHgap(20);
	              gg.setVgap(20);
	              VBox vv=new VBox();
	              vv.getChildren().addAll(gg,done);
	              vv.setSpacing(20);
	              vv.setAlignment(Pos.CENTER);
	             Scene ss=new Scene(vv,800,800);
	             primaryStage.setScene(ss);
	              done.setOnAction(r->
	              {alert1.setHeaderText("the data is not valid");
	            	  if(t1.getText()=="")
	            	  {   alert1.show();
	            		  return;
	            	  }
	            	  newValue.setName(t1.getText().trim());
	            	
	            	  if(r1.isSelected())
	            	  {
	            		  newValue.setGender(r1.getText().charAt(0));
	            	  }else {
	            		  newValue.setGender(r2.getText().charAt(0));
	            	  }
	            	  
	            	  if(newValue.getAge()!=age.getValue())
	            	  {
	            		  Martyr m1=new Martyr();
	            		  m1.setAge(age.getValue());
	            		  m1.setName(t1.getText().trim());
	            		  if(r1.isSelected())
		            	  {
	            			  m1.setGender(r1.getText().toLowerCase().charAt(0));
		            	  }else {
		            		  System.out.println(r2.getText().toLowerCase().charAt(0));
		            		  m1.setGender(r2.getText().toLowerCase().charAt(0));
		            	  }
	            		  date1.getNegativ().getMartyr().delet(newValue);
	            		  date1.getNegativ().getMartyr().insert(m1);
	            		
	            		  
	            	  }else {
	            	  newValue.setAge(age.getValue());
	            	  
	            	 
	            	  
	            	  }
	            	  table.getItems().clear();
						l1.setText("The date :" + date1.getNegativ().getDate());
						disply1.setText("The avg date =" + date1.avg());
						disply2.setText("The youngest :" + date1.youngest());
						disply3.setText("The oldest :" + date1.oldest());
						date1.name(table); 	  
	            	
	            	  primaryStage.setScene(scene);
	              });
	              
	              
	                
	                
	                
	            }
			  });


			enter.setOnAction(m -> {
				alert1.setHeaderText("the data is not valid");
				if (nameField.getText().trim() == "") {
					alert1.show();
					return;
				}
				String name = nameField.getText().trim();
				table.getItems().clear();
				date1.Search(name, table);
				nameField.setText("");

			});

			back.setOnAction(u -> {
				primaryStage.setScene(choose);
			});

			porderPane.setRight(button1);
			porderPane.setAlignment(button1, Pos.CENTER);

			if (date1.getDate().getRoot() == null) {
				button.setDisable(true);
				button1.setDisable(true);
			}


			primaryStage.setScene(scene);

			primaryStage.setTitle("Watermarked Image Example");

		});

		b4.setOnAction(e -> {

			try {
				File f1 = new File("copyfile");
				PrintWriter p1 = new PrintWriter(f1);

				p1.write("Name,Date,Age,location,District,Gender");
				loadtofile(district.root, p1);
				p1.close();

			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		});
		return v2;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	}


	public static void main(String[] args) {
		launch(args);
	}

	private void abload(TNode<Location> root, ComboBox<String> t1) {
		if (root != null) {
			if (root.getLeft() != null)
				abload(root.getLeft(), t1);
			t1.getItems().add(root.getData().getNameofLocation());
			if (root.getRigth() != null)
				abload(root.getRigth(), t1);
		}

	}

	private void abloaddis(TNode<District> root, ComboBox<String> t1) {
		if (root != null) {
			if (root.getLeft() != null)
				abloaddis(root.getLeft(), t1);
			t1.getItems().add(root.getData().getName());

			if (root.getRigth() != null)
				abloaddis(root.getRigth(), t1);

		}

	}

	public void loadtofile(TNode<District> root, PrintWriter p1) {
		if (root != null) {
			if (root.getLeft() != null)
				loadtofile(root.getLeft(), p1);

			number_of_martyr(root.getData().getLocation().root, p1, root.getData());
			if (root.getRigth() != null)
				loadtofile(root.getRigth(), p1);
		}
	}

	private void number_of_martyr(TNode<Location> root, PrintWriter p1, District d1) {
		if (root != null) {
			if (root.getLeft() != null)
				number_of_martyr(root.getLeft(), p1, d1);
			getDate(root.getData().get_martyr_date().root, p1, d1, root.getData());
			if (root.getRigth() != null)
				number_of_martyr(root.getRigth(), p1, d1);

		}

	}

	private void getDate(TNode<Date_Record> root, PrintWriter p1, District d1, Location l1) {

		if (root != null) {
			if (root.getLeft() != null)
				getDate(root.getLeft(), p1, d1, l1);

			getmartyr(root.getData().getMartyr().getHead(), p1, d1, l1, root.getData());
			if (root.getRigth() != null)
				getDate(root.getRigth(), p1, d1, l1);
		}
	}

	private void getmartyr(Node<Martyr> node, PrintWriter p1, District d1, Location l1, Date_Record date) {
		for (; node != null; node = node.next) {
			p1.write("\n" + node.getData().getName() + "," + date.getDate() + "," + node.getData().getAge() + ","
					+ l1.getNameofLocation() + "," + d1.getName() + "," + node.getData().getGender());
			
			
		}
	}

}
