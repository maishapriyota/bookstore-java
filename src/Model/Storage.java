package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Storage{

    ArrayList<Box> boxes;
    private final Scanner scanner;
    public void add(Box box){
        boxes.add(box);
    }

    public void find(String itemType, int ignoredQuantity){
        int count = 0;
        boxes = (ArrayList<Box>) boxes.stream().sorted(Comparator.comparing(Box::getProductionDate)).
                collect(Collectors.toList());
        for(Box box: boxes){
            if(box.getItemType().equals(itemType)) {
                System.out.println(box);
                count++;
            }
        }
        if(count == 0)
            System.out.println("The box you wanted to search doesn't exist!!!");
    }

    public void pick(String itemType, int quantity){
        boxes.stream().filter(b -> b.getItemType().equals(itemType) && b.getItemCount() >= quantity).
                collect(Collectors.toList()).stream().forEach(b -> System.out.println(b));
        System.out.print("Enter the quantity of the box you want to pick: ");
        int itemCount = Integer.parseInt(scanner.nextLine());
        int finalItemCount = itemCount;
        if(isTrue()){
            boxes.stream().filter(b -> b.getItemCount() == finalItemCount).
                    collect(Collectors.toList()).stream().forEach(b -> b.setItemCount(b.getItemCount()-quantity));
            System.out.println("Items successfully picked!!");
        }
    }

    public void remove(){
        boxes.removeIf(b -> b.getItemCount() == 0);
    }
    public boolean isTrue(){
        String choice;
        boolean flag = false;
        System.out.print("Are you sure you wanna pick these items?(y/n): ");
        choice = scanner.nextLine();
        return (choice.toLowerCase().equals("y")) ? (flag = true) : (flag = false);
    }
    public void list(){
        for(Box box: boxes){
            System.out.println(box);
        }
    }
    public Storage() {
        this.scanner = new Scanner(System.in);
        this.boxes = new ArrayList<>();
    }
}
