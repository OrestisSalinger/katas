package ch.redpill.refactoring;


public class Parcel {
    private String code;
    private boolean type;
    
    public Parcel(String c) {
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
