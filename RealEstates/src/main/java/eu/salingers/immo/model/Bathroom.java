package eu.salingers.immo.model;

import lombok.Getter;

/**
 * Gets the towel warmers.
 *
 * @return the towel warmers
 */
@Getter
public class Bathroom implements ApartmentItem{

  /** The square meters. */
  private Double squareMeters;

  /** The showers. */
  private Integer showers;

  /** The bath tubs. */
  private Integer bathTubs;

  /** The towel warmers. */
  private Integer towelWarmers;

  /**
   * The Class Builder.
   */
  public static class Builder {
    
    /** The square meters. */
    private Double squareMeters;

    /** The showers. */
    private Integer showers;
    
    /** The bath tubs. */
    private Integer bathTubs;
    
    /** The towel warmers. */
    private Integer towelWarmers;
   
    /**
     * Instantiates a new bath builder.
     *
     * @param squareMeters the square meters
     */
    public Builder(final Double squareMeters) {
        this.squareMeters = squareMeters;
       }
    

    /**
     * With showers.
     *
     * @param showers the showers
     * @return the bath builder
     */
    public Builder withShowers(Integer showers) {
      this.showers = showers;
      return this;
    }

    /**
     * With bath tubs.
     *
     * @param bathTubs the bath tubs
     * @return the bath builder
     */
    public Builder withBathTubs(Integer bathTubs) {
      this.bathTubs = bathTubs;
      return this;
    }

    /**
     * With towel warmers.
     *
     * @param towelWarmers the towel warmers
     * @return the bath builder
     */
    public Builder withTowelWarmers(Integer towelWarmers) {
      this.towelWarmers = towelWarmers;
      return this;
    }

    /**
     * Builds the.
     *
     * @return the bathroom
     */
    public Bathroom build() {
      return new Bathroom(this);
    }
  }

  /**
   * Instantiates a new bathroom.
   *
   * @param builder the builder
   */
  private Bathroom(Builder builder) {
    this.squareMeters = builder.squareMeters;
    this.showers = builder.showers;
    this.bathTubs = builder.bathTubs;
    this.towelWarmers = builder.towelWarmers;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() { 
    return "Bathroom [" + (squareMeters != null ? "squareMeters=" + squareMeters + ", " : "")//NOSONAR
        + (showers != null ? "showers=" + showers + ", " : "") + (bathTubs != null ? "bathTubs=" + bathTubs + ", " : "")
        + (towelWarmers != null ? "towelWarmers=" + towelWarmers : "") + "]";
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bathTubs == null) ? 0 : bathTubs.hashCode());
    result = prime * result + ((showers == null) ? 0 : showers.hashCode());
    result = prime * result + ((squareMeters == null) ? 0 : squareMeters.hashCode());
    result = prime * result + ((towelWarmers == null) ? 0 : towelWarmers.hashCode());
    return result;
  }

  /* (non-Javadoc)
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
    Bathroom other = (Bathroom) obj;
    if (bathTubs == null) {
      if (other.bathTubs != null)
        return false;
    } else if (!bathTubs.equals(other.bathTubs))
      return false;
    if (showers == null) {
      if (other.showers != null)
        return false;
    } else if (!showers.equals(other.showers))
      return false;
    if (!squareMeters.equals(other.squareMeters))
      return false;
    if (towelWarmers == null) {
      if (other.towelWarmers != null)
        return false;
    } else if (!towelWarmers.equals(other.towelWarmers))
      return false;
    return true;
  }

}