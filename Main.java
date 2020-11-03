
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	public Main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame f = new JFrame("Naive Baize App");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(515, 200);

				JLabel metaFileNameLabel = new JLabel("Enter the meta file name");
				JLabel trainFileNameLabel = new JLabel("Enter the training file name");
				JLabel testFileNameLabel = new JLabel("Enter the test file name");
				JTextField metaFileNameTextField = new JTextField(30);
				JTextField trainFileNameTextField = new JTextField(30);
				JTextField testFileNameTextField = new JTextField(30);
				
				JButton loadButton = new JButton("Load");
				JButton trainButton= new JButton("Train");
				JButton classifyButton= new JButton("Provide Classifications");
				JButton accuracyButton = new JButton("Determine accuracy");
				JButton resetButton = new JButton("Reset");
				loadButton.setVisible(false);
				trainButton.setVisible(false);
				classifyButton.setVisible(false);
				accuracyButton.setVisible(false);
				JPanel panel = new JPanel();
				panel.add(metaFileNameLabel);
				panel.add(metaFileNameTextField);
				panel.add(trainFileNameLabel);
				panel.add(trainFileNameTextField);
				panel.add(testFileNameLabel);
					testFileNameLabel.setVisible(false);
				panel.add(testFileNameTextField);
					testFileNameTextField.setVisible(false);
				panel.add(loadButton);
				panel.add(trainButton);
				panel.add(classifyButton);
				panel.add(accuracyButton);
				panel.add(resetButton);
				f.add(panel);
				f.setVisible(true);

				metaFileNameTextField.addActionListener(actionEvent -> {
					if(metaFileNameTextField.getText().substring(metaFileNameTextField.getText().indexOf(".") + 1).equals("meta") &&
							trainFileNameTextField.getText().substring(trainFileNameTextField.getText().indexOf(".") + 1).equals("train")){

						trainButton.setVisible(true);
						classifyButton.setVisible(true);
						accuracyButton.setVisible(true);
					}
				});

				trainFileNameTextField.addActionListener(actionEvent -> {
					if(metaFileNameTextField.getText().substring(metaFileNameTextField.getText().indexOf(".") + 1).equals("meta") &&
							trainFileNameTextField.getText().substring(trainFileNameTextField.getText().indexOf(".") + 1).equals("train")){

						trainButton.setVisible(true);
						classifyButton.setVisible(true);
						accuracyButton.setVisible(true);
					}
				});

				trainButton.addActionListener(actionEvent -> {
					NB nb = new NB();

					nb.parse(metaFileNameTextField.getText());
					nb.parse(trainFileNameTextField.getText());

					testFileNameLabel.setVisible(true);
					testFileNameTextField.setVisible(true);

					metaFileNameTextField.setVisible(false);
					trainFileNameTextField.setVisible(false);
					metaFileNameLabel.setVisible(false);
					trainButton.setVisible(false);
				});

				resetButton.addActionListener(actionEvent -> {
					f.dispose();
					new Main();
				});
			}
		});
	}

	
	public static void main(String[] args) {
		new Main();
	}
}
