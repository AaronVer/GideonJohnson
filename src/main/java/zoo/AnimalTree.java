package zoo;

public class AnimalTree<T extends Comparable<T>> {

    AnimalBranch<T> head;

    public AnimalTree() {

    }


//    process:
//    check if head exists
//    if exists, check if left child exists
//    if left child exists, switch currently examined branch to left child
//    new branch is greater than current branch, so check if right child exists
//    right child does not exist, so we set current.right to a new animalBranch

//    our toolbox:
//    we will need to keep track of the current branch
//    we will need to continue while a empty slot has not been found
//    we will need to check if head is null first


    // Double and tripple check to see if the below function is correct
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
                // how do we decide if go left or right in the tree search?
                // we do this by having a method that compares the new item to whatever
                // branch we're looking at
                if (current.getAnimal().compareTo(a) < 0) {
                    System.out.println("Current animal: " + current + ", Branching left");
//                    what if we need to move left, but that space is empty?
//                    we set that new item to the new animal
//                    we also exit out of the add method: our job is complete
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