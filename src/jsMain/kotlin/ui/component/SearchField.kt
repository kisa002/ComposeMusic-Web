package ui.component

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Input
import supports.compose.FontAwesome
import ui.ColorSearchFieldBackground
import ui.ColorWhite
import ui.ColorWhiteGray

@Composable
fun SearchField(placeholder: String = "") {
    Form(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            alignItems(AlignItems.Center)
            backgroundColor(ColorSearchFieldBackground)
            border {
                width = 0.px
                borderRadius(12.px)
            }
            padding(0.px, 20.px, 0.px, 20.px)
        }
    }) {
        Input(type = InputType.Search, attrs = {
            style {
                padding(10.px, 0.px, 10.px, 0.px)
                border(0.px)
                placeholder(placeholder)
                color(ColorWhite)
                background("none")
            }

            onInput {
                console.log(it.value)
            }
        })

        FontAwesome("fas", "fa-search", attrs = {
            style {
                color(ColorWhiteGray)
            }
        })
    }
}