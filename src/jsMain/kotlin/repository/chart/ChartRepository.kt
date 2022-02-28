package repository.chart

import repository.chart.model.Song

interface ChartRepository {
    suspend fun getMelonChart(): List<Song>
    suspend fun getBugsChart(): List<Song>
    suspend fun getGenieChart(): List<Song>
}