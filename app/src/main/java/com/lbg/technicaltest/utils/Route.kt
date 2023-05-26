package com.lbg.technicaltest.utils

import com.lbg.technicaltest.utils.CommonConstants.NEWS_HEADLINES_LIST_SCREEN
import com.lbg.technicaltest.utils.CommonConstants.NEWS_ITEM_DETAIL_SCREEN

sealed class Route(val route: String) {
    object NewsHeadlinesListScreen : Route(route = NEWS_HEADLINES_LIST_SCREEN)
    object NewsItemDetailScreen : Route(route = NEWS_ITEM_DETAIL_SCREEN)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
