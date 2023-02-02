package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.pages.DownloaderViewPage;
import com.qa.factory.DriverFactory;

public class ElementUtil {
	
	//long timerInSeconds = 2400;
	
	private static final Logger LOGGER = LogManager.getLogger(ElementUtil.class);
	
	public static void highlightElement(WebElement element) {
		LOGGER.info("INSIDE HIGHLIGHT ELEMENT");
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');",element);
	}
	
	// Decryption technique
		public static String decryptPassword(String encodedString) {
			Decoder decoder = Base64.getDecoder();
			byte[] bytes = decoder.decode(encodedString);
			//System.out.println("decrypted value::"+new String(bytes));
			
			return new String(bytes);
		}
		
	// Check File is Exist or not	
		public boolean checkIfFileExist(String filePath, String fileName) {
			LOGGER.info("Checking File is exist ----->"+filePath + fileName);
			System.out.println("Checking File is exist ----->"+filePath + fileName);
			String FileName = fileName+".zip";
	        try {
	        	
	                      File file = new File(filePath + FileName);                      
	                      //file.createNewFile();
	                      return file.exists();

	        } catch (Exception e) {
	                      e.printStackTrace();
	        }
	        return false;
	}
		
		public void UNZIP_FILE(String zipFilePath, String destDir) {
	        File dir = new File(destDir);
	        // create output directory if it doesn't exist
	        if(!dir.exists()) dir.mkdirs();
	        FileInputStream fis;
	        //buffer for read and write data to file
	        byte[] buffer = new byte[1024];
	        try {
	            fis = new FileInputStream(zipFilePath);
	            ZipInputStream zis = new ZipInputStream(fis);
	            ZipEntry ze = zis.getNextEntry();
	            while(ze != null){
	                String fileName = ze.getName();
	                File newFile = new File(destDir + File.separator + fileName);
	                System.out.println("Unzipping to "+newFile.getAbsolutePath());
	                //create directories for sub directories in zip
	                new File(newFile.getParent()).mkdirs();
	                FileOutputStream fos = new FileOutputStream(newFile);
	                int len;
	                while ((len = zis.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	                }
	                fos.close();
	                //close this ZipEntry
	                zis.closeEntry();
	                ze = zis.getNextEntry();
	            }
	            //close last ZipEntry
	            zis.closeEntry();
	            zis.close();
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    }

		// Check File is Exist or not	
		public boolean checkFileExist(String filePath, String fileName) {
					LOGGER.info("Checking File is exist ----->"+filePath + fileName);
					System.out.println("Checking File is exist ----->"+filePath + fileName);
					
			        try {
			        	
			                      File file = new File(filePath + fileName);                      
			                      //file.createNewFile();
			                      return file.exists();

			        } catch (Exception e) {
			                      e.printStackTrace();
			        }
			        return false;
			}
		
		
	public String listenAFolder(String folderPath, String fileName, long timerInSeconds) {
			        
			        long now = System.currentTimeMillis();
			        long startInSeconds =  (now/1000)%60;
			        long endTime = now + (timerInSeconds * 1000);



			       while( now <=  endTime - 1) {
			            
			             now = System.currentTimeMillis();
			             startInSeconds =  (now/1000)%60;
			           try {
			                Thread.sleep(1000);
			            } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
			            if(checkIfFileExist(folderPath, fileName)) {
			                System.out.println(" File "+ fileName + " EXISTS in the folder " + folderPath);
			                LOGGER.info(" File "+ fileName + " EXISTS in the folder " + folderPath);
			                break;
			            } else {
			                System.out.println(" File "+ fileName + " doesn't exist in the folder " + folderPath);
			                LOGGER.info("File "+ fileName + " doesn't exist in the folder " + folderPath);
			            }
			        }

			       return null;
			        
			    }		
}
