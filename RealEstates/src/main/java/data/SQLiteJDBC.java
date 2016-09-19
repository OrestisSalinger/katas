package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteJDBC {

  public Connection connect() {
    Connection c = null;
    try {
      Class.forName(Messages.getString("RealEstates.CLASS_NAME")); //$NON-NLS-1$
      c =  DriverManager.getConnection(Messages.getString("RealEstates.DB_NAME")); //$NON-NLS-1$
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() ); //$NON-NLS-1$
      System.exit(0);
    }
    System.out.println(Messages.getString("RealEstates.OPEN_MESSAGE")); //$NON-NLS-1$
    return c;
  }

}
