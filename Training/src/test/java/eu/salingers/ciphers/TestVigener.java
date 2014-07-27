package eu.salingers.ciphers;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestVigener {

	private Vigener create() {
		Vigener vigener = new Vigener();
		return vigener;
	}

	@Test
	public void encryp_keySmallerThanMessage_keyArrayLengthEqualsMessageLength() {
		final Vigener vigener = create();

		final String messageToEncrypt = "WHATANICEDAYTODAYHEREINWHEREVERWEARE";
		char[] encrypted = vigener.createKeyArray("CRYPTO",messageToEncrypt.length());

		assertEquals(messageToEncrypt.length() , encrypted.length);
	}

	@Test
	public void encryp_keySmallerThanMessage_keyArrayFilledAsExpected() {
		final Vigener vigener = create();
		final char[] expected = new char[]{'C','R','Y','P','T','O','C','R','Y','P','T','O','C','R','Y','P','T'};

		char[] encrypted = vigener.createKeyArray("CRYPTO","WHATANICEDAYTODAY".length());

		assertArrayEquals(expected , encrypted);
	}

	@Test
	public void encrypt_returnsEncryptionString() {
		Vigener vigener = create();
		final String key = "CRYPTO";
		final String messageToEncrypt = "WHATANICEDAYTODAY";
		String encrypted = vigener.encrypt(key,messageToEncrypt);
		String expected = "ZZZJUCLUDTUNWGCQS";
		System.out.println("expected " + expected);
		System.out.println("actual   " + encrypted);
		assertEquals(expected, encrypted);
	}

	@Test
	public void decrypt_returnsDecryptionString() {
		Vigener vigener = create();
		final String key = "CRYPTO";
		final String expected = "WHATANICEDAYTODAY";
		String toDecrypt = "ZZZJUCLUDTUNWGCQS";

		String decrypted = vigener.decrypt(key,toDecrypt);

		System.out.println("expected " + expected);
		System.out.println("actual   " + decrypted);
		assertEquals(expected, decrypted);
	}

	@Test
	public void encrypt2_returnsEncryptionString() {
		Vigener vigener = create();
		final String key = "CRYPTO";
		final String messageToEncrypt = "WHATANICEDAYTODAYANDTOMORROW";
		String encrypted = vigener.encrypt(key,messageToEncrypt);
		String expected = "ZZZJUCLUDTUNWGCQSPQVSEGDUJNM";
		System.out.println("expected " + expected);
		System.out.println("actual   " + encrypted);
		assertEquals(expected, encrypted);
	}

	@Test
	public void decrypt2_returnsDecryptionString() {
		Vigener vigener = create();
		final String key = "CRYPTO";
		final String expected = "WHATANICEDAYTODAYANDTOMORROW";
		String toDecrypt = "ZZZJUCLUDTUNWGCQSPQVSEGDUJNM";

		String decrypted = vigener.decrypt(key,toDecrypt);

		System.out.println("expected " + expected);
		System.out.println("actual   " + decrypted);
		assertEquals(expected, decrypted);
	}



}
