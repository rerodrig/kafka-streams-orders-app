package com.example.kafkastreamsordersapp.order

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/orders")
class OrderController(val orderService: OrderService) {

    @PostMapping
    suspend fun save(@RequestBody order: Order) {
        orderService.submit(order)
    }

}