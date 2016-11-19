package eu.salingers.immo.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.salingers.fixtures.ApartmentFixture;

public class TestApartment {

  @Test
  /**
   * A class is equal to itself.
   */
  public void equal_ToSelf() {

      assertTrue("Class equal to itself.", ApartmentFixture.standard.equals(ApartmentFixture.standard));
  }

  @Test
  /**
   * A class is equal to itself.
   */
  public void equal_TwoDifferentBathroomWithSameAttributes_isEqual() {
      assertTrue("Class equal to itself.", ApartmentFixture.standard.equals(ApartmentFixture.standard2));
 
  }
  
  /**
   * standard.equals(WrongType) must return false;
   *
   */
  @Test
  public void equal_passIncompatibleType_isFalse() {
      assertFalse("Passing incompatible object to equals should return false", ApartmentFixture.standard.equals("string"));
  }
  
  
  @Test
  public void equal_nullReference_isFalse() {
      assertFalse("Passing null to equals should return false", ApartmentFixture.standard.equals(null));
  }
 
  @Test
  public void equal_squareMetersIsDifferent_isFalse() {
    assertFalse("Passing different squareMeters to equals should return false", ApartmentFixture.standard.equals(ApartmentFixture.standardWithDifferentSquares));
  }
  @Test
  public void equal_otherBathroomsIsNull_isFalse() {
    assertFalse("Passing null to equals should return false", ApartmentFixture.standard.equals(ApartmentFixture.standardWithoutBathrooms));
  }
  @Test
  public void equal_otherRoomHasDifferentSquareMeters_isFalse() {
    assertFalse("Passing null to equals should return false", ApartmentFixture.standard.equals(ApartmentFixture.standardWithDifferentRoomSquares));
  }
  @Test
  public void equal_otherGardenIsNull_isFalse() {
    assertFalse("Passing null to equals should return false", ApartmentFixture.standard.equals(ApartmentFixture.standardWithoutGardens));
  }
  
  @Test
  public void equal_terrasseIsNullOtherTerrasseIsNotNull_isFalse() {
    assertFalse("Passing null TERRASSE to equals should return false", ApartmentFixture.standardWithoutTerrasse.equals(ApartmentFixture.standard));
  }
  @Test
  public void equal_roomIsNullOtherRoomIsNotNull_isFalse() {
    assertFalse("Passing null TERRASSE to equals should return false", ApartmentFixture.standardWithoutRooms2.equals(ApartmentFixture.standard));
  }

  @Test
  public void equal_terrasseIsNullOtherTerrasseIsNull_isTrue() {
    assertTrue("Passing both null TERRASSE to equals should return true", ApartmentFixture.standardWithoutTerrasse.equals(ApartmentFixture.standardWithoutTerrasse2));
  }
  
  @Test
  public void equal_oneTerrasseOtherTwoTerrasses_isFalse() {
    assertFalse("Passing Apartment with different number of terrasses to equals should return false", ApartmentFixture.standard.equals(ApartmentFixture.standardWithDifferentNumberOfTerrasses));
  }

  @Test
  public void equal_differentTerrasseSquareMeters_isFalse() {
    assertFalse("Passing Apartment with different terrasses terrasses square meters to equals should return false", ApartmentFixture.standard.equals(ApartmentFixture.standardWithDifferentTerrasseSquareMeters));
  }
  
  @Test
  public void equal_roomIsNullOtherRoomIsNull_isTrue() {
    assertTrue("Passing null Apartment to equals should return true.", ApartmentFixture.standardWithoutRooms.equals(ApartmentFixture.standardWithoutRooms2));
  }
  
  @Test
  public void equal_gardenIsNullOtherGardenIsNotNull_isFalse() {
    assertFalse("Passing null Garden to equals should return false", ApartmentFixture.standardWithoutGardens.equals(ApartmentFixture.standard));
  }
  
  @Test
  public void equal_gardenIsNullOtherGardenIsNull_isTrue() {
    assertTrue("Passing null Garden to equals should return true", ApartmentFixture.standardWithoutGardens.equals(ApartmentFixture.standardWithoutGardens2));
  }

