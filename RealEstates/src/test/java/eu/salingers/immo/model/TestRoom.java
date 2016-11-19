package eu.salingers.immo.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import eu.salingers.immo.model.TestAddress.AddressFixture;

public class TestRoom {
  static final class RoomFixture {
    private static final Garden garden = new Garden.Builder(123.1D).build();
    static Room standard = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardDiffSquareMeters = new Room
        .Builder(1.1D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutWindowCount = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutWindowCount2 = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithDiffWindowCount = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(2)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutWidth = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutWidth2 = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withLenght(1.3f)
        .build();
    static Room standardWithDiffWidth = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.1f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutLength = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .build();
    static Room standardWithoutLength2 = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .build();
    static Room standardWithDiffLength = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withLenght(1.1f)
        .withWidth(1.2f)
        .build();
    static Room standardWithDiffHeight = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.2f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutHeight = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutHeight2 = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithGarden = new Room
        .Builder(1.5D)
        .withGardens(Arrays.asList(garden))
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithGarden2 = new Room
        .Builder(1.5D)
        .withGardens(Arrays.asList(garden))
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithDiffGarden = new Room
        .Builder(1.5D)
        .withGardens(Arrays.asList(garden,garden))
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithTerrace = new Room
        .Builder(1.5D)
        .withTerraces(Arrays.asList(new Terrace(123.1D)))
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithTerrace2 = new Room
        .Builder(1.5D)
        .withTerraces(Arrays.asList(new Terrace(123.1D)))
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithDiffTerrace = new Room
        .Builder(1.5D)
        .withTerraces(Arrays.asList(new Terrace(123.2D)))
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithFloorType = new Room
        .Builder(1.5D)
        .withFloorType("floorType")
        .withDoorCount(2)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithDiffFloorType = new Room
        .Builder(1.5D)
        .withFloorType("A")
        .withDoorCount(2)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithFloorType2 = new Room
        .Builder(1.5D)
        .withFloorType("floorType")
        .withDoorCount(2)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutDoorCount = new Room
        .Builder(1.5D)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutDoorCount2 = new Room
        .Builder(1.5D)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithBalcony = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withBalconies(Arrays.asList(new Balcony(123.1D)))
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithBalcony2 = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withBalconies(Arrays.asList(new Balcony(123.1D)))
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithDiffBalcony = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withBalconies(Arrays.asList(new Balcony(123.2D),new Balcony(123.3D)))
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutFloor = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardWithoutFloor2 = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standard2 = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standard3 = new Room
        .Builder(1.5D)
        .withDoorCount(1)
        .withWindowCount(1)
        .withFloor(1)
        .withHeatingType(HeatingType.OVEN)
        .withHeight(1.1f)
        .withWidth(1.2f)
        .withLenght(1.3f)
        .build();
    static Room standardDiffHeatingType = new Room
      .Builder(1.5D)
      .withDoorCount(1)
      .withWindowCount(1)
      .withFloor(1)
      .withHeatingType(HeatingType.DISTRICT_HEAT)
      .withHeight(1.1f)
      .withWidth(1.2f)
      .withLenght(1.3f)
      .build();
}

  @Test
  /**
   * A class is equal to itself.
   */
  public void equal_ToSelf() {

      assertTrue("Class equal to itself.", RoomFixture.standard.equals(RoomFixture.standard));
  }

  /**
   * standard.equals(WrongType) must return false;
   *
   */
  @Test
  public void passIncompatibleType_isFalse() {
      assertFalse("Passing incompatible object to equals should return false", RoomFixture.standard.equals("string"));
  }
  
  /**
   * standard.equals(null) must return false;
   *
   */
  @Test
  public void nullReference_isFalse() {
      assertFalse("Passing null to equals should return false", RoomFixture.standard.equals(null));
  }
  
