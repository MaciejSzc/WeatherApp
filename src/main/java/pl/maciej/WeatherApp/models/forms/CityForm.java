package pl.maciej.WeatherApp.models.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class CityForm {
    @Min(-80)
    @Max(80)
    private int temp;
    @Min(0)
    @Max(100)
    private int air;
    @Pattern(regexp = "[A-Za-z]+")
    private String name;

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
        CityForm cityForm = (CityForm) o;
        return temp == cityForm.temp &&
                air == cityForm.air &&
                Objects.equals(name, cityForm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, air, name);
    }
}
