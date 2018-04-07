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
import android.os.Build
import android.support.v4.view.LayoutInflaterCompat
import android.support.v7.app.AppCompatDelegate
import android.text.Spanned
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsArrayBuilder
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.context.IconicsContextWrapper
import com.mikepenz.iconics.context.IconicsLayoutInflater
import com.mikepenz.iconics.context.IconicsLayoutInflater2
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
    block(builder)
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