package screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement
import repository.chart.ChartRepository
import repository.chart.model.Song
import ui.ColorRealWhiteGray
import ui.ColorWhite

val dummyMusicList = listOf(
    Song("이 시간에 rebirth", "제이키드먼(JAY KIDMAN)", "https://image.bugsm.co.kr/album/images/500/4502/450236.jpg"),
    Song("연결고리 (feat. MC Meta)", "일리네어 레코즈(ILLIONAIRE RECORDS)", "https://image.bugsm.co.kr/album/images/200/4310/431088.jpg?version=20190910042521.0"),
    Song("11:11", "일리네어 레코즈(ILLIONAIRE RECORDS)", "https://image.bugsm.co.kr/album/images/200/4310/431088.jpg?version=20190910042521.0"),
    Song("1llusion", "도끼(Dok2)", "https://image.bugsm.co.kr/album/images/200/200368/20036807.jpg?version=20190910044309.0"),
    Song("뭘 알어 (What U Know)", "일리네어 레코즈(ILLIONAIRE RECORDS)", "https://image.bugsm.co.kr/album/images/200/200222/20022245.jpg?version=20190910044137.0"),
    Song("내가 (feat. Beenzino & The Quiett)", "도끼(Dok2)", "https://image.bugsm.co.kr/album/images/200/5126/512606.jpg?version=20190910043131.0"),
    Song("111%", "도끼(Dok2)", "https://image.bugsm.co.kr/album/images/200/5126/512606.jpg?version=20190910043131.0"),
    Song("이끼 (Feat. MINO, BOBBY) (Prod. MINO)", "Mudd the student", "https://image.bugsm.co.kr/album/images/200/204336/20433609.jpg?version=20220125005831.0"),
    Song("\$\$o Dope (feat. Vasco, C Jamm)", "San E(산이)", "https://image.bugsm.co.kr/album/images/200/4985/498549.jpg?version=20210422183751.0"),
    Song("모두가 내 발아래", "San E(산이)", "https://image.bugsm.co.kr/album/images/200/4966/496634.jpg?version=20210422183751.0"),
    Song("10°0' 0° N 118°50 0° E (feat. ASH ISLAND)", "김승민", "https://image.bugsm.co.kr/album/images/200/9713/971373.jpg?version=20211013004414.0"),
    Song("너랑 달라 (한림체육관 X 한요한, 저스디스 (JUSTHIS))", "한요한 , 저스디스(JUSTHIS)", "https://image.bugsm.co.kr/album/images/200/40540/4054060.jpg?version=20210704063548.0")
)

@Composable
fun HomeHotMusic(chartRepository: ChartRepository) {
    val coroutineScope = rememberCoroutineScope()
    val songList = MutableStateFlow<List<Song>>(emptyList())

    Section(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            paddingTop(50.px)
        }
    }) {
        HomeHotMusicTitle()

        HomeHotMusicList {
            songList.collectAsState().value.forEach {
                HomeHotMusicItem(it)
            }
        }
    }

    coroutineScope.launch {
        chartRepository.getMelonChart().let { chart ->
            songList.value = chart
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
fun HomeHotMusicItem(song: Song) {
    Img(attrs = {
        style {
            border {
                width = 0.px
                borderRadius(12.px)
            }
        }
    }, src = song.thumbnail)
    Span (attrs = {
        style {
            display(DisplayStyle.Flex)
            width((14.5).percent)
            flexDirection(FlexDirection.Column)
            marginTop(20.px)
        }
    }) {

        Span(attrs = {
            style {
                fontSize(16.px)
                color(ColorWhite)
                marginTop(10.px)
            }
        }) {
            Text(song.title)
        }

        Span(attrs = {
            style {
                color(ColorRealWhiteGray)
                overflow("hidden")
                whiteSpace("nowrap")
                property("text-overflow", "ellipsis")
            }
        }) {
            Text(song.artist)
        }
    }
}