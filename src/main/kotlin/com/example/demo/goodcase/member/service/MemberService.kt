package com.example.demo.goodcase.member.service

import com.example.demo.common.domain.Member
import com.example.demo.goodcase.member.service.data.CreateRequest
import com.example.demo.goodcase.member.service.data.UpdateRequest
import com.example.demo.goodcase.member.service.implement.MemberAppend
import com.example.demo.goodcase.member.service.implement.MemberReader
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberReader: MemberReader,
    private val memberAppend: MemberAppend
) {
    fun read(id: Long): Member {
        return memberReader.read(id)
    }

    fun create(createRequest: CreateRequest): Member {
        return memberAppend.add(createRequest)
    }

    fun update(id: Long, updateRequest: UpdateRequest): Boolean {
        val member = memberReader.read(id)
        memberAppend.update(member, updateRequest)
        return true
    }
}