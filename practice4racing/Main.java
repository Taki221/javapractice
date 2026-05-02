package practice4racing;


interface Runnable {
    boolean run(int distance);
}

interface Jumpable {
    boolean jump(double height);
}


class Duck implements Runnable, Jumpable {
    public boolean run(int distance) {
        System.out.println("Утка пытается пробежать " + distance + "м...");
        return distance <= 50; 
    }
    public boolean jump(double height) {
        System.out.println("Утка пытается прыгнуть на " + height + "м...");
        return height <= 0.5;
    }
}

class Robot implements Runnable, Jumpable {
    public boolean run(int distance) {
        System.out.println("Робот бежит " + distance + "м...");
        return distance <= 1000;
    }
    public boolean jump(double height) {
        System.out.println("Робот прыгает на " + height + "м...");
        return height <= 2.0;
    }
}

class Dog implements Runnable, Jumpable {
    public boolean run(int distance) {
        System.out.println("Собака бежит " + distance + "м...");
        return distance <= 500;
    }
    public boolean jump(double height) {
        System.out.println("Собака прыгает на " + height + "м...");
        return height <= 1.0;
    }
}


class Obstacle {
    public boolean pass(Object participant) {
        return true;
    }
}

class Track extends Obstacle {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean pass(Object participant) {
        if (participant instanceof Runnable) {
            return ((Runnable) participant).run(distance);
        }
        return false;
    }
}

class Wall extends Obstacle {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean pass(Object participant) {
        if (participant instanceof Jumpable) {
            return ((Jumpable) participant).jump(height);
        }
        return false;
    }
}



public class Main {
    public static void main(String[] args) {
        
        Object[] participants = {
            new Duck(),
            new Robot(),
            new Dog()
        };

        Obstacle[] obstacles = {
            new Track(40),
            new Wall(0.4),
            new Track(200),
            new Wall(1.5)
        };

        System.out.println("Соревнования: \n");

        for (Object p: participants) {
            String type = p.getClass().getSimpleName();
            System.out.println("\n На дистанции: " + type);

            boolean canContinue = true;

            for (Obstacle obs: obstacles) {

                if(!obs.pass(p)) {
                    System.out.println(type + " не справился");
                    canContinue = false;
                    break;
                }
            }
            if (canContinue) {
                System.out.println(type + " прошел все испытания.");
            }
        }
    }
}
