package ru.knockstick.kraftikland;

import org.bukkit.plugin.java.JavaPlugin;
import ru.knockstick.metrics.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Main extends JavaPlugin implements Listener {
    public Main plugin = this;
    public Boolean isEnabled = this.getConfig().getBoolean("plugin.enabled");
    public double x1 = this.getConfig().getDouble("plugin.x1");
    public double y1 = this.getConfig().getDouble("plugin.y1");
    public double z1 = this.getConfig().getDouble("plugin.z1");
    public float yaw1 = (float)this.getConfig().getInt("plugin.yaw1");
    public float pitch1 = (float)this.getConfig().getInt("plugin.pitch1");
    
    public double x2 = this.getConfig().getDouble("plugin.x2");
    public double y2 = this.getConfig().getDouble("plugin.y2");
    public double z2 = this.getConfig().getDouble("plugin.z2");
    public float yaw2 = (float)this.getConfig().getInt("plugin.yaw2");
    public float pitch2 = (float)this.getConfig().getInt("plugin.pitch2");
    
    public double x3 = this.getConfig().getDouble("plugin.x3");
    public double y3 = this.getConfig().getDouble("plugin.y3");
    public double z3 = this.getConfig().getDouble("plugin.z3");
    public float yaw3 = (float)this.getConfig().getInt("plugin.yaw3");
    public float pitch3 = (float)this.getConfig().getInt("plugin.pitch3");
    
    public double xSpawn = this.getConfig().getDouble("plugin.xSpawn");
    public double ySpawn = this.getConfig().getDouble("plugin.ySpawn");
    public double zSpawn = this.getConfig().getInt("plugin.zSpawn");
    public float yawSpawn = (float)this.getConfig().getInt("plugin.yawSpawn");
    public float pitchSpawn = (float)this.getConfig().getInt("plugin.pitchSpawn");
    
    public String msg1 = this.getConfig().getString("plugin.msg1");
    public String msg2 = this.getConfig().getString("plugin.msg2");
    public String msg3 = this.getConfig().getString("plugin.msg3");
    public String endmsg = this.getConfig().getString("plugin.endmsg");
    
    public String prefix = this.getConfig().getString("plugin.prefix");
    
    @SuppressWarnings("unused")
	@Override
    public void onEnable() {
        this.plugin = this;
        this.saveDefaultConfig();
        this.getLogger().info("KraftikLand QuickGuide started!");
        this.getLogger().info("The plugin is made by the FriendWorld Network administration with love <3");
        this.getLogger().info("Our Contacts: https://github.com/FriendWorld-Network, Discord: https://discord.friendworld.ru/");
        this.getServer().getPluginManager().registerEvents(this, this);
        int pluginId = 14702;
        Metrics metrics = new Metrics(this, pluginId);
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Thread thread = new Thread() {
            public void run() {
                if(p.hasPlayedBefore() == false) {
                    try {
                        p.teleport(new Location(Bukkit.getWorld("world"), x1, y1, z1, yaw1, pitch1));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                        p.sendMessage(prefix + " " + msg1);
                        Thread.sleep(4000);
                        p.teleport(new Location(Bukkit.getWorld("world"), x2, y2, z2, yaw2, pitch2));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                        p.sendMessage(prefix + " " + msg2);
                        Thread.sleep(4000);
                        p.teleport(new Location(Bukkit.getWorld("world"), x3, y3, z3, yaw3, pitch3));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                        p.sendMessage(prefix + " " + msg3);
                        Thread.sleep(4000);
                        p.teleport(new Location(Bukkit.getWorld("world"), xSpawn, ySpawn, zSpawn, yawSpawn, pitchSpawn));
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
                        p.sendMessage(prefix + " " + endmsg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        if (isEnabled == true) {
        	thread.start();
        }
        
    }

}