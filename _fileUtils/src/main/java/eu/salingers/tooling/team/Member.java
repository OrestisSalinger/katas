package eu.salingers.tooling.team;

/**
 * @author orestis
 *
 */
public class Member {
  private String lastName;
  private String firstName;
  private String Company;
  private TeamRole role;

  /**
   * @param lastName
   * @param firstName
   * @param company
   * @param role
   */
  public Member(String lastName, String firstName, String company, TeamRole role) {
    this.lastName = lastName;
    this.firstName = firstName;
    Company = company;
    this.role = role;
  }

  public TeamRole getRole() {
    return role;
  }

  public void setRole(TeamRole role) {
    this.role = role;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getCompany() {
    return Company;
  }

  @Override
  public String toString() {
    return "\nMember [" + (lastName != null ? "lastName=" + lastName + "," : "") + (firstName != null ? "firstName=" + firstName + "," : "")
        + (Company != null ? "Company=" + Company + ", " : "") + (role != null ? "role=" + role : "") + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Company == null) ? 0 : Company.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Member other = (Member) obj;
    if (Company == null) {
      if (other.Company != null)
        return false;
    } else if (!Company.equals(other.Company))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    return true;
  }

}
