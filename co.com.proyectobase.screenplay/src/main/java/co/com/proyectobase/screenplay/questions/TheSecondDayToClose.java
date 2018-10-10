package co.com.proyectobase.screenplay.questions;

import co.com.proyectobase.screenplay.ui.MaxTimeHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;

public class TheSecondDayToClose implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		return Presence.of(MaxTimeHomePage.SECOND_DAY_TO_CLOSE).viewedBy(actor).asBoolean();
	}
	
	public static TheSecondDayToClose isPresent() {
		return new TheSecondDayToClose();
	}
}
