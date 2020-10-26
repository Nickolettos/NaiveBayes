
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public Main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame f = new JFrame("Naive Baize App");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(500, 200);

				JLabel fileNameLabel = new JLabel("Enter the file name");
				JTextField fileInput = new JTextField(30);
				JButton loadButton = new JButton("Load");
				JButton trainButton= new JButton("Train");
				JButton classifyButton= new JButton("Provide Classifications");
				JButton accuracyButton = new JButton("Determine accuracy");
				loadButton.setVisible(false);
				trainButton.setVisible(false);
				classifyButton.setVisible(false);
				accuracyButton.setVisible(false);
				JPanel panel = new JPanel();
				panel.add(fileNameLabel);
				panel.add(fileInput);
				panel.add(loadButton);
				panel.add(trainButton);
				panel.add(classifyButton);
				panel.add(accuracyButton);
				f.add(panel);
				f.setVisible(true);

				fileInput.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {
							loadButton.setVisible(true);
							trainButton.setVisible(true);
							classifyButton.setVisible(true);
							accuracyButton.setVisible(true);
					}
				});

				loadButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						String filename= fileInput.getText();
						NB nb= new NB();
						nb.parse(filename);
						f.dispose();
					}
				});
			}
		});
	}

	
	public static void main(String[] args) {
		new Main();
	}
}
