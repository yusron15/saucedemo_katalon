import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def testData = findTestData('Data Files/login_saucedemo')

def username = testData.getObjectValue('Username', 1)

def password = testData.getObjectValue('Password', 1)

WebUI.comment(username)

WebUI.comment(password)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

//Login
CustomKeywords.'login.Login'(username, password)

//Verify item 'Sauce Labs Backpack is exist'
productTitle = WebUI.getText(findTestObject('Object Repository/saucedemo/Product Page/div_Sauce Labs Backpack'))

WebUI.verifyMatch(productTitle, 'Sauce Labs Backpack', false)

//Add to Cart
WebUI.click(findTestObject('Object Repository/saucedemo/Product Page/button_Add to cart'))

//Go to Cart Page
WebUI.click(findTestObject('Object Repository/saucedemo/Product Page/a_Swag Labs_shopping_cart_link'))

//Verify item 'Sauce Labs Backpack is exist in Cart Page'
WebUI.verifyElementPresent(findTestObject('Object Repository/saucedemo/Cart Page/div_Sauce Labs Backpack'), 5, FailureHandling.STOP_ON_FAILURE)

//Hit checkout
WebUI.click(findTestObject('Object Repository/saucedemo/Cart Page/button_Checkout'))

//Fill Checkout Information
CustomKeywords.'Fill_Checkout_Information.Checkout_Information'('Rudi', 'Tabuti', '1010')

//Verify we're on Checkout Overview Page
WebUI.verifyElementPresent(findTestObject('Object Repository/saucedemo/Checkout Overview Page/span_Checkout Overview'), 5, FailureHandling.STOP_ON_FAILURE)

//Verify item 'Sauce Labs Backpack is exist in Checkout Overview Page'
productCheckout = WebUI.getText(findTestObject('Object Repository/saucedemo/Checkout Overview Page/div_Sauce Labs Backpack'))

WebUI.verifyMatch(productCheckout, 'Sauce Labs Backpack', false)

//Hit Finish
WebUI.click(findTestObject('Object Repository/saucedemo/Checkout Overview Page/button_Finish'))

//Verify we're on Checkout Complete Page
WebUI.verifyElementPresent(findTestObject('Object Repository/saucedemo/Checkout Complete Page/h2_Thank you for your order'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

