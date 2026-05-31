package com.vishal.projects.cms.testcases;

import com.vishal.common.BaseTest;
import com.vishal.constants.FrameworkConstants;
import com.vishal.helpers.ExcelHelpers;
import com.vishal.helpers.PropertiesHelpers;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductInfoTest extends BaseTest {

    @Test
    public void TC_GetProductInfo() {
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_PRODUCTS_USER, "ProductInfo");
        ExcelHelpers excel2 = new ExcelHelpers();
        excel2.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        getLoginPageCMS().loginSuccessWithCustomerAccount(excel2.getCellData(4, "email"), excel2.getCellData(4, "password"));
        ArrayList productInfo = getProductInfoPage().productInfo(PropertiesHelpers.getValue("product_P01"));
        int lastRow = excel.getRows();
        int newRow = lastRow + 1;
        excel.setCellData(String.valueOf(newRow), newRow, 0);
        for (int i = 0; i < productInfo.size(); i++) {
            if (String.valueOf(newRow) != null) {
                excel.setCellData((String) productInfo.get(i), newRow, i + 1);
            }
        }
    }
}
