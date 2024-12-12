package io.github.autumn.autumnsafety;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

public final class AutumnSafety extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        String logContent = """
                
                ========================================================
                已成功启用AutumnSafety
                使用"/AutSa help"来查看本插件帮助
                ========================================================
                     ___      ___     ___      ___      ___      ___
                    /\\  \\    /\\__\\   /\\  \\    /\\__\\    /\\__\\    /\\__\\
                   /  \\  \\  / / _/_  \\ \\  \\  / / _/_  /  L_L_  / | _|_
                  /  \\ \\__\\/ /_/\\__\\ /  \\__\\/ /_/\\__\\/ /L \\__\\/  |/\\__\\
                  \\/\\  /  /\\ \\/ /  // /\\/__/\\ \\/ /  /\\/_/ /  /\\/|  /  /
                    / /  /  \\  /  / \\/__/    \\  /  /   / /  /   | /  /
                    \\/__/    \\/__/            \\/__/    \\/__/    \\/__/
                ========================================================
                """;
        getLogger().info(logContent);

        AutumnModCheckKickOut autumnModCheckKickOut = new AutumnModCheckKickOut();
        getServer().getPluginManager().registerEvents(autumnModCheckKickOut, this);

        PluginCommand autSaCommand = getCommand("AutSa");
        if (autSaCommand!= null) {
            @Nullable CommandExecutor AutumnCommandExecutor = null;
            autSaCommand.setExecutor(null);
        } else {
            getLogger().severe("无法获取名为AutSa的命令对象，命令注册失败，请检查命令配置或插件依赖情况");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("感谢使用AutumnSafety\n" +
                "[AutumnMoon]: Yoooooo!!");
    }
}
