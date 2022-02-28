package utils

import org.w3c.xhr.XMLHttpRequest
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
}