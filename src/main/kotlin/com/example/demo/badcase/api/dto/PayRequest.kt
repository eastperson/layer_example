package com.example.demo.badcase.api.dto

import java.math.BigDecimal

data class PayRequest(
    val amount: BigDecimal,
    val memberId: Long
)