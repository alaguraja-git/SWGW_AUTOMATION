package stepdefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.pages.DownloaderViewPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class DownloaderViewSteps {
	
	private static final Logger LOGGER = LogManager.getLogger(DownloaderViewSteps.class);
	private DownloaderViewPage DownloaderViewPage = new DownloaderViewPage(DriverFactory.getDriver());
	
	
	
	@Then("click on download view icon at top left corner of the page")
	public void click_on_download_view_icon_at_top_left_corner_of_the_page() {
		
		LOGGER.info("Clicking Downloader view icon");
		DownloaderViewPage.clickDownloadViewIcon();
		LOGGER.info("Sucessfully Clicked Downloader view icon");
	}
	
	
	@Then("check whether tabs of download view is displayed")
	public void check_whether_taps_of_download_view_is_displayed(DataTable downloaderViewTable) {
		
		int tot_count = DownloaderViewPage.getDownloadViewCount();
		
		System.out.println("Total Downloader View List count is"+tot_count);
		LOGGER.info("Total Downloader View List count is"+tot_count);
		
		List<String> ExpDownloaderViewList = downloaderViewTable.asList();
		System.out.println("Expected Downloader View List :"+ExpDownloaderViewList);
		LOGGER.info("Expected Downloader View List :"+ExpDownloaderViewList);
		
		List<String> ActDownloaderViewList = DownloaderViewPage.getDownloadViewList();
		System.out.println("Actual Downloader View List :"+ActDownloaderViewList);
		LOGGER.info("Actual Downloader View List :"+ActDownloaderViewList);
		
		Assert.assertTrue(ExpDownloaderViewList.containsAll(ActDownloaderViewList));	
	
	}
	
	
	
	@Then("click on My Target gropus")
	public void click_on_my_target_gropus() {
		
		LOGGER.info("Clicking My Target Groups");
		DownloaderViewPage.clickMyTargetGroups();
		LOGGER.info("Sucessfully Clicked My Target Groups");
	    
	}
	
	@Then("check the presence of four Tabs within My Target Groups")
	public void check_the_presence_of_four_tabs_within_my_target_groups(DataTable myTargetGroupTable) {
		
		List<String> ExpMyGroupViewList = myTargetGroupTable.asList();
		System.out.println("Expected Downloader View List :"+ExpMyGroupViewList);
		LOGGER.info("Expected Downloader View List :"+ExpMyGroupViewList);
		
		DownloaderViewPage.getMyTargetGroupList();
		
		
	}
	
	@Then("click on the EUFT Target Group")
	public void click_on_the_euft_target_group() throws InterruptedException {
		
		LOGGER.info("Clicking EUFT Target Groups");
		DownloaderViewPage.clickEUFTActiveTargetGroups();
		Thread.sleep(1000);
		LOGGER.info("Sucessfully Clicked EUFT Target Groups");
	}
	
	
	
	@Then("click on the EUFT Target Group which is blocked")
	public void click_on_the_euft_target_group_which_is_blocked() {
		LOGGER.info("Clicking EUFT Target Groups");
		DownloaderViewPage.clickEUPTTargetRecord();
		LOGGER.info("Sucessfully Clicked EUFT Target Groups");
	}
	
	@Then("check the presence of three taps in EUFT Target Groups")
	public void check_the_presence_of_three_taps_in_euft_target_groups(DataTable EUPSTargetTable) {
		int tot_count = DownloaderViewPage.getEUFTTargetCount();
		
		System.out.println("Total EUFT Target List count is"+tot_count);
		LOGGER.info("Total EUFT Target List count is"+tot_count);
		
		List<String> ExpEUFTTargetList = EUPSTargetTable.asList();
		System.out.println("Expected Downloader View List :"+ExpEUFTTargetList);
		LOGGER.info("Expected Downloader View List :"+ExpEUFTTargetList);
		
		List<String> ActEUFTTargetViewList = DownloaderViewPage.getEUFTTargetViewList();
		System.out.println("Actual EUFT View List :"+ActEUFTTargetViewList);
		LOGGER.info("Actual EUFT View List :"+ActEUFTTargetViewList);
		
		Assert.assertTrue(ExpEUFTTargetList.containsAll(ActEUFTTargetViewList));
	}
	
	@Then("click on Tickets tap")
	public void click_on_tickets_tap() {
		LOGGER.info("BEFORE CLICKING TICKETS TAB");
		DownloaderViewPage.clickTicketsTab();
	}

	@Then("expand the ticket from whih box needs to be displayed")
	public void expand_the_ticket_from_whih_box_needs_to_be_displayed() {
		LOGGER.info("BEFORE CLICKING TICKETS EXPAND BUTTON");
		DownloaderViewPage.clickTicketExpand();
	}

	@Then("select the box that needs to be downloaded")
	public void select_the_box_that_needs_to_be_downloaded() {
		LOGGER.info("BEFORE CLICKING TICKETS EXPAND CHECK BOX");
		DownloaderViewPage.clickTicketExpandCheckBox();
	}

	@Then("click on Download button")
	public void click_on_download_button() throws InterruptedException {
		LOGGER.info("BEFORE CLICKING DOWNLOAD BUTTON");
		DownloaderViewPage.clickTicketDownloadButton();
		Thread.sleep(9000);
	}

	@Then("Alert Message should be displayed")
	public void alert_message_should_be_displayed() {
		String expAlertMessage = "CXP 903 0161/4 R1A could not be delivered to this customer - Please contact SW Gateway Support via https://ericsson.sharepoint.com/sites/SwGateway/SitePages/Rev%20B%205%20Support.aspx";
		String actAlertMEssage = DownloaderViewPage.getAlertBoxMessageAndValidate();
		Assert.assertTrue(expAlertMessage.equalsIgnoreCase(actAlertMEssage));
	}
	

	
	@Then("Alert is displayed with message {string}")
	public void alert_is_displayed_with_message(String expectedMessage) {
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expAlertMessage = "CXP 903 0161/4 R1A could not be delivered to this customer - Please contact SW Gateway Support via https://ericsson.sharepoint.com/sites/SwGateway/SitePages/Rev%20B%205%20Support.aspx";
		System.out.println("Expected Alert Message :"+expAlertMessage);
		LOGGER.info("Expected Alert Message :"+expAlertMessage);
		String actAlertMEssage = DownloaderViewPage.getAlertBoxMessageAndValidate();
		System.out.println("Actual Alert Message :"+actAlertMEssage);
		LOGGER.info("Actual Alert Message :"+actAlertMEssage);
		Assert.assertTrue(expAlertMessage.equalsIgnoreCase(actAlertMEssage));    
	}
	
	@Then("click on Ticket ID column to sort decending order")
	public void click_on_Ticket_ID_column_to_sort_decending_order() {
		
		LOGGER.info("CLICKING TICKETS ID for Sorting");
		DownloaderViewPage.clickOnTicketIDDecending();
	}
	
	@Then("expand the ticket to check and download the product")
	public void expand_the_ticket_to_check_and_download_the_product() throws InterruptedException {		
		LOGGER.info("Expand the ticket to check and download the product");
		DownloaderViewPage.expandTicketDownloadProduct();		
		Thread.sleep(2000);
	}
	
	@Then("Expand the node inside the node")
	public void Expand_the_node_inside_the_node() throws InterruptedException {
		LOGGER.info("Expand the Node Inside the node");
		DownloaderViewPage.expandInsideNode();		
		Thread.sleep(2000);
	}
	
	@Then("check the productname with version and download file names")
	public void check_the_productname_with_version_and_download_file_names() throws InterruptedException {
		
		LOGGER.info("check the productname with version and download file names");
		DownloaderViewPage.checkProductNameAndVersionAndDownloadFilename();		
		Thread.sleep(2000);
		
		
	}
	
	@Then("check the downloaded zip file is available under proper folder and unzip that file")
	public void check_the_downloaded_zip_file_is_available_under_proper_folder_and_unzip_that_file() throws InterruptedException {
		
		LOGGER.info("check the downloaded zip file is available under proper folder");
//		String Downloaded_FileLocation = prop.getProperty("Download_location");
//		boolean file_exist = Util.checkIfFileExist(Downloaded_FileLocation, );	
		Thread.sleep(1000);
		DownloaderViewPage.checkDownloadedFileExist();
		Thread.sleep(5000);
		DownloaderViewPage.unzipDownloadedFile();
		Thread.sleep(10000);
		
	}
	

	@When("user click on ProductAdminView icon")
	public void user_click_on_ProductAdminView_icon() {
		
		LOGGER.info("Clicking ProductAdminView");
		DownloaderViewPage.clickProductAdminViewicon();
		LOGGER.info("Sucessfully Clicked ProductAdminView");
	    
	}
	
	@When("click on June2021 release")
	public void click_on_June2021_release() throws InterruptedException {
		
		LOGGER.info("Clicking on June2021 release");
		Thread.sleep(3000);
		DownloaderViewPage.clickJune2021Icon();
		LOGGER.info("Sucessfully Clicked on June2021 release");
	    
	}
	
	@Then("click on finder icon")
	public void click_on_finder_icon() {
		
		LOGGER.info("click on finder icon");
		DownloaderViewPage.clickFindericon();
		LOGGER.info("Sucessfully Clicked on finder icon");
	    
	}
	
	@When("user enter product name in the search box and click on search button")
	public void user_enter_product_name_in_the_search_box_and_click_on_search_button() {
		
		LOGGER.info("user enter product name in the search box and click on search button");
		DownloaderViewPage.clickSearchBox();
		LOGGER.info("Sucessfully enter user enter product name in the search box and clicked on search button");
	    
	}
	
	@Then("click on product version")
	public void click_on_product_version() {
		
		LOGGER.info("click on product version");
		DownloaderViewPage.clickProductVersion();
		LOGGER.info("Sucessfully clicked on product version");
	    
	}
	
	@Then("get all the file names and validate with downloaded files")
	public void get_all_the_file_names_and_validate_with_downloaded_files() {
		
		LOGGER.info("get all the file names and validate with downloaded files");
		DownloaderViewPage.getFileNamesAndValidate();
		LOGGER.info("Sucessfully get all the file names and validate with downloaded files");
	    
	}
	
	
	
	
	
}
