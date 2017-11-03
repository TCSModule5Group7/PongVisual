package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import networking.*;



/**
 * Created by Sander on 3-11-2017.
 */
public class Menu {
    private JTextArea textArea1;
    private JButton StartAiGame;
    private JButton Start1v1;
    private JButton exit;

    public Menu() {

        ReceivingServer receivingServer = new Receivingserver();


        StartAiGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Start1v1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
