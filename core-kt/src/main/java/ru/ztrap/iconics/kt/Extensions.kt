/*
 * Copyright (c) 2018 zTrap
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.ztrap.iconics.kt

import android.content.Context
import android.content.ContextWrapper
import android.content.res.ColorStateList
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Typeface
import android.os.Build
import android.support.v4.graphics.drawable.IconCompat
import android.support.v4.view.LayoutInflaterCompat
import android.support.v7.app.AppCompatDelegate
import android.text.Spanned
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsArrayBuilder
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.context.IconicsContextWrapper
import com.mikepenz.iconics.context.IconicsLayoutInflater
import com.mikepenz.iconics.context.IconicsLayoutInflater2
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.utils.IconicsMenuInflaterUtil

/**
 * Adaptation for [IconicsContextWrapper]
 * */
fun Context.wrapByIconics(): ContextWrapper {
    return IconicsContextWrapper.wrap(this)
}

/**
 * Compatible adaptation for setting IconicsLayoutInflater
 * @see IconicsLayoutInflater
 * @see IconicsLayoutInflater2
 * */
@Suppress("DEPRECATION")
fun LayoutInflater.setIconicsFactory(appCompatDelegate: AppCompatDelegate) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LayoutInflaterCompat.setFactory2(this, IconicsLayoutInflater2(appCompatDelegate))
    } else {
        LayoutInflaterCompat.setFactory(this, IconicsLayoutInflater(appCompatDelegate))
    }
}

/**
 * Adaptation for [IconicsMenuInflaterUtil.inflate]
 * */
fun MenuInflater.inflateWithIconics(
    context: Context,
    menuId: Int,
    menu: Menu,
    checkSubMenu: Boolean = false
) {
    IconicsMenuInflaterUtil.inflate(this, context, menuId, menu, checkSubMenu)
}

/**
 * Adaptation for [Iconics.IconicsBuilder] with auto-executing [Iconics.IconicsBuilderString.build]
 * */
fun Context.iconicsBuilder(
    block: Iconics.IconicsBuilder.() -> Iconics.IconicsBuilderString
): Spanned {
    val builder = Iconics.IconicsBuilder().ctx(this)
    return block(builder).build()
}

/**
 * Adaptation for [Iconics.IconicsBuilder] with auto-executing [Iconics.IconicsBuilderView.build]
 * */
fun Context.iconicsBuilder(block: Iconics.IconicsBuilder.() -> Iconics.IconicsBuilderView) {
    val builder = Iconics.IconicsBuilder().ctx(this)
    block(builder).build()
}

/**
 * Adaptation for [IconicsArrayBuilder] with auto-executing [IconicsArrayBuilder.build]
 * */
fun IconicsDrawable.createArray(
    block: IconicsArrayBuilder.() -> IconicsArrayBuilder
): Array<IconicsDrawable> {
    val builder = IconicsArrayBuilder(this)
    return block(builder).build()
}

/**
 * Pretty converter to [android.support.v4.graphics.drawable.IconCompat]
 *
 * Note: use [IconCompat.toIcon] to transform into Platform's Icon
 * */
fun IconicsDrawable.toAndroidIconCompat(): IconCompat {
    return IconCompat.createWithBitmap(toBitmap())
}

// region icon
/**
 * @see IconicsDrawable.icon
 */
@JvmName("iconFromString")
fun IconicsDrawable.icon(iconProducer: () -> String): IconicsDrawable {
    return icon(iconProducer())
}

/**
 * @see IconicsDrawable.icon
 */
@JvmName("iconFromChar")
fun IconicsDrawable.icon(iconProducer: () -> Char): IconicsDrawable {
    return icon(iconProducer())
}

/**
 * @see IconicsDrawable.icon
 */
fun IconicsDrawable.icon(iconProducer: () -> IIcon): IconicsDrawable {
    return icon(iconProducer())
}
// endregion

// region iconText
/**
 * @see IconicsDrawable.iconText
 */
@JvmName("iconTextFromString")
fun IconicsDrawable.iconText(iconTextProducer: () -> String): IconicsDrawable {
    return iconText(iconTextProducer())
}
// endregion

// region color
/**
 * @see IconicsDrawable.colorRes
 */
fun IconicsDrawable.colorRes(colorResProducer: () -> Int): IconicsDrawable {
    return colorRes(colorResProducer())
}

/**
 * @see IconicsDrawable.colorListRes
 */
fun IconicsDrawable.colorListRes(colorListResProducer: () -> Int): IconicsDrawable {
    return colorListRes(colorListResProducer())
}

/**
 * @see IconicsDrawable.color
 */
@JvmName("color")
fun IconicsDrawable.color(colorProducer: () -> Int): IconicsDrawable {
    return color(colorProducer())
}

/**
 * @see IconicsDrawable.color
 */
@JvmName("colorStateList")
fun IconicsDrawable.color(colorListProducer: () -> ColorStateList): IconicsDrawable {
    return color(colorListProducer())
}
// endregion

// region iconOffsetX
/**
 * @see IconicsDrawable.iconOffsetXRes
 */
fun IconicsDrawable.iconOffsetXRes(iconOffsetXResProducer: () -> Int): IconicsDrawable {
    return iconOffsetXRes(iconOffsetXResProducer())
}

/**
 * @see IconicsDrawable.iconOffsetXRes
 */
fun IconicsDrawable.iconOffsetXDp(iconOffsetXDpProducer: () -> Int): IconicsDrawable {
    return iconOffsetXDp(iconOffsetXDpProducer())
}

/**
 * @see IconicsDrawable.iconOffsetXRes
 */
fun IconicsDrawable.iconOffsetXPx(iconOffsetXPxProducer: () -> Int): IconicsDrawable {
    return iconOffsetXPx(iconOffsetXPxProducer())
}
// endregion

// region iconOffsetY
/**
 * @see IconicsDrawable.iconOffsetYRes
 */
fun IconicsDrawable.iconOffsetYRes(iconOffsetYResProducer: () -> Int): IconicsDrawable {
    return iconOffsetYRes(iconOffsetYResProducer())
}

/**
 * @see IconicsDrawable.iconOffsetYDp
 */
fun IconicsDrawable.iconOffsetYDp(iconOffsetYDpProducer: () -> Int): IconicsDrawable {
    return iconOffsetYDp(iconOffsetYDpProducer())
}

/**
 * @see IconicsDrawable.iconOffsetYPx
 */
fun IconicsDrawable.iconOffsetYPx(iconOffsetYPxProducer: () -> Int): IconicsDrawable {
    return iconOffsetYPx(iconOffsetYPxProducer())
}
// endregion

// region padding
/**
 * @see IconicsDrawable.paddingRes
 */
fun IconicsDrawable.paddingRes(paddingResProducer: () -> Int): IconicsDrawable {
    return paddingRes(paddingResProducer())
}

/**
 * @see IconicsDrawable.paddingDp
 */
fun IconicsDrawable.paddingDp(paddingDpProducer: () -> Int): IconicsDrawable {
    return paddingDp(paddingDpProducer())
}

/**
 * @see IconicsDrawable.paddingPx
 */
fun IconicsDrawable.paddingPx(paddingPxProducer: () -> Int): IconicsDrawable {
    return paddingPx(paddingPxProducer())
}
// endregion

// region size
/**
 * @see IconicsDrawable.sizeRes
 */
fun IconicsDrawable.sizeRes(sizeResProducer: () -> Int): IconicsDrawable {
    return sizeRes(sizeResProducer())
}

/**
 * @see IconicsDrawable.sizeDp
 */
fun IconicsDrawable.sizeDp(sizeDpProducer: () -> Int): IconicsDrawable {
    return sizeDp(sizeDpProducer())
}

/**
 * @see IconicsDrawable.sizePx
 */
fun IconicsDrawable.sizePx(sizePxProducer: () -> Int): IconicsDrawable {
    return sizePx(sizePxProducer())
}
// endregion

// region sizeX
/**
 * @see IconicsDrawable.sizeResX
 */
fun IconicsDrawable.sizeResX(sizeResXProducer: () -> Int): IconicsDrawable {
    return sizeResX(sizeResXProducer())
}

/**
 * @see IconicsDrawable.sizeDpX
 */
fun IconicsDrawable.sizeDpX(sizeDpXProducer: () -> Int): IconicsDrawable {
    return sizeDpX(sizeDpXProducer())
}

/**
 * @see IconicsDrawable.sizePxX
 */
fun IconicsDrawable.sizePxX(sizePxXProducer: () -> Int): IconicsDrawable {
    return sizePxX(sizePxXProducer())
}
// endregion

// region sizeY
/**
 * @see IconicsDrawable.sizeResY
 */
fun IconicsDrawable.sizeResY(sizeResYProducer: () -> Int): IconicsDrawable {
    return sizeResY(sizeResYProducer())
}

/**
 * @see IconicsDrawable.sizeDpY
 */
fun IconicsDrawable.sizeDpY(sizeDpYProducer: () -> Int): IconicsDrawable {
    return sizeDpY(sizeDpYProducer())
}

/**
 * @see IconicsDrawable.sizePxY
 */
fun IconicsDrawable.sizePxY(sizePxYProducer: () -> Int): IconicsDrawable {
    return sizePxY(sizePxYProducer())
}
// endregion

// region backgroundContourColor
/**
 * @see IconicsDrawable.backgroundContourColorRes
 */
fun IconicsDrawable.backgroundContourColorRes(
    backgroundContourColorResProducer: () -> Int
): IconicsDrawable {
    return backgroundContourColorRes(backgroundContourColorResProducer())
}

/**
 * @see IconicsDrawable.backgroundContourColor
 */
fun IconicsDrawable.backgroundContourColor(
    backgroundContourColorProducer: () -> Int
): IconicsDrawable {
    return backgroundContourColor(backgroundContourColorProducer())
}
// endregion

// region contourColor
/**
 * @see IconicsDrawable.contourColorRes
 */
fun IconicsDrawable.contourColorRes(contourColorResProducer: () -> Int): IconicsDrawable {
    return contourColorRes(contourColorResProducer())
}

/**
 * @see IconicsDrawable.contourColor
 */
fun IconicsDrawable.contourColor(contourColorProducer: () -> Int): IconicsDrawable {
    return contourColor(contourColorProducer())
}
// endregion

// region roundedCornersRx
/**
 * @see IconicsDrawable.roundedCornersRxRes
 */
fun IconicsDrawable.roundedCornersRxRes(roundedCornersRxResProducer: () -> Int): IconicsDrawable {
    return roundedCornersRxRes(roundedCornersRxResProducer())
}

/**
 * @see IconicsDrawable.roundedCornersRxDp
 */
fun IconicsDrawable.roundedCornersRxDp(roundedCornersRxDpProducer: () -> Int): IconicsDrawable {
    return roundedCornersRxDp(roundedCornersRxDpProducer())
}

/**
 * @see IconicsDrawable.roundedCornersRxPx
 */
fun IconicsDrawable.roundedCornersRxPx(roundedCornersRxPxProducer: () -> Int): IconicsDrawable {
    return roundedCornersRxPx(roundedCornersRxPxProducer())
}
// endregion

// region roundedCornersRy
/**
 * @see IconicsDrawable.roundedCornersRyRes
 */
fun IconicsDrawable.roundedCornersRyRes(roundedCornersRyResProducer: () -> Int): IconicsDrawable {
    return roundedCornersRyRes(roundedCornersRyResProducer())
}

/**
 * @see IconicsDrawable.roundedCornersRyDp
 */
fun IconicsDrawable.roundedCornersRyDp(roundedCornersRyDpProducer: () -> Int): IconicsDrawable {
    return roundedCornersRyDp(roundedCornersRyDpProducer())
}

/**
 * @see IconicsDrawable.roundedCornersRyPx
 */
fun IconicsDrawable.roundedCornersRyPx(roundedCornersRyPxProducer: () -> Int): IconicsDrawable {
    return roundedCornersRyPx(roundedCornersRyPxProducer())
}
// endregion

// region roundedCorners
/**
 * @see IconicsDrawable.roundedCornersRes
 */
fun IconicsDrawable.roundedCornersRes(roundedCornersResProducer: () -> Int): IconicsDrawable {
    return roundedCornersRes(roundedCornersResProducer())
}

/**
 * @see IconicsDrawable.roundedCornersDp
 */
fun IconicsDrawable.roundedCornersDp(roundedCornersDpProducer: () -> Int): IconicsDrawable {
    return roundedCornersDp(roundedCornersDpProducer())
}

/**
 * @see IconicsDrawable.roundedCornersPx
 */
fun IconicsDrawable.roundedCornersPx(roundedCornersPxProducer: () -> Int): IconicsDrawable {
    return roundedCornersPx(roundedCornersPxProducer())
}
// endregion

// region contourWidth
/**
 * @see IconicsDrawable.contourWidthRes
 */
fun IconicsDrawable.contourWidthRes(contourWidthResProducer: () -> Int): IconicsDrawable {
    return contourWidthRes(contourWidthResProducer())
}

/**
 * @see IconicsDrawable.contourWidthDp
 */
fun IconicsDrawable.contourWidthDp(contourWidthDpProducer: () -> Int): IconicsDrawable {
    return contourWidthDp(contourWidthDpProducer())
}

/**
 * @see IconicsDrawable.contourWidthPx
 */
fun IconicsDrawable.contourWidthPx(contourWidthPxProducer: () -> Int): IconicsDrawable {
    return contourWidthPx(contourWidthPxProducer())
}
// endregion

// region backgroundContourWidth
/**
 * @see IconicsDrawable.backgroundContourWidthRes
 */
fun IconicsDrawable.backgroundContourWidthRes(
    backgroundContourWidthResProducer: () -> Int
): IconicsDrawable {
    return backgroundContourWidthRes(backgroundContourWidthResProducer())
}

/**
 * @see IconicsDrawable.backgroundContourWidthDp
 */
fun IconicsDrawable.backgroundContourWidthDp(
    backgroundContourWidthDpProducer: () -> Int
): IconicsDrawable {
    return backgroundContourWidthDp(backgroundContourWidthDpProducer())
}

/**
 * @see IconicsDrawable.backgroundContourWidthPx
 */
fun IconicsDrawable.backgroundContourWidthPx(
    backgroundContourWidthPxProducer: () -> Int
): IconicsDrawable {
    return backgroundContourWidthPx(backgroundContourWidthPxProducer())
}
// endregion

// region other
/**
 * @see IconicsDrawable.enableShadowSupport
 */
fun IconicsDrawable.enableShadowSupport(enableShadowSupportProducer: () -> View): IconicsDrawable {
    return enableShadowSupport(enableShadowSupportProducer())
}

/**
 * @see IconicsDrawable.drawContour
 */
fun IconicsDrawable.drawContour(drawContourProducer: () -> Boolean): IconicsDrawable {
    return drawContour(drawContourProducer())
}

/**
 * @see IconicsDrawable.drawBackgroundContour
 */
fun IconicsDrawable.drawBackgroundContour(
    drawBackgroundContourProducer: () -> Boolean
): IconicsDrawable {
    return drawBackgroundContour(drawBackgroundContourProducer())
}

/**
 * @see IconicsDrawable.colorFilter
 */
fun IconicsDrawable.colorFilter(colorFilterProducer: () -> ColorFilter): IconicsDrawable {
    return colorFilter(colorFilterProducer())
}

/**
 * @see IconicsDrawable.alpha
 */
fun IconicsDrawable.alpha(alphaProducer: () -> Int): IconicsDrawable {
    return alpha(alphaProducer())
}

/**
 * @see IconicsDrawable.style
 */
fun IconicsDrawable.style(styleProducer: () -> Paint.Style): IconicsDrawable {
    return style(styleProducer())
}

/**
 * @see IconicsDrawable.typeface
 */
fun IconicsDrawable.typeface(typefaceProducer: () -> Typeface): IconicsDrawable {
    return typeface(typefaceProducer())
}

/**
 * @see IconicsDrawable.respectFontBounds
 */
fun IconicsDrawable.respectFontBounds(respectFontBoundsProducer: () -> Boolean): IconicsDrawable {
    return respectFontBounds(respectFontBoundsProducer())
}
// endregion