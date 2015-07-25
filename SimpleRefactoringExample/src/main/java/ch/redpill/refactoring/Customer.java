package ch.redpill.refactoring;


public class Customer {
    private String name;
    private Parcel[] magazines;

    public Customer(String name, Parcel[] parcels) {
        this.name = name;
        this.magazines = parcels;
    }
    
    public String getName() {
        return name;
    }
    
    public Parcel[] getMagazines() {
        return magazines;
    }
}
