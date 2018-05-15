package summer1;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Main3<S> extends Application {
	
	
	private Scanner z;
    String everything;
    String text;
    TableView tab = new TableView();
	Label a1;
	Label b1;
	Label c1;
	Label d1;
	String file1;
	String label;
	String type;
	String identification;
	BorderPane layout = new BorderPane();
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

		ListView<String> list = new ListView<String>();		

		
		TableColumn nameColumn = new TableColumn("Type");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn surnameColumn = new TableColumn("Tag");
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
		
		
		
		TableColumn middlenameColumn = new TableColumn("Identification");
		middlenameColumn.setCellValueFactory(new PropertyValueFactory<>("middlename"));

		tab.getColumns().addAll(nameColumn, surnameColumn,middlenameColumn);
		
		Person2 person = new Person2("John", "Doe","101");
		tab.getItems().add(person);
		
		
		
		
		layout.setBottom(tab);
		WebView webView = new WebView();	
		// Create the WebEngine
		final WebEngine webEngine = webView.getEngine();
		// LOad the Start-Page
		webEngine.load("http://www.google.com");
		// Update the stage title when a new web page title is available
		layout.setCenter(webView);
		String Folder="C:\\Users\\Sshy\\Desktop\\JSON Folders";
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
			        		
			        	    tab.getItems().clear();		        		
			        		webView.getEngine().loadContent(readFileContent(file));
			        		 Object obj = new JSONParser().parse(new FileReader("C:\\Users\\Sshy\\Desktop\\JSON Folders\\Batch_1_001.lif"));
			     	   
			     	        JSONObject jo = (JSONObject) obj;
			     	        
			     	        JSONObject payload = (JSONObject)jo.get("payload");
			     	      
			     	        JSONObject textObject = (JSONObject)payload.get("text");
			     	     
			     	        JSONArray views = (JSONArray)payload.get("views");
			     	        JSONObject view = (JSONObject)views.get(0);
			     	        
			     	         text = (String)textObject.get("@value");
			     	         
			     	         String dhruvinBrahmbhatt = (String)payload.get("payload");
			     	        System.out.println(text);
			     	       
			     	        
			     	       JSONArray annotations = (JSONArray)view.get("annotations");
			            
			     	       
			     	       Iterator iter = annotations.iterator();
			     	       
			     	       while(iter.hasNext())
			     	       {
			     	    	   JSONObject annotation = (JSONObject)iter.next();
			     	    	   
			     	    	   System.out.println(annotation.get("id"));
			     	    	   
			     	    	   identification = (String) annotation.get("id").toString();
			     	    	   
			     	    	   
			     	    	   System.out.println(annotation.get("start")); 
			     	    	   System.out.println(annotation.get("end"));
			     	    	   
			     	    	   
			     	    	   System.out.println(annotation.get("@type"));
			     	    	   
			     	    	    type = (String) annotation.get("@type");
			     	    	   System.out.println(annotation.get("label"));
			     	    	   
			     	    	    label = (String)annotation.get("label");
			     	    	    
			     	    	    

					     	      TableColumn type1 = new TableColumn("type");
					     			type1.setCellValueFactory(new PropertyValueFactory<>("type"));

					     			TableColumn label1 = new TableColumn("Tag");
					     			
					     			label1.setCellValueFactory(new PropertyValueFactory<>("label"));
					     			
					     			
					     			TableColumn id= new TableColumn("Id");
					     			id.setCellValueFactory(new PropertyValueFactory<>("ID"));

					     			//tab.getColumns().addAll(type1, label1);					     								     								     								     			
					     			     	    	   			     	    	  			     	    	   
			     	    	   JSONObject feature = (JSONObject)annotation.get("features");
			     	    	   System.out.println(feature.get("agreement"));
			     	    	   
			     	    	   System.out.println(feature.get("annotator"));
			     	    	   System.out.println(feature.get("content"));
			     	   		
			     	    	   
			     	    	  Person2 person = new Person2(type,label,identification);
			     	    	  
			     	    	  
			     	    	 tab.getItems().add(person);		
			     	    	   layout.setBottom(tab);
			     	    	 
				     			
			     	       }
			        		JSONStuff(file);
			        		
			        		webView.getEngine().loadContent(text);
						} catch (IOException | ParseException e) {
							// TODO Auto-generated catch block
							System.out.println("Failed");
						}
			        
			        } 
			        
			    
			    }
			});
			GridPane grid = new GridPane();
		
		grid.add(list, 0, 0);
		
		Navigation nav = new Navigation(webView, "", false);
		layout.setTop(nav);
		layout.setLeft(grid);
			
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
	
	
	
	public void JSONStuff(String fileName) throws FileNotFoundException, IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(fileName));
        
        JSONObject jo = (JSONObject) obj;
        
        JSONObject payload = (JSONObject)jo.get("payload");
      
        JSONObject textObject = (JSONObject)payload.get("text");
     
        JSONArray views = (JSONArray)payload.get("views");
        JSONObject view = (JSONObject)views.get(0);
        
         text = (String)textObject.get("@value");
         
         String dhruvinBrahmbhatt = (String)payload.get("payload");
        System.out.println(text);
       
        
       JSONArray annotations = (JSONArray)view.get("annotations");
       
       
       WebView webView = new WebView();	
		WebView webView1 = new WebView();

		
		final WebEngine webEngine = webView.getEngine();
		
		final WebEngine webEngine1 = webView1.getEngine(); 
       
       
       webView.getEngine().loadContent(text);
        
       Iterator iter = annotations.iterator();
       
       while(iter.hasNext())
       {
    	   JSONObject annotation = (JSONObject)iter.next();
    	   
    	   System.out.println(annotation.get("id"));
    	   System.out.println(annotation.get("start"));
    	   System.out.println(annotation.get("end"));
    	   System.out.println(annotation.get("@type"));	
    	   System.out.println(annotation.get("label"));
    	   
    	   JSONObject feature = (JSONObject)annotation.get("features");
    	   System.out.println(feature.get("agreement"));
    	   System.out.println(feature.get("annotator"));
    	   System.out.println(feature.get("content"));
   		
       }
       
       String annotations21;

	}
}