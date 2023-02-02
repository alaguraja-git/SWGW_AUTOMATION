package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.Constants;
import com.qa.util.ElementUtil;

public class SucessfullDownloaderPage {

private WebDriver driver;
	
	private static final Logger LOGGER = LogManager.getLogger(SucessfullDownloaderPage.class);

	// By Locators downloader view scenario
	private By DownloaderIcon = By.xpath("//*[@id=\"divToolbar\"]/div[1]/ul/li[2]/img");
	private By DownloadViewTabs = By.cssSelector("div#tvcTabs0 li a");
	private By MyTargetGroups = By.xpath("//*[@id=\"tvcTabs0\"]/div[1]/ul/li[1]/div/a");
	private By RequestAccess = By.xpath("//*[@id=\"toolbar-container\"]/div/div/div[1]/div[1]/span");
	private By RemoveAccess = By.xpath("//*[@id=\"toolbar-container\"]/div/div/div[2]/span");
	private By FinderIcon = By.xpath("//*[@id=\"toolbar-container\"]/div/div/div[4]/div/i");
	private By TableIcon = By.xpath("//*[@id=\"toolbar-container\"]/div/div/div[5]/div/i[1]");
	private By EUFTTargetGroup = By.cssSelector("div#tvcTabs0 li a");
	private By EUFTTargetGroupRecord = By.xpath("//a[contains(text(),'EMPRESA DE TELECOMUNICACIONES DE CU')]");
	private By Tickets = By.xpath("//a[@title='Ticket[s] for selected Target Group']");
	private By TicketExpand = By.xpath("//form[@name='tvcTableForm']/div/div/table/tbody/tr[1]/td/table/tbody/tr[2]/td[1]");
	private By TicketExpandCheckBox = By.xpath("//input[@name='emxTableRowId']");
	private By DownloadButton = By.xpath("//div[@id='toolbar-container']/div/div/div");
	
