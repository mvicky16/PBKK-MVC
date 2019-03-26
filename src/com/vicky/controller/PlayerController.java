package com.vicky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("Form", "player", new Player());
    }
 
    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST)
    public String submit(@ModelAttribute("player")Player player, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", player.getName());
        model.addAttribute("age", player.getAge());
        model.addAttribute("rating", player.getRating());
        
        return "playerview";
    }
}