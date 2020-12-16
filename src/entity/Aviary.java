package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Aviary extends LocationWithListOfDogs {

    private static long counter=0;
    @Getter
    @EqualsAndHashCode.Include
    private final long ID;
    @Getter
    @Setter
    private boolean isClean;

    public Aviary() {
        counter++;
        ID=counter;
        isClean=false;
        System.out.printf("Aviary %d is created %s \n",ID,toString());
    }

}
