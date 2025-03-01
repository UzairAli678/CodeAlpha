package ChatBot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AIChatbotGUI {
    private static HashMap<String, String> responses = new HashMap<>();
    private static JTextArea chatArea;
    private static JTextField userInputField;

    public static void main(String[] args) {
       
        responses.put("hello", "Hello! How can I assist you today?");
        responses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("what is your name", "I'm an AI chatbot created to help you.");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("help", "I can respond to greetings, general questions, and assist with basic inquiries.");

 
        JFrame frame = new JFrame("AI Chatbot");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

    
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        userInputField = new JTextField();
        userInputField.setEnabled(true);
        userInputField.requestFocusInWindow();

      
        ActionListener sendAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processUserInput();
            }
        };

        userInputField.addActionListener(sendAction); 

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(sendAction); 

      
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(userInputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

     
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static void processUserInput() {
        String userInput = userInputField.getText().trim().toLowerCase();
        if (userInput.isEmpty()) {
            return;
        }
        userInputField.setText("");
        chatArea.append("You: " + userInput + "\n");

        if (userInput.equals("exit")) {
            chatArea.append("Chatbot: Goodbye! See you next time.\n");
            return;
        }

        boolean foundResponse = false;
        for (String key : responses.keySet()) {
            if (userInput.contains(key)) {
                chatArea.append("Chatbot: " + responses.get(key) + "\n");
                foundResponse = true;
                break;
            }
        }

        if (!foundResponse) {
            chatArea.append("Chatbot: I'm not sure how to respond to that. Can you ask something else?\n");
        }

        userInputField.requestFocusInWindow(); 
    }
}
