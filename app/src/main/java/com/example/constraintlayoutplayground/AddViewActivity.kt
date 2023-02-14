package com.example.constraintlayoutplayground

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import com.example.constraintlayoutplayground.databinding.ActivityAddViewBinding
import com.example.constraintlayoutplayground.databinding.ConstraintLayoutCanvasBinding

private const val TAG = "AddViewActivity"

class AddViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddViewBinding
    private var viewList = ArrayList<Int>(listOf(1,2,3,4,5,6))
    private var viewIdList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.apply {
            addViewButton.setOnClickListener {
                addConstraintLayout()
            }
        }
    }

    private fun addConstraintLayout() {

        binding.apply {

            val wrapContentLayoutParams = LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )

            val multiSizeParams = LayoutParams(
                resources.getDimensionPixelSize(R.dimen._75dp),
                resources.getDimensionPixelSize(R.dimen._75dp)
            )
            val multiView = ConstraintLayoutCanvasBinding.inflate(layoutInflater).root

            when (viewIdList.size) {
                0 -> {
                    val layout = ConstraintLayout(this@AddViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = startMultiGuideline.id
                        endToEnd = parentLayout.id
                        marginEnd = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    parentLayout.addView(layout)

                }

                1 -> {
                    val layout = ConstraintLayout(this@AddViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = viewIdList[0]
                        endToEnd = viewIdList[0]
                        topMargin = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    parentLayout.addView(layout)

                }

                2 -> {
                    val layout = ConstraintLayout(this@AddViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = viewIdList[1]
                        endToEnd = viewIdList[1]
                        topMargin = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    parentLayout.addView(layout)
                }

                3 -> {
                    val layout = ConstraintLayout(this@AddViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = viewIdList[2]
                        endToEnd = viewIdList[2]
                        topMargin = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    parentLayout.addView(layout)
                }

                4 -> {
                    val layout = ConstraintLayout(this@AddViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        endToStart = viewIdList[3]
                        bottomToBottom = viewIdList[3]
                        marginEnd = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    parentLayout.addView(layout)
                }

                5 -> {
                    val layout = ConstraintLayout(this@AddViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        endToStart = viewIdList[4]
                        bottomToBottom = viewIdList[4]
                        marginEnd = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    parentLayout.addView(layout)
                }

                else -> Toast.makeText(this@AddViewActivity, "Only 6 People Allowed in A Party!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun addLayoutIdToViewIdList(id: Int) {
        viewIdList.add(id)
        Log.d(TAG, "addLayoutIdToViewIdList: $viewIdList ")
    }
}