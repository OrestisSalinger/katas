package eu.salingers.tooling.servers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import eu.salingers.tooling.servers.brute.TestBruteServers;
import eu.salingers.tooling.servers.data.file.TestCSVHandling;
import eu.salingers.tooling.servers.model.pages.TestReadHtmlPageData;
import eu.salingers.tooling.servers.stress.StressTestLogin;

@RunWith(Suite.class)
@SuiteClasses({ TestAllEnvironmentsResponseCode.class, TestCSVHandling.class, TestReadHtmlPageData.class,
    TestServerMapping.class, TestBruteServers.class, StressTestLogin.class })

public class AllRunningTests {

}
