package com.example.stacktask.ui.main

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.stacktask.R
import com.example.stacktask.ViewPager2.TaskPagerAdapter
import com.example.stacktask.models.Task
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    private lateinit var taskList: List<Task>
    private var taskPagerAdapter: TaskPagerAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)




        viewModel.getAllTasks().observe(this, Observer<List<Task>> {
            taskList = it
            viewPager = view_pager
            if (taskPagerAdapter == null) taskPagerAdapter = TaskPagerAdapter(taskList)
            if (viewPager.adapter == null) viewPager.adapter = taskPagerAdapter
            taskPagerAdapter!!.notifyDataSetChanged()
        })




        remove.setOnClickListener {
            if (taskList.isNotEmpty()) viewModel.removeTask(taskList.get(taskList.lastIndex))
        }

        add.setOnClickListener {
            viewModel.addTask(task.text.toString())
        }
    }

}
