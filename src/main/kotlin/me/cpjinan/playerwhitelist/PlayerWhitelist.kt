package me.cpjinan.playerwhitelist

import me.cpjinan.playerwhitelist.manager.RegisterManager.registerAll
import taboolib.common.platform.Plugin

object PlayerWhitelist : Plugin() {

    override fun onEnable() {
        registerAll()
    }
}