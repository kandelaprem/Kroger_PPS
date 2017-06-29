package kroger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class KrogTest {

	public static void main(String[] args)throws BiffException, IOException  {
	


System.setProperty("webdriver.chrome.driver", "E:\\ch_dri\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		Krog_page obj = new Krog_page(driver);
       
		String FilePath = "E://TestData.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		
		Sheet sh = wb.getSheet(0);
		int rc=sh.getRows();
		String ur=sh.getCell(0,0).getContents();
		driver.get(ur);
		for (int row = 2; row < rc; row++) {
			
			String u=sh.getCell(0, row).getContents();
			String p=sh.getCell(1, row).getContents();
			obj.setuplogin(u, p);
					
			obj.newpatient();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		obj.addprescription();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		obj.prescriptionhistory();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		obj.hintquestion();
				
		} 
	}
}
