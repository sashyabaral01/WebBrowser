package summer1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TableView;

import javafx.stage.Stage;

public class TableTest extends Application {
	TableView tab = new TableView();
	String sashya="Hi";
	
	BorderPane pane = new BorderPane();
	public static void main(String[]args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("!Browser!");
		Button button = new Button();
		button.setText("Click");
		button.setOnAction(e->System.out.println("Hello"));
		
		


		TableColumn typeColumn = new TableColumn("Type");
		typeColumn.setCellValueFactory(new PropertyValueFactory<Annotation, String>("Type"));

		TableColumn labelColumn = new TableColumn("Label");
		labelColumn.setCellValueFactory(new PropertyValueFactory<Annotation, String>("Label"));
		
		TableColumn identificationColumn = new TableColumn("Identification");
		identificationColumn.setCellValueFactory(new PropertyValueFactory<Annotation, String>("Identification"));
		
		TableColumn sashyaColumn = new TableColumn("Start");
		sashyaColumn.setCellValueFactory(new PropertyValueFactory<Annotation, String>("Start"));
		
		
		TableColumn testColumn = new TableColumn("Stop");
		testColumn.setCellValueFactory(new PropertyValueFactory<Annotation, String>("Stop"));
		
		TableColumn test2column = new TableColumn("Agreement");
		test2column.setCellValueFactory(new PropertyValueFactory<Annotation, String>("Agreement"));
		
		
		tab.getColumns().addAll(typeColumn, labelColumn,identificationColumn,sashyaColumn, testColumn,test2column);
		
		
		
		//Person person = new Person(sashya, "Hello", "Sashya", "Cat", "Lion", "Nothing");
		Annotation annotation = new Annotation(sashya, "Hello", "Sashya", "Cat", "Lion", "Nothing");

		tab.getItems().add(annotation);
		
		pane.setCenter(button);
		pane.setBottom(tab);
		Scene scene = new Scene(pane,300,250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
}
}


