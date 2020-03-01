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
 * Store
 *
 * @param <E> type of `Enum`
 * @param <T> type of [value]
 * @property actions [Actions][Action]
 * @constructor Constructs a [Store]
 * @throws IllegalArgumentException if [actions] contains two [Actions][Action] with same IDs
 * @since 0.0.1
 * @author Lars Tennstedt
 */
@ExperimentalStrela
class Store<E : Enum<E>, T>(val init: T, val actions: List<Action<E, T>>) {
    init {
        require(actions.map { it.id }.distinct().size == actions.size) {
            "expected only actions which have different IDs"
        }
    }

    /**
     * Value
     *
     * @since 0.0.1
     */
    val value: T
        get() = _value

    private var _value: T = init

    /**
     * Executes the [Action] identified by [actionId], updates [value] accordingly and returns the new [value]
     *
     * @since 0.0.1
     */
    fun dispatch(actionId: E): T {
        _value = actions.filter { it.id === actionId }.single().f.invoke(value)
        return value
    }

    override fun hashCode(): Int {
        val factor = 31
        return factor * (factor * (factor * 7 + init.hashCode()) + value.hashCode()) + actions.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Store<*, *>) return false
        return init == other.init && value == other.value && actions == other.actions
    }

    override fun toString(): String = "Store{init=$init, value=$value, actions=$actions}"

    companion object
}

/**
 * Action
 *
 * @param <E> type of `Enum`
 * @param <T> type of [value]
 * @property id ID of the [Action]
 * @property f function
 * @constructor Constructs an [Action]
 * @since 0.0.1
 * @author Lars Tennstedt
 */
@ExperimentalStrela
data class Action<E : Enum<E>, T>(val id: E, val f: (T) -> T) {
    companion object
}
