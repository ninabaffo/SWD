import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

/**
 * MyClient connects to chatServer and extends JFrame to create a GUI to display
 * messages between client and server.
 */
public class MyClient extends JFrame{
    private JTextField enterField; // entering information from user
    private JTextArea displayArea; // displays information to user
    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private String message = ""; // message from serve
    private final String chatServer; // host server
    private Socket socket; // socket to communicate with server

    /**
     * MyClient constructor initializes the chatServer and sets up the GUI
     * @param host of chatServer
     */
    // initialize chatServer and set up GUI
    public MyClient(String host) {
        super("Client");
        chatServer = host; // set server to which this client connects
        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);// setEditable = true so the user can edit the file in a JTextArea
        enterField.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sendData(e.getActionCommand());
                        enterField.setText("");
                    }
                }
        );
        add(enterField, BorderLayout.SOUTH);

        displayArea = new JTextArea(); // create display area
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(400, 300); // set window size
        setVisible(true); // show window

        startClient();
    }

    /**
     * startClient creates a socket to connect to the server
     * or throws an exception if the client terminates the connection.
     */
    public void startClient() {
        // connect to server and get streams
        try {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (EOFException eofException) {
            displayMessage("\nClient terminated connection");
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection(); // close connection
        }
    }

    /**
     * connectToServer initializes the socketServer socket
     * to connect to the server and displays a message when it has been connected.
     * @throws IOException if I/O streams cant connect properly
     */
    private void connectToServer() throws IOException {
        displayMessage("\nAttempting Connection \n");
        socket = new Socket(InetAddress.getByName(chatServer), 23590);

        displayMessage("\n Connected to: " + socket.getInetAddress().getHostName());
    }

    /**
     * getStreams attempts to get the input and output streams for objects
     * through the socket to send and receive data.
     * @throws IOException if unable to connect to input/output streams
     */
    private void getStreams() throws IOException {
        output = new ObjectOutputStream(socket.getOutputStream());
        output.flush(); // flush output buffer to send header info

        input = new ObjectInputStream(socket.getInputStream());

        displayMessage("\nGot I/O streams! \n");
    }

    /**
     * processConnection reads messages sent from the server
     * and displays it in the GUI.
     * @throws InterruptedException if an unknown object is displayed
     */
    private void processConnection() throws InterruptedException{
        setTextFieldEditable(true); // enable enter field so client user can send messages
        do {
            try {
                message = (String) input.readObject();
                displayMessage("\n" + message); }
            catch (ClassNotFoundException | IOException classNotFoundException){
                displayMessage("\n Unknown object type received! ");
            }
        }
        while (!message.equals("Server >>> Terminate"));
    }

    /**
     * closeConnection closes the input and output streams
     * and the socket connection.
     */
    private void closeConnection() {
        displayMessage("\n Closing connection");
        setTextFieldEditable(false);
        try {
            output.close();
            input.close();
            socket.close();
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    /**
     * Private method sendData takes the inputted String message and sends
     * it to the server to be displayed in the GUI.
     * @param message to send
     */
    private void sendData(String message){
        try
        {
            output.writeObject(message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT: " + message);
        }
        catch (IOException ioException){
            displayArea.append("\n Error writing object ");
        }
    }

    /**
     * displayMessage manipulates the displayArea in the event dispatch thread.
     * @param messageToDisplay is the messageDisplayed in the GUI.
     */
    private void displayMessage(final String messageToDisplay){
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { // updates displayArea
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }

    /**
     * setTextFieldEditable sets the displayArea to be editable when needed
     * @param editable boolean to tell the text field to be editable
     */
    private void setTextFieldEditable(final boolean editable){
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { // sets enterFields editiability
                        enterField.setEditable(editable);
                    }
                }
        );
    }
}

