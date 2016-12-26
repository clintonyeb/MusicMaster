package com.music

class UserController {

    AlbumService albumService

    def index() { }

    def login(username, password){
        if (username && password){
            def user = User.findByUsernameAndPassword(username, password)
            if (user){
                redirect(action: "displayAllAlbums")
            }
            else redirect(action: "index")
        }else redirect(action: "index")
    }

    def displayAllAlbums(){
        List<Album> albums = albumService.getLatest()
        [albums: albums]
    }

    def register(){

    }

    def doRegister(){
        def user = new User(params)
        if (user.validate() && user.save()){
            flash.message = "Successfully signed up"
            redirect(controller: "user", action: "displayAllAlbums")
        }else {
            flash.error = "Error creating account"
            redirect(action: "register")
        }
    }
}