  @Test
  public void equal_bathroomIsNullOtherBathroomIsNotNull_isFalse() {
    assertFalse("Passing null Bathroom to equals should return false", ApartmentFixture.standardWithoutBathrooms.equals(ApartmentFixture.standard));
  }
  
  @Test
  public void equal_bathroomIsNullOtherBathroomIsNull_isTrue() {
    assertTrue("Passing null Bathroom to equals should return true", ApartmentFixture.standardWithoutBathrooms.equals(ApartmentFixture.standardWithoutBathrooms2));
  }
  
  
//  /**
//   * Repeated calls to hashcode should consistently return the same integer.
//   */
//  @Test
//  public void hashcode_isConsistent() {
//      int initial_hashcode = ApartmentFixture.standard.hashCode();
//      assertEquals("Consistent hashcode test fails", initial_hashcode, ApartmentFixture.standard.hashCode());
//      assertEquals("Consistent hashcode test fails", initial_hashcode, ApartmentFixture.standard.hashCode());
//  }
//  
//  /**
//   * Objects that are equal using the equals method should return the same integer.
//   */
//  @Test
//  public void testHashcode_twoEqualsObjects_produceSameNumber() {
//      int withStreetAndNumber = ApartmentFixture.standard.hashCode();
//      int withStreetAndNumber2 = ApartmentFixture.standard2.hashCode();
//
//      assertEquals("Equal object, return equal hashcode test fails", withStreetAndNumber, withStreetAndNumber2);
//  }
//  
//  /**
//   * A more optimal implementation of hashcode ensures
//   * that if the objects are unequal different integers are produced.
//   *
//   */
//  @Test
//  public void hashcode_twoUnEqualObjects_produceDifferentNumber() {
//      int standard = ApartmentFixture.standard.hashCode();
//      int standardWithDifferentSquareMeters = ApartmentFixture.standardWithDifferentSquareMeters.hashCode();
//      assertTrue("Equal object, return unequal hashcode test fails", !(standard == standardWithDifferentSquareMeters));
//  }
//
//  /*
//   * bathtub != other.bathtub;
//   *   
//   */
//  @Test
//  public void hashcode_bathtubsIsNull_produceDifferentNumber() {
//    assertFalse("Equal object, return unequal hashcode test fails", (ApartmentFixture.standardWithoutBathtubs.hashCode() == ApartmentFixture.standard.hashCode()));
//  }
//
//  /*
//   * showers != other.showers;
//   *   
//   */
//  @Test
//  public void hashcode_showersIsNull_produceDifferentNumber() {
//    assertFalse("Equal object, return unequal hashcode test fails", (ApartmentFixture.standardWithoutShowers.hashCode() == ApartmentFixture.standard.hashCode()));
//  }
//  /*
//   * towlWarmer != other.towlWarmer;
//   *   
//   */
//  @Test
//  public void hashcode_towlWarmerIsNull_produceDifferentNumber() {
//    assertFalse("Equal object, return unequal hashcode test fails", (ApartmentFixture.standardWithoutTowelWarmers.hashCode() == ApartmentFixture.standard.hashCode()));
//  }
//  
//
//  @Test
//  public void toString_twoEqualObjects_isEqual() {
//    assertEquals(ApartmentFixture.standard.toString(), ApartmentFixture.standard2.toString());
//  }
//
//  @Test
//  public void toString_twoUnequalObjects_isUnequal() {
//    assertThat(ApartmentFixture.standard.toString(), not(equalTo(ApartmentFixture.standardWithDifferentSquares.toString())));
//  }
//  
//  @Test
//  public void toString_withoutSquareMeters_isEqual() {
//    Bathroom stub = Mockito.mock(Bathroom.class);
//    Mockito.when(stub.getSquareMeters()).thenAnswer(new Answer<Null>() {
//      public Null answer(InvocationOnMock invocation) throws Throwable {
//        return null;
//      }
//    });
//    Mockito.when(stub.toString()).thenCallRealMethod();
//
//    assertEquals("Bathroom []",stub.toString());
//  }
//  
  
  
  
}
