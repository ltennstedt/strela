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

import com.github.ltennstedt.strela.Option.None
import com.github.ltennstedt.strela.Option.Some

/**
 * Returns a [Some] if `[value] !== null`, a [None] otherwise
 *
 * @since 0.0.1
 */
fun <T> optionOf(value: T?): Option<T> = if (value === null) None() else Some(value)

/**
 * Option
 *
 * @since 0.0.1
 * @author Lars Tennstedt
 */
sealed class Option<T> {
    /**
     * Some
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    data class Some<T>(val value: T) : Option<T>() {
        companion object
    }

    /**
     * None
     *
     * @since 0.0.1
     * @author Lars Tennstedt
     */
    class None<T> : Option<T>() {
        companion object
    }

    /**
     * Indicates if `this` is a [Some]
     *
     * @since 0.0.1
     */
    val isSome: Boolean = this is Some<*>

    /**
     * Indicates if `this` is a [None]
     *
     * @since 0.0.1
     */
    val isNone: Boolean = this is None

    companion object
}
