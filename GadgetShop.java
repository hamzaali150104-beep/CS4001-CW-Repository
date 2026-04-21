import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GadgetShop extends JFrame implements ActionListener
{
    private ArrayList<Gadget> gadgets;

    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField creditField;
    private JTextField memoryField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField downloadSizeField;
    private JTextField displayNumberField;

    private JTextArea displayArea;

    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton clearButton;
    private JButton displayAllButton;
    private JButton makeCallButton;
    private JButton downloadMusicButton;

    public GadgetShop()
    {
        super("Gadget Shop");
        gadgets = new ArrayList<Gadget>();

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(10, 2, 5, 5));

        inputPanel.add(new JLabel("Model:"));
        modelField = new JTextField();
        inputPanel.add(modelField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Weight:"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Size:"));
        sizeField = new JTextField();
        inputPanel.add(sizeField);

        inputPanel.add(new JLabel("Initial Credit:"));
        creditField = new JTextField();
        inputPanel.add(creditField);

        inputPanel.add(new JLabel("Initial Memory:"));
        memoryField = new JTextField();
        inputPanel.add(memoryField);

        inputPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField);

        inputPanel.add(new JLabel("Duration:"));
        durationField = new JTextField();
        inputPanel.add(durationField);

        inputPanel.add(new JLabel("Download Size:"));
        downloadSizeField = new JTextField();
        inputPanel.add(downloadSizeField);

        inputPanel.add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        inputPanel.add(displayNumberField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));

        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        makeCallButton = new JButton("Make A Call");
        downloadMusicButton = new JButton("Download Music");

        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);

        buttonPanel.add(addMobileButton);
        buttonPanel.add(addMP3Button);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(makeCallButton);
        buttonPanel.add(downloadMusicButton);

        add(buttonPanel, BorderLayout.CENTER);

        displayArea = new JTextArea(14, 40);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        setSize(650, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String getModelInput()
    {
        return modelField.getText();
    }

    public double getPriceInput()
    {
        return Double.parseDouble(priceField.getText());
    }

    public int getWeightInput()
    {
        return Integer.parseInt(weightField.getText());
    }

    public String getSizeInput()
    {
        return sizeField.getText();
    }

    public int getCreditInput()
    {
        return Integer.parseInt(creditField.getText());
    }

    public int getMemoryInput()
    {
        return Integer.parseInt(memoryField.getText());
    }

    public String getPhoneNumberInput()
    {
        return phoneNumberField.getText();
    }

    public int getDurationInput()
    {
        return Integer.parseInt(durationField.getText());
    }

    public int getDownloadSizeInput()
    {
        return Integer.parseInt(downloadSizeField.getText());
    }

    public int getDisplayNumber()
    {
        int displayNumber = -1;

        try
        {
            displayNumber = Integer.parseInt(displayNumberField.getText());

            if (displayNumber < 0 || displayNumber >= gadgets.size())
            {
                JOptionPane.showMessageDialog(this,
                    "Please enter a display number that matches a gadget in the list.",
                    "Invalid Display Number",
                    JOptionPane.ERROR_MESSAGE);
                displayNumber = -1;
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,
                "Display number must be an integer.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        }

        return displayNumber;
    }

    public void addMobile()
    {
        try
        {
            String model = getModelInput();
            double price = getPriceInput();
            int weight = getWeightInput();
            String size = getSizeInput();
            int credit = getCreditInput();

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);
            displayArea.append("Mobile added successfully at index " + (gadgets.size() - 1) + "\n\n");
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,
                "Please enter valid numerical values for price, weight and credit.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addMP3()
    {
        try
        {
            String model = getModelInput();
            double price = getPriceInput();
            int weight = getWeightInput();
            String size = getSizeInput();
            int memory = getMemoryInput();

            MP3 mp3Player = new MP3(model, price, weight, size, memory);
            gadgets.add(mp3Player);
            displayArea.append("MP3 player added successfully at index " + (gadgets.size() - 1) + "\n\n");
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,
                "Please enter valid numerical values for price, weight and memory.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearFields()
    {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    }

    public void displayAll()
    {
        displayArea.setText("");

        if (gadgets.size() == 0)
        {
            displayArea.append("No gadgets are currently stored.\n");
        }
        else
        {
            for (int i = 0; i < gadgets.size(); i++)
            {
                Gadget currentGadget = gadgets.get(i);
                displayArea.append("Display Number: " + i + "\n");
                displayArea.append("Model: " + currentGadget.getModel() + "\n");
                displayArea.append("Price: £" + currentGadget.getPrice() + "\n");
                displayArea.append("Weight: " + currentGadget.getWeight() + "g\n");
                displayArea.append("Size: " + currentGadget.getSize() + "\n");

                if (currentGadget instanceof Mobile)
                {
                    Mobile mobile = (Mobile) currentGadget;
                    displayArea.append("Credit Remaining: " + mobile.getCredit() + " minute(s)\n");
                }
                else if (currentGadget instanceof MP3)
                {
                    MP3 mp3Player = (MP3) currentGadget;
                    displayArea.append("Available Memory: " + mp3Player.getMemory() + "\n");
                }

                displayArea.append("------------------------------\n");
            }
        }
    }

    public void makeCall()
    {
        int displayNumber = getDisplayNumber();

        if (displayNumber != -1)
        {
            try
            {
                Gadget selectedGadget = gadgets.get(displayNumber);

                if (selectedGadget instanceof Mobile)
                {
                    Mobile mobile = (Mobile) selectedGadget;
                    String phoneNumber = getPhoneNumberInput();
                    int duration = getDurationInput();

                    mobile.makeCall(phoneNumber, duration);
                    displayArea.append("Attempted call from gadget " + displayNumber + "\n\n");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,
                        "The selected gadget is not a Mobile object.",
                        "Type Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,
                    "Please enter a valid integer for call duration.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void downloadMusic()
    {
        int displayNumber = getDisplayNumber();

        if (displayNumber != -1)
        {
            try
            {
                Gadget selectedGadget = gadgets.get(displayNumber);

                if (selectedGadget instanceof MP3)
                {
                    MP3 mp3Player = (MP3) selectedGadget;
                    int downloadSize = getDownloadSizeInput();

                    mp3Player.downloadMusic(downloadSize);
                    displayArea.append("Attempted music download on gadget " + displayNumber + "\n\n");
                }
                else
                {
                    JOptionPane.showMessageDialog(this,
                        "The selected gadget is not an MP3 object.",
                        "Type Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this,
                    "Please enter a valid integer for download size.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addMobileButton)
        {
            addMobile();
        }
        else if (e.getSource() == addMP3Button)
        {
            addMP3();
        }
        else if (e.getSource() == clearButton)
        {
            clearFields();
        }
        else if (e.getSource() == displayAllButton)
        {
            displayAll();
        }
        else if (e.getSource() == makeCallButton)
        {
            makeCall();
        }
        else if (e.getSource() == downloadMusicButton)
        {
            downloadMusic();
        }
    }

    public static void main(String[] args)
    {
        new GadgetShop();
    }
}
