package eu.salingers.synchronize;

import java.util.Arrays;

import org.testng.annotations.Test;

public class TestSynchronizer {

	@Test(threadPoolSize = 1000, invocationCount = 10000)
	public void synchronize_methodOnly_measureSpeed() {
		eu.salingers.synchronize.Synchronizer synchro = new Synchronizer();
		synchro.synch();
		printMapToConsole(synchro);

	}

	@Test( threadPoolSize = 1000, invocationCount = 10000)
	public void synchronize_methodAndBlock_measureSpeed() {
	  eu.salingers.synchronize.Synchronizer synchro = new Synchronizer();
	  synchro.synchCascade();
	  printMapToConsole(synchro);
  }



	private void printMapToConsole(eu.salingers.synchronize.Synchronizer synchro) {
		System.out.println("printMapToConsole\n" + Arrays.toString(synchro.getMap().keySet().toArray()));
		System.out.println(Arrays.toString(synchro.getMap().values().toArray()));
	}


}
