package data;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.*;
import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.core.Is;
import org.junit.Test;
import java.sql.*;

public class TestDBConnection {

  @Test
  public void connect_sqlLiteDB_connectionNotNull() throws SQLException {
    SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
    Connection connection = sqLiteJDBC.connect();
    assertNotNull(connection);
  }
  
  @Test
  public void connect_sqlLiteDB_connectionNotClosed() throws SQLException {
    SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
    Connection connection = sqLiteJDBC.connect();
    assertFalse(connection.isClosed());
  }
  
  @Test
  public void connect_sqlLiteDB_connectionCanBeClosed() throws SQLException {
    SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
    Connection connection = sqLiteJDBC.connect();
    assertNotNull(connection);
    assertFalse(connection.isClosed());
    connection.close();
    assertTrue(connection.isClosed());
  }
  
  
  

}
