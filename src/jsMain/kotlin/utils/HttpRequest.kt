package utils

import org.w3c.xhr.XMLHttpRequest
import repository.chart.model.Song
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class HttpRequest {
    enum class HttpRequestType {
        GET,
        POST,
        HEAD,
        PUT,
        DELETE,
        CONNECT,
        OPTIONS,
        PATCH
    }

    suspend fun <T> requestGet(url: String) = request<T>(HttpRequestType.GET, url)
    suspend fun <T> requestPost(url: String) = request<T>(HttpRequestType.POST, url)
    suspend fun <T> requestHead(url: String) = request<T>(HttpRequestType.HEAD, url)
    suspend fun <T> requestPut(url: String) = request<T>(HttpRequestType.PUT, url)
    suspend fun <T> requestDelete(url: String) = request<T>(HttpRequestType.DELETE, url)
    suspend fun <T> requestConnect(url: String) = request<T>(HttpRequestType.CONNECT, url)
    suspend fun <T> requestOptions(url: String) = request<T>(HttpRequestType.OPTIONS, url)
    suspend fun <T> requestPatch(url: String) = request<T>(HttpRequestType.PATCH, url)

    // List인 경우, 로그는 정상이지만 n번 원소 접근 시 exception 발생 -> Compose Web 자체 이슈인 것 같음
    suspend fun <T> request(httpRequestType: HttpRequestType, url: String) = suspendCoroutine<T> { continuation ->
        XMLHttpRequest().let { request ->
            request.open(httpRequestType.name, url, true)
            request.send()
            request.onloadend = {
                JSON.parse<T>(request.responseText).let { response ->
                    continuation.resume(response)
                }
            }
        }
    }

    // 마음에 들지 않지만 우선..
    suspend fun requestForSongList(url: String) =
        suspendCoroutine<List<Song>> { continuation ->
            XMLHttpRequest().let { request ->
                request.open(HttpRequestType.GET.name, url, true)
                request.send()
                request.onloadend = {
                    val songs = ArrayList<Song>(emptyList())
                    request.responseText.let { response ->
                        for (i in 1..50) {
                            val title = response.split("title\":\"")[i].split("\"")[0]
                            val artist = response.split("artist\":\"")[i].split("\"")[0]
                            val thumbnail = response.split("thumbnail\":\"")[i].split("\"")[0]
                            val song = Song(title, artist, thumbnail)
                            songs.add(song)
                        }
                    }
                    continuation.resume(songs)
                }
            }
        }
}