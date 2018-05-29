

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ID = "";
        String name = "";
        String age = "";
        String livingPlace = "";
        String orderID = "";
        String nameOfOrder = "";
        String massa = "";
        int countOfOwners = 0;
        int countOfOrdersALL = 0;
        int countOfOrders = 0;

        Owner owners[] = new Owner[2];
        Order orders[] = new Order[4];
        try {
            FileInputStream readOwners = new FileInputStream("owners.txt");
            Scanner scanner = new Scanner(readOwners);
                while (scanner.hasNext()) {
                    ID = scanner.next();
                    name = scanner.next() + " " + scanner.next() + " " + scanner.next();
                    age = scanner.next();
                    livingPlace = scanner.next();
                    Owner owner = new Owner(ID, name, age, livingPlace, countOfOrders);
                    owners[countOfOwners] = owner;
                    countOfOwners++;
                }
            scanner.close();
            FileInputStream readOrders = new FileInputStream("orders.txt");
            Scanner scan = new Scanner(readOrders);
            while (scan.hasNext()) {
                orderID = scan.next();
                ID = scan.next();
                nameOfOrder = scan.next();
                massa = scan.next();
                Order order = new Order(orderID, ID, nameOfOrder, massa);
                orders[countOfOrdersALL] = order;
                for(int i = 0; i < owners.length; i++) {
                    if(owners[i].getID().equals(ID)) {
                        owners[i].setCountOfOrders(owners[i].getCountOfOrders());
                        break;
                    }
                }
                countOfOrdersALL++;
            }
            scan.close();
        } catch (Exception e) {

        }
       ShopService service = new ShopService();
       service.ordersEqualsMass(orders);
       service.peopleFromSameCity(owners);
       service.theBestOwner(owners);
    }

   /* public static void reader(String fileName, Owner owners[], String ID, String name, String age, String livingPlace) throws Exception {
        FileInputStream readOwners = new FileInputStream(fileName);
        Scanner scanner = new Scanner(readOwners);
        String line = "";
        if( fileName.equals("owners.txt")) {
            while (scanner.hasNext()) {
                ID = scanner.next();
                name = scanner.next() + " " + scanner.next() + " " + scanner.next() ;
                age = scanner.next();
                livingPlace = scanner.next();
                setOwners(owners, ID, name, age, livingPlace);
            }
        }
    }
    public static void setOwners(Owner owners[], String ID, String name, String age, String livingPlace) {
        owners

    }*/
}
