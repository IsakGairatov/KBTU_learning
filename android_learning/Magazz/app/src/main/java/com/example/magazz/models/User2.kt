package com.example.magazz.models

class User2 {
    var id: Int
    var usname: String
    var Role: String

    constructor(id: Int = 0, usname: String = "", Role: String = "") {
        this.id = id
        this.usname = usname
        this.Role = Role
    }
}