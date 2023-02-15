package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.Test;

import page.AddCategoryPage;
import page.BasePage;
import util.BrowseFactoryPage;


public class AddCategoryTest {

	WebDriver driver;
	AddCategoryPage addCategoryPage;
	String duplicateEntry;
	
	/*
	 * TC1: Validate a user is able to add a category and once the category is added it should display.
	 */
	@Test(priority=1)
	public void addCategory()
	{
		driver=BrowseFactoryPage.init();
		addCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);
		String input = "TestNG"+BasePage.generateRandomNumber(100);
		duplicateEntry=input;
		addCategoryPage.enterValuesForList(input);
		addCategoryPage.clickAddButton();
		Assert.assertEquals(addCategoryPage.checkComboBoxItemsForText(input),true);
		Assert.assertEquals(addCategoryPage.checkIfCategoryIsDisplayed(input),true);
	}
	
	/*
	 * TC2: Validate a user is not able to add a duplicated category. 
	 */
	@Test(priority=2)
	public void duplicateItems()
	{
		addCategoryPage.enterValuesForList(duplicateEntry);
		addCategoryPage.clickAddButton();
		Assert.assertEquals(addCategoryPage.getCurrentURLForPage(),"https://techfios.com/test/102/todo.php");	
		//BrowseFactoryPage.tearDown();
	}
	
	/*
	 * TC3: Validate the month drop down has all the months (jan, feb, mar ...) in the Due Date dropdown section.
	 */
	@Test(priority=3)
	public void validateMonths()
	{
		driver=BrowseFactoryPage.init();
		addCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);
		List<String> expectecMonths = new ArrayList<String>();
		//expectecMonths.add("None");
		expectecMonths.add("Jan");
		expectecMonths.add("Feb");
		expectecMonths.add("Mar");
		expectecMonths.add("Apr");
		expectecMonths.add("May");
		expectecMonths.add("Jun");
		expectecMonths.add("Jul");
		expectecMonths.add("Aug");
		expectecMonths.add("Sep");
		expectecMonths.add("Oct");
		expectecMonths.add("Nov");
		expectecMonths.add("Dec");
		List<String> actualMonths= addCategoryPage.getMonths();
//	//
//		System.out.println(al.get(i));
		 for(int i = 0; i<actualMonths.size();i++)
		 {
		//actualMonths.get(i).getText();
	    System.out.println("Actual Months :" + actualMonths.get(i)+ " --> "+ "Expected Months :" + expectecMonths.get(i) );
		
		Assert.assertEquals(actualMonths.get(i), expectecMonths.get(i)," month not available");
		//Assert.assertTrue(actualMonths.get(i).equals(expectecMonths.get(i)));
	
		 }
//}
	}
	}
