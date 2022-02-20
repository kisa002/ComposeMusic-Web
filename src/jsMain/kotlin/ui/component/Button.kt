package ui.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import ui.ColorButtonGreen
import ui.ColorWhite

@Composable
fun RoundedButton(text: String, onClick: () -> Unit) {
    Button(attrs = {
        style {
            width(160.px)
            height(50.px)
            backgroundColor(ColorButtonGreen)
            color(ColorWhite)
            fontWeight(600)
            marginTop(20.px)
            fontSize(0.45.em + 0.45.vw)

            border {
                width = 0.px
                borderRadius(12.px)
            }
        }

        onClick {
            onClick()
        }
    }) {
        Text(text)
    }
}