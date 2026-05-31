package com.vishal.projects.cms.testcases;

import com.vishal.common.BaseTest;
import com.vishal.constants.FrameworkConstants;
import com.vishal.dataprovider.DataProviderAddProduct;
import com.vishal.helpers.ExcelHelpers;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test CMS")
@Feature("Add Product Test")
public class AddProductTest extends BaseTest {

    @Test(dataProvider = "data_provider_add_product", dataProviderClass = DataProviderAddProduct.class)
    public void TC_AddNewProductAdmin(Hashtable<String, String> data) {
        ExcelHelpers excelLogin = new ExcelHelpers();
        ExcelHelpers excelAddProduct = new ExcelHelpers();
        excelLogin.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
        excelAddProduct.setExcelFile(FrameworkConstants.EXCEL_CMS_DATA, "AddProduct");
        getLoginPageCMS().loginSuccessAdminPage(excelLogin.getCellData(5, "email"), excelLogin.getCellData(5, "password"));
        getAddProductPage().addProduct(data.get("productName"), data.get("category"), data.get("unit"), data.get("weight"), data.get("tags"), data.get("unitPrice"), data.get("discountDate"), data.get("quantity"), data.get("description"), data.get("discount"), data.get("image"));
        getAddProductPage().verifyNewProduct(data.get("category"), data.get("unit"), Double.valueOf(data.get("unitPrice")), data.get("description"));

    }
}


