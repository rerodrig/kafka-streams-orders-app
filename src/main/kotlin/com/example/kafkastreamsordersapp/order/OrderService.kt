package com.example.kafkastreamsordersapp.order

import mu.KotlinLogging
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.function.Consumer

@Service
class OrderService(val streamBridge: StreamBridge) {

    private val logger = KotlinLogging.logger {}

    val bindingName = "ordersProducer-out-0"

    fun submit(order: Order) {
        streamBridge.send(bindingName, OrderCreatedEvent(order.id, order))
    }


    @Bean
    fun ordersConsumer(): Consumer<Message<OrderCreatedEvent>> = Consumer {
        val orderCreatedEvent = it.payload

        val deliveryAttempt = it.headers["deliveryAttempt"]

        if (orderCreatedEvent.id == "99") {

            logger.info { "[Kafka] Delivery attempt $deliveryAttempt" }

            throw IllegalArgumentException("Error processing order")
        }
        logger.info { "[Kafka] Order event received by ORDER: $orderCreatedEvent" }
    }

}