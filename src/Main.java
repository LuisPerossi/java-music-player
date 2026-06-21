void main() {
    AudioPlayer.getInstance().loadPlaylist();

    PlayerFrame player = new PlayerFrame();
    player.setVisible(true);
}
