public class Lesson_5_1 {
    //Задача про котов и тарелки с едой
    public static void main(String[] args) {
        Cat[] cats = { new Cat("Barsic", 10), new Cat("Vasya", 20), new Cat("Boris", 30) };
        Plate plate = new Plate(70, 40);
        System.out.println(plate);

        // feeding cats first time
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println(plate);
        plate.add(40);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.setFullness(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    void setFullness(boolean status) {
        fullness = status;
    }

    void eat(Plate plate) {
        if (!fullness) {
            fullness = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return "name = " + name + ", apetite = " + appetite + ", fullness = " + fullness;
    }
}

class Plate {
    private int volume;
    private int food;

    Plate(int volume, int food) {
        this.volume = volume;
        this.food = food;
    }

    boolean decreaseFood(int portion) {
        if (food < portion) {
            return false;
        }
        food -= portion;
        return true;
    }

    void add(int food) {
        if (this.food + food <= volume) {
            this.food += food;
        }
    }
    @Override
    public String toString() {
        return "food on plate: " + food;
    }
}
