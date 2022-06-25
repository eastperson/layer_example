package com.example.demo.common.domain

import com.example.demo.badcase.domain.Card

class Member(
    val id: Long? = null,
    var name: String,
    var age: Int,
    val card: Card? = null
) {
    fun update(age: Int, name: String) {
        this.age = age
        this.name = name
    }
}