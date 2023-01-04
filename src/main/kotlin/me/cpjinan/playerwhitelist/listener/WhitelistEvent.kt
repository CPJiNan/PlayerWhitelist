package me.cpjinan.playerwhitelist.listener

import me.cpjinan.playerwhitelist.manager.ConfigManager
import me.cpjinan.playerwhitelist.manager.ConfigManager.whitelist
import me.cpjinan.playerwhitelist.manager.FormatManager
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import taboolib.common.platform.event.SubscribeEvent

object WhitelistEvent {

    /**
     * 玩家登入事件处理方法
     */
    @SubscribeEvent
    fun onPlayerLogin(event : AsyncPlayerPreLoginEvent) {
        if (whitelist.getBoolean("enable") && ((whitelist.getList("player")?.contains(event.name)?:event.allow()) == false)) event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED,FormatManager.getWhitelistFormat(event.name))
    }

}