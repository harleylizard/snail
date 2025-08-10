package com.harleylizard.gladys

import com.google.gson.GsonBuilder
import com.harleylizard.gladys.Pair.Companion.and
import com.harleylizard.gladys.strategy.Strategy
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import java.net.http.HttpClient
import java.util.*

class Gladys private constructor(private val map: Map<String, Pair<Strategy, Aliases>>): HttpHandler {
    private val gson = GsonBuilder().create()

    override fun handle(exchange: HttpExchange) {
        if (exchange.requestMethod.equals("GET")) {
            val headers = exchange.requestURI.path.substring(1).split("/")

            val name = headers[0]
            if (map.contains(name)) {
                val strategy = map[name]?.l ?: return

                val platform = headers[1]
                val slug = headers[2]
                val version = headers[3]

                val dependencies = mutableSetOf<Dependency>()

                val client = HttpClient.newHttpClient()

                dependencies.addAll(strategy.find(client, gson, platform, slug, version))

                client.shutdown()
            }

            exchange.sendResponseHeaders(404, -1)
            return
        }

        exchange.sendResponseHeaders(405, -1)
    }

    class Builder {
        private val map = mutableMapOf<String, Pair<Strategy, Aliases>>()

        val build get() = Gladys(Collections.unmodifiableMap(map))

        fun add(name: String, strategy: Strategy) {
            map[name] = strategy and Aliases()
        }
    }

    companion object {

        fun build(unit: Builder.() -> Unit) = Builder().also(unit).build
    }

}