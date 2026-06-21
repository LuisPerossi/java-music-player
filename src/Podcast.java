public class Podcast extends Audio {
    private int episodeNumber;

    public Podcast(String title, String author, String path, int episodeNumber) {
        super(title, author, path);
        this.episodeNumber = episodeNumber;
    }

    public int getEpisodeNumber() { return episodeNumber; }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    @Override
    public String getDisplayName() {
        return("[Podcast] " + title + " - " + author);
    }

    @Override
    public String getType() {
        return "Podcast";
    }
}
