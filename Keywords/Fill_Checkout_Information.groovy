import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Fill_Checkout_Information {
	@Keyword
	def Checkout_Information(String firstname, String lastname, String postal_code) {
		WebUI.setText(findTestObject('Object Repository/saucedemo/Checkout Information Page/input_Checkout Your Information_firstName'), firstname)

		WebUI.setText(findTestObject('Object Repository/saucedemo/Checkout Information Page/input_Checkout Your Information_lastName'), lastname)

		WebUI.setText(findTestObject('Object Repository/saucedemo/Checkout Information Page/input_Checkout Your Information_postalCode'), postal_code)
	
		WebUI.click(findTestObject('Object Repository/saucedemo/Checkout Information Page/input_Cancel_continue'))
	}
}


