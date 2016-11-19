package eu.salingers.immo.model;

public enum Country {
  SWITZERLAND("CH"), 
  GERMANY("DE");

  String countryCode;
  Country(String countryCode){
    this.countryCode = countryCode;
  }
}
