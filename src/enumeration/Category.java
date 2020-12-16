package enumeration;

public enum Category {

    PUPPY,
    ADULT,
    OLD;

   public static Category getCategoryByAge(double age) {
      if (age<1.0) return PUPPY;
      else if (age<8.0) return ADULT;
           else return OLD;
   }

}
