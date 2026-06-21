public class Song extends Audio {
    private String genre;

    public Song(String title, String author, String path, String genre) {
        super(title, author, path);
        this.genre = genre;
    }

    public String getGenre(){ return genre; }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getDisplayName(){
        return("[Song] " + title + " - " + author);
    }

    @Override
    public String getType(){
        return("Song");
    }
}