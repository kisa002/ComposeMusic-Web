import org.jetbrains.compose.web.renderComposable
import screens.home.HomeScreen

fun main() {
    renderComposable(rootElementId = "root") {
        HomeScreen()
    }
}