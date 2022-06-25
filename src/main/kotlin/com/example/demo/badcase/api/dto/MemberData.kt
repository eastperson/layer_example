package com.example.demo.badcase.api.dto

class MemberRead {
    data class Response(
        val id: Long,
        val name: String,
        val age: Int
    )
}

class MemberCreate {

    data class Request(
        val name: String,
        val age: Int
    )
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
    )
}