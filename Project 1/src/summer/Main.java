package summer;


import java.util.*;
import java.io.*;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main<S> extends Application {


	private TableView<String> table = new TableView<String>();
	private Scanner z;
	Label a1;
	Label b1;
	Label c1;
	Label d1;


	public static void main(String[]args) {
		launch(args);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<S,String>("email"));
        
        
        
        
        
        
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
       table.setPrefHeight(150);
       table.setPrefWidth(150);
       
       
       //adding a browser
       
       
		WebView webView = new WebView();
		
		// Create the WebEngine
		final WebEngine webEngine = webView.getEngine();

		// LOad the Start-Page
		webEngine.load("http://www.google.com");
		
		// Update the stage title when a new web page title is available
		
		
		layout.setCenter(webView);

		// Create the VBox
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       //adding a browser

        ObservableList<String> items =FXCollections.observableArrayList (
			    "Test", "Car", "Name", "Plane");
			list.setItems(items);
			list.setPrefWidth(100);
			list.setPrefHeight(600);
		
			
			
			list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			    @SuppressWarnings("unlikely-arg-type")
				@Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			        
			        if(list.equals("Test"));
			        {
			        	System.out.println("Hello");
			        	openFile();
			        	readFile();
			        	layout.setCenter(a1);
			        	
			        	
			        	
			    
			    }
			        
			        
			    }
			});
			
			
		GridPane grid = new GridPane();
		
		BorderPane table1 = new BorderPane();
		
		
		//grid.add(button, 0, 0);
		grid.add(list, 0, 0);
		

		table1.setBottom(table);
		
		Navigation nav = new Navigation(webView, "", false);
		
		
		//added navigation bar
		layout.setTop(nav);
		//added navigation bar 	
		layout.setLeft(grid);
		layout.setBottom(table1);
		
		
		//reading from file
		
		
		
		
		
		
		
		//reading from file
		//layout.getChildren().addAll(grid,table1);		
		Scene scene = new Scene(layout,300,250);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	public void openFile() {
		
		try {
			z= new Scanner(new File("src/summer/Name.txt"));
		}
		catch(Exception e){
			System.out.println("Couldn't find file");
		}
		
	}
	public void readFile() {
		try {
			while(z.hasNext()) {
				String a = z.next();
				String b = z.next();
				String c = z.next();
				String d = z.next();
				
				a1 = new Label(a);
				b1 = new Label(b);
				c1 = new Label(c);
				d1 = new Label(d);
				
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
				System.out.println("Successful");
				
			}
		}
		catch(Exception e) {
			System.out.println("Failed to find");
			
		}
	}

}
