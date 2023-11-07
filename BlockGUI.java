import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BlockGUI {
    private Blockchain blockchain;
    private JFrame frame;
    private JTextArea textArea;
    private JTextField dataField;

    public BlockGUI() {
        blockchain = new Blockchain();

        frame = new JFrame("Java Blockchain");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        dataField = new JTextField(20);
        JButton addButton = new JButton("Add Block");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = dataField.getText();
                blockchain.addBlock(data);
                dataField.setText("");
                updateTextArea();
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(textArea));
        frame.add(dataField);
        frame.add(addButton);

        frame.setVisible(true);
        updateTextArea();
    }

    private void updateTextArea() {
        textArea.setText("");
        for (Block block : blockchain.getChain()) {
            textArea.append("Block Data: " + block.getData() + "\n");
            textArea.append("Block Hash: " + block.getHash() + "\n");
            textArea.append("----------------------------\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BlockGUI();
            }
        });
    }
}