package eu.salingers.tooling.servers.data.file;

public enum MandantoryServerCSVFields {
  //url;js_enabled;login;username;password;
  URL("url"),
  JAVASCRIPT_ENABLED("javascriptEnabled"),
  LOGIN("login"),
  USERNAME("username"),
  PASSWORD("password");
  
  
  private final String name;

  /**
   * @param text
   * @return 
   */
  private MandantoryServerCSVFields(final String name) {
      this.name = name;
  }

  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
      return name;
  }
  
  
}
