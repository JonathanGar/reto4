package co.com.proyectobase.screenplay.tasks;

import java.util.List;

import org.openqa.selenium.Keys;

import co.com.proyectobase.screenplay.model.MaxTimeReportModel;
import co.com.proyectobase.screenplay.ui.MaxTimeDayReport;
import co.com.proyectobase.screenplay.ui.MaxTimeHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


public class RegisterOnMaxTime implements Task {
	
	private List<MaxTimeReportModel> maxTimeReportData;
	
	public RegisterOnMaxTime(List<MaxTimeReportModel> maxTimeReportModel) {
		super();
		this.maxTimeReportData = maxTimeReportModel;
	}
	
	public static RegisterOnMaxTime aTask(List<MaxTimeReportModel> maxTimeReportModel) {
		return Tasks.instrumented(RegisterOnMaxTime.class, maxTimeReportModel);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// actor.wait(5000);
		// actor.attemptsTo(WaitUntil.the(MaxTimeHomePage.LU_TIME_REPORT, isEnabled()));						
		actor.attemptsTo(Wait.inSeconds(23));
		actor.attemptsTo(Click.on(MaxTimeHomePage.LU_TIME_REPORT));
		actor.attemptsTo(Click.on(MaxTimeHomePage.IMG_ANALYSTS_LIST));
		actor.attemptsTo(Click.on(MaxTimeHomePage.get_analyst_username_opt(this.maxTimeReportData.get(0).getReport_user())));
		
		actor.attemptsTo(Wait.inSeconds(4));	
		actor.attemptsTo(Click.on(MaxTimeHomePage.DAY_TO_CLOSE));
		
		do_report_half_day(actor, this.maxTimeReportData.get(0));
		actor.attemptsTo(Wait.inSeconds(2));
		do_report_half_day(actor, this.maxTimeReportData.get(1));
		
		actor.attemptsTo(Wait.inSeconds(6));
		actor.attemptsTo(Click.on(MaxTimeDayReport.LINK_CLOSE_DAY));
		actor.attemptsTo(Click.on(MaxTimeDayReport.DIV_CLOSE_DAY_IFrame));
	}
			
	private void do_report_half_day(Actor actor, MaxTimeReportModel maxTimeReportData) {
		
		actor.attemptsTo(Wait.inSeconds(2));
		actor.attemptsTo(
				WaitUntil.the(MaxTimeDayReport.LINK_NEW, isEnabled()),
				Click.on(MaxTimeDayReport.LINK_NEW)
		);
		
		actor.attemptsTo(Wait.inSeconds(6));
		actor.attemptsTo(				
				WaitUntil.the(MaxTimeDayReport.DIV_SEARCH_PROJECT_BTN, isEnabled()),
				Click.on(MaxTimeDayReport.DIV_SEARCH_PROJECT_BTN)
		);				
		actor.attemptsTo(
				WaitUntil.the(MaxTimeDayReport.INPUT_SEARCH_IFRAME, isEnabled()),
				Enter.theValue(maxTimeReportData.getClient_code())
				.into(MaxTimeDayReport.INPUT_SEARCH_IFRAME).thenHit(Keys.ENTER)				
		);
		actor.attemptsTo(Wait.inSeconds(4));
		actor.attemptsTo(
				WaitUntil.the(MaxTimeDayReport.get_project_cell_by_client_code(maxTimeReportData.getClient_code()), isEnabled()),
				Click.on(MaxTimeDayReport.get_project_cell_by_client_code(maxTimeReportData.getClient_code())
		));
		
		actor.attemptsTo(Wait.inSeconds(4));
		actor.attemptsTo(
				WaitUntil.the(MaxTimeDayReport.HOUR_TYPE_ARROW, isEnabled()),
				Click.on(MaxTimeDayReport.HOUR_TYPE_ARROW),
				Click.on(MaxTimeDayReport.get_option_hour_type(maxTimeReportData.getHour_type()))
		);
		
		actor.attemptsTo(Wait.inSeconds(6));
		actor.attemptsTo(Click.on(MaxTimeDayReport.DIV_SEARCH_SERVICE));
		actor.attemptsTo(
				Enter.theValue(maxTimeReportData.getService())
				.into(MaxTimeDayReport.INPUT_SEARCH_IFRAME).thenHit(Keys.ENTER)				
		);
		actor.attemptsTo(Click.on(
				MaxTimeDayReport.get_service_cell_by_name(maxTimeReportData.getService())
		));
		
		actor.attemptsTo(Wait.inSeconds(5));	
		actor.attemptsTo(Click.on(MaxTimeDayReport.SEARCH_ACTIVITY_ARROW));
		actor.attemptsTo(
				WaitUntil.the(MaxTimeDayReport.INPUT_SEARCH_ACTIVITY, isEnabled()),
				Enter.theValue(maxTimeReportData.getActivity())
				.into(MaxTimeDayReport.INPUT_SEARCH_ACTIVITY)
		);
		actor.attemptsTo(Click.on(MaxTimeDayReport.get_activity_list_item(maxTimeReportData.getActivity())));
		
		actor.attemptsTo(Enter.theValue(maxTimeReportData.getExecuted_hours()).into(
				MaxTimeDayReport.INPUT_EXECUTED_HOURS
		));
		actor.attemptsTo(Enter.theValue(maxTimeReportData.getComment()).into(
				MaxTimeDayReport.INPUT_COMMENT
		));		
		actor.attemptsTo(Click.on(MaxTimeDayReport.LINK_SAVE_CLOSE));
	}
}
