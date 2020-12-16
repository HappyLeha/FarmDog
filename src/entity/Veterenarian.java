package entity;

import lombok.*;
import java.util.ArrayList;
import java.util.Random;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Veterenarian {

    private static long counter=0;
    @Getter
    @EqualsAndHashCode.Include
    private final long ID;
    @Getter
    @Setter
    @NonNull
    private String name;
    @Getter
    @ToString.Exclude
    private ArrayList<Aviary> aviaries;

    public Veterenarian(@NonNull String name) {
        counter++;
        ID=counter;
        this.name=name;
        this.aviaries=new ArrayList<>();
        System.out.printf("Veterenarian %s is created %s \n",name,toString());
    }

    public void checkHealthOfDogs() {
        for (Aviary aviary : aviaries) {
            for (Dog dog : aviary.getDogs()) {
                System.out.printf("Veterenarian %s checks Dog %s \n",name,dog.getTitle());
                if (dog.isSick()) {
                    Random random=new Random();
                    System.out.printf("Dog %s is sick \n",dog.getTitle());
                    System.out.printf("Veterenarian %s treates Dog %s \n",name,dog.getTitle());
                    boolean isSick=random.nextBoolean();
                    dog.setSick(isSick);
                    if (isSick) {
                        System.out.printf("Veterenarian %s haven't treated Dog %s \n",name,dog.getTitle());
                    }
                    else System.out.printf("Veterenarian %s have treated Dog %s \n",name,dog.getTitle());
                }
                else System.out.printf("Dog %s is not sick \n",dog.getTitle());
            }
        }
    }

}
