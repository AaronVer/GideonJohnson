package zoo;

// This is creating a generic called "T" to be used for the class.
public class AnimalBranch<T extends Comparable<T>> {

    // The generic being used here indicates that "animal" can be any data type.
    private T animal;
    // What I believe these do is that they make it so whenever a Branch object gets created,
    // two more Branch objects below it are primed to be made as well (they are sub-objects, but have the same
    // potential and coding). However, since they have not recieved a data type yet, they are not immedietly
    // created. Thus preventing an infinite loop of object creation from going off).
    AnimalBranch left;
    AnimalBranch right;

    public AnimalBranch() {

    }

    // Accepts any data type, then assigns that to the "animal" variable. This is a very simple constructor
    // and object it's making
    public AnimalBranch(T a){
        animal = a;
    }

    public int compareTo(AnimalBranch<T> a){
        return animal.compareTo(a.animal);
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public AnimalBranch getLeft() {
        return left;
    }

    public void setLeft(AnimalBranch left) {
        this.left = left;
    }

    public AnimalBranch getRight() {
        return right;
    }

    public void setRight(AnimalBranch right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return animal.toString();
    }


}