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
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Main1<S> extends Application {
	private TableView<String> table = new TableView<String>();
	private Scanner z;
    String everything;

	Label a1;
	Label b1;
	Label c1;
	Label d1;
	String file1;
	//String file2;
	//String file3;
	//String file4;
	GridPane labels = new GridPane();
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
       //displayContents();
       //adding a browser
		WebView webView = new WebView();	
		// Create the WebEngine
		final WebEngine webEngine = webView.getEngine();
		// LOad the Start-Page
		webEngine.load("http://www.google.com");
		// Update the stage title when a new web page title is available
		layout.setCenter(webView);
		String Folder="C:\\Users\\Sshy\\Desktop\\Text Files";
       //adding a browser
        ObservableList<? extends Object> items =FXCollections.observableArrayList (getFolderFiles(Folder));
		
			list.setItems((ObservableList<String>) items);
			list.setPrefWidth(300);
			list.setPrefHeight(600);
			
			list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			    @SuppressWarnings("unlikely-arg-type")
				@Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			        String file = Folder + "\\" + newValue;
			        
			        if(list.equals(file));
			        {
			        	System.out.println(file);
			        	
			        	try {
			        		webView.getEngine().loadContent(readFileContent(file));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("Failed");
						}
			        	Button b = new Button();
			        } 
			        
			    
			    }
			});
			GridPane grid = new GridPane();
		BorderPane table1 = new BorderPane();
		grid.add(list, 0, 0);
		table1.setBottom(table);
		Navigation nav = new Navigation(webView, "", false);
		layout.setTop(nav);
		layout.setLeft(grid);
		layout.setBottom(table1);		
		Scene scene = new Scene(layout,300,250);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public String readFileContent(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		     return sb.toString();
		     //System.out.println(everything);
		} finally {
		    br.close();
		}
		
	}
	
	
	public String[] getFolderFiles(String Folder) {
		   File path = new File(Folder);
		   
		    File [] files = path.listFiles();
		    String[] fileNames = new String[files.length];
		    for(int i = 0; i<files.length;i++)
		    {
		    	fileNames[i]=files[i].getName();
		    }
		    return fileNames;
	}
}