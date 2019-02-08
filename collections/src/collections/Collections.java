
package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class Collections {


    public static void main(String[] args) throws IOException {
        
        menu();

    }
    
    public static void menu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Choose which collection you would like to demo.");
        System.out.println("a - ArrayList" + 
                         "\nl - LinkedList" +
                         "\nt - TreeSet" + 
                         "\nh - HashMap" +
                         "\nq - Quit");
        String choice = br.readLine();
        switch (choice) {
            case "a":
                doArrayList(); //lists
                break;
            case "l":
                doLinkedList(); //queues
                break;
            case "t":
                doTreeSet(); //trees
                break;
            case "h":
                doHashMap(); //maps
                break;
            case "q":
                break;
        }

    }
    
    
    public static void doLinkedList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("You will be prompted to enter 3 sets of User info.");
        
        user userA = new user();
        user userB = new user();
        user userC = new user();
        
        LinkedList<user> ll = new LinkedList();
        
        //prompt for and store various inputs for userA
        System.out.println("\nEnter User Name: ");
        userA.setName(br.readLine());
        System.out.println("Enter User Age: ");
        userA.setAge(Integer.parseInt(br.readLine()));
        System.out.println("Enter User City: ");
        userA.setCity(br.readLine());
        System.out.println("\nInfo for User A:" +
                           "\nName: " + userA.getName() +
                           "\nAge: " + userA.getAge() +
                           "\nCity: " + userA.getCity());
        
        //prompt for and store various inputs for userB
        System.out.println("\nEnter User Name: ");
        userB.setName(br.readLine());
        System.out.println("Enter User Age: ");
        userB.setAge(Integer.parseInt(br.readLine()));
        System.out.println("Enter User City: ");
        userB.setCity(br.readLine());
        System.out.println("\nInfo for User B:" +
                           "\nName: " + userB.getName() +
                           "\nAge: " + userB.getAge() +
                           "\nCity: " + userB.getCity());
        
        //prompt for and store various inputs for userC
        System.out.println("\nEnter User Name: ");
        userC.setName(br.readLine());
        System.out.println("Enter User Age: ");
        userC.setAge(Integer.parseInt(br.readLine()));
        System.out.println("Enter User City: ");
        userC.setCity(br.readLine());
        System.out.println("\nInfo for User C:" +
                           "\nName: " + userC.getName() +
                           "\nAge: " + userC.getAge() +
                           "\nCity: " + userC.getCity());
        
        ll.add(userA);
        ll.add(userB);
        ll.add(userC);
        
        System.out.println("\nThe LinkedList can store objects and other collections.");
        System.out.println("These are Java user objects that we reference by their attribute.\n");
        
        for (int i = 0; i < ll.size(); i++) {
            System.out.println("Contents of LinkedList index " + i + ": " + ll.get(i).name + ", " + ll.get(i).age + ", " + ll.get(i).city);
        }
        System.out.println("\n");
        menu();
    }
    
    public static void doArrayList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList al = new ArrayList();
        
        //prompt for and store various inputs for arrayList
        System.out.println("This is the ArrayList demo." +
                           "\nInitially, it has 0 elements." +
                           "\nYou will be prompted to enter 5 names." + 
                           "\nEach entry will add an element to the ArrayList");
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nEnter Name " + i + ": ");
            al.add(br.readLine());
        }
        
        System.out.println("Contents of ArrayList: " + al);
        System.out.println("End of ArrayList Demo.\n");
        
        menu();
    }
    
    public static void doTreeSet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        TreeSet ts = new TreeSet();
        
        //prompt for and store various inputs for TreeSet
        System.out.println("This is the TreeSet demo." +
                           "\nInitially, it has 0 elements." +
                           "\nYou will be prompted to enter 5 names." + 
                           "\nEach entry will be added to the TreeSet." +
                           "\nEntries will be sorted before they are stored." +
                           "\nEnsure that at least there is one set of duplicates in your entries." +
                           "\nThis will demonstrate the TreeSet's inability to store duplicate values.");
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nEnter Name " + i + ": ");
            ts.add(br.readLine());
        }
        
        System.out.println("Contents of TreeSet: " + ts);
        System.out.println(ts.size() + " entries were accepted.");
        System.out.println("Elements are sorted before they are stored.");
        System.out.println("End of TreeSet Demo.\n");
        
        menu();
    }
    
    public static void doHashMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> hm = new HashMap();
        
        //prompt for and store various inputs for HashMap
        System.out.println("This is the HashMap demo." +
                           "\nInitially, it has 0 elements." +
                           "\nYou will be prompted to enter 5 names and ages." + 
                           "\nEach entry will be added to the HashMap." +
                           "\nEntries will not necessarily maintain any specific order." +
                           "\nEnsure that at least there is one set of duplicate names in your entries." +
                           "\nThis will demonstrate the HashMap's inability to store duplicate keys." + 
                           "\nThe value of the last duplicate key is the value stored to that key.");
        
        String name;
        int age;
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nEnter Name " + i + ": ");
            name = br.readLine();
            System.out.println("\nEnter Age " + i + ": ");
            age = Integer.parseInt(br.readLine());
            hm.put(name,age);
        }
        
        System.out.println("Contents of HashMap: " + hm);
        System.out.println(hm.size() + " complete entries were accepted.");
        
        System.out.println("\nType one of the names entered to retrieve their age from the HashMap:");
        System.out.println("This person is " + hm.get(br.readLine()) + " years old.");
        
        System.out.println("End of HashMap Demo.\n");
        
        menu();
    }
    

}
