package screens.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import ui.ColorWhite

@Composable
fun LargeBanner() {
    Div(attrs = {
        style {
            width(100.percent)
            height(460.px)
            background("url(\"./images/large_banner.jpg\") center bottom 45% / cover no-repeat")
            margin(20.px, 20.px, 0.px, 280.px + 20.px)

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
                backgroundColor(Color("#00000088"))

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

                Button(attrs = {
                    style {
                        width(160.px)
                        height(50.px)
                        backgroundColor(Color("#25a56a"))
                        color(ColorWhite)
                        fontWeight(600)
                        marginTop(20.px)
                        fontSize(0.45.em + 0.45.vw)

                        border {
                            width = 0.px
                            borderRadius(12.px)
                        }
                    }
                }) {
                    Text("Play Now")
                }
            }
        }
    }
}