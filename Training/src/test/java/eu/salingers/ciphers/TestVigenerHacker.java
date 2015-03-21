package eu.salingers.ciphers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVigenerHacker {

	@Test
	public void hack_returnsDecryptionString() {
		VigenerHacker vigenerHacker = new VigenerHacker();
		final String key = "CRYPTO";
		final String expected = "WHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAYWHATANICEDAYTODAY";
		String toDecrypt = "ZZZJUCLUDTUNWGCQS";
		System.out.println("enc " + new Vigener().encrypt(key, expected));
		String hacked = vigenerHacker.hack(key.length(),toDecrypt);

		System.out.println("expected " + expected);
		System.out.println("actual   " + hacked);
		assertEquals(expected, hacked);
	}


}
