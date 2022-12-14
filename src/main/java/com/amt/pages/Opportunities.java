package com.amt.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.GetExcelFormulaValue;
import com.amt.testUtil.Dropdown;

public class Opportunities extends TestBase {
	
	JavascriptExecutor js;
	
	@FindBy(xpath = "//i[@class='icon-opportunity']")
	private WebElement opportunities;
	
	
	@FindBy(xpath = "//input[@placeholder='Search something here']")
	private WebElement search_bar;
	
	
	@FindBy(xpath = "//tr[@class='ng-star-inserted']//td[9]")
	private WebElement oppo_open_status;
	
	@FindBy(xpath = "//div[@class='status']")
	private WebElement oppo_proposal_status;
	
	@FindBy(xpath = "//*[@id='cWraper']/div/app-opportunity-management/div[2]/div/div/div/app-grid/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[8]/div/div/div/span")
	private WebElement channel_status;
	
	@FindBy(xpath = "(//td[@class='p-0']//tr[@tablerowclicked='thirdLevel'][1]/td[7])[1]")  
	private WebElement contract_status;
	
	@FindBy(xpath = "//*[@id='cWraper']/div/app-opportunity-management/div[2]/div/div/div/app-grid/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[1]/div/div")  
	private WebElement quote_no;
	
		
	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;
	
	@FindBy(xpath = "//a[@title='Copy']//img")
	private WebElement copy_contract;
	
	@FindBy(xpath = "(//a[@title='Delete']//img)[4]")
	private WebElement delete_contract;	
	
	
    @FindBy(xpath = "//*[@title='Send Contract']")
	private WebElement send_contract;
    
	@FindBy(xpath = "//*[@id='sendcontractmodal']/div/div/div[2]/div[2]/div[1]/div/div/div/label")
	private WebElement override;
	
	@FindBy(xpath = "//*[@id='EmailIDshare']")
	private WebElement email_input_field;
	
	@FindBy(xpath = "//*[@id='sendcontractmodal']/div/div/div[3]/div/button[2]")
	private WebElement send_email;
	
	
	@FindBy(xpath = "//input[@id='loginUsernameBox']")
	private WebElement customer_email_input_field;
		
	@FindBy(xpath = "//input[@id='loginPasswordBox']")
	private WebElement customer_password_input_field;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement email_login_button;
	
	@FindBy(xpath = "//*[@id='mail-section-controller']/div[1]/div[1]/div[1]/div[1]/ul/li[4]/a/span[1]")
	private WebElement junk_box_count;
	 
	
	@FindBy(xpath = "//*[@id='mail-section-controller']/div[1]/div[1]/div[1]/div[1]/ul/li[4]/a")
	private WebElement email_Junk_box;	
	
	@FindBy(xpath = "//*[@id='searchBoxText']")
	private WebElement email_search_field;	
	
	@FindBy(xpath = "//*[@id='messageBody']/text()[5]")
	private WebElement email_doc_to_sign_link;
	
	@FindBy(xpath = "//i[@class='icon-opportunity']")
	private WebElement opportunity_menu_link;

	
	@FindBy(xpath = "//*[@id='cWraper']/div/app-opportunity-management/div[2]/div/div/div/app-grid/div[1]/div[1]/div[1]/div/div[1]/div/tag-input/div/div")
	private WebElement opportunity_search_text_box ;
	
	
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-opportunity-management[1]/div[2]/div[1]/div[1]/div[1]/app-grid[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[7]")
	private WebElement opp_listing_double_click ;
	
	
	
	@FindBy(xpath = "//input[@id='fleetCar']")
	private WebElement opp_opp_fact_find_no_of_cars ;
	
	
	@FindBy(xpath = "//input[@id='fleetHgv']")
	private WebElement opp_opp_fact_find_no_of_hgv ;

	@FindBy(xpath = "//input[@id='fleetLCV']")
	private WebElement opp_opp_fact_find_no_of_lcv ;
	
	
	@FindBy(xpath = "//select[@id='carScheme']")
	private WebElement opp_opp_fact_find_no_of_carscheme ;
	
	@FindBy(xpath = "//app-opportunity-header/div[1]/div[2]/div[1]/button[2]/i[1]")
	private WebElement opp_opp_update_button ;
	
	
	
	@FindBy(xpath = "//*[@id='cWraper']/div/app-add-opportunities/app-opportunity-header/div/div[1]/div/ul/li[3]/a/p")
	private WebElement opp_proposal_button ;
	
	
	
	@FindBy(xpath = "//*[@id=\"cWraper\"]/div/app-opportunity-management/div[2]/div/div/div/app-grid/div[2]/div/div[2]/div[1]/table/tbody/tr[8]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[7]/div/div/div/span")
	private WebElement opp_find_channel_status ;

	@FindBy(xpath = "//*[@id=\"cWraper\"]/div/app-opportunity-management/div[2]/div/div/div/app-grid/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr/td[8]/div/a[4]")
	private WebElement opp_find_send_contract_icon ;

	@FindBy(xpath = "//*[@id=\"sendcontractmodal\"]/div/div/div[3]/div/button[2]")
	private WebElement send_contract_to_customer_pop_up_send_button ;

	
	// Channel data 
	
	@FindBy(xpath = "//*[@id=\"cWraper\"]/div/app-opportunity-management/div[2]/div/div/div/app-grid/div[2]/div/div[2]/div[1]/table/tbody/tr[6]/td[2]/table/tbody/tr[2]/td[2]/table/tbody")
	private List<WebElement> channel_data ;

	

	
	
	
	
	

	
	public Opportunities() {
		PageFactory.initElements(driver, this);
		
		try
    	{
    		prop=new Properties();
    		FileInputStream ip = new FileInputStream("D:\\StagingNew\\AMT_Automation\\src\\main\\java\\configs\\excelValues.properties");
    		prop.load(ip);                            
    	}
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
		
    	}
	
	public boolean search_and_verify_opportunity(String sheet_name) throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		
		
		String oppoNo = GetExcelFormulaValue.get_cell_value(0, 1, sheet_name);	
		
		Click.sendKeys(driver, search_bar, oppoNo, 30);
		
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.ENTER).build().perform(); 		
		
