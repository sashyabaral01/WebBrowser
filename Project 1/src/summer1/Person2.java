package summer1;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;

public class Person2 {
    private String  type;
    private String  label;
    private String  identification;
    private String  start;
    private String  stop;
    private String  agreement;

    public Person2(String type, String label,String id) {
        this.type = type;
        this.label = label;
        this.identification = id;
        this.start = start;
        this.stop = stop;
        this.agreement = agreement;
        	
    }

    public String getName() {
        return type;
    }

    public String getSurname() {
        return label;
    }
}