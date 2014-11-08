package chatv3;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{

	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		new Listener.chat(this);
		new Listener.join(this);
		System.out.println("ChatPlugin von V3lop5 geladen!");
		super.onEnable();
	}
}
