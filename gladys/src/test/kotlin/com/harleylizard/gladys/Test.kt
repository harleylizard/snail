package com.harleylizard.gladys

import com.harleylizard.gladys.strategy.CurseForgeStrategy
import com.harleylizard.gladys.strategy.FabricStrategy
import com.harleylizard.gladys.strategy.ModrinthStrategy
import com.sun.net.httpserver.HttpServer
import org.junit.jupiter.api.Test
import java.net.InetSocketAddress
import java.util.concurrent.Executors

fun main() {
    // http://localhost:8443/fabric/fabric/fabric-api/1.21.1
    val service = Executors.newCachedThreadPool();
    Runtime.getRuntime().addShutdownHook(Thread {
        service.shutdown()
    })

    val host = HttpServer.create(InetSocketAddress(8443), 0)
    host.createContext("/", Gladys.build {
        add("curse-forge", CurseForgeStrategy())
        add("fabric", FabricStrategy())
        add("modrinth", ModrinthStrategy())
    })
    host.executor = service
    host.start()
}

class Test {

    @Test
    fun test() {
    }
}