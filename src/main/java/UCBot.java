
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.vdurmont.emoji.EmojiParser;

public class UCBot implements LongPollingSingleThreadUpdateConsumer{

	private final TelegramClient client;
	
	UCBot(String token)
	{
		client = new OkHttpTelegramClient(token);
	}
	
	@Override
	public void consume(Update update)
	{
		if(update.hasMessage() && update.getMessage().hasText())
		{
			
			long ChatId = update.getMessage().getChatId();
			long UserId = update.getMessage().getFrom().getId();
			
			String response = EmojiParser.parseToUnicode("🆔User ID: " + UserId + "\n🆔Chat Id: " + ChatId);
			
			SendMessage send = SendMessage.builder()
								.chatId(ChatId)
								.text(response)
								.build();
			
			try {
				client.execute(send);
			} catch (TelegramApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
	}
	
	
}
