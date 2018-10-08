package co.com.proyectobase.screenplay.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import co.com.proyectobase.screenplay.model.MaxTimeLoginModel;
import co.com.proyectobase.screenplay.model.MaxTimeReportModel;
import co.com.proyectobase.screenplay.tasks.OpenTheBrowser;
import co.com.proyectobase.screenplay.tasks.RegisterOnMaxTime;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class ReportActivitiesForADay {
	
	@Managed(driver="Chrome")	
	private WebDriver hisBrowser;
	
	private Actor jonathan = Actor.named("Jonathan");
	
	@Before
	public void initialConfiguration() {
		jonathan.can(BrowseTheWeb.with(hisBrowser));
	}
	
	@Given("^Jonathan want to report his activities on MaxTime$")
	public void jonathanWantToReportHisActivitiesOnMaxTime(List<MaxTimeLoginModel> maxTimeLoginModel)  {
		jonathan.wasAbleTo(OpenTheBrowser.onTheMaxTimeLoginPage(maxTimeLoginModel));
	}

	@When("^He register a task$")
	public void heRegisterATask(List<MaxTimeReportModel> maxTimeReportModel) {
		jonathan.attemptsTo(RegisterOnMaxTime.aTask(maxTimeReportModel));
	}

	@Then("^He should see the current day closed$")
	public void heShouldSeeTheCurrentDayClosed() {
	}

}
