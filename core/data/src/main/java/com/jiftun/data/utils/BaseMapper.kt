package com.jiftun.data.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.jiftun.domain.utils.StatusResult

interface Mapper<R, E> {
    fun mapFromApiResponse(type: R): E
}

fun <R, E> mapFromApiResponse(statusResult: Flow<StatusResult<R>>, mapper: Mapper<R, E>): Flow<StatusResult<E>> {
    return statusResult.map {
        when (it) {
            is StatusResult.Success -> StatusResult.Success(mapper.mapFromApiResponse(it.data))
            is StatusResult.Error -> StatusResult.Error(it.message, it.code)
            is StatusResult.Loading -> StatusResult.Loading
        }
    }
}

