package kroger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Krog_page {
	
	By uname = By.xpath("//*[@id='emailAddress']");
	By pwd = By.xpath("//*[@id='password']");
	By sbmt = By.xpath("//*[@id='submit']");
	By sqtn = By.xpath("//*[@id='scoped-to-account']/section/div/div/section/span/ul[1]/li[3]/a");
	By dsbd = By.xpath("//*[@id='scoped-to-account']/section/div/div/section/span/ul[5]/li/a");
	By dadd_p = By.id("desktop-add-patient-nav");
	By ptype = By.xpath("//*[@id='patienttype_dropdown-p0']");
	By pfn = By.xpath("//*[@id='patientfirstname_input-p0']");
	By pln = By.xpath("//*[@id='patientlastname_input-p0']");
	By pdob = By.xpath("//*[@id='dobBox-p0']/select");
	By pdd = By.xpath("//*[@id='dobBox-p0']/input[1]");
	By pyy = By.xpath("//*[@id='dobBox-p0']/input[2]");
	By ptrq = By.xpath("//*[@id='newPatientRequest']/div/div[1]/div[2]/ul[1]/li[7]/div/label[1]/input");
	By dalg = By.xpath("//*[@id='drugAllergyLabel-sulfa-p0']/input");
    By dhc = By.xpath("//*[@id='healthConditionLabel-asthma-p0']");
	By ins = By.xpath("//*[@id='insuranceCompanyOrGroup_input-p0']");
	By ins_nm = By.xpath("//*[@id='insuredName_input-p0']");
	By ins_id = By.xpath("//*[@id='insuredId_input-p0']");
	By bin = By.xpath("//*[@id='bin_input-p0']");
	By pcn = By.xpath("//*[@id='pcn_input-p0']");
    By chkbx = By.xpath("//*[@id='newPatientRequest']/div/div[1]/div[2]/ul[3]/li[1]/label/input");
    By prctype = By.xpath("//*[@id='prescriptiontype_dropdown-rx0-p0']");
    By mdname = By.xpath("//*[@id='medicationName_input-rx0-p0']");
    By nmprc = By.xpath("//*[@id='prescriberName_input-rx0-p0']");
    By prc_ph = By.xpath("//*[@id='prescriberPhone_input-rx0-p0']");
    By newpreq = By.xpath("//*[@id='newPatientRequest']/div/div[2]/input");
	By add_pres = By.xpath("//*[@id='linkPatient']/li[1]/li/a[1]");
    By pfrsn = By.xpath("//*[@id='firstNameBox']");
    By pfrsl = By.xpath("//*[@id='lastNameBox']");
    By pdobtype = By.xpath("//*[@id='dobBox']/select");
    By pdobdd = By.xpath("//*[@id='dobBox']/input[1]");
    By pdobyy = By.xpath("//*[@id='dobBox']/input[2]");
    By psrtype = By.xpath("//*[@id='selectprescription_type_dropdown']");
    By rxno = By.xpath("//*[@id='rxNumberBox']");
    By submt = By.xpath("//*[@id='submit_patient_details']");
    By sgnout = By.xpath("/html/body/span[2]/span[1]/span/div[1]/div[3]/div/span[1]/a[2]");
	By ptnumbber=By.id("patient_number_0");
	By dtfltr=By.id("date_filter");
	By exppno=By.id("expected_pres_number");
	By expqnty=By.id("expected_quanti");
	By expsupply=By.id("expected_supply");
	public WebDriver driver;
	
	public Krog_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	void setuplogin(String u, String p)
	{
		driver.findElement(uname).sendKeys(u);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(pwd).sendKeys(p);
		driver.findElement(sbmt).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	
	
	void hintquestion()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement seleniumlink;
		seleniumlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span[2]/span[1]/span/div[1]/div[3]/div/span[1]/a[1]")));
		seleniumlink.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(sqtn).click();
		//validate hint question with DB query
	}
	
	
	void newpatient() throws BiffException, IOException
	{
		String FilePath = "E://newpatient.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0);
		int rc=sh.getRows();
			for (int row = 2; row < rc; row++) {
		    String pfname=sh.getCell(0, row).getContents();
			String plastn=sh.getCell(1, row).getContents();
			String dobp=sh.getCell(2, row).getContents();
		    String pdate=sh.getCell(3, row).getContents();
		    String pyear=sh.getCell(4, row).getContents();
		    String insname=sh.getCell(5, row).getContents();
		    String insmhold=sh.getCell(6, row).getContents();
		    String insid=sh.getCell(7, row).getContents();
		    String bn=sh.getCell(8, row).getContents();
		    String pn=sh.getCell(9, row).getContents();
		    String mdcname=sh.getCell(10, row).getContents();
		    String presby=sh.getCell(11, row).getContents();
		    String prac_ph=sh.getCell(12, row).getContents();
		   	
		
		WebDriverWait wait4=new WebDriverWait(driver, 20);
		WebElement seleniumlink2;
		seleniumlink2= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span[2]/span[1]/span/div[1]/div[3]/div/span[1]/a[1]")));
		seleniumlink2.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebDriverWait wait2=new WebDriverWait(driver, 20);
		WebElement seleniumlink1;
		driver.findElement(sqtn).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		seleniumlink1= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("desktop-add-patient-nav")));
		seleniumlink1.click();		
		driver.findElement(dadd_p).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;	
		//new Select(driver.findElement(ptype)).selectByIndex(2);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(pfn).sendKeys(pfname);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(pln).sendKeys(plastn);
		new Select(driver.findElement(pdob)).selectByIndex(2);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(pdd).sendKeys(pdate);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(pyy).sendKeys(pyear);
		driver.findElement(ptrq).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(dalg).click();
		driver.findElement(dhc).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(ins).sendKeys(insname);
		driver.findElement(ins_nm).sendKeys(insmhold);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(ins_id).sendKeys(insid);
		driver.findElement(bin).sendKeys(bn);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(pcn).sendKeys(pn);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement e = driver.findElement(chkbx);
		e.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		new Select(driver.findElement(prctype)).selectByIndex(0);
		driver.findElement(mdname).sendKeys(mdcname);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(nmprc).sendKeys(presby);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(prc_ph).sendKeys(prac_ph);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(newpreq).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		// validate new patient with query in DB
}
	
	}
	
	 void addprescription() throws BiffException, IOException
		{
		 String FilePath = "E://prescription.xls";
			FileInputStream fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(0);
			int rc=sh.getRows();
			for (int row = 2; row < rc; row++) 
			{
			String pfname=sh.getCell(0, row).getContents();
			String plastn=sh.getCell(1, row).getContents();
			String pd=sh.getCell(2, row).getContents();
			String py=sh.getCell(3, row).getContents();
			String prx=sh.getCell(4, row).getContents();
		 	driver.findElement(add_pres).click();
		 			 	
			driver.findElement(pfrsn).sendKeys(pfname);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(pfrsl).sendKeys(plastn);
			new Select(driver.findElement(pdobtype)).selectByIndex(2);
			driver.findElement(pdobdd).sendKeys(pd);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(pdobyy).sendKeys(py);
			new Select(driver.findElement(psrtype)).selectByIndex(2);
			driver.findElement(rxno).sendKeys(prx);
			driver.findElement(submt).click();
			//validate query
		}
		}   
	    
	void prescriptionhistory() throws BiffException, IOException
	{
		String FilePath = "E://Pres_history.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0);
		int rc=sh.getRows();
		for (int row = 2; row < rc; row++) 
		{
			String ptnumber=sh.getCell(0, row).getContents();
			String datefilt=sh.getCell(1, row).getContents();
			String exppres=sh.getCell(2, row).getContents();
			String expquantity=sh.getCell(3, row).getContents();
			String esupply=sh.getCell(4, row).getContents();
			driver.findElement(ptnumbber).sendKeys(ptnumber);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(dtfltr).sendKeys(datefilt);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(exppno).sendKeys(exppres);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(expqnty).sendKeys(expquantity);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(expsupply).sendKeys(esupply);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		}	
		
	}
	
	void dashboard()
	{
		driver.findElement(dsbd).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//validate query 
	}
	
	void signout()
	{
		driver.navigate().refresh();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement seleniumlink;
		seleniumlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("sgnout")));
		seleniumlink.click();
		// logout
		}
	}
	

	

