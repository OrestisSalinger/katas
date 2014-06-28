package eu.salingers.examples.unittests;

public class User {

	private final String name;
	private final String email;
	private final String language;

	public User(final String name, final String email, final String language) {
		this.name = name;
		this.email = email;
		this.language = language;
	}

	public final String getName() {
		return name;
	}

	public final String getEmail() {
		return email;
	}

	public final String getLanguage() {
		return language;
	}

	public String getValidUserData() throws InvalidUserDataException {
		if (isValid(name) && isValid(email)
				&& isValid(language)) {
			return "[" +name + ", " + email + ", " + language + "]";
		} else {
			throw new InvalidUserDataException("Invalid User Values");
		}
	}

	private boolean isValid(final String str) {
		return isNotNull(str) && str.length() > 0;
	}

	private boolean isNotNull(final Object obj) {
		return obj != null;
	}
}