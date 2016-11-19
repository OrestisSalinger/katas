package eu.salingers.immo.model;

import lombok.Getter;

@Getter
public class Pond {

  private double squareMeters;

  private String filterType;

  private String divingBoard;

  private int length;

  private int width;

  private int deep;
  
  private Pond(Builder builder) {
    this.squareMeters = builder.squareMeters;
    this.filterType = builder.filterType;
    this.divingBoard = builder.divingBoard;
    this.length = builder.length;
    this.width = builder.width;
    this.deep = builder.deep;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + deep;
    result = prime * result + ((divingBoard == null) ? 0 : divingBoard.hashCode());
    result = prime * result + ((filterType == null) ? 0 : filterType.hashCode());
    result = prime * result + length;
    long temp;
    temp = Double.doubleToLongBits(squareMeters);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + width;
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
    Pond other = (Pond) obj;
    if (deep != other.deep)
      return false;
    if (divingBoard == null) {
      if (other.divingBoard != null)
        return false;
    } else if (!divingBoard.equals(other.divingBoard))
      return false;
    if (filterType == null) {
      if (other.filterType != null)
        return false;
    } else if (!filterType.equals(other.filterType))
      return false;
    if (length != other.length)
      return false;
    if (Double.doubleToLongBits(squareMeters) != Double.doubleToLongBits(other.squareMeters))
      return false;
    if (width != other.width)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Pool [squareMeters=" + squareMeters + ", "
        + (filterType != null ? "filterType=" + filterType + ", " : "")
        + (divingBoard != null ? "divingBoard=" + divingBoard + ", " : "") + "length=" + length + ", width=" + width + ", deep="
        + deep + "]";
  }

  public static class Builder {
    private double squareMeters;

    private String filterType;

    private String divingBoard;

    private int length;

    private int width;

    private int deep;
    
    public Builder(final Double squareMeters) {
      this.squareMeters = squareMeters;
    }

    public Builder filterType(String filterType) {
      this.filterType = filterType;
      return this;
    }

    public Builder divingBoard(String divingBoard) {
      this.divingBoard = divingBoard;
      return this;
    }

    public Builder length(int length) {
      this.length = length;
      return this;
    }

    public Builder width(int width) {
      this.width = width;
      return this;
    }

    public Builder deep(int deep) {
      this.deep = deep;
      return this;
    }

    public Pond build() {
      return new Pond(this);
    }
  }
}
