package eu.salingers.immo.model;

import java.util.List;

import lombok.Getter;

@Getter
public class Garden {
  private Double squareMeters;

  private List<Pool> pools;

  private List<Pool> ponds;

  /**
   * @param squareMeters
   */
  private Garden(Builder builder) {
    this.squareMeters = builder.squareMeters;
    this.pools = builder.pools;
    this.ponds = builder.ponds;
  }

  @Override
  public String toString() {
    return "Garden [" + (squareMeters != null ? "squareMeters=" + squareMeters : "") + "]";
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
    Garden other = (Garden) obj;
    if (squareMeters == null) {
      if (other.squareMeters != null)
        return false;
    } else if (!squareMeters.equals(other.squareMeters))
      return false;
    return true;
  }

  public static class Builder {
    private Double squareMeters;

    private List<Pool> pools;

    private List<Pool> ponds;

    public Builder(Double squareMeters) {
      this.squareMeters = squareMeters;
    }

    public Builder pools(List<Pool> pools) {
      this.pools = pools;
      return this;
    }

    public Builder ponds(List<Pool> ponds) {
      this.ponds = ponds;
      return this;
    }

    public Garden build() {
      return new Garden(this);
    }
  }

 
}
