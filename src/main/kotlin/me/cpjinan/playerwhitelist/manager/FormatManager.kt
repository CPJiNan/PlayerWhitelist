package me.cpjinan.playerwhitelist.manager

import taboolib.common.util.replaceWithOrder
import taboolib.module.chat.colored

object FormatManager {
    fun getWhitelistFormat(name:String) : String{
        return ConfigManager.whitelist.getList("format")!!.joinToString(separator = System.lineSeparator()).replaceWithOrder("#$name").colored()
    }
}