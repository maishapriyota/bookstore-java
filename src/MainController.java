import Model.*;
import java.util.Scanner;


public class MainController {

    ItemStorage<Notebook> notebookStorage;
    ItemStorage<Pencil> pencilStorage;
    ItemStorage<Gloves> glovesStorage;
    ItemStorage<Mask> maskStorage;

    private final Storage storage;
    private final Scanner scanner;

    public void run() {
        do{
            System.out.println("1. Register stocks");
            System.out.println("2. List the full stock");
            System.out.println("3. Search");
            System.out.println("4. Pick items");
            System.out.println("0. Exit");
            System.out.println();
        }while (processChoice());
    }

    private boolean processChoice(){
        int choice = getInt(0, 4);
        switch (choice) {
            case 1 -> registerBoxes();
            case 2 -> {
                System.out.println("Listing all the stocks..");
                storage.list();
            }
            case 3 -> searchBox();
            case 4 -> pickItems();
        }
        if (choice != 0){
            System.out.println();
            System.out.println("Press ENTER to continue...");
            scanner.nextLine();
        }
        return choice != 0;
    }

    private int getInt(int min, int max) {
        int i = 0;
        boolean isCorrect;
        do {
            System.out.printf("Enter a number (%d-%d)%n", min, max);
            isCorrect = true;
            try {
                i = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                isCorrect = false;
            }
        } while (!isCorrect || i < min || i > max);

        return i;
    }

    private void registerBoxes() {
        String color, itemType = null;
        int price, itemCount, pages, filtersize, safetylevel, size;
        System.out.println("What types of item you want to register?");
        System.out.println("1. Pencil");
        System.out.println("2. Notebook");
        System.out.println("3. Mask");
        System.out.println("4. Gloves");
        int choice = getInt(0, 4);

        switch (choice) {
            case 1 -> {
                System.out.print("color: ");
                color = scanner.nextLine();
                System.out.print("price: ");
                price = Integer.parseInt(scanner.nextLine());
                pencilStorage.add(new Pencil(price, color));
                itemType = pencilStorage.get();
            }
            case 2 -> {
                System.out.print("pages: ");
                pages = Integer.parseInt(scanner.nextLine());
                System.out.print("price: ");
                price = Integer.parseInt(scanner.nextLine());
                notebookStorage.add(new Notebook(price, pages));
                itemType = notebookStorage.get();
            }
            case 3 -> {
                System.out.print("filter size: ");
                filtersize = Integer.parseInt(scanner.nextLine());
                System.out.print("safety level: ");
                safetylevel = Integer.parseInt(scanner.nextLine());
                maskStorage.add(new Mask(safetylevel, filtersize));
                itemType = maskStorage.get();
            }
            case 4 -> {
                System.out.print("size: ");
                size = Integer.parseInt(scanner.nextLine());
                System.out.print("Safety level: ");
                safetylevel = Integer.parseInt(scanner.nextLine());
                glovesStorage.add(new Gloves(safetylevel, size));
                itemType = glovesStorage.get();
            }
            default -> System.out.println("The typed item cannot be packed into boxes!!!!");
        }


        System.out.println("Registering the box");
        System.out.println("--------------------------");
        System.out.print("Enter the quantity: ");
        itemCount = Integer.parseInt(scanner.nextLine());
        storage.add(BoxPackaging.createBox(itemType, itemCount));
        System.out.println(itemType + ";" + itemCount );


    }
    public void searchBox(){
        String itemType;

        System.out.println("\tSearch boxes");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.print("Item Type: ");
        itemType = scanner.nextLine();
        System.out.print("Quantity: ");
        int itemCount = scanner.nextInt();

        System.out.println("\nSearched Results\n");
        storage.find(itemType, itemCount);
    }

    public void pickItems(){
        String itemType;
        int quantity;

        System.out.println("\tPick items");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.print("Item Type: ");
        itemType = scanner.nextLine();
        System.out.print("Quantity: ");
        quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("\nSearched Results\n");
        storage.pick(itemType, quantity);
        storage.remove();
    }

    public MainController() {
        scanner = new Scanner(System.in);
        this.pencilStorage = new ItemStorage<>();
        this.notebookStorage = new ItemStorage<>();
        this.maskStorage = new ItemStorage<>();
        this.glovesStorage = new ItemStorage<>();

        this.storage = new Storage();
        storage.add(BoxPackaging.createBox("red pencil", 30));
        storage.add(BoxPackaging.createBox("437 pages notebook", 12));
        storage.add(BoxPackaging.createBox("safety level_4 glove(size 12)", 42));
        storage.add(BoxPackaging.createBox("safety level_5 mask(filter 3)", 55));
    }
}
