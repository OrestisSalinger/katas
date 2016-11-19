package eu.salingers.immo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TestAddress {
  static final class AddressFixture {
    static Address withoutStreetAndNumber = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .build();
    static Address withoutStreetAndNumber2 = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .build();
    static Address withStreetWithoutNumber = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreet("Street")
        .build();
    static Address withoutStreetAndNumberDiffCity = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("a")
        .build();
    static Address withoutStreetAndNumberDiffCountry = new Address
        .Builder(Country.GERMANY,"Zip")
        .withCity("City")
        .build();
    static Address withoutStreetAndNumberDiffZip = new Address
        .Builder(Country.SWITZERLAND,"Zipa")
        .withCity("City")
        .build();
    static Address withoutStreetAndNumberAndCity = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .build();
    static Address withoutStreetAndNumberCityNull2 = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .build();
    static Address withStreetAndNumber = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreetAndNumber("Street","1a")
        .build();
    static Address withStreetAndNumber2 = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreetAndNumber("Street","1a")
        .build();
    static Address withStreetAndDifferentNumber = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreetAndNumber("Street","1b")
        .build();
    static Address withStreetAndNumber3 = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreetAndNumber("Street","1a")
        .build();
    static Address withDiffStreetAndNumber = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreetAndNumber("Streeta","1b")
        .build();
    static Address withDiffNumber = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreetAndNumber("Street","1b")
        .build();
    static Address withStreet1 = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreet("Street")
        .build();
    static Address withDiffStreet = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("City")
        .withStreet("Streeta")
        .build();
    static Address withStreetDiffCity = new Address
        .Builder(Country.SWITZERLAND,"Zip")
        .withCity("Citya")
        .withStreet("Street")
        .build();
    }

  @Test
  /**
   * A class is equal to itself.
   */
  public void equal_ToSelf() {

      assertTrue("Class equal to itself.", AddressFixture.withoutStreetAndNumber.equals(AddressFixture.withoutStreetAndNumber));
  }

  /**
   * withoutStreetAndNumber.equals(WrongType) must return false;
   *
   */
  @Test
  public void passIncompatibleType_isFalse() {
      assertFalse("Passing incompatible object to equals should return false", AddressFixture.withoutStreetAndNumber.equals("string"));
  }
  
  /**
   * withoutStreetAndNumber.equals(null) must return false;
   *
   */
  @Test
  public void nullReference_isFalse() {
      assertFalse("Passing null to equals should return false", AddressFixture.withoutStreetAndNumber.equals(null));
  }

  /**
   * 1. x, x.equals(x) must return true.
   * 2. x and y, x.equals(y) must return true if and only if y.equals(x) returns true.
   */
  @Test
  public void equals_isReflexive_isSymmetric() {
      assertTrue("Reflexive test fail withoutStreetAndNumber,withStreetAndNumber", AddressFixture.withStreetAndNumber.equals(AddressFixture.withStreetAndNumber2));
      assertTrue("Symmetric test fail withStreetAndNumber", AddressFixture.withStreetAndNumber2.equals(AddressFixture.withStreetAndNumber));
  }

  /**
   * 1. x.equals(y) returns true
   * 2. y.equals(z) returns true
   * 3. x.equals(z) must return true
   */
  @Test
  public void equals_isTransitive() {
      assertTrue("Transitive test fails withStreetAndNumber,withStreetAndNumber2", AddressFixture.withStreetAndNumber.equals(AddressFixture.withStreetAndNumber2));
      assertTrue("Transitive test fails withStreetAndNumber2,withStreetAndNumber3", AddressFixture.withStreetAndNumber2.equals(AddressFixture.withStreetAndNumber3));
      assertTrue("Transitive test fails withStreetAndNumber,withStreetAndNumber3", AddressFixture.withStreetAndNumber.equals(AddressFixture.withStreetAndNumber3));
  }
  
  /**
   * Repeated calls to equals consistently return true or false.
   */
  @Test
  public void equals_isConsistent() {
      assertTrue("Consistent test fail withStreetAndNumber,withStreetAndNumber2", AddressFixture.withStreetAndNumber.equals(AddressFixture.withStreetAndNumber2));
      assertTrue("Consistent test fail withStreetAndNumber,withStreetAndNumber2", AddressFixture.withStreetAndNumber.equals(AddressFixture.withStreetAndNumber2));
      assertTrue("Consistent test fail withStreetAndNumber,withStreetAndNumber2", AddressFixture.withStreetAndNumber.equals(AddressFixture.withStreetAndNumber2));
      assertFalse(AddressFixture.withStreetAndNumber.equals(AddressFixture.withoutStreetAndNumber));
      assertFalse(AddressFixture.withStreetAndNumber.equals(AddressFixture.withoutStreetAndNumber));
      assertFalse(AddressFixture.withStreetAndNumber.equals(AddressFixture.withoutStreetAndNumber));
  }

  
  /**
   *if (city == null) {
   * if (other.city != null)
   *      return false;
   * 
   */
  @Test
  public void equals_cityIsNullOtherCityIsNotNull_equalReturnsFalse() {
    assertFalse(AddressFixture.withoutStreetAndNumberAndCity.equals(AddressFixture.withoutStreetAndNumber));
  }
  
  /**
   *if (city == null) {
   * if (other.city != null)
   *      return false;
   * 
   */
  @Test
  public void equals_cityIsNullOtherCityIsNull_equalReturnsTrue() {
    assertTrue(AddressFixture.withoutStreetAndNumberAndCity.equals(AddressFixture.withoutStreetAndNumberCityNull2));
  }

  /**
   *if (city == null) {
   * if (other.city != null)
   *      return false;
   * 
   */
  @Test
  public void equals_differentCity_returnsFalse() {
    assertFalse(AddressFixture.withoutStreetAndNumber.equals(AddressFixture.withoutStreetAndNumberDiffCity));
  }
  
  /**
   * street == null
   * other.street != null
   * 
   */
  @Test
  public void equals_streetIsNullOtherStreetIsNotNull_equalReturnsFalse() {
    assertFalse(AddressFixture.withoutStreetAndNumber.equals(AddressFixture.withStreetAndNumber));
  }
  
  /**
   * street != null
   * other.street == null
   * 
   */
  @Test
  public void equals_streetIsNotNullOtherStreetIsNull_equalReturnsFalse() {
    assertFalse(AddressFixture.withStreetAndNumber.equals(AddressFixture.withoutStreetAndNumber));
  }
  
  /**
   * street == null
   * other.street == null
   * 
   */
  @Test
  public void equals_streetIsNullOtherStreetIsNull_equalReturnsTrue() {
    assertTrue(AddressFixture.withoutStreetAndNumber.equals(AddressFixture.withoutStreetAndNumber));
  }

  /**
   * street != null
   * other.street != null
   * 
   */
  @Test
  public void equals_streetIsNotNullOtherStreetIsNotNull_equalReturnsTrue() {
    assertTrue(AddressFixture.withStreetAndNumber.equals(AddressFixture.withStreetAndNumber2));
  }
  
  /**
   * streetNumber == null
   * other.street != null
   * 
   */
  @Test
  public void equals_streetNumberIsNullOtherStreetNumberIsNotNull_equalReturnsFalse() {
    assertFalse(AddressFixture.withStreetWithoutNumber.equals(AddressFixture.withStreetAndNumber));
  }

  /**
   * streetNumber == null
   * other.street != null
   * 
   */
  @Test
  public void equals_streetAndNumberOtherStreetNumberIsDifferent_returnsFalse() {
    assertFalse(AddressFixture.withStreetAndNumber.equals(AddressFixture.withStreetAndDifferentNumber));
  }

  /**
   * zip != other.zip
   * 
   */
  @Test
  public void equals_withoutStreetAndNumberOtherZipIsDifferent_returnsFalse() {
    assertFalse(AddressFixture.withoutStreetAndNumber.equals(AddressFixture.withoutStreetAndNumberDiffZip));
  }
  
  
  /**
   * if (country != other.country)
   *  return false;
   */
  @Test
  public void equals_cityIsNullOtherCityIsNull_equalReturnsFalse() {
    assertFalse(AddressFixture.withoutStreetAndNumber.equals(AddressFixture.withoutStreetAndNumberDiffCountry));
  }

  
  
  @Test
  public void toString_withStreetAndNumber_isEqual() {
    assertEquals("Address [country=SWITZERLAND, city=City, zip=Zip, street=Street, streetNumber=1a]", AddressFixture.withStreetAndNumber.toString());
  }
  
  @Test
  public void toString_withoutStreetAndNumberAndCity_isEqual() {
    assertEquals("Address [country=SWITZERLAND, zip=Zip, ]", AddressFixture.withoutStreetAndNumberAndCity.toString());
  }

  @Test
  public void toString_withoutCountry_isEqual() {
    Address stub = Mockito.mock(Address.class);
    Mockito.when(stub.getCountry()).thenAnswer(new Answer<Null>() {
      public Null answer(InvocationOnMock invocation) throws Throwable {
        return null;
      }
    });
    Mockito.when(stub.toString()).thenCallRealMethod();

    assertEquals("Address []",stub.toString());
  }
  
  
  
  /**
   * Repeated calls to hashcode should consistently return the same integer.
   */
  @Test
  public void hashcode_isConsistent() {
      int initial_hashcode = AddressFixture.withStreetAndNumber.hashCode();
     
      assertEquals("Consistent hashcode test fails", initial_hashcode, AddressFixture.withStreetAndNumber.hashCode());
      assertEquals("Consistent hashcode test fails", initial_hashcode, AddressFixture.withStreetAndNumber.hashCode());
  }
  
  /**
   * Objects that are equal using the equals method should return the same integer.
   */
  @Test
  public void testHashcode_twoEqualsObjects_produceSameNumber() {
      int withStreetAndNumber = AddressFixture.withStreetAndNumber.hashCode();
      int withStreetAndNumber2 = AddressFixture.withStreetAndNumber2.hashCode();

      assertEquals("Equal object, return equal hashcode test fails", withStreetAndNumber, withStreetAndNumber2);
  }
  
  /**
   * A more optimal implementation of hashcode ensures
   * that if the objects are unequal different integers are produced.
   *
   */
  @Test
  public void hashcode_twoUnEqualObjects_produceDifferentNumber() {
      int withStreetAndNumber = AddressFixture.withStreetAndNumber.hashCode();
      int withoutStreetAndNumber = AddressFixture.withoutStreetAndNumber.hashCode();

      assertTrue("Equal object, return unequal hashcode test fails", !(withStreetAndNumber == withoutStreetAndNumber));
  }

  /*
   * city != other.city;
   *   
   */
  @Test
  public void hashcode_cityIsDifferent_produceDifferentNumber() {
    assertFalse("Equal object, return unequal hashcode test fails", (AddressFixture.withoutStreetAndNumberAndCity.hashCode() == AddressFixture.withoutStreetAndNumber.hashCode()));
  }

  /*
   * country != other.country;
   *   
   */
  @Test
  public void hashcode_countryIsDifferent_produceDifferentNumber() {
    assertFalse("Equal object, return unequal hashcode test fails", (AddressFixture.withoutStreetAndNumberDiffCountry.hashCode() == AddressFixture.withoutStreetAndNumber.hashCode()));
  }
    
}
