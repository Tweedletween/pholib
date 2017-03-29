package PhoLib.model;

import java.time.LocalDate;

/**
 * Created by melina on 3/28/17.
 */
public class Pho {
    private String name;
    private int categoryId;
    private LocalDate dateUploaded;
    private String username;
    private boolean favorite;

    public Pho(String name, int categoryId, LocalDate dataUploaded, String username, boolean favorite) {
        this.name = name;
        this.categoryId = categoryId;
        this.dateUploaded = dataUploaded;
        this.username = username;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
