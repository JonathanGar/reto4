package co.com.proyectobase.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Wait implements Task {
	
	private long seconds;
	
	public Wait(long seconds) {
		this.seconds = seconds;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			Thread.sleep(this.seconds * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}		
	}
	
	public static Wait inSeconds(long seconds) {
		return Tasks.instrumented(Wait.class, seconds);
	}

}
