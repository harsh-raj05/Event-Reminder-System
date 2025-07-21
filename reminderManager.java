// ReminderManager.java
import java.util.ArrayList;

public class reminderManager{
    public ArrayList<Event> eventList;

    public reminderManager(){
        eventList=new ArrayList<>();
    }

    public void addEvent(String title,String description,String date,String time){
        Event e=new Event(title,description,date,time);
        eventList.add(e);
        System.out.println("Event added successfully.\n");
    }

    public void showAllEvents(){
        if (eventList.isEmpty()){
            System.out.println("No events found.\n");
            return;
        }
        System.out.println("All Events:");
        for (int i=0;i<eventList.size();i++) {
            System.out.println("Event #"+(i+1));
            eventList.get(i).displayEvent();
        }
    }

    public void showEventsOnDate(String searchDate){
        boolean found=false;
        for (Event e:eventList) {
            if (e.getDate().equals(searchDate)){
                e.displayEvent();
                found=true;
            }
        }
        if (!found){
            System.out.println("No events found on "+searchDate);
        }
    }

    public void markEventCompleted(int index){
        if (index>=0 && index<eventList.size()){
            eventList.get(index).markAsCompleted();
            System.out.println("Event marked as completed.");
        } else{
            System.out.println("Invalid event number.");
        }
    }

    public void showCompletedEvents(){
        boolean found=false;
        for (Event e:eventList){
            if (e.getStatus().equalsIgnoreCase("Completed")){
                e.displayEvent();
                found=true;
            }
        }
        if (!found){
            System.out.println("No completed events found.");
        }
    }

    public void updateEventStatus(int index,String newStatus){
        if (index>=0 && index<eventList.size()){
            Event e=eventList.get(index);
            if (newStatus.equalsIgnoreCase("Completed")){
                e.markAsCompleted();
                System.out.println("Event marked as Completed.");
            } else if (newStatus.equalsIgnoreCase("Pending")){
                e.setStatus("Pending");
                System.out.println("Event marked as Pending.");
            } else{
                System.out.println("Invalid status. Use 'Pending' or 'Completed'.");
            }
        } else{
            System.out.println("Invalid event number.");
        }
    }

    public void removeEvent(int index){
        if (index>=0 && index<eventList.size()) {
            eventList.remove(index);
            System.out.println("Event removed successfully.");
        } else{
            System.out.println("Invalid event number.");
        }
    }
}
