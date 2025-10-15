package com.luis.smallnews.presentation.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.luis.smallnews.domain.models.ArticleModel
import com.luis.smallnews.presentation.states.TopHeadState

@Composable
fun MainScreen(navigateToDetain: (ArticleModel) -> Unit) {

    val viewModel: MainViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state.value) {
            TopHeadState.Loading -> {
                CircularProgressIndicator()
            }

            is TopHeadState.Error -> {
                val error = (state.value as TopHeadState.Error)
                Text(
                    text = error.error,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            is TopHeadState.Success -> {
                val data = (state.value as TopHeadState.Success).listArticles

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "E.E.U.U. News",
                        style = TextStyle(fontSize = 25.sp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )

                    LazyColumn {
                        var index = 0
                        items(data) { article ->
                            ArticleItem(
                                article = article,
                                index = index,
                                onClick = { navigateToDetain(article) }
                            )
                            index++
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleItem(article: ArticleModel, index: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .background(
                when (index % 2 == 0) {
                    true -> Color.Gray
                    false -> Color.White
                }
            )
            .padding(5.dp)
    ) {
        Text(article.title, style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold))
        Text(
            article.description,
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal)
        )
        Spacer(Modifier.size(5.dp))
        Text(
            article.author,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic
            )
        )
        Spacer(Modifier.size(10.dp))
    }
}