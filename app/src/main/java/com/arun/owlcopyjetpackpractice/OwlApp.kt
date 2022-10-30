package com.arun.owlcopyjetpackpractice

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.arun.owlcopyjetpackpractice.ui.CourseTabs
import com.arun.owlcopyjetpackpractice.ui.theme.BlueTheme


/**
 * Created by Arun Pandian  on 01/08/22.
 */
@Composable
fun OwlApp(finishActivity: () -> Unit) {
    BlueTheme() {
        val tabs = remember { CourseTabs.values() }
        val navController = rememberNavController()
        Scaffold(backgroundColor = MaterialTheme.colors.primarySurface, bottomBar = {
            OwlBottomBar(
                navController = navController,
                tabs = tabs
            )
        }) {
            NavGraph(
                finishActivity = finishActivity,
                navController = navController,
                modifier = Modifier.padding(it)
            )
        }

    }
}

@Composable
fun OwlBottomBar(navController: NavController, tabs: Array<CourseTabs>) {

}