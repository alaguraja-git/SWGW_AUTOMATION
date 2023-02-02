package stepdefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.pages.DownloaderViewPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class SucessfullDownloaderSteps {
	
	private static final Logger LOGGER = LogManager.getLogger(SucessfullDownloaderSteps.class);
	private DownloaderViewPage DownloaderViewPage = new DownloaderViewPage(DriverFactory.getDriver());
	
	

}
