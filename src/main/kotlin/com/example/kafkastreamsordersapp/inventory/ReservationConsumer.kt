package com.example.kafkastreamsordersapp.inventory

import com.example.kafkastreamsordersapp.order.Order
import com.example.kafkastreamsordersapp.order.OrderCreatedEvent
import mu.KotlinLogging
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import reactor.core.publisher.EmitterProcessor
import java.util.function.Consumer
import java.util.function.Supplier

@Component
class ReservationConsumer {

    private val logger = KotlinLogging.logger {}

    @Bean
    fun inventoryReservationConsumer(): Consumer<OrderCreatedEvent> = Consumer {
        logger.info { "[RabbitMQ] Order event received by INVENTORY RESERVATION: $it" }
    }

}