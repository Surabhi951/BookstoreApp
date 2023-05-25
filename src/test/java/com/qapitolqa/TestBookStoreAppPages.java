package com.qapitolqa;

import com.qapitolqa.baseclass.BaseClass;
import com.qapitolqa.pages.*;
import com.qapitolqa.utility.DataProviderBSA;
import org.testng.annotations.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TestBookStoreAppPages extends BaseClass {

    RegistrationPage registrationPage;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;

    AddressPage addressPage;
    PaymentPage paymentPage;

    ShippingPage shippingPage;

    @BeforeMethod
    public void initialization() throws FileNotFoundException {
        setUP();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        addressPage = new AddressPage(driver);
        paymentPage = new PaymentPage(driver);
        shippingPage = new ShippingPage(driver);
    }

    @Test(priority = 0)
    public void placeOrderOnBookStoreApp() throws InterruptedException, AWTException, IOException {
       registrationPage.registrationOnBookStoreApp();
        takeScreenShot();
        homePage.selectBook();
        takeScreenShot();
        cartPage.addProductToCartAndCheckout();
        takeScreenShot();
        addressPage.enterAddressDetails();
        takeScreenShot();
        addressPage.selectAddress();
        takeScreenShot();
        paymentPage.enterPaymentDetails();
        takeScreenShot();
        paymentPage.selectPaymentCard();
        takeScreenShot();
        shippingPage.shippingOrder();
        takeScreenShot();
        shippingPage.verifyShippingOrder();
        takeScreenShot();
        homePage.logoutFromBookStoreApp();
        takeScreenShot();
    }

    @Test(priority = 1, dataProvider = "dataProvider", dataProviderClass = DataProviderBSA.class)
    public void verifySelectBookSignInAndPlaceOrder(String userName, String password) throws InterruptedException, AWTException {
        homePage.selectBook();
        cartPage.addProductIntoCart();
        loginPage.loginIntoTheBookStoreApp(userName, password);
        cartPage.proceedToCheckOut();
        addressPage.selectAddress();
        paymentPage.selectPaymentCard();
        shippingPage.shippingOrder();
        shippingPage.verifyShippingOrder();
        homePage.logoutFromBookStoreApp();
    }

    @Test(priority = 2, dataProvider = "dataProvider", dataProviderClass = DataProviderBSA.class)
    public void verifySignInAndSelectBookAndPlaceOrder(String userName, String password) throws InterruptedException, AWTException {
        loginPage.loginIntoTheBookStoreApp(userName, password);
        homePage.selectBook();
        cartPage.addProductToCartAndCheckout();
        addressPage.selectAddress();
        paymentPage.selectPaymentCard();
        shippingPage.shippingOrder();
        shippingPage.verifyShippingOrder();
        homePage.logoutFromBookStoreApp();
    }

    @Test(priority = 3)
    public void signInAndPlaceOrder() throws InterruptedException {
        loginPage.loginWithNewUser();
        homePage.selectNewBook();
        cartPage.addProductToCartAndCheckout();
        addressPage.enterAddressDetails();
        paymentPage.selectPaymentCard();
        shippingPage.shippingOrder();
        shippingPage.verifyShippingOrder();
        homePage.logoutFromBookStoreApp();
    }

    @Test(priority = 4)
    public void registerAsANewUserAndPlaceOrder() throws InterruptedException, AWTException {
        registrationPage.registerWithNewUser();
        homePage.selectBook();
        cartPage.addProductToCartAndCheckout();
        addressPage.enterAddressDetails();
        addressPage.selectAddress();
        paymentPage.enterPaymentDetails();
        paymentPage.selectPaymentCard();
        shippingPage.shippingOrder();
        shippingPage.verifyShippingOrder();
        homePage.logoutFromBookStoreApp();
    }

    @Test(priority = 5, dataProvider = "dataProvider", dataProviderClass = DataProviderBSA.class)
    public void addNewAddressToAddressPageAndPlaceOrder(String userName, String password) throws InterruptedException, AWTException {
        loginPage.loginIntoTheBookStoreApp(userName, password);
        homePage.selectBook();
        cartPage.addProductToCartAndCheckout();
        addressPage.addNewAddressTOAddressPage();
        paymentPage.enterPaymentDetails();
        paymentPage.selectPaymentCard();
        shippingPage.shippingOrder();
        shippingPage.verifyShippingOrder();
        homePage.logoutFromBookStoreApp();
    }

    @Test(priority = 6, dataProvider = "dataProvider", dataProviderClass = DataProviderBSA.class)
    public void deleteAddressAndPlaceOrder(String userName, String password) throws InterruptedException, AWTException {
        loginPage.loginIntoTheBookStoreApp(userName, password);
        homePage.selectBook();
        cartPage.addProductToCartAndCheckout();
        addressPage.deleteAddressDetails();
        addressPage.enterAddressDetails();
        addressPage.selectAddress();
        paymentPage.selectPaymentCard();
        shippingPage.shippingOrder();
        shippingPage.verifyShippingOrder();
        homePage.logoutFromBookStoreApp();
    }

    @Test(priority = 7, dataProvider = "dataProvider", dataProviderClass = DataProviderBSA.class)
    public void deleteAddressAndAddNewAddressAndPlaceOrder(String userName, String password) throws InterruptedException, AWTException {
        loginPage.loginIntoTheBookStoreApp(userName, password);
        homePage.selectBook();
        cartPage.addProductToCartAndCheckout();
        addressPage.deleteAddressDetails();
        addressPage.addNewAddressTOAddressPage();
        paymentPage.selectPaymentCard();
        shippingPage.shippingOrder();
        shippingPage.verifyShippingOrder();
        homePage.logoutFromBookStoreApp();
    }

    @Test(priority = 8, dataProvider = "dataProvider", dataProviderClass = DataProviderBSA.class)
    public void signInSelectMultipleBooksAndPlaceOrder(String userName, String password) throws InterruptedException {
        loginPage.loginIntoTheBookStoreApp(userName, password);
        homePage.AddMultipleBooks();
        cartPage.proceedToCheckOut();
        addressPage.selectAddress();
        paymentPage.selectPaymentCard();
        shippingPage.shippingOrder();
        shippingPage.verifyShippingOrder();
        homePage.logoutFromBookStoreApp();
    }

    @Test(priority = 9, dataProvider = "dataProvider", dataProviderClass = DataProviderBSA.class)
    public void automationOnLogout(String userName, String password) throws InterruptedException, AWTException {
        loginPage.loginIntoTheBookStoreApp(userName, password);
        homePage.logoutFromBookStoreApp();
    }


    @Test(priority = 10, dataProvider = "dataProvider", dataProviderClass = DataProviderBSA.class)
    public void signInAndUpdateProfile(String userName, String password) throws InterruptedException {
        loginPage.loginIntoTheBookStoreApp(userName, password);
        homePage.updateProfile();
    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
