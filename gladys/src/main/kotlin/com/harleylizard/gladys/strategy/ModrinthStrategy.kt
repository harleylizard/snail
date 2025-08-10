package com.harleylizard.gladys.strategy

import com.google.gson.Gson
import com.harleylizard.gladys.Dependency
import java.net.URI
import java.net.http.HttpClient

class ModrinthStrategy : Strategy {
    override fun find(client: HttpClient, gson: Gson, platform: String, slug: String, version: String): Set<Dependency> {
        return emptySet()
    }

    override fun uri(slug: String, version: String): URI = URI.create("https://api.modrinth.com/v2/project/$slug/version")
}