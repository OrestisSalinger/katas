package eu.salingers.ciphers;


public class Vigener {

	private static final String[] alphabet = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

	public String encrypt(String key, String messageToEncrypt) {
		char[] keySplit = createKeyArray(key, messageToEncrypt.length());
		char[] messageSplit = messageToEncrypt.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < messageSplit.length; i++) {
			final int mod = (messageSplit[i] + keySplit[i]) % alphabet.length + 1;
			sb.append(alphabet[mod]);
		}
		return sb.toString();
	}

	public String decrypt(String key, String toDecrypt) {
		char[] keySplit = createKeyArray(key, toDecrypt.length());
		char[] messageSplit = toDecrypt.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < messageSplit.length; i++) {
			int mod = (messageSplit[i]-keySplit[i])% alphabet.length-1 ;

			final String enc = mod>=0?alphabet[mod]:alphabet[mod+alphabet.length];
			sb.append(enc);
		}
		return sb.toString();
	}

	protected char[] createKeyArray(String key, int length) {
		char[] keys = new char[length];
		final int keyLength = key.length();
		System.out.println("keyLength: " + keyLength);
		fillKeyBuffer(key, keys);
		return keys;
	}

	private void fillKeyBuffer(String key, char[] keys) {
		for (int i = 0; i < keys.length; i++) {
			keys[i] = findChar(key, i);
		}
	}

	private char findChar(String key, int i) {
		return key.charAt((int) (i - findIndex(key, i)));
	}

	private double findIndex(String key, int i) {
		return key.length() * Math.ceil(i / key.length());
	}


}
