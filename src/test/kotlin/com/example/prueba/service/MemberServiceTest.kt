package com.example.prueba.service

import com.example.prueba.model.Member
import com.example.prueba.repository.MemberRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class MemberServiceTest {
    @InjectMocks
    lateinit var memberService: MemberService

    @Mock
    lateinit var memberRepository: MemberRepository

    val memberMock = Member().apply {
        id = 1
        fullname = "01506825334"
        email = "Steven"
        age = 18
    }

        @Test
        fun saveMemberWhenIsCorrect() {
            Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java))).thenReturn(memberMock)
            val response = memberService.save(memberMock)
            Assertions.assertEquals(response.id, memberMock.id)
        }

        @Test
        fun saveClientWhenIsFullnameIsBlank() {
            Assertions.assertThrows(Exception::class.java) {
                memberMock.apply { fullname = " " }
                Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java))).thenReturn(memberMock)
                memberService.save(memberMock)
            }
        }

    }