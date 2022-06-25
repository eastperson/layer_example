package com.example.demo.badcase.domain

import com.example.demo.badcase.api.dto.MemberUpdate

class Member(
    val id: Long? = null,
    var name: String,
    var age: Int,
    val card: Card? = null
)