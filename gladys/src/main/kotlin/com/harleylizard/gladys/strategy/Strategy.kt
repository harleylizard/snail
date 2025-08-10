package com.harleylizard.gladys.strategy

import com.harleylizard.gladys.Dependency

sealed interface Strategy {

    fun find(): Set<Dependency>
}