public class Podcast extends Audio {
    private int episodeNumber;

    public Podcast(String title, String author, String path, int duration, int episodeNumber) {
        super(title, author, path, duration);
        this.episodeNumber = episodeNumber;
    }

    public int getEpisodeNumber() { return episodeNumber; }

    @Override
    public String getDisplayName() {
        return("[Podcast] " + title + " - " + author);
    }

    @Override
    public String getType() {
        return "Podcast";
    }
}
