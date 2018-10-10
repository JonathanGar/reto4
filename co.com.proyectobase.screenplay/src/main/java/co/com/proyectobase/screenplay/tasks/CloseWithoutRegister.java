package co.com.proyectobase.screenplay.tasks;

import java.util.List;

import co.com.proyectobase.screenplay.model.MaxTimeReportModel;
import co.com.proyectobase.screenplay.ui.MaxTimeDayReport;
import co.com.proyectobase.screenplay.ui.MaxTimeHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class CloseWithoutRegister implements Task {
	
	private List<MaxTimeReportModel> maxTimeReportData;
	
	public CloseWithoutRegister(List<MaxTimeReportModel> maxTimeReportModel) {
		super();
		this.maxTimeReportData = maxTimeReportModel;
	}
	
	public static CloseWithoutRegister aDay(List<MaxTimeReportModel> maxTimeReportModel) {
		return Tasks.instrumented(CloseWithoutRegister.class, maxTimeReportModel);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Wait.inSeconds(20));
		actor.attemptsTo(Click.on(MaxTimeHomePage.LU_TIME_REPORT));
		actor.attemptsTo(Click.on(MaxTimeHomePage.IMG_ANALYSTS_LIST));
		actor.attemptsTo(Click.on(MaxTimeHomePage.get_analyst_username_opt(this.maxTimeReportData.get(0).getReport_user())));		
		actor.attemptsTo(Wait.inSeconds(4));	
		actor.attemptsTo(Click.on(MaxTimeHomePage.DAY_TO_CLOSE));
		actor.attemptsTo(Wait.inSeconds(3));
		actor.attemptsTo(Click.on(MaxTimeDayReport.LINK_CLOSE_DAY));
		actor.attemptsTo(Click.on(MaxTimeDayReport.DIV_CLOSE_DAY_IFrame));
	}
}
