package supports.compose

import org.jetbrains.compose.web.css.*

fun StyleBuilder.borderTop(width: CSSNumeric, lineStyle: LineStyle, color: CSSColorValue) {
    property("border-top", "$width $lineStyle $color")
}

fun StyleBuilder.borderRight(width: CSSNumeric, lineStyle: LineStyle, color: CSSColorValue) {
    property("border-right", "$width $lineStyle $color")
}

fun StyleBuilder.borderBottom(width: CSSNumeric, lineStyle: LineStyle, color: CSSColorValue) {
    property("border-bottom", "$width $lineStyle $color")
}

fun StyleBuilder.borderLeft(width: CSSNumeric, lineStyle: LineStyle, color: CSSColorValue) {
    property("border-left", "$width $lineStyle $color")
}

