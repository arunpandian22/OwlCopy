package com.arun.owlcopyjetpackpractice.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.arun.owlcopyjetpackpractice.R


/**
 * Created by Arun Pandian  on 04/08/22.
 */

enum class CourseTabs(@StringRes val title: Int, @DrawableRes val icon: Int, val route: String) {
    MY_COURSES(R.string.my_courses, R.drawable.ic_grain, CoursesDestinations.MY_COURSES_ROUTE),
    FEATURED(R.string.featured, R.drawable.ic_featured, CoursesDestinations.FEATURED_ROUTE),
    SEARCH(R.string.search, R.drawable.ic_search, CoursesDestinations.SEARCH_COURSES_ROUTE)
}

/**
 * Destinations used in the ([OwlApp]).
 */
private object CoursesDestinations {
    const val FEATURED_ROUTE = "courses/featured"
    const val MY_COURSES_ROUTE = "courses/my"
    const val SEARCH_COURSES_ROUTE = "courses/search"
}