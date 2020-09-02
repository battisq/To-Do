package com.battisq.to_do.screens.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.battisq.to_do.R
import com.battisq.to_do.databinding.FragmentTasksBinding
import com.battisq.to_do.models.Task
import com.battisq.to_do.utilits.MAIN_ACTIVITY
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TasksFragment : Fragment() {

    companion object {
        fun newInstance() = TasksFragment()
    }

    private var binding: FragmentTasksBinding? = null
    private val mBinding: FragmentTasksBinding get() = binding!!
    private lateinit var mViewModel: TasksViewModel
    private lateinit var mAdapter: TasksAdapter
    private lateinit var mObserverList: Observer<List<Task>>
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mFloatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialization()
    }

    private fun initialization() {
        mFloatingActionButton = mBinding.fab
        mFloatingActionButton.setOnClickListener {
            MAIN_ACTIVITY.mNavController.navigate(R.id.action_tasksFragment_to_addTaskFragment)
        }

        mAdapter = TasksAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val tasks = it
            mAdapter.setTasks(tasks)
        }

        mViewModel = ViewModelProvider(this).get(TasksViewModel::class.java)
        mViewModel.tasks.observe(viewLifecycleOwner, mObserverList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.tasks.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }
}