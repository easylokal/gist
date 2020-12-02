package com.easylokal.easylokal_android_sdk.internal.reinflater.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.easylokal.easylokal_android_sdk.R
import com.google.android.material.tabs.TabLayout

/**
 * A custom [TabLayout] which copies the ReInflater view tag from the [ReInflaterTabItem] dummy view
 * to the newly created [TabLayout.TabView] when it gets added to the [ReInflaterTabLayout]
 * and updates the text of the new [TabLayout.TabView] using the [ReInflaterTabItem.textResourceId].
 */
internal class ReInflaterTabLayout(
    context: Context,
    attrs: AttributeSet?
) : TabLayout(context, attrs) {

    override fun addView(child: View?) {
        super.addView(child)
        copyReinflaterTagAndUpdateText(child)
    }

    override fun addView(child: View?, index: Int) {
        super.addView(child, index)
        copyReinflaterTagAndUpdateText(child, index)
    }

    override fun addView(child: View?, params: ViewGroup.LayoutParams?) {
        super.addView(child, params)
        copyReinflaterTagAndUpdateText(child)
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        super.addView(child, index, params)
        copyReinflaterTagAndUpdateText(child, index)
    }

    private fun copyReinflaterTagAndUpdateText(child: View?, index: Int = tabCount - 1) {
        copyReInflaterTag(child, index)
        updateText(child, index)
    }

    private fun copyReInflaterTag(child: View?, index: Int) {
        getTabAt(index)
            ?.view
            ?.setTag(R.id.view_tag, child?.getTag(R.id.view_tag))
    }

    private fun updateText(child: View?, index: Int) {
        val resId = (child as? ReInflaterTabItem)?.textResourceId

        if (resId != null) {
            getTabAt(index)?.text = context.resources.getText(resId)
        }
    }
}