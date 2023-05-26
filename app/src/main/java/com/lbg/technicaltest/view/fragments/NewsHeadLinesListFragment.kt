package com.lbg.technicaltest.view.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.lbg.technicaltest.model.Article
import com.lbg.technicaltest.model.NewsHeadlinesResponse
import com.lbg.technicaltest.network.Resource
import com.lbg.technicaltest.utils.Route
import com.lbg.technicaltest.view.ui.theme.TechnicalTestTheme
import com.lbg.technicaltest.viewmodel.NewsHeadLinesListViewModel

@Composable
fun NewsHeadLinesListFragment(
    modifier: Modifier = Modifier,
    newsHeadLinesListViewModel: NewsHeadLinesListViewModel = viewModel(),
    onClickToNewsDetailScreen: (Int) -> Unit = {},
    navController: NavHostController
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        newsHeadLinesListViewModel.getNewsHeadlinesData()
        subscribeToAPICall(newsHeadLinesListViewModel, onClickToNewsDetailScreen, navController)
    }
}

@Composable
fun headlinesList(
    headLineItem: Article,
    index: Int,
    onClickToNewsDetailScreen: (Int) -> Unit,
    navController: NavHostController
) {
    val imageData = rememberAsyncImagePainter(
        model = headLineItem.urlToImage
    )
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                //onClickToNewsDetailScreen.invoke(index)
                navController.navigate(
                    Route.NewsItemDetailScreen.withArgs(
                        "Author : "+headLineItem.author,
                        headLineItem.title,
                        headLineItem.description
                    )
                )
            }
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Image(
                    painter = imageData,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(1.dp, MaterialTheme.colors.secondary, CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(
                        text = headLineItem.author,
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = headLineItem.title,
                        style = MaterialTheme.typography.subtitle1.copy(
                            fontWeight = FontWeight.Light
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
fun subscribeToAPICall(
    newsHeadLinesListViewModel: NewsHeadLinesListViewModel,
    onClickToNewsDetailScreen: (Int) -> Unit,
    navController: NavHostController
) {
    when (val newsListResponse = newsHeadLinesListViewModel.newsHeadlinesResponse.value) {
        is Resource.Success -> {
            recyclerViewUI(newsListResponse.data, onClickToNewsDetailScreen, navController)
        }
        is Resource.Loading -> {}
        is Resource.Error -> {}
        else -> {}
    }
}

@Composable
fun recyclerViewUI(
    data: NewsHeadlinesResponse?,
    onClickToNewsDetailScreen: (Int) -> Unit,
    navController: NavHostController
) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        itemsIndexed(items = data?.articles ?: emptyList()) { index, article ->
            headlinesList(headLineItem = article, index, onClickToNewsDetailScreen, navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsHeadLinesListFragmentPreview() {
    TechnicalTestTheme {

    }
}
