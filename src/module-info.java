module Project1_structure {
	requires javafx.controls;

	opens application to javafx.graphics, javafx.base, javafx.fxml;
}
