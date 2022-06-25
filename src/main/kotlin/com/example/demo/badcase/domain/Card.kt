package com.example.demo.badcase.domain

import com.example.demo.badcase.api.dto.PayRequest
import java.math.BigDecimal

class Card(
    var currentAmount: BigDecimal
) {
    fun pay(payDto: PayRequest) {
        this.currentAmount -= payDto.amount
    }
}
