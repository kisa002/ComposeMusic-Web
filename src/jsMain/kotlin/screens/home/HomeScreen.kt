package screens.home

import androidx.compose.runtime.Composable
import supports.compose.Body

@Composable
fun HomeScreen() {
    Body {
        HomeHeader()
        HomeSidebar()
        HomeMain()
    }
}