package javacoursework;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Used to create class MenuInfo which implements ActionListener class.
 * This class creates the entire GUI of the 'Laptop Information System'
 * Some classes from javax.swing package and some from java.awt package and some java.util are imported in this class.
 * This class has 40 attributes, a constructor and 8 methods for creating GUI components and event handling.
 * @author (Prajan Acharya, Mohit Paudel, Khiman Thapa, Sanchay Chapagain) 
 * Created on November 20,2017
 */

public class MenuInfo implements ActionListener {

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    private JMenuItem open, exit, userGuide, about;
    private JLabel backgroundImage, laptopInfo, laptopId, brand, color, model, processor, price, tableTitle;
    private JTextField laptopIdText, modelText, colorText, priceText, searchText;
    private JComboBox brandCombo, laptopsAvailableCombo;
    private Container pane;
    private JPanel titlePanel, processorPanel, laptopEntryPanel, jtablePanel;
    private JRadioButton i3, i5, i7;
    private JButton insertButton, clearButton, clearTableButton, searchButton, searchLaptopsButton;
    private JTable menuDetails;
    private DefaultTableModel dtm;
    private ArrayList<LaptopInfo> priceSearchList = new <LaptopInfo> ArrayList();

    /**
     * Constructor of class MenuInfo
     * Initializes initializes some GUI components.
     * Calls several methods responsible for creating the GUI components. 
     */
    public MenuInfo() {
        frame = new JFrame("Laptop Information System");

        ImageIcon systemBackground = new ImageIcon("background3.jpg");
        backgroundImage = new JLabel(systemBackground);
        frame.setContentPane(backgroundImage);

        pane = frame.getContentPane();
        pane.setLayout(null);

        createMenus();

        Border entryPanelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        titlePanel = new JPanel();
        pane.add(titlePanel);
        titlePanel.setLayout(null);
        titlePanel.setBackground(Color.DARK_GRAY);
        titlePanel.setBounds(350, 10, 330, 50);
        titlePanel.setBorder(entryPanelBorder);

        laptopInfo = new JLabel("Laptop Information System");
        titlePanel.add(laptopInfo);
        Font f = new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 23);
        laptopInfo.setFont(f);
        laptopInfo.setForeground(Color.ORANGE);
        laptopInfo.setBounds(10, 0, 350, 40);

        createLaptopDetails_EntryForm();

        createTable();

        createSearchComponents();

