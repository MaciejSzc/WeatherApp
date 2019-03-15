package pl.maciej.WeatherApp.models.services;

import org.springframework.stereotype.Service;
import pl.maciej.WeatherApp.models.entities.CityEntity;
import pl.maciej.WeatherApp.models.forms.CityForm;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    List<CityEntity> city = new ArrayList<>();

    public void addCity(CityForm cityForm){
        CityEntity cityEntity = new CityEntity(cityForm.getTemp(),cityForm.getAir(),cityForm.getName());
        city.add(cityEntity);
    }

    public void reset(){
        city.clear();
    }


}
