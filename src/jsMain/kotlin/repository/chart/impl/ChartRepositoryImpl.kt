package repository.chart.impl

import repository.chart.ChartRepository
import repository.chart.model.Song
import utils.HttpRequest

class ChartRepositoryImpl : ChartRepository {
    private val httpRequest = HttpRequest()

    override suspend fun getMelonChart(): List<Song> = httpRequest.requestForSongList("http://localhost:8080/chart/melon")

    override suspend fun getBugsChart(): List<Song> = httpRequest.requestForSongList("http://localhost:8080/chart/bugs")

    override suspend fun getGenieChart(): List<Song> = httpRequest.requestForSongList("http://localhost:8080/chart/genie")
}