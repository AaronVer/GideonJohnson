package zoo;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {

        System.out.println("cat".compareTo("dog"));
        System.out.println("dog".compareTo("cat"));




        // So these are objects, created with the *Animal* class, with names that start with
        // *a*, and passing on information like *giraffe* that later gets integrated into the object's
        // strings to fill their species string
        Animal a1 = new Animal("giraffe");
        Animal a2 = new Animal("cow");
        Animal a3 = new Animal("shark");
        Animal a4 = new Animal("lion");
        Animal a5 = new Animal("lion");
        Animal a6 = new Animal("Zebra");

        System.out.println(a1.compareTo(a2));

        System.out.println(a2.compareTo(a3));


        AnimalTree<Animal> tree = new AnimalTree<Animal>();

        ArrayList<String> list1 = new ArrayList<>();
        //ArrayList<Cookie> list2 = new ArrayList<>();


       tree.add(a1);
        tree.add(a2);
        tree.add(a3);
        tree.add(a4);
        tree.add(a5);
        System.out.println("does the tree contain lion?");
        System.out.println(tree.contains(a5));
        System.out.println("does the tree contain zebra?");
        System.out.println(tree.contains(a6));

        /*
        Lists
            -ordered elements
            Array lists
            Linked lists
        Sets
            -unique elements
            Hashsets
            Treesets
        Queues
            -elements must be entered/removed in a specific order
            -stacks, queues
            arraydeque, priorityqueue
        Maps
            -key/value pairs, not necessarily iterable
            -treemap, hashmap
         */


   }
}