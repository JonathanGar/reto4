package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.choucairtesting.com:18000/MaxTimeCHC/Login.aspx")
public class MaxTimeLoginPage extends PageObject {
	
	public static final Target INPUT_USER_NAME = Target.the("User name input").located(
			By.xpath("//*[@id=\"Logon_v0_MainLayoutEdit_xaf_l30_xaf_dviUserName_Edit_I\"]")); 
	public static final Target INPUT_PASSWORD = Target.the("Password input").located(
			By.xpath("//*[@id=\"Logon_v0_MainLayoutEdit_xaf_l35_xaf_dviPassword_Edit_I\"]"));
	public static final Target BTN_CONNECT = Target.the("Connect button").located(
			By.xpath("//*[@id=\"Logon_PopupActions_Menu_DXI0_T\"]/a")); 
	
}
