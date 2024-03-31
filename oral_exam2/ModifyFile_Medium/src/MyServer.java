import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyServer extends JFrame{
    private JTextField enterField;
    private JTextArea displayArea; // displays info to user
    private ObjectInputStream input; // input stream from user
    private ObjectOutputStream output; // output stream from user
    private Socket connection; // socket to connect to client
    private ServerSocket server;
    private int counter = 1;
    private String contentsOfFile = "";

    /**
     * MyServer constructor sets up the GUI.
     */
    public MyServer() {
        super("Server");

        displayArea = new JTextArea(); // create display area
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setVisible(true);
        setSize(400, 300); // set window size

    }

    /**
     * startServer sets up the server connection with the client by creating a serverSocket and
     * waiting for a connection.
     */
    public void startServer() {
        try {
            server = new ServerSocket(23590, 100); // create server socket
            while(true){
                try {
                    waitForConnection();
                    getStreams(); // get the input and output streams
                    processConnection(); // process connection
                } catch (EOFException | InterruptedException eofException) {
                    displayMessage("\nServer terminated connection");
                } finally {
                    closeConnection(); // close connection
                    counter++;
                }
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    /**
     * waitForConnection waits for a connection to arrive then displays the connection info
     * @throws IOException if I/O streams cant connect properly
     */
    private void waitForConnection() throws IOException {
        displayMessage("SERVER: Wating for connection...\n");
        connection = server.accept();
        displayMessage("\nSERVER: Connection received from: "+ connection.getInetAddress().getHostName()+"\n");
    }

    /**
     * getStreams sets up the I/O streams to send and receive data with the client.
     * and displays a message when done.
     * @throws IOException if I/O streams cant connect properly
     */
    private void getStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output to send info

        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nSERVER: Got I/O streams!\n");
    }

    /**
     * processConnection processes connection with the client and send a message indicating so.
     * it also takes the input from the client to read in the filename, puts it into a buffered reader
     * to read the contents of the file, then sends the contents to the client to be edited
     * @throws InterruptedException if the fileName specified was not found
     */
    // process connection with client
    private void processConnection() throws InterruptedException {
        String message = "SERVER: Connection Successful!\nSERVER: Please enter filename below. (FileRetrieve.txt)\n";
        sendData(message);
        do {
            try
            {
                String inputStr = (String) input.readObject(); // read new message
                File fileToBeModified = new File("oral_exam2" + File.separator + "ModifyFile_Medium" + File.separator + "src" + File.separator + inputStr);

                BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
                String fileContents = reader.readLine();
                String originalFileContents = "";

                // put the contents of the file in originalFileContents
                while (fileContents != null) {
                    originalFileContents = originalFileContents + fileContents + "\n";
                    fileContents = reader.readLine();
                }

                sendData(originalFileContents);
                modifyFile(originalFileContents, fileToBeModified);

            } catch (ClassNotFoundException | IOException classNotFoundException) {
                displayMessage("\nFile not found");
            }
        }
        while (!message.equals("Server >>> Terminate"));
    }

    /**
     * closeConnection closes the I/O streams and socket connection with the client
     */
    // close streams and socket
    private void closeConnection() {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false);
        try {
            output.close();
            input.close();
            connection.close();
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    /**
     * sendData takes in a String and sends it to the client to be outputted
     * @param message is the message sent.
     */
    private void sendData(String message){
        try // send object to client
        {
            output.writeObject(message);
            output.flush(); // flush output to client
            displayMessage("SERVER: "+message);
        }
        catch (IOException ioException){
            displayArea.append("\nError writing object ");
        }
    }

    /**
     * modifyFile takes in the contents of the file to be modified and gets the modifications
     * from the user. It uses a fileWriter to write the contents back to the file to be stored.
     * @param fileContents contents to be modified
     * @param file file to send modifications to
     * @throws IOException  if the I/O file is not found
     * @throws ClassNotFoundException if class not found
     */
    private void modifyFile(String fileContents, File file) throws IOException, ClassNotFoundException {
        String message = "Enter modifications to file contents below: \n";
        sendData(message);
        String newFile = "";

        String modifications = (String) input.readObject();
        Scanner newIn = new Scanner(modifications);

        while(newIn.hasNextLine()){
            newFile += newIn.nextLine() + "\n";
        }

        contentsOfFile = fileContents.replaceAll(fileContents, newFile);

        FileWriter writer = new FileWriter(file);
        writer.write(contentsOfFile);
        sendData(contentsOfFile);

        writer.close();
    }

    /**
     * displayMessage manipulates the displayArea in the event dispatch thread.
     * @param messageToDisplay is the messageDisplayed in the GUI.
     */
    private void displayMessage(final String messageToDisplay){
            SwingUtilities.invokeLater(
                    new Runnable() {
                        public void run() // updates displayArea
                        {
                            displayArea.append(messageToDisplay); // display message
                        }
                    }
            );
        }

    /**
     * setTextFieldEditable sets the displayArea to be editable when needed
     * @param editable boolean to tell the text field to be editable
     */
    private void setTextFieldEditable ( final boolean editable){
          SwingUtilities.invokeLater(
              new Runnable() {
                   public void run() { // sets enterFields editiability
                        enterField.setEditable(editable);
                   }
              }
            );
        }
}
