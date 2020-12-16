package entity;

import lombok.Getter;
import lombok.ToString;
import java.util.ArrayList;

@ToString
public abstract class LocationWithListOfDogs implements Location {

    @Getter
    @ToString.Exclude
    private ArrayList<Dog> dogs=new ArrayList<>();

}
