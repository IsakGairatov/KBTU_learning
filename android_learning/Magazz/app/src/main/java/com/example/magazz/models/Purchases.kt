package com.example.magazz.models

class Purchases {
    var id: Int
    var buyer_id: Int
    var product_id: Int
    var address: String
    var phoneNumber: String

    constructor(id: Int = 0, b_id: Int = 0, p_id: Int = 0, address: String = "", phone: String = "") {
        this.id = id
        this.buyer_id = b_id
        this.product_id = p_id
        this.address = address
        this.phoneNumber = phone
    }
}