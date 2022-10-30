package com.arun.owlcopyjetpackpractice.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * Created by Arun Pandian  on 15/10/22.
 */

@Immutable
data class Images(@DrawableRes val lockupLogo: Int)

internal val LocalImages = staticCompositionLocalOf<Images> {
    error("No local Images specified")
}