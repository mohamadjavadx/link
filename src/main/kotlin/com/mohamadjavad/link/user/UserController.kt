package com.mohamadjavad.link.user

import com.mohamadjavad.link.user.request.UserCreateRequest
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@Validated
class UserController(
    @Autowired
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody userCreateRequest: UserCreateRequest): User {
        return userService.createUser(userCreateRequest)
    }

    @GetMapping
    fun test(): String {
        return "test"
    }

}