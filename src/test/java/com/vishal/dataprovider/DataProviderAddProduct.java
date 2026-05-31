package com.vishal.dataprovider;

import com.vishal.constants.FrameworkConstants;
import com.vishal.helpers.ExcelHelpers;
import com.vishal.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderAddProduct {
    @DataProvider(name = "data_provider_add_product")
    public Object[][] dataAddProduct() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(SystemHelpers.getCurrentDir() + FrameworkConstants.EXCEL_CMS_DATA, "AddProduct", 2, 2);
        return data;
    }
}
