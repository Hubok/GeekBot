package bot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class CmdInvite extends Command {

	public CmdInvite() {
		name = "invite-bot";
		help = "An invite link to invite the bot to you server";
		
	}

	@Override
	protected void execute(CommandEvent event) {
		event.getChannel().sendMessage("have an invite link to invite the bot to your server: "
				+ "https://discordapp.com/api/oauth2/authorize?client_id=426722296816861184&permissions=8&scope=bot").submit();
		
	}

}
