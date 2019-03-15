package pl.maciej.WeatherApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maciej.WeatherApp.models.forms.CityForm;
import pl.maciej.WeatherApp.models.services.CityService;

import javax.validation.Valid;

@Controller
public class CityController {
@Autowired
    CityService cityService;

    @GetMapping("/city/update")
    public String city(Model model){

        model.addAttribute("city_form", new CityForm());

        return "city_update";
    }

    @GetMapping("/weather")
    public String weather(Model model){
        model.addAttribute("list", cityService);

    //    model.addAttribute("maxTemp", cityService.greatestAir())

        return "weather";
    }

    @GetMapping("/delete")
    public String delete(){
        cityService.reset();
        return "redirect:/weather";
    }

    @GetMapping("/sample")
    public String sample(Model model){
        model.addAttribute("list",cityService.randomList());
        return "redirect:/weather";
    }

    @PostMapping("/city/update")

    public String city(@ModelAttribute("city_form") @Valid CityForm cityForm,
                        BindingResult bindingResult,
                        Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tekst", "Niepoprawne dane");
            return "city_update";
        }

            cityService.addCity(cityForm);
            return "city_update";

    }






}
