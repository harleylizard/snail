package com.harleylizard.snail

import org.gradle.api.Plugin
import org.gradle.api.Project
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

    }
}