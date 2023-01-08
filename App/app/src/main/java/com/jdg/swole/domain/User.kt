package com.jdg.swole.domain

class User(private val id: Int, private val firstName: String, private val lastName: String) {
    val fullName: () -> String = {"$firstName $lastName"}
}