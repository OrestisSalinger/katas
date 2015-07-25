package ch.redpill.refactoring;


public class Round {
    private String name;
    private Customer[] names;
    
    public Round(String name, Customer[] names) {
        this.name = name;
        this.names = names;
    }
    
    public String getName() {
        return name;
    }
    
    public Customer[] getNames() {
        return names;
    }
}
