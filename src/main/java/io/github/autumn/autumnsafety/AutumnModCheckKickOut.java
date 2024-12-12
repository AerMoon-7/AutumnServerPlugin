package io.github.autumn.autumnsafety;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class AutumnModCheckKickOut extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // 注册事件监听器
        getServer().getPluginManager().registerEvents(this, this);

        // 加载配置文件
        saveDefaultConfig();
        List<String> bannedMods = getConfig().getStringList("banned-mods");
        // 这里可以打印下加载的禁止模组列表到日志，方便查看
        getLogger().info("已从配置文件加载禁止的模组列表: " + bannedMods);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        try {
            List<String> bannedMods = getConfig().getStringList("banned-mods");
            for (String mod : bannedMods) {
                // 这里后续可以完善更准确的检查逻辑，目前还是简单示例
                if (event.getPlayer().getResourcePackStatus() == null) {
                    getLogger().info(event.getPlayer().getName() + "可能没安装 " + mod);
                } else {
                    getLogger().info(event.getPlayer().getName() + "可能安装了 " + mod);
                    event.getPlayer().kickPlayer("检测到你安装了不允许的 " + mod + " 模组，禁止进入服务器");
                }
            }
        } catch (Exception e) {
            getLogger().severe("在检查模组时出现错误: " + e.getMessage());
        }
    }
}