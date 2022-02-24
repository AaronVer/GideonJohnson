package zoo;

public class AnimalTree<T extends Comparable<T>> {

    //Creates first Branch object named "head"
    AnimalBranch<T> head;

    public AnimalTree() {

    }

    // Animal Branches are objects as well as Animals. This creates a new Branch object named Head, then
    // begins the tree process. Because each Branch has a Left and a Right, it is able to continue downwards
    // and create the overall tree structure.
    public boolean add(T a) {
        // the head starts at the top of the tree. If it is null, then that means the
        // tree hasn't started yet. So this fills the first slot out.
        if (head == null) {
            System.out.println("Added as head: " + a);
            head = new AnimalBranch(a);
        } else {
            AnimalBranch current = head;
            while(true){
//                // With hash comparison, if the thing we're adding (which is 'a') is less than the head slot,
                // then we branch left and create a new child slot to place it in.
                // Of course, to avoid deleting data, we will only place it in if the slot is currently null...
                if (current.getAnimal().compareTo(a) < 0) {
                    System.out.println("Current animal: " + current + ", Branching left");
                    // if it's null, fill the slot with our animal
                    if (current.left == null) {
                        current.left = new AnimalBranch(a);
                        System.out.println("Added animal: " + a);
                        return true;
                        // if it isn't null, then we repeat the process to go to the child slots. We continue
                        // this until we find an empty slot to go in.
                    } else {
                        current = current.left;
                    }
                    // if the has is greater than the current slot pointed to we branch right instead of left.
                } else if (current.getAnimal().compareTo(a) > 0) {
                    System.out.println("Current animal: " + current + "Branching right");
                    if (current.right == null) {
                        current.right = new AnimalBranch(a);
                        System.out.println("Added animal: " + a);
                        return true;
                    } else {
                        // continue searching for a space that isn't null, but changing what the
                        // currently examined slot is and letting the loop repeat itself.
                        current = current.right;
                    }
                } else {
                    System.out.println("Species " + a + "already exists!");
                    return false;
                }
            }
        }

        return false;
    }
    // Start of the "contains function"
    public boolean contains(T a) {
        if (head == null) {
            System.out.println("Added as head: " + a);
            return false;
        } else {
            AnimalBranch current = head;
            while (true) {
                // Go left if our animal is less than the current slot, go right if it is more than.
                if (current.getAnimal().compareTo(a) < 0) {
                    System.out.println("Current animal: " + current + ", Branching left");
                    if (current.left == null) {
                        System.out.println("Animal does not exist: " + a);
                        return false;
                    } else {
                        current = current.left;
                    }
                } else if (current.getAnimal().compareTo(a) > 0) {
                    System.out.println("Current animal: " + current + "Branching right");
                    if (current.right == null) {
                        current.right = new AnimalBranch(a);
                        System.out.println("Animal does not exist: " + a);
                        return false;
                    } else {
                        current = current.right;
                    }
                } else {
                    System.out.println("Species " + a + "already exists!");
                    return true;
                }
            }
        }
    }
/*
time complexity:
if the tree were balanced:
searching for an animal would scale logarithmically with regards
to expanding the total amounts of animals
compared to eg an unsorted array, in which case searching for something would expand
linearly with regards to the total amount of items
(ie, we iterate through everything)
eg:
linked list insert is O(1)
array insert is O(1)
tree insert is O(log(n))
let's say we have data structures where we maintain sorting
linked list insert in order is O(n)
array insert in order is O(n)
tree insert in order is O(log(n))
 */
}