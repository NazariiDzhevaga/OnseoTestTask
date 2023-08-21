package base.constants;

public enum Hosts {
    LIVE_SCORE("https://www.livescore.com/en/");
    private String path;

    public String getPath() {
        return path;
    }

    Hosts(String path) {
        this.path = path;
    }
}