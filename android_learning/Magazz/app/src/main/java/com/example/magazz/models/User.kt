package com.example.magazz.models

class User {
    var id: Int
    var usname: String
    var Pass: String
    var Role: String

    constructor(id: Int = 0, usname: String = "", Pass: String = "", Role: String = "") {
        this.id = id
        this.usname = usname
        this.Pass = Pass
        this.Role = Role
    }
}
