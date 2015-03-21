package eu.salingers.synchronize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Synchronizer {

	private static Logger LOGGER;

	static {
		LOGGER = Logger.getLogger(Synchronizer.class.getName());
		try {
			Logger.getLogger(Synchronizer.class.getName()).addHandler(
					new FileHandler("synchro.log"));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private Map<String, String> map = new HashMap<>();

	private static final Object monitor = new Object();

	public synchronized void synchCascade() {
		synchronized (monitor) {
			final String msg = "Cascaded synch Thread: "
					+ Thread.currentThread();
			System.out.println(msg);
			LOGGER.info(msg);
			map.put("Test " + new SimpleDateFormat().format(new Date()), msg);
		}

	}

	public synchronized void synch() {
		final String msg = "Method synch Thread: " + Thread.currentThread();
		System.out.println(msg);
		LOGGER.info(msg);
		map.put("Test " + new SimpleDateFormat().format(new Date()), msg);
	}

	/**
	 * @return map
	 */
	final Map<String, String> getMap() {
		return map;
	}

	void setMap(Map<String, String> map) {
		this.map = map;
	}

}
