package com.example.demo.goodcase.member.service.implement

import com.example.demo.common.domain.Member
import com.example.demo.goodcase.member.repository.MemberRepository
import com.example.demo.goodcase.member.service.data.CreateRequest
import com.example.demo.goodcase.member.service.data.UpdateRequest
import org.springframework.stereotype.Component

@Component
class MemberAppend(
    private val memberRepository: MemberRepository
) {
    fun add(createRequest: CreateRequest): Member {
        val member = Member(name = createRequest.name, age = createRequest.age)
        return memberRepository.save(member)
    }

    fun update(member: Member, updateRequest: UpdateRequest): Member {
        member.update(age = updateRequest.age, name = updateRequest.name)
        return memberRepository.save(member)
    }
}