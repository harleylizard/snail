package com.harleylizard.gladys

import com.google.gson.JsonArray
import com.google.gson.JsonSerializer

class DependencySet(private val dependencies: Set<Dependency>) {

    companion object {
        val serialiser = JsonSerializer<DependencySet> { set, type, context ->
            val array = JsonArray()
            for (dependency in set.dependencies) {
                array.add(context.serialize(dependency, Dependency::class.java))
            }
            array
        }

    }
}