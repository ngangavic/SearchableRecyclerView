package com.example.searchablerecyclerview.kotlin

class Animal {
    var name: String? = null
    var location: String? = null
    var img: String? = null

    constructor(name: String?, location: String?, img: String?) {
        this.name = name
        this.location = location
        this.img = "http://192.168.75.5/"+img
    }
}