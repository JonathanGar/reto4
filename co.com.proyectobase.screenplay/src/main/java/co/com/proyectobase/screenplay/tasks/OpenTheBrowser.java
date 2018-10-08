package co.com.proyectobase.screenplay.tasks;

import java.util.List;

import co.com.proyectobase.screenplay.model.MaxTimeLoginModel;
import co.com.proyectobase.screenplay.ui.MaxTimeLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTheBrowser implements Task {
	
	private MaxTimeLoginPage maxTimeLoginPage;
	private List<MaxTimeLoginModel> maxTimeLoginModel;
	
	public OpenTheBrowser(List<MaxTimeLoginModel> maxTimeLoginModel) {
		super();
		this.maxTimeLoginModel = maxTimeLoginModel;
	}	
	
	@Override
	public <T extends Actor> void performAs(T actor) {		
		MaxTimeLoginModel maxTimeLogin = this.maxTimeLoginModel.get(0);		
		
		actor.attemptsTo(Open.browserOn(maxTimeLoginPage));		
		actor.attemptsTo(Enter.theValue(maxTimeLogin.getUser_name()).into(
				MaxTimeLoginPage.INPUT_USER_NAME));
		actor.attemptsTo(Enter.theValue(maxTimeLogin.getPassword()).into(
				MaxTimeLoginPage.INPUT_PASSWORD));
		actor.attemptsTo(Click.on(MaxTimeLoginPage.BTN_CONNECT));		
	}

	public static OpenTheBrowser onTheMaxTimeLoginPage(List<MaxTimeLoginModel> maxTimeLoginModel) {		
		return Tasks.instrumented(OpenTheBrowser.class, maxTimeLoginModel);
	}
}
