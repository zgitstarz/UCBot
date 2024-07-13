
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

	public static String token = "";
	
	public static void main(String[] args) throws InterruptedException, TelegramApiException {
		
		TelegramBotsLongPollingApplication bot = new TelegramBotsLongPollingApplication();
		

		bot.registerBot(token, new UCBot(token));

		Thread.currentThread().join();


		
		
		

	}

}
