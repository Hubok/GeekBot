package bot.commands;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.io.Files;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import bot.GeekBot;

public class CmdEnderHistory extends Command {
	private static Logger log = LogManager.getLogger(CmdChironHistory.class);

	public CmdEnderHistory() {
		name = "ender-history";
		hidden = true;
	}

	@Override
	protected void execute(CommandEvent event) {
		log.info("ender activated");
		File file;
		String url = GeekBot.getENDER_URL() + "/printer?history=true&apikey=" + GeekBot.getENDER_KEY();
		try {
			 Files.createTempDir();
			file = File.createTempFile("EnderHistory", ".json");
			FileUtils.copyURLToFile(new URL(url), file);
			event.getChannel().sendFile(file).submit();
			file.delete();
		} catch (Exception e) {
			log.catching(e);
			event.getChannel().sendMessage("got IO Exception: " + e.getStackTrace()).submit();
		}
	}

}
