package com.arun.owlcopyjetpackpractice.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arun.owlcopyjetpackpractice.R
import com.arun.owlcopyjetpackpractice.ui.theme.OwlTheme
import com.arun.owlcopyjetpackpractice.ui.theme.YellowTheme


/**
 * Created by Arun Pandian  on 15/10/22.
 */
@Composable
fun Onboarding(onBoardingComplete: () -> Unit) {
    YellowTheme {
        Scaffold(
            topBar = { AppBar() },
            backgroundColor = MaterialTheme.colors.primarySurface,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.navigationBarsPadding()
                ) {
                    Icon(
                        painterResource(id = R.drawable.explore),
                        contentDescription = stringResource(id = R.string.label_continue_to_courses)
                    )
                }
            }) { paddingValue ->
            Column(
                modifier = Modifier
                    .statusBarsPadding()
                    .navigationBarsPadding()
                    .padding(paddingValue)
            ) {
                Text(text = stringResource(id = R.string.choose_topics_that_interest_you), style = MaterialTheme.typography.h4, textAlign = TextAlign.End, modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp))


            }
        }

    }
}

@Composable
private fun AppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = OwlTheme.images.lockupLogo),
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
        IconButton(modifier = Modifier.padding(16.dp), onClick = {

        }) {
            Icon(imageVector = Icons.Filled.Settings, contentDescription = "description")
        }

    }
}

@Preview(name = "Onboarding", showSystemUi = true, showBackground = true)
@Composable
private fun OnboardingPreview() {
    Onboarding({})

}