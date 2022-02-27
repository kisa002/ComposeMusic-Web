package screens.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Main

@Composable
fun HomeMain() {
    Main(attrs = {
        style {
            display(DisplayStyle.Flex)
            width(100.vw - 280.px - 70.px)
            flexDirection(FlexDirection.Column)
            paddingLeft(280.px)

            margin(35.px)
        }
    }) {
        LargeBanner()
        HomeHotMusic()
    }
}