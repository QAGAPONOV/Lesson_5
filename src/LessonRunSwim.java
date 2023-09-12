public class LessonRunSwim {
    public static void main(String[] args) {
        Cats cat = new Cats(200);
        Dog dog = new Dog(500, 10);

        IAnimal[] animals = { cat, dog };
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.run(150));
            System.out.println(animal.run(100));
            System.out.println(animal.run(200));
            System.out.println(animal.run(50));
            System.out.println(animal.run(300));
            System.out.println(animal.run(200));
            System.out.println(animal.swim(10));
            System.out.println(animal.swim(5));
            System.out.println(animal.swim(6));
        }
        System.out.println("Animals: " + Animal.getCountOfAnimals());
    }
}

class Dog extends Animal {
    Dog(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
}

class Cats extends Animal {
    Cats(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }

    Cats(int runLimit) {
        super(runLimit, -1);
    }

    @Override
    public String swim(int distance) {
        return getClassName() + " no swim";
    }
}

abstract class Animal implements IAnimal {
    private int runLimit;
    private int swimLimit;
    private String className;
    private static int countOfAnimals = 0;

    Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();
        countOfAnimals++;
    }

    public String getClassName() {
        return className;
    }

    public static int getCountOfAnimals() {
        return countOfAnimals;
    }

    @Override
    public String run(int distance) {
        if (distance > runLimit) {
            return className + ": ran distance " + distance + " м." + " - not reached";
        } else {
            return className + ": ran distance " + distance + " м." + " OK";
        }
    }

    @Override
    public String swim(int distance) {
        if (distance > swimLimit) {
            return className + " swim distance " + distance + " м." + " - not reached";
        } else {
            return className + ": swim distance " + distance + " м." + " OK";
        }
    }

    @Override
    public String toString() {
        return className + " ran limit: " + runLimit + " м." + ", swim limit: " + swimLimit + " м.";
    }
}

interface IAnimal {
    String run(int distance);

    String swim(int distance);
}
