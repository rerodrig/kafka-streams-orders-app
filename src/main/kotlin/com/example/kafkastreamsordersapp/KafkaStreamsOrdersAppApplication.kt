package com.example.kafkastreamsordersapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KafkaStreamsOrdersAppApplication

fun main(args: Array<String>) {
	runApplication<KafkaStreamsOrdersAppApplication>(*args)
}
