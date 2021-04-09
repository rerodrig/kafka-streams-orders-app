package com.example.kafkastreamsordersapp.order

data class Order(val id: String, val customerId: Long, val product: Product, val quantity: Int, val price: Double)