package com.example.demo.goodcase.member.service.implement

import com.example.demo.common.domain.Member
import com.example.demo.goodcase.member.repository.MemberRepository
import org.springframework.stereotype.Component

@Component
class MemberReader(
    private val memberRepository: MemberRepository
) {
    fun read(id: Long): Member = memberRepository.read(id) ?: throw Exception("회원이 존재하지 않습니다.")
}