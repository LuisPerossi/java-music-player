public abstract class Audio {
    protected String title;
    protected String author;
    protected String path;
    protected int duration;

    public Audio(String title, String author, String path, int duration) {
        this.title = title;
        this.author = author;
        this.path = path;
        this.duration = duration;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPath() { return path; }
    public int getDuration() { return duration; }

    public abstract String getDisplayName();
    public abstract String getType();
}
