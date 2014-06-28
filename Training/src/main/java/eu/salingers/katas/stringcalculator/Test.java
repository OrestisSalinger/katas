package eu.salingers.katas.stringcalculator;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Test {
	private Collection<String> collection;

	@BeforeClass
	private void setUpSomeState() {
	// Do something...
	}
	@AfterClass
	private void tearDownSomeState() {
	// Do something...
	}

	@Before
	private void setUpOnEachTest() {
		collection = new ArrayList<>();
	}
	@After
	private void cleanUpOnEachTest() {
		collection.clear();
	}














	public Collection<String> getCollection() {
		return collection;
	}

	public void setCollection(Collection<String> collection) {
		this.collection = collection;
	}
}
