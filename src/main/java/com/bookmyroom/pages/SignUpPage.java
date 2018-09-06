package com.bookmyroom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookmyroom.util.Constants;
import com.bookmyroom.util.GetExcelData;
import com.bookmyroom.util.Reusable;

public class SignUpPage {
	
	static WebDriver driver;
	GetExcelData excelData=new GetExcelData();
	
	Reusable util=new Reusable(driver);	
	static org.apache.log4j.Logger log = Logger.getLogger(SignUpPage.class.getName());
	
	public SignUpPage(WebDriver driver){
		SignUpPage.driver=driver;
	}
	
	public void signUp(String name,String email,String username,String password,String gender,String age,String phone) 
	{
		
		String data[][];
		
			data = excelData.getData(Constants.signUpExcelPath, "SignUp");
			
			System.out.println("In signUpPage: "+Constants.signUpExcelPath);
		
		
		for(int i=0;i<data.length;i++)
        {
			System.out.println("----- Keyword: "+data[i][Constants.keyword_col]+" ------");
			switch(data[i][Constants.keyword_col])
	    	{
	    	
	    	case "navigateTo":
	    		util.navigateTo(data[i][Constants.parameter_col]);
	    		util.implicitWait();
	    		break;
	    		
	    	case "clickSignUp":
	    		util.click(data[i][Constants.pathType_col], data[i][Constants.path_col]);
	    		util.implicitWait();
	    		break;	    
	    		
	    	case "enterName":
	    		util.enterText(data[i][Constants.pathType_col], data[i][Constants.path_col], name);
	    		util.implicitWait();
	    		break;
	    	
	    	case "enterUsername":
	    		util.enterText(data[i][Constants.pathType_col], data[i][Constants.path_col], username);
	    		util.implicitWait();
	            break;
	    		
	    	case "enterEmail":
	    		util.enterText(data[i][Constants.pathType_col],data[i][Constants.path_col], email);
	    		util.implicitWait();
	    		break;

			    		
	    	case "enterPassword":
	    		util.enterText(data[i][Constants.pathType_col],data[i][Constants.path_col], password);
	    		util.implicitWait();
	    	    break;
	    		
	    	case "selectGender":
	    		util.selectFromDropDownBox(data[i][Constants.pathType_col],data[i][Constants.path_col] ,gender);
	    		util.implicitWait();
	    	    break;
	    		
	    	case "enterAge":
	    		util.enterText(data[i][Constants.pathType_col], data[i][Constants.path_col], age);
	    		util.implicitWait();
	    		break;
	    		
	    	case "enterPhone":
	    		util.enterText(data[i][Constants.pathType_col], data[i][Constants.path_col], phone);
	    		util.implicitWait();
	    		break;
	    	
	    	case "clickSubmit":
	    		util.click(data[i][Constants.pathType_col], data[i][Constants.path_col]);
	    		util.implicitWait();
	    		break;
	    		
	    	case "verifyTitle":
	    	util.verifyTitle(data[i][Constants.parameter_col]);
	    	util.implicitWait();
	    	break;
	    	//util.verify(data[i][Constants.pathType_col],data[i][Constants.path_col], data[i][Constants.parameter_col]);
	    	
	        
	    	default:log.debug("Invalid Keyword");
	    	
	    	}
        }
		
	}

}
