package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.ConfigReader;
import com.qa.util.Constants;
import com.qa.util.ElementUtil;

public class DownloaderViewPage {

	private WebDriver driver;
	
	private static final Logger LOGGER = LogManager.getLogger(DownloaderViewPage.class);
	private ElementUtil Util = new ElementUtil();
	private Constants myConst = new Constants();
	
	private ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();
	
	private long timerInSeconds = 2400;
	
	String downloadedfilename="";
	String Productname="";
	String version="";
	String NMSMetaInfoFile="";
	String SWGSignFile="";
	String SWGManiFile="";
	String SystemProductName="";
	String NMSFileName="";
	String TextDocumentFileName="";
	String ALACTextDocumentName="";

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
	
	private By EUFTTargetGroup_active = By.xpath("//*[@id='tbrc'] //a[contains(text(),'TELEINFORMATICA Y COMUNICACIONES, S')]");
	private By TicketID_Decending = By.xpath("//*[@id='thrc'] //a[contains(text(),'Ticket ID')]");	
	
	private By TicketIDExpand = By.xpath("//*[@id='tbl']/tbody/tr[1]/td/table/tbody/tr[2]/td");
	//private By TicketIDExpand = By.xpath("//td[contains(text(),'T-103314')]");
	private By ExpandInsideNode = By.xpath("//*[@id='tbl']/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[3]");
	private By ProductName = By.xpath("//*[@id='tbr']/tbody/tr[2]/td[3]");
	private By ProductVersion = By.xpath("//*[@id='tbr']/tbody/tr[2]/td[4]");
	
	private By NMSMetaInformationFile = By.xpath("//*[@id='tbr']/tbody/tr[3]/td/a");
	private By SWGSignatureFile = By.xpath("//*[@id='tbr']/tbody/tr[5]/td/a");
	private By SWGManifestFile = By.xpath("//*[@id='tbr']/tbody/tr[4]/td/a");
	
	private By ProductAdminIcon = By.xpath("//*[@id='divToolbar']/div[1]/ul/li[3]/img");												
	private By June2021Release = By.xpath("//*[@id='tbrc']/table/tbody/tr/td/a");
	private By finderIcon = By.xpath("//*[@id=\"toolbar-container\"]/div/div/div[3]/div/i");
	private By searchBox = By.xpath("//*[@class='expressions']/div[2]/div/table/tbody/tr[3]/td/input");
	private By searchBoxButton = By.xpath("//a[contains(text(),'Search')]");
	
	private By NMSXMLName = By.xpath("//*[@id=\"tbr\"]/tbody/tr[2]/td[3]");
	private By TextDocumentName = By.xpath("//*[@id=\"tbr\"]/tbody/tr[3]/td[3]");
	private By TestPDFDoc = By.xpath("//*[@id=\"tbr\"]/tbody/tr[4]/td[3]");
	
	private By DownloaderFinderIcon = By.xpath("//*[@id=\"toolbar-container\"]/div/div/div[3]/div/i");
	//private By DownloaderSearchBox = By.xpath("//*[@class='expressions']/div[2]/div/table/tbody/tr[3]/td/input");
	private By DownloaderSearchBox = By.cssSelector("body > div.expressions > div.expression > div > table > tbody > tr:nth-child(3) > td > input");
	private By DownloaderSearchBoxButton = By.xpath("//*[@class='actions']/table/tbody/tr/td[2]/a");
	
	
	List<String> tableName;
	
	List<String> expectedName;
	
