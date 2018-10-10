package co.com.proyectobase.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.targets.Target;

public class MaxTimeDayReport extends PageObject {
	
	public static final IFrame iframe_projects = IFrame.withPath(By.className("dxpc-iFrame"));	
	public static final Target LINK_NEW = Target.the("New link").located(			
			By.xpath("(//li[@class=\"dxm-item dxm-dropDownMode\"]/div[@class=\"dxm-content dxm-hasText\"]/a[@class=\"dx dxalink\"])[1]"));
	public static final Target DIV_SEARCH_PROJECT_BTN = Target.the("Search project DIV").located(
			By.xpath("(//div[@class=\"dxb\"])[1]"));	
	public static final Target INPUT_SEARCH_IFRAME = Target.the("Search project input").inIFrame(
			iframe_projects).located(By.xpath("//*[@id=\"Dialog_SearchActionContainer_Menu_ITCNT0_xaf_a0_Ed_I\"]"));
	public static final Target HOUR_TYPE_ARROW = Target.the("Hour type table").located(
			By.xpath("(//table[@class=\"dxbebt\"])[1]"));
	public static final Target DIV_SEARCH_SERVICE = Target.the("Search service DIV").located(
			By.xpath("(//div[@class=\"dxb\"])[4]"));
	public static final Target SEARCH_ACTIVITY_ARROW = Target.the("Search activity table").located(
			By.xpath("(//table[@class=\"dxbebt\"])[2]"));
	public static final Target INPUT_SEARCH_ACTIVITY = Target.the("Search activity input").located(
			By.xpath("((//table[@class=\"Item\"])[6]//input)[2]"));	
	public static final Target INPUT_EXECUTED_HOURS = Target.the("Executed hours input").located(
			By.xpath("(//table[@class=\"Item\"])[8]//table//table/tbody/tr/td/input"));
	public static final Target INPUT_COMMENT = Target.the("Comment input").located(
			By.xpath("(//table[@class=\"Item\"])[12]//table//table/tbody/tr/td/input"));
	public static final Target LINK_SAVE_CLOSE = Target.the("Save and close link").located(
			By.xpath("//*[@id=\"Vertical_EditModeActions2_Menu_DXI1_T\"]/a"));
	public static final Target LINK_CLOSE_DAY = Target.the("Close day link").located(
			By.xpath("//*[@id=\"Vertical_TB_Menu_DXI1_T\"]/a"));
	public static final Target DIV_CLOSE_DAY_IFrame = Target.the("Close day in iFrame div").inIFrame(
			iframe_projects).located(By.xpath("//*[@id=\"Dialog_actionContainerHolder_Menu_DXI0_T\"]"));	
	
	public static Target get_project_cell_by_client_code(String client_code) {
		return Target.the("project cell of the search").inIFrame(iframe_projects).located(
				By.xpath("//*[@class=\"dxgvTable_Office2010Blue\"]//span[text()='"+ client_code +"']"));
	}
	
	public static Target get_service_cell_by_name(String service_name) {
		return Target.the("project cell of the search").inIFrame(iframe_projects).located(
				By.xpath("//*[@class=\"dxgvTable_Office2010Blue\"]//span[text()='"+ service_name +"']"));
	}
			
	public static Target get_option_hour_type(String hour_type) {
		return Target.the("project cell of the search").located(By.xpath(
				"//*[@class=\"dxeListBox_Office2010Blue\"]//table//td[text()='"+ hour_type +"']"));
	}
	
	public static Target get_activity_list_item(String activity) { 
			return Target.the("Activity list item").located(
			By.xpath("//*[@class=\"dxeListBox_Office2010Blue\"]//table//td[@dxtext=\""+ activity +"\"]"));
	}
}
