public abstract class Audio {
    protected String title, author, path, duration;

    public Audio(String title, String author, String path, String duration) {
        this.title = title;
        this.author = author;
        this.path = path;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPath() {
        return path;
    }

    public String getDuration() {
        return duration;
    }

    abstract String getDisplayName();
    abstract String getType();
}
