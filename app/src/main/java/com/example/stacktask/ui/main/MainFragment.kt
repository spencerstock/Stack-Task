package com.example.stacktask.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.stacktask.R
import com.example.stacktask.models.Task
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {
    lateinit var taskList: List<Task>

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.getAllTasks().observe(this, Observer<List<Task>> {
            taskList = it
            message.text = it[it.lastIndex].name
        })


        remove.setOnClickListener {
            viewModel.removeTask(taskList.get(taskList.lastIndex))
        }

        add.setOnClickListener {
            viewModel.addTask(task.text.toString())
        }
    }

}
