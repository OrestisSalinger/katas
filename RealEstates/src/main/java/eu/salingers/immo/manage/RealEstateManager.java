package eu.salingers.immo.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import eu.salingers.immo.model.Apartment;
import eu.salingers.immo.model.Building;

public class RealEstateManager {

  Map<String, Building> buildings = new ConcurrentHashMap<>();
  
  private List<Apartment> apartments = new ArrayList<>();

  public void addAppartment(Apartment apartment) {
      apartments.add(apartment);
  }


  public void addAppartments(List<Apartment> apartments){ 
    this.apartments.addAll(apartments);
  
  }

  public List<Apartment> getApartments() {
    return apartments;
  }


  public Building createBuilding() {
    return new Building.Builder()
        .apartments(apartments)
        .build();
  }


 


}
