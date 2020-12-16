package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SquareForTraining implements Location {

    private static long counter=0;
    @Getter
    @EqualsAndHashCode.Include
    private final long ID;

    public SquareForTraining() {
        counter++;
        ID=counter;
        System.out.printf("SquareForTraining %d is created %s \n",ID,toString());
    }

}
