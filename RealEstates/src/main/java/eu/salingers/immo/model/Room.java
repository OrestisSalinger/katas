package eu.salingers.immo.model;

import java.util.List;

import lombok.Getter;

/**
 * @author orestis
 *
 */
@Getter
public class Room {
 
  private Double squareMeters;

  private Integer windowCount;

  private Integer doorCount;

  private Float lenght;

  private Float width;

  private Float height;

  private String floorType;
  
  private Integer floor;

  private HeatingType heatingType;

  private List<Balcony> balconies;

  private List<Terrace> terraces;

  private List<Garden> gardens;

  public static class Builder {

    private Double squareMeters;

    private Integer windowCount;

    private Integer doorCount;

    private Float lenght;

    private Float width;

    private Float height;

    private String floorType;

    private HeatingType heatingType;

    private Integer floor;

    private List<Balcony> balconies;

    private List<Terrace> terraces;

    private List<Garden> gardens;

    public Builder(final Double squareMeters) {
      this.squareMeters = squareMeters;
    }
    
    public Builder withWindowCount(Integer windowCount) {
      this.windowCount = windowCount;
      return this;
    }

    public Builder withDoorCount(Integer doorCount) {
      this.doorCount = doorCount;
      return this;
    }

    public Builder withLenght(Float lenght) {
      this.lenght = lenght;
      return this;
    }

    public Builder withWidth(Float width) {
      this.width = width;
      return this;
    }

    public Builder withHeight(Float f) {
      this.height = f;
      return this;
    }

    public Builder withFloorType(String floorType) {
      this.floorType = floorType;
      return this;
    }

    public Builder withFloor(Integer floor) {
      this.floor = floor;
      return this;
    }

    public Builder withHeatingType(HeatingType heatingType) {
      this.heatingType = heatingType;
      return this;
    }

    public Builder withBalconies(List<Balcony> balconies) {
      this.balconies = balconies;
      return this;
    }

    public Builder withTerraces(List<Terrace> terraces) {
      this.terraces = terraces;
      return this;
    }

    public Builder withGardens(List<Garden> gardens) {
      this.gardens = gardens;
      return this;
    }

    public Room build() {
      return new Room(this);
    }
  }
  private Room(Builder builder) {
    this.squareMeters = builder.squareMeters;
    this.windowCount = builder.windowCount;
    this.doorCount = builder.doorCount;
    this.lenght = builder.lenght;
    this.width = builder.width;
    this.height = builder.height;
    this.floorType = builder.floorType;
    this.floor = builder.floor;
    this.heatingType = builder.heatingType;
    this.balconies = builder.balconies;
    this.terraces = builder.terraces;
    this.gardens = builder.gardens;
  }
  
  @Override
  public String toString() { //NOSONAR
    return "Room [" + (squareMeters != null ? "squareMeters=" + squareMeters + ", " : "") //NOSONAR
        + (windowCount != null ? "windowCount=" + windowCount + ", " : "")
        + (doorCount != null ? "doorCount=" + doorCount + ", " : "") + (lenght != null ? "lenght=" + lenght + ", " : "")
        + (width != null ? "width=" + width + ", " : "") + (height != null ? "height=" + height + ", " : "")
        + (floorType != null ? "floorType=" + floorType + ", " : "") + (floor != null ? "floor=" + floor + ", " : "")
        + (heatingType != null ? "heatingType=" + heatingType + ", " : "")
        + (balconies != null ? "balconies=" + balconies + ", " : "") 
        + (terraces != null ? "terraces=" + terraces + ", " : "")
        + (gardens != null ? "gardens=" + gardens : "") + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((balconies == null) ? 0 : balconies.hashCode());
    result = prime * result + ((doorCount == null) ? 0 : doorCount.hashCode());
    result = prime * result + ((floor == null) ? 0 : floor.hashCode());
    result = prime * result + ((floorType == null) ? 0 : floorType.hashCode());
    result = prime * result + ((gardens == null) ? 0 : gardens.hashCode());
    result = prime * result + ((heatingType == null) ? 0 : heatingType.hashCode());
    result = prime * result + ((height == null) ? 0 : height.hashCode());
    result = prime * result + ((lenght == null) ? 0 : lenght.hashCode());
    result = prime * result + ((squareMeters == null) ? 0 : squareMeters.hashCode());
    result = prime * result + ((terraces == null) ? 0 : terraces.hashCode());
    result = prime * result + ((width == null) ? 0 : width.hashCode());
    result = prime * result + ((windowCount == null) ? 0 : windowCount.hashCode());
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
    Room other = (Room) obj;
    if (balconies == null) {
      if (other.balconies != null)
        return false;
    } else if (!balconies.equals(other.balconies))
      return false;
    if (doorCount == null) {
      if (other.doorCount != null)
        return false;
    } else if (!doorCount.equals(other.doorCount))
      return false;
    if (floor == null) {
      if (other.floor != null)
        return false;
    } else if (!floor.equals(other.floor))
      return false;
    if (floorType == null) {
      if (other.floorType != null)
        return false;
    } else if (!floorType.equals(other.floorType))
      return false;
    if (gardens == null) {
      if (other.gardens != null)
        return false;
    } else if (!gardens.equals(other.gardens))
      return false;
    if (heatingType != other.heatingType)
      return false;
    if (height == null) {
      if (other.height != null)
        return false;
    } else if (!height.equals(other.height))
      return false;
    if (lenght == null) {
      if (other.lenght != null)
        return false;
    } else if (!lenght.equals(other.lenght))
      return false;
    if (width == null) {
      if (other.width != null)
        return false;
    } else if (!width.equals(other.width))
      return false;
    if (terraces == null) {
      if (other.terraces != null)
        return false;
    } else if (!terraces.equals(other.terraces))
      return false;
    if (windowCount == null) {
      if (other.windowCount != null)
        return false;
    } else if (!windowCount.equals(other.windowCount))
      return false;
    if (!squareMeters.equals(other.squareMeters))
      return false;
    return true;
  }
  
  
}