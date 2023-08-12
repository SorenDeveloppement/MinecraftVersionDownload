package fr.galaglow.mvd;

import fr.galaglow.mvd.utils.Versions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MinecraftVersionDownloader {
    private Versions mcVersion;
    private String downloadDirectory;

    public MinecraftVersionDownloader(Versions mcVersion, String downloadDirectory) {
        this.mcVersion = mcVersion;
        this.downloadDirectory = downloadDirectory;
    }

    public String getMcVersionName() {
        return mcVersion.name().toLowerCase();
    }

    public void downloadVersion() throws IOException {
        URL version_link = new URL(this.mcVersion.getLink());
        HttpURLConnection connection = (HttpURLConnection) version_link.openConnection();
        InputStream in = null;
        String filename = version_link.getFile();
        filename = filename.substring(filename.lastIndexOf('/') + 1);
        FileOutputStream out = new FileOutputStream(this.downloadDirectory + File.separator + filename);
        in = connection.getInputStream();
        int read = -1;
        byte[] buffer = new byte[4096];
        System.out.println("[DOWNLOAD/INFO]: Downloading file...");
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
        in.close();
        out.close();
        System.out.println("[DOWNLOAD/INFO]: File is correctly downloaded!");
    }

    private static URL verify(String url){
        if(!url.toLowerCase().startsWith("http://") || !url.toLowerCase().startsWith("https://")) {
            return null;
        }
        URL verifyUrl = null;

        try{
            verifyUrl = new URL(url);
        }catch(Exception e){
            e.fillInStackTrace();
        }
        return verifyUrl;
    }
}
