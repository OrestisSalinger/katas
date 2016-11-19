package eu.salingers.immo.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class RealEstate {
  private long id;
  private Address address;
  private LocalDate builtDate;
  private LocalDate lastRenovationDate;
  private int floors;
  private List<Apartment> apartments;
  private Person owner;
  private State state = State.NEW;
  private RealEstateCategory category = RealEstateCategory.APPARTMENT_BUILDING;
  private Site micro;
  private Site meso;
  private Site macro;
}