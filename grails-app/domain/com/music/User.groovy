package com.music

class User {

    String username
    String password
    String email
    static hasMany = [history: History]

    static constraints = {
        username size:5..15, blank:false, unique: true
        password password: true, minSize: 5, blank: false
        email email: true, blank: false
    }
}
