package io.uvera.template.api.user.auth

import io.uvera.template.configuration.CacheConfiguration
import io.uvera.template.common.dao.user.User
import io.uvera.template.common.dao.user.UserDao
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class UserCachingService(
    protected val repo: UserDao,
) {
    @Cacheable(cacheNames = [CacheConfiguration.USER_ENTITY_CACHE_NAME], key = "#email")
    fun findUserByEmail(email: String): User? = repo.findByEmail(email)
}