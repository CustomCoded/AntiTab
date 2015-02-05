package me.MurkitoDev.antitab;


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;

public class AntiTab extends JavaPlugin implements Listener{

	private ProtocolManager protocolManager;
	public void onLoad(){
		protocolManager = ProtocolLibrary.getProtocolManager();
		protocolManager.addPacketListener(
				  new PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Server.TAB_COMPLETE) {
				    @Override
				    public void onPacketSending(PacketEvent event) {
				        if (event.getPacketType() == PacketType.Play.Server.TAB_COMPLETE) {
				           if (!(event.getPlayer().isOp())){
				        	   event.setCancelled(true);
				           }
				        }
				    }
				});
	}
	
}
