package entity;

import enumeration.Category;
import lombok.*;
import java.util.ArrayList;
import java.util.Optional;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Worker {

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

    public Worker(@NonNull String name) {
        counter++;
        ID=counter;
        this.name=name;
        this.aviaries=new ArrayList<>();
        System.out.printf("Worker %s is created %s \n",name,toString());
    }

    public void feedDogs() {
        for (Aviary aviary : aviaries) {
            for (Dog dog : aviary.getDogs()) {
                dog.setHungry(false);
                System.out.printf("Dog %s is fed %s by Worker %s \n",dog.getTitle(),
                        getEatByCategory(dog.getCategory()),name);
            }
        }
    }

    public void washAviaries() {
        for (Aviary aviary : aviaries) {
            System.out.printf("Worker %s washes Aviary %d \n",name,aviary.getID());
            aviary.setClean(true);
        }
    }

    public void distributeDogs(ArrayList<Location> locations) {
        for (Aviary aviary : aviaries) {
            for (Dog dog : aviary.getDogs()) {
                switch (dog.getCategory()) {
                    case PUPPY:
                        Optional<SquareForTraining> squareForTraining=locations.stream().
                                filter(i->i instanceof SquareForTraining).map(i->(SquareForTraining)i).findFirst();
                        if (squareForTraining.isPresent()) {
                            dog.setCurrentLocation(squareForTraining.get());
                            System.out.printf("Worker %s trains Dog %s at SquareForTraining \n",name,dog.getTitle());
                        }
                        else System.out.println("There isn't SquareForTraining");
                        break;
                    case ADULT:
                        Optional<Job> job=locations.stream().filter(i->i instanceof Job).map(i->(Job)i).
                                filter(i->i.getDogs().contains(dog)).findFirst();
                        if (job.isPresent()) {
                            dog.setCurrentLocation(job.get());
                            System.out.printf("Worker %s sends Dog %s at Job %s \n",name,
                                    dog.getTitle(),job.get().getTitle());
                        }
                        else System.out.printf("There isn't Job for Dog %s \n",dog.getTitle());
                        break;
                    case OLD:
                    default:
                        dog.setCurrentLocation(aviary);
                        System.out.printf("Worker %s leaves Dog %s at Aviary %d \n",name, dog.getTitle(),aviary.getID());
                }
            }
        }
    }

    public void returnDogsToAviary() {
        for (Aviary aviary : aviaries) {
            for (Dog dog : aviary.getDogs()) {
                dog.setHungry(true);
                dog.setCurrentLocation(aviary);
                System.out.printf("Worker %s returns Dog %s to Aviary %d \n",name,
                        dog.getTitle(),aviary.getID());
            }
        }
    }

    private String getEatByCategory(Category category) {
        switch (category) {
            case PUPPY:
                return "Porridge";
            case OLD:
                return "Pet food";
            case ADULT:
            default:
                return "meat";
        }
    }

}
