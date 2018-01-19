package br.com.explorecraft.ecannouncements;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class EC_Announcements extends JavaPlugin {
	
	private Configs config;
	
	public Configs getConfigs(){
		return this.config;
	}
	
	public static int index;
	
	
	public void onEnable() {
		index=0;
		getServer().getConsoleSender().sendMessage(org.bukkit.ChatColor.GREEN + "[EC_Announcements] Plugin Enabled");
		this.config = new Configs(this);
		announcements();
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(org.bukkit.ChatColor.RED + "[EC_Announcements] Plugin Disabled");
		
		
	}
	
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();		
	}
	
	public void announcements() {
						
		if (getConfig().getString("announcements.enable-announcements").equalsIgnoreCase("true")) {
            Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            	ArrayList<String> anuncios = (ArrayList<String>) getConfig().getStringList("announcements.message").stream().map(message -> ChatColor.translateAlternateColorCodes('&', message)).collect(Collectors.toList());
            	if (getConfig().getString("announcements.random-announcements").equalsIgnoreCase("false")) {            	            	
            	
            		if (index < anuncios.size()) {            	
            	        Bukkit.broadcastMessage(anuncios.get(index));
            	        index++;
            	     } else {index = 0;}
            	    } 
            	
            	   if (getConfig().getString("announcements.random-announcements").equalsIgnoreCase("true")) {            	
            	        Random random = new Random();
        	        	int index = random.nextInt(anuncios.size());
                        Bukkit.broadcastMessage(anuncios.get(index));}
                        
            }, 0, getConfig().getInt("announcements.seconds") * 20);
        }
		
		
	}

}
