package com.mohamadjavad.link.user

import com.mohamadjavad.link.user.request.UserCreateRequest
import com.mohamadjavad.link.user.request.UserUpdateRequest
import com.mohamadjavad.link.util.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll().map(UserEntity::toDomain)
    }

    fun getUserById(id: UUID): User {
        return userRepository.findById(id).map(UserEntity::toDomain).orElseThrow { NotFoundException() }
    }

    fun createUser(userCreateRequest: UserCreateRequest): User {
        return userRepository.save(
            UserEntity(
                email = userCreateRequest.email,
                username = userCreateRequest.username,
            )
        ).toDomain()
    }

    fun updateUser(userUpdateRequest: UserUpdateRequest): User {
        return userRepository.findById(userUpdateRequest.id).map {
            userRepository.save(
                it.copy(
                    username = userUpdateRequest.username
                )
            ).toDomain()
        }.orElseThrow { NotFoundException() }
    }

    fun deleteUser(id: UUID) {
        userRepository.deleteById(id)
    }
}