   		LO.print("Searched opportunity with Opportunity ref no.");
   		System.out.println("Searched opportunity with Opportunity ref no.");
   		
   		ExplicitWait.visibleElement(driver, quote_no, 30);
   		
   		String quoteNoFromScreen = quote_no.getText().trim();
   		
   		String quoteNoFromExcel = GetExcelFormulaValue.get_cell_value(0, 0, sheet_name);
   		
   		boolean status =false;
   		if(quoteNoFromScreen.equals(quoteNoFromExcel))
   		{
   			status = true ;
   		}
   		return status ;
	}
	
	public boolean verify_status_of_opportunity() throws InterruptedException, IOException
	{
		ExplicitWait.visibleElement(driver, oppo_open_status, 30); 
		
		ExplicitWait.visibleElement(driver, oppo_proposal_status, 30);
		
		ExplicitWait.visibleElement(driver, channel_status, 30);
		
		ExplicitWait.visibleElement(driver, contract_status, 30);
		
		String oppoOpenStatus = oppo_open_status.getText().trim();
		
		String oppoProposalStatus = oppo_proposal_status.getText().trim();
		
		String oppoChannelStatus = channel_status.getText().trim();
		
		String oppoContractStatus = contract_status.getText().trim();
		
		boolean openStatus = oppoOpenStatus.equals("Open");
		boolean proposalStatus =oppoProposalStatus.equals("Proposal Required");
		boolean channelStatus =oppoChannelStatus.equals("Draft");
		boolean contractStatus =oppoContractStatus.equals("Draft");
		
		boolean flag = false;
		if(openStatus&&proposalStatus&&channelStatus&&contractStatus) {
			flag = true ;			
		}
		
		return flag;		
		
	}

    public boolean verify_contract_is_copied(String sheet_name) throws InterruptedException, IOException

{
	Click.on(driver, copy_contract, 30);
	
	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
	
    String oppoNo = GetExcelFormulaValue.get_cell_value(0, 1, sheet_name);	
	
    Thread.sleep(3000);
    
	Click.sendKeys(driver, search_bar, oppoNo, 30);
	
	Actions act = new Actions(driver);
	
	act.sendKeys(Keys.ENTER).build().perform();
	
	Thread.sleep(3000);
	
	List<WebElement> copy_icons = driver.findElements(By.xpath("//a[@title='Copy']//img"));
	
	ExplicitWait.waitForListOfVisibleElements(driver, copy_icons, 20);
	
	System.out.println("Copy icons present on screen are "+copy_icons.size());
	
	boolean status = false;
	if(copy_icons.size()>1)
	{
		status = true;
	}
	
	return status;
	
}

    public boolean verify_copied_contract_is_deleted(String sheet_name) throws IOException, InterruptedException
{
	Thread.sleep(3000);
	
	String oppoNo = GetExcelFormulaValue.get_cell_value(0, 1, sheet_name);	
		
	Click.on(driver, delete_contract, 30);
	
	Actions act = new Actions(driver);
	
	Thread.sleep(3000);
	
	act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB, Keys.ENTER).build().perform(); 
	
	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
	
    Click.sendKeys(driver, search_bar, oppoNo, 30);
	
    act.sendKeys(Keys.ENTER).build().perform(); 
    
     List<WebElement> copy_icons = driver.findElements(By.xpath("//a[@title='Copy']//img"));
	
	boolean status = false;
	if(copy_icons.size()==1)
	{
		status = true;
	}
	
	return status;		
	
   }
	
    public boolean verify_contract_is_sent_to_mail(String sheet_name , String customer_email_id) throws InterruptedException
    {
    	Click.on(driver, send_contract, 30);
    	
    	Thread.sleep(4000);
    	
    	js = (JavascriptExecutor)driver;
    	
    	ExplicitWait.clickableElement(driver, override, 20);
    	
    	js.executeScript("arguments[0].click();", override );
    	
    	ExplicitWait.clickableElement(driver, email_input_field, 20);
    	
    	email_input_field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    	
    	Click.sendKeys(driver, email_input_field, customer_email_id, 30);
    	
    	Click.on(driver, send_email, 30);
    	
    	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
    	
	 	ExplicitWait.visibleElement(driver, channel_status, 30);
		
		ExplicitWait.visibleElement(driver, contract_status, 30);
		
		String oppoChannelStatus = channel_status.getText().trim();
		
		String oppoContractStatus = contract_status.getText().trim();

		boolean channelStatus =oppoChannelStatus.equals("Sent to customer");
		boolean contractStatus =oppoContractStatus.equals("Sent to customer");
		
		boolean flag = false;
		if(channelStatus&&contractStatus) {
			flag = true ;			
		}
		
		return flag;   	
    	    	
    }
  
    
    
    public void verify_mail_is_received(String sheet_name , String customer_email_id, String password) throws InterruptedException {
	   
	  WebDriver newEmailTab = driver.switchTo().newWindow(WindowType.TAB);
		
	  newEmailTab.get("https://mail.thegatewaydigital.com/interface/root#/login");
	
	Set<String> handles=driver.getWindowHandles();
	
	Thread.sleep(3000);
	 
	Click.sendKeys(newEmailTab, customer_email_input_field, customer_email_id , 30);
	
	Click.sendKeys(newEmailTab, customer_password_input_field, password , 30);
	
	Thread.sleep(6000);
	
	Click.on(newEmailTab, email_login_button, 30);
	
	Click.on(newEmailTab, email_Junk_box, 30);
	
	ExplicitWait.visibleElement(newEmailTab, junk_box_count, 30);
	
	double junkBoxCount = Double.parseDouble(junk_box_count.getText());
	double junkBoxCount1 = Double.parseDouble(junk_box_count.getText());
	
	while(junkBoxCount==junkBoxCount1) {
	newEmailTab.navigate().refresh();	
	ExplicitWait.visibleElement(newEmailTab, junk_box_count, 30);
	Thread.sleep(2000);
	double junkBoxCount2 = Double.parseDouble(junk_box_count.getText());
	junkBoxCount = junkBoxCount2;
	}
	
	Thread.sleep(3000);
	
	Click.sendKeys(newEmailTab, email_search_field, "AMT Auto has sent you a document to sign", 30);
	
    Actions act = new Actions(driver);
	
	Thread.sleep(3000);
	
	act.sendKeys(Keys.ENTER).build().perform();
	
	ExplicitWait.visibleElement(newEmailTab, email_doc_to_sign_link, 30);
	
	String doc_sign_link = email_doc_to_sign_link.getText();
	
	WebDriver newDocTab = newEmailTab.switchTo().newWindow(WindowType.TAB);
	
	newDocTab.get(doc_sign_link);
	
	
} 
	
    

	public void opp_Menu_link() throws Exception

	{
		Thread.sleep(3000);

		//Click on Search text box of Opportunity
		Click.on(driver, opportunity_menu_link, 30);

		LO.print("Clicked on Opportunity link form Menu ");
		System.out.println("Clicked on Opportunity link form Menu");
		//ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
		//Click.sendKeys(driver, Lead_OpportunityId, null, 10);

	  
}
	
	
	
	public void opp_Search_Textbox(String GetOpportunityid1) throws Exception

	{

		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		ExplicitWait.visibleElement(driver, search_bar, 10);
		
		
	
    Thread.sleep(5000);

	
    search_bar.sendKeys(GetOpportunityid1);
		

		LO.print("Enter the Opportunity id in Search Text box");
		System.out.println("Enter the Opportunity id in Search Text box");
		
		search_bar.sendKeys(Keys.ENTER);
		
		
	    Thread.sleep(5000);
	
}
	
	
	
	
	
    
	
	
	
	public void opp_Listing_detail_page() throws Exception

	{


		
		ExplicitWait.visibleElement(driver, opp_listing_double_click, 10);
		
		Actions act = new Actions(driver);

		//Double click on element
 
		act.doubleClick(opp_listing_double_click).perform();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		


	
    
		}
	
	
	public void opp_Listing_detail_update_indiviual() throws Exception

	{

		 Thread.sleep(5000);
		
    
    
    
    ExplicitWait.visibleElement(driver, opp_opp_update_button, 10);
    
    opp_opp_update_button.click();
    
	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
    
    // proposal link 
    
	  Thread.sleep(5000);
    
 ExplicitWait.visibleElement(driver, opp_proposal_button, 20);
    
 opp_proposal_button.click();
    
 
 LO.print("click on Proposal icon");
	System.out.println("click on Proposal icon");
 
    
		}
	
	
	
	public void opp_opp_fact_find_Find() throws Exception

	{

		 Thread.sleep(5000);
		
		ExplicitWait.visibleElement(driver, opp_opp_fact_find_no_of_cars, 10);
		
		
		opp_opp_fact_find_no_of_cars.sendKeys("1");
		
	
    Thread.sleep(5000);

    ExplicitWait.visibleElement(driver, opp_opp_fact_find_no_of_hgv, 10);
    
    opp_opp_fact_find_no_of_hgv .sendKeys("1");
    
    
    ExplicitWait.visibleElement(driver, opp_opp_fact_find_no_of_lcv, 10);
    
    opp_opp_fact_find_no_of_lcv .sendKeys("1");
    
    
   // ExplicitWait.visibleElement(driver, opp_opp_fact_find_no_of_carscheme, 10);
    
	
    Dropdown.selectByVisibleText(driver, opp_opp_fact_find_no_of_carscheme, " No ", 10);
    
    opp_opp_fact_find_no_of_carscheme.click();
    
    
    
    ExplicitWait.visibleElement(driver, opp_opp_update_button, 10);
    
    opp_opp_update_button.click();
    
	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
    
    // proposal link 
    
	  Thread.sleep(5000);
    
 ExplicitWait.visibleElement(driver, opp_proposal_button, 20);
    
 opp_proposal_button.click();
    
 
 LO.print("click on Proposal icon");
	System.out.println("click on Proposal icon");
 
    
	//ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
    
    
		
		
	/*	@FindBy(xpath = "//input[@id='fleetCar']")
		private WebElement opp_opp_fact_find_no_of_cars ;
		
		
		@FindBy(xpath = "//input[@id='fleetHgv']")
		private WebElement opp_opp_fact_find_no_of_hgv ;

		@FindBy(xpath = "//input[@id='fleetLCV']")
		private WebElement opp_opp_fact_find_no_of_lcv ;
		
		
		@FindBy(xpath = "//select[@id='carScheme']")
		private WebElement opp_opp_fact_find_no_of_carscheme ;*/
    
		}
	
	
	
	
	
	public void opp_Find_Channel_Status() throws Exception

	{
		
		ExplicitWait.visibleElement(driver, opp_find_channel_status, 10);
		
		
		String Find_Channel_Status = opp_find_channel_status.getText();
		
		 LO.print("Channel_Status =" + Find_Channel_Status );
			System.out.println("Channel_Status" + Find_Channel_Status );

		
		
		
	}
	
	
	
	
	
	public void opp_Find_Send_Contract_icon() throws Exception

	{

		 Thread.sleep(5000);
		
		ExplicitWait.visibleElement(driver, opp_find_send_contract_icon, 10);
		
		 LO.print("click on Send_Contract icon");
			System.out.println("click on  Send_Contract icon");

			opp_find_send_contract_icon.click();
		
		
		
		
		
		
		
		ExplicitWait.visibleElement(driver, send_contract_to_customer_pop_up_send_button, 10);
		
	
		
		send_contract_to_customer_pop_up_send_button.click(); 
		
		
		
		 //*[@id="sendcontractmodal"]/div/div/div[3]/div/button[2]
		
		
	}
	
	

	public void opp_Verify_Channel_data() throws Exception

	{

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		ExplicitWait.waitForListOfVisibleElements(driver, channel_data, 20);
		
	
		
		
		 String [] data = new String[channel_data.size()];
		 
		
		    
for (int i=0 ; i<=channel_data.size()-1; i++)
	
{

	
	 data[i] = channel_data.get(i).getText();
	
	System.out.println("Data =" + data[i]);
	
//	System.out.println("Data =" + data[i]);
	
	
}
   
System.out.println("Data =" + data[3]);
        
	}
	
	
    
}		 
		
		