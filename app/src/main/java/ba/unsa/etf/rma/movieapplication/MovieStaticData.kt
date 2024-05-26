package ba.unsa.etf.rma.movieapplication


fun getFavoriteMovies(): List<Movie> {
    return listOf(
        Movie(1,"Pride and prejudice",
            "Sparks fly when spirited Elizabeth Bennet meets single, rich, and proud Mr. Darcy. But Mr. Darcy reluctantly finds himself falling in love with a woman beneath his class. Can each overcome their own pride and prejudice?",
            "16.02.2005.","https://www.imdb.com/title/tt0414387/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(2,"Pulp Fiction",
            "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
            "14.10.1994.","https://www.imdb.com/title/tt0110912/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(3,"The Lord of the Rings",
            "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
            "10.12.2001","https://www.imdb.com/title/tt0120737/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(4,"Serenity",
            "The crew of the ship Serenity try to evade an assassin sent to recapture one of their members who is telepathic.",
            "30.09.2005","https://www.imdb.com/title/tt0379786/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(5,"Shaun of the Dead",
            "A man's uneventful life is disrupted by the zombie apocalypse.",
            "09.04.2004","https://www.imdb.com/title/tt0365748/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(6,"Watchmen",
            "In 1985 where former superheroes exist, the murder of a colleague sends active vigilante Rorschach into his own sprawling investigation, uncovering something that could completely change the course of history as we know it.",
            "23.02.2009.","https://www.imdb.com/title/tt0409459/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/")
    )
}

fun getRecentMovies(): List<Movie> {
    return listOf(
        Movie(1,"Creed III",
            "Adonis has been thriving in both his career and family life, but when a childhood friend and former boxing prodigy resurfaces, the face-off is more than just a fight.",
            "03.03.2023.","https://www.imdb.com/title/tt11145118/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(2,"Scream VI",
            "In the next installment, the survivors of the Ghostface killings leave Woodsboro behind and start a fresh chapter in New York City.",
            "10.03.2023.","https://www.imdb.com/title/tt17663992/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(3,"Shazam! Fury of the Gods",
            "The film continues the story of teenage Billy Batson who, upon reciting the magic word \"SHAZAM!\" is transformed into his adult Super Hero alter ego, Shazam.",
            "17.03.2023.","https://www.imdb.com/title/tt10151854/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(4,"John Wick: Chapter 4",
            "John Wick uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.",
            "24.03.2023.","https://www.imdb.com/title/tt10366206/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(5,"Dungeons & Dragons: Honor Among Thieves",
            "A charming thief and a band of unlikely adventurers embark on an epic quest to retrieve a lost relic, but things go dangerously awry when they run afoul of the wrong people.",
            "31.03.2023.","https://www.imdb.com/title/tt2906216/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
        Movie(6,"Love again",
            "A young woman tries to ease the pain of her fiancé's death by sending romantic texts to his old cell phone number, and forms a connection with the man the number has been reassigned to.",
            "12.05.2023.","https://www.imdb.com/title/tt10276482/",
            "https://www.imdb.com/title/tt0414387/","https://www.imdb.com/title/tt0414387/"),
    )
}
fun getMovieActors():Map<String,List<String>>{
    return mapOf<String,List<String>>("Pulp Fiction" to listOf("John Travolta","Samuel L. Jackson","Bruce Willis","Amanda Plummer","Laura Lovelace"),"Pride and prejudice" to listOf("Keira Knightley","Talulah Riley","Rosamund Pike"))
}

fun getSimilarMovies():Map<String,List<String>>{
    return mapOf<String,List<String>>("Pulp Fiction" to listOf("Fight Club","Inception","Se7en"),"Pride and prejudice" to listOf("Jane Eyre","The Notebook","Atonement"))
}