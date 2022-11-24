package task2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ActionListener, MouseListener {
    JFrame jframe;
    JPanel panel;
    JLabel label, label2;
    static JTextArea textarea;
    JTextField field;
    JButton button;

    static ServerSocket ssckt;
    static Socket sckt;
    static DataInputStream dtinpt;
    static DataOutputStream dtotpt;

    int defWidth = 700;
    int defHeight = 500;

    Server() {
        jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(defWidth, defHeight);
        jframe.setTitle("Chat app");
        jframe.setResizable(false);

        panel = new JPanel();
        panel.setBounds(0, 0, defWidth, defHeight);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255));

        label = new JLabel("Server Machine");
        label.setBounds(300, 25, 100, 25);
        label.setForeground(Color.black);

        textarea = new JTextArea();
        textarea.setBounds(50, 60, 580, 200);
        textarea.setForeground(Color.black);
        textarea.setFocusable(false);
        // set border
        textarea.setBorder(
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        label2 = new JLabel("Type your Message Here:");
        label2.setBounds(25, 290, 200, 25);
        label2.setForeground(Color.black);

        field = new JTextField();
        field.setBounds(25, 325, 500, 30);
        // field.setFocusable(false);
        field.setFont(new Font("verdana", Font.PLAIN, 15));
        field.setBackground(new Color(255, 255, 255));
        field.setForeground(new Color(0, 0, 0));

        button = new JButton("Send");
        button.setBackground(new Color(245, 245, 245));
        button.setForeground(Color.black);
        button.setBounds(540, 325, 75, 30);
        button.setFont(new Font("calibri", Font.BOLD, 12));
        button.setFocusable(false);
        button.addActionListener(this);
        button.addMouseListener(this);

        panel.add(label);
        panel.add(label2);
        panel.add(textarea);
        panel.add(field);
        panel.add(button);

        jframe.add(panel);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server();
            }
        });
        String msgin = "";
        try {
            ssckt = new ServerSocket(1201);
            sckt = ssckt.accept();
            dtinpt = new DataInputStream(sckt.getInputStream());
            dtotpt = new DataOutputStream(sckt.getOutputStream());
            while (!msgin.equals("exit")) {
                msgin = dtinpt.readUTF();
                textarea.setText(textarea.getText().trim() + "\n Client: " + msgin);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == button) {
            String msgout = "";
            try {
                msgout = field.getText().trim();
                System.out.println(msgout);
                dtotpt.writeUTF(msgout);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
