package com.nopCommerce.dataProvider;

import org.testng.annotations.DataProvider;

import com.nopCommerce.utility.NewExcelLibrary;

public class DataProviders 
{
    
	
	NewExcelLibrary obj = new NewExcelLibrary();
    
    
   
	@DataProvider(name="credentials")
	public Object[][] getEmail()
    {
    	int rows = obj.getRowCount("Data");
    	int columns = obj.getColumnCount("Data");
    	int actRows = rows-1;
    	
    	Object[][] data = new Object[actRows][columns];
    	
    	for (int i=0; i<actRows;i++)
    	{
    		for(int j=0; j<columns; j++)
    		{
    		    data[i][j] = obj.getCellData("Data", j, i+2);
    		}
    	}
    	return data;
    }
   
	
	@DataProvider(name="product")
	public Object[][] getProduct() 
	{
		 int rows = obj.getRowCount("ProductDeatils");
		 int columns = obj.getColumnCount("ProductDeatils");
		 int actRows = rows-1;
		 
		 Object[][] data = new Object[actRows][columns];
		 
		 for(int i=0; i<actRows;i++)
		 {
			 for(int j=0;j<columns;j++)
			 {
				data[i][j] = obj.getCellData("ProductDeatils", j, i+2);
			 }
		 }
		 
		 return data;
	}
	
	
	
	
	
	
	
	
	
	
	
}
