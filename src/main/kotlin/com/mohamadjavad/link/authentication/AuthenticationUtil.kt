package com.mohamadjavad.link.authentication

import java.util.*

internal fun generateRandomCode(codeLength: Int): String {
    val random = Random(System.nanoTime())
    val code = StringBuilder()
    repeat(codeLength) {
        val digit = random.nextInt(10)
        code.append(digit)
    }
    return code.toString()
}