	private By EUFTTargetGroup_active = By.xpath("//a[contains(text(),'TELEINFORMATICA Y COMUNICACIONES, S')]");
	
	
	// DownloadViewPage - Constructor
	public SucessfullDownloaderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Click Download View Icon
	public void clickDownloadViewIcon() {
		try {
		ElementUtil.highlightElement(driver.findElement(DownloaderIcon));
		LOGGER.info("CLICK ON DOWNLOADER ICON");
		driver.findElement(DownloaderIcon).click();
		}catch (Exception e) {
			System.out.println("Downloader Icon Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("Downloader Icon Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(DownloaderIcon));
			}catch(Exception e2) {
				System.out.println("Downloader Icon Element not found... Please check the Locator used..");
				LOGGER.info("Downloader Icon Element not found... Please check the Locator used..");
			}
			}
	}
	
	// click on My Target Gropus	
	public void clickMyTargetGroups() {
		try {
		ElementUtil.highlightElement(driver.findElement(MyTargetGroups));
		LOGGER.info("CLICK ON MY TARGET GROUPS");
		driver.findElement(MyTargetGroups).click();
		}catch (Exception e) {
			System.out.println("My Target Groups Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("My Target Groups Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(DownloaderIcon));
			}catch(Exception e2) {
				System.out.println("My Target Groups Element not found... Please check the Locator used..");
				LOGGER.info("My Target Groups Element not found... Please check the Locator used..");
			}
			}
	}
	
	
	// click on My Target Gropus	
		public void clickEUFTActiveTargetGroups() {
			try {
			ElementUtil.highlightElement(driver.findElement(EUFTTargetGroup_active));
			LOGGER.info("CLICK ON EUFT Active target Groups");
			driver.switchTo().defaultContent();
		    Thread.sleep(10000);
		    driver.switchTo().frame("content").switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame").switchTo().frame("tableBodyRight");
			driver.findElement(EUFTTargetGroup_active).click();
			}catch (Exception e) {
				System.out.println("My Target Groups Element not found... Trying to find it one more time using explicit wait");
				LOGGER.info("My Target Groups Element not found... Trying to find it one more time using explicit wait");
				try {
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(DownloaderIcon));
				}catch(Exception e2) {
					System.out.println("My Target Groups Element not found... Please check the Locator used..");
					LOGGER.info("My Target Groups Element not found... Please check the Locator used..");
				}
				}
		}
	
	
	
	
	
	// DownloadViewPage - Action Page
	public int getDownloadViewCount() {
		
		int total=0;
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	LOGGER.info("SWITCHING TO CONTENT FRAME");
		driver.switchTo().frame("content");
		
		try {
			
		total = driver.findElements(DownloadViewTabs).size();
		}catch (Exception e) {
			System.out.println("DownloadViewTabs Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("DownloadViewTabs Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(DownloaderIcon));
			}catch(Exception e2) {
				System.out.println("DownloadViewTabs Element not found... Please check the Locator used..");
				LOGGER.info("DownloadViewTabs Element not found... Please check the Locator used..");
			}
			}
		
		return total;
	}
	
	// Get DownloaderViewList
	public List<String> getDownloadViewList() {
		List<String> downloadList = new ArrayList<>();
		List<WebElement> DownloaderViewList = null;
		try {
			LOGGER.info("FINDING THE DOWNLOAD VIEW TABS");
			DownloaderViewList = driver.findElements(DownloadViewTabs);
		}catch (Exception e) {
			System.out.println("Downloader View List Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("Downloader View List Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(DownloadViewTabs));
			}catch(Exception e2) {
				System.out.println("Downloader View List Element not found... Please check the Locator used..");
				LOGGER.info("Downloader View List Element not found... Please check the Locator used..");
			}
		}		
		
		for(WebElement e : DownloaderViewList) {
			String text = e.getText();
			System.out.println("Downloader View Header List"+text);
			LOGGER.info("Downloader View Header List"+text);
			downloadList.add(text);
		}
		return downloadList;
		
	}
	
	
	// Get MyTargetGroups View List
	
	public void getMyTargetGroupList() {
		
		String Request_Access=null;
		String Remove_Access;
		String RequestAccess_Expected = "Request Access";
		String RemoveAccess_Expected = "Remove Access";

		// moving to particular frame
		LOGGER.info("SWITCHING TO TABLE CONTENT FRAME");
		driver.switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame");
		
		// Request Access check
		try {
			Request_Access = driver.findElement(RequestAccess).getText();
			if(Request_Access.contains(RequestAccess_Expected)) {
				System.out.println("Request Access is available");
				LOGGER.info("Request Access is available");				
			}

		} catch (Exception e) {
			System.out.println("RequestAccess Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("RequestAccess Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver, Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(RequestAccess));
			} catch (Exception e2) {
				System.out.println("RequestAccess Element not found... Please check the Locator used..");
				LOGGER.info("RequestAccess Element not found... Please check the Locator used..");
			}
		}
	
		
		// Remove Access check
		
		try {
			Remove_Access = driver.findElement(RemoveAccess).getText();
			if(Remove_Access.contains(RemoveAccess_Expected)) {
				System.out.println("Remove Access is available");
				LOGGER.info("Remove Access is available");				
			}

		} catch (Exception e) {
			System.out.println("Remove Access Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info("Remove Access Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver, Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(RequestAccess));
			} catch (Exception e2) {
				System.out.println("Remove Access Element not found... Please check the Locator used..");
				LOGGER.info("Remove Access Element not found... Please check the Locator used..");
			}
		}
		
		// Finder icon check
		
				try {
					WebElement Finder_Icon = driver.findElement(FinderIcon);
					if(Finder_Icon.isDisplayed()) {
						System.out.println("Finder Icon is available");
						LOGGER.info("Finder Iconis available");				
					}

				} catch (Exception e) {
					System.out.println("Finder Icon Element not found... Trying to find it one more time using explicit wait");
					LOGGER.info("Finder Icon Element not found... Trying to find it one more time using explicit wait");
					try {
						WebDriverWait wait = new WebDriverWait(driver, Constants.IMPLICIT_WAIT);
						wait.until(ExpectedConditions.visibilityOfElementLocated(RequestAccess));
					} catch (Exception e2) {
						System.out.println("Finder Icon Element not found... Please check the Locator used..");
						LOGGER.info("Finder Icon Element not found... Please check the Locator used..");
					}
				}
		
			
			// TableIcon check
				
				try {
					WebElement Table_icon = driver.findElement(TableIcon);
					if(Table_icon.isDisplayed()) {
						System.out.println("Table Icon is available");
						LOGGER.info("Table Icon available");				
					}

				} catch (Exception e) {
					System.out.println("Table Icon Element not found... Trying to find it one more time using explicit wait");
					LOGGER.info("Table Icon Element not found... Trying to find it one more time using explicit wait");
					try {
						WebDriverWait wait = new WebDriverWait(driver, Constants.IMPLICIT_WAIT);
						wait.until(ExpectedConditions.visibilityOfElementLocated(RequestAccess));
					} catch (Exception e2) {
						System.out.println("Table Icon Element not found... Please check the Locator used..");
						LOGGER.info("Table Icon Element not found... Please check the Locator used..");
					}
				}
				
				driver.switchTo().defaultContent();
		
	}
	