        frame.setVisible(true);
        frame.setSize(1060, 640);
        frame.setResizable(false);
    }

    /**
     * main method of class MenuInfo which creates an object of the same class
    */
    public static void main(String[] args) {
        MenuInfo object=new MenuInfo();
    }
    
    /**
     * This method creates the menu bar, menu and menu items and also adds icon to the menu items.
     * adds action listener to menu items
    */
    public void createMenus() {
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        ImageIcon openImage = new ImageIcon("open.png");
        ImageIcon exitImage = new ImageIcon("exitImage.png");
        ImageIcon userGuideImage = new ImageIcon("userGuide.png");
        ImageIcon aboutImage = new ImageIcon("about.png");

        fileMenu = new JMenu("File");
        fileMenu.addActionListener(this);
        menuBar.add(fileMenu);

        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        helpMenu.addActionListener(this);

        open = new JMenuItem("Open", openImage);
        fileMenu.add(open);
        open.addActionListener(this);

        exit = new JMenuItem("Exit", exitImage);
        fileMenu.add(exit);
        exit.addActionListener(this);

        userGuide = new JMenuItem("User Guide", userGuideImage);
        helpMenu.add(userGuide);
        userGuide.addActionListener(this);

        about = new JMenuItem("About", aboutImage);
        helpMenu.add(about);
        about.addActionListener(this);
    }
    
    /**
     * This method creates various GUI components which can be used to enter the details of the laptops.
     * adds action listener to insert button and clear button
    */
    public void createLaptopDetails_EntryForm() {
        Border entryPanelBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

        laptopEntryPanel = new JPanel();
        pane.add(laptopEntryPanel);
        laptopEntryPanel.setBounds(20, 130, 300, 365);
        laptopEntryPanel.setLayout(null);
        laptopEntryPanel.setBorder(entryPanelBorder);
        ImageIcon systemBackground = new ImageIcon("background3.jpg");
        laptopEntryPanel.setBackground(Color.DARK_GRAY);

        laptopId = new JLabel("Laptop Id");
        laptopEntryPanel.add(laptopId);
        laptopId.setBounds(20, 20, 80, 25);
        laptopId.setForeground(Color.ORANGE);

        laptopIdText = new JTextField();
        laptopEntryPanel.add(laptopIdText);
        laptopIdText.setBounds(110, 20, 150, 25);

        brand = new JLabel("Brand");
        laptopEntryPanel.add(brand);
        brand.setBounds(20, 55, 80, 25);
        brand.setForeground(Color.ORANGE);

        brandCombo = new JComboBox();
        laptopEntryPanel.add(brandCombo);
        brandCombo.setBounds(110, 55, 150, 25);
        brandCombo.addItem("Dell");
        brandCombo.addItem("Lenovo");
        brandCombo.addItem("Acer");
        brandCombo.addItem("Apple");
        brandCombo.addItem("Asus");

        model = new JLabel("Model Name");
        laptopEntryPanel.add(model);
        model.setBounds(20, 90, 80, 25);
        model.setForeground(Color.ORANGE);

        modelText = new JTextField();
        laptopEntryPanel.add(modelText);
        modelText.setBounds(110, 90, 150, 25);

        processor = new JLabel("Processor");
        laptopEntryPanel.add(processor);
        processor.setBounds(20, 125, 80, 25);
        processor.setForeground(Color.ORANGE);

        Border processorPanelBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        processorPanel = new JPanel();
        laptopEntryPanel.add(processorPanel);
        processorPanel.setLayout(null);
        processorPanel.setBounds(20, 150, 240, 50);
        processorPanel.setBorder(processorPanelBorder);

        i3 = new JRadioButton("i3");
        processorPanel.add(i3);
        i3.setBounds(5, 15, 40, 25);
        i3.setSelected(true);

        i5 = new JRadioButton("i5");
        processorPanel.add(i5);
        i5.setBounds(90, 15, 40, 25);

        i7 = new JRadioButton("i7");
        processorPanel.add(i7);
        i7.setBounds(175, 15, 40, 25);

        ButtonGroup grp = new ButtonGroup();
        grp.add(i3);
        grp.add(i5);
        grp.add(i7);

        color = new JLabel("Color");
        laptopEntryPanel.add(color);
        color.setBounds(20, 210, 80, 25);
        color.setForeground(Color.ORANGE);

        colorText = new JTextField();
        laptopEntryPanel.add(colorText);
        colorText.setBounds(110, 210, 150, 25);

        price = new JLabel("Price");
        laptopEntryPanel.add(price);
        price.setBounds(20, 240, 80, 25);
        price.setForeground(Color.ORANGE);

        priceText = new JTextField();
        laptopEntryPanel.add(priceText);
        priceText.setBounds(110, 240, 150, 25);

        ImageIcon insertIcon = new ImageIcon("insertImage.png");
        ImageIcon clearIcon = new ImageIcon("clearImage.png");

        insertButton = new JButton("Insert", insertIcon);
        laptopEntryPanel.add(insertButton);
        insertButton.setBounds(40, 300, 100, 30);
        insertButton.addActionListener(this);

        clearButton = new JButton("Clear", clearIcon);
        laptopEntryPanel.add(clearButton);
        clearButton.setBounds(150, 300, 100, 30);
        clearButton.addActionListener(this);

    }
    
    /**
     * This method creates a table which stores the details of the laptops and a clear button which clears all the data from the table.
     * adds action listener to clear button
    */
    public void createTable() {
        
        Border tablePanelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);

        jtablePanel = new JPanel();
        pane.add(jtablePanel);
        jtablePanel.setLayout(null);
        jtablePanel.setBounds(360, 130, 650, 365);
        jtablePanel.setBorder(tablePanelBorder);
        jtablePanel.setBackground(Color.DARK_GRAY);

        Font f = new Font("SansSerif", Font.BOLD | Font.ITALIC, 18);

        tableTitle = new JLabel("Menu Details");
        tableTitle.setBounds(275, 5, 150, 25);
        jtablePanel.add(tableTitle);
        tableTitle.setForeground(Color.ORANGE);
        tableTitle.setFont(f);

        String[] columns = {"Laptop Id", "Brand", "Model Name", "Processor", "Color", "Price"};
        Object[][] rows = new Object[20][6];

        dtm = new DefaultTableModel(rows, columns);

        menuDetails = new JTable(dtm);
        menuDetails.setEnabled(false);
        menuDetails.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(menuDetails);
        jtablePanel.add(scrollPane);
        scrollPane.setBounds(5, 30, 640, 330);

        ImageIcon clearTableImage = new ImageIcon("clearTableImage.png");

        clearTableButton = new JButton("Clear Table", clearTableImage);
        pane.add(clearTableButton);
        clearTableButton.setBounds(360, 510, 130, 30);
        clearTableButton.addActionListener(this);

    }

    /**
     * This methods creates the search buttons which can be used to search the laptops either being based on brand or on price.
     * adds action listener to Search button and View Laptops Available button
    */
    public void createSearchComponents() {

        ImageIcon searchImage = new ImageIcon("searchIcon.png");
        ImageIcon viewImage = new ImageIcon("viewIcon.png");

        searchText = new JTextField();
        pane.add(searchText);
        searchText.setBounds(790, 85, 100, 30);

        searchButton = new JButton("Search", searchImage);
        pane.add(searchButton);
        searchButton.setBounds(900, 85, 110, 30);
        searchButton.addActionListener(this);

        laptopsAvailableCombo = new JComboBox();
        pane.add(laptopsAvailableCombo);
        laptopsAvailableCombo.setBounds(710, 510, 100, 30);
        laptopsAvailableCombo.addItem("Dell");
        laptopsAvailableCombo.addItem("Lenovo");
        laptopsAvailableCombo.addItem("Acer");
        laptopsAvailableCombo.addItem("Apple");
        laptopsAvailableCombo.addItem("Asus");

        searchLaptopsButton = new JButton("View Laptops Available", viewImage);
        pane.add(searchLaptopsButton);
        searchLaptopsButton.setBounds(815, 510, 195, 30);
        searchLaptopsButton.addActionListener(this);

    }

    /**
     * This method gets called when any of the buttons of GUI or any menu items of the GUI is pressed.
     * It is responsible for event handling.
     */
    public void actionPerformed(ActionEvent ae) {
        // for event handling if Insert button is pressed
        if (ae.getSource() == insertButton) {
            if (!laptopIdText.getText().equals("") && !modelText.getText().equals("") && !priceText.getText().equals("")) {
                try {
                    String laptopId = laptopIdText.getText();
                    int idOfLaptop = Integer.parseInt(laptopId);
                    String brand = (String) brandCombo.getSelectedItem();
                    String modelName = modelText.getText();
                    String processor = "";
                    if (i3.isSelected() == true) {
                        processor = "i3";
                    } else if (i5.isSelected() == true) {
                        processor = "i5";
                    } else if (i7.isSelected() == true) {
                        processor = "i7";
                    }
                    String colorOfLaptop = colorText.getText();
                    String priceOfLaptop = priceText.getText();

                    try {
                        double price = Double.parseDouble(priceOfLaptop);
                        String[] dataForTable = {laptopId, brand, modelName, processor, colorOfLaptop, priceOfLaptop};

                        int numberOfRows = menuDetails.getRowCount();
                        int numberOfColumns = menuDetails.getColumnCount();
                        boolean emptyCondition = false;
                        int rowCount = 0;
                        do {
                            String rowData = (String) menuDetails.getValueAt(rowCount, 0);
                            if (rowData != null && rowData.length() != 0) {
                                rowCount++;
                            } else {
                                emptyCondition = true;
                            }
                        } while (rowCount <= numberOfRows && emptyCondition != true);

                        for (int i = 0; i < numberOfColumns; i++) {
                            menuDetails.setValueAt(dataForTable[i], rowCount, i);
                        }

                        //add entered record to the arraylist
                        LaptopInfo obj = new LaptopInfo(idOfLaptop, brand, modelName, processor, colorOfLaptop, price);
                        priceSearchList.add(obj);

                        //used to add new row to JTable when insert button is pressed once
                        String[][] emptyRow = {null, null, null, null, null, null};
                        dtm.addRow(emptyRow);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid price!!!!", "Error Message", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid laptop ID!!!!", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please donot leave any field blank.", "Error Message", JOptionPane.WARNING_MESSAGE);

            }

        // for event handling if Clear button is pressed    
        } else if (ae.getSource() == clearButton) {
            laptopIdText.setText("");
            brandCombo.setSelectedIndex(0);
            modelText.setText("");
            colorText.setText("");
            priceText.setText("");
        } 
        // for event handling if Clear Table button is pressed  
        else if (ae.getSource() == clearTableButton) {
            int numberOfRows = menuDetails.getRowCount();
            int numberOfColumns = menuDetails.getColumnCount();
            int rowCount = 0;
            do {
                String rowData = (String) menuDetails.getValueAt(rowCount, 0);
                if (rowData != null && rowData.length() != 0) {
                    for (int i = 0; i < numberOfColumns; i++) {
                        menuDetails.setValueAt(null, rowCount, i);
                    }
                } else {
                    rowCount++;
                }
            } while (rowCount < numberOfRows);
            priceSearchList.clear();
        } 
        
        // for event handling if View Laptops Available button is pressed  
        else if (ae.getSource() == searchLaptopsButton) {
            String searchedBrand = (String) laptopsAvailableCombo.getSelectedItem();
            ArrayList list = new ArrayList();
            int numberOfRows = menuDetails.getRowCount();
            int count = 0;

            int rowCount = 0;
            do {
                String rowData = (String) menuDetails.getValueAt(rowCount, 0);
                if (rowData != null && rowData.length() != 0) {
                    String brandOfLaptop = (String) menuDetails.getValueAt(rowCount, 1);
                    if (brandOfLaptop.equalsIgnoreCase(searchedBrand)) {
                        String modelOfLaptop = (String) menuDetails.getValueAt(rowCount, 2);
                        list.add(modelOfLaptop);
                        count++;
                        rowCount++;
                    } else {
                        rowCount++;
                    }
                } else {
                    rowCount++;
                }
            } while (rowCount < numberOfRows);

            if (list.size() == 0) {
                JOptionPane.showMessageDialog(frame, "Sorry ! We do not have the laptop of this brand.", "No Laptops Found", JOptionPane.ERROR_MESSAGE);
            } else {
                StringBuilder sb = new StringBuilder("There are ");
                sb.append(Integer.toString(count)).append(" laptops of ").append(searchedBrand).append(" :").append("\n");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i)).append("\n");
                }
                JOptionPane.showMessageDialog(frame, sb.toString(), "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        // for event handling if Search button is pressed  
        else if (ae.getSource() == searchButton) {
            String priceSearched = searchText.getText();
            if (priceSearched.length() != 0 && priceSearched != null) {

                try {
                    double searchedPrice = Double.parseDouble(priceSearched);
                    selectionSort();

                    int searchFoundPosition = binarySearch(searchedPrice);
                    if (searchFoundPosition == -1) {
                        JOptionPane.showMessageDialog(frame, "Sorry!!!! We donot have any laptop of this price.", "Laptop Not Found!!!!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String laptopId = Integer.toString(priceSearchList.get(searchFoundPosition).getLaptopId());
                        String brandOfLaptop = priceSearchList.get(searchFoundPosition).getBrand();
                        String modelOfLaptop = priceSearchList.get(searchFoundPosition).getModel();
                        String processor = priceSearchList.get(searchFoundPosition).getProcessor();
                        String color = priceSearchList.get(searchFoundPosition).getColor();
                        String price = Double.toString(priceSearchList.get(searchFoundPosition).getPrice());
                        String messageToBeDisplayed = "Laptop Available!!!!" + "\n" + "The laptop has following details" + "\n"
                                + "Laptop Id : " + laptopId + "\n" + "Brand : " + brandOfLaptop + "\n" + "Model Name : "
                                + modelOfLaptop + "\n" + "Processor : " + processor + "\n" + "Color : " + color + "\n"
                                + "Price : " + price;
                        JOptionPane.showMessageDialog(frame, messageToBeDisplayed, "Search Successful!!!!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Please, enter the valid price to search.", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter the value for price to search.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        
        // for event handling if Open menu-item is pressed  
        else if (ae.getSource() == open) {
            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "C:\\Users\\Prabin\\Desktop\\Java Coursework\\Proposal.docx");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error");
            }
        } 
        
        // for event handling if Exit menu-item is pressed  
        else if (ae.getSource() == exit) {
            System.exit(0);
        }
        
        // for event handling if User Guide menu-item is pressed  
        else if (ae.getSource() == userGuide) {
            try {
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "C:\\Users\\Prabin\\Desktop\\Java Coursework\\UserGuide.pdf");
            } catch (Exception ex) {
                ex.printStackTrace();

                JOptionPane.showMessageDialog(frame, "Error");
            }
        } 
        
        // for event handling if About menu item is pressed  
        else if (ae.getSource() == about) {
            String companyDetails = "Version : 5.0.1" + "\n" + "Status : Up-To-Date" + "\n" + "Date Created : November,2017" + "\n" + "Creators : Prajan Acharya, Khimon Thapa, Mohit Paudel, Sanchaya Chapagain";
            JOptionPane.showMessageDialog(frame, companyDetails, "System Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
    * This method sorts the elements of the ArrayList using Selection Sort Algorithm. 
    */
    public void selectionSort() {
        for (int i = 0; i < priceSearchList.size() - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < priceSearchList.size(); j++) {
                if (priceSearchList.get(j).getPrice() < priceSearchList.get(minPos).getPrice()) {
                    minPos = j;
                }
            }
            LaptopInfo temp = priceSearchList.get(minPos);
            priceSearchList.set(minPos, priceSearchList.get(i));
            priceSearchList.set(i, temp);
        }
    }

    /**
    * This method searches a particular price from ArrayList and returns the position of the searched price in the ArrayList.. 
    */
    public int binarySearch(double searchedPrice) {
        int high = priceSearchList.size() - 1;
        int low = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (priceSearchList.get(mid).getPrice() == searchedPrice) {
                return mid;
            } else if (priceSearchList.get(mid).getPrice() > searchedPrice) {
                high = mid - 1;
            } else if (priceSearchList.get(mid).getPrice() < searchedPrice) {
                low = mid + 1;
            }
        }
        return -1;
    }

}
