package br.com.explorecraft.ecannouncements;



import java.util.Arrays;


public class Configs {
	
	
   EC_Announcements plugin;


	
	
	public Configs(EC_Announcements plugin) {
		
		this.plugin=plugin;
		
		plugin.getConfig().options().header("=============== EC_Announcements Configuration Options ================\n"
				+ "\n"
				+ "Version: 1.0.\n"
				+ "Author: TheExplorerBR\n"
				+ "\n"
				+ "\n"
				+ "(EN) By Default, the plugin started disabled, to activate the announcements, please set enable-announcements to 'TRUE'\n"
				+ "(PT-BR) Por Default o plugin iniciará desativado (FALSE). Para ativar os anuncios modifique o enable-announcements para 'TRUE'\n"
				+ "\n"
				+ "(EN)For colors, use the '&' character\n"
				+ "(PT-BR) Para utilizar cores, utilize o caractere '&'\n"
				+ "\n"
				+ "(EN) Make sure each message is surrounded by quotations: ('message'). You can add as many announcements as you want\n"
				+ "(PT-BR) Esteja certo de que cada anúncio (mensagem) esteja entre aspas. Você pode adicionar quantos anúncios desejar\n"
				+ "\n"
				+ "(EN)Set the interval of time (in seconds) between each announcements\n"
				+ "(PT-BR) Escolha o intervalo (em segundos) entre os anúncios\n"
				+ "\n"
				+ "(EN)Set how you want to show the announcements (Random or ordered).By default the plugin is set to 'FALSE' and will show announcements in order.\n "
				+ "Set 'TRUE' to show randomly announcements\n"
				+ "(PT-BR) Escolha se deseja mostrar seus anuncios de forma aleatória ou ordenada. Por padrão o plugin vem setado como 'FALSE' e mostrará os anúncios ordenados.\n"
				+ " Altere para 'TRUE' caso queira que os anuncios sejam mostrados aleatóriamente\n"				
				+ "\n"				
                + "\n");
		
		if(!(plugin.getConfig().contains("announcements"))) {			
			plugin.getConfig().set("announcements.enable-announcements", "FALSE");
			plugin.getConfig().set("announcements.message",Arrays.asList("&6&l[Announcement] &1&lMy Test Announcement one","&2&l My Test Announcement two"));
			plugin.getConfig().set("announcements.seconds",5);
			plugin.getConfig().set("announcements.random-announcements", "FALSE");
			
			plugin.saveConfig();
		}
	}
			
}
