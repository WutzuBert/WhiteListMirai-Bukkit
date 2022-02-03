package cn.cubegarden.whitelistmirai;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class WhiteListMirai extends JavaPlugin implements Listener {
    Thread thread = new Thread(MiraiConnect.INSTANCE::connect);
    public static String Command = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("WhiteListMirai已加载！");
        thread.start();
        new BukkitRunnable(){
            @Override
            public void run(){
                if(Command != null){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(),Command);
                    Command = null;
                }
            }
        }.runTaskTimer(this,0,1);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("WhiteListMirai已卸载！");
        thread.stop();
    }
}