	// DownloadViewPage - Constructor
	public DownloaderViewPage(WebDriver driver) {
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
			driver.switchTo().defaultContent();
			Thread.sleep(12000);
		    driver.switchTo().frame("content").switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame").switchTo().frame("tableBodyRight");
		    ElementUtil.highlightElement(driver.findElement(EUFTTargetGroup_active));
			LOGGER.info("CLICK ON EUFT Active target Groups");
		    driver.findElement(EUFTTargetGroup_active).click();
		    Thread.sleep(1000);	
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
					Thread.sleep(2000);
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
					Thread.sleep(8000);
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
				
				
// Click on Ticket ID Decending Order
				
				// Click Tickets Tab
				
				public void clickOnTicketIDDecending() {
					try {
					
//					driver.findElement(Tickets).click();
						
// ********************************* click Ticket ID column for ascending  ********************************************
//						driver.switchTo().defaultContent();  
//						Thread.sleep(2000);
//					    driver.switchTo().frame("content");
//					    driver.switchTo().frame("detailsDisplay");
//					    driver.switchTo().frame("tvcTabs0contentFrame");
//					    driver.switchTo().frame("tableContentFrame");
//					    driver.switchTo().frame("tableBodyRight");
//					    ElementUtil.highlightElement(driver.findElement(TicketID_Decending));
//						LOGGER.info("CLICKING ON TICKET ID SORTING");
//					    Thread.sleep(3000);
//					    //driver.findElement(By.cssSelector("a.sortlink")).click();
//					    driver.findElement(TicketID_Decending).click();	
					    
//**********************************************************************************************************************
						
						
						
						
						// Via finder icon
						driver.switchTo().defaultContent();  
						Thread.sleep(2000);
					    driver.switchTo().frame("content");
					    driver.switchTo().frame("detailsDisplay");
					    driver.switchTo().frame("tvcTabs0contentFrame");
					    driver.switchTo().frame("tableContentFrame");
					    ElementUtil.highlightElement(driver.findElement(DownloaderFinderIcon));
						LOGGER.info("CLICKING ON DownloaderFinderIcon");
					    Thread.sleep(2000);
					    //driver.findElement(By.cssSelector("a.sortlink")).click();
					    driver.findElement(DownloaderFinderIcon).click();	
					    Thread.sleep(3000);
					    
					    driver.switchTo().defaultContent();
					    Thread.sleep(2000);
				        driver.switchTo().frame("content").switchTo().frame("detailsDisplay");
				        driver.switchTo().frame("tvcTabs0contentFrame");
				        driver.switchTo().frame("tvcInlineFrame_0");
				        Thread.sleep(2000);
					    
					    driver.findElement(DownloaderSearchBox).sendKeys(prop.getProperty("TicketID"));
					    Thread.sleep(2000);
					    
					    driver.findElement(DownloaderSearchBoxButton).click();
					    
					    Thread.sleep(2000);
						
						// ****************************
					    
					    
						
					}catch (Exception e) {
						System.out.println("DownloaderSearchBoxButton tab not found... Trying to find it one more time using explicit wait");
						LOGGER.info("DownloaderSearchBoxButton tab not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(DownloaderSearchBoxButton));
						}catch(Exception e2) {
							System.out.println("DownloaderSearchBoxButton tab not found... Please check the Locator used..");
							LOGGER.info("DownloaderSearchBoxButton tab not found... Please check the Locator used..");
						}
						}
					
				}
				
				
// Check and Download Expand Button
				
				public void expandTicketDownloadProduct() {
					try {					
						driver.switchTo().defaultContent();
					    Thread.sleep(4000);
					    driver.switchTo().frame("content").switchTo().frame("detailsDisplay").switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame").switchTo().frame("tableBodyRight");
					    Thread.sleep(4000);
					    ElementUtil.highlightElement(driver.findElement(TicketIDExpand));
					    LOGGER.info("CLICKING ON TICKET ID EXPAND");
					    
					    //And expand the tickets from which box need to be displayed// next step
					    driver.findElement(TicketIDExpand).click();				
						
					}catch (Exception e) {
						System.out.println("My Target Groups Ticket tab not found... Trying to find it one more time using explicit wait");
						LOGGER.info("My Target Groups Ticket tab not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(TicketIDExpand));
						}catch(Exception e2) {
							System.out.println("My Target Groups Ticket tab not found... Please check the Locator used..");
							LOGGER.info("My Target Groups Ticket tab not found... Please check the Locator used..");
						}
						}
					
				}
				
				
// Expand Inside Node
				
				public void expandInsideNode() {
					try {					
						driver.switchTo().defaultContent();
					    driver.switchTo().frame("content").switchTo().frame("detailsDisplay").switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame").switchTo().frame("tableBodyRight");
					    Thread.sleep(1000);
					    ElementUtil.highlightElement(driver.findElement(ExpandInsideNode));
					    LOGGER.info("Expand the Node Inside the Node");
					    //Expand nodeinside the node
					    driver.findElement(ExpandInsideNode).click();					    
					    Thread.sleep(1000);		
						
					}catch (Exception e) {
						System.out.println("Expand the Node Inside the Node... Trying to find it one more time using explicit wait");
						LOGGER.info("Expand the Node Inside the Node... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(ExpandInsideNode));
						}catch(Exception e2) {
							System.out.println("My Target Groups Ticket tab not found... Please check the Locator used..");
							LOGGER.info("My Target Groups Ticket tab not found... Please check the Locator used..");
						}
						}
					
				}
							
				
	//checkProductNameAndVersionAndDownloadFilename	
				
				
				public void checkProductNameAndVersionAndDownloadFilename() {
					try {					
						driver.switchTo().defaultContent();
					    driver.switchTo().frame("content").switchTo().frame("detailsDisplay").switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame").switchTo().frame("tableBodyRight");
					    Thread.sleep(2000);
					   //getting the product name
					    ElementUtil.highlightElement(driver.findElement(ProductName));					    
					    LOGGER.info("Get the Product Name");
					    SystemProductName=driver.findElement(ProductName).getText();
					    Productname=driver.findElement(ProductName).getText();
					    Thread.sleep(1000);
					    System.out.println("Original Productname is " +Productname);
					    LOGGER.info("Original Productname is " +Productname);
					    Productname=Productname.replaceAll("\\s","");
					    System.out.println("Productname is " +Productname);
					    LOGGER.info("Productname is " +Productname);
					    
					    ElementUtil.highlightElement(driver.findElement(ProductVersion));
					    version=driver.findElement(ProductVersion).getText();
					    System.out.println("Version is " +version);   //CXP 902 0822/1R1A
					    LOGGER.info("Version is..." +version);
					    
					    downloadedfilename =Productname+"-"+version;
					    System.out.println("downloadedfilename is " +downloadedfilename);
					    LOGGER.info("downloadedfilename is......" +downloadedfilename);
					    Thread.sleep(1000);	
					    
					    
// ********************************************* Main working program Start *********************************************************************
					    
//					    
//					    ElementUtil.highlightElement(driver.findElement(NMSMetaInformationFile));
////					    JavascriptExecutor executor = (JavascriptExecutor) driver;
////						executor.executeScript("arguments[0].scrollIntoView(true);", NMSMetaInformationFile);
////						Thread.sleep(2000);
//					    NMSMetaInfoFile=driver.findElement(NMSMetaInformationFile).getText();
//					    System.out.println("NMSMetaInfoFile------>"+NMSMetaInfoFile);
//					    LOGGER.info("NMSMetaInfoFile-------->"+NMSMetaInfoFile);
//					    
//					    ElementUtil.highlightElement(driver.findElement(SWGSignatureFile));
//					    SWGSignFile=driver.findElement(SWGSignatureFile).getText();
//					    System.out.println("SWGSignFile------->"+SWGSignFile);
//					    LOGGER.info("SWGSignFile-------->"+SWGSignFile);
//					    
//					    ElementUtil.highlightElement(driver.findElement(SWGManifestFile));
//					    SWGManiFile = driver.findElement(SWGManifestFile).getText();
//					    System.out.println("SWGManiFile----->"+SWGManiFile);
//					    LOGGER.info("SWGManiFile------>"+SWGManiFile);		    
					    
// ********************************************* Main working program End *********************************************************************
	
					    
					    // Tested Code ------ Can Delete
					    
					    
					    List<WebElement> myTagsWithId = driver.findElements(By.xpath("//*[@id='tbrc']/table/tbody/tr"));
					    
					    System.out.println("total size------->"+myTagsWithId.size());
					    LOGGER.info("total size.....>" +myTagsWithId.size());
					    
					    tableName = new ArrayList<String>();
					    
					 // now printing all id values one by one
					    for(int i=3;i<=myTagsWithId.size();i++){
					    	ElementUtil.highlightElement(driver.findElement(By.xpath("//*[@id='tbrc']/table/tbody/tr["+i+"]/td[8]")));
					    	String name = driver.findElement(By.xpath("//*[@id='tbrc']/table/tbody/tr["+i+"]/td[8]")).getText();
					    	System.out.println("Ticket Reference name"+name);
					    	tableName.add(name);
					    
					     }
					    
					    
					    // Tested Code End - Can Delete
					    
					    
					    
					    
					    
					    
					    
					    
					}catch (Exception e) {
						System.out.println("checkProductNameAndVersionAndDownloadFilename... Trying to find it one more time using explicit wait");
						LOGGER.info("checkProductNameAndVersionAndDownloadFilename... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(ProductName));
						}catch(Exception e2) {
							System.out.println("checkProductNameAndVersionAndDownloadFilename not found... Please check the Locator used..");
							LOGGER.info("checkProductNameAndVersionAndDownloadFilename not found... Please check the Locator used..");
						}
						}
					
				}
				
			
				
				public void checkDownloadedFileExist() throws InterruptedException {
					Thread.sleep(2000);
					String Downloaded_FileLocation = prop.getProperty("Download_location");
					System.out.println("DOWNLOAD LOCATION--->"+Downloaded_FileLocation);
					LOGGER.info("DOWNLOAD LOCATION--->"+Downloaded_FileLocation);
					
					System.out.println("DOWNLOAD FILE NAME--->"+downloadedfilename);
					LOGGER.info("DOWNLOAD FILE NAME--->"+downloadedfilename);
					
					
					Util.listenAFolder(Downloaded_FileLocation, downloadedfilename, myConst.timerInSeconds);
					
					//boolean file_exist = Util.checkIfFileExist(Downloaded_FileLocation, downloadedfilename);
					
//					System.out.println("file_exist--->"+file_exist);
//					LOGGER.info("file_exist--->"+file_exist);
//					
//					if(file_exist)
//					{
//						System.out.println("ZIP File is available");
//						LOGGER.info("ZIP FILE IS AVAILABLE");
//					}
//					else
//					{
//						System.out.println("ZIP File is not available");
//						LOGGER.info("ZIP FILE IS NOT AVAILABLE");
//					}
				}
				
				
				
				public void unzipDownloadedFile() throws InterruptedException {
					Thread.sleep(10000);
					System.out.println("UNZIP FILE DOWNLOADED FILE");
					LOGGER.info("UNZIP THE DOWNLOADED FILE");
					
					String Downloaded_FileLocation = prop.getProperty("Download_location");
					
					String filePath = Downloaded_FileLocation+downloadedfilename+".zip";
					String destDir = Downloaded_FileLocation;
					
					Util.UNZIP_FILE(filePath, destDir);
					Thread.sleep(5000);
					
				}
				
				
				
		// ProductAdminIcon		
				
				
				// click on ProductAdminIcon	
				public void clickProductAdminViewicon() {
					try {
					driver.navigate().refresh();
					Thread.sleep(2000);
					ElementUtil.highlightElement(driver.findElement(ProductAdminIcon));
					LOGGER.info("CLICK ON ProductAdminIcon");
					Thread.sleep(5000);
				    driver.findElement(ProductAdminIcon).click();
				    Thread.sleep(2000);	
					}catch (Exception e) {
						System.out.println("ProductAdminIcon not found... Trying to find it one more time using explicit wait");
						LOGGER.info("ProductAdminIcon Element not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(ProductAdminIcon));
						}catch(Exception e2) {
							System.out.println("ProductAdminIcon Element not found... Please check the Locator used..");
							LOGGER.info("ProductAdminIcon Element not found... Please check the Locator used..");
						}
						}
				}
				
				
				
				
				// click on clickJune2021Icon	
				public void clickJune2021Icon() {
					try {
					driver.switchTo().defaultContent();
				    Thread.sleep(2000);
				    driver.switchTo().frame("content").switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tableContentFrame").switchTo().frame("tableBodyRight");
					ElementUtil.highlightElement(driver.findElement(June2021Release));
					LOGGER.info("CLICK ON June2021Release");
				    driver.findElement(June2021Release).click();
				    Thread.sleep(2000);	
					}catch (Exception e) {
						System.out.println("June2021Release not found... Trying to find it one more time using explicit wait");
						LOGGER.info("June2021Release Element not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(June2021Release));
						}catch(Exception e2) {
							System.out.println("June2021Release Element not found... Please check the Locator used..");
							LOGGER.info("June2021Release Element not found... Please check the Locator used..");
						}
						}
				}				
				
				
				// click on clickFindericon	
				public void clickFindericon() {
					try {
						Thread.sleep(1000);
				        driver.switchTo().defaultContent();
				        driver.switchTo().frame("content").switchTo().frame("detailsDisplay");
				        driver.switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tvcTabs0contentFrame");
				        driver.switchTo().frame("tableContentFrame");
				        Thread.sleep(1000);
					ElementUtil.highlightElement(driver.findElement(finderIcon));
					LOGGER.info("CLICK ON finderIcon");
				    driver.findElement(finderIcon).click();
				    Thread.sleep(2000);	
					}catch (Exception e) {
						System.out.println("June2021Release not found... Trying to find it one more time using explicit wait");
						LOGGER.info("June2021Release Element not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(finderIcon));
						}catch(Exception e2) {
							System.out.println("June2021Release Element not found... Please check the Locator used..");
							LOGGER.info("June2021Release Element not found... Please check the Locator used..");
						}
						}
				}
			
		//searchBox
				
				// click on clickFindericon	
				public void clickSearchBox() {
					try {
						
						driver.switchTo().defaultContent();
				        driver.switchTo().frame("content").switchTo().frame("detailsDisplay");
				        driver.switchTo().frame("tvcTabs0contentFrame").switchTo().frame("tvcTabs0contentFrame");
				        driver.switchTo().frame("tvcInlineFrame_0");
				        Thread.sleep(2000);
						
					ElementUtil.highlightElement(driver.findElement(searchBox));
					LOGGER.info("CLICK ON searchBox");
					
					System.out.println("SystemProductName---->"+SystemProductName);
					LOGGER.info("SystemProductName---->"+SystemProductName);
					
				    driver.findElement(searchBox).sendKeys(SystemProductName);
				    Thread.sleep(2000);
				    driver.findElement(searchBoxButton).click();
				    Thread.sleep(2000);
					}catch (Exception e) {
						System.out.println("searchBox not found... Trying to find it one more time using explicit wait");
						LOGGER.info("searchBox Element not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
						}catch(Exception e2) {
							System.out.println("searchBox Element not found... Please check the Locator used..");
							LOGGER.info("searchBox Element not found... Please check the Locator used..");
						}
						}
				}		
				
				
				
				// click on clickProductVersion	
				public void clickProductVersion() {
					try {	
						System.out.println("Product Version---->"+version);
						LOGGER.info("Product Version---->"+version);
						
						//System.out.println("XPATH-----1>"+"//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\"%s\")]\" %"+version+"))]");
						//System.out.println("XPATH-----2>"+"//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\"'\")]\""+version+" \"'\")]\"))]");
						//System.out.println("XPATH-----3>"+"//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+" \")]\"))]");
						
						//System.out.println("XPATH-----4>"+"//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]\"))");
						
						//System.out.println("XPATH-----5>"+"//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]");
						
						
						//System.out.println("XPATH----6"+"//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\"\"+version+\"\")]\"");
															
						//LOGGER.info("XPATH---->"+"//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),"+version+")]");
						
						
						System.out.println("XPATH----->"+"//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]");
						//  driver.findElement(By.xpath("//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]"));
						
						
						Thread.sleep(9000);
				        driver.switchTo().defaultContent();
				        Thread.sleep(9000);
				        driver.switchTo().frame("content");
				        driver.switchTo().frame("detailsDisplay");
				        driver.switchTo().frame("tvcTabs0contentFrame");
				        driver.switchTo().frame("tvcTabs0contentFrame");
				        //driver.switchTo().frame("tableTopFrame");
				        driver.switchTo().frame("tableContentFrame");
				        driver.switchTo().frame("tableBodyRight");
				        
				        WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]")));
					
				        
				        WebElement ProductVer = driver.findElement(By.xpath("//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]"));
				        
				        //WebElement ProductVer = driver.findElement(By.xpath("//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]"));
				        
					       
				        Thread.sleep(2000);
				        ElementUtil.highlightElement(ProductVer);
				        
				        WebDriverWait wait1 = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
						wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]"))).click();
						
				       // Thread.sleep(2000);
				       // WebElement W3= driver.findElement(By.xpath("//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]")); 
				      										
//				        //scroll to product version
//				        JavascriptExecutor exec = (JavascriptExecutor) driver;
//				        exec.executeScript("arguments[0].scrollIntoView(true);", W3);
//				        
//				        //sample
				        
				        		        
				       // driver.findElement(By.xpath("//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]")).click();
				        Thread.sleep(4000);
					LOGGER.info("CLICK ON ProductVersion");
					
					System.out.println("Product Version---->"+version);
					LOGGER.info("Product Version---->"+version);
					
				    
				    Thread.sleep(2000);
					}catch (Exception e) {
						System.out.println("ProductVersion not found... Trying to find it one more time using explicit wait");
						LOGGER.info("ProductVersion Element not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tb']/div[2]/table/tbody/tr[1]/td/a[starts-with(text(),\""+version+"\")]")));
						}catch(Exception e2) {
							System.out.println("ProductVersion Element not found... Please check the Locator used..");
							LOGGER.info("ProductVersion Element not found... Please check the Locator used..");
						}
						}
				}	
				
				public void getFileNamesAndValidate() {
					try {	
						Thread.sleep(3000);
				        driver.switchTo().defaultContent();
				        driver.switchTo().frame("content");
				        driver.switchTo().frame("detailsDisplay");
				        driver.switchTo().frame("tvcTabs0contentFrame");
				        
				        
				        
				        // ***************************************************** Proper Working Code START ***********************************
				        
//				        String NMSFileName= driver.findElement(NMSXMLName).getText();
//				        //NMSFileName = NMSFileName+".xml";
//				        System.out.println("NMSFileName"+NMSFileName);
//				        LOGGER.info("NMSFileName"+NMSFileName);	
//				        Thread.sleep(2000);
//				        
//				        // Compare same file name is exist or not
//				        // **********************************************
//				        
//				        String Downloaded_FileLocation = prop.getProperty("Download_location");
//						System.out.println("DOWNLOAD LOCATION--->"+Downloaded_FileLocation);
//						LOGGER.info("DOWNLOAD LOCATION--->"+Downloaded_FileLocation);
//				        
//				        boolean file_exist = Util.checkFileExist(Downloaded_FileLocation, NMSFileName);
//						
//						System.out.println("file_exist--->"+file_exist);
//						LOGGER.info("file_exist--->"+file_exist);
//						
//						if(file_exist)
//						{
//							System.out.println("NMS XML File is available");
//							LOGGER.info("NMS XML IS AVAILABLE");
//						}
//						else
//						{
//							System.out.println("NMS XML is not available");
//							LOGGER.info("NMS XML IS NOT AVAILABLE");
//						}
//				        Thread.sleep(2000);
//				        //***********************************************************
//				        //getting the text of doc name : Test_startTesting.doc
//				        String TextDocumentFileName= driver.findElement(TextDocumentName).getText();//Test_startTesting.doc
//				        //TextDocumentFileName=TextDocumentFileName+".txt";
//				        System.out.println("TextDocumentFileName"+TextDocumentFileName);
//				        LOGGER.info("TextDocumentFileName"+TextDocumentFileName);
//				        Thread.sleep(2000);
//				        
//				        
//				        boolean TXTFile_Exist = Util.checkFileExist(Downloaded_FileLocation, TextDocumentFileName);
//						
//						System.out.println("DOCFILE_Exist--->"+TXTFile_Exist);
//						LOGGER.info("DOCFile_Exist--->"+TXTFile_Exist);
//						
//						if(TXTFile_Exist)
//						{
//							System.out.println("DOC File is available");
//							LOGGER.info("DOC File IS AVAILABLE");
//						}
//						else
//						{
//							System.out.println("DOC File is not available");
//							LOGGER.info("DOC File IS NOT AVAILABLE");
//						}
//				        //getting the text of doc name  : Test_startTesting.pdf
//				        String ALACTextDocumentName= driver.findElement(TestPDFDoc).getText();
//				       // ALACTextDocumentName = ALACTextDocumentName+"docx";
//				        System.out.println("ALACTextDocumentName"+ALACTextDocumentName);
//				        LOGGER.info("ALACTextDocumentName"+ALACTextDocumentName);
//				        
//				        boolean TestPDFDoc_Exit = Util.checkFileExist(Downloaded_FileLocation, ALACTextDocumentName);
//						
//						System.out.println("PDFFile_Exist--->"+TestPDFDoc_Exit);
//						LOGGER.info("PDFFile_Exist--->"+TestPDFDoc_Exit);
//						
//						if(TestPDFDoc_Exit)
//						{
//							System.out.println("PDF File is available");
//							LOGGER.info("PDF File is available");
//						}
//						else
//						{
//							System.out.println("PDF File is not available");
//							LOGGER.info("PDF File IS NOT AVAILABLE");
//						}
//						
						
// Proper Working Code Finished ***************************************************************************************************888
						
						 List<WebElement> myTagsWithName = driver.findElements(By.xpath("//*[@id='tbr']/tbody/tr"));
						    
						    System.out.println("total size------->"+myTagsWithName.size());
						    LOGGER.info("total size.....>" +myTagsWithName.size());
						    
						    
						expectedName = new ArrayList<String>();
						
						//*[@id="tbr"]/tbody/tr[2]/td[3]
						
						for(int i=2;i<=myTagsWithName.size();i++){
					    	ElementUtil.highlightElement(driver.findElement(By.xpath("//*[@id='tbr']/tbody/tr["+i+"]/td[3]")));
					    	String name = driver.findElement(By.xpath("//*[@id='tbr']/tbody/tr["+i+"]/td[3]")).getText();
					    	System.out.println("Expected Reference name"+name);
					    	expectedName.add(name);
					    	System.out.println("Reference Document:"+expectedName);
					    	LOGGER.info("Reference Document:"+expectedName);
					    
					     }
						
						// Comparison of download files
						
						   String Downloaded_FileLocation = prop.getProperty("Download_location");
							System.out.println("DOWNLOAD LOCATION--->"+Downloaded_FileLocation);
							LOGGER.info("DOWNLOAD LOCATION--->"+Downloaded_FileLocation);
						
						for(String compareResult:expectedName)
						{
							boolean file_exit = Util.checkFileExist(Downloaded_FileLocation, compareResult);
							
							if(file_exit)
								{
									System.out.println(compareResult+"----> File is available");
									LOGGER.info(compareResult+"----> File is available");
								}
								else
								{
									System.out.println(compareResult+"----> File is not available");
									LOGGER.info(compareResult+"----> File is not available");
								}
							
						}
						
						Thread.sleep(3000);
						
//					// Comparison of Download Signature Files
//						
//						// Download_SignatureFile_Location
//						
//						String Downloaded_Signature_FileLocation = prop.getProperty("Download_SignatureFile_Location");
//						System.out.println("DOWNLOAD SIGNATURE FILE LOCATION--->"+Downloaded_Signature_FileLocation);
//						LOGGER.info("DOWNLOAD SIGNATURE FILE LOCATION--->"+Downloaded_Signature_FileLocation);
//					
//					for(String compareSignatureResult:tableName)
//					{
//						boolean file_exit = Util.checkFileExist(Downloaded_Signature_FileLocation, compareSignatureResult);
//						
//						if(file_exit)
//							{
//								System.out.println(compareSignatureResult+"----> File is available");
//								LOGGER.info(compareSignatureResult+"----> File is available");
//							}
//							else
//							{
//								System.out.println(compareSignatureResult+"----> File is not available");
//								LOGGER.info(compareSignatureResult+"----> File is not available");
//							}
//						
//					}
//						
						
						
						
						
						
				    Thread.sleep(2000);
					}catch (Exception e) {
						System.out.println("NMSXMLName not found... Trying to find it one more time using explicit wait");
						LOGGER.info("NMSXMLName Element not found... Trying to find it one more time using explicit wait");
						try {
							WebDriverWait wait = new WebDriverWait(driver,Constants.IMPLICIT_WAIT);
							wait.until(ExpectedConditions.visibilityOfElementLocated(NMSXMLName));
						}catch(Exception e2) {
							System.out.println("NMSXMLName Element not found... Please check the Locator used..");
							LOGGER.info("NMSXMLName Element not found... Please check the Locator used..");
						}
						}
				}		
						
				
				
}