  /**
   * 1. x, x.equals(x) must return true.
   * 2. x and y, x.equals(y) must return true if and only if y.equals(x) returns true.
   */
  @Test
  public void equals_isReflexive_isSymmetric() {
      assertTrue("Reflexive test fail withoutStreetAndNumber,withStreetAndNumber", RoomFixture.standard.equals(RoomFixture.standard2));
      assertTrue("Symmetric test fail withStreetAndNumber", AddressFixture.withStreetAndNumber2.equals(AddressFixture.withStreetAndNumber));
  }

  /**
   * 1. x.equals(y) returns true
   * 2. y.equals(z) returns true
   * 3. x.equals(z) must return true
   */
  @Test
  public void equals_isTransitive() {
      assertTrue("Transitive test fails standard,withBalconyTerrasseAndGarden2", RoomFixture.standard.equals(RoomFixture.standard2));
      assertTrue("Transitive test fails withBalconyTerrasseAndGarden2,standard3", RoomFixture.standard2.equals(RoomFixture.standard3));
      assertTrue("Transitive test fails standard,standard3", RoomFixture.standard.equals(RoomFixture.standard3));
  }
  
  /**
   * Repeated calls to equals consistently return true or false.
   */
  @Test
  public void equals_isConsistent() {
      assertTrue("Consistent test fail standard,withBalconyTerrasseAndGarden2", RoomFixture.standard.equals(RoomFixture.standard2));
      assertTrue("Consistent test fail standard,withBalconyTerrasseAndGarden2", RoomFixture.standard.equals(RoomFixture.standard2));
      assertTrue("Consistent test fail standard,withBalconyTerrasseAndGarden2", RoomFixture.standard.equals(RoomFixture.standard2));
      assertFalse(RoomFixture.standard.equals(RoomFixture.standardDiffHeatingType));
      assertFalse(RoomFixture.standard.equals(RoomFixture.standardDiffHeatingType));
      assertFalse(RoomFixture.standard.equals(RoomFixture.standardDiffHeatingType));
  }
  
