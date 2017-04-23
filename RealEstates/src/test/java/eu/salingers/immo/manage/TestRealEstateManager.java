package eu.salingers.immo.manage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsIterableWithSize;
import org.hamcrest.core.Is;
import org.junit.Test;

import eu.salingers.fixtures.ApartmentFixture;
import eu.salingers.immo.model.Apartment;
import eu.salingers.immo.model.Building;

public class TestRealEstateManager {

  @Test
  public void addApartment_addOneApartment_oneApartmentInManager() {
    RealEstateManager manager = new RealEstateManager();
    final Apartment apartment = ApartmentFixture.standard;
    manager.addAppartment(apartment);
    List<Apartment> apartmentList = manager.getApartments();
    assertThat(apartmentList.size(),equalTo(1));
  }

  @Test
  public void addApartment_addOneApartment_managerReturnsSameApartment() {
    RealEstateManager manager = new RealEstateManager();
    final Apartment apartment = ApartmentFixture.standard;
    manager.addAppartment(apartment);
    List<Apartment> apartmentList = manager.getApartments();
    assertThat(apartmentList, hasItem(apartment));
  }

  @Test
  public void addApartments_addTwoDifferentApartment_managerReturnsTwoApartments() {
    RealEstateManager manager = new RealEstateManager();
    final Apartment apartment = ApartmentFixture.standard;
    final Apartment differentApartment = ApartmentFixture.standardWithDifferentRoomSquares;
    manager.addAppartments(Arrays.asList(new Apartment[]{apartment,differentApartment}));
    
    List<Apartment> apartmentList = manager.getApartments();
    
    assertThat(apartmentList, IsIterableWithSize.iterableWithSize(2));
  }

  @Test
  public void addApartments_addTwoDifferentApartment_managerReturnsSameTwoApartments() {
    RealEstateManager manager = new RealEstateManager();
    final Apartment apartment = ApartmentFixture.standard;
    final Apartment differentApartment = ApartmentFixture.standardWithDifferentRoomSquares;
    manager.addAppartments(Arrays.asList(new Apartment[]{apartment,differentApartment}));
    
    List<Apartment> apartmentList = manager.getApartments();
    
    assertThat(apartmentList, hasItem(apartment));
    assertThat(apartmentList, hasItem(differentApartment));
  }
  
  @Test
  public void createBuilding_addBuildingTwoAppartmentsDiffSquares_managerReturnsBuildingWithTwoApartmentsOfDiffSquares() {
    RealEstateManager manager = new RealEstateManager();
    
    final Apartment apartment = ApartmentFixture.standard;

    final Apartment differentApartment = ApartmentFixture.standardWithDifferentSquares;
    
    manager.addAppartments(Arrays.asList(new Apartment[]{apartment,differentApartment}));
    final Building building = manager.createBuilding();
    
    assertThat(building.getApartments().get(0).getSquareMeters(), Is.is(100.1));
    assertThat(building.getApartments().get(1).getSquareMeters(), Is.is(100.2));
  }
  
  
  
  
}
