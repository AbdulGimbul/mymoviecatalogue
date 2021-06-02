package com.example.abdl.mymoviecatalogue.utils

import com.example.abdl.mymoviecatalogue.R
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.data.source.remote.response.MovieResponse
import com.example.abdl.mymoviecatalogue.data.source.remote.response.TvShowResponse

object DataDummy {
    fun generateDummyMovies(): List<MoviesEntity>{
        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity(
            "1",
            "Start is Born",
            "Stefano Sollima",
            "Action, Adventure, Thriller, War",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "2",
            "Alita",
            "Simon McQuoid",
            "Action, Fantasy, Adventure",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/z8CExJekGrEThbpMXAmCFvvgoJR.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "3",
            "Aquaman",
            "Adam Wingard",
            "Science Fiction, Action, Drama",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "4",
            "Arrow",
            "Ilya Naishuller",
            "Action, Thriller, Crime, Comedy",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "5",
            "Bohemian",
            "Evan Spiliotopoulos",
            "Horror",
            "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "6",
            "Cold Persuit",
            "Kevin Nolting",
            "Family, Animation, Comedy",
            "Set before the events of ‘Soul’, 22 refuses to go to Earth, enlisting a gang of 5 new souls in attempt of rebellion. However, 22’s subversive plot leads to a surprising revelation about the meaning of life.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "7",
            "Creed",
            "Haruo Sotozaki",
            "Animation, Action, Adventure, Fantasy, Drama",
            "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "8",
            "Crimes",
            "Zack Snyder",
            "Action, Adventure, Fantasy, Science Fiction",
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/vXHzO26mJaOt4VO7ZFiM6No5ScT.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "9",
            "Doom Patrol",
            "Thomas Astruc",
            "Animation, Comedy, Family, Adventure\n",
            "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
        )
        )
        movies.add(
            MoviesEntity(
            "10",
            "Dragon Ball",
            "Carlos López Estrada",
            "Animation, Adventure, Fantasy, Family, Action\n",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/w6n1pu9thpCVHILejsuhKf3tNCV.jpg"
        )
        )
        return movies
    }

    fun generateDummyTvShows(): ArrayList<TvShowEntity>{
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
            "1",
            "Fairytail",
            "David Shore",
            "2017",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "2",
            "Family Guy",
            "Malcolm Spellman",
            "2021",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "3",
            "Flash",
            "Greg Berlanti",
            "2014",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "4",
            "Glass",
            "Dave Erickson",
            "2015",
            "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/fuVuDYrs8sxvEolnYr0wCSvtyTi.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "5",
            "God",
            "Steven S. DeKnight",
            "2021",
            "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "6",
            "Gotham",
            "Shonda Rhimes",
            "2005",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "7",
            "The Walking Dead",
            "Neil LaBute",
            "2016",
            "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "8",
            "The Umbrella",
            "Dave Filoni",
            "2021",
            "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "9",
            "The Simpson",
            "David Benioff",
            "2011",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg"
        )
        )
        tvShow.add(
            TvShowEntity(
            "10",
            "Supernatural",
            "Frank Darabont",
            "2010",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg"
        )
        )
        return tvShow
    }


    fun generateRemoteDummyMovies():List<MovieResponse>{
        val movie = ArrayList<MovieResponse>()

        movie.add(
            MovieResponse(
                "1",
                "Start is Born",
                "Stefano Sollima",
                "Action, Adventure, Thriller, War",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "2",
                "Alita",
                "Simon McQuoid",
                "Action, Fantasy, Adventure",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/z8CExJekGrEThbpMXAmCFvvgoJR.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "3",
                "Aquaman",
                "Adam Wingard",
                "Science Fiction, Action, Drama",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/m6bUeV4mczG3z2YXXr5XDKPsQzv.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "4",
                "Arrow",
                "Ilya Naishuller",
                "Action, Thriller, Crime, Comedy",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "5",
                "Bohemian",
                "Evan Spiliotopoulos",
                "Horror",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "6",
                "Cold Persuit",
                "Kevin Nolting",
                "Family, Animation, Comedy",
                "Set before the events of ‘Soul’, 22 refuses to go to Earth, enlisting a gang of 5 new souls in attempt of rebellion. However, 22’s subversive plot leads to a surprising revelation about the meaning of life.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "7",
                "Creed",
                "Haruo Sotozaki",
                "Animation, Action, Adventure, Fantasy, Drama",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "8",
                "Crimes",
                "Zack Snyder",
                "Action, Adventure, Fantasy, Science Fiction",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/vXHzO26mJaOt4VO7ZFiM6No5ScT.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "9",
                "Doom Patrol",
                "Thomas Astruc",
                "Animation, Comedy, Family, Adventure\n",
                "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
            )
        )
        movie.add(
            MovieResponse(
                "10",
                "Dragon Ball",
                "Carlos López Estrada",
                "Animation, Adventure, Fantasy, Family, Action\n",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/w6n1pu9thpCVHILejsuhKf3tNCV.jpg"
            )
        )
        return movie
    }

    fun generateRemoteDummyTvshow() : List<TvShowResponse>{
        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(
            TvShowResponse(
                "1",
                "Fairytail",
                "David Shore",
                "2017",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "2",
                "Family Guy",
                "Malcolm Spellman",
                "2021",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "3",
                "Flash",
                "Greg Berlanti",
                "2014",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "4",
                "Glass",
                "Dave Erickson",
                "2015",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/fuVuDYrs8sxvEolnYr0wCSvtyTi.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "5",
                "God",
                "Steven S. DeKnight",
                "2021",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "6",
                "Gotham",
                "Shonda Rhimes",
                "2005",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "7",
                "The Walking Dead",
                "Neil LaBute",
                "2016",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "8",
                "The Umbrella",
                "Dave Filoni",
                "2021",
                "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "9",
                "The Simpson",
                "David Benioff",
                "2011",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg"
            )
        )
        tvShow.add(
            TvShowResponse(
                "10",
                "Supernatural",
                "Frank Darabont",
                "2010",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg"
            )
        )
        return tvShow
    }
}