/**
 * Melodix (C) 2026 — "Feel Every Note"
 * Adapted from OpenTune (GPL-3.0) — see NOTICE.md
 * Liquid-glass backdrop rendering via io.github.kyant0:backdrop.
 */

package com.melodix.music.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.layer.GraphicsLayer
import androidx.compose.ui.graphics.rememberGraphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.kyant.backdrop.backdrops.LayerBackdrop
import com.kyant.backdrop.backdrops.rememberLayerBackdrop
import com.kyant.backdrop.drawBackdrop
import com.kyant.backdrop.effects.blur
import com.kyant.backdrop.effects.colorControls
import com.kyant.backdrop.effects.lens
import com.kyant.backdrop.effects.vibrancy
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import kotlin.math.sign
import com.kyant.backdrop.backdrops.layerBackdrop as nativeBackdrop

typealias PlatformBackdrop = LayerBackdrop

val LocalBackdrop = staticCompositionLocalOf<PlatformBackdrop?> { null }

@Composable
fun rememberBackdrop(): PlatformBackdrop = rememberLayerBackdrop {
    drawRect(Color.Black)
    drawContent()
}

fun Modifier.layerBackdrop(backdrop: PlatformBackdrop): Modifier = this.nativeBackdrop(backdrop)

fun Modifier.drawBackdropCustomShape(
    backdrop: PlatformBackdrop,
    layer: GraphicsLayer,
    luminanceAnimation: Float,
    shape: Shape
): Modifier {
    return this.drawBackdrop(
        backdrop = backdrop,
        effects = {
            val l = (luminanceAnimation * 2f - 1f).let { sign(it) * it * it }
            vibrancy()
            colorControls(
                brightness =
                    if (l > 0f) {
                        lerp(0.1f, 0.5f, l)
                    } else {
                        lerp(0.1f, -0.2f, -l)
                    },
                contrast =
                    if (l > 0f) {
                        lerp(1f, 0f, l)
                    } else {
                        1f
                    },
                saturation = 1.5f,
            )
            blur(
                if (l > 0f) {
                    lerp(8f.dp.toPx(), 16f.dp.toPx(), l)
                } else {
                    lerp(8f.dp.toPx(), 2f.dp.toPx(), -l)
                },
            )
            lens(24f.dp.toPx(), size.minDimension / 2f, true)
        },
        onDrawBackdrop = { drawBackdrop ->
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                drawBackdrop()
            }
        },
        shape = { shape },
        onDrawSurface = {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                drawRect(Color.Black.copy(alpha = 0.1f))
            } else {
                // Fallback for Android 11 and below since RenderEffect blur isn't supported
                drawRect(Color(0xE6121212))
            }
        }
    )
}

/**
 * Melodix glass surface: prefers OpenTune-exact backdrop glass, falls back to
 * haze blur when no backdrop is provided, no-op when disabled.
 */
@Composable
fun Modifier.melodixGlass(
    enabled: Boolean,
    shape: Shape,
    hazeState: HazeState? = null,
): Modifier {
    val backdrop = LocalBackdrop.current
    val layer = rememberGraphicsLayer()
    return when {
        !enabled -> this
        backdrop != null -> drawBackdropCustomShape(backdrop, layer, 0.35f, shape)
        hazeState != null -> hazeEffect(hazeState)
        else -> this
    }
}
