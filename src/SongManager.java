import java.util.ArrayList;

public class SongManager {
    private ArrayList<Song> songList = new ArrayList<>();

    public void addSong(Song s) {
        songList.add(s);
        System.out.println(songList);
    }

    public void removeSong(Song s) {
        songList.remove(s);
    }
}
