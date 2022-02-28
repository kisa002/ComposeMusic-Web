package repository.chart.impl

import repository.chart.ChartRepository
import repository.chart.model.Song
import utils.HttpRequest

class ChartRepositoryImpl : ChartRepository {
    val httpRequest = HttpRequest()

    override suspend fun getMelonChart(): List<Song> = httpRequest.requestGet("http://localhost:8080/chart/melon")

    override suspend fun getBugsChart(): List<Song> = httpRequest.requestGet("http://localhost:8080/chart/bugs")

    override suspend fun getGenieChart(): List<Song> = httpRequest.requestGet("http://localhost:8080/chart/genie")
}