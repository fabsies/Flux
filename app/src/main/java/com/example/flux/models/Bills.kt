package com.example.flux.models

class Bills {
    var category:String=""
    var amount:String=""
    var date:String=""
    var mode:String=""
    var id:String=""

    constructor(category:String,amount:String,date:String,mode:String,id:String){
        this.category=category
        this.amount=amount
        this.date=date
        this.mode=mode
        this.id=id
    }
    constructor()
}