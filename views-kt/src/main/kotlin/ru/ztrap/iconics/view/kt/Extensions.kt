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

package ru.ztrap.iconics.view.kt

import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.view.IconicsCheckableTextView
import com.mikepenz.iconics.view.IconicsCompoundButton
import com.mikepenz.iconics.view.IconicsImageView
import com.mikepenz.iconics.view.IconicsTextView

/**
 * Safely update start [IconicsDrawable]
 * @param checked defines what the icon will be updated
 * */
fun IconicsCheckableTextView.startIcon(checked: Boolean, block: IconicsDrawable.() -> Unit) {
    if (checked) {
        var icon = checkedIconicsDrawableStart

        if (icon == null) {
            icon = IconicsDrawable(context)
            setCheckedDrawableStart(icon)
        }
        block(icon)
    } else {
        startIcon(block)
    }
}

/**
 * Safely update top [IconicsDrawable]
 * @param checked defines what the icon will be updated
 * */
fun IconicsCheckableTextView.topIcon(checked: Boolean, block: IconicsDrawable.() -> Unit) {
    if (checked) {
        var icon = checkedIconicsDrawableTop

        if (icon == null) {
            icon = IconicsDrawable(context)
            setCheckedDrawableTop(icon)
        }
        block(icon)
    } else {
        topIcon(block)
    }
}

/**
 * Safely update end [IconicsDrawable]
 * @param checked defines what the icon will be updated
 * */
fun IconicsCheckableTextView.endIcon(checked: Boolean, block: IconicsDrawable.() -> Unit) {
    if (checked) {
        var icon = checkedIconicsDrawableEnd

        if (icon == null) {
            icon = IconicsDrawable(context)
            setCheckedDrawableEnd(icon)
        }
        block(icon)
    } else {
        endIcon(block)
    }
}

/**
 * Safely update bottom [IconicsDrawable]
 * @param checked defines what the icon will be updated
 * */
fun IconicsCheckableTextView.bottomIcon(checked: Boolean, block: IconicsDrawable.() -> Unit) {
    if (checked) {
        var icon = checkedIconicsDrawableBottom

        if (icon == null) {
            icon = IconicsDrawable(context)
            setCheckedDrawableBottom(icon)
        }
        block(icon)
    } else {
        bottomIcon(block)
    }
}

/**
 * Safely update [IconicsDrawable]
 * @param checked defines what the icon will be updated
 * */
fun IconicsCompoundButton.icon(checked: Boolean, block: IconicsDrawable.() -> Unit) {
    var icon = if (checked) checkedIcon else uncheckedIcon

    if (icon == null) {
        icon = IconicsDrawable(context)
        if (checked) checkedIcon = icon else uncheckedIcon = icon
    }
    block(icon)
}

/**
 * Safely update [IconicsDrawable]
 * */
fun IconicsImageView.icon(block: IconicsDrawable.() -> Unit) {
    var icon = icon

    if (icon == null) {
        icon = IconicsDrawable(context)
        this.icon = icon
    }
    block(icon)
}

/**
 * Safely update start [IconicsDrawable]
 * */
fun IconicsTextView.startIcon(block: IconicsDrawable.() -> Unit) {
    var icon = iconicsDrawableStart

    if (icon == null) {
        icon = IconicsDrawable(context)
        setDrawableStart(icon)
    }
    block(icon)
}

/**
 * Safely update top [IconicsDrawable]
 * */
fun IconicsTextView.topIcon(block: IconicsDrawable.() -> Unit) {
    var icon = iconicsDrawableTop

    if (icon == null) {
        icon = IconicsDrawable(context)
        setDrawableTop(icon)
    }
    block(icon)
}

/**
 * Safely update end [IconicsDrawable]
 * */
fun IconicsTextView.endIcon(block: IconicsDrawable.() -> Unit) {
    var icon = iconicsDrawableEnd

    if (icon == null) {
        icon = IconicsDrawable(context)
        setDrawableEnd(icon)
    }
    block(icon)
}

/**
 * Safely update bottom [IconicsDrawable]
 * */
fun IconicsTextView.bottomIcon(block: IconicsDrawable.() -> Unit) {
    var icon = iconicsDrawableBottom

    if (icon == null) {
        icon = IconicsDrawable(context)
        setDrawableBottom(icon)
    }
    block(icon)
}