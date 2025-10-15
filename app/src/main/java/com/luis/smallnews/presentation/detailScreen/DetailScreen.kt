package com.luis.smallnews.presentation.detailScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.luis.smallnews.domain.models.ArticleModel
import com.luis.smallnews.presentation.states.ArticleState

@Composable
fun DetailScreen(
    viewModel: DetailViewModel
) {
    val state = viewModel.state.collectAsState()

    val urlHandler = LocalUriHandler.current
    when (state.value) {
        is ArticleState.Article -> {
            val articleModel = (state.value as ArticleState.Article).data

            articleModel?.let { article: ArticleModel ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Text(
                        text = article.title,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    )

                    AsyncImage(
                        model = article.urlToImage,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Text(
                        text = article.author,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Italic
                        )
                    )

                    Text(
                        text = article.content,
                        style = TextStyle(fontSize = 15.sp)
                    )

                    Text(
                        text = "Tab here to read more",
                        style = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
                        modifier = Modifier.clickable {
                            urlHandler.openUri(article.urlNews)
                        }
                    )

                }
            }
        }
    }

}