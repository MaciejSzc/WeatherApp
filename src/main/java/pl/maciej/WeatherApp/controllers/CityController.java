package pl.maciej.WeatherApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maciej.WeatherApp.models.forms.CityForm;
import pl.maciej.WeatherApp.models.services.CityService;

import javax.validation.Valid;

@Controller
public class CityController {
@Autowired
    CityService cityService;

    @GetMapping("/city_update")
    public String phone(Model model){

        model.addAttribute("city_form", new CityForm());

        return "cityupdate";
    }

    @PostMapping("/add/product")

    public String phone(@ModelAttribute("city_form") @Valid CityForm cityForm,
                        BindingResult bindingResult,
                        Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tekst", "Wprowadź poprawne dane");
            return "cityupdate";
        }


            return "cityupdate";

    }




}
