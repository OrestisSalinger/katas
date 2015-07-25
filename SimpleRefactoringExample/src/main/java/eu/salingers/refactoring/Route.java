package eu.salingers.refactoring;


public class Route {
    private String name;
    private Purchaser[] names;
    
    public Route(String name, Purchaser[] names) {
        this.name = name;
        this.names = names;
    }
    
    public String getName() {
        return name;
    }
    
    public Purchaser[] getNames() {
        return names;
    }
}
