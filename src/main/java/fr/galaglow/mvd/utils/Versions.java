package fr.galaglow.mvd.utils;

public enum Versions {
    Paper1_8_8("https://api.papermc.io/v2/projects/paper/versions/1.8.8/builds/445/downloads/paper-1.8.8-445.jar"),
    Paper1_9_4("https://api.papermc.io/v2/projects/paper/versions/1.9.4/builds/775/downloads/paper-1.9.4-775.jar");

    public final String link;
    Versions(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
}
