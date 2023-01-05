package me.cpjinan.playerwhitelist.commands

import me.cpjinan.playerwhitelist.manager.ConfigManager
import me.cpjinan.playerwhitelist.manager.ConfigManager.config
import me.cpjinan.playerwhitelist.manager.ConfigManager.whitelist
import org.bukkit.Bukkit
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*
import taboolib.expansion.createHelper
import taboolib.module.chat.colored

@CommandHeader(name = "playerwhitelist", aliases = ["whitelist"], permission = "playerwhitelist.admin")
object MainCommand {

    @CommandBody(permission = "playerwhitelist.admin")
    val main = mainCommand {
        createHelper()
    }

    @CommandBody(permission = "playerwhitelist.admin")
    val add = subCommand {
        dynamic("player") {
            execute<ProxyCommandSender> { sender, context, _ ->
                whitelist["player"] = whitelist.getStringList("player").plus(context.get(1))
                config.saveToFile(config.file)
                sender.sendMessage(("&a已添加玩家 &f"+context.get(1)+" &a至白名单！").colored())
            }
        }
    }

    @CommandBody(permission = "playerwhitelist.admin")
    val remove = subCommand {
        dynamic("player") {
            execute<ProxyCommandSender> { sender, context, _ ->
                val playerList = whitelist.getStringList("player").toMutableList()
                playerList.removeIf { it == context.get(1) }
                whitelist["player"] = playerList.toList()
                config.saveToFile(config.file)
                sender.sendMessage(("&c已将玩家 &f"+context.get(1)+" &c从白名单删除！").colored())
            }
        }
    }

}