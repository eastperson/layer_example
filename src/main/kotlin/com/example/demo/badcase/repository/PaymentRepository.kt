package com.example.demo.badcase.repository

import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository {
    fun save()
}