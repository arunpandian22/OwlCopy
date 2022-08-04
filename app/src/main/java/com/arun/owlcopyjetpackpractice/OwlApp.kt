package com.arun.owlcopyjetpackpractice

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.arun.owlcopyjetpackpractice.ui.CourseTabs
import com.arun.owlcopyjetpackpractice.ui.theme.BlueTheme


/**
 * Created by Arun Pandian  on 01/08/22.
 */
@Composable
fun OwlApp(finishActivity: () -> Unit) {
    BlueTheme() {
        val tabs = remember { CourseTabs.values() }
//        val navController =  remembe

    }

}