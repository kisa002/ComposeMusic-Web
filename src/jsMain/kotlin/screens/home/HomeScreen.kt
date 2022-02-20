package screens.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import supports.compose.Body

@Composable
fun HomeScreen() {
    Body {
        HomeHeader()
        HomeSidebar()
        HomeMain()
    }
}