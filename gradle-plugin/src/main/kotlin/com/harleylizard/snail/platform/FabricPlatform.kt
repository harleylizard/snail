package com.harleylizard.snail.platform

import net.fabricmc.loom.util.Constants
import org.gradle.api.Project
import java.lang.UnsupportedOperationException

class FabricPlatform : Platform {

    override fun name(project: Project) = "fabric"

    override fun version(project: Project): String {
        return project.configurations.getByName(Constants.Configurations.MINECRAFT).dependencies.first().version ?: throw UnsupportedOperationException()
    }
}