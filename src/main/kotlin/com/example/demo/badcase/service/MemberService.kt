package com.example.demo.badcase.service

import com.example.demo.badcase.api.dto.MemberCreate
import com.example.demo.badcase.api.dto.MemberRead
import com.example.demo.badcase.api.dto.MemberUpdate
import com.example.demo.badcase.api.dto.PayRequest
import com.example.demo.badcase.domain.Member
import com.example.demo.badcase.repository.OrderRepository
import com.example.demo.badcase.repository.CardRepository
import com.example.demo.badcase.repository.MemberRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val orderRepository: OrderRepository,
    private val cardRepository: CardRepository
) {
    fun read(id: Long): MemberRead.Response {
        val member = memberRepository.read(id) ?: throw Exception("회원이 존재하지 않습니다.")
        val response = MemberRead.Response(
            id = member.id!!,
            name = member.name,
            age = member.age
        )
        return response
    }

    fun create(createRequest: MemberCreate.Request): MemberCreate.Response {
        val member = Member(name = createRequest.name, age = createRequest.age)
        val saved = memberRepository.save(member)
        val response = MemberCreate.Response(
            id = saved.id!!,
            name = saved.name,
            age = saved.age
        )
        return response
    }

    fun update(id: Long, updateRequest: MemberUpdate.Request): Boolean {
        val member = memberRepository.read(id) ?: throw Exception("회원이 존재하지 않습니다.")
        member.age = updateRequest.age
        member.name = updateRequest.name
        val result = memberRepository.update(member)
        return result
    }

    fun delete(id: Long): Boolean {
        val member = memberRepository.read(id) ?: throw Exception("회원이 존재하지 않습니다.")
        val result = memberRepository.delete(member)
        return result
    }

    fun pay(payDto: PayRequest): BigDecimal {
        val member = memberRepository.read(payDto.memberId) ?: throw Exception("회원이 존재하지 않습니다.")
        val card = member.card!!
        if (card.currentAmount < payDto.amount) {
            throw Exception("잔액이 부족합니다.")
        }
        card.pay(payDto)
        return card.currentAmount
    }
}