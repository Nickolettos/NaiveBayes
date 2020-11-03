import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main {
	
	public Main() {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame f = new JFrame("Naive Baize App");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(515,200);

				JLabel metaFileNameLabel = new JLabel("Enter the meta file name");
				JLabel trainFileNameLabel = new JLabel("Enter the training file name");
				JLabel testFileNameLabel = new JLabel("Enter the test file name");
				JLabel outputFileNameLabel = new JLabel("Enter the output file name");
				JTextField outputFileNameTextField = new JTextField(30);
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
				outputFileNameLabel.setVisible(false); //should only be visible if meta file and test file are correct, and data was successfully trained
				outputFileNameTextField.setVisible(false); //should only be visible if meta file and test file are correct, and data was successfully trained
				
				JPanel panel = new JPanel();
				
				panel.add(metaFileNameLabel);
				panel.add(metaFileNameTextField);
				panel.add(trainFileNameLabel);
				panel.add(trainFileNameTextField);
				panel.add(testFileNameLabel);
				testFileNameLabel.setVisible(false);
				panel.add(testFileNameTextField);
				testFileNameTextField.setVisible(false);
				panel.add(outputFileNameLabel);
				panel.add(outputFileNameTextField);
				panel.add(loadButton);
				panel.add(trainButton);
				panel.add(classifyButton);
				panel.add(accuracyButton);
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
					
					if (trainFileNameTextField.getText().substring(trainFileNameTextField.getText().indexOf(".") + 1).equals("train") && 
							metaFileNameTextField.getText().substring(metaFileNameTextField.getText().indexOf(".") + 1).equals("meta")) {
								
							trainButton.setVisible(true);
							classifyButton.setVisible(true);
							accuracyButton.setVisible(true);							
					}					
				});
				

				trainButton.addActionListener(actionEvent -> {
					
					//set these as no longer visible so UI just has label, text field, and button.
					metaFileNameTextField.setVisible(false);
					metaFileNameLabel.setVisible(false);	
					trainFileNameTextField.setVisible(false);
					trainFileNameLabel.setVisible(false);	
					trainButton.setVisible(false);
					
					NB nb = new NB();
					nb.parse(metaFileNameTextField.getText());
					nb.parse(trainFileNameTextField.getText());

					testFileNameLabel.setVisible(true);
					testFileNameTextField.setVisible(true);	
					
				});

				//classify button. only classify button asks user for output file (hide determine accuracy button?) word doc says this and accuracy button are independent.
				classifyButton.addActionListener(actionEvent -> {
					
					accuracyButton.setVisible(false);
					classifyButton.setVisible(false);
					testFileNameLabel.setVisible(false);
					testFileNameTextField.setVisible(false);
					
					JLabel classifyingLabel = new JLabel("Classifying...");
					panel.add(classifyingLabel);
					classifyingLabel.setVisible(true);
					
					outputFileNameLabel.setVisible(true);
					outputFileNameTextField.setVisible(true);
			
					//classify algorithm goes here	
					
					//remove 'classifyingLabel' from panel
				});
				
				
				//accuracy button (independent of classify, hide UI elements?)
				accuracyButton.addActionListener(actionEvent -> {
			
					classifyButton.setVisible(false);
					accuracyButton.setVisible(false);
					testFileNameLabel.setVisible(false);
					testFileNameTextField.setVisible(false);
					JLabel test = new JLabel("Determining Accuracy...");
					panel.add(test);
					test.setVisible(true);
					
					//determine accuracy algorithm and output to UI code goes here

					//remove 'test' label 
				});
				
				//output file is displayed when user enters a test file and hits "classify" button. when user enters output file and hits enter, the data will be written to it
				outputFileNameTextField.addActionListener(actionEvent -> {
					
					JLabel output = new JLabel("Output file entered!");
					panel.add(output);
					output.setVisible(true);
					outputFileNameLabel.setVisible(false);
					outputFileNameTextField.setVisible(false);
					
					//get string in the output file text field and create/open a file with that name			
					String outputFileName = outputFileNameTextField.getText();
					File outputFile = new File(outputFileName);
					
					//code to write data to output file goes here
				});

				resetButton.addActionListener(actionEvent -> {
					f.dispose();
					new Main();
				});
					
			}//run() brace
		});//eventview.envokeLater() brace and parenthesis
	}//main() constructor brace

	
	public static void main(String[] args) {
		new Main();
	}
} //class brace
