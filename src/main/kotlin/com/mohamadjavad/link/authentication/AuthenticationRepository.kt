package com.mohamadjavad.link.authentication

import org.springframework.data.jpa.repository.JpaRepository

interface AuthenticationRepository : JpaRepository<AuthenticationEntity, String>