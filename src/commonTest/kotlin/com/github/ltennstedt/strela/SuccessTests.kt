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

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@ExperimentalStrela
class SuccessTests {
    lateinit var success: Try<Boolean>

    @BeforeTest
    fun setUp() {
        success = tryOf { true }
    }

    @Test
    fun isSuccessReturnsTrue() {
        // when
        val actual = success.isSuccess

        // then
        assertTrue(actual)
    }

    @Test
    fun isFailureReturnsFalse() {
        // when
        val actual = success.isFailure

        // then
        assertFalse(actual)
    }
}
