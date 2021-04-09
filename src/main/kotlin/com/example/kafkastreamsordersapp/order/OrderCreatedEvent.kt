package com.example.kafkastreamsordersapp.order

data class OrderCreatedEvent(val id: String, val order: Order)
