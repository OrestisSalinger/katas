package eu.salingers.immo.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class Building {
  private long id;
  private List<Apartment> apartments = Collections.emptyList();
  private List<Commercial> commercials = Collections.emptyList();
  private List<Terrace> terraces = Collections.emptyList();
  private List<Pool> pools = Collections.emptyList();
  private List<Garden> gardens = Collections.emptyList();
  private Person owner;
  private LocalDate builtDate;
  private LocalDate lastRenovationDate;
  private Address address;
  private int stories;
  private State state = State.NOT_SET;
  private Site site = Site.NOT_SET;
  private HeatingType heatingType = HeatingType.NOT_SET;
  private RealEstateCategory category = RealEstateCategory.NOT_SET;
  
  private Building(Builder builder){
    this.id=builder.id;
    this.apartments=builder.apartments;
    this.commercials=builder.commercials;
    this.terraces=builder.terraces;
    this.pools=builder.pools;
    this.gardens=builder.gardens;
    this.owner=builder.owner;
    this.builtDate=builder.builtDate;
    this.lastRenovationDate=builder.lastRenovationDate;
    this.address=builder.address;
    this.stories=builder.stories;
    this.state=builder.state;
    this.site=builder.site;
    this.heatingType=builder.heatingType;
    this.category=builder.category;
  }

  @Override
  public String toString() { // NOSONAR
    return "Building [id=" + id + ", " + (apartments != null ? "apartments=" + apartments + ", " : "") //NOSONAR
        + (commercials != null ? "commercials=" + commercials + ", " : "")
        + (terraces != null ? "terraces=" + terraces + ", " : "") + (pools != null ? "pools=" + pools + ", " : "")
        + (gardens != null ? "gardens=" + gardens + ", " : "") + (owner != null ? "owner=" + owner + ", " : "")
        + (builtDate != null ? "builtDate=" + builtDate + ", " : "")
        + (lastRenovationDate != null ? "lastRenovationDate=" + lastRenovationDate + ", " : "")
        + (address != null ? "address=" + address + ", " : "") + "stories=" + stories + ", "
        + (state != null ? "state=" + state + ", " : "") + (site != null ? "site=" + site + ", " : "")
        + (heatingType != null ? "heatingType=" + heatingType + ", " : "") + (category != null ? "category=" + category : "")
        + "]";
  }
 
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((apartments == null) ? 0 : apartments.hashCode());
    result = prime * result + ((builtDate == null) ? 0 : builtDate.hashCode());
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((commercials == null) ? 0 : commercials.hashCode());
    result = prime * result + ((gardens == null) ? 0 : gardens.hashCode());
    result = prime * result + ((heatingType == null) ? 0 : heatingType.hashCode());
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((lastRenovationDate == null) ? 0 : lastRenovationDate.hashCode());
    result = prime * result + ((owner == null) ? 0 : owner.hashCode());
    result = prime * result + ((pools == null) ? 0 : pools.hashCode());
    result = prime * result + ((site == null) ? 0 : site.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result + stories;
    result = prime * result + ((terraces == null) ? 0 : terraces.hashCode());
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
    Building other = (Building) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (apartments == null) {
      if (other.apartments != null)
        return false;
    } else if (!apartments.equals(other.apartments))
      return false;
    if (builtDate == null) {
      if (other.builtDate != null)
        return false;
    } else if (!builtDate.equals(other.builtDate))
      return false;
    if (category != other.category)
      return false;
    if (commercials == null) {
      if (other.commercials != null)
        return false;
    } else if (!commercials.equals(other.commercials))
      return false;
    if (gardens == null) {
      if (other.gardens != null)
        return false;
    } else if (!gardens.equals(other.gardens))
      return false;
    if (heatingType != other.heatingType)
      return false;
    if (id != other.id)
      return false;
    if (lastRenovationDate == null) {
      if (other.lastRenovationDate != null)
        return false;
    } else if (!lastRenovationDate.equals(other.lastRenovationDate))
      return false;
    if (owner == null) {
      if (other.owner != null)
        return false;
    } else if (!owner.equals(other.owner))
      return false;
    if (pools == null) {
      if (other.pools != null)
        return false;
    } else if (!pools.equals(other.pools))
      return false;
    if (site != other.site)
      return false;
    if (state != other.state)
      return false;
    if (stories != other.stories)
      return false;
    if (terraces == null) {
      if (other.terraces != null)
        return false;
    } else if (!terraces.equals(other.terraces))
      return false;
    return true;
  }

  public static class Builder {
    private long id;
    private List<Apartment> apartments;
    private List<Commercial> commercials;
    private List<Terrace> terraces;
    private List<Pool> pools;
    private List<Garden> gardens;
    private Person owner;
    private LocalDate builtDate;
    private LocalDate lastRenovationDate;
    private Address address;
    private int stories;
    private State state;
    private Site site;
    private HeatingType heatingType;
    private RealEstateCategory category;
    public Builder id(long id) {
      this.id=id;
      return this;
    }
    public Builder apartments(List<Apartment> apartments) {
      this.apartments=apartments;
      return this;
    }
    public Builder commercials(List<Commercial> commercials) {
      this.commercials=commercials;
      return this;
    }
    public Builder terraces(List<Terrace> terraces) {
      this.terraces=terraces;
      return this;
    }
    public Builder pools(List<Pool> pools) {
      this.pools=pools;
      return this;
    }
    public Builder gardens(List<Garden> gardens) {
      this.gardens=gardens;
      return this;
    }
    public Builder owner(Person owner) {
      this.owner=owner;
      return this;
    }
    public Builder builtDate(LocalDate builtDate) {
      this.builtDate=builtDate;
      return this;
    }
    public Builder lastRenovationDate(LocalDate lastRenovationDate) {
      this.lastRenovationDate=lastRenovationDate;
      return this;
    }
    public Builder address(Address address) {
      this.address=address;
      return this;
    }
    public Builder stories(int stories) {
      this.stories=stories;
      return this;
    }
    public Builder state(State state) {
      this.state=state;
      return this;
    }
    public Builder site(Site site) {
      this.site=site;
      return this;
    }
    public Builder heatingType(HeatingType heatingType) {
      this.heatingType=heatingType;
      return this;
    }
    public Builder category(RealEstateCategory category) {
      this.category=category;
      return this;
    }
    public Building build(){
      return new Building(this);
    }
  }

}