package repository.chart

import repository.chart.model.Song

interface ChartRepository {
    suspend fun getMelonChart(): List<Song>
}