package PhoLib.model;

import java.time.LocalDate;

/**
 * Created by melina on 3/28/17.
 */
public class Pho {
    private String name;
    private LocalDate dataUploaded;
    private String username;
    private boolean favorite;

    public Pho(String name, LocalDate dataUploaded, String username, boolean favorite) {
        this.name = name;
        this.dataUploaded = dataUploaded;
        this.username = username;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDataUploaded() {
        return dataUploaded;
    }

    public String getUsername() {
        return username;
    }

    public boolean isFavorite() {
        return favorite;
    }
}
