package com.lucasfagundes.androidudemycourse.adapter

data class Movie(
    val title: String,
    val year: String,
    val genre: String
) {
    companion object {
        val DUMBLIST = listOf(
            Movie(
                title = "asdsdasdasddasd",
                year = "asdasd",
                genre = "asdasdasd"
            ),
            Movie(
                title = "asdasd",
                year = "asdasd",
                genre = "asdasdasd"
            ),
            Movie(
                title = "asdasd",
                year = "asdasdasddddddddasd",
                genre = "asdasdasd"
            ),
            Movie(
                title = "asdaaaaaaaaaaaaasd",
                year = "asdasddaa",
                genre = "asdasdasd"
            ),
            Movie(
                title = "asddauuuuuasd",
                year = "asdasd",
                genre = "asdasdasd"
            )
        )
    }
}
