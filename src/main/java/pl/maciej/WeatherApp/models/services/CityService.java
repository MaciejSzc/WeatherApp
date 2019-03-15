package pl.maciej.WeatherApp.models.services;

import org.springframework.stereotype.Service;
import pl.maciej.WeatherApp.models.entities.CityEntity;
import pl.maciej.WeatherApp.models.forms.CityForm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public LocalDateTime greatestTemp(){
        CityEntity tMax = new CityEntity(0,0,"a");

        for(CityEntity c : city){
            if(c.getTemp()>tMax.getTemp()){
                tMax = c;
            }
        }
        return tMax.getLocalDateTime();

    }

    public LocalDateTime lowestTemp(){
        CityEntity tMin = new CityEntity(0,0,"a");

        for(CityEntity c : city){
            if(c.getTemp()< tMin.getTemp()){
                tMin = c;
            }
        }
        return tMin.getLocalDateTime();

    }

    public LocalDateTime greatestAir(){
        CityEntity aMax = new CityEntity(0,0,"a");

        for(CityEntity c : city){
            if(c.getTemp()>aMax.getTemp()){
                aMax = c;
            }
        }
        return aMax.getLocalDateTime();


    }




    public String greatestCity(){

        Map<String, Integer> cities = new HashMap<>();

        for (CityEntity cityEntity : city) {
            int counterPresent = 0;
            int sum = 0;

            for (CityEntity entity : city) {
                if(cityEntity.getName().equals(entity.getName())){
                    counterPresent++;
                    sum = entity.getTemp();
                }
            }

            cities.put(cityEntity.getName(), sum / counterPresent);
        }

        String acutalCityName = "error";
        int actualCityTemp = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> stringIntegerEntry : cities.entrySet()) {
            if(actualCityTemp < stringIntegerEntry.getValue()){
                actualCityTemp = stringIntegerEntry.getValue();
                acutalCityName = stringIntegerEntry.getKey();
            }
        }

        return acutalCityName;
    }


}
