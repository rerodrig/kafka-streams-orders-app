package com.example.kafkastreamsordersapp.inventory

import com.example.kafkastreamsordersapp.order.OrderCreatedEvent
import mu.KotlinLogging
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class InventoryConsumer(val streamBridge: StreamBridge) {

    private val logger = KotlinLogging.logger {}

    val bindingName = "inventoryOrdersConsumer-out-0"

    @Bean
    fun inventoryOrdersConsumer(): Consumer<OrderCreatedEvent> = Consumer {
        logger.info { "[Kafka] Order event received by INVENTORY: $it, sending to RabbitMQ" }
        streamBridge.send(bindingName, it)
    }

}