package com.codelabs.state

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WellnessViewModelTest {
    @Test
    fun initialTaskList_hasThirtyItems() {
        val viewModel = WellnessViewModel()
        assertEquals(30, viewModel.tasks.size)
    }

    @Test
    fun changeTaskChecked_updatesObservableState() {
        val viewModel = WellnessViewModel()
        val task = viewModel.tasks.first()
        assertFalse(task.checked)

        viewModel.changeTaskChecked(task, true)

        assertTrue(task.checked)
    }

    @Test
    fun remove_deletesTaskFromList() {
        val viewModel = WellnessViewModel()
        val task = viewModel.tasks.first()

        viewModel.remove(task)

        assertEquals(29, viewModel.tasks.size)
        assertFalse(viewModel.tasks.contains(task))
    }
}
