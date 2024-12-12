package io.github.autumn.autumnsafety;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class AutumnCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            // 检查命令参数
            if (args.length == 0) {
                player.sendMessage("这是我的自定义命令！");
            } else {
                player.sendMessage("你输入了参数：" + args[0]);
            }
            return true;
        } else {
            sender.sendMessage("这个命令只能由玩家执行。");
            return false;
        }
    }
}