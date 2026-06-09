void main() {
    PlayerFrame player = new PlayerFrame();
    player.setVisible(true);

    AudioPlayer player1 = AudioPlayer.getInstance();

    player1.addAudio(
            new Song("Bohemiam Rapsody",
            "Queen",
            "queen.mp3",
            "4:30"
            )
    );

    player1.addAudio(
            new Song(
                    "Minueto in G",
                    "Luis Perossi",
                    "minueto.mp3",
                    "2:34"
            )
    );

    for(Audio audio : player1.getPlaylist()){
        System.out.println(audio.getType() + ":" + audio.getDisplayName());
    }

}
