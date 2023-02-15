package com.example.constraintlayoutplayground

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import com.example.constraintlayoutplayground.databinding.ActivityRemoveViewBinding
import com.example.constraintlayoutplayground.databinding.ConstraintLayoutCanvasBinding

private const val TAG = "RemoveViewActivity"

class RemoveViewActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityRemoveViewBinding
    //private var viewList = ArrayList<Int>()
    private var viewIdList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRemoveViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initClickListeners()
    }


    private fun initClickListeners() {
        binding.apply {

            addButton.setOnClickListener {
                addConstraintLayout()
            }

            removeButton.setOnClickListener {
                removeConstraintLayout()
            }
        }
    }

    private fun removeConstraintLayout(){
        binding.apply {
            try {
                val index = editText.text.toString().toInt()
                rearrangeConstraints(index)
                val view = findViewById<ConstraintLayout>(viewIdList[index])
                view.setOnClickListener(null)
                parentLayout.removeView(view)
                viewIdList.removeAt(index)
            } catch (e: Exception) {
                Toast.makeText(this@RemoveViewActivity, "Index Out Of Bounds!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun addConstraintLayout() {

        binding.apply {

            val wrapContentLayoutParams = ActionBar.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )

            val multiSizeParams = ActionBar.LayoutParams(
                resources.getDimensionPixelSize(R.dimen._75dp),
                resources.getDimensionPixelSize(R.dimen._75dp)
            )
            val multiView = ConstraintLayoutCanvasBinding.inflate(layoutInflater).root

            when (viewIdList.size) {
                0 -> {
                    val layout = ConstraintLayout(this@RemoveViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = startMultiGuideline.id
                        endToEnd = parentLayout.id
                        marginEnd = resources.getDimensionPixelSize(R.dimen._20dp)
                    }
                    layout.setOnClickListener(this@RemoveViewActivity)

                    parentLayout.addView(layout)
                    applyVerticalAdditionAnimationToView(layout)


                }

                1 -> {
                    val layout = ConstraintLayout(this@RemoveViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = viewIdList[0]
                        endToEnd = viewIdList[0]
                        topMargin = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    layout.setOnClickListener(this@RemoveViewActivity)

                    parentLayout.addView(layout)
                    applyVerticalAdditionAnimationToView(layout)

                }

                2 -> {
                    val layout = ConstraintLayout(this@RemoveViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = viewIdList[1]
                        endToEnd = viewIdList[1]
                        topMargin = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    layout.setOnClickListener(this@RemoveViewActivity)

                    parentLayout.addView(layout)
                    applyVerticalAdditionAnimationToView(layout)
                }

                3 -> {
                    val layout = ConstraintLayout(this@RemoveViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = viewIdList[2]
                        endToEnd = viewIdList[2]
                        topMargin = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    layout.setOnClickListener(this@RemoveViewActivity)

                    parentLayout.addView(layout)
                    applyVerticalAdditionAnimationToView(layout)
                }

                4 -> {
                    val layout = ConstraintLayout(this@RemoveViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        endToStart = viewIdList[3]
                        bottomToBottom = viewIdList[3]
                        marginEnd = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    layout.setOnClickListener(this@RemoveViewActivity)

                    parentLayout.addView(layout)
                    applyHorizontalAdditionAnimationToView(layout)
                }

                5 -> {
                    val layout = ConstraintLayout(this@RemoveViewActivity)
                    layout.id = View.generateViewId()
                    addLayoutIdToViewIdList(layout.id)
                    layout.addView(multiView, multiSizeParams)
                    layout.layoutParams = ConstraintLayout.LayoutParams(wrapContentLayoutParams)
                    layout.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        endToStart = viewIdList[4]
                        bottomToBottom = viewIdList[4]
                        marginEnd = resources.getDimensionPixelSize(R.dimen._20dp)
                    }

                    layout.setOnClickListener(this@RemoveViewActivity)

                    parentLayout.addView(layout)
                    applyHorizontalAdditionAnimationToView(layout)

                }

                else -> Toast.makeText(this@RemoveViewActivity, "Only 6 People Allowed in A Party!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun addLayoutIdToViewIdList(id: Int) {
        viewIdList.add(id)
        Log.d(TAG, "addLayoutIdToViewIdList: $viewIdList ")
    }

    private fun rearrangeConstraints(index: Int) {
        when(index){
            3 -> {
                if (viewIdList.size > 4) {
                    val topView = findViewById<ConstraintLayout>(viewIdList[index - 1])
                    val leftView = findViewById<ConstraintLayout>(viewIdList[index + 1])
                    leftView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = topView.id
                        topMargin = resources.getDimension(R.dimen._20dp).toInt()
                        endToEnd = topView.id
                        marginEnd = 0
                        bottomToBottom = ConstraintLayout.LayoutParams.UNSET
                        endToStart = ConstraintLayout.LayoutParams.UNSET
                    }
                }
            }

            0 -> {
                if (viewIdList.size > 1) {

                    shiftTopView()
                    rearrangeFourthView()
                }
            }

            1, 2, 4 -> {
                attachConstraintOfNextIndex(index)
                rearrangeFourthView()
            }

        }
    }

    private fun attachConstraintOfNextIndex(index: Int) {
        when(index){
            1,2 -> verticalAttachmentOfNextIndex(index)
            4 -> horizontalAttachmentOfNextIndex(index)
        }

    }

    private fun verticalAttachmentOfNextIndex(index: Int){
        if(viewIdList.size > index + 1){
            val previousView = findViewById<ConstraintLayout>(viewIdList[index-1])
            val nextView = findViewById<ConstraintLayout>(viewIdList[index+1])
            nextView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                topToBottom = previousView.id
                endToEnd = previousView.id
            }
        }
    }

    private fun horizontalAttachmentOfNextIndex(index: Int){
        if(viewIdList.size > index + 1){
            val previousView = findViewById<ConstraintLayout>(viewIdList[index-1])
            val nextView = findViewById<ConstraintLayout>(viewIdList[index+1])
            nextView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                endToStart = previousView.id
                bottomToBottom = previousView.id
            }
        }
    }

    private fun rearrangeFourthView(){
        if (viewIdList.size > 4) {
            val thirdIndexView = findViewById<ConstraintLayout>(viewIdList[3])
            val fourthIndexView = findViewById<ConstraintLayout>(viewIdList[4])
            fourthIndexView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                topToBottom = thirdIndexView.id
                topMargin = resources.getDimension(R.dimen._20dp).toInt()
                endToEnd = thirdIndexView.id
                bottomToBottom = ConstraintLayout.LayoutParams.UNSET
                endToStart = ConstraintLayout.LayoutParams.UNSET
                marginEnd = 0
            }
        }
    }

    private fun shiftTopView(){
        binding.apply {
            val bottomView = findViewById<ConstraintLayout>(viewIdList[1])
            bottomView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                topToBottom = startMultiGuideline.id
                endToEnd = parentLayout.id
                marginEnd = resources.getDimensionPixelSize(R.dimen._20dp)
                topMargin = ConstraintLayout.LayoutParams.UNSET
            }
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            viewIdList[0] -> Toast.makeText(this, "First Multi", Toast.LENGTH_SHORT).show()
            viewIdList[1] -> Toast.makeText(this, "Second Multi", Toast.LENGTH_SHORT).show()
            viewIdList[2] -> Toast.makeText(this, "Third Multi", Toast.LENGTH_SHORT).show()
            viewIdList[3] -> Toast.makeText(this, "Fourth Multi", Toast.LENGTH_SHORT).show()
            viewIdList[4] -> Toast.makeText(this, "Fifth Multi", Toast.LENGTH_SHORT).show()
            viewIdList[5] -> Toast.makeText(this, "Sixth Multi", Toast.LENGTH_SHORT).show()
        }
    }

    private fun applyVerticalAdditionAnimationToView(layout: View) {
        val animation = AnimationUtils.loadAnimation(this@RemoveViewActivity, R.anim.slide_down)
        layout.startAnimation(animation)
    }
    private fun applyHorizontalAdditionAnimationToView(layout: View) {
        val animation = AnimationUtils.loadAnimation(this@RemoveViewActivity, R.anim.slide_right)
        layout.startAnimation(animation)
    }


}