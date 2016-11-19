package eu.salingers.immo.model;

import java.time.LocalDate;

public class Person {
  @Override
  public String toString() {
    return "Person [" + (firstName != null ? "firstName=" + firstName + ", " : "")//NOSONAR
        + (familyName != null ? "familyName=" + familyName + ", " : "")
        + (phoneNumber != null ? "phoneNumber=" + phoneNumber + ", " : "")
        + (dateOfBirth != null ? "dateOfBirth=" + dateOfBirth + ", " : "") + (address != null ? "address=" + address + ", " : "")
        + (email != null ? "email=" + email + ", " : "") + (url != null ? "url=" + url : "") + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = prime * result + ((url == null) ? 0 : url.hashCode());
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
    Person other = (Person) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (dateOfBirth == null) {
      if (other.dateOfBirth != null)
        return false;
    } else if (!dateOfBirth.equals(other.dateOfBirth))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (familyName == null) {
      if (other.familyName != null)
        return false;
    } else if (!familyName.equals(other.familyName))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    } else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    if (url == null) {
      if (other.url != null)
        return false;
    } else if (!url.equals(other.url))
      return false;
    return true;
  }

  private String firstName;

  private String familyName;

  private String phoneNumber;

  private LocalDate dateOfBirth;

  private Address address;

  private String email;

  private String url;

  public static class Builder {

    private String firstName;

    private String familyName;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private Address address;

    private String email;

    private String url;

    /**
     * @param firstName
     * @param familyName
     * @param address
     */
    Builder(String firstName, String familyName, Address address) {
      this.firstName = firstName;
      this.familyName = familyName;
      this.address = address;
    }

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder familyName(String familyName) {
      this.familyName = familyName;
      return this;
    }

    public Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Builder dateOfBirth(LocalDate dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public Builder address(Address address) {
      this.address = address;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder url(String url) {
      this.url = url;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }

  private Person(Builder builder) {
    this.firstName = builder.firstName;
    this.familyName = builder.familyName;
    this.phoneNumber = builder.phoneNumber;
    this.dateOfBirth = builder.dateOfBirth;
    this.address = builder.address;
    this.email = builder.email;
    this.url = builder.url;
  }
}
