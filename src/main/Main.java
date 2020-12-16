package main;

import entity.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Dog> dogs;
    public static ArrayList<Aviary> aviaries;
    public static ArrayList<Veterenarian> veterenarians;
    public static ArrayList<Worker> workers;
    public static ArrayList<Job> jobs;
    public static SquareForTraining squareForTraining;

    public static void initParams() {
        squareForTraining=new SquareForTraining();
        System.out.println();
        veterenarians=new ArrayList<>();
        veterenarians.add(new Veterenarian("Peter"));
        veterenarians.add(new Veterenarian("Sarah"));
        System.out.println();
        workers=new ArrayList<>();
        workers.add(new Worker("Jerry"));
        workers.add(new Worker("Amanda"));
        workers.add(new Worker("Joseph"));
        System.out.println();
        jobs=new ArrayList<>();
        jobs.add(new Job("Police"));
        jobs.add(new Job("Emergency"));
        System.out.println();
        aviaries=new ArrayList<>();
        for (int i=0;i<5;i++) {
            aviaries.add(new Aviary());
        }
        System.out.println();
        workers.get(0).getAviaries().add(aviaries.get(0));
        workers.get(1).getAviaries().add(aviaries.get(1));
        workers.get(1).getAviaries().add(aviaries.get(2));
        workers.get(2).getAviaries().add(aviaries.get(3));
        workers.get(2).getAviaries().add(aviaries.get(4));
        veterenarians.get(0).getAviaries().add(aviaries.get(0));
        veterenarians.get(0).getAviaries().add(aviaries.get(1));
        veterenarians.get(1).getAviaries().add(aviaries.get(2));
        veterenarians.get(1).getAviaries().add(aviaries.get(3));
        veterenarians.get(1).getAviaries().add(aviaries.get(4));
        dogs=new ArrayList<>();
        dogs.add(new Dog("Max",9.5));
        dogs.add(new Dog("Bella",8.2));
        dogs.add(new Dog("Charlie",7.8));
        dogs.add(new Dog("Molly",6.4));
        dogs.add(new Dog("Bailey",5.9));
        dogs.add(new Dog("Lucy",4.4));
        dogs.add(new Dog("Buddy",2.6));
        dogs.add(new Dog("Daisy",0.9));
        dogs.add(new Dog("Rocky",0.7));
        dogs.add(new Dog("Maggie",0.5));
        jobs.get(0).getDogs().add(dogs.get(2));
        jobs.get(0).getDogs().add(dogs.get(3));
        jobs.get(1).getDogs().add(dogs.get(4));
        jobs.get(1).getDogs().add(dogs.get(5));
        jobs.get(1).getDogs().add(dogs.get(6));
        aviaries.get(0).getDogs().add(dogs.get(8));
        aviaries.get(0).getDogs().add(dogs.get(9));
        aviaries.get(1).getDogs().add(dogs.get(0));
        aviaries.get(1).getDogs().add(dogs.get(3));
        aviaries.get(2).getDogs().add(dogs.get(1));
        aviaries.get(2).getDogs().add(dogs.get(4));
        aviaries.get(3).getDogs().add(dogs.get(2));
        aviaries.get(3).getDogs().add(dogs.get(5));
        aviaries.get(4).getDogs().add(dogs.get(6));
        aviaries.get(4).getDogs().add(dogs.get(7));
        for (Aviary aviary:aviaries) {
            for(Dog dog:aviary.getDogs()) {
                dog.setCurrentLocation(aviary);
            }
        }
    }

    public static void feedDogs() {
        for (Worker worker:workers) {
            worker.feedDogs();
        }
        System.out.println();
    }

    public static void feedDogsOfBreakfast() {
        System.out.println("It is time for breakfast");
        feedDogs();
        for (Dog dog:dogs) {
            System.out.println(dog);
        }
        System.out.println();
    }

    public static void checkHealthOfDogs() {
        System.out.println("It is time for checking health");
        for (Veterenarian veterenarian:veterenarians) {
            veterenarian.checkHealthOfDogs();
        }
        System.out.println();
        for (Dog dog:dogs) {
            System.out.println(dog);
        }
        System.out.println();
    }

    public static void washAviares() {
        System.out.println("It is time for washing aviares");
        for (Worker worker:workers) {
            worker.washAviaries();
        }
        System.out.println();
        for (Aviary aviary:aviaries) {
            System.out.println(aviary);
        }
        System.out.println();
    }

    public static void distributeDogs() {
        ArrayList<Location> locations=new ArrayList<>();
        locations.addAll(aviaries);
        locations.addAll(jobs);
        locations.add(squareForTraining);
        System.out.println("It is time for distributing dogs");
        for (Worker worker:workers) {
            worker.distributeDogs(locations);
        }
        System.out.println();
        for (Dog dog:dogs) {
            System.out.println(dog);
        }
        System.out.println();
    }

    public static void returnDogsToAviary() {
        System.out.println("It is time to return dogs to Aviary");
        for (Worker worker:workers) {
            worker.returnDogsToAviary();
        }
        System.out.println();
        for (Dog dog:dogs) {
            System.out.println(dog);
        }
        System.out.println();
    }

    public static void feedDogsOfDinner() {
        System.out.println("It is time for dinner");
        feedDogs();
        for (Dog dog:dogs) {
            System.out.println(dog);
        }
        System.out.println();
    }

    public static void main(String[] args) {
      initParams();
      feedDogsOfBreakfast();
      checkHealthOfDogs();
      washAviares();
      distributeDogs();
      returnDogsToAviary();
      feedDogsOfDinner();
    }
    
}
