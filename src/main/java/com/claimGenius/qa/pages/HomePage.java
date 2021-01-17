package com.claimGenius.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="firstname")
	WebElement text_field_label_with_First_Name;
	
	@FindBy(name="lastname")
	WebElement text_field_label_with_Last_Name;
	
	
	@FindBy(xpath="//h3[contains(text(),'Selenium Practice Form')]")
	WebElement form_Title;
	

	@FindBy(id="continents")
	WebElement selectbox_labeled_with_continents;
	
	@FindBy(id="selenium_commands")
	WebElement mutli_selectbox_labeled_with_continents;
	
	@FindBy(id="photo")
	WebElement upload_button;
	
	@FindBy(id="sex-0")
	WebElement Male_radio_button;
	
	@FindBy(id="sex-1")
	WebElement Female_radio_button;
	
	@FindBy(id="profession-0")
	WebElement Manual_Tester_checkbox;
	
	@FindBy(id="profession-1")
	WebElement Automation_Tester_checkbox;
	
	
	
	public void set_First_Name(String first_name)
	{
		text_field_label_with_First_Name.sendKeys(first_name);
	}
	
	public void set_Last_Name(String last_name)
	{
		text_field_label_with_Last_Name.sendKeys(last_name);
	}
	
	public String getFormTitle()
	{
		String form_title = form_Title.getText();
		return form_title;
	}	
	
	
	
	
	public boolean Is_Textbox_labeled_with_First_Name_Available()
	{
		boolean firstname = text_field_label_with_First_Name.isDisplayed();
		return firstname;
	}
	
	public boolean Is_Textbox_labeled_with_First_Name_Active()
	{
		boolean firstname = text_field_label_with_First_Name.isEnabled();
		return firstname;
	}
	
	public String capture_value_of_text_box_labeled_with_First_Name()
	{
		String value =text_field_label_with_First_Name.getAttribute("value");
		return value;
	}
	
	public void clear_value_of_text_box_labeled_with_First_Name()
	{
		text_field_label_with_First_Name.clear();	
	}
	
	public boolean Is_selectbox_labeled_with_continents_Available()
	{
		boolean firstname = selectbox_labeled_with_continents.isDisplayed();
		return firstname;
	}
	
	public boolean Is_selectbox_labeled_with_continents_Active()
	{
		boolean firstname = selectbox_labeled_with_continents.isEnabled();
		return firstname;
	}
	public void click_on_upload_button()
	{
		upload_button.click();	
	}
	public boolean Is_upload_button_labeled_with_Upload_Image_Available()
	{
		boolean uploadbutton = upload_button.isDisplayed();
		return uploadbutton;
	}
	
	public boolean Is_upload_button_labeled_with_Upload_Image_Active()
	{
		boolean uploadbutton = upload_button.isEnabled();
		return uploadbutton;
	}
	
	
	
	public boolean Is_radio_button_labeled_with_Male_Available()
	{
		boolean Male = Male_radio_button.isDisplayed();
		return Male;
	}
	
	public boolean Is_radio_button_labeled_with_Female_Available()
	{
		boolean Female = Female_radio_button.isDisplayed();
		return Female;
	}
	
	public boolean Is_radio_button_labeled_with_Male_Active()
	{
		boolean Male = Male_radio_button.isEnabled();
		return Male;
	}
	
	public boolean Is_radio_button_labeled_with_Female_Active()
	{
		boolean Female = Female_radio_button.isEnabled();
		return Female;
	}
	
	
	public boolean Is_radio_button_labeled_with_Male_selected()
	{
		boolean Male = Male_radio_button.isSelected();
		return Male;
	}
	
	public boolean Is_radio_button_labeled_with_Female_selected()
	{
		boolean Female = Female_radio_button.isSelected();
		return Female;
	}
	
	public void select_male_radio_button()
	{
		Male_radio_button.click();
	}
	public void select_Female_radio_button()
	{
		Female_radio_button.click();
	}
	
	public boolean Is_checkbox_labeled_with_Manual_Tester_Available()
	{
		boolean Manual_Tester = Manual_Tester_checkbox.isDisplayed();
		return Manual_Tester;
	}
	
	public boolean Is_checkbox_labeled_with_Automation_Tester_Available()
	{
		boolean Automation_Tester = Automation_Tester_checkbox.isDisplayed();
		return Automation_Tester;
	}
	
	public boolean Is_checkbox_labeled_with_Manual_Tester_Active()
	{
		boolean Manual_Tester = Manual_Tester_checkbox.isEnabled();
		return Manual_Tester;
	}
	
	public boolean Is_checkbox_labeled_with_Automation_Tester_Active()
	{
		boolean Automation_Tester = Automation_Tester_checkbox.isEnabled();
		return Automation_Tester;
	}
	
	
	public boolean Is_checkbox_labeled_with_Manual_Tester_selected()
	{
		boolean Manual_Tester = Manual_Tester_checkbox.isSelected();
		return Manual_Tester;
	}
	
	public boolean Is_checkbox_labeled_with_Automation_Tester_selected()
	{
		boolean Automation_Tester = Automation_Tester_checkbox.isSelected();
		return Automation_Tester;
	}
	
	public void select_Manual_Tester_checkbox()
	{
		Manual_Tester_checkbox.click();
	}
	public void select_Automation_Tester_checkbox()
	{
		Automation_Tester_checkbox.click();
	}
	
	
	public boolean Is_multi_selectbox_labeled_with_continents_Available()
	{
		boolean mutli_selectbox = mutli_selectbox_labeled_with_continents.isDisplayed();
		return mutli_selectbox;
	}
	
	public boolean Is_multi_selectbox_labeled_with_continents_Active()
	{
		boolean mutli_selectbox = mutli_selectbox_labeled_with_continents.isEnabled();
		return mutli_selectbox;
	}
	
	
	
	
	
	
	
	
}