// Click on EUPTTargetGroups
	
	public void clickEUPTTargetRecord() {
		
		LOGGER.info("SWITCHING TO TABLE CONTENT AND TABLE BODY RIGHT FRAME");

		driver.switchTo().frame("content").switchTo().frame("tvcTabs0contentFrame").switchTo()
				.frame("tableContentFrame").switchTo().frame("tableBodyRight");

		try {
			ElementUtil.highlightElement(driver.findElement(EUFTTargetGroupRecord));
			LOGGER.info("FINDING THE EUFT TARGET GROUP RECORD");
			driver.findElement(EUFTTargetGroupRecord).click();
		} catch (Exception e) {
			System.out.println(
					"EUFTTargetGroupRecord Element not found... Trying to find it one more time using explicit wait");
			LOGGER.info(
					"EUFTTargetGroupRecord Element not found... Trying to find it one more time using explicit wait");
			try {
				WebDriverWait wait = new WebDriverWait(driver, Constants.IMPLICIT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(DownloaderIcon));
			} catch (Exception e2) {
				System.out.println("EUFTTargetGroupRecord Element not found... Please check the Locator used..");
				LOGGER.info("EUFTTargetGroupRecord Element not found... Please check the Locator used..");
			}
		}
		driver.switchTo().defaultContent();
	}
	
	
// EUFT Target Count - Action Page
		public int getEUFTTargetCount() {
			
			int total=0;

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOGGER.info("SWITCHING TO EUFT DETAILS DISPLAY FRAME");
			driver.switchTo().frame("content").switchTo().frame("detailsDisplay");
			
			try {
				
			total = driver.findElements(EUFTTargetGroup).size();
			}catch (Exception e) {
				System.out.println("EUFT Target Group Element not found... Trying to find it one more time using explicit wait");
				LOGGER.info("EUFT Target Group Element not found... Trying to find it one more time using explicit wait");
				try {
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EUFTTargetGroup));
				}catch(Exception e2) {
					System.out.println("EUFT Target Group Element not found... Please check the Locator used..");
					LOGGER.info("EUFT Target Group Element not found... Please check the Locator used..");
				}
				}
			
			return total;
		}
	
			
		// Get DownloaderViewList
		public List<String> getEUFTTargetViewList() {
			List<String> EUFTTargetList = new ArrayList<>();
			List<WebElement> EUFTTargetViewList = null;
			try {
				LOGGER.info("FINDING EUFT TARGET GROUP");
				EUFTTargetViewList = driver.findElements(EUFTTargetGroup);
			}catch (Exception e) {
				System.out.println("EUFT Target List Element not found... Trying to find it one more time using explicit wait");
				LOGGER.info("EUFT Target List Element not found... Trying to find it one more time using explicit wait");
				try {
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(EUFTTargetGroup));
				}catch(Exception e2) {
					System.out.println("EUFT Target View List Element not found... Please check the Locator used..");
					LOGGER.info("EUFT Target View List Element not found... Please check the Locator used..");
				}
				}
		
			for(WebElement e : EUFTTargetViewList) {
				String text = e.getText();
				System.out.println("EUFT Target View Header List"+text);
				LOGGER.info("EUFT Target View Header List"+text);
				EUFTTargetList.add(text);
			}
			return EUFTTargetList;
			
		}
		
		
