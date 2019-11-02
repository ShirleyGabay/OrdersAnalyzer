package com.shirley.gabay.ordersanalyzer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list1 = listOf(
            OrdersAnalyzer.OrderLine(1, "Sunglasses", 1, 120.0),
            OrdersAnalyzer.OrderLine(2, "T-Shirt", 6, 99.0),
            OrdersAnalyzer.OrderLine(3, "Shoes", 2, 13.0)
        )

        val list2 = listOf(
            OrdersAnalyzer.OrderLine(4, "Eye Liner 1", 4, 8.1),
            OrdersAnalyzer.OrderLine(5, "Eye Liner 2", 12, 2.8),
            OrdersAnalyzer.OrderLine(6, "Eye Liner 3", 7, 6.0)
        )

        val list3 = listOf(
            OrdersAnalyzer.OrderLine(7, "Product1", 33, 3.12),
            OrdersAnalyzer.OrderLine(8, "Product2", 12, 37.23),
            OrdersAnalyzer.OrderLine(9, "Product3", 78, 11.7)
        )

        val order1 = OrdersAnalyzer.Order(1, LocalDateTime.of(2017, 8, 12, (0 until 12).random(), (0 until 60).random()), list1)

        val order2 = OrdersAnalyzer.Order(4, LocalDateTime.now().minusHours(36), list2)

        val order3 = OrdersAnalyzer.Order(6, LocalDateTime.now().plusDays(36), list2)

        val order4 = OrdersAnalyzer.Order(9, LocalDateTime.now().minusDays(1), list3)

        text.setText(OrdersAnalyzer().totalDailySales(listOf(order1, order2, order3, order4)).toString())
    }
}
