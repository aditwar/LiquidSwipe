package com.example.liquidswipedemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.jem.easyreveal.RevealLayout
import com.jem.liquidswipe.LiquidSwipeClipPathProvider

class CustomPagerAdapter(private val context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.fragment_dummy, container, false);
        layout.findViewById<TextView>(R.id.fragment_textview).text = titleArray[(position % titleArray.count())]
        layout.findViewById<LottieAnimationView>(R.id.lottieAnimationView).setAnimation(
            resourceArray[(position % titleArray.count())])
        layout.findViewById<LottieAnimationView>(R.id.lottieAnimationView).repeatCount = LottieDrawable.INFINITE
        layout.findViewById<LottieAnimationView>(R.id.lottieAnimationView).repeatMode = LottieDrawable.REVERSE
        layout.findViewById<LottieAnimationView>(R.id.lottieAnimationView).playAnimation()
        layout.setBackgroundColor(backgroundColorArray[(position % titleArray.count())])
        (layout as? RevealLayout)?.clipPathProvider = LiquidSwipeClipPathProvider()
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun getCount(): Int {
        return titleArray.count() * 20
    }
}