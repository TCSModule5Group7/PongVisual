package game.gui;

import java.awt.Color;
import java.awt.Component;

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

	public LogFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		JList<LogMessage> list = new JList<>();
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
		
		// just test data
		list.setListData(new LogMessage[] {
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("hkjhkjbkjyhgs", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("klfhsdfghsdjfds", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.ERROR),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.ERROR),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.ERROR),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.ERROR),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE),
			new LogMessage("sdjfhsdkfhsjf", MessageType.ERROR),
			new LogMessage("sdjfhsdkfhsjf", MessageType.MESSAGE)
		});
		
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
	
	public static void main(String[] args) {
		new LogFrame().setVisible(true);
	}
}
