import java.util.ArrayList;

public final class AudioPlayer {
    private static AudioPlayer instance;
    ArrayList<Audio> playlist = new ArrayList<>();
    private int currentIndex = -1;

    private AudioPlayer() {}

    public static AudioPlayer getInstance(){
        if (instance == null) {
            instance = new AudioPlayer();
        }
        return instance;
    }

    public void addAudio(Audio a){
        playlist.add(a);
    }

    public void removeAudio(Audio a){
        playlist.remove(a);
    }

    public ArrayList<Audio> getPlaylist() {
        return playlist;
    }
}
