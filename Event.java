// Event.java
public class Event{
    private String title;
    private String description;
    private String date; 
    private String time; 
    private String status;
    private int reminderOffset; 

    public Event(String title,String description,String date,String time,int reminderOffset){
        this.title=title;
        this.description=description;
        this.date=date;
        this.time=time;
        this.status="Pending";
        this.reminderOffset = reminderOffset;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public void markAsCompleted(){
        this.status="Completed";
    }

    public int getReminderOffset() {
    return reminderOffset;
}

    public void setReminderOffset(int reminderOffset) {
        this.reminderOffset = reminderOffset;
    }

    public void displayEvent(){
        System.out.println("Title      : "+title);
        System.out.println("Description: "+description);
        System.out.println("Date       : "+date);
        System.out.println("Time       : "+time);
        System.out.println("Status     : "+status);
        System.out.println("----------------------------");
    }
}
