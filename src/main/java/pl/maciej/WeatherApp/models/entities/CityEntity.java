package pl.maciej.WeatherApp.models.entities;

import pl.maciej.WeatherApp.models.forms.CityForm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
//import java.time.ZoneId;
import java.util.Objects;

public class CityEntity {
    //ZoneId zone1 = ZoneId.of("Europe/Warsaw");//to do usunięcia, bo na sztywno całemu światu ustawiasz warszawska strefe czasowa
    private int temp;
    private int air;
    private String name;
    private LocalDate localDate;
    public CityEntity(int temp, int air, String name) {
        this.temp = temp;
        this.air = air;
        this.name = name;
        this.localDate = LocalDate.now();
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return temp == that.temp &&
                air == that.air &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, air, name);
    }
}
