package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.targets.Target;

public class MaxTimeDayReport extends PageObject {
	
	public static final IFrame iframe_projects = IFrame.withPath(
			By.className("dxpc-iFrame")
			//By.xpath("//*[@id=\"PopupWindowCallbackPanel_PopupWindow8639481_CIF-1\"]")
	);	
	public static final Target LINK_NEW = Target.the("New link").located(
			By.xpath("//*[@id=\"Vertical_v3_MainLayoutView_xaf_l103_xaf_dviReporteDetallado_ToolBar_Menu_DXI0_T\"]/a"));
	public static final Target DIV_SEARCH_PROJECT = Target.the("Search project DIV").located(
			By.xpath("//*[@id=\"Vertical_v6_MainLayoutEdit_xaf_l128_xaf_dviProyecto_Edit_Find_CD\"]"));	
	public static final Target INPUT_SEARCH_PROJECT = Target.the("Search project input").inIFrame(
			iframe_projects).located(By.xpath("//*[@id=\"Dialog_SearchActionContainer_Menu_ITCNT0_xaf_a0_Ed_I\"]"));
	public static final Target INPUT_HOUR_TYPE = Target.the("Hour type input").located(
			By.xpath("//*[@id=\"Vertical_v6_MainLayoutEdit_xaf_l148_xaf_dviTipoHora_Edit_DD_I\"]"));	
		
	
	public static Target get_project_cell_by_client_code(String client_code) {
		return Target.the("project cell of the search").inIFrame(iframe_projects).located(
				By.xpath("//*[@id=\"Dialog_v7_LE_v8_cell0_4_xaf_CodigoCliente\"]//span[text()='"+ client_code +"']"));
	}
	
	public static Target get_option_hour_type(String hour_type) {
		return Target.the("project cell of the search").located(By.xpath(
				"//*[@id=\"Vertical_v6_MainLayoutEdit_xaf_l148_xaf_dviTipoHora_Edit_DD_DDD_L_LBT\"]//td[text()='"+ hour_type +"']"
		));
	}
}
