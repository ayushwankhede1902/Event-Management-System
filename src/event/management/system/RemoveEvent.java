package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEvent extends JFrame implements ActionListener {
    
    Choice cEventId;
    JButton delete, back;
    
    RemoveEvent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelId = new JLabel("Id");
        labelId.setBounds(50, 50, 100, 30);
        add(labelId);
        
        cEventId = new Choice();
        cEventId.setBounds(200, 50, 150, 30);
        add(cEventId);
        
        try {
            Conn c = new Conn();
            String query = "select * from events";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cEventId.add(rs.getString("EventId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelEventname = new JLabel("Event Name");
        labelEventname.setBounds(50, 100, 100, 30);
        add(labelEventname);
        
        JLabel lblEventname = new JLabel();
        lblEventname.setBounds(200, 100, 100, 30);
        add(lblEventname);
        
        JLabel labelContact = new JLabel("Contact");
        labelContact.setBounds(50, 150, 100, 30);
        add(labelContact);
        
        JLabel lblContact = new JLabel();
        lblContact.setBounds(200, 150, 100, 30);
        add(lblContact);
        
        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 200, 100, 30);
        add(labelEmail);
        
        JLabel lblEmail = new JLabel();
        lblEmail.setBounds(200, 200, 100, 30);
        add(lblEmail);
        
        try {
            Conn c = new Conn();
            String query = "select * from events where EventId = '"+cEventId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblEventname.setText(rs.getString("Eventname"));
                lblContact.setText(rs.getString("Contact"));
                lblEmail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cEventId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from events where EventId = '"+cEventId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblEventname.setText(rs.getString("Eventname"));
                        lblContact.setText(rs.getString("Contact"));
                        lblEmail.setText(rs.getString("Email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from events where EventID = '"+cEventId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Event Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEvent();
    }
}

