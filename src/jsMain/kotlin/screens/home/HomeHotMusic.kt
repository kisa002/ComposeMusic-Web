package screens.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement
import ui.ColorRealWhiteGray
import ui.ColorWhite

@Composable
fun HomeHotMusic() {
    Section(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            paddingTop(60.px)
        }
    }) {
        HomeHotMusicTitle()

        HomeHotMusicList {
            for (i in 0..17) {
                HomeHotMusicItem()
            }
        }
    }
}

@Composable
fun HomeHotMusicTitle() {
    Div(attrs = {
        style {
            color(ColorWhite)
            fontSize(30.px)
        }
    }) {
        Text("핫한 음악")
    }
}

@Composable
fun HomeHotMusicList(content: ContentBuilder<HTMLDivElement>) {
    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.SpaceBetween)
            flexWrap(FlexWrap.Wrap)
            marginTop(10.px)
        }
    }, content = content)
}

@Composable
fun HomeHotMusicItem() {
    Span (attrs = {
        style {
            display(DisplayStyle.Flex)
            maxWidth(15.percent)
            flexDirection(FlexDirection.Column)
            marginTop(20.px)
        }
    }) {
        Img(attrs = {
            style {
                border {
                    width = 0.px
                    borderRadius(12.px)
                }
            }
        }, src = "https://image.bugsm.co.kr/album/images/500/4502/450236.jpg")

        Span(attrs = {
            style {
                fontSize(16.px)
                color(ColorWhite)
                marginTop(10.px)
            }
        }) {
            Text("이 시간에 rebirth")
        }

        Span(attrs = {
            style {
                color(ColorRealWhiteGray)
                overflow("hidden")
                whiteSpace("nowrap")
                property("text-overflow", "ellipsis")
            }
        }) {
            Text("제이키드먼(JAY KIDMAN)")
        }
    }
}