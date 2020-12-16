package entity;

import enumeration.Category;
import lombok.*;
import java.util.Random;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dog {

  private static long counter=0;
  @Getter
  @EqualsAndHashCode.Include
  private final long ID;
  @Getter
  @Setter
  @NonNull
  private String title;
  @Getter
  private double age;
  @Getter
  private Category category;
  @Getter
  @Setter
  private boolean isSick;
  @Getter
  @Setter
  private boolean isHungry;
  @Getter
  @Setter
  private boolean isTrained;
  @Getter
  private Location currentLocation;

  public Dog(@NonNull String title,double age) {
      setAge(age);
      Random random=new Random();
      counter++;
      ID=counter;
      this.title=title;
      this.category= Category.getCategoryByAge(age);
      isSick=random.nextBoolean();
      isHungry=true;
      isTrained=random.nextBoolean();
      System.out.printf("Dog %s is created %s \n",title,toString());

  }

  public void setAge(double age) {
      if (age<0.0) throw new IllegalArgumentException();
      this.age=age;
      category=Category.getCategoryByAge(age);
  }

    public boolean setCurrentLocation(Location currentLocation) {
        if (currentLocation instanceof LocationWithListOfDogs) {
            LocationWithListOfDogs location=(LocationWithListOfDogs)currentLocation;
            if (location.getDogs().contains(this)) {
                this.currentLocation=currentLocation;
                return true;
            }
            else return false;
        }
        else {
            this.currentLocation=currentLocation;
            return true;
        }
    }
}
