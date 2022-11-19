package com.example.alertapp

interface IPreference {
    fun get(key: String): Any
    fun set(key: String): Boolean
}