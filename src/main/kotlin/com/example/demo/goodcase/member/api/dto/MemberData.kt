package com.example.demo.goodcase.member.api.dto

import com.example.demo.goodcase.member.service.data.CreateRequest
import com.example.demo.goodcase.member.service.data.UpdateRequest

class MemberRead {
    data class Response(
        val id: Long,
        val name: String,
        val age: Int
    )
}

class MemberCreate {

    data class HttpRequest(
        val name: String,
        val age: Int,
        val secretKey: String
    ) {
        fun toCreateRequest() = CreateRequest(
            name = name,
            age = age
        )
    }

    data class Response(
        val id: Long,
        val name: String,
        val age: Int
    )
}

class MemberUpdate {
    data class Request(
        val name: String,
        val age: Int
    ) {
        fun toUpdateRequest() = UpdateRequest(
            name = name,
            age = age
        )
    }
}