package com.amt.test.OP;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amt.CustomerQuotePackage.CustomerQuotePageOutrightHPNRPage;
import com.amt.HoldingCostPages.HoldingCostOutrightHPNRPage;
import com.amt.QuoteSummaryPages.QuoteSummaryOutrightHPNRPage;
import com.amt.pages.AcquisitionListingPage;
import com.amt.pages.LoginPage;
import com.amt.pages.OptionsAccessoriesPage;
import com.amt.pages.VehicleSelectionPage;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_Outright_HPNR_Page;
import com.amt.testBase.TestBase;
import com.amt.testUtil.ReadExcelData;

@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Acquisition_Quotes_Outright_HPNR_with_maintenance_Normal_Save_Test extends TestBase {



	LoginPage obj_Login_Page;
	AcquisitionListingPage obj_acq_listing_page;
	VehicleSelectionPage obj_vehicle_selection_page;
	OptionsAccessoriesPage obj_options_accessories;
	ContractTypesAndOTR_Outright_HPNR_Page obj_contract_types_and_OTR_page;
	HoldingCostOutrightHPNRPage obj_holding_cost_page;
	CustomerQuotePageOutrightHPNRPage obj_customer_quote_page;
	QuoteSummaryOutrightHPNRPage obj_quote_summary_page;


	@Test(priority = 1, dataProvider = "testData")
	public void aquisition_quotes_outright_HPNR_OTR_calculation_with_maintenance_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		obj_acq_listing_page = new AcquisitionListingPage();
		obj_vehicle_selection_page = new VehicleSelectionPage();
		obj_options_accessories = new OptionsAccessoriesPage();
		obj_contract_types_and_OTR_page = new ContractTypesAndOTR_Outright_HPNR_Page();
		

		obj_acq_listing_page.aquisition_Listingpage_AddnewQuote();
		obj_vehicle_selection_page.select_vehicle(manufacturer, model);
		obj_options_accessories.options_And_Accessories_selection();
		boolean subtotal_after_discount = obj_contract_types_and_OTR_page
				.contractTypes_and_OTR_selection_outright_HPNR_Ownbook_calculation(sheet_name);
		Assert.assertTrue(subtotal_after_discount);

	}
	
	@Test(priority=2, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_outright_HPNR_OTR_calculation_with_maintenance_test" })

	public void aquisition_quotes_outright_HPNR_after_discount_calculations_with_maintenance_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		obj_contract_types_and_OTR_page = new ContractTypesAndOTR_Outright_HPNR_Page();

		boolean otr_price_check = obj_contract_types_and_OTR_page
				.verify_after_discount_calculations_contract_types_page(sheet_name);
		Assert.assertTrue(otr_price_check);


	}
	
	@Test(priority=3, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_outright_HPNR_after_discount_calculations_with_maintenance_test" })

	public void aquisition_quotes_outright_HPNR_holding_cost_calculations_with_maintenance_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		obj_holding_cost_page = new HoldingCostOutrightHPNRPage();
	
		boolean holding_cost_without_maintenance_boolean = obj_holding_cost_page
				.verify_holding_cost_with_maintenance( percentage_cap_maint_value, 
					 residual_value_used,  maint_cost_used, percentage_cap_residual_value,
				     maintenance_status,  target_rental,  sheet_name );
		Assert.assertTrue(holding_cost_without_maintenance_boolean);
	

	}
	
	@Test(priority=4, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_outright_HPNR_holding_cost_calculations_with_maintenance_test" })

	public void aquisition_quotes_outright_HPNR_customer_quote_calculations_check_monthly_finance_payment_with_maintenance_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {


		obj_customer_quote_page = new CustomerQuotePageOutrightHPNRPage();
		
		boolean monthly_total_payment_check =obj_customer_quote_page.check_monthly_payment_on_customer_quote_with_maintenance(driver,maintenance_status, matrix_credit_type, balloon_payment_status,order_deposit, finance_deposit,document_fee, sheet_name);
		Assert.assertTrue(monthly_total_payment_check);

	}	
		
	@Test(priority=5, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_outright_HPNR_customer_quote_calculations_check_monthly_finance_payment_with_maintenance_test" })

	public void aquisition_quotes_outright_HPNR_quote_summary_values_verification_with_maintenance_test(String manufacturer, String model, 
			String Vehicle_Basic_price, String  road_tax_for_first_year, String percentage_cap_residual_value, String percentage_cap_maint_value,
			String residual_value_used, String maint_cost_used, String target_rental, String additional_terms, String additional_mileage,
			String vehicle_profit ,String  maintenance_status,String matrix_credit_type, String security_deposit, 
			String balloon_payment_status, String part_exchange_actual, String part_exchange_given, String less_finance_settlement,
			String  order_deposit, String finance_deposit, String document_fee, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {


		obj_quote_summary_page = new QuoteSummaryOutrightHPNRPage();
		
		boolean quote_summary_value_check =obj_quote_summary_page.quote_summary_outright_HPNR_with_maintenance(sheet_name);		
        
		Assert.assertTrue(quote_summary_value_check);       
	}
	
	

	@DataProvider(name = "testData")
	public Object[][] getTestData() throws IOException {
		Object[][] data = ReadExcelData.getTestData("OutrightHPNRwithMaintenance");
		return data;
	}

}
