package com.harleylizard.snail

import com.harleylizard.snail.platform.ClochePlatform.Companion.clochePlatform
import earth.terrarium.cloche.api.target.MinecraftTarget

object SnailCloche {

    fun MinecraftTarget.latest(unit: (Dependencies) -> Unit) {
        Dependencies(clochePlatform).also(unit)
    }
}