package me.joshshin.datalayer.network

/**
 * Created by Josh Shin on 4/15/18
 */

internal object MockApiResponses {
    val mockPopularMoviesResponse =
            // Pardon this apallingly long string
            """{"page":1,"total_results":19817,"total_pages":991,"results":[{"vote_count":1376,"id":337167,"video":false,"vote_average":6.1,"title":"Fifty Shades Freed","popularity":519.823591,"poster_path":"\/jjPJ4s3DWZZvI4vw8Xfi4Vqa1Q8.jpg","original_language":"en","original_title":"Fifty Shades Freed","genre_ids":[18,10749],"backdrop_path":"\/9ywA15OAiwjSTvg3cBs9B7kOCBF.jpg","adult":false,"overview":"Believing they have left behind shadowy figures from their past, newlyweds Christian and Ana fully embrace an inextricable connection and shared life of luxury. But just as she steps into her role as Mrs. Grey and he relaxes into an unfamiliar stability, new threats could jeopardize their happy ending before it even begins.","release_date":"2018-02-07"},{"vote_count":6931,"id":269149,"video":false,"vote_average":7.7,"title":"Zootopia","popularity":336.561584,"poster_path":"\/sM33SANp9z6rXW8Itn7NnG1GOEs.jpg","original_language":"en","original_title":"Zootopia","genre_ids":[16,12,10751,35],"backdrop_path":"\/mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg","adult":false,"overview":"Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.","release_date":"2016-02-11"},{"vote_count":3902,"id":354912,"video":false,"vote_average":7.8,"title":"Coco","popularity":265.013236,"poster_path":"\/eKi8dIrr8voobbaGzDpe8w0PVbC.jpg","original_language":"en","original_title":"Coco","genre_ids":[12,35,10751,16],"backdrop_path":"\/askg3SMvhqEl4OL52YuvdtY40Yb.jpg","adult":false,"overview":"Despite his family’s baffling generations-old ban on music, Miguel dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector, and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history.","release_date":"2017-10-27"},{"vote_count":474,"id":447332,"video":false,"vote_average":7.5,"title":"A Quiet Place","popularity":193.662421,"poster_path":"\/nAU74GmpUk7t5iklEp3bufwDq4n.jpg","original_language":"en","original_title":"A Quiet Place","genre_ids":[18,27,53,878],"backdrop_path":"\/nIrDm42dy5PaXtUAzUfPmxM4mQm.jpg","adult":false,"overview":"A family is forced to live in silence while hiding from creatures that hunt by sound.","release_date":"2018-04-05"},{"vote_count":1342,"id":333339,"video":false,"vote_average":7.9,"title":"Ready Player One","popularity":184.684943,"poster_path":"\/pU1ULUq8D3iRxl1fdX2lZIzdHuI.jpg","original_language":"en","original_title":"Ready Player One","genre_ids":[12,878,28],"backdrop_path":"\/q7fXcrDPJcf6t3rzutaNwTzuKP1.jpg","adult":false,"overview":"When the creator of a popular video game system dies, a virtual contest is created to compete for his fortune.","release_date":"2018-03-28"},{"vote_count":4128,"id":284054,"video":false,"vote_average":7.3,"title":"Black Panther","popularity":174.954107,"poster_path":"\/uxzzxijgPIY7slzFvMotPv8wjKA.jpg","original_language":"en","original_title":"Black Panther","genre_ids":[28,12,14,878],"backdrop_path":"\/b6ZJZHUdMEFECvGiDpJjlfUWela.jpg","adult":false,"overview":"King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without.  Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister,  members of the Dora Milaje (the Wakandan \"special forces\"), and an American secret agent, to prevent Wakanda from being dragged into a world war.","release_date":"2018-02-13"},{"vote_count":4954,"id":181808,"video":false,"vote_average":7.1,"title":"Star Wars: The Last Jedi","popularity":169.166627,"poster_path":"\/kOVEVeg59E0wsnXmF9nrh6OmWII.jpg","original_language":"en","original_title":"Star Wars: The Last Jedi","genre_ids":[14,12,878],"backdrop_path":"\/oVdLj5JVqNWGY0LEhBfHUuMrvWJ.jpg","adult":false,"overview":"Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares to do battle with the First Order.","release_date":"2017-12-13"},{"vote_count":805,"id":353616,"video":false,"vote_average":6.4,"title":"Pitch Perfect 3","popularity":153.047331,"poster_path":"\/fchHLsLjFvzAFSQykiMwdF1051.jpg","original_language":"en","original_title":"Pitch Perfect 3","genre_ids":[35,10402],"backdrop_path":"\/f5a9YRvJ7uSM0JAtEI59sqKRnVg.jpg","adult":false,"overview":"After the highs of winning the world championships, the Bellas find themselves split apart and discovering there aren't job prospects for making music with your mouth. But when they get the chance to reunite for an overseas USO tour, this group of awesome nerds will come together to make some music, and some questionable decisions, one last time.","release_date":"2017-12-21"},{"vote_count":288,"id":347882,"video":false,"vote_average":5.2,"title":"Sleight","popularity":143.392697,"poster_path":"\/wridRvGxDqGldhzAIh3IcZhHT5F.jpg","original_language":"en","original_title":"Sleight","genre_ids":[18,53,28,878],"backdrop_path":"\/zKZqtGKmysHNbmsJQWS51rywROw.jpg","adult":false,"overview":"A young street magician is left to take care of his little sister after his mother's passing and turns to drug dealing in the Los Angeles party scene to keep a roof over their heads. When he gets into trouble with his supplier, his sister is kidnapped and he is forced to rely on both his sleight of hand and brilliant mind to save her.","release_date":"2017-04-28"},{"vote_count":7597,"id":198663,"video":false,"vote_average":7,"title":"The Maze Runner","popularity":139.386514,"poster_path":"\/coss7RgL0NH6g4fC2s5atvf3dFO.jpg","original_language":"en","original_title":"The Maze Runner","genre_ids":[28,9648,878,53],"backdrop_path":"\/lkOZcsXcOLZYeJ2YxJd3vSldvU4.jpg","adult":false,"overview":"Set in a post-apocalyptic world, young Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow “runners” for a shot at escape.","release_date":"2014-09-10"},{"vote_count":5564,"id":284053,"video":false,"vote_average":7.4,"title":"Thor: Ragnarok","popularity":132.350475,"poster_path":"\/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg","original_language":"en","original_title":"Thor: Ragnarok","genre_ids":[28,12,14],"backdrop_path":"\/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg","adult":false,"overview":"Thor is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.","release_date":"2017-10-25"},{"vote_count":7971,"id":321612,"video":false,"vote_average":6.8,"title":"Beauty and the Beast","popularity":122.883964,"poster_path":"\/tWqifoYuwLETmmasnGHO7xBjEtt.jpg","original_language":"en","original_title":"Beauty and the Beast","genre_ids":[10751,14,10749],"backdrop_path":"\/6aUWe0GSl69wMTSWWexsorMIvwU.jpg","adult":false,"overview":"A live-action adaptation of Disney's version of the classic tale of a cursed prince and a beautiful young woman who helps him break the spell.","release_date":"2017-03-16"},{"vote_count":993,"id":338970,"video":false,"vote_average":6.1,"title":"Tomb Raider","popularity":118.594303,"poster_path":"\/ePyN2nX9t8SOl70eRW47Q29zUFO.jpg","original_language":"en","original_title":"Tomb Raider","genre_ids":[28,12,14],"backdrop_path":"\/yVlaVnGRwJMxB3txxwA24XurSNp.jpg","adult":false,"overview":"Lara Croft, the fiercely independent daughter of a missing adventurer, must push herself beyond her limits when she finds herself on the island where her father disappeared.","release_date":"2018-03-08"},{"vote_count":4129,"id":141052,"video":false,"vote_average":6.4,"title":"Justice League","popularity":114.011632,"poster_path":"\/eifGNCSDuxJeS1loAXil5bIGgvC.jpg","original_language":"en","original_title":"Justice League","genre_ids":[28,12,14,878],"backdrop_path":"\/o5T8rZxoWSBMYwjsUFUqTt6uMQB.jpg","adult":false,"overview":"Fuelled by his restored faith in humanity and inspired by Superman's selfless act, Bruce Wayne and Diana Prince assemble a team of metahumans consisting of Barry Allen, Arthur Curry and Victor Stone to face the catastrophic threat of Steppenwolf and the Parademons who are on the hunt for three Mother Boxes on Earth.","release_date":"2017-11-15"},{"vote_count":3464,"id":399055,"video":false,"vote_average":7.3,"title":"The Shape of Water","popularity":107.116625,"poster_path":"\/k4FwHlMhuRR5BISY2Gm2QZHlH5Q.jpg","original_language":"en","original_title":"The Shape of Water","genre_ids":[18,14,10749],"backdrop_path":"\/rgyhSn3mINvkuy9iswZK0VLqQO3.jpg","adult":false,"overview":"An other-worldly story, set against the backdrop of Cold War era America circa 1962, where a mute janitor working at a lab falls in love with an amphibious man being held captive there and devises a plan to help him escape.","release_date":"2017-12-01"},{"vote_count":1217,"id":274855,"video":false,"vote_average":5.7,"title":"Geostorm","popularity":105.612522,"poster_path":"\/nrsx0jEaBgXq4PWo7SooSnYJTv.jpg","original_language":"en","original_title":"Geostorm","genre_ids":[28,878,53],"backdrop_path":"\/79X8JkGxzc1tJMi0KxUSaPLooVg.jpg","adult":false,"overview":"After an unprecedented series of natural disasters threatened the planet, the world's leaders came together to create an intricate network of satellites to control the global climate and keep everyone safe. But now, something has gone wrong: the system built to protect Earth is attacking it, and it becomes a race against the clock to uncover the real threat before a worldwide geostorm wipes out everything and everyone along with it.","release_date":"2017-10-13"},{"vote_count":12491,"id":118340,"video":false,"vote_average":7.9,"title":"Guardians of the Galaxy","popularity":105.342608,"poster_path":"\/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg","original_language":"en","original_title":"Guardians of the Galaxy","genre_ids":[28,878,12],"backdrop_path":"\/bHarw8xrmQeqf3t8HpuMY7zoK4x.jpg","adult":false,"overview":"Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.","release_date":"2014-07-30"},{"vote_count":3568,"id":353486,"video":false,"vote_average":6.6,"title":"Jumanji: Welcome to the Jungle","popularity":99.147428,"poster_path":"\/bXrZ5iHBEjH7WMidbUDQ0U2xbmr.jpg","original_language":"en","original_title":"Jumanji: Welcome to the Jungle","genre_ids":[28,12,35,10751],"backdrop_path":"\/cpz070zEKbPGXzCWuQsNt42PqXY.jpg","adult":false,"overview":"The tables are turned as four teenagers are sucked into Jumanji's world - pitted against rhinos, black mambas and an endless variety of jungle traps and puzzles. To survive, they'll play as characters from the game.","release_date":"2017-12-09"},{"vote_count":14205,"id":24428,"video":false,"vote_average":7.5,"title":"The Avengers","popularity":98.377622,"poster_path":"\/cezWGskPY5x7GaglTTRN4Fugfb8.jpg","original_language":"en","original_title":"The Avengers","genre_ids":[878,28,12],"backdrop_path":"\/hbn46fQaRmlpBuUrEiFqv0GDL6Y.jpg","adult":false,"overview":"When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!","release_date":"2012-04-25"},{"vote_count":1265,"id":336843,"video":false,"vote_average":7.2,"title":"Maze Runner: The Death Cure","popularity":95.784481,"poster_path":"\/7GgZ6DGezkh3szFdvskH5XD4V0t.jpg","original_language":"en","original_title":"Maze Runner: The Death Cure","genre_ids":[28,9648,878,53,12,14],"backdrop_path":"\/bvbyidkMaBls1LTaIWYY6UmYTaL.jpg","adult":false,"overview":"Thomas leads his group of escaped Gladers on their final and most dangerous mission yet. To save their friends, they must break into the legendary Last City, a WCKD-controlled labyrinth that may turn out to be the deadliest maze of all. Anyone who makes it out alive will get answers to the questions the Gladers have been asking since they first arrived in the maze.","release_date":"2018-01-17"}]}"""
}