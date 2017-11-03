package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import networking.* ;



/**
 * Created by Sander on 3-11-2017.
 */
public class Menu {
    private JTextArea textArea1;
    private JButton StartAiGame;
    private JButton reset;
    private JButton stop;
    private ReceivingServer server;
    private SharedGameState sgs;

    public Menu() {

        sgs = new SharedGameState();
        server = new ReceivingServer(sgs);


        StartAiGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendCommand("start");
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendCommand("reset");

            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendCommand("stop");
            }
        });
    }
}
