package com.amt.HoldingCostPages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
import com.amt.testUtil.Difference;
import com.amt.testUtil.Dropdown;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.ReadExcelCalculation;
import com.amt.testUtil.RemoveComma;

public class HoldingCost_HPNR_FL_Page extends TestBase {
	ReadExcelCalculation obj_read_excel_calculation_page;
		
	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;
	
	@FindBy(xpath = "//p[contains(text(),'Holding cost')]")
	private WebElement holding_cost;	
	
	@FindBy(xpath = "//span[@class='slider round sliderRed']")
	private WebElement maintenance_toggle_button;
	
	@FindBy(xpath = "//div[@class='acc-head havebtns']")
	private WebElement holding_cost_summary;
	
	@FindBy(xpath = "//div[@class='vehicleDetails ownBookHolding']//div[7]//p[1]")
	private WebElement holding_cost_summary_residual_value_used;
	
	@FindBy(xpath = "//*[@id='ResidualValue']")
	private WebElement holding_cost_summary_residual_value_used_input_field;
	
	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/div/div[1]/div/p/strong")
	private WebElement holding_cost_summary_terms;
	
	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/div/div[2]/div/p/strong")
	private WebElement holding_cost_summary_mileage;	
	
	@FindBy(xpath = "//*[@id='headingCustomerQuote']/div[2]/div/div[3]/div/p/strong")
	private WebElement total_monthly_holding_cost;
	
	@FindBy(xpath = "//*[@class='slider round sliderRed']")
	private WebElement holding_cost_maintenance_toggle_button;
	
	@FindBy(xpath = "//*[@id='ResidualPercentage']")
	private WebElement holding_cost_maintenance_cost_used;
	
	@FindBy(xpath = "//input[@id='ResidualPercentage']")
	private WebElement holding_cost_percentage_cap_residual_value_used;
		
	@FindBy(xpath = "//input[@id='CapMaintenancePercentage']")
	private WebElement percentage_maintenance_cost_used;
	
	@FindBy(xpath = "//input[@id='ResidualValue']")
	private WebElement residual_value_used;
	
	@FindBy(xpath = "//input[@id='Maintenancevalue3']")
	private WebElement maintenance_cost_used;
		
	@FindBy(xpath = "//*[@id='collapseCustomerQuote']/div/div/div/div/div/form/div/div/div[5]/div/p/strong")
	private WebElement total_cap_maintenance_value;
	
	
	@FindBy(xpath = "//button[@class='btn btn-outline-secondary px-4 mr-2']")
	private WebElement add_funder_quote;
	
	@FindBy(xpath = "//label[@class='switch ml-1 mr-1']//span[@class='slider round sliderRed']")
	private WebElement holding_cost_based_on_funder_quote_toggle_button;
		
	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement funder;
	
	@FindBy(xpath = "//input[@id='quoteReferenceNo']")
	private WebElement quote_ref;
	
	@FindBy(xpath = "//input[@id='quoteExpiryDate']")
	private WebElement expiry_date;
	
	@FindBy(xpath = "//select[@name='acquisitionPaymentProfileId']")
	private WebElement payment_profile_dropdown;
	
	@FindBy(xpath = "//input[@id='duration']")
	private WebElement duration;
	
	@FindBy(xpath = "//input[@id='initialFinanceRental']")
	private WebElement initial_finance_rental;
	
	@FindBy(xpath = "//input[@id='totalInitialRental']")
	private WebElement total_initial_rental;
		
	@FindBy(xpath = "//input[@id='funderItemMileage']")
	private WebElement miles_per_annum;
	
	@FindBy(xpath = "//input[@id='contractMileage']")
	private WebElement contract_mileage;
	
	@FindBy(xpath = "//input[@id='cashDeposit']")
	private WebElement cash_deposit;
	
	@FindBy(xpath = "//input[@id='financeCharges']")
	private WebElement finance_charges;
	
	@FindBy(xpath = "//input[@id='monthlyFinanceRental']")
	private WebElement monthly_finance_rental;
	
	@FindBy(xpath = "//input[@id='finalBalloonPayment']")
	private WebElement final_balloon_payment;
	
	@FindBy(xpath = "//input[@id='optionToPurchaseFee']")
	private WebElement option_to_purchase_fee;
	
	@FindBy(xpath = "//input[@id='financeRental']")
	private WebElement monthly_payment;
	
	
	
	@FindBy(xpath = "//input[@id='documentFee']")
	private WebElement document_fee;
	
	@FindBy(xpath = "//input[@id='pencePerExcessMileageFinance']")
	private WebElement pense_per_excess_mile_finance;
	
	@FindBy(xpath = "//span[@class='slider round']")
	private WebElement funder_maintenance_toggle;
	
	@FindBy(xpath = "//span[@class='slider round sliderRed']")
	private WebElement common_maintenance_toggle;	
	
	@FindBy(xpath = "//input[@id='monthlyMaintenanceRental']")
	private WebElement monthly_maintenance_rental;	
	
	@FindBy(xpath = "//input[@id='pencePerExcessMileageMaintenance']")
	private WebElement pense_per_excess_mile_maintenance;
	
	@FindBy(xpath = "//input[@id='percentageOfSaleProceedToCustomer']")
	private WebElement percentage_of_sale_proceed_to_customer;
	
	@FindBy(xpath = "//input[@id='secondaryHirePeriodRental']")
	private WebElement secondary_hire_period_rental;	
	
	@FindBy(xpath = "//i[@class='btn-icon-addAddress-white']")
	private WebElement add;
	
	@FindBy(xpath = "//*[@id='collapseCustomerQuote']/div/div/div/div/div/form/div/div/div[4]/div/p/strong")
	private WebElement cap_monthly_maint_cost;	
	
	
	public HoldingCost_HPNR_FL_Page() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verify_holding_cost_after_adding_funder_quote_without_maintenance(String quoteRef, String expiryDate ,String term,String milesPerAnnum,String cashDeposit,
			String financeCharges,String documentFee, String monthlyPayment ,String finalBalloonPayment,String optionToPurchaseFee, String sheet_name) throws InterruptedException, IOException
	{
		Click.on(driver, holding_cost, 30);
		
		LO.print("***********Entered in holding cost page ***********");
		System.out.println("***********Entered in holding cost page ***********");
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);	
		
		Click.on(driver, add_funder_quote, 30);
		
		Thread.sleep(3000);
		
