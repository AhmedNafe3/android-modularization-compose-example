package com.jiftun.domain.utils

import kotlinx.coroutines.flow.Flow

interface UseCase

interface ApiUseCaseParams<Params, Type> : UseCase {
    suspend fun execute(params: Params): Flow<StatusResult<Type>>
}

interface ApiUseCaseNonParams<Type> : UseCase {
    suspend fun execute(): Flow<StatusResult<Type>>
}
