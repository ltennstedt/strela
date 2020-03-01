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

/**
 * Either
 *
 * @since 0.0.1
 * @author Lars Tennstedt
 */
@ExperimentalStrela
sealed class Either<L, R> {
    /**
     * Left
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    data class Left<L, R>(val value: L) : Either<L, R>() {
        companion object
    }

    /**
     * Right
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    data class Right<L, R>(val value: R) : Either<L, R>() {
        companion object
    }

    /**
     * Indicates if `this` is a [Left]
     *
     * @since 0.0.1
     */
    val isLeft: Boolean = this is Left<*, *>

    /**
     * Indicates if `this` is a [Right]
     *
     * @since 0.0.1
     */
    val isRight: Boolean = this is Right<*, *>

    companion object
}