		Click.on(driver, holding_cost_based_on_funder_quote_toggle_button, 30);	
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);	
		
		
		 Click.on(driver, funder, 30);
		
		 Actions act = new Actions(driver);
		 act.sendKeys(Keys.ENTER).build().perform();
		 
		 Click.sendKeys(driver, quote_ref, quoteRef, 30);
		 
		 Click.sendKeys(driver, expiry_date, expiryDate, 30);
		 
		 Click.sendKeys(driver, duration, term, 30);
		 
		 Click.sendKeys(driver, miles_per_annum, milesPerAnnum, 30);

		 Click.on(driver, contract_mileage, 30);
		 
		 Click.sendKeys(driver, cash_deposit, cashDeposit, 30);
		 
		 Click.sendKeys(driver, finance_charges, financeCharges, 30);
		 
		 Click.sendKeys(driver, document_fee, documentFee, 30);
		 
		 Click.sendKeys(driver, monthly_payment, monthlyPayment, 30);
		 
		 Click.sendKeys(driver, final_balloon_payment, finalBalloonPayment, 30);
		 
		 Click.sendKeys(driver, option_to_purchase_fee, optionToPurchaseFee, 30);
		 
		 Click.on(driver, add, 30);	 
		 
		 ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		 
		 obj_read_excel_calculation_page =new ReadExcelCalculation();
		 
			obj_read_excel_calculation_page =new ReadExcelCalculation();
		   double monthly_holding_cost_expected=  obj_read_excel_calculation_page.verify_holding_cost_after_adding_funder_without_maintenance_for_hpnr_bch_pch( term, milesPerAnnum, monthlyPayment,
				   finalBalloonPayment, documentFee , sheet_name);
		 
		 ExplicitWait.visibleElement(driver, total_monthly_holding_cost, 50);
		 String monthly_holding_cost= total_monthly_holding_cost.getText().substring(2);
			
			String total_monthly_holding_cost_from_screen=RemoveComma.of(monthly_holding_cost);
			
			LO.print("Total_monthly_holding_cost_from_screen ="+monthly_holding_cost);
			System.out.println("Total_monthly_holding_cost_from_screen "+monthly_holding_cost);
			
			LO.print("Total_monthly_holding_cost_from_excel ="+monthly_holding_cost_expected);
			System.out.println("Total_monthly_holding_cost_from_excel "+monthly_holding_cost_expected);
			
			double total_monthly_holding_cost_actual1=Double.parseDouble(total_monthly_holding_cost_from_screen);	
			double diff=Difference.of_two_Double_Values(total_monthly_holding_cost_actual1, monthly_holding_cost_expected);
	        boolean flag=false;
			if(diff<0.2)
	        {	flag=true;	}				 
			
			return flag;	 
		 
	}
	
	
	public boolean verify_holding_cost_after_adding_funder_quote_with_maintenance(String quoteRef, String expiryDate ,String term,String milesPerAnnum,String cashDeposit,
			String financeCharges,String documentFee, String monthlyPayment ,String finalBalloonPayment,String optionToPurchaseFee, String sheet_name) throws InterruptedException, IOException
	{
		Click.on(driver, holding_cost, 30);
		
		LO.print("***********Entered in holding cost page ***********");
		System.out.println("***********Entered in holding cost page ***********");
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);	
		
		Click.on(driver, add_funder_quote, 30);
		
		Thread.sleep(3000);
		
		Click.on(driver, holding_cost_based_on_funder_quote_toggle_button, 30);	
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);	
		
		
		 Click.on(driver, funder, 30);
		 Thread.sleep(1000);
		
		 Actions act = new Actions(driver);
		 act.sendKeys(Keys.ENTER).build().perform();
		 
		 Click.sendKeys(driver, quote_ref, quoteRef, 30);
		 
		 Click.sendKeys(driver, expiry_date, expiryDate, 30);
		 
		 Click.sendKeys(driver, duration, term, 30);
		 
		 Click.sendKeys(driver, miles_per_annum, milesPerAnnum, 30);

		 Click.on(driver, contract_mileage, 30);
		 
		 Click.sendKeys(driver, cash_deposit, cashDeposit, 30);
		 
		 Click.sendKeys(driver, finance_charges, financeCharges, 30);
		 
		 Click.sendKeys(driver, document_fee, documentFee, 30);
		 
		 Click.sendKeys(driver, monthly_payment, monthlyPayment, 30);
		 
		 Click.sendKeys(driver, final_balloon_payment, finalBalloonPayment, 30);
		 
		 Click.sendKeys(driver, option_to_purchase_fee, optionToPurchaseFee, 30);
		 
		 Click.on(driver, add, 30);	 
		 
		 ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		 
		 Click.on(driver, common_maintenance_toggle, 30);
		 
		 ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		 
		 Click.on(driver, holding_cost_summary, 30);
			 
		 
		 ExplicitWait.visibleElement(driver, cap_monthly_maint_cost, 10);
		 
		 String cap_monthly_maint_value_from_screen = RemoveComma.of(cap_monthly_maint_cost.getText().trim().substring(2));
		 
		 
		 
		 
		 

		 
		 obj_read_excel_calculation_page =new ReadExcelCalculation();
		 
			obj_read_excel_calculation_page =new ReadExcelCalculation();
		   double monthly_holding_cost_expected=  obj_read_excel_calculation_page.verify_holding_cost_after_adding_funder_with_maintenance_for_hpnr_bch_pch( term, milesPerAnnum, monthlyPayment,cap_monthly_maint_value_from_screen,
				   finalBalloonPayment, documentFee , sheet_name);
		 
		 ExplicitWait.visibleElement(driver, total_monthly_holding_cost, 50);
		 String monthly_holding_cost= total_monthly_holding_cost.getText().substring(2);
			
			String total_monthly_holding_cost_from_screen=RemoveComma.of(monthly_holding_cost);
			
			LO.print("Total_monthly_holding_cost_from_screen ="+monthly_holding_cost);
			System.out.println("Total_monthly_holding_cost_from_screen "+monthly_holding_cost);
			
			LO.print("Total_monthly_holding_cost_from_excel ="+monthly_holding_cost_expected);
			System.out.println("Total_monthly_holding_cost_from_excel "+monthly_holding_cost_expected);
			
			double total_monthly_holding_cost_actual1=Double.parseDouble(total_monthly_holding_cost_from_screen);	
			double diff=Difference.of_two_Double_Values(total_monthly_holding_cost_actual1, monthly_holding_cost_expected);
	        boolean flag=false;
			if(diff<0.2)
	        {	flag=true;	}				 
			
			return flag;	 
		 
	}
	
	
	
	public boolean verify_holding_cost_after_adding_funder_quote_with_maintenance(String quoteRef, String expiryDate ,String term,String milesPerAnnum,String monthlyFinanceRental,
			String monthlyMaintenanceRental,String finalBallonPayment, String documentFee ,String pencePerExcessMileFinance,String pencePerExcessMileMaintenance,String percentageOfSaleProceedToCustomer,
			String secondaryHirePeriodRental, String sheet_name) throws InterruptedException, IOException
	{
		Click.on(driver, holding_cost, 30);
		
		LO.print("***********Entered in holding cost page ***********");
		System.out.println("***********Entered in holding cost page ***********");
		
		 ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

	
		 
		Click.on(driver, add_funder_quote, 30);
		
		Thread.sleep(3000);
		
		Click.on(driver, holding_cost_based_on_funder_quote_toggle_button, 30);			
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
        Click.on(driver, funder_maintenance_toggle, 30);
		
        ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
		
		 Click.on(driver, funder, 30);
		
		 Actions act = new Actions(driver);
		 act.sendKeys(Keys.ENTER).build().perform();
		 
		 Click.sendKeys(driver, quote_ref, quoteRef, 30);
		 
		 Click.sendKeys(driver, expiry_date, expiryDate, 30);
		 
		 Dropdown.select(driver, payment_profile_dropdown, 1, 30);
		 
		 Click.sendKeys(driver, duration, term, 30);
		 
		 Click.sendKeys(driver, miles_per_annum, milesPerAnnum, 30);

		 Click.on(driver, contract_mileage, 30);
		 
		 Click.sendKeys(driver, monthly_finance_rental, monthlyFinanceRental, 30);

		 Click.sendKeys(driver, final_balloon_payment, finalBallonPayment, 30);
		
		 Click.sendKeys(driver, document_fee, documentFee, 30);
		 
		 Click.sendKeys(driver, pense_per_excess_mile_finance, pencePerExcessMileFinance, 30);
		
		 Click.sendKeys(driver, percentage_of_sale_proceed_to_customer, percentageOfSaleProceedToCustomer, 30);
		 
		 Click.sendKeys(driver, secondary_hire_period_rental, secondaryHirePeriodRental, 30);
		 
		 Click.sendKeys(driver, monthly_maintenance_rental, monthlyMaintenanceRental, 30);

		 Click.sendKeys(driver, pense_per_excess_mile_maintenance, pencePerExcessMileMaintenance, 30);
		 
		 Click.on(driver, add, 30);	 
		 
		 ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		 
		 obj_read_excel_calculation_page =new ReadExcelCalculation();
		 
			obj_read_excel_calculation_page =new ReadExcelCalculation();
		   double monthly_holding_cost_expected=  obj_read_excel_calculation_page.verify_holding_cost_after_adding_funder_with_maintenance( term, milesPerAnnum, monthlyFinanceRental,
					 monthlyMaintenanceRental, finalBallonPayment,  documentFee , pencePerExcessMileFinance, pencePerExcessMileMaintenance, percentageOfSaleProceedToCustomer,
					 secondaryHirePeriodRental,  sheet_name);
		 
		 ExplicitWait.visibleElement(driver, total_monthly_holding_cost, 50);
		 Thread.sleep(2000);
		 String monthly_holding_cost= total_monthly_holding_cost.getText().substring(2);
			
			String total_monthly_holding_cost_from_screen=RemoveComma.of(monthly_holding_cost);
			
			LO.print("Total_monthly_holding_cost_from_screen ="+monthly_holding_cost);
			System.out.println("Total_monthly_holding_cost_from_screen "+monthly_holding_cost);
			
			LO.print("Total_monthly_holding_cost_from_excel ="+monthly_holding_cost_expected);
			System.out.println("Total_monthly_holding_cost_from_excel "+monthly_holding_cost_expected);
			
			double total_monthly_holding_cost_actual1=Double.parseDouble(total_monthly_holding_cost_from_screen);	
			double diff=Difference.of_two_Double_Values(total_monthly_holding_cost_actual1, monthly_holding_cost_expected);
	        boolean flag=false;
			if(diff<0.2)
	        {	flag=true;	}				 
			
			return flag;
		 
		 
		 
	}

	

	

	public boolean verify_holding_cost_without_maintenance(String sheet_name) throws IOException, InterruptedException {
		Click.on(driver, holding_cost, 30);
		
		LO.print("***********Entered in holding cost page ***********");
		System.out.println("***********Entered in holding cost page ***********");
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
		  LO.print("***********Entered in holding cost page ***********");
		  System.out.println("***********Entered in holding cost page ***********");
		  Thread.sleep(2000);  
		
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
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
		  LO.print("***********Entered in holding cost page ***********");
		  System.out.println("***********Entered in holding cost page ***********");
		  Thread.sleep(2000);  
		
		 Click.on(driver, holding_cost_summary, 30);

		Thread.sleep(3000);
		  LO.print("Clicked on holding cost summary");
		  System.out.println("Clicked on holding cost summary");
		  
		Click.on(driver, holding_cost_maintenance_toggle_button,30);
		
		LO.print("Clicked on holding_cost_maintenance_toggle_button");
		  System.out.println("Clicked on holding_cost_maintenance_toggle_button");
		  percentage_maintenance_cost_used.clear();
		  
		  ExplicitWait.visibleElement(driver, holding_cost_percentage_cap_residual_value_used, 50);
		  ExplicitWait.visibleElement(driver, percentage_maintenance_cost_used, 50);		  
		  ExplicitWait.visibleElement(driver, residual_value_used, 50);
		  

		   
		obj_read_excel_calculation_page =new ReadExcelCalculation();
		return  obj_read_excel_calculation_page.verify_holding_cost_with_maintenance(driver,
				holding_cost_summary_terms, holding_cost_summary_mileage, 
				holding_cost_summary_residual_value_used, total_monthly_holding_cost, holding_cost_maintenance_cost_used,
				holding_cost_percentage_cap_residual_value_used,total_cap_maintenance_value,  maintenance_required,target_rental,
				residual_value_used_from_excel,maintenance_cost_used_from_excel, percentage_cap_residual_value_used, percentage_maintenance_cost_used_from_excel,
				sheet_name);
		
		
		
		
	}
}
