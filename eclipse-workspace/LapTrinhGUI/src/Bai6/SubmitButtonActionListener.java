package Bai6;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SubmitButtonActionListener implements ActionListener {
	
	private JFrame frame;
    private JList<String> categoryList;
    private DefaultListModel<String> listModel;
    
    public SubmitButtonActionListener(JFrame frame, JList<String> list, DefaultListModel<String> listModel) {
    	this.frame = frame;
    	this.categoryList = list;
    	this.listModel = listModel;
    }
    
	 @Override
     public void actionPerformed(ActionEvent e) {
         // Get selected categories
         List<String> selectedCategories = new ArrayList<>();
         for (int index : categoryList.getSelectedIndices()) {
             selectedCategories.add(listModel.getElementAt(index));
         }

         // Display selected categories
         String message = "Selected Categories: ";
         if (selectedCategories.isEmpty()) {
             message += "None";
         } else {
             for (String category : selectedCategories) {
                 message += category + ", ";
             }
             message = message.substring(0, message.length() - 2); // Remove trailing comma and space
         }

         JOptionPane.showMessageDialog(frame, message);
     }
}
