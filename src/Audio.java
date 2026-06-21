import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public abstract class Audio implements Playable {
    protected String title;
    protected String author;
    protected String path;
    protected int duration;
    protected boolean paused = false;

    protected Clip clip;
    protected long pausePosition = 0;

    public Audio(String title, String author, String path) {
        this.title = title;
        this.author = author;
        this.path = path;
        this.duration = getDurationFromFile();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPath() { return path; }
    public int getDuration() { return duration; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private void loadClip() {
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getDurationFromFile() {
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(path));

            long frames = stream.getFrameLength();
            float frameRate = stream.getFormat().getFrameRate();

            return (int) (frames / frameRate);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getFormattedDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    public abstract String getDisplayName();
    public abstract String getType();

    @Override
    public String toString() {
        return getDisplayName();
    }

    @Override
    public void play() {

        try {

            if (clip == null) {
                loadClip();
            }

            clip.setMicrosecondPosition(0);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    @Override
    public void pause() {

        if (clip != null) {
            if (!paused) {
                pausePosition = clip.getMicrosecondPosition();
                paused = true;
                clip.stop();
            } else {
                clip.setMicrosecondPosition(pausePosition);
                paused = false;
                clip.start();
            }
        }

    };

    @Override
    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.setMicrosecondPosition(0);
            pausePosition = 0;
            paused = false;
        }
    }

}
