package partslist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import partslist.model.Part;
import partslist.service.PartService;

import java.util.List;

@Controller
public class PartsListController {

    private int page;

    private PartService partService;

    private int filterFlag = 1;

    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }


    @RequestMapping(value = "/")
    public ModelAndView allParts(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(required = false) Integer selectorList) {
        if (selectorList != null) filterFlag = selectorList;
        List<Part> parts = switchList(filterFlag, page);

        int partsCount = partService.partsCount();

        int pagesCount = (partsCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("parts");
        modelAndView.addObject("page", page);

        modelAndView.addObject("partsList", parts);


        modelAndView.addObject("partsCount", partsCount);
        modelAndView.addObject("pagesCount", pagesCount);

        int compsCount = partService.compsCount();
        modelAndView.addObject("compsCount", compsCount);

        this.page = page;
        return modelAndView;
    }

    private List<Part> switchList(int filterFlag, int page) {
        List<Part> result = null;

        switch (filterFlag) {
            case 1:
                result = partService.allParts(page);
                break;
            case 2:
                result = partService.allTrueParts(page);
                break;
            case 3:
                result = partService.allFalseParts(page);
                break;
        }
        return result;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchItem(@RequestParam() String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("part", new Part());
        modelAndView.addObject("partsList", partService.findByName(name));

        return modelAndView;
    }





    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(@ModelAttribute("message") String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPart(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        if (partService.checkName(part.getName())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            partService.add(part);
        } else {
            modelAndView.addObject("message","part with name \"" + part.getName() + "\" already exists");
            modelAndView.setViewName("redirect:/add");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id,
                                 @ModelAttribute("message") String message) {
        Part part = partService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("part", part);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editPart(@ModelAttribute("part") Part part) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        partService.edit(part);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePart(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Part part = partService.getById(id);
        partService.delete(part);
        return modelAndView;
    }



}
