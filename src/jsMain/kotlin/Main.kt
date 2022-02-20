import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import colors.ColorBlue
import colors.ColorPrimary
import colors.ColorTextUnselected
import colors.ColorWhite
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.CSSAutoKeyword
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.*
import kotlin.js.Console

fun main() {
    renderComposable(rootElementId = "root") {
        Body {
            HeaderGroup {
                HeaderNavList {
                    HeaderNavItem("Profile", false)
                    HeaderNavItem("About", false)
                    HeaderNavItem("Manage", false)
                }

                SearchField()
            }
            Sidebar()
            Main()
        }
    }
}

@Composable
fun Body(content: ContentBuilder<HTMLDivElement>) {
    Div(attrs = {
        style {
            width(100.vw)
            height(100.vh)
            backgroundColor(ColorPrimary)
            padding(0.px)
        }
    }, content = content)
}

@Composable
fun HeaderGroup(content: ContentBuilder<HTMLElement>) {
    Header(attrs = {
        style {
            width(auto)
            height(70.px)
            paddingLeft(280.px)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            alignItems(AlignItems.Center)

            borderBottom(1.px, LineStyle.Solid, Color("#222227"))
        }
    }, content = content)
}

@Composable
fun HeaderNavList(content: ContentBuilder<HTMLElement>) {
    Nav(attrs = {
        style {
            display(DisplayStyle.Flex)
            height(100.percent)
            paddingLeft(30.px)
            flexDirection(FlexDirection.Row)
            justifyContent(JustifyContent.FlexStart)
            alignItems(AlignItems.Center)
        }
    }, content = content)
}

@Composable
fun HeaderNavItem(text: String, isSelected: Boolean) {
    A(attrs = {
        style {
            marginRight(30.px)
        }
    }) {
        SelectText(text, isSelected)
    }
}

@Composable
fun Sidebar() {
    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
            position(Position.Fixed)
            flexDirection(FlexDirection.Column)
            top(0.px)
            width(280.px)
            height(100.vh)
            backgroundColor(ColorPrimary)
            borderRight(1.px, LineStyle.Solid, Color("#222227"))
            borderBottom(1.px, LineStyle.Solid, Color("#222227"))
        }
    }) {
        SidebarLogo(content = {
            Text("Jetpack Compose")
        })
        SidebarList {
            SidebarItem("Home", true)
            SidebarItem("Chart", false)
            SidebarItem("Notice", false)
        }
    }
}

@Composable
fun SidebarLogo(content: ContentBuilder<HTMLSpanElement>) {
    Div(attrs = {
        style {
            width(280.px)
            height(70.px)
            display(DisplayStyle.Flex)
            // justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            borderBottom(1.px, LineStyle.Solid, Color("#222227"))
        }
    }) {
        Span(attrs = {
            style {
                color(ColorBlue)
                fontWeight("Bold")
                marginLeft(40.px)
            }
        }, content = content)
    }
}

@Composable
fun SidebarList(content: ContentBuilder<HTMLUListElement>) {
    Ul(attrs = {
        style {
            listStyle("none")
        }
    }, content = content)
}

@Composable
fun SidebarItem(text: String, isSelected: Boolean) {
    Li(attrs = { style { marginBottom(15.px) } }) {
        SelectText(text, isSelected)
    }
}

@Composable
fun SelectText(text: String, isSelected: Boolean) {
    Span(attrs = {
        style {
            color(
                when (isSelected) {
                    true -> ColorWhite
                    false -> ColorTextUnselected
                }
            )
        }
    }) {
        Text(text)
    }
}

@Composable
fun SearchField() {
    val keyword by mutableStateOf("afaf")

    Form(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Row)
            alignItems(AlignItems.Center)
            backgroundColor(Color("#222222"))
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
                placeholder("노래 제목으로 검색")
                color(ColorWhite)
                background("none")
            }

            onInput {
                console.log(it.value)
            }
        })

        FontAwesome("fas", "fa-search", attrs = {
            style {
                color(Color("#7F7F7F"))
            }
        })
    }
}

@Composable
fun FontAwesome(vararg classes: String, attrs: AttrBuilderContext<HTMLElement>, content: ContentBuilder<HTMLElement>? = null) {
    I(attrs = {
        classes(*classes)
        attrs()
    }, content = content)
}

@Composable
fun LargeBanner() {
    Div(attrs = {
        style {
            width(100.percent)
            height(460.px)
            background("url(\"large_banner.jpg\") center bottom 45% / cover no-repeat")
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
                    Text("Jetpack Composes")
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

@Composable
fun Main() {
    Div(attrs = {
        style {
            width(100.vw)
            display(DisplayStyle.Flex)
        }
    }) {
        LargeBanner()
    }
}

@Composable
private fun Test() {
    var count: Int by mutableStateOf(0)

    Div({
        style {
            padding(25.px)
            font("/fonts/Pretendard-Black")
        }
    }) {
        Button(attrs = {
            onClick { count -= 1 }
        }) {
            Text("-")
        }

        Span({ style { padding(15.px) } }) {
            Text("$count")
        }

        Div(attrs = {
            style {
                fontFamily("Pretendard")
                fontSize(14.px)
            }
        }) {
            Text("이거 글자 바뀌었을까?")
        }

        Button(attrs = {
            onClick { count += 1 }
        }) {
            Text("+")
        }
    }
}