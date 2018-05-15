package summer1;

public class Annotation {
    private String type;
    private String label;
    private String id;
    private String start;
    private String stop;
    private String agreement;

    public Annotation(String type, String label,String id,String start, String stop,String agreement) {
        this.type = type;
        this.label = label;
        this.id = id;
        this.start = start;
        this.stop = stop;
        this.agreement = agreement;
        	
    }

    public String getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }
    
    public String getIdentification() {
    	return id	;
    }
    
    public String getStart() {
    	return start;
    }
    
    public String getStop() {
    	return stop;
    }
    
    public String getAgreement() {
    	return agreement;
    }
}