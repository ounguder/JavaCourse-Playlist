import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        Song s = findSong(title);
        if (s == null) {
            this.songs.add(new Song(title,duration));
            System.out.println(title + " is added on the album!!");

        } else {

            System.out.println("This song is already in the list!");
            return false;
        }
        return true;



    }

    private Song findSong(String title) {
        String songName;

            for (Song s : songs) {
                songName = s.getTitle();
                if (songName.equalsIgnoreCase(title)) {
                    return s;
                }
            }
            return null;

        }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if(trackNumber>0 && trackNumber <= songs.size()) {
            Song likedSong = songs.get(trackNumber - 1);
            if (likedSong != null) {
                String nameOfLikedSong = likedSong.getTitle();
                playlist.add(likedSong);
                System.out.println(nameOfLikedSong + " was successfully added your playlist!");
                return true;
            }
        } else {
            System.out.println("Track number does not exist!");


        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song likedSong = findSong(title);
        if (likedSong != null) {
            String nameOfLikedSong = likedSong.getTitle();
            playlist.add(likedSong);
            System.out.println(nameOfLikedSong + " was successfully added your playlist!");
            return true;
        } else {
            System.out.println("The song does not exist!");
            return false;
        }


    }
}
