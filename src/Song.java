public class Song extends Audio {
    private String genre;

    public Song(String title, String author, String path, int duration, String genre) {
        super(title, author, path, duration);
        this.genre = genre;
    }

    public String getGenre(){ return genre; }

    @Override
    public String getDisplayName(){
        return("[Song] " + title + " - " + author);
    }

    @Override
    public String getType(){
        return("Song");
    }
}