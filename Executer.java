// Executer.java
import java.util.*;


public class Executer{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        reminderManager manager=new reminderManager();
        manager.loadFromFile("events.csv");
        int choice;

        do {
            System.out.println("\n===== Event Reminder Menu =====");
            System.out.println("1. Add Event");
            System.out.println("2. View All Events");
            System.out.println("3. View Events by Date");
            System.out.println("4. Mark Event as Completed");
            System.out.println("5. View Completed Events");
            System.out.println("6. Update Event Status");
            System.out.println("7. Remove Event");
            System.out.println("8. Exit and save the file");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice){
                case 1:
                    System.out.print("Enter event title: ");
                    String title=sc.nextLine();
                    System.out.print("Enter event description: ");
                    String desc=sc.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date=sc.nextLine();
                    System.out.print("Enter time (HH:MM): ");
                    String time=sc.nextLine();
                    manager.addEvent(title,desc,date,time);
                    break;

                case 2:
                    manager.showAllEvents();
                    break;

                case 3:
                    System.out.print("Enter date to search (YYYY-MM-DD): ");
                    String searchDate=sc.nextLine();
                    manager.showEventsOnDate(searchDate);
                    break;

                case 4:
                    manager.showAllEvents();
                    System.out.print("Enter event number to mark as completed: ");
                    int compNum=sc.nextInt();
                    sc.nextLine();
                    manager.markEventCompleted(compNum-1);
                    break;

                case 5:
                    manager.showCompletedEvents();
                    break;

                case 6:
                    manager.showAllEvents();
                    System.out.print("Enter event number to update: ");
                    int upNum=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status (Pending/Completed): ");
                    String status=sc.nextLine();
                    manager.updateEventStatus(upNum-1,status);
                    break;

                case 7:
                    manager.showAllEvents();
                    System.out.print("Enter event number to remove: ");
                    int delNum=sc.nextInt();
                    sc.nextLine();
                    manager.removeEvent(delNum-1);
                    break;

                case 8:
                    manager.saveToFile("events.csv");
                    System.out.println("Exiting Event Reminder System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice!=8);

        sc.close();
    }
}
