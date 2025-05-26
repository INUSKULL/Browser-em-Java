import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.net.URL;

public class Browser extends JFrame {

    private Browser carlos;
    private int bolt = -1;
    private JPanel Url;
    private JTextField battleField;
    private JButton seek;
    private JButton destroy;
    private JButton clea;
    private JButton proceder;
    private JButton retornar;
    private JButton guia;
    private JLabel babel;
    private JList listCj;
    private JEditorPane bigSmoke;
    private JScrollBar scrull;
    private DefaultListModel listCarlos;


    public Browser() {
        setTitle("Histórico de Navegação");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,1060);
        setContentPane(Url);
        setVisible(true);
        setLocationRelativeTo(null);
        carlos = this;
        listCarlos = new DefaultListModel();
        listCj.setModel(listCarlos);


        seek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String list = battleField.getText();
                babel.setText("Url:"+ list);
                listCarlos.add(0, list);
                String url = battleField.getText();
                babel.setText("Url: " + url);
                listCarlos.add(0, url);
                loadPage(url);
            }
        });


        clea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleaList();

            }
        });


        destroy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destroyCharge();
            }
        });

        retornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retJohn();

            }
        });

        proceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proJohn();

            }
        });

        guia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                babel.setText("");

            }
        });

        bigSmoke.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    String url = e.getURL().toString();
                    listCarlos.add(0, url);
                    loadPage(url);
                }
            }
        });
        scrull.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                rudelaMouse(e);

            }
        });
    }
    private void destroyCharge(){
        int cJ = listCj.getSelectedIndex();
        if (cJ != -1){
        listCarlos.remove(cJ);
        if (bolt > 0){
            bolt--;
            listCj.setSelectedIndex(bolt);
           }
        }
    }
     private void retJohn() {
         if (bolt > 0) {
             bolt--;
             listCj.setSelectedIndex(bolt);
         }
     }
    private void proJohn() {
        if (bolt < listCarlos.getSize() -1) {
            bolt++;
            listCj.setSelectedIndex(bolt);
        }
    }
    private void cleaList(){
        listCarlos.clear();
    }
    private void loadPage(String url) {
        try {
            bigSmoke.setPage(new URL(url));
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir a página.");
        }
    }
    private void rudelaMouse(MouseWheelEvent e){
        int rudela = e.getWheelRotation();
        JScrollBar verticalScrollBar = scrull;
        int newValue = verticalScrollBar.getValue() - rudela * verticalScrollBar.getUnitIncrement();
        verticalScrollBar.setValue(newValue);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Browser::new);
    }


}
