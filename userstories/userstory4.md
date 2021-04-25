User Story - Playlist
==========================

**Story:** As a registered user, I want to be able to make my own playlists and save them in my account, so that I can play the same videos later again. 

**Background/Business value:** We want to be able to provide our users a better experience using our page by letting them assemble their own playlists.

**Details:** To store the user's playlists we create a new table in the database.

**Acceptance criteria:**
 - There is an option "Add to playlist" by clicking on the three dots next to the name of every video.
 - The user can choose a playlist to add this video, or create a new one
 - If the user is creating a new playlist, they are prompted to type the name of the new playlist
 - There is link at the left dropdown menu that leads to the user's playlist
 - By opening one of the playlists, all the videos are listed under each other and the user can start playing the list by any of them
 - While playing the playlist if one video ends, the next from the playlist starts automatically
