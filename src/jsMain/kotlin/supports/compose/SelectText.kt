package supports.compose

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import ui.ColorTextUnselected
import ui.ColorWhite

@Composable
fun SelectText(
    text: String,
    selectedColor: CSSColorValue = ColorWhite,
    unselectedColor: CSSColorValue = ColorTextUnselected,
    isSelected: Boolean
) {
    Span(attrs = {
        style {
            color(
                when (isSelected) {
                    true -> selectedColor
                    false -> unselectedColor
                }
            )
        }
    }) {
        Text(text)
    }
}