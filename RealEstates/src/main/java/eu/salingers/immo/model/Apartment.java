package eu.salingers.immo.model;

import java.util.List;

import lombok.Getter;

@Getter
public class Apartment implements Lettable {
  
  private Double squareMeters;

  private List<Room> rooms;

  private List<Bathroom> bathRooms;

  private List<Terrace> terrasses;

  private List<Garden> gardens;

  private Boolean isBooked;

  public static class Builder {
    private List<Room> rooms;

    private List<Bathroom> bathRooms;

    private List<Terrace> terrasses;

    private List<Garden> gardens;

    private Double squareMeters;

    public Builder(final Double squareMeters) {
      this.squareMeters = squareMeters;
    }
    
    
    public Builder withRooms(List<Room> rooms) {
      this.rooms = rooms;
      return this;
    }

    public Builder withBathRooms(List<Bathroom> bathRooms) {
      this.bathRooms = bathRooms;
      return this;
    }

    public Builder withTerrasses(List<Terrace> terrasses) {
      this.terrasses = terrasses;
      return this;
    }

    public Builder withGardens(List<Garden> gardens) {
      this.gardens = gardens;
      return this;
    }

    public Apartment build() {
      return new Apartment(this);
    }
  }

  private Apartment(Builder builder) {
    this.squareMeters = builder.squareMeters;
    this.rooms = builder.rooms;
    this.bathRooms = builder.bathRooms;
    this.terrasses = builder.terrasses;
    this.gardens = builder.gardens;
  }

  @Override
  public String toString() {
    return "Apartment [squareMeters= squareMeters" //NOSONAR
        + (rooms != null ? "rooms=" + rooms + ", " : "") + (bathRooms != null ? "bathRooms=" + bathRooms + ", " : "")
        + (terrasses != null ? "terrasses=" + terrasses + ", " : "") + (gardens != null ? "gardens=" + gardens : "") + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bathRooms == null) ? 0 : bathRooms.hashCode());
    result = prime * result + ((gardens == null) ? 0 : gardens.hashCode());
    result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
    result = prime * result +  squareMeters.hashCode();
    result = prime * result + ((terrasses == null) ? 0 : terrasses.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Apartment other = (Apartment) obj;
    if (bathRooms == null) {
      if (other.bathRooms != null)
        return false;
    } else if (!bathRooms.equals(other.bathRooms))
      return false;
    if (gardens == null) {
      if (other.gardens != null)
        return false;
    } else if (!gardens.equals(other.gardens))
      return false;
    if (rooms == null) {
      if (other.rooms != null)
        return false;
    } else if (!rooms.equals(other.rooms))
      return false;
    if (!squareMeters.equals(other.squareMeters))
      return false;
    if (terrasses == null) {
      if (other.terrasses != null)
        return false;
    } else if (!terrasses.equals(other.terrasses))
      return false;
    return true;
  }

  @Override
  public void book() {
    isBooked = Boolean.TRUE;    
  }

  @Override
  public void unbook() {
    isBooked = Boolean.FALSE;    
  }
}