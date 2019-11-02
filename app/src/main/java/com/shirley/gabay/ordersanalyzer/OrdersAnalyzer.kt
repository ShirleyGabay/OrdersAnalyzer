package com.shirley.gabay.ordersanalyzer

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.*

class OrdersAnalyzer {

    private val map: MutableMap<DayOfWeek, Int>

    init {
        this.map = EnumMap(DayOfWeek::class.java)
    }

    data class Order(
        val orderId: Int,
        val creationDate: LocalDateTime,
        val orderLines: List<OrderLine>
    )

    data class OrderLine(
        val productId: Int,
        val name: String,
        val quantity: Int,
        val unitPrice: Double
    )


    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {
        for (order in orders) {
            map.put(order.creationDate.dayOfWeek, getSum(order.orderLines))
        }
        return map
    }

    private fun getSum(orderLines: List<OrderLine>): Int {
        var sum = 0
        for (orderLine in orderLines) {
            sum += orderLine.quantity
        }
        return sum
    }


}