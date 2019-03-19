package app;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 */
public class SwingDemo extends JFrame {
    private static  String[] data = {"John Mayer", "Frank Sinatra", "Seth MacFarlane", "Nina Simone", "BB King", "Peggy Lee"};
    //private static  String[] data;
    private JPanel mainPanel;
    private JList<String> list;
    private JTextArea textArea;
    private JButton exitButton;

    public SwingDemo(String title) {
        super(title);
        mainPanel = (JPanel) this.getContentPane();
        textArea = new JTextArea(50, 10);

        //NORTH
        list = new JList<>(data);
        list.addListSelectionListener(new LFListener(this));
        mainPanel.add(list, BorderLayout.NORTH);

        //CENTER
        JScrollPane txtPanel = new JScrollPane(textArea);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setEditable(false);
        mainPanel.add(txtPanel, BorderLayout.CENTER);

        //SOUTH
        exitButton = new JButton("Bye Bye!");
        exitButton.addActionListener(e -> System.exit(0));

        JPanel exitPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        exitPanel.setLayout(flowLayout);
        exitPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        exitPanel.add(exitButton);

        mainPanel.add(exitPanel, BorderLayout.SOUTH);
    }

    public static void main(String... args) throws Exception {

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

        /*data = new String[looks.length];
        int i =0;
        for (UIManager.LookAndFeelInfo look : looks) {
            data[i++] = look.getClassName().toString()+"<<<Jacek>>>";
        }
        //data[i] = "com.seaglasslookandfeel.SeaGlassLookAndFeel";
        */


        SwingDemo swingDemo = new SwingDemo("Swing Demo Window");
        swingDemo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        swingDemo.setSize(new Dimension(500, 500));

        swingDemo.setVisible(true);
    }

    private class LFListener implements ListSelectionListener {
        private JFrame parent;

        public LFListener(JFrame swingDemo) {
            parent = swingDemo;
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                textArea.append("kliknołeś -"+list.getSelectedValue() + "\n");
                try {
                    //UIManager.setLookAndFeel(list.getSelectedValue());
                    Thread.sleep(1000);
                    parent.repaint();
                } catch (Exception ee) {
                    System.err.println(" Could nto set look and feel! ");
                }
            }
        }
    }
}