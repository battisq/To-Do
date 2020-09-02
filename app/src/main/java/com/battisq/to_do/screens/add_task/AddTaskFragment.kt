package com.battisq.to_do.screens.add_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.battisq.to_do.R
import com.battisq.to_do.databinding.FragmentAddTaskBinding
import com.battisq.to_do.databinding.FragmentTasksBinding
import com.battisq.to_do.models.Task
import com.battisq.to_do.utilits.MAIN_ACTIVITY
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddTaskFragment : Fragment() {

    companion object {
        fun newInstance() = AddTaskFragment()
    }

    private var binding: FragmentAddTaskBinding? = null
    private val mBinding: FragmentAddTaskBinding get() = binding!!
    private lateinit var mViewModel: AddTaskViewModel
    private lateinit var mTaskText: TextView
    private lateinit var mFab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddTaskViewModel::class.java)
        mTaskText = mBinding.taskText
        mFab = mBinding.fab
        mFab.setOnClickListener {
            val text = mBinding.taskText.text.toString()

            mViewModel.insert(Task(text = text)) {
                MAIN_ACTIVITY.mNavController.navigate(R.id.action_addTaskFragment_to_tasksFragment)
            }
        }
    }

}