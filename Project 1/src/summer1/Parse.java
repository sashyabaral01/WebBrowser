package summer1;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class Parse {
    public static void main(String[] args) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\Sshy\\Desktop\\JSON Folders\\Batch_1_001.lif"));
      
        JSONObject jo = (JSONObject) obj;
        
        JSONObject payload = (JSONObject)jo.get("payload");
      
        JSONObject textObject = (JSONObject)payload.get("text");
     
        JSONArray views = (JSONArray)payload.get("views");
        JSONObject view = (JSONObject)views.get(0);
        
        String text = (String)textObject.get("@value");
        System.out.println(text);
       
       JSONArray annotations = (JSONArray)view.get("annotations");
        
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
        
     
    


     


        
}
    
}