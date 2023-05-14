package com.mohamadjavad.link

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LinkApplication{

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<LinkApplication>(*args)
        }
    }

}
