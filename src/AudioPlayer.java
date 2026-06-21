import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public final class AudioPlayer {
    private static AudioPlayer instance;
    ArrayList<Audio> playlist = new ArrayList<>();
    private Audio currentAudio;

    private AudioPlayer() {}

    public static AudioPlayer getInstance(){
        if (instance == null) {
            instance = new AudioPlayer();
        }
        return instance;
    }

    public void addAudio(Audio a){
        playlist.add(a);
        savePlaylist();
    }
    public void removeAudio(Audio a){
        playlist.remove(a);
        savePlaylist();
    }

    public ArrayList<Audio> getPlaylist() {
        return playlist;
    }

    public Audio getCurrentAudio() {
        return currentAudio;
    }
    public void setCurrentAudio(Audio currentAudio) {
        this.currentAudio = currentAudio;
    }

    public void playCurrent() {
        if (currentAudio != null) {
            currentAudio.play();
        }
    }

    public void pauseCurrent() {
        if (currentAudio != null) {
            currentAudio.pause();
        }
    }

    public void next() {
        if (currentAudio == null) { return; }

        currentAudio.stop();

        int index = playlist.indexOf(currentAudio);

        if (index < playlist.size() - 1) {
            currentAudio = playlist.get(index + 1);
        } else { currentAudio = playlist.getFirst(); }

        currentAudio.play();
    }

    public void previous() {
        if (currentAudio == null) { return; }

        currentAudio.stop();

        int index = playlist.indexOf(currentAudio);

        if (index > 0) {
            currentAudio = playlist.get(index - 1);
        } else { currentAudio = playlist.getLast(); }

        currentAudio.play();
    }

    public void savePlaylist() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("playlist.txt"))) {

            for (Audio a : playlist) {

                if (a instanceof Song) {
                    writer.println(
                            "Song;" +
                            a.getTitle() + ";" +
                            a.getAuthor() + ";" +
                            a.getPath() + ";" +
                            ((Song) a).getGenre()
                    );

                } else if (a instanceof  Podcast) {
                    writer.println(
                            "Podcast;" +
                            a.getTitle() + ";" +
                            a.getAuthor() + ";" +
                            a.getPath() + ";" +
                            ((Podcast) a).getEpisodeNumber()
                    );
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPlaylist() {
        File file = new File("playlist.txt");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("playlist.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts[0].equals("Song")) {
                    playlist.add(new Song(
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4]
                    ));
                } else if (parts[0].equals("Podcast")) {
                    playlist.add(new Podcast(
                            parts[1],
                            parts[2],
                            parts[3],
                            Integer.parseInt(parts[4])
                    ));
                }

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to load previous playlist!");
            e.printStackTrace();
        }
    }

}
