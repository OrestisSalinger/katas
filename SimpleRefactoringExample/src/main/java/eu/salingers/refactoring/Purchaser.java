package eu.salingers.refactoring;


public class Purchaser {
    private String name;
    private Order[] magazines;

    public Purchaser(String name, Order[] parcels) {
        this.name = name;
        this.magazines = parcels;
    }
    
    public String getName() {
        return name;
    }
    
    public Order[] getMagazines() {
        return magazines;
    }
}
