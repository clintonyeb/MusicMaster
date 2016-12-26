package com.music

import grails.plugin.cache.Cacheable
import grails.transaction.Transactional
import groovy.transform.CompileStatic
import org.grails.web.json.JSONObject
import org.springframework.beans.factory.annotation.Value
import grails.plugins.rest.client.RestBuilder
import groovy.transform.CompileDynamic


@Transactional
@CompileStatic
class AlbumService {

    @Value('${music.search.url}')
    String searchUrl

    final String urlHome = "https://itunes.apple.com/search?limit=25&term=music&country=in"

    @Cacheable('itunesSearchResults')
    List<Album> search(String searchTerm) {
        log.debug "Searching iTunes Store For [${searchTerm}]"
        def rb = new RestBuilder()

        log.debug "Search URL: ${searchUrl}"
        def queryParameters = [searchTerm: searchTerm] as Map<String, Object>
        def resp = rb.get(searchUrl, queryParameters)

        def json = (JSONObject)resp.json
        def jsonResults = json.results
        //log.debug(jsonResults.toString())

        jsonResults.collect { albumInfo ->
            createAlbum albumInfo
        }
    }

    @Cacheable('itunesHomeResults')
    List<Album> getLatest() {
        def rb = new RestBuilder()

        //log.debug "Search URL: ${searchUrl}"
        //def queryParameters = [searchTerm: ""] as Map<String, Object>
        def resp = rb.get(urlHome)

        def json = (JSONObject)resp.json
        def jsonResults = json.results

        jsonResults.collect { albumInfo ->
            createAlbum albumInfo
        }
    }


    @CompileDynamic
    protected Album createAlbum(json) {
        new Album(
                artistId: json.artistId,
                previewUrl: json.previewUrl,
                artWorkUrl: json.artworkUrl100,
                primaryGenreName: json.primaryGenreName,
                collectionName: json.collectionName,
                artistName: json.artistName,
                url: json.collectionViewUrl)
    }
}
