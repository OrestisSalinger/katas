package eu.salingers.katas.primefactor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static eu.salingers.katas.primefactor.PrimeFactors.generate;
public class TestPrimeFactors {

	@Test(dataProvider="provideNumbers")
	public void generatePrimeFactors(Map<List<Integer>, Integer> map) throws Exception {
		for (Entry<List<Integer>, Integer> entry : map.entrySet()) {
			assertEquals(entry.getKey(),generate( entry.getValue()));
		}
	  }

	@DataProvider(name = "provideNumbers")
	public Object[][] provideData() {
		Map<List<Integer>, Integer> map = new HashMap<>();
		map.put(new ArrayList<Integer>(java.util.Collections.<Integer> emptyList()),1);
		map.put(list(2),2);
		map.put(list(3),3);
		map.put(list(2,2),4);
		map.put(list(2,3),6);
		map.put(list(2,2,2),8);
		map.put(list(3,3),9);
		map.put(list(2,5),10);
		map.put(list(2,2,3),12);
		map.put(list(2,7),14);
		map.put(list(3,5),15);
		map.put(list(2,2,2,2),16);
		map.put(list(2,3,3),18);
		map.put(list(2,2,5),20);
		map.put(list( 2, 2, 2, 2, 2, 2, 3, 3, 3),1728);
		map.put(list( 3, 283, 3413),2_897_637);
		map.put(list(3, 83, 116371),2_897_637_9);
		return new Object[][] { { map } };
	}

	private ArrayList<Integer> list(Integer... ints) {
		return new ArrayList<Integer>(Arrays.asList(ints));
	}



}