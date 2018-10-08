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
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.matchers.statematchers.IsVisibleMatcher;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilTargetIsReady;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class RegisterOnMaxTime implements Task {
	
	private MaxTimeReportModel maxTimeReportData;
	
	public RegisterOnMaxTime(List<MaxTimeReportModel> maxTimeReportModel) {
		super();
		this.maxTimeReportData = maxTimeReportModel.get(0);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		// actor.attemptsTo(WaitUntil.the(MaxTimeHomePage.LU_TIME_REPORT, isEnabled()));
		try {
			Thread.sleep(20000);		
			actor.attemptsTo(Click.on(MaxTimeHomePage.LU_TIME_REPORT));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		
		actor.attemptsTo(Click.on(MaxTimeHomePage.IMG_ANALYSTS_LIST));
		actor.attemptsTo(Click.on(MaxTimeHomePage.get_analyst_username_opt(maxTimeReportData.getReport_user())));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		actor.attemptsTo(
				//WaitUntil.the(MaxTimeHomePage.DAY_TO_CLOSE, isVisible()), 
				Click.on(MaxTimeHomePage.DAY_TO_CLOSE)
		);
		
		actor.attemptsTo(Click.on(MaxTimeDayReport.LINK_NEW));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actor.attemptsTo(Click.on(MaxTimeDayReport.DIV_SEARCH_PROJECT));
				
		actor.attemptsTo(
				Enter.theValue(this.maxTimeReportData.getClient_code())
				.into(MaxTimeDayReport.INPUT_SEARCH_PROJECT).thenHit(Keys.ENTER)				
		);
		actor.attemptsTo(Click.on(
				MaxTimeDayReport.get_project_cell_by_client_code(this.maxTimeReportData.getClient_code())
		));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actor.attemptsTo(
				WaitUntil.the(MaxTimeDayReport.INPUT_HOUR_TYPE, isVisible()),
				Click.on(MaxTimeDayReport.INPUT_HOUR_TYPE),
				Click.on(MaxTimeDayReport.get_option_hour_type(this.maxTimeReportData.getHour_type()))
		);
	}
	
	public static RegisterOnMaxTime aTask(List<MaxTimeReportModel> maxTimeReportModel) {
		return Tasks.instrumented(RegisterOnMaxTime.class, maxTimeReportModel);
	}
}
