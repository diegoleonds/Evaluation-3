package com.example.evaluation3.control.auth

import java.security.MessageDigest

private fun hashString(input: String, algorithm: String): String {
    return MessageDigest
        .getInstance(algorithm)
        .digest(input.toByteArray())
        .fold("") { str, it -> str + "%02x".format(it) }
}

fun String.toSha256() = hashString(this, "SHA-256")