package eu.salingers.examples.unittests;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class TestUserNonsense {
	private static final String[] USER_DATA = new String[]{"hal",
		"hal@ibm.jcn", "binary"};
	private static final String[] USER_DATA_NAME_EMPTY = {"",
		"hal@ibm.jcn", "binary"};
	private static final String[] USER_DATA_LANGUAGE_EMPTY = {"hal",
		"hal@ibm.jcn", ""};
	private static final String[] USER_DATA_EMAIL_EMPTY ={"hal",
		"", "binary"};

	@Test
	public void getName() {
		assertEquals(USER_DATA[0], createUser(USER_DATA).getName());
	}

	@Test
	public void getEmail() {
		assertEquals(USER_DATA[1], createUser(USER_DATA).getEmail());
	}

	@Test
	public void getLanguage() {
		assertEquals(USER_DATA[2], createUser(USER_DATA).getLanguage());
	}

	@Test(expected=InvalidUserDataException.class)
	public void getValidUserData_userNameEmpty() throws InvalidUserDataException {
		createUser(USER_DATA_NAME_EMPTY).getValidUserData();
	}
	@Test(expected=InvalidUserDataException.class)
	public void getValidUserData_emailEmpty() throws InvalidUserDataException {
		createUser(USER_DATA_EMAIL_EMPTY).getValidUserData();
	}
	@Test(expected=InvalidUserDataException.class)
	public void getValidUserData_languageEmpty() throws InvalidUserDataException {
		createUser(USER_DATA_LANGUAGE_EMPTY).getValidUserData();
	}
	@Test(expected=InvalidUserDataException.class)
	public void getValidUserData_userNameNull() throws InvalidUserDataException {
		new User(null,USER_DATA[1],USER_DATA[2]).getValidUserData();
	}
	@Test(expected=InvalidUserDataException.class)
	public void getValidUserData_emailNull() throws InvalidUserDataException {
		new User(USER_DATA[0],null,USER_DATA[2]).getValidUserData();
	}
	@Test(expected=InvalidUserDataException.class)
	public void getValidUserData_languageNull() throws InvalidUserDataException {
		new User(USER_DATA[0],USER_DATA[1],null).getValidUserData();
	}
	@Test
	public void getValidUserData_dataValid_userDataEqualsInputData() throws InvalidUserDataException {
		System.out.println(createUser(USER_DATA).getValidUserData());
		assertEquals(Arrays.toString(USER_DATA),createUser(USER_DATA).getValidUserData());
	}










	private User createUser(final String data[]) {
		return new User(data[0], data[1], data[2]);
	}
}