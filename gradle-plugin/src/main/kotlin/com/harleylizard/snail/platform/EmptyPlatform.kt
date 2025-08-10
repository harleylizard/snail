package com.harleylizard.snail.platform

import org.gradle.api.Project

class EmptyPlatform private constructor(): Platform {
    override fun name(project: Project): String {
        throw UnsupportedOperationException()
    }

    override fun version(project: Project): String {
        throw UnsupportedOperationException()
    }

    companion object {
        val empty: Platform = EmptyPlatform()

    }
}