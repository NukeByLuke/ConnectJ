import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectJ extends JFrame {
    private JTextArea messageArea;
    private JTextField inputField;
    private JButton sendButton;

    public ConnectJ() {
        // Set up the main frame
        setTitle("Texting App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the message area
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        add(new JScrollPane(messageArea), BorderLayout.CENTER);

        // Create the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        // Create the input field
        inputField = new JTextField();
        inputPanel.add(inputField, BorderLayout.CENTER);

        // Create the send button
        sendButton = new JButton("Send");
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add the input panel to the frame
        add(inputPanel, BorderLayout.SOUTH);

        // Add action listener to the send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Add action listener to the input field to send message on Enter key press
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            messageArea.append("You: " + message + "\n");
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConnectJ().setVisible(true);
            }
        });
    }
}