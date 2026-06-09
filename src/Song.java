public class Song extends Audio {
    String genre;
    public Song(String title, String author, String path, String duration) {
        super(title, author, path, duration);
    }

    public String getGenre(){
        return(genre);
    }

    @Override
    public String getDisplayName(){
        return(title + " - " + author);
    }

    @Override
    public String getType(){
        return("Song");
    }
}