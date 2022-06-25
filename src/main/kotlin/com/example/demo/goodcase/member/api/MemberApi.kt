package com.example.demo.goodcase.member.api

import com.example.demo.common.domain.Member
import com.example.demo.goodcase.member.api.dto.MemberCreate
import com.example.demo.goodcase.member.api.dto.MemberRead
import com.example.demo.goodcase.member.api.dto.MemberUpdate
import com.example.demo.goodcase.member.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/member")
class MemberApi(
    private val memberService: MemberService
) {

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): ResponseEntity<MemberRead.Response> {
        val member = memberService.read(id)
        val data = convertToResponse(member)
        return ResponseEntity.ok(data)
    }

    @PostMapping
    fun create(@RequestBody createRequest: MemberCreate.HttpRequest): ResponseEntity<MemberCreate.Response> {
        val created = memberService.create(createRequest.toCreateRequest())
        val data = convertToCreateResponse(created)
        return ResponseEntity.ok(data)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updateRequest: MemberUpdate.Request): ResponseEntity<Boolean> {
        memberService.update(id, updateRequest.toUpdateRequest())
        return ResponseEntity.ok(true)
    }

    private fun convertToCreateResponse(member: Member) = MemberCreate.Response(
        id = member.id!!,
        name = member.name,
        age = member.age
    )

    private fun convertToResponse(member: Member) = MemberRead.Response(
        id = member.id!!,
        name = member.name,
        age = member.age
    )
}