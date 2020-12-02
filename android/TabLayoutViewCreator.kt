package com.easylokal.easylokal_android_sdk.internal.reinflater.creator

import android.content.Context
import android.util.AttributeSet
import com.easylokal.easylokal_android_sdk.internal.reinflater.views.ReInflaterTabLayout
import com.google.android.material.tabs.TabLayout

/**
 * [ViewCreator] which creates a [ReInflaterTabLayout].
 */
internal object TabLayoutViewCreator : ViewCreator<TabLayout> {

    override val viewName = TabLayout::class.qualifiedName.toString()


    override fun createView(context: Context, attrs: AttributeSet?): TabLayout {
        /**
         Refer [here](https://github.com/easylokal/gist/blob/main/android/ReInflaterTabLayout.kt) to check view class.
        */
        return ReInflaterTabLayout(context, attrs)
    }
}