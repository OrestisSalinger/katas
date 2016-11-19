package eu.salingers.data;

public class DBConnectException extends RuntimeException {
  private static final long serialVersionUID = -1966636468967956593L;

  public DBConnectException(Exception e) {
    super(e);
}


}
