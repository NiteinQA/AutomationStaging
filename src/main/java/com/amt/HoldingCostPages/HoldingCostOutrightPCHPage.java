package com.amt.HoldingCostPages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.ReadExcelCalculation;

public class HoldingCostOutrightPCHPage extends TestBase {
	ReadExcelCalculation obj_read_excel_calculation_page;
		
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/app-aquisition-header[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/p[1]")
	private WebElement holding_cost;	
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-holding-cost[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[6]/div[4]")
	private WebElement ownbook_holding_cost_matrix_default_cell;
	
	@FindBy(xpath = "//span[@class='slider round sliderRed']")
	private WebElement maintenance_toggle_button;
	
	@FindBy(xpath = "//div[@class='acc-head havebtns']")
	private WebElement holding_cost_summary;
	
	
	@FindBy(xpath = "//div[@class='vehicleDetails ownBookHolding']//div[7]//p[1]")
	private WebElement holding_cost_summary_residual_value_used;
	
	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/div/div[1]/div/p/strong")
	private WebElement holding_cost_summary_terms;
	
	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/div/div[2]/div/p/strong")
	private WebElement holding_cost_summary_mileage;	
	
	@FindBy(xpath = "//*[@id='collapseCustomerQuote']/div/div/div/div/div/form/div/div/div[1]/div/p/strong")
	private WebElement total_monthly_holding_cost;
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-holding-cost[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/label[1]/span[1]")
	private WebElement holding_cost_maintenance_toggle_button;
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-holding-cost[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-aquisition-vehicle-summary[1]/div[1]/div[1]/div[2]/div[2]/div[5]/div[2]/div[10]/p[1]")
	private WebElement holding_cost_maintenance_cost_used;
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-holding-cost[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	private WebElement holding_cost_percentage_cap_residual_value_used;
	
	
	
	@FindBy(xpath = "//input[@id='CapMaintenancePercentage']")
	private WebElement percentage_maintenance_cost_used;
	
	@FindBy(xpath = "//input[@id='ResidualValue']")
	private WebElement residual_value_used;
	
	@FindBy(xpath = "//input[@id='Maintenancevalue3']")
	private WebElement maintenance_cost_used;
	
	@FindBy(xpath = "//div[@class='bold subSectionTitle border-0']")
	private WebElement click_on_dead_element;
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-holding-cost[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-aquisition-vehicle-summary[1]/div[1]/div[1]/div[2]/div[2]/div[5]/div[2]/div[9]/p[1]")
	private WebElement total_cap_maintenance_value;
	
	
	public HoldingCostOutrightPCHPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	public boolean verify_holding_cost_without_maintenance(String sheet_name) throws IOException {
		Click.on(driver, holding_cost, 30);
		
		LO.print("***********Entered in holding cost page ***********");
		System.out.println("***********Entered in holding cost page ***********");
		
		Click.on(driver, holding_cost_summary, 30);
		
		 LO.print("Clicked on holding cost summary");
		  System.out.println("Clicked on holding cost summary");
		
		obj_read_excel_calculation_page =new ReadExcelCalculation();
		return obj_read_excel_calculation_page.verify_holding_cost_without_maintenance(driver,
				holding_cost_summary_terms, holding_cost_summary_mileage, 
				holding_cost_summary_residual_value_used, total_monthly_holding_cost, 
				sheet_name);
			}



	public boolean verify_holding_cost_with_maintenance(String percentage_maintenance_cost_used_from_excel, 
			String residual_value_used_from_excel, String maintenance_cost_used_from_excel,String percentage_cap_residual_value_used,
			String maintenance_required, String target_rental, String sheet_name ) throws IOException, InterruptedException {
		Actions act = new Actions(driver);
		
		Click.on(driver, holding_cost, 30);
		
		  LO.print("***********Entered in holding cost page ***********");
		  System.out.println("***********Entered in holding cost page ***********");
		  
		Click.on(driver, holding_cost_summary, 30);
		
		  LO.print("Clicked on holding cost summary");
		  System.out.println("Clicked on holding cost summary");
		  
		Click.on(driver, holding_cost_maintenance_toggle_button,30);
		
		LO.print("Clicked on holding_cost_maintenance_toggle_button");
		  System.out.println("Clicked on holding_cost_maintenance_toggle_button");
		  percentage_maintenance_cost_used.clear();
		  
		  ExplicitWait.visibleElement(driver, holding_cost_percentage_cap_residual_value_used, 50);
		  ExplicitWait.visibleElement(driver, percentage_maintenance_cost_used, 50);		  
		  ExplicitWait.visibleElement(driver, residual_value_used, 50);
		  
//		  holding_cost_percentage_cap_residual_value_used.clear();
//		  percentage_maintenance_cost_used.clear();
//		  residual_value_used.clear();
//		  
//		  act.sendKeys(Keys.TAB).build().perform();
//		  
//		  Click.sendKeys(driver, holding_cost_percentage_cap_residual_value_used, percentage_maintenance_cost_used_from_excel, 30);
//		  
//		  act.sendKeys(Keys.TAB).build().perform();
//		  Thread.sleep(5000);
//		  
//		  Click.sendKeys(driver, percentage_maintenance_cost_used, percentage_maintenance_cost_used_from_excel, 30);
//		  		  
//		  act.sendKeys(Keys.TAB).build().perform();
//		  Thread.sleep(5000);
//		  
//		  LO.print("Percentage_cap_maintenance_cost_used value ="+percentage_maintenance_cost_used_from_excel+" sent to input field -% CAP maint. cost used");
//		  System.out.println("Percentage_cap_maintenance_cost_used value ="+percentage_maintenance_cost_used_from_excel+" sent to input field -% CAP maint. cost used");
//		  
//		   
//		  Click.sendKeys(driver, residual_value_used, residual_value_used_from_excel , 30);
//		  act.sendKeys(Keys.TAB).build().perform();
//		  Thread.sleep(5000);
		  
		  
		 // Click.sendKeys(driver, maintenance_cost_used, maintenance_cost_used_from_excel , 30);
		   
		obj_read_excel_calculation_page =new ReadExcelCalculation();
		return  obj_read_excel_calculation_page.verify_holding_cost_with_maintenance(driver,
				holding_cost_summary_terms, holding_cost_summary_mileage, 
				holding_cost_summary_residual_value_used, total_monthly_holding_cost, holding_cost_maintenance_cost_used,
				holding_cost_percentage_cap_residual_value_used,total_cap_maintenance_value,  maintenance_required,target_rental,
				residual_value_used_from_excel,maintenance_cost_used_from_excel, percentage_cap_residual_value_used, percentage_maintenance_cost_used_from_excel,
				sheet_name);
		
		
		
	}
}
