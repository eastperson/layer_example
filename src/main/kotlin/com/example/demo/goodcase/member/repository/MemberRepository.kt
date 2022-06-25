package com.example.demo.goodcase.member.repository

import com.example.demo.common.domain.Member
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository {

    fun read(id: Long): Member?
    fun save(member: Member): Member
    fun update(member: Member): Boolean
    fun delete(member: Member): Boolean
}