package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton view, add, remove , addevent ,viewevent, removeevent;
    
    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("Event Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        
        JLabel heading1 = new JLabel("Attendee Details");
        heading1.setBounds(620, 55, 400, 40);
        heading1.setFont(new Font("Raleway", Font.BOLD, 15));
        image.add(heading1);
        
        add = new JButton("Add Attendee");
        add.setBounds(650, 100, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Attendee");
        view.setBounds(820, 100, 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        remove = new JButton("Remove Attendee");
        remove.setBounds(650, 160, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        JLabel heading2 = new JLabel("Event Details");
        heading2.setBounds(620, 230, 400, 40);
        heading2.setFont(new Font("Raleway", Font.BOLD, 15));
        image.add(heading2);
        
        addevent = new JButton("Add Event");
        addevent.setBounds(650, 275, 150, 40);
        addevent.addActionListener(this);
        image.add(addevent);
        
        viewevent = new JButton("View Event");
        viewevent.setBounds(820, 275, 150, 40);
        viewevent.addActionListener(this);
        image.add(viewevent);
        
        removeevent = new JButton("Remove Event");
        removeevent.setBounds(650, 335, 150, 40);
        removeevent.addActionListener(this);
        image.add(removeevent);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddAttendee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewAttendee();
        }else if (ae.getSource() == remove){
            setVisible(false);
            new RemoveAttendee();
        }else if (ae.getSource() == addevent){
            setVisible(false);
            new AddEvent();
        }else if (ae.getSource() == viewevent){
            setVisible(false);
            new ViewEvent();
        }else if (ae.getSource() == removeevent){
            setVisible(false);
            new RemoveEvent();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
