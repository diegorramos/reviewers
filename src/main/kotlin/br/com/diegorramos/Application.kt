package br.com.diegorramos

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("br.com.diegorramos")
                .mainClass(Application.javaClass)
                .start()
    }
}