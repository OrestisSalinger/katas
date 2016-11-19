package eu.salingers.immo.manage;

import java.util.ArrayList;
import java.util.List;

import eu.salingers.immo.model.Apartment;

public class RealEstateManager {

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


}
