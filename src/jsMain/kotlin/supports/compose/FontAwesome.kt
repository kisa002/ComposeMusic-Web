package supports.compose

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.I
import org.w3c.dom.HTMLElement

@Composable
fun FontAwesome(vararg classes: String, attrs: AttrBuilderContext<HTMLElement>, content: ContentBuilder<HTMLElement>? = null) {
    I(attrs = {
        classes(*classes)
        attrs()
    }, content = content)
}