package com.music

class History {

    String searchTerm
    static belongsTo = [user: User]
    static constraints = {
    }
}
