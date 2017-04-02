package pholib.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pholib.model.Pho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import pholib.service.CategoryService;
import pholib.service.PhoService;
import pholib.web.FlashMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melina on 3/27/17.
 */
@Controller
public class PhoController {
    @Autowired
    private PhoService phoService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String listPhos(Model model) {
        List<Pho> phos = phoService.findAll();
        model.addAttribute("phos", phos);
        return "pho/index";
    }

    @RequestMapping("/phos/{phoId}")
    public String PhoDetails(@PathVariable Long phoId, Model model) {
        Pho pho = phoService.findById(phoId);

        model.addAttribute("pho", pho);
        return "pho/details";
    }

    @RequestMapping("/phos/{phoId}.gif")
    @ResponseBody
    public byte[] phoImg(@PathVariable Long phoId) {
        return phoService.findById(phoId).getBytes();
    }

    @RequestMapping("/favorites")
    public String favorites(Model model){
        List<Pho> favs = new ArrayList<>();
        model.addAttribute("phos", favs);
        model.addAttribute("username", "Melina");
        return "pho/favorites";
    }

    @RequestMapping("/upload")
    public String formNewPho(Model model) {

        model.addAttribute("pho", new Pho());
        model.addAttribute("categories", categoryService.findAll());

        return "pho/form";
    }

    @RequestMapping(value = "/phos", method = RequestMethod.POST)
    public String addPho(Pho pho, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        phoService.save(pho, file);
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Pho successfuly uploaded", FlashMessage.Status.SUCCESS));
        return String.format("redirect:/phos/%s", pho.getId());
    }
}
