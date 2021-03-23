package com.lucasfagundes.androidudemycourse.feature.recycler_view.adapter

data class Movie(
    val title: String,
    val year: String,
    val genre: String
) {
    companion object {
        val DUMBLIST = listOf(
            Movie(
                title = "Um Sonho de Liberdade",
                year = "1994",
                genre = "Drama"
            ),
            Movie(
                title = "O Poderoso Chefão",
                year = "1972",
                genre = "Crime, drama"
            ),
            Movie(
                title = "O Poderoso Chefão II",
                year = "1972",
                genre = "Crime, drama"
            ),
            Movie(
                title = "Batman: O Cavaleiro das Trevas",
                year = "2008",
                genre = "Action, Crime, Drama "
            ),
            Movie(
                title = "12 Homens e uma Sentença",
                year = "1957",
                genre = "Crime, drama"
            ),
            Movie(
                title = "A Lista de Schindler ",
                year = "1993",
                genre = "Biography, Drama, History "
            ),
            Movie(
                title = "O Senhor dos Anéis: O Retorno do Rei",
                year = "2003",
                genre = "Action, Adventure, Drama "
            ),
            Movie(
                title = "Pulp Fiction: Tempo de Violência",
                year = "1994",
                genre = "Crime, Drama"
            ),
            Movie(
                title = "Três Homens em Conflito",
                year = "1966",
                genre = "Western"
            ),
            Movie(
                title = "Clube da Luta",
                year = "1999",
                genre = "Drama"
            ),
            Movie(
                title = "Matrix",
                year = "1999",
                genre = "Action, Sci-Fi"
            ),
            Movie(
                title = "Os Sete Samurais",
                year = "1954",
                genre = " Action, Adventure"
            )


        )
    }
}
