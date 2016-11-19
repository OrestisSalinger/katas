package eu.salingers.immo.model;

import lombok.Getter;

/**
 * The Class Address.
 */
@Getter
public class Address {

  private Country country;

  private String city;

  private String zip;

  private String street;

  private String streetNumber;

  /**
   * The Class Builder.
   */
  public static class Builder {
    private Country country;

    private String city;

    private String zip;

    private String street;

    private String streetNumber;

    /**
     * Instantiates a new builder.
     *
     * @param country
     *          the country
     * @param zip
     *          the zip
     */
    public Builder(final Country country, final String zip) {
      this.country = country;
      this.zip = zip;
    }

    /**
     * With street.
     *
     * @param street
     *          the street
     * @return the builder
     */
    public final Builder withStreet(final String street) {
      this.street = street;
      return this;
    }

    /**
     * With street and number.
     *
     * @param street
     *          the street
     * @param streetNumber
     *          the street number
     * @return the builder
     */
    public final Builder withStreetAndNumber(final String street, final String streetNumber) {
      this.street = street;
      this.streetNumber = streetNumber;
      return this;
    }

    /**
     * With city.
     *
     * @param city
     *          the city
     * @return the builder
     */
    public final Builder withCity(final String city) {
      this.city = city;
      return this;
    }

    /**
     * Builds the.
     *
     * @return the address
     */
    public final Address build() {
      return new Address(this);
    }
  }

  private Address(final Builder builder) {
    this.country = builder.country;
    this.city = builder.city;
    this.zip = builder.zip;
    this.street = builder.street;
    this.streetNumber = builder.streetNumber;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((street == null) ? 0 : street.hashCode());
    result = prime * result + ((streetNumber == null) ? 0 : streetNumber.hashCode());
    result = prime * result + ((zip == null) ? 0 : zip.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Address other = (Address) obj;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (country != other.country)
      return false;
    if (street == null) {
      if (other.street != null)
        return false;
    } else if (!street.equals(other.street))
      return false;
    if (streetNumber == null) {
      if (other.streetNumber != null)
        return false;
    } else if (!streetNumber.equals(other.streetNumber))
      return false;
    if (!zip.equals(other.zip))
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Address [" + (country != null ? "country=" + country + ", " : "")//NOSONAR
        + (city != null ? "city=" + city + ", " : "")
        + (zip != null ? "zip=" + zip + ", " : "") 
        + (street != null ? "street=" + street + ", " : "")
        + (streetNumber != null ? "streetNumber=" + streetNumber : "") + "]";
  }
}
