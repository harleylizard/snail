package com.harleylizard.gladys.strategy

import com.google.gson.Gson
import com.harleylizard.gladys.Dependency
import java.net.URI
import java.net.http.HttpClient

sealed interface Strategy {

    fun find(client: HttpClient, gson: Gson, platform: String, slug: String, version: String): Set<Dependency>

    fun uri(slug: String, version: String): URI
}