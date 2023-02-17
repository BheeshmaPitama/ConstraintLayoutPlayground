package com.example.constraintlayoutplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import com.example.constraintlayoutplayground.databinding.ActivityConstraintSetBinding

class ConstraintSetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConstraintSetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintSetBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.apply {
            button2.setOnClickListener {
                removeButton2()
            }
        }
    }

    private fun removeButton2() {
        binding.apply {
            val constraintSet = ConstraintSet()
            constraintSet.clone(parentLayout)
            constraintSet.connect(
                button3.id ,
                ConstraintSet.TOP,
                button1.id,
                ConstraintSet.BOTTOM
            )

            resetButton5constraints(constraintSet)

            val transition = AutoTransition()
            transition.duration = 500
            transition.interpolator = AccelerateDecelerateInterpolator()

            TransitionManager.beginDelayedTransition(parentLayout,transition)
            constraintSet.applyTo(parentLayout)
            parentLayout.removeView(button2)
        }
    }

    private fun resetButton5constraints(constraintSet: ConstraintSet) {
        binding.apply {

            constraintSet.connect(
                button5.id,
                ConstraintSet.TOP,
                button4.id,
                ConstraintSet.BOTTOM,
                resources.getDimensionPixelSize(R.dimen._20dp)
            )

            constraintSet.connect(
                button5.id,
                ConstraintSet.START,
                parentLayout.id,
                ConstraintSet.START
            )
        }
    }
}