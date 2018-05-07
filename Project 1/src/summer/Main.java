package summer;

import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	private TableView<String> table = new TableView<String>();
	
	public static void main(String[]args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("!Browser!");
		Button button = new Button();
		button.setText("Click");
		button.setOnAction(e->System.out.println("Hello"));
		BorderPane layout = new BorderPane();
		ListView<String> list = new ListView<String>();
		
		final Label label = new Label("Address Book");
		
        label.setFont(new Font("Arial", 20));

 
        table.setEditable(true);
 
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
        
                
		ObservableList<String> items =FXCollections.observableArrayList (
			    "Single", "Double", "Suite", "Family App");
			list.setItems(items);
			list.setPrefWidth(100);
			list.setPrefHeight(100);
		
		GridPane grid = new GridPane();
		
		BorderPane table1 = new BorderPane();
		
		
		//grid.add(button, 0, 0);
		grid.add(list, 0, 0);
		

		table1.setBottom(table);
		 	
		layout.setLeft(grid);
		layout.setBottom(table);
		
		//layout.getChildren().addAll(grid,table1);		
		Scene scene = new Scene(layout,300,250);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	

}
