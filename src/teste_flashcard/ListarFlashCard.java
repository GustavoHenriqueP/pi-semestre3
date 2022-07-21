package teste_flashcard;

import java.util.List;

import control.FlashCardDAO;
import model.FlashCard;


public class ListarFlashCard {

	public void listarFL() {

		FlashCardDAO dao = new FlashCardDAO();
		
		List<FlashCard> lista = dao.get("select * from TBFLASHCARD");
		for(FlashCard fl: lista)
		{
			System.out.println(fl);
		}
	}
}