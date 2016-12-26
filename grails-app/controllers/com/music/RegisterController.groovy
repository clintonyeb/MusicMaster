package com.music

class RegisterController {

    def index() { }

    def createNewUser(){
        def user = new User(params)
        if (user.validate() && user.save()){
            flash.message = "Successfully signed up"
            redirect(controller: "user", action: "displayAllAlbums")
        }else {
            flash.error = "Error creating account"
            redirect(action: "index")
        }
    }
}
