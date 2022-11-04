package com.amt.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amt.CustomerQuotePackage.CustomerQuotePageBrokerFLPage;
import com.amt.CustomerQuotePackage.CustomerQuotePageBrokerPCHPage;
import com.amt.QuoteSummaryPages.QuoteSummaryBrokerFLPage;
import com.amt.QuoteSummaryPages.QuoteSummaryBrokerPCHPage;
import com.amt.pages.AcquisitionListingPage;
import com.amt.pages.OptionsAccessoriesPage;
import com.amt.pages.VehicleSelectionPage;
import com.amt.pages.AcquisitionBrokerPages.AcquisitionQuotesBrokerBCHPage;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_Broker_FL_Page;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_Broker_PCH_Page;
import com.amt.testBase.TestBase;
import com.amt.testUtil.ReadExcelData;


@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Acquisition_Quotes_Broker_FL_without_maintenance_Test extends TestBase {
	
	public AcquisitionQuotesBrokerBCHPage obj_aquisition_quotes_page_broker_bch;
	AcquisitionListingPage obj_acq_listing_page;
	VehicleSelectionPage obj_vehicle_selection_page;
	OptionsAccessoriesPage obj_options_accessories;
	ContractTypesAndOTR_Broker_FL_Page obj_contract_types_and_OTR_Broker_FL;
	CustomerQuotePageBrokerFLPage obj_customer_quote_page;
	QuoteSummaryBrokerFLPage  obj_quote_summary_page;
	
	
		
	@Test(priority=0, dataProvider="testData")
	public void aquisition_quotes_user_flow_broker_fl_without_maintenance_test(String manufacturer, String model, String quoteRef, 
			String quoteExpiryDate, String term, String milesperannum,String initialFinanceRental, String monthlyFinanceRental,
			String finalBallonPayment, String pensePerExcessMileFinance,String percentageOfSaleProceedsToCustomer, 
			String secondaryHirePeriodRental,String commission, String sheet_name) throws InterruptedException, IOException {
			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 obj_vehicle_selection_page = new VehicleSelectionPage();
	     obj_options_accessories = new OptionsAccessoriesPage();
		 obj_contract_types_and_OTR_Broker_FL = new ContractTypesAndOTR_Broker_FL_Page();
		 obj_customer_quote_page = new CustomerQuotePageBrokerFLPage();
		 obj_quote_summary_page =new QuoteSummaryBrokerFLPage();
		
		obj_acq_listing_page.aquisition_Listingpage_AddnewQuote();
		obj_vehicle_selection_page.select_vehicle(manufacturer, model);
		obj_options_accessories.options_And_Accessories_selection();
		boolean subtotal_after_discount=obj_contract_types_and_OTR_Broker_FL.contractTypes_and_OTR_selection_broker_fl(sheet_name);
		Assert.assertTrue(subtotal_after_discount);
		
		boolean otr_price_check = obj_contract_types_and_OTR_Broker_FL
				.verify_after_discount_calculations_contract_types_page(sheet_name);
		Assert.assertTrue(otr_price_check);
		
		boolean customer_quote_check=obj_customer_quote_page.customer_Quote_broker_fl_without_maintenance(quoteRef, quoteExpiryDate,term, milesperannum, 
				initialFinanceRental,monthlyFinanceRental,finalBallonPayment, pensePerExcessMileFinance,percentageOfSaleProceedsToCustomer,
				secondaryHirePeriodRental,commission);	
		
		Assert.assertTrue(customer_quote_check);
		
		boolean quote_summary_page_status = obj_quote_summary_page.quote_summary_broker_fl_without_maintenance(sheet_name);
		Assert.assertTrue(quote_summary_page_status);
		
	}
	
	
	
	@DataProvider(name="testData")
	public Object[][] getTestData() throws IOException {		
		Object[][] data=ReadExcelData.getTestData("BrokerFLwithoutMaintenance");
		return data;	
		
	}

}
