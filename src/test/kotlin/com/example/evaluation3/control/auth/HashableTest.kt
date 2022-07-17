package com.example.evaluation3.control.auth

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class HashableTest {
    @Test
    fun shouldGenerateSameHash() {
        val toBeHashed = "teste"
        val expectedHash = "46070d4bf934fb0d4b06d9e2c46e346944e322444900a435d7d9a95e6d7435f5"
        assertEquals(expectedHash, toBeHashed.sha256())
    }

    @Test
    fun shouldGenerateDifferentHash() {
        val toBeHashed = "teste"
        val expectedHash = "46070d4bf934fb0d4b06d9e2c46e346944e322444900a435d7d9a95e6d7435f5a"
        assertNotEquals(expectedHash, toBeHashed.sha256())
    }
}