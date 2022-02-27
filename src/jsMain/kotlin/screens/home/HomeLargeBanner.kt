package screens.home

import androidx.compose.runtime.Composable
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import ui.ColorButtonGreen
import ui.ColorFadeBlack
import ui.ColorWhite
import ui.component.RoundedButton

@Composable
fun LargeBanner() {
    Div(attrs = {
        style {
            height(420.px)
            background("url(\"./images/large_banner.jpg\") center bottom 45% / cover no-repeat")

            border {
                width = 0.px
                borderRadius(12.px)
            }
        }
    }) {
        Div(attrs = {
            style {
                width(100.percent)
                height(100.percent)
                backgroundColor(ColorFadeBlack)

                border {
                    width = 0.px
                    borderRadius(12.px)
                }
            }
        }) {
            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    padding(60.px)
                }
            }) {
                Div(attrs = {
                    style {
                        color(ColorWhite)
                        fontSize(0.8.em + 0.8.vw)
                    }
                }) {
                    Text("당신이 찾고있는")
                    Br()
                    Text("당신이 원하는 음악")
                }

                Div(attrs = {
                    style {
                        color(ColorWhite)
                        fontWeight("bold")
                        fontSize((1.2).em + (1.2).vw)
                    }
                }) {
                    Text("Jetpack Compose")
                }

                RoundedButton("Play Now") {
                    window.alert("Play Now")
                }
            }
        }
    }
}