/*
 * Copyright 2020 Lars Tennstedt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.ltennstedt.strela

import com.github.ltennstedt.strela.Try.Failure
import com.github.ltennstedt.strela.Try.Success

/**
 * Returns a [Success] if invoking [f] does not throw a `Throwable`, a [Failure] otherwise
 *
 * @since 0.0.1
 */
fun <V> tryOf(f: () -> V): Try<V> {
    try {
        return Success(f.invoke())
    } catch (t: Throwable) {
        return Failure(t)
    }
}

/**
 * Try
 *
 * @since 0.0.1
 * @author Lars Tennstedt
 */
sealed class Try<out V> {
    /**
     * Success
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    data class Success<out V> internal constructor(val value: V) : Try<V>() {
        companion object
    }

    /**
     * Failure
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    data class Failure<out V>(val throwable: Throwable) : Try<V>() {
        companion object
    }

    /**
     * Indicates if `this` is a [Success]
     *
     * @since 0.0.1
     */
    val isSuccess: Boolean = this is Success<*>

    /**
     * Indicates if `this` is a [Failure]
     *
     * @since 0.0.1
     */
    val isFailure: Boolean = this is Failure<*>

    companion object
}