  /**
   * squareMeters == other.squareMeters
   * return false;
   * 
   */
  @Test
  public void equals_differentSquareMeters_returnsFalse() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardDiffSquareMeters));
  }
  
  /**
   *if (balconies != null) {
   * if (other.balconies == null)
   *      return false;
   * 
   */
  @Test
  public void equals_balconiesIsNotNullOtherBalconiesIsNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithBalcony.equals(RoomFixture.standard));
  }

  /**
   *if (balconies == null) {
   * if (other.balconies != null)
   *      return true;
   * 
   */
  @Test
  public void equals_balconiesIsNullOtherBalconiesIsNotNull_returnsTrue() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithBalcony));
  }

  /**
   * balconies == other.balconies
   * return true;
   * 
   */
  @Test
  public void equals_balconiesAreSame_returnsTrue() {
    assertTrue(RoomFixture.standardWithBalcony.equals(RoomFixture.standardWithBalcony2));
  }
  
  /**
   *if (doorCount == null) {
   * if (other.doorCount != null)
   *      return false;
   * 
   */
  @Test
  public void equals_doorCountIsNullOtherDoorCountIsNotNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithoutDoorCount.equals(RoomFixture.standard));
  }

  /**
   *if (doorCount == null) {
   * if (other.doorCount == null)
   *      return true;
   * 
   */
  @Test
  public void equals_doorCountIsNullOtherDoorCountIsNull_returnsTrue() {
    assertTrue(RoomFixture.standardWithoutDoorCount.equals(RoomFixture.standardWithoutDoorCount2));
  }

  /**
   *if (doorCount != null) {
   * if (other.doorCount == null)
   *      return false;
   * 
   */
  @Test
  public void equals_doorCountIsNotNullOtherDoorCountIsNull_returnsFalse() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithoutDoorCount));
  }

  /**
   * doorCount == other.doorCount
   * return true;
   * 
   */
  @Test
  public void equals_doorCountAreSame_returnsTrue() {
    assertTrue(RoomFixture.standard.equals(RoomFixture.standard2));
  }
 
  /**
   *if (windowCount == null) {
   * if (other.windowCount != null)
   *      return false;
   * 
   */
  @Test
  public void equals_windowCountIsNullOtherWindowCountIsNotNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithoutWindowCount.equals(RoomFixture.standard));
  }
  
  /**
   *if (windowCount == null) {
   * if (other.windowCount == null)
   *      return true;
   * 
   */
  @Test
  public void equals_windowCountIsNullOtherWindowCountIsNull_returnsTrue() {
    assertTrue(RoomFixture.standardWithoutWindowCount.equals(RoomFixture.standardWithoutWindowCount2));
  }
  
  /**
   *if (windowCount != null) {
   * if (other.windowCount == null)
   *      return false;
   * 
   */
  @Test
  public void equals_windowCountIsNotNullOtherWindowCountIsNull_returnsFalse() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithoutWindowCount));
  }
  
  /**
   * windowCount == other.windowCount
   * return true;
   * 
   */
  @Test
  public void equals_windowCountAreSame_returnsTrue() {
    assertTrue(RoomFixture.standard.equals(RoomFixture.standard2));
  }
  
  /**
   *if (floor == null) {
   * if (other.floor != null)
   *      return false;
   * 
   */
  @Test
  public void equals_floorIsNullOtherfloorIsNotNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithoutFloor.equals(RoomFixture.standard));
  }
  
  /**
   *if (floor != null) {
   * if (other.floor == null)
   *      return false;
   * 
   */
  @Test
  public void equals_floorIsNotNullOtherfloorIsNull_returnsFalse() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithoutFloor));
  }
  
  /**
   *if (floor == null) {
   * if (other.floor == null)
   *      return true;
   * 
   */
  @Test
  public void equals_floorIsNotNullOtherfloorIsNotNull_returnsTrue() {
    assertTrue(RoomFixture.standardWithoutFloor.equals(RoomFixture.standardWithoutFloor2));
  }
  
  /**
   *if (floorType == null) {
   * if (other.floorType != null)
   *      return false;
   * 
   */
  @Test
  public void equals_floorTypeIsNullOtherfloorIsNotNull_returnsTrue() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithFloorType));
  }

  /**
   *if (floorType != null) {
   * if (other.floorType != null)
   *      return true;
   * 
   */
  @Test
  public void equals_floorTypeIsNotNullOtherfloorIsNotNull_returnsTrue() {
    assertTrue(RoomFixture.standardWithFloorType.equals(RoomFixture.standardWithFloorType2));
  }

  /**
   * floorType != other.floorType
   * return false;
   * 
   */
  @Test
  public void equals_doorCountAreDifferent_returnsFalse() {
    assertFalse(RoomFixture.standardWithFloorType.equals(RoomFixture.standardWithDiffFloorType));
  }
  
  /**
   *if (garden == null) {
   * if (other.garden != null)
   *      return false;
   * 
   */
  @Test
  public void equals_gardenIsNullOtherGardenIsNotNull_returnsTrue() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithGarden));
  }
  
  /**
   *if (garden != null) {
   * if (other.garden == null)
   *      return false;
   * 
   */
  @Test
  public void equals_gardenIsNotNullOtherGardenIsNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithGarden.equals(RoomFixture.standard));
  }

  /**
   * garden != other.garden)
   *      return false;
   * 
   */
  @Test
  public void equals_gardenIsDifferent_returnsFalse() {
    assertFalse(RoomFixture.standardWithGarden.equals(RoomFixture.standardWithDiffGarden));
  }
  
  /**
   * garden == other.garden)
   *      return true;
   * 
   */
  @Test
  public void equals_gardenAreSame_returnsTrue() {
    assertTrue(RoomFixture.standardWithGarden.equals(RoomFixture.standardWithGarden2));
  }
  /**
   *if (terrace == null) {
   * if (other.terrace != null)
   *      return false;
   * 
   */
  @Test
  public void equals_terraceIsNullOtherTerraceIsNotNull_returnsTrue() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithTerrace));
  }
  
  /**
   *if (terrace != null) {
   * if (other.terrace == null)
   *      return false;
   * 
   */
  @Test
  public void equals_terraceIsNotNullOtherTerraceIsNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithTerrace.equals(RoomFixture.standard));
  }
  
  /**
   * terrace != other.terrace)
   *      return false;
   * 
   */
  @Test
  public void equals_terraceIsDifferent_returnsFalse() {
    assertFalse(RoomFixture.standardWithTerrace.equals(RoomFixture.standardWithDiffTerrace));
  }
  
  /**
   * terrace == other.terrace)
   *      return true;
   * 
   */
  @Test
  public void equals_terraceAreSame_returnsTrue() {
    assertTrue(RoomFixture.standardWithTerrace.equals(RoomFixture.standardWithTerrace2));
  }
  
  /**
   *if (height == null) {
   * if (other.height != null)
   *      return false;
   * 
   */
  @Test
  public void equals_heightIsNullOtherHeightIsNotNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithoutHeight.equals(RoomFixture.standard));
  }
  
  /**
   *if (height == null) {
   * if (other.height == null)
   *      return true;
   * 
   */
  @Test
  public void equals_heightIsNullOtherHeightIsNull_returnsTrue() {
    assertTrue(RoomFixture.standardWithoutHeight.equals(RoomFixture.standardWithoutHeight2));
  }
  
  /**
   *if (height != null) {
   * if (other.height == null)
   *      return false;
   * 
   */
  @Test
  public void equals_heightIsNotNullOtherHeightIsNull_returnsTrue() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithoutHeight));
  }
  
  /**
   * height != other.height)
   *      return false;
   * 
   */
  @Test
  public void equals_heightIsDifferent_returnsFalse() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithDiffHeight));
  }
  
  /**
   * height == other.height)
   *      return true;
   * 
   */
  @Test
  public void equals_heightAreSame_returnsTrue() {
    assertTrue(RoomFixture.standard.equals(RoomFixture.standard2));
  }
  
  /**
   *if (length == null) {
   * if (other.length != null)
   *      return false;
   * 
   */
  @Test
  public void equals_lengthIsNullOtherLengthIsNotNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithoutLength.equals(RoomFixture.standard));
  }
  
  /**
   *if (length == null) {
   * if (other.length == null)
   *      return true;
   * 
   */
  @Test
  public void equals_lengthIsNullOtherLengthIsNull_returnsTrue() {
    assertTrue(RoomFixture.standardWithoutLength.equals(RoomFixture.standardWithoutLength2));
  }
  
  /**
   *if (length != null) {
   * if (other.length == null)
   *      return false;
   * 
   */
  @Test
  public void equals_lengthIsNotNullOtherLengthIsNull_returnsTrue() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithoutLength));
  }
  
  /**
   * length != other.length)
   *      return false;
   * 
   */
  @Test
  public void equals_lengthIsDifferent_returnsFalse() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithDiffLength));
  }
  
  /**
   * length == other.length)
   *      return true;
   * 
   */
  @Test
  public void equals_lengthAreSame_returnsTrue() {
    assertTrue(RoomFixture.standard.equals(RoomFixture.standard2));
  }
  /**
   *if (width == null) {
   * if (other.width != null)
   *      return false;
   * 
   */
  @Test
  public void equals_widthIsNullOtherWidthIsNotNull_returnsFalse() {
    assertFalse(RoomFixture.standardWithoutWidth.equals(RoomFixture.standard));
  }
  
  /**
   *if (width == null) {
   * if (other.width == null)
   *      return true;
   * 
   */
  @Test
  public void equals_widthIsNullOtherWidthIsNull_returnsTrue() {
    assertTrue(RoomFixture.standardWithoutWidth.equals(RoomFixture.standardWithoutWidth2));
  }
  
  /**
   *if (width != null) {
   * if (other.width == null)
   *      return false;
   * 
   */
  @Test
  public void equals_widthIsNotNullOtherWidthIsNull_returnsTrue() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithoutWidth));
  }
  
  /**
   * width != other.width)
   *      return false;
   * 
   */
  @Test
  public void equals_widthIsDifferent_returnsFalse() {
    assertFalse(RoomFixture.standard.equals(RoomFixture.standardWithDiffWidth));
  }
  
  /**
   * width == other.width)
   *      return true;
   * 
   */
  @Test
  public void equals_widthAreSame_returnsTrue() {
    assertTrue(RoomFixture.standard.equals(RoomFixture.standard2));
  }

  @Test
  public void toString_standard_isEqual() {
    assertEquals("Room [squareMeters=1.5, windowCount=1, doorCount=1, lenght=1.3, width=1.2, height=1.1, floor=1, heatingType=OVEN, ]", RoomFixture.standard.toString());
  }
  
  @Test
  public void toString_standardWithFloorTypeOtherWithSameFloorType_isEqual() {
    assertEquals(RoomFixture.standardWithFloorType.toString().toString(), RoomFixture.standardWithFloorType.toString());
  }

  @Test
  public void toString_standardWithBalconyOtherWithBalcony_isEqual() {
    assertEquals(RoomFixture.standardWithBalcony.toString(), RoomFixture.standardWithBalcony2.toString());
  }

  @Test
  public void toString_standardWithGardenOtherWithGarden_isEqual() {
    assertEquals(RoomFixture.standardWithGarden.toString(), RoomFixture.standardWithGarden.toString());
  }

  @Test
  public void toString_standardWithTerraceOtherWithTerrace_isEqual() {
    assertEquals(RoomFixture.standardWithTerrace.toString(), RoomFixture.standardWithTerrace2.toString());
  }

  @Test
  public void toString_standardWithoutDoorCount_isEqual() {
    assertEquals("Room [squareMeters=1.5, windowCount=1, lenght=1.3, width=1.2, height=1.1, floor=1, heatingType=OVEN, ]", RoomFixture.standardWithoutDoorCount.toString());
  }

  @Test
  public void toString_withoutSquareMeters_isEqual() {
    Room stub = Mockito.mock(Room.class);
    Mockito.when(stub.getSquareMeters()).thenAnswer(new Answer<Null>() {
      public Null answer(InvocationOnMock invocation) throws Throwable {
        return null;
      }
    });
    Mockito.when(stub.toString()).thenCallRealMethod();

    assertEquals("Room []",stub.toString());
  }
  
  /**
   * Repeated calls to hashcode should consistently return the same integer.
   */
  @Test
  public void hashcode_isConsistent() {
      int initial_hashcode = RoomFixture.standard.hashCode();
     
      assertEquals("Consistent hashcode test fails", initial_hashcode, RoomFixture.standard.hashCode());
      assertEquals("Consistent hashcode test fails", initial_hashcode, RoomFixture.standard.hashCode());
  }
  
  /**
   * Objects that are equal using the equals method should return the same integer.
   */
  @Test
  public void testHashcode_twoEqualsObjects_produceSameNumber() {
      int standard = RoomFixture.standard.hashCode();
      int standard2 = RoomFixture.standard2.hashCode();

      assertEquals("Equal object, return equal hashcode test fails", standard, standard2);
  }
  
  /**
   * A more optimal implementation of hashcode ensures
   * that if the objects are unequal different integers are produced.
   *
   */
  @Test
  public void hashcode_twoUnEqualObjects_produceDifferentNumber() {
      int standard = RoomFixture.standard.hashCode();
      int standardWithoutDoorCount = RoomFixture.standardWithoutDoorCount.hashCode();

      assertTrue("Equal object, return unequal hashcode test fails", !(standard == standardWithoutDoorCount));
  }

  /*
   * city != other.city;
   *   
   */
  @Test
  public void hashcode_doorCountDifferent_produceDifferentNumber() {
    assertFalse("Equal object, return unequal hashcode test fails", (RoomFixture.standardWithoutDoorCount.hashCode() == RoomFixture.standard.hashCode()));
  }

  /*
   * country != other.country;
   *   
   */
  @Test
  public void hashcode_windowCountIsDifferent_produceDifferentNumber() {
    assertFalse("Equal object, return unequal hashcode test fails", (RoomFixture.standard.hashCode() == RoomFixture.standardWithDiffWindowCount.hashCode()));
  }
  
}
