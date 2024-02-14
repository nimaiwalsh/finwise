package com.ittybittyapps.apptemplate.core.model.config

enum class Environment {
    Demo, Dev, Test, Production;

    companion object {
        fun fromString(value: String?): Environment {
            return when (value) {
                Demo.name -> Demo
                Dev.name -> Dev
                Test.name -> Test
                else -> Production
            }
        }
    }
}
