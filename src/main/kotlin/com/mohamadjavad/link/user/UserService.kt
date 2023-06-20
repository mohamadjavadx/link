package com.mohamadjavad.link.user

import com.mohamadjavad.link.util.NotAuthorizedException
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.optionals.getOrNull

@OptIn(ExperimentalStdlibApi::class)
@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun getAllUsers(): List<User> {
        return userRepository.findAll().map(UserEntity::toDomain)
    }

    fun getUserById(id: UUID): User {
        return userRepository.findById(id).map(UserEntity::toDomain).orElseThrow { NotAuthorizedException() }
    }

    fun findUserByEmail(email: String): User? {
        return userRepository.findOne(Example.of(UserEntity(email = email))).getOrNull()?.toDomain()
    }

    fun createUser(email: String): User {
        return userRepository.save(
            UserEntity(
                email = email
            )
        ).toDomain()
    }

    fun deleteUser(id: UUID) {
        userRepository.deleteById(id)
    }

}