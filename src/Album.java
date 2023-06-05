import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String albumName, String artist) {

        this.name = albumName;
        this.artist = artist;
        this.songs = new SongList();

    }

    public boolean addSong(String songName, double duration) {
        return songs.add(new Song(songName, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
       if(songs.findSong(trackNumber) != null){
           return playlist.add(songs.findSong(trackNumber));
       }
       return false;
    }

    public boolean addToPlayList(String songName, LinkedList<Song> playlist) {
        if(songs.findSong(songName) != null){
            return playlist.add(songs.findSong(songName));
        }
        return false;
    }


    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
           if(findSong(song.getTitle()) != null){
               return false;
           }
           return songs.add(song);
        }

        private Song findSong(String songTitle){
            for (int i = 0; i < songs.size(); i++) {
                if(songs.get(i).getTitle().equals(songTitle)){
                    return songs.get(i);
                }
            }
            return null;
        }

        private Song findSong(int trackNumber){
            int index = trackNumber - 1;
            if(index >= 0 && index <= songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}
