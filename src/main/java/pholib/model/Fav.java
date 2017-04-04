package pholib.model;

import javax.persistence.*;

/**
 * Created by melina on 4/4/17.
 */
@Entity
public class Fav {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pho_id")
    private Pho pho;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Fav() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pho getPho() {
        return pho;
    }

    public void setPho(Pho pho) {
        this.pho = pho;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
