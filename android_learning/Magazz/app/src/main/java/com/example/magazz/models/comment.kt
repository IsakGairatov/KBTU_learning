package com.example.magazz.models

class comment {
    var id: Int
    var Commented_id: Int
    var Product_id: Int
    var Comment: String

    constructor(id: Int = 0, c_id: Int = 0, P_id: Int = 0, C: String = "") {
        this.id = id
        this.Commented_id = c_id
        this.Product_id = P_id
        this.Comment = C
    }
}