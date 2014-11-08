package Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import chatv3.main;

public class chat implements Listener {

	public chat(main main) {
		main.getServer().getPluginManager().registerEvents(this, main);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if (e.getMessage().startsWith("@a")){
			String message = e.getMessage();
			message = message.replace("@all", "");
			message = message.replace("@al", "");
			message = message.replace("@a", "");
				if( e.getPlayer().hasPermission("chat.global")) {
			
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "@all" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET + e.getPlayer().getDisplayName(), message, player);
			}
				}else{
					e.getPlayer().sendMessage(ChatColor.RED + "Du hast keine Rechte im allgemeinen Chat zu schreiben!");
					ChatNear(e.getPlayer(), message);
				}
		} else {
			ChatNear(e.getPlayer(), e.getMessage());
		}
		e.setCancelled(true);
	}

	private void sendMessage(String player, String message, Player p) {
		// TODO Auto-generated method stub
		p.sendMessage(player + ChatColor.RESET + ChatColor.ITALIC
				+ ChatColor.GOLD + "> " + ChatColor.RESET + ChatColor.GRAY
				+ message);
	}

	private void ChatNear(Player player, String message) {
		// TODO Auto-generated method stub
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.getLocation().distance(player.getLocation()) <= 30) {
				sendMessage(player.getDisplayName(), message, p);
			}
			if (p.getLocation().distance(player.getLocation()) >= 31
					&& p.hasPermission("chat.admin")) {

				sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED
						+ ChatColor.BOLD + "A" + ChatColor.RESET
						+ ChatColor.RED + "Spy" + ChatColor.DARK_GRAY + "] "
						+ player.getDisplayName(), message, p);
			}
		}
	}
}
