package com.qapitolqa.utility;

import org.testng.annotations.DataProvider;

public class DataProviderBSA {

    @DataProvider(name = "dataProvider")
    public static Object[][] getData(){
        return new Object[][]{
                {"surabhi601@gmail.com","surabhi123"}
        };
    }
}
