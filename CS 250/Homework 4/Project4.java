package project.pkg4;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;
/**
 *
 * @author Gianni Esposito
 */
public class Project4 extends JFrame implements ActionListener {

    public Project4() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(540, 150);
        setLocation(200, 100);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridy = 1;

        JTextField words = new JTextField("Please make sure your input file is in the same directory as this program and named input.txt");
        add(words, c);
        c.gridy++;

        JButton button1 = new JButton("Tokenizer");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    tokenization();
                } catch (IOException ex) {
                    Logger.getLogger(Project4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        add(button1, c);
        c.gridy++;
        JButton button2 = new JButton("Serialization");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                serialization();
            }
        });
        add(button2, c);
        c.gridy++;

        setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        new Project4();

    }

    public static void serialization() {
        ObjectData dataValueObject = new ObjectData();
        dataValueObject.setFirst("Gianni");
        dataValueObject.setLast("Esposito");
        try {
            SerializationDemo.serialization("output.ser", dataValueObject);
            ObjectData object = (ObjectData) SerializationDemo.deSerialization("output.ser");
            System.out.println(object.toString());
            System.out.println("Objects have been deserialized. Please check output.ser for your deserialized objects.");
        } catch (IOException exp) {
            exp.printStackTrace();
        } catch (ClassNotFoundException exp) {
            exp.printStackTrace();
        }
    }

    public static void tokenization() throws FileNotFoundException, IOException {
        String msg;
        //String delims = ",";
        String data = "input.txt";
        String outfilename = "output.txt";
        File file = new File(outfilename);
        file.createNewFile();

        FileInputStream fisData = new FileInputStream(data);
        BufferedReader readBufferData = new BufferedReader(new InputStreamReader(fisData));

        FileWriter tokenData = new FileWriter(outfilename, true);
        BufferedWriter tokenDataB = new BufferedWriter(tokenData);
        try {
            while ((msg = readBufferData.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(msg);
                StringBuilder sb = new StringBuilder();
                System.out.println("Input file contents: " + msg);

                while (tokens.hasMoreTokens()) {
                    msg = tokens.nextToken();
                    String msgLower = msg.toLowerCase();
                    // write one token per line to output file
                    tokenDataB.newLine();
                    tokenDataB.write(msgLower);
                    tokenDataB.write("\n");
                }
            }

            //close the output writer at the end
            tokenDataB.close();

            System.out.println("Output was successful! Please check output.txt for your new tokens!");
        } catch (Exception e) {
            System.out.println("Error Exception: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
