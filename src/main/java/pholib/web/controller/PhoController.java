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
        model.addAttribute("action","/phos");
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("heading","Add photo");
        model.addAttribute("submit","Add");

        return "pho/form";
    }

    @RequestMapping("/phos/{phoId}/edit")
    public String formNewPho(@PathVariable Long phoId, Model model) {
        if (!model.containsAttribute("pho")) {
            model.addAttribute("pho", phoService.findById(phoId));
        }
        model.addAttribute("action",String.format("/phos/%s", phoId));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("heading","Edit photo");
        model.addAttribute("submit","Update");

        return "pho/form";
    }

    // Add a new photo
    @RequestMapping(value = "/phos", method = RequestMethod.POST)
    public String addPho(Pho pho, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
        phoService.save(pho, file);

        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Photo successfuly uploaded", FlashMessage.Status.SUCCESS));

        return String.format("redirect:/phos/%s", pho.getId());
    }

    // Update an exsiting photo
    @RequestMapping(value = "/phos/{phoId}", method = RequestMethod.POST)
    public String editPho(Pho pho, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {

        phoService.save(pho, file);
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Photo successfuly updated", FlashMessage.Status.SUCCESS));

        return "redirect:/";
    }

    @RequestMapping(value = "/phos/{phoId}/delete", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable Long phoId, RedirectAttributes redirectAttributes) {
        Pho pho = phoService.findById(phoId);

        phoService.delete(pho);
        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Pho deleted", FlashMessage.Status.SUCCESS));

        return "redirect:/";
    }
}
