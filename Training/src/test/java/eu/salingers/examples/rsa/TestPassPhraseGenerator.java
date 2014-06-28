package eu.salingers.examples.rsa;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;

public class TestPassPhraseGenerator {

	private final String ADDRESS = "Orestis Salinger, Haldenstrasse 16, 8335 Hittnau";
	private final String TEXT_LONG = "Rindfleischetikettierungsueberwachungsaufgabenuebertragungsgesetz";
	private final String TEXT_SHORT1 = "VFs";
	private final String TEXT_SHORT2 = "P";

	@Test(dataProvider="phrases",invocationCount=100)
	public void textToNumber(String object) {
		PassPhraseGenerator generator = new PassPhraseGenerator();

		BigInteger[] numbers = generator.textToNumber(object);
		String numberToText = generator.numberToText(numbers);
		assertEquals(object, numberToText);
		System.out.println(Arrays.toString(numbers) + "\nBack to text: " + numberToText );
	}

	@Test
	public void textToNumberToPublicKey() {
		String pass1 = TEXT_SHORT1;
		String pass2 = TEXT_SHORT2;
		PassPhraseGenerator generator = new PassPhraseGenerator();
		BigInteger[] numbers1 = generator.textToNumber(pass1);
		BigInteger[] numbers2 = generator.textToNumber(pass2);
		String numberToText1 = generator.numberToText(numbers1);
		String numberToText2 = generator.numberToText(numbers2);
		System.out.println(numbers1[0] + " is prime = " + numbers1[0].isProbablePrime(100));
		System.out.println(numbers2[0] + " is prime = " + numbers2[0].isProbablePrime(1));

		String publicKey = generator.getPublicKey(numbers1[0],numbers2[0]);


		System.out.println(Arrays.toString(numbers1) + "\nBack to text: " + numberToText1 );
		System.out.println(Arrays.toString(numbers1) + "\nBack to text: " + numberToText2 );


		assertEquals(pass1, numberToText1);

	}



	@DataProvider(name = "phrases")
	public String[][] phrases() {
		return new String[][] {{ADDRESS},{TEXT_LONG},{TEXT_SHORT1},{TEXT_SHORT2}};

	}


}
