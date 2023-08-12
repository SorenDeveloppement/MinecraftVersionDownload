package fr.galaglow.mvd;

import fr.galaglow.mvd.utils.Versions;

public class MinecraftVersionDownloader {
    private Versions mcVersion;

    public MinecraftVersionDownloader(Versions mcVersion) {
        this.mcVersion = mcVersion;
    }

    public String getMcVersionName() {
        return mcVersion.name().toLowerCase();
    }

    public

    public static void main(String[] args) {
        MinecraftVersionDownloader mvd = new MinecraftVersionDownloader(Versions.Paper1_8_8);
        System.out.println(mvd.getMcVersionName());
    }
}
