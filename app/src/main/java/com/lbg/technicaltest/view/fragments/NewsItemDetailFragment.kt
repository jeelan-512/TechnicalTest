package com.lbg.technicaltest.view.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lbg.technicaltest.view.ui.theme.TechnicalTestTheme

@Composable
fun NewsItemDetailFragment(
    modifier: Modifier,
    author: String?,
    title: String?,
    description: String?
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        detailsPageData(author, title, description)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun detailsPageData(author: String?, title: String?, description: String?) {
    Card(modifier = Modifier) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = author ?: "",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title ?: "",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = description ?: "",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsItemDetailFragmentPreview() {
    TechnicalTestTheme {
     //   NewsItemDetailFragment(modifier = Modifier, article = article)
    }
}