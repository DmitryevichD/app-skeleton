package by.dm13y.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication


@EnableConfigurationProperties
@SpringBootApplication
class AppSkeletonApplication

fun main(args: Array<String>) {
    runApplication<AppSkeletonApplication>(*args)
}
