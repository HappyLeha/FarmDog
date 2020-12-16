package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Job extends LocationWithListOfDogs {

    private static long counter=0;
    @Getter
    @EqualsAndHashCode.Include
    private final long ID;
    @Getter
    private String title;

    public Job(@NonNull String title) {
        counter++;
        ID=counter;
        this.title=title;
        System.out.printf("Job %s is created %s \n",title,toString());
    }

}
