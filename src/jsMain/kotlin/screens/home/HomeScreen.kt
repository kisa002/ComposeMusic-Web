package screens.home

import androidx.compose.runtime.Composable
import repository.chart.impl.ChartRepositoryImpl
import supports.compose.Body

@Composable
fun HomeScreen() {
    val chartRepositoryImpl = ChartRepositoryImpl()

    Body {
        HomeHeader()
        HomeSidebar()
        HomeMain(chartRepositoryImpl)
    }
}