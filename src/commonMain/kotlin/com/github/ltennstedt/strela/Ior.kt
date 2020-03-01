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
 * Ior
 *
 * @param <L> type of left value
 * @param <R> type of right value
 * @constructor Constructs an [Ior]
 * @since 0.0.1
 * @author Lars Tennstedt
 */
sealed class Ior<L, R> {
    /**
     * Left
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    data class Left<L>(val value: L) : Ior<L, Nothing>() {
        companion object
    }

    /**
     * Right
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    data class Right<R>(val value: R) : Ior<Nothing, R>() {
        companion object
    }

    /**
     * Both
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    data class Both<L, R>(val value: Pair<L, R>) : Ior<L, R>() {
        companion object
    }

    /**
     * Indicates if `this` is a [Left]
     *
     * @since 0.0.1
     */
    val isLeft: Boolean = this is Left<*>

    /**
     * Indicates if `this` is a [Right]
     *
     * @since 0.0.1
     */
    val isRight: Boolean = this is Right<*>

    /**
     * Indicates if `this` is a [Both]
     *
     * @since 0.0.1
     */
    val isBoth: Boolean = this is Both<*, *>

    companion object
}
