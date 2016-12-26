package com.music

class AlbumController {

    AlbumService albumService

    def index(String searchTerm) {
        if(searchTerm) {
            List<Album> searchResults = albumService.search(searchTerm)
            [searchTerm: searchTerm, searchResults: searchResults]
        }
    }
}
