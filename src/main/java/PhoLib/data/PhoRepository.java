package PhoLib.data;

import PhoLib.model.Pho;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by melina on 3/28/17.
 */
@Component
public class PhoRepository {
    private static final List<Pho> ALL_PHOS = Arrays.asList(
        new Pho("android-explosion", 1, LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
        new Pho("ben-and-mike", 2, LocalDate.of(2015,10,30), "Ben Jakuben", true),
        new Pho("book-dominos", 3, LocalDate.of(2015,9,15), "Craig Dennis", false),
        new Pho("compiler-bot", 1, LocalDate.of(2015,2,13), "Ada Lovelace", true),
        new Pho("cowboy-coder", 2, LocalDate.of(2015,2,13), "Grace Hopper", false),
        new Pho("infinite-andrew", 3, LocalDate.of(2015,8,23), "Marissa Mayer", true)
    );

    public Pho findByName(String name) {
        for (Pho pho : ALL_PHOS) {
            if (pho.getName().equals(name)) return pho;
        }
        return null;
    }

    public List<Pho> getAllPhos() {
        return ALL_PHOS;
    }

    public List<Pho> findByCategoryId(int id) {
        List<Pho> phos = new ArrayList<>();
        for (Pho pho : ALL_PHOS) {
            if (pho.getCategoryId() == id) {
                phos.add(pho);
            };
        }
        return phos;
    }
}
