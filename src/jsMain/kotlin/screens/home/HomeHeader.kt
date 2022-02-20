package screens.home

import androidx.compose.runtime.Composable
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav
import org.w3c.dom.HTMLElement
import supports.compose.SelectText
import supports.compose.borderBottom
import ui.ColorBorder
import ui.component.SearchField

@Composable
fun HomeHeader() {
    HeaderGroup {
        HeaderNavList {
            HeaderNavItem("Profile", false)
            HeaderNavItem("About", false)
            HeaderNavItem("Manage", false)
        }

        SearchField(placeholder = "노래 제목으로 검색") {

        }
    }
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

            borderBottom(1.px, LineStyle.Solid, ColorBorder)
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
        SelectText(text = text, isSelected = isSelected)
    }
}