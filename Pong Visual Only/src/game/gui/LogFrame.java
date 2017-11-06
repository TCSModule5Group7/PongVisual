package game.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

public class LogFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<LogMessage> model;

	public LogFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setBackground(Color.BLACK);
		contentPane = new JPanel();
		
		model = new DefaultListModel<>();
		
		JList<LogMessage> list = new JList<>();
		list.setModel(model);
		list.setBackground(Color.GRAY);
		list.setCellRenderer(new ListCellRenderer<LogMessage>() {
			@Override
			public Component getListCellRendererComponent(JList<? extends LogMessage> list, LogMessage value, int index,
					boolean isSelected, boolean cellHasFocus) {
				JLabel l = new JLabel(value.getText());
				if (value.getType() == MessageType.MESSAGE) {
					l.setForeground(Color.GREEN);
				}
				else {
					l.setForeground(Color.RED);
				}
				return l;
			}
		});
		JScrollPane scrollPane = new JScrollPane(list);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		contentPane.setLayout(gl_contentPane);
		setContentPane(contentPane);
	}
	
	public void log(String s, MessageType t) {
		model.addElement(new LogMessage(s,t));
	}
}
