package eu.salingers.immo.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TestBathroom {
  static final class BathRoomFixture {
    static Bathroom standard = new Bathroom.Builder(1.5D)
        .withBathTubs(1)
        .withShowers(1)
        .withTowelWarmers(1)
        .build();
    static Bathroom standard2 = new Bathroom.Builder(1.5D)
        .withBathTubs(1)
        .withShowers(1)
        .withTowelWarmers(1)
        .build();
    static Bathroom standardWithDifferentTowelWarmers = new Bathroom.Builder(1.5D)
        .withBathTubs(1)
        .withShowers(1)
        .withTowelWarmers(2)
        .build();
    static Bathroom standardWithDifferentShowers = new Bathroom.Builder(1.5D)
        .withBathTubs(1)
        .withShowers(2)
        .withTowelWarmers(1)
        .build();
    static Bathroom standardWithDifferentBathtubs = new Bathroom.Builder(1.5D)
        .withBathTubs(2)
        .withShowers(1)
        .withTowelWarmers(1)
        .build();
    static Bathroom standardWithoutBathtubs = new Bathroom.Builder(1.5D)
        .withShowers(1)
        .withTowelWarmers(1)
        .build();
    static Bathroom standardWithoutBathtubs2 = new Bathroom.Builder(1.5D)
        .withShowers(1)
        .withTowelWarmers(1)
        .build();
    static Bathroom standardWithDifferentSquareMeters = new Bathroom.Builder(1.51D)
        .withBathTubs(1)
        .withShowers(1)
        .withTowelWarmers(1)
        .build();
    static Bathroom standardWithoutTowelWarmers = new Bathroom.Builder(1.5D)
        .withBathTubs(1)
        .withShowers(1)
        .build();
    static Bathroom standardWithoutTowelWarmers2 = new Bathroom.Builder(1.5D)
        .withBathTubs(1)
        .withShowers(1)
        .build();
    static Bathroom standardWithoutShowers = new Bathroom.Builder(1.5D)
        .withBathTubs(1)
        .withTowelWarmers(1)
        .build();
    static Bathroom standardWithoutShowers2 = new Bathroom.Builder(1.5D)
        .withBathTubs(1)
        .withTowelWarmers(1)
        .build();
  }
  @Test
  /**
   * A class is equal to itself.
   */
  public void equal_ToSelf() {

      assertTrue("Class equal to itself.", BathRoomFixture.standard.equals(BathRoomFixture.standard));
  }

  @Test
  /**
   * A class is equal to itself.
   */
  public void equal_ToDifferentBathroomWithSameAttributes() {

      assertTrue("Class equal to itself.", BathRoomFixture.standard.equals(BathRoomFixture.standard2));
 
  }
  
  /**
   * standard.equals(WrongType) must return false;
   *
   */
  @Test
  public void equal_passIncompatibleType_isFalse() {
      assertFalse("Passing incompatible object to equals should return false", BathRoomFixture.standard.equals("string"));
  }
  
  /**
   * standard.equals(null) must return false;
   *
   */
  @Test
  public void equal_nullReference_isFalse() {
      assertFalse("Passing null to equals should return false", BathRoomFixture.standard.equals(null));
  }
 
  @Test
  public void equal_otherBathtubsIsNull_isFalse() {
    assertFalse("Passing null to equals should return false", BathRoomFixture.standard.equals(BathRoomFixture.standardWithoutBathtubs));
  }
  @Test
  public void equal_otherShowersIsNull_isFalse() {
    assertFalse("Passing null to equals should return false", BathRoomFixture.standard.equals(BathRoomFixture.standardWithoutShowers));
  }
  @Test
  public void equal_otherTowelWarmerIsNull_isFalse() {
    assertFalse("Passing null to equals should return false", BathRoomFixture.standard.equals(BathRoomFixture.standardWithoutTowelWarmers));
  }
  
  @Test
  public void equal_bathtubsIsNullOtherBathtubsIsNotNull_isFalse() {
    assertFalse("Passing different Bathtubs to equals should return false", BathRoomFixture.standardWithoutBathtubs.equals(BathRoomFixture.standard));
  }
  @Test
  public void equal_showersIsNullOtherShowersIsNotNull_isFalse() {
    assertFalse("Passing both null showers to equals should return true.", BathRoomFixture.standardWithoutShowers.equals(BathRoomFixture.standard));
  }
  @Test
  public void equal_showersIsNullOtherShowersIsNull_isTrue() {
    assertTrue("Passing both null showers to equals should return true", BathRoomFixture.standardWithoutShowers.equals(BathRoomFixture.standardWithoutShowers2));
  }
  @Test
  public void equal_towelWarmerIsNullOtherTowelWarmerIsNotNull_isFalse() {
    assertFalse("Passing null towelWarmer to equals should return false", BathRoomFixture.standardWithoutTowelWarmers.equals(BathRoomFixture.standard));
  }
  @Test
  public void equal_towelWarmerNullOtherTowelWarmerIsNull_isTrue() {
    assertTrue("Passing both null showers to equals should return true.", BathRoomFixture.standardWithoutTowelWarmers.equals(BathRoomFixture.standardWithoutTowelWarmers2));
  }
  @Test
  public void equal_bathtubsIsNullOtherBathtubsIsNotNull_isTrue() {
    assertFalse("Passing null bathtubs to equals should return false", BathRoomFixture.standardWithoutBathtubs.equals(BathRoomFixture.standard));
  }
  @Test
  public void equal_bathtubsNullOtherBathtubsIsNull_isTrue() {
    assertTrue("Passing both null showers to equals should return true.", BathRoomFixture.standardWithoutBathtubs.equals(BathRoomFixture.standardWithoutBathtubs2));
  }
  @Test
  public void equal_squareMetersAreDifferent_isFalse() {
    assertFalse("Passing different squareMeters to equals should return false", BathRoomFixture.standard.equals(BathRoomFixture.standardWithDifferentSquareMeters));
  }
  
  
  /**
   * Repeated calls to hashcode should consistently return the same integer.
   */
  @Test
  public void hashcode_isConsistent() {
      int initial_hashcode = BathRoomFixture.standard.hashCode();
      assertEquals("Consistent hashcode test fails", initial_hashcode, BathRoomFixture.standard.hashCode());
      assertEquals("Consistent hashcode test fails", initial_hashcode, BathRoomFixture.standard.hashCode());
  }
  
  /**
   * Objects that are equal using the equals method should return the same integer.
   */
  @Test
  public void testHashcode_twoEqualsObjects_produceSameNumber() {
      int withStreetAndNumber = BathRoomFixture.standard.hashCode();
      int withStreetAndNumber2 = BathRoomFixture.standard2.hashCode();

      assertEquals("Equal object, return equal hashcode test fails", withStreetAndNumber, withStreetAndNumber2);
  }
  
  /**
   * A more optimal implementation of hashcode ensures
   * that if the objects are unequal different integers are produced.
   *
   */
  @Test
  public void hashcode_twoUnEqualObjects_produceDifferentNumber() {
      int standard = BathRoomFixture.standard.hashCode();
      int standardWithDifferentSquareMeters = BathRoomFixture.standardWithDifferentSquareMeters.hashCode();
      assertTrue("Equal object, return unequal hashcode test fails", !(standard == standardWithDifferentSquareMeters));
  }

  /*
   * bathtub != other.bathtub;
   *   
   */
  @Test
  public void hashcode_bathtubsIsNull_produceDifferentNumber() {
    assertFalse("Equal object, return unequal hashcode test fails", (BathRoomFixture.standardWithoutBathtubs.hashCode() == BathRoomFixture.standard.hashCode()));
  }

  /*
   * showers != other.showers;
   *   
   */
  @Test
  public void hashcode_showersIsNull_produceDifferentNumber() {
    assertFalse("Equal object, return unequal hashcode test fails", (BathRoomFixture.standardWithoutShowers.hashCode() == BathRoomFixture.standard.hashCode()));
  }
  /*
   * towlWarmer != other.towlWarmer;
   *   
   */
  @Test
  public void hashcode_towlWarmerIsNull_produceDifferentNumber() {
    assertFalse("Equal object, return unequal hashcode test fails", (BathRoomFixture.standardWithoutTowelWarmers.hashCode() == BathRoomFixture.standard.hashCode()));
  }
  

  @Test
  public void toString_twoEqualObjects_isEqual() {
    assertEquals(BathRoomFixture.standard.toString(), BathRoomFixture.standard2.toString());
  }

  @Test
  public void toString_twoUnequalObjects_isUnequal() {
    assertThat(BathRoomFixture.standard.toString(), not(equalTo(BathRoomFixture.standardWithDifferentSquareMeters.toString())));
  }
  
  @Test
  public void toString_withoutSquareMeters_isEqual() {
    Bathroom stub = Mockito.mock(Bathroom.class);
    Answer<Null> answer = new Answer<Null>() {
      public Null answer(InvocationOnMock invocation) throws Throwable {
        return null;
      }
    };
    Mockito.when(stub.getSquareMeters()).thenAnswer(answer);
    Mockito.when(stub.toString()).thenCallRealMethod();

    assertEquals("Bathroom []",stub.toString());
  }
  
  
  
  
}
