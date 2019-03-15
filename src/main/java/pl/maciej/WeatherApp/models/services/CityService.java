package pl.maciej.WeatherApp.models.services;

import org.springframework.stereotype.Service;
import pl.maciej.WeatherApp.models.entities.CityEntity;
import pl.maciej.WeatherApp.models.forms.CityForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CityService {

   private List<CityEntity> city = new ArrayList<>();

    public void addCity(CityForm cityForm){
        CityEntity cityEntity = new CityEntity(cityForm.getTemp(),cityForm.getAir(),cityForm.getName());
        city.add(cityEntity);
    }

    public void reset(){
        city.clear();
    }

    public LocalDate greatestTemp(){
        CityEntity tMax = new CityEntity(Integer.MIN_VALUE,0,"a");

        for(CityEntity c : city){
            if(c.getTemp()>tMax.getTemp()){
                tMax = c;
            }
        }
        if (tMax.getName().equals("a")) {
            return null;
        } else {

            return tMax.getLocalDate();

        }

    }

    public LocalDate lowestTemp() {
        CityEntity tMin = new CityEntity(Integer.MAX_VALUE, 0, "a");

        for (CityEntity c : city) {
            if (c.getTemp() < tMin.getTemp()) {
                tMin = c;
            }
        }

        if (tMin.getName().equals("a")) {
            return null;
        } else {

            return tMin.getLocalDate();

        }
    }


    public LocalDate greatestAir(){
        CityEntity aMax = new CityEntity(Integer.MIN_VALUE,0,"a");

        for(CityEntity c : city){
            if(c.getTemp()>aMax.getTemp()){
                aMax = c;
            }
        }
        if (aMax.getName().equals("a")) {
            return null;
        } else {

            return aMax.getLocalDate();

        }

    }




    public String greatestCity(){

        Map<String, Integer> cities = new HashMap<>();

        for (CityEntity cityEntity : city) {
            int counterPresent = 0;
            int sum = 0;

            for (CityEntity entity : city) {
                if(cityEntity.getName().equals(entity.getName())){
                    counterPresent++;
                    sum += entity.getTemp();
                }
            }

            cities.put(cityEntity.getName(), sum / counterPresent);
        }

        String acutalCityName = "Brak danych";
        int actualCityTemp = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> stringIntegerEntry : cities.entrySet()) {
            if(actualCityTemp < stringIntegerEntry.getValue()){
                actualCityTemp = stringIntegerEntry.getValue();
                acutalCityName = stringIntegerEntry.getKey();
            }
        }

        return acutalCityName;
    }

    public List<CityEntity> randomList(){

       city.add(new CityEntity((int)Math.random()*100,22,"Szczecin"));
       city.add(new CityEntity((int)Math.random()*100,50,"Koszalin"));


        return city;
    }

}
