package eu.salingers.immo.model;

import org.junit.Ignore;
import org.junit.Test;

public class TestRealEstate {
  static final class Fixture {
    static Apartment apartment = new Apartment
        .Builder(123.1)
        .build();
  }

  @Ignore
  @Test
  public void constructObject_setAllAttributes_allAttributesKept() {
//    RealEstate realEstate = new RealEstate();
//    final Address address = new Address.Builder(Country.SWITZERLAND, "Zip").withCity("City").build();
//    realEstate.setAddress(address);
//    realEstate.setApartments(Arrays.asList(Fixture.apartment));
//    realEstate.setId(1L);
//    realEstate.setFloors(1);
//    realEstate.setCategory(RealEstateCategory.APPARTMENT_BUILDING);
//    realEstate.setMacro(Site.A);
//    realEstate.setMeso(Site.A);
//    realEstate.setMicro(Site.A);
//    realEstate.setOwner(new Person.Builder("firstName","familyName",address).build());
//    realEstate.setState(State.NEW);
//    realEstate.setBuiltDate(LocalDate.of(2001, Month.JANUARY, 1));
//    realEstate.setLastRenovationDate(LocalDate.of(2001, Month.JANUARY, 1));
//    assertNotNull(realEstate);
//    System.out.println(realEstate);
  }

}
