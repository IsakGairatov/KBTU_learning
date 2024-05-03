package com.example.magazz.models

class product {
    var id: Int
    var name: String
    var desc: String
    var price: Int
    var amount: Int

    constructor(id: Int = 0, name: String = "", desc: String = "", price: Int = 0, amount: Int = 0) {
        this.id = id
        this.name = name
        this.desc = desc
        this.price = price
        this.amount = amount
    }
}