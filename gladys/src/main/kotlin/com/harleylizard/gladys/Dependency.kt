package com.harleylizard.gladys

import com.google.gson.JsonObject
import com.google.gson.JsonSerializer

class Dependency {

    companion object {
        val serialiser = JsonSerializer<Dependency> { dependency, type, context -> JsonObject() }

    }
}