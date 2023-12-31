package com.example.lesson_2511.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_2511.R
import com.example.lesson_2511.data.db.TaskState
import com.example.lesson_2511.data.module.Task
import com.example.lesson_2511.databinding.FragmentHomeBinding
import com.example.lesson_2511.di.appComponent
import com.example.lesson_2511.di.viewModel.ViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()

    private val adapter = TaskAdapter(::onTaskStateClick)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    private fun onTaskStateClick(task: Task) {
        val states = TaskState.values().map { it.name }.toTypedArray()
        var index = -1
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Select new state.")
            .setNeutralButton("Cancel") { _, _ -> }
            .setPositiveButton("Ok") { _, _ ->
                viewModel.changeTaskState(task, index)
            }
            .setSingleChoiceItems(states, states.indexOf(task.state.name)) { _, which ->
                index = which
            }
            .show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.tasksRecycler) {
            adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.tasks.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.buttonCreateTask.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToModifyTaskFragment()
            findNavController().navigate(direction)
        }
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }
}