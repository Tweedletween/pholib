package PhoLib.data;

import PhoLib.model.Pho;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by melina on 3/28/17.
 */
@Component
public class PhoRepository {
    private static final List<Pho> ALL_PHOS = Arrays.asList(
        new Pho("android-explosion", LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
        new Pho("ben-and-mike", LocalDate.of(2015,10,30), "Ben Jakuben", true),
        new Pho("book-dominos", LocalDate.of(2015,9,15), "Craig Dennis", false),
        new Pho("compiler-bot", LocalDate.of(2015,2,13), "Ada Lovelace", true),
        new Pho("cowboy-coder", LocalDate.of(2015,2,13), "Grace Hopper", false),
        new Pho("infinite-andrew", LocalDate.of(2015,8,23), "Marissa Mayer", true)
    );

    public Pho findByName(String name) {
        for (Pho pho : ALL_PHOS) {
            if (pho.getName().equals(name)) return pho;
        }
        return null;
    }
}
