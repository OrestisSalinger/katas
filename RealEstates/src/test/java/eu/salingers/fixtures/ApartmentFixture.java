package eu.salingers.fixtures;

import java.util.Arrays;
import java.util.List;

import eu.salingers.immo.model.Apartment;
import eu.salingers.immo.model.Bathroom;
import eu.salingers.immo.model.Garden;
import eu.salingers.immo.model.Room;
import eu.salingers.immo.model.Terrace;

public final class ApartmentFixture {
  private final static List<Room> ROOMS = Arrays.asList(new Room.Builder(10.1D).build());
  private final static List<Room> ROOMS_DIFF_SQUAREMETERS = Arrays.asList(new Room.Builder(10.2D).build());
  private final static List<Bathroom> BATHROOMS = Arrays.asList(new Bathroom.Builder(10.1D).build());
  private final static List<Garden> GARDENS = Arrays.asList(new Garden.Builder(10.1D).build());
  private final static List<Terrace> TERRASSE = Arrays.asList(new Terrace(10.1D));
  private final static List<Terrace> TERRASSE2ITEMS = Arrays.asList(new Terrace(10.1D), new Terrace(10.1D));
  private final static List<Terrace> TERRASSE_DIFF_SQUAREMETERS = Arrays.asList(new Terrace(10.2D));
  public final static Apartment standard = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withBathRooms(BATHROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standard2 = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withBathRooms(BATHROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithoutBathrooms = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithoutRooms2 = new Apartment.Builder(100.1D)
      .withBathRooms(BATHROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithDifferentNumberOfTerrasses = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withBathRooms(BATHROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE2ITEMS)
      .build();
  public final static Apartment standardWithDifferentTerrasseSquareMeters = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withBathRooms(BATHROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE_DIFF_SQUAREMETERS)
      .build();
  public final static Apartment standardWithDifferentSquares = new Apartment.Builder(100.2D)
      .withRooms(ROOMS)
      .withBathRooms(BATHROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithDifferentRoomSquares = new Apartment.Builder(100.1D)
      .withRooms(ROOMS_DIFF_SQUAREMETERS)
      .withBathRooms(BATHROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithoutRooms = new Apartment.Builder(100.1D)
      .withBathRooms(BATHROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithoutBathrooms2 = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withGardens(GARDENS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithoutGardens = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withBathRooms(BATHROOMS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithoutGardens2 = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withBathRooms(BATHROOMS)
      .withTerrasses(TERRASSE)
      .build();
  public final static Apartment standardWithoutTerrasse = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withGardens(GARDENS)
      .withBathRooms(BATHROOMS)
      .build();
  public final static Apartment standardWithoutTerrasse2 = new Apartment.Builder(100.1D)
      .withRooms(ROOMS)
      .withGardens(GARDENS)
      .withBathRooms(BATHROOMS)
      .build();
      
}