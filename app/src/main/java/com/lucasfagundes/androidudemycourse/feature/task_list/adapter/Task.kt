package com.lucasfagundes.androidudemycourse.feature.task_list.adapter

data class Task(
    val title: String,

) {
    companion object {
        val DUMBLIST = listOf(
            Task(
                title = "Um Sonho de Liberdade",
            ),
            Task(
                title = "O Poderoso Chefão",
            ),
            Task(
                title = "O Poderoso Chefão II",
            ),
            Task(
                title = "O Poderoso Chefão III",
            )
        )
    }
}
