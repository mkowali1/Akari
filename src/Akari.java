import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Akari extends JFrame
{
    public Akari()
    {
        this.setTitle("Akari");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((int) (screenSize.getWidth()/2 - 350), (int) (screenSize.getHeight()/2 - 350), 700, 700);
        panelButtonow.setBackground(Color.GREEN);
        JButton bStart = (JButton) panelButtonow.add(new JButton("Start"));
        bStart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                startGame();
            }
        });
        JButton bInstrukcja = (JButton) panelButtonow.add(new JButton("instrukcja"));
        bInstrukcja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (k == 1) {
                    hideInstruction();
                    k--;
                    return;
                }
                if (k == 0) {
                    showInstruction();
                    k ++;
                }

            }
        });
        JButton bWyjdz = (JButton) panelButtonow.add(new JButton("Wyjdź"));
        bWyjdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                exitGame();
            }
        });
        this.getContentPane().add(panelObslugi);
        this.getContentPane().add(panelButtonow, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(oknoInstrukcji1, BorderLayout.WEST);
    }
    public void hideInstruction()
    {
        panelObslugi.schowajInstrukcje();
    }
    public void showInstruction()
    {
        panelObslugi.pokaInstrukcje();
    }
    public void startGame()
    {
        panelObslugi.startujGre();
    }
    public void exitGame()
    {
        panelObslugi.wyjdzZGry();
    }
    int k = 0;
    public JPanel panelButtonow = new JPanel();
    public PanelObslugi panelObslugi = new PanelObslugi();
    JLabel oknoInstrukcji1 = new JLabel();
    class PanelObslugi extends JPanel
    {
        public void pokaInstrukcje()
        {
            oknoInstrukcji1.setText("<html>Twoim zadaniem jest podświetlenie wszystkich białych pól spełniając zarówno następujące zasady: " +
                    " <br> 1. Żarówki nie mogą świecić na siebie nawzajem" +
                    " <br> 2. Wokół czarnych pół musi sąsiadować wskazana przez czarne pola ilość żarówek" +
                    " <br> Po umieszczeniu żarówek kliknij przycisk 'Sprawdź wynik'</html>");
            oknoInstrukcji1.setFont(new Font("Serif", Font.BOLD, 16));
        }
        public void schowajInstrukcje()
        {
            oknoInstrukcji1.setText("");
        }
        public void startujGre()
        {
            new Akari().setDefaultCloseOperation(EXIT_ON_CLOSE);
            new OknoGry().setVisible(true);
        }
        public void wyjdzZGry()
        {
            System.exit(0);
        }
    }
}
class Uruchom
{
    public static void main(String[] args)
    {
        new Akari().setVisible(true);
    }
}
