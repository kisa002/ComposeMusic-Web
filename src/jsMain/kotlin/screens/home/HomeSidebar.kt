package screens.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.HTMLUListElement
import supports.compose.SelectText
import supports.compose.borderBottom
import supports.compose.borderRight
import ui.ColorBlue
import ui.ColorBorder
import ui.ColorPrimary

@Composable
fun HomeSidebar() {
    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
            position(Position.Fixed)
            flexDirection(FlexDirection.Column)
            top(0.px)
            width(280.px)
            height(100.vh)
            backgroundColor(ColorPrimary)
            borderRight(1.px, LineStyle.Solid, ColorBorder)
            borderBottom(1.px, LineStyle.Solid, ColorBorder)
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
            borderBottom(1.px, LineStyle.Solid, ColorBorder)
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
        SelectText(text = text, isSelected = isSelected)
    }
}