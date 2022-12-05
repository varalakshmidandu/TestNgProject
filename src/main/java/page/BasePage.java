package page;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	
	WebDriver driver;
	public BasePage(WebDriver driver)
	{
		 this.driver=driver;
	}
	
	public static int generateRandomNumber(int boundaryNum)
	{
		Random r=new Random();
		return r.nextInt(boundaryNum);
	}
	
	public boolean checkIfCheckBoxIsSelected(WebElement element)
	{
		return element.isSelected();
	}
	
	public List<WebElement> getAllCheckBoxInPage()
	{
		List<WebElement> allCheckBoxes= this.driver.findElements(By.xpath("//input[@type='checkbox']"));
	    return allCheckBoxes;
	}
	
	public int getCheckBoxCountInPage(List<WebElement> allCheckBoxes)
	{
		return allCheckBoxes.size();
	}
	
	public void clickWebElement(WebElement element)
	{
		element.click();
	}
	
	public void enterTextInTextBox(String text,WebElement element)
	{
		element.sendKeys(text);
	}
	
	public void waitForOptionsInComboBox(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(this.driver,30);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, By.tagName("option")));
	}
	public boolean checkIfComboBoxHasThisValue(WebElement element,String input)
	{
		boolean flag=false;
		this.waitForOptionsInComboBox(element);
		Select sel = new Select(element);
		List<WebElement> optns=sel.getOptions();
		for(WebElement l:optns) {
			if(l.getText().equals(input))
			{
				flag= true;
				break;
			}
		}
		return flag;
	}
	
	public String getCurrentURLForPage()
	{
		return driver.getCurrentUrl();
	}
	public List<String> getOptionsFromDropdownBox(WebElement element)
	{
		Select sel=new Select(element);
		List<String> ll = new ArrayList<String>();
		List<WebElement> e=sel.getOptions();
		for(WebElement l:e) {
			if(!(l.getText().equals("None")))
			{
				 
				ll.add(l.getText());
			    
			}
		}
		return ll;
	}
}
	/*
	public List<String> getOptionsFromComboBox(WebElement element)
	{
	Boolean found = false;

	 element = driver.findElement(By.id("//*[@id=\\\"extra\\\"]/select[3]"));
	Select select = new Select(element);
	List<String> ll = new ArrayList<String>();
	List<WebElement> allOptions = select.getOptions();
	for(int i=0; i<allOptions.size(); i++) {
	    if(allOptions.equals("None")) {
	        found=true;
	        break;
	    }
	}
	if(found) {
	    System.out.println("Value exists");
	}
	return ll;
}*/

