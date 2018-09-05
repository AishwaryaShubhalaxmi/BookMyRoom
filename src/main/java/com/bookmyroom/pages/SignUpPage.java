package com.bookmyroom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.bookmyroom.util.Constants;
import com.bookmyroom.util.GetExcelData;
import com.bookmyroom.util.Reusable;

public class SignUpPage {
	
	static WebDriver driver;
	GetExcelData excelData;
	
	Reusable util=new Reusable(driver);	
	static org.apache.log4j.Logger log = Logger.getLogger(SignUpPage.class.getName());
	
	public SignUpPage(WebDriver driver){
		SignUpPage.driver=driver;
	}
	
	public void signUp(String name,String email,String username,String password,String gender,String age,String phone) 
	{
		
		String data[][];
		
			data = excelData.getData(Constants.signUpExcelPath, "SignUp");
		
		
		for(int i=0;i<data.length;i++)
        {
			
			switch(data[i][Constants.keyword_col])
	    	{
	    	
	    	case "navigateTo":
	    		util.navigateTo(data[i][Constants.parameter_col]);
	    		break;
	    		
	    
	    		
	    	case "enterName":
	    		util.enterText(data[i][Constants.pathType_col], data[i][Constants.path_col], name);
	    		break;
	    	
	    	case "enterUsername":
	    		util.enterText(data[i][Constants.pathType_col], data[i][Constants.path_col], username);
	            break;
	    		
	    	case "enterEmail":
	    		util.enterText(data[i][Constants.pathType_col],data[i][Constants.path_col], email);
	    		break;

			    		
	    	case "enterPassword":
	    		util.enterText(data[i][Constants.pathType_col],data[i][Constants.path_col], password);
	    	    break;
	    		
	    	case "selectGender":
	    		util.selectFromDropDownBox(data[i][Constants.pathType_col],data[i][Constants.path_col] ,gender);
	    	    break;
	    		
	    	case "enterAge":
	    		util.enterText(data[i][Constants.pathType_col], data[i][Constants.path_col], age);
	    		break;
	    		
	    	case "enterPhone":
	    		util.enterText(data[i][Constants.pathType_col], data[i][Constants.path_col], phone);
	    		break;
	    	
	    	case "clickSubmit":
	    		util.click(data[i][Constants.pathType_col], data[i][Constants.path_col]);
	    	    break;
	    		
	    	case "verify":
	    	util.verify(data[i][Constants.pathType_col],data[i][Constants.path_col], data[i][Constants.parameter_col]);
	    	break;
	        default:log.debug("Invalid Keyword");
	    	
	    	}
        }
		
	}

}
