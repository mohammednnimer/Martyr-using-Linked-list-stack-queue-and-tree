package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class District_Scene extends Application {
	private TreeBinarySearch<District> district = new TreeBinarySearch<>();
	private Queue<District> queue = new Queue<>();
	private Stack_Linked_list<District> stack = new Stack_Linked_list<>();
	private District negativ;
	private Location loc;
	public Queue<District> getQueue() {
		return queue;
	}

	public void setQueue(Queue<District> queue) {
		this.queue = queue;
	}

	public Stack_Linked_list<District> getStack() {
		return stack;
	}

	public void setStack(Stack_Linked_list<District> stack) {
		this.stack = stack;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public District getNegativ() {
		return negativ;
	}

	public void setNegativ(District negativ) {
		this.negativ = negativ;
	}




	public Location getLoc() {
		return loc;
	}


	private Scene scene;

	@Override
	public void start(Stage primaryStage) throws IOException, Exception {

	}


	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public void fromto() {
		while (!queue.getfront().getName().equals(negativ.getName())) {
			stack.push(queue.dequeue());
		}
	}

	public TreeBinarySearch<District> getDistrict() {
		return district;
	}

	public void setDistrict(TreeBinarySearch<District> district1) {

		this.district = district1;
	}

	public int number_of_martyr(District d1) {

		Stack_Linked_list<Date_Record> date = new Stack_Linked_list<>();

		number_of_martyr(d1.getLocation().getRoot(), date);

		return number_of_martyr(date);
	}

	private int number_of_martyr(Stack_Linked_list<Date_Record> d1) {
		int sum = 0;

		while (d1.peek() != null) {

			Date_Record d2 = (Date_Record) d1.pop();
			sum += d2.getMartyr().length();

		}

		return sum;

	}

	private void number_of_martyr(TNode<Location> root, Stack_Linked_list date) {
		if (root != null) {
			if (root.getLeft() != null)
				number_of_martyr(root.getLeft(), date);
			loadtostack(root.getData().get_martyr_date().root, date);
			if (root.getRigth() != null)
				number_of_martyr(root.getRigth(), date);

		}

	}

	private void loadtostack(TNode root, Stack_Linked_list date) {

		if (root != null) {
			if (root.getLeft() != null)
				loadtostack(root.getLeft(), date);
			date.push(root.getData());
			if (root.getRigth() != null)
				loadtostack(root.getRigth(), date);
     	}
	}

	public  District next() {

		if (queue.getfront() == null) {
			return null;
		}

		District ddd = (District) queue.dequeue();

		if (queue.getfront() == null) {
			queue.enqueue(ddd);
			return null;
		}

		stack.push(ddd);
		District dd = (District) queue.getfront();
		return dd;

	}

	public District prev() {

		District dd = (District) stack.peek();
		if (dd == null) {
			return null;
		}
		insertAtBottom(queue, (District) stack.pop());
		return dd;

	}

	public static void insertAtBottom(Queue<District> queue, District data) {

		if (queue.isEmpty()) {
			queue.enqueue(data);
		} else {

			int size = queue.size();
			District[] temp = new District[size];
			for (int i = 0; i < size; i++) {
				temp[i] = (District) queue.dequeue();
			}

			queue.enqueue(data);

			for (int i = 0; i < size; i++) {
				queue.enqueue(temp[i]);
			}
		}

	}

	

	public static void main(String[] args) {

		launch(args);

	}

	public void addDistrict(String n) {

		District d1 = new District();
		d1.setName(n);

		district.insert(d1);
	}

	public District deletDistrict(String n) {
		District d1 = new District();
		d1.setName(n);
		
		return (District) district.delet(d1).getData();
	}

	public void abload() {
		queue=district.traverceInOreder();
	}

	private void abload(TNode<District> root, Queue<District> d1) {
		if (root != null) {
			if (root.getLeft() != null)
				abload(root.getLeft(), d1);
			d1.enqueue(root.getData());
			
			if (root.getRigth() != null)
			
				abload(root.getRigth(), d1);
			
			
			
		}

	}

	public boolean ubdate(String old, String newn) {
		District d1 = new District();
		district.traverceInOreder();
		d1.setName(old);
		if (district.find(d1) == null) {
			System.out.println("sorry");
			return false;
		}
		District d2 = district.find(d1).getData();

		district.delet(d1);
		d2.setName(newn);
		district.insert(d2);
		System.out.println(newn);
		district.traverceInOreder();
		return true;
	}

}
