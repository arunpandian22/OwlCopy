package com.arun.owlcopyjetpackpractice

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


/**
 * Created by Arun Pandian  on 06/08/22.
 */
object MainDestinations {
    const val ONBOARDING_ROUTE = "onboarding"
    const val COURSES_ROUTE = "courses"
    const val COURSE_DETAIL_ROUTE = "course"
    const val COURSE_DETAIL_ID_KEY = "courseId"
}

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    finishActivity: () -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.COURSES_ROUTE,
    showOnBoardingInitially: Boolean = true
) {

    // Onboarding could be read from shared preferences.
    val onboardingComplete = remember(showOnBoardingInitially) {
        mutableStateOf(!showOnBoardingInitially)
    }

    val actions = remember(navController) {
        MainActions(navController)
    }

   NavHost(navController = navController, startDestination = MainDestinations.ONBOARDING_ROUTE ) {
       composable(MainDestinations.ONBOARDING_ROUTE) {
           // Intercept back in Onboarding : make it finish the activity
           BackHandler {
               finishActivity()
           }
       }
   }


    // used form the courses_route
    val openCourse = { newCourseId: Long, from: NavBackStackEntry ->
        if (from.lifeCycleResumed()) {
            navController.navigate("${MainDestinations.COURSE_DETAIL_ROUTE}/$newCourseId")
        }
    }

}

/**
 * Models the navigation actions in the app
 */
class MainActions(navController: NavHostController) {

    val onboardingComplete: () -> Unit = {
        navController.popBackStack()
    }

    //  used from COURSE_ROUTE
    val openCourse = { newCourseID: Long, from: NavBackStackEntry ->
        // inorder to discard the duplicated navigation events, we check the lifecycle
        if (from.lifeCycleResumed()) {
            navController.navigate("${MainDestinations.COURSE_DETAIL_ROUTE}/$newCourseID")
        }

    }

    //  used from COURSE_DETAIL_ROUTE
    val relatedCourse = { newCourseID: Long, from: NavBackStackEntry ->
        // inorder to discard the duplicated navigation events, we check the lifecycle
        if (from.lifeCycleResumed()) {
            navController.navigate("${MainDestinations.COURSE_DETAIL_ROUTE}/$newCourseID")
        }
    }

    //  used from COURSE_DETAIL_ROUTE
    val upPress: (NavBackStackEntry) -> Unit = { from ->
        // inorder to discard the duplicated navigation events, we check the lifecycle
        if (from.lifeCycleResumed()) {
            navController.navigateUp()
        }
    }

}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifeCycleResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED