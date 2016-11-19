package eu.salingers.crawl;

public class Member {
  


  String linkToProfile;

  String linkToImage;

  String name;

  int contactDegree;

  String title;

  String location;

  String industry;

  String country;

  int connectionsInCommon;

  private Member(Builder builder) {
    this.linkToProfile = builder.linkToProfile;
    this.linkToImage = builder.linkToImage;
    this.name = builder.name;
    this.contactDegree = builder.contactDegree;
    this.title = builder.title;
    this.location = builder.location;
    this.industry = builder.industry;
    this.country = builder.country;
    this.connectionsInCommon = builder.connectionsInCommon;
  }
  
  public static class Builder {
    private String linkToProfile;

    private String linkToImage;

    private String name;

    private int contactDegree;

    private String title;

    private String location;

    private String industry;

    private String country;

    private int connectionsInCommon;

    public Builder linkToProfile(String linkToProfile) {
      this.linkToProfile = linkToProfile;
      return this;
    }

    public Builder linkToImage(String linkToImage) {
      this.linkToImage = linkToImage;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder contactDegree(int contactDegree) {
      this.contactDegree = contactDegree;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder location(String location) {
      this.location = location;
      return this;
    }

    public Builder industry(String industry) {
      this.industry = industry;
      return this;
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public Builder connectionsInCommon(int connectionsInCommon) {
      this.connectionsInCommon = connectionsInCommon;
      return this;
    }

    public Member build() {
      return new Member(this);
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((industry == null) ? 0 : industry.hashCode());
    result = prime * result + ((linkToProfile == null) ? 0 : linkToProfile.hashCode());
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Member other = (Member) obj;
    if (country == null) {
      if (other.country != null) {
        return false;
      }
    } else if (!country.equals(other.country)) {
      return false;
    }
    if (industry == null) {
      if (other.industry != null) {
        return false;
      }
    } else if (!industry.equals(other.industry)) {
      return false;
    }
    if (linkToProfile == null) {
      if (other.linkToProfile != null) {
        return false;
      }
    } else if (!linkToProfile.equals(other.linkToProfile)) {
      return false;
    }
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else if (!location.equals(other.location)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }
}
