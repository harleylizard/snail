package com.harleylizard.snail

import com.harleylizard.snail.platform.EmptyPlatform
import com.harleylizard.snail.platform.FabricPlatform
import com.harleylizard.snail.platform.Platform
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyCollector
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import java.net.URI

class Snail : Plugin<Project> {

    override fun apply(target: Project) {
        target.allprojects {
            it.repositories.let { repositories ->
                repositories.exclusive("https://cursemaven.com/", "curse.maven")
                repositories.exclusive("https://api.modrinth.com/maven", "maven.modrinth")
            }

        }
    }

    companion object {
        val Project.platform: Platform get() {
            if (project.pluginManager.hasPlugin("fabric-loom")) {
                return FabricPlatform()
            }
            return EmptyPlatform.empty
        }

        private fun RepositoryHandler.exclusive(url: String, group: String) {
            exclusiveContent {
                it.forRepositories(mavenCentral(), maven { maven ->
                    maven.url = URI(url)
                })
                it.filter { filter ->
                    filter.includeGroup(group)
                }
            }
        }

        fun Project.latest(unit: (Dependencies) -> Unit) {
            dependencies.latest(platform, unit)
        }

        fun DependencyHandler.latest(platform: Platform, unit: (Dependencies) -> Unit) {

        }

        fun DependencyCollector.latest(platform: Platform, unit: (Dependencies) -> Unit) {

        }

    }
}