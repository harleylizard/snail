package com.harleylizard.snail.platform

import earth.terrarium.cloche.api.target.MinecraftTarget
import org.gradle.api.Project

class ClochePlatform private constructor(private val target: MinecraftTarget) : Platform {

    override fun name(project: Project): String = target.name

    override fun version(project: Project): String {
        return target.minecraftVersion.orNull ?: throw UnsupportedOperationException()
    }

    companion object {
        val MinecraftTarget.clochePlatform: Platform get() = ClochePlatform(this)

    }
}