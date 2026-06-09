public class Podcast extends Audio {
    String podcastName;
    public Podcast(String title, String author, String path, String duration) {
        super(title, author, path, duration);
    }

    public String getPodcastName(){
        return(podcastName);
    }

    @Override
    public String getDisplayName(){
        return(title + " - " + author);
    }

    @Override
    public String getType(){
        return("Podcast");
    }
}
