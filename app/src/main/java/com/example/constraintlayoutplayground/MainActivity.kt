package com.example.constraintlayoutplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.core.view.updateLayoutParams
import com.example.constraintlayoutplayground.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var viewList = ArrayList<ConstraintLayout>()
    private var viewIdList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        addAllViews()
        initClickListeners()
    }

    private fun addAllViews() {
        binding.constraintLayout.children.forEach {
            if (it is ConstraintLayout) {
                viewList.add(it)
                viewIdList.add(it.id)
            }
        }
    }

    private fun initClickListeners() {
        binding.apply {

            submitButton.setOnClickListener {
                try {
                    val index = editText.text.toString().toInt()
                    rearrangeConstraints(index)
                    val view = findViewById<ConstraintLayout>(viewIdList[index])
                    view.visibility = View.GONE
                    viewIdList.removeAt(index)
                    viewList.removeAt(index)
                } catch (e : Exception){
                    Toast.makeText(this@MainActivity, "Index Out Of Bounds!", Toast.LENGTH_SHORT).show()
                }
        }
    }
}

    private fun rearrangeConstraints(index: Int) {
        when(index){
            3 -> {
                if (viewIdList.size > 4) {
                    val leftView = findViewById<ConstraintLayout>(viewIdList[index + 1])
                    val topView = findViewById<ConstraintLayout>(viewIdList[index - 1])
                    leftView.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = topView.id
                        topMargin = resources.getDimension(R.dimen._20dp).toInt()
                        endToEnd = topView.id
                        marginEnd = 0
                        bottomToBottom = 0
                    }
                }
            }

            0 -> {
                if (viewIdList.size > 1) {

                    shiftTopView()
                    rearrangeFourthView()
                }
            }

            1, 2 -> rearrangeFourthView()

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
        val bottomView = findViewById<ConstraintLayout>(viewIdList[1])
        bottomView.updateLayoutParams<ConstraintLayout.LayoutParams> {
            topMargin = 0
        }
    }

}