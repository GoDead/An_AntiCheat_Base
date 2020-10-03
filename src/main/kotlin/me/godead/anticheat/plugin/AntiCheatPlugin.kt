package me.godead.anticheat.plugin

import me.godead.anticheat.users.User
import me.godead.lilliputian.Dependency
import me.godead.lilliputian.Lilliputian
import me.godead.lilliputian.Repository
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

open class AntiCheatPlugin : JavaPlugin() {

    override fun onEnable() {
        val lilliputian = Lilliputian(this)
        lilliputian.dependencyBuilder
            .addDependency(
                Dependency(
                    Repository.JITPACK,
                    "com.github.retrooper",
                    "packetevents",
                    "1.6.9"
                )
            )
            .addDependency(
                Dependency(
                    Repository.MAVENCENTRAL,
                    "org.jetbrains.kotlin",
                    "kotlin-stdlib",
                    "1.4.10"
                )
            )
            .loadDependencies()
        onStart()
        AntiCheatManager.init(this)
        onStartFinish()
    }

    override fun onDisable() {
        onStop()
        AntiCheatManager.stop(this)
    }

    open fun onStart() {}

    open fun onStartFinish() {}

    open fun onStop() {}

    fun setUser(user: Class<*>) {
        AntiCheatManager.customUser = user
    }

    val plugin: Plugin
        get() = AntiCheatManager.plugin

}