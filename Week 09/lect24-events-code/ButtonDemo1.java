import java.awt.*;         // basic AWT classes
import java.awt.event.*;   // event classes
import javax.swing.*;      // Swing classes

/**
 * Very simple demo of Swing event handling.  
 * Create a window with a single button that prints a message when it's clicked.
 * Version 1 with named inner class to handle button events.
 */ 
public class ButtonDemo1 {
  
  // inner class to handle button events
  private static class MyButtonListener implements ActionListener {
    final String id;
    private int nEvents = 0;
    
    /** Create a new MyButtonListener */
    public MyButtonListener(String id) {
      this.id = id;
    }

    /**
     * Respond to events generated by the button by printing the
     * command and number of times the event has been triggered.
     * @param e the event created by the button when it was clicked.
     */
    public void actionPerformed(ActionEvent e) {
      nEvents++;
      System.out.println(id + " " + e.getActionCommand() + " " + nEvents);
    }
  }
  
  
  public static void main(String[] args) {
    // Create new window and set it to exit from application when closed.
    JFrame frame = new JFrame("Button Demo");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    // Create a new button with label "Hit me" and string "OUCH!" to be
    // returned as part of each action event.
    JButton button = new JButton("Hit me");
    button.setActionCommand("OUCH!");

    button.addActionListener(new MyButtonListener("Listener1"));
    
    // Experiment: add two ButtonListeners
    // button.addActionListener(new MyButtonListener("Listener2"));
    // button.addActionListener(new MyButtonListener("Listener3"));

    // Experiment: add a single ButtonListener twice
    // MyButtonListener mbl = new MyButtonListener("Listener4");
    // button.addActionListener(mbl);
    // button.addActionListener(mbl);

    // Add button to the window and make it visible.
    frame.add(button);
    frame.pack();
    frame.setVisible(true);
  }
}
