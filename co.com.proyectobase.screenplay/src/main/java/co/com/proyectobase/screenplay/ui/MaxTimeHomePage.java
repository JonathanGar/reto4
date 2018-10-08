package co.com.proyectobase.screenplay.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MaxTimeHomePage extends PageObject {
	
	public static final Target LU_TIME_REPORT = Target.the("Time rport link LU").located(
			By.xpath("//*[@id=\"Vertical_NC_NB_GC0\"]"));		
	public static final Target IMG_ANALYSTS_LIST = Target.the("Analysts list icon").located(
			By.xpath("//*[@id=\"Vertical_v1_LE_v2_col1\"]/table/tbody/tr/td[2]/img"));	
	public static final Target DAY_TO_CLOSE = Target.the("Day to close").located(
			By.xpath("//*[@id=\"Vertical_v1_LE_v2_cell0_0_xaf_Fecha\"]/tbody/tr/td"));
	
	//*[@id="Vertical_v1_LE_v2_cell0_0_xaf_Fecha\"]/tbody/tr/td
	//*[@id="Vertical_v1_LE_v2_cell1_0_xaf_Fecha"]/tbody/tr/td
	//*[@id="Vertical_v1_LE_v2_cell2_0_xaf_Fecha"]/tbody/tr/td
	
	public static Target get_analyst_username_opt(String username) {
		return Target.the("Analysts list icon").located(
				By.xpath("//table[@id='Vertical_v1_LE_v2_HFListBox_LBT']/tbody/tr/td[text()='"+ username +"']"));
	}	
}

//*[@id="Vertical_v1_LE_v2_DXMainTable"]/tbody/tr/td//span[text()="03/10/18"]
//*[@id="Vertical_v1_LE_v2_cell0_0_xaf_Fecha_View"]  span
//*[@id="Vertical_v1_LE_v2_DXDataRow0"]  fila completa
