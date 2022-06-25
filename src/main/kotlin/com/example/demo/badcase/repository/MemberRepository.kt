package com.example.demo.badcase.repository

import com.example.demo.badcase.domain.Member
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository {

    fun read(id: Long): Member?
    fun save(member: Member): Member
    fun update(member: Member): Boolean
    fun delete(member: Member): Boolean
}