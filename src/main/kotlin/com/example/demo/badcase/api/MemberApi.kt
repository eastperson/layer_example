package com.example.demo.badcase.api

import com.example.demo.badcase.api.dto.MemberCreate
import com.example.demo.badcase.api.dto.MemberRead
import com.example.demo.badcase.api.dto.MemberUpdate
import com.example.demo.badcase.api.dto.PayRequest
import com.example.demo.badcase.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/member")
class MemberApi(
    private val memberService: MemberService
) {

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): ResponseEntity<MemberRead.Response> {
        return ResponseEntity.ok(memberService.read(id))
    }

    @PostMapping
    fun create(@RequestBody createRequest: MemberCreate.Request): ResponseEntity<MemberCreate.Response> {
        return ResponseEntity.ok(memberService.create(createRequest))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updateRequest: MemberUpdate.Request): ResponseEntity<Boolean> {
        return ResponseEntity.ok(memberService.update(id, updateRequest))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Boolean> {
        return ResponseEntity.ok(memberService.delete(id))
    }

    @PostMapping
    fun pay(@RequestBody payDto: PayRequest): ResponseEntity<BigDecimal> {
        return ResponseEntity.ok(memberService.pay(payDto))
    }
}
