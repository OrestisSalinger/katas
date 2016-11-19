package eu.salingers.immo.model;

import java.time.LocalDate;

public class Person {
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
