package com.harleylizard.snail.platform

import org.gradle.api.Project

sealed interface Platform {

    fun name(project: Project): String

    fun version(project: Project): String
}