import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EventReminderGUI extends JFrame {
    private ReminderManager manager;
    private JTable eventTable;
    private DefaultTableModel tableModel;

    public EventReminderGUI() {
        manager = new ReminderManager();
        manager.loadFromFile("events.csv");

        setTitle("Event Reminder System");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"Title", "Description", "Date", "Time", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        eventTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(eventTable);

        JButton addBtn = new JButton("Add Event");
        JButton completeBtn = new JButton("Mark Completed");
        JButton removeBtn = new JButton("Remove Event");
        JButton saveBtn = new JButton("Save & Exit");

        loadEventsIntoTable();

        addBtn.addActionListener(e -> addEventDialog());
        completeBtn.addActionListener(e -> markSelectedAsCompleted());
        removeBtn.addActionListener(e -> removeSelectedEvent());
        saveBtn.addActionListener(e -> {
            manager.saveToFile("events.csv");
            JOptionPane.showMessageDialog(this, "Events saved. Exiting.");
            System.exit(0);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(completeBtn);
        buttonPanel.add(removeBtn);
        buttonPanel.add(saveBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadEventsIntoTable() {
        tableModel.setRowCount(0);
        for (Event e : manager.eventList) {
            tableModel.addRow(new Object[]{e.getTitle(), e.getDescription(), e.getDate(), e.getTime(), e.getStatus()});
        }
    }

    private void addEventDialog() {
        JTextField titleField = new JTextField();
        JTextField descField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField timeField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Description:"));
        panel.add(descField);
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);
        panel.add(new JLabel("Time (HH:MM):"));
        panel.add(timeField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add Event", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            manager.addEvent(titleField.getText(), descField.getText(), dateField.getText(), timeField.getText());
            loadEventsIntoTable();
        }
    }

    private void markSelectedAsCompleted() {
        int selectedRow = eventTable.getSelectedRow();
        if (selectedRow >= 0) {
            manager.markEventCompleted(selectedRow);
            loadEventsIntoTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an event to mark as completed.");
        }
    }

    private void removeSelectedEvent() {
        int selectedRow = eventTable.getSelectedRow();
        if (selectedRow >= 0) {
            manager.removeEvent(selectedRow);
            loadEventsIntoTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an event to remove.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventReminderGUI().setVisible(true));
    }
}