// Click Tickets Tab
		
		public void clickTicketsTab() {
			try {
			ElementUtil.highlightElement(driver.findElement(Tickets));
			LOGGER.info("CLICK ON TICKETS TAB");
			driver.findElement(Tickets).click();
			}catch (Exception e) {
				System.out.println("My Target Groups Ticket tab not found... Trying to find it one more time using explicit wait");
				LOGGER.info("My Target Groups Ticket tab not found... Trying to find it one more time using explicit wait");
				try {
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(DownloaderIcon));
				}catch(Exception e2) {
					System.out.println("My Target Groups Ticket tab not found... Please check the Locator used..");
					LOGGER.info("My Target Groups Ticket tab not found... Please check the Locator used..");
				}
				}
			driver.switchTo().defaultContent();
		}

		
		
//TicketExpand
		
		public void clickTicketExpand() {
			driver.switchTo().frame("content").switchTo().frame("detailsDisplay").switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame").switchTo().frame("tableBodyRight");
			try {
			ElementUtil.highlightElement(driver.findElement(TicketExpand));
			driver.findElement(TicketExpand).click();
			}catch (Exception e) {
				System.out.println("My Target Groups TicketExpand not found... Trying to find it one more time using explicit wait");
				LOGGER.info("My Target Groups TicketExpand not found... Trying to find it one more time using explicit wait");
				try {
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.visibilityOfElementLocated(TicketExpand));
				}catch(Exception e2) {
					System.out.println("My Target Groups TicketExpand tab not found... Please check the Locator used..");
					LOGGER.info("My Target Groups TicketExpand tab not found... Please check the Locator used..");
				}
				}
			
		}	
		
		
//TicketExpandCheckbox
		
				public void clickTicketExpandCheckBox() {
					try {
						LOGGER.info("CLICK ON TICKET EXPAND BUTTON");
					ElementUtil.highlightElement(driver.findElement(TicketExpandCheckBox));
					driver.findElement(TicketExpandCheckBox).click();
					}catch (Exception e) {
						System.out.println("My Target Groups TicketExpandCheckBox not found... Trying to find it one more time using explicit wait");
						LOGGER.info("My Target Groups TicketExpandCheckBox not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(TicketExpandCheckBox));
						}catch(Exception e2) {
							System.out.println("My Target Groups TicketExpandCheckBoxd tab not found... Please check the Locator used..");
							LOGGER.info("My Target Groups TicketExpandCheckBox tab not found... Please check the Locator used..");
						}
						}
					driver.switchTo().defaultContent();
				}	
		
		
		
//TicketDownload
				
				public void clickTicketDownloadButton() {
					driver.switchTo().frame("content").switchTo().frame("detailsDisplay").switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame");
					try {
					ElementUtil.highlightElement(driver.findElement(DownloadButton));
					LOGGER.info("CLICK ON DOWNLOAD BUTTON");
					driver.findElement(DownloadButton).click();
					}catch (Exception e) {
						System.out.println("My Target Groups TicketDownloadButton not found... Trying to find it one more time using explicit wait");
						LOGGER.info("My Target Groups TicketExpandDownloadButton not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(DownloadButton));
						}catch(Exception e2) {
							System.out.println("My Target Groups TicketExpandDownloadButton tab not found... Please check the Locator used..");
							LOGGER.info("My Target Groups TicketExpandDownloadButton tab not found... Please check the Locator used..");
						}
						}
					
				}
				
				
// GetAlertBoxMessage and Validate
				
				public String getAlertBoxMessageAndValidate() {
					WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
					wait.until(ExpectedConditions.alertIsPresent());
					LOGGER.info("CHECKING ALERT BOX MESSAGE");
					String actAlertMessage = driver.switchTo().alert().getText();
					System.out.println("Actual Alert Message"+actAlertMessage);
					LOGGER.info("Actual Alert Message"+actAlertMessage);					
					Alert ok = driver.switchTo().alert();
					ok.accept();
					return actAlertMessage;
				}
}

