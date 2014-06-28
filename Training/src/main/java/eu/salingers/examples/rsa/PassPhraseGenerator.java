package eu.salingers.examples.rsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PassPhraseGenerator {
	// final static List<String> alphabet = new ArrayList<>(Arrays.asList("a",
	// "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
	// "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A",
	// "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
	// "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " ",
	// "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ",", ".",";"));
	final List<String> alphabet = new ArrayList<>(Arrays.asList("C",
			"K", "V", "1", "w", "v", "o", "X", "H", "F", "p", "P", "t", "E",
			"7", "L", "B", ",", "U", "N", "l", "O", "x", "6", "g", "A", "T",
			"n", "3", "0","ü", ".", "a", "b", "I", "Y", "f", "Q", "k", "9", "d",
			" ", "Z", ";", "h", "D", "8", "R", "r", "i", "J", "y", "W", "2",
			"m", "s", "5", "c", "q", "G", "M", "e", "4", "z", "j", "S", "u"));

	protected PassPhraseGenerator() {
	}

	public BigInteger[] textToNumber(String text) {
		StringBuilder result = new StringBuilder();
		StringBuilder key = new StringBuilder();
		for (int i = 1; i <= text.length(); i++) {
			String split = text.split("")[i];
			int indexOf = alphabet.indexOf(split);
			int temp = indexOf > 9 ? 1 : 0;
			key.append(String.valueOf(temp));
			result.append(String.valueOf(indexOf));
		}
		return new BigInteger[] { new BigInteger(result.toString()),
				new BigInteger(key.toString()) };
	}

	public String numberToText(final BigInteger[] number) {
		String code = String.valueOf(number[0]);
		String[] key = String.valueOf(number[1]).split("");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < key.length; i++) {
			if (key[i].isEmpty()) {
				continue;
			} else if (key[i].equals("0")) {
				String temp = code.substring(0, 1);
				code = code.substring(1, code.length());
				result.append(alphabet.get(Integer.parseInt(temp)));
			} else if (key[i].equals("1")) {
				String temp = code.substring(0, 2);
				code = code.substring(2, code.length());
				result.append(alphabet.get(Integer.parseInt(temp)));
			}
		}
		return result.toString();
	}

	public String getPublicKey(BigInteger num1, BigInteger num2) {




		return null;
	}

}
