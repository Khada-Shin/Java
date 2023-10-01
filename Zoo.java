public class Zoo {

    private static final int MAX_CAGES = 25;

    Animal[] animals;
    String name, city;
    final int nbrCages;

    int nbrAnimals;

    public Zoo() {
        this.nbrCages = MAX_CAGES;
        animals = new Animal[MAX_CAGES];
    }

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.nbrCages = MAX_CAGES;
        animals = new Animal[MAX_CAGES];
    }



    boolean isZooFull() {
        return nbrAnimals == MAX_CAGES;
    }

    static Zoo comparerZoo(Zoo zoo1, Zoo zoo2) {
        return (zoo1.nbrAnimals > zoo2.nbrAnimals) ? zoo1 : zoo2;
    }

    void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages/Animals: " + nbrCages);
    }

    boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1)
            return false;
        if (nbrAnimals == nbrCages)
            return false;
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    boolean removeAnimal(Animal animal) {
        int indexAnimal = searchAnimal(animal);
        if (indexAnimal == -1)
            return false;
        for (int i = indexAnimal; i < nbrAnimals; i++) {
            animals[i] = animals[i + 1];
            animals[nbrAnimals] = null;
            this.nbrAnimals--;
        }
        return true;
    }

    void displayAnimals() {
        System.out.println("Liste des animaux de " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    int searchAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.name == animals[i].name)
                return i;
        }
        return index;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", N° Cages/Animals: " + nbrCages;
    }
}
