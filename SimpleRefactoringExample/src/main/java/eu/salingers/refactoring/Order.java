package eu.salingers.refactoring;


public class Order {
    private String code;
    private boolean type;
    
    public Order(String c) {
        this.code = c;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setType(boolean type) {
        this.type = type;
    }
    
    public boolean getType() {
        return type;
    }
}
