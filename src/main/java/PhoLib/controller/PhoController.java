package PhoLib.controller;

import PhoLib.data.PhoRepository;
import PhoLib.model.Pho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by melina on 3/27/17.
 */
@Controller
public class PhoController {
    @Autowired
    private PhoRepository phoRepository;

    @RequestMapping("/")
    public String listPhos(ModelMap modelMap) {
        List<Pho> allPhos = phoRepository.getAllPhos();
        modelMap.put("phos", allPhos);
        return "home";
    }

    @RequestMapping("/pho/{name}")
    public String phoDetails(@PathVariable String name, ModelMap modelMap) {
        Pho pho = phoRepository.findByName(name);
        modelMap.put("pho", pho);
        return "pho-details";
    }
}
