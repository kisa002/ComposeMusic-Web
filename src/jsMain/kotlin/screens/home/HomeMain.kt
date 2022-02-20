package screens.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Main

@Composable
fun HomeMain() {
    Main(attrs = {
        style {
            width(100.vw)
            display(DisplayStyle.Flex)
        }
    }) {
        LargeBanner()
    }
}