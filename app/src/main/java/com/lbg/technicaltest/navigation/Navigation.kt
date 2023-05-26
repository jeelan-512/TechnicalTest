package com.lbg.technicaltest.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lbg.technicaltest.utils.CommonConstants.AUTHOR
import com.lbg.technicaltest.utils.CommonConstants.DESCRIPTION_KEY
import com.lbg.technicaltest.utils.CommonConstants.TITLE
import com.lbg.technicaltest.utils.Route
import com.lbg.technicaltest.view.fragments.NewsHeadLinesListFragment
import com.lbg.technicaltest.view.fragments.NewsItemDetailFragment

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.NewsHeadlinesListScreen.route
    ) {
        composable(route = Route.NewsHeadlinesListScreen.route) {
            NewsHeadLinesListFragment(
                navController = navController
            )
        }

        composable(
            route = Route.NewsItemDetailScreen.route + "/{Author}/{Title}/{Description}",
            arguments = listOf(
                navArgument(AUTHOR) {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument(TITLE) {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument(DESCRIPTION_KEY) {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { data ->
            val author: String? = data.arguments?.getString(AUTHOR)
            val title: String? = data.arguments?.getString(TITLE)
            val description: String? = data.arguments?.getString(DESCRIPTION_KEY)
            NewsItemDetailFragment(modifier = Modifier, author, title, description)
        }
    }
}