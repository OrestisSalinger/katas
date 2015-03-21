package eu.salingers.ciphers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VigenerHacker {
	private final String mostUsed = "E";
	private final String secondMostUsed = "T";

	private final static List<String> commons = new ArrayList<String>(){
		private static final long serialVersionUID = -1415408639140761610L;
		{
			add("E");
			add("T");
			add("A");
			add("O");
			add("I");
			add("N");
			add("S");
			add("R");
			add("H");
			add("D");
			add("L");
			add("U");
			add("C");
			add("M");
			add("F");
			add("Y");
			add("W");
			add("G");
			add("P");
			add("B");
			add("V");
			add("K");
			add("X");
			add("Q");
			add("J");
			add("Z");
		}
	};
	private String alphabet = Arrays.toString(Vigener.alphabet).replace(",", "").replace("[","").replace("]", "").replace(" ","");

	public String hack(int keyLength, String toDecrypt) {
		System.out.println("cry " + toDecrypt);
		final String[] split = split(keyLength, toDecrypt);
		List<List<String>> sorted = new ArrayList<List<String>>();

		System.out.println(Arrays.toString(split));
		for (int i = 0; i < keyLength; i++) {
			String[] temp = extractByIndex(split, i);
			System.out.println(i + " temp " + Arrays.toString(temp));
			sorted.add(Arrays.asList(temp));
		}
		for (int i = 0; i < sorted.size(); i++) {
			System.out.println(i+ " " + Arrays.toString(sorted.get(i).toArray()));
		}



		final int subtract = findIndexInAlpha('T') - findIndexInAlpha('E');
		System.out.println("T-E "+ " (" + (subtract+1) + ") "+ alphabet.charAt(subtract));

		return null;
	}

	private int findIndexInAlpha(char c) {
		System.out.println("Alphabet "+alphabet);
		System.out.println("looking for "+c);

		final int indexOf = alphabet.indexOf(c);

		System.out.println("index "+indexOf);


		return indexOf;
	}

	private String[] extractByIndex(String[] split,int index) {
		String[] result = new String[split.length];
		int i = 0;
		String substring;
		for (String s :split) {
			try{
			substring = String.valueOf(s.charAt(index));
			}catch(StringIndexOutOfBoundsException e){
				substring = "";
			}

			System.out.println("letter " + (index+1) + " " + substring.trim());
			result[i++] = substring.trim();
		}

		return result;
	}

	private String[] split(int keyLength, String toDecrypt) {
		return toDecrypt.split(createSplitRegEx(keyLength));
	}

	private String createSplitRegEx(int keyLength) {
		return "(?<=\\G.{"+keyLength+"})";
	}

}
