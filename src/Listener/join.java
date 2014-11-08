package Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import chatv3.main;

public class join implements Listener {

	
	public join(main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.getPlayer().setDisplayName(createDisplayName(e.getPlayer()));
		
	}

	private String createDisplayName(Player p) {
		// TODO Auto-generated method stub
		String display = p.getName();
		String group = "";

		if (p.hasPermission("chat.member")) {
			group = ChatColor.GOLD + "" + ChatColor.BOLD + "M" + ChatColor.RESET + ChatColor.DARK_GREEN + "ember" + ChatColor.RESET +  ChatColor.GRAY + " | " + ChatColor.BLUE ;
		}
		if (p.hasPermission("chat.premium")) {
			group = ChatColor.GOLD + "" + ChatColor.BOLD + "P" + ChatColor.RESET + ChatColor.DARK_PURPLE + "remium" + ChatColor.RESET + ChatColor.GRAY + " | " + ChatColor.BLUE ;
		}
		if (p.hasPermission("chat.admin")) {
			group = ChatColor.GOLD + "" + ChatColor.BOLD + "A" + ChatColor.RESET + ChatColor.DARK_RED + "dmin" + ChatColor.RESET + ChatColor.GRAY + " | " + ChatColor.RED;
		}

		display = group + p.getName();

		return display;
	}

}
