package eu.salingers.immo.model;

public class Terrace {
  private final Double squareMeters;

  /**
   * @param squareMeters
   */
  public Terrace(Double squareMeters) {
    this.squareMeters = squareMeters;
  }

  @Override
  public String toString() {
    return "Terrace [" + (squareMeters != null ? "squareMeters=" + squareMeters : "") + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((squareMeters == null) ? 0 : squareMeters.hashCode());
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
    Terrace other = (Terrace) obj;
    if (squareMeters == null) {
      if (other.squareMeters != null)
        return false;
    } else if (!squareMeters.equals(other.squareMeters))
      return false;
    return true;
  }
  
  
}
