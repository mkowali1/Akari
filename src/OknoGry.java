import org.w3c.dom.events.EventException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class OknoGry extends JFrame {
    public OknoGry() {
        this.setTitle("OknoGry");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((int) (screenSize.getWidth()/2 - 350), (int) (screenSize.getHeight()/2 - 350), 700, 700);
        // Tworzenie przycisków szachownicy
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                szachownica[i][j] = new JButton();
            }
        }
        // Dodawanie przycisków do panelu szachownicy
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                panelSzachownicy.add(szachownica[i][j]);
            }
        }
        panelSzachownicy.add(sprawdz);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                szachownica[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startThread();
                    }
                });
            }
        }
        sprawdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sprawdzWynik();
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panelSzachownicy, BorderLayout.CENTER);
        panelSzachownicy.setBounds(0, 0, 100, 100);
        panelSzachownicy.setLayout(null);
        panelSzachownicy.setBackground(Color.BLUE);
        //ustawianie lokalizacji przycisków
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                szachownica[i][j].setLocation(175 + j * 50, 175 + i * 50);
                szachownica[i][j].setSize(50, 50);
                szachownica[i][j].setBackground(Color.white);
            }
        }
        sprawdz.setLocation(500, 600);
        sprawdz.setSize(150, 50);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //plansze szachownicy
        //plansza numer jeden
        numerPlanszy = generator.nextInt(11);
        if (numerPlanszy == 0) {
            szachownica[0][4].setBackground(czarny);
            szachownica[0][4].setText(String.valueOf(1));
            szachownica[1][3].setBackground(czarny);
            szachownica[1][3].setText(String.valueOf(0));
            szachownica[2][0].setBackground(czarny);
            szachownica[2][0].setText(String.valueOf(3));
            szachownica[3][1].setBackground(czarny);
            szachownica[3][1].setText(String.valueOf(3));
            szachownica[3][3].setBackground(czarny);
            szachownica[3][5].setBackground(czarny);
            szachownica[3][5].setText(String.valueOf(1));
            szachownica[4][6].setBackground(czarny);
            szachownica[4][6].setText(String.valueOf(0));
            szachownica[5][3].setBackground(czarny);
            szachownica[6][2].setBackground(czarny);
            szachownica[6][2].setText(String.valueOf(1));
        }
        //plansza numer dwa
        if (numerPlanszy == 1) {
            szachownica[0][0].setBackground(czarny);
            szachownica[0][0].setText(String.valueOf(0));
            szachownica[0][2].setBackground(czarny);
            szachownica[0][6].setBackground(czarny);
            szachownica[0][6].setText(String.valueOf(0));
            szachownica[1][3].setBackground(czarny);
            szachownica[2][6].setBackground(czarny);
            szachownica[3][1].setBackground(czarny);
            szachownica[3][3].setBackground(czarny);
            szachownica[3][5].setBackground(czarny);
            szachownica[3][5].setText(String.valueOf(2));
            szachownica[4][0].setBackground(czarny);
            szachownica[4][0].setText(String.valueOf(1));
            szachownica[5][3].setBackground(czarny);
            szachownica[6][0].setBackground(czarny);
            szachownica[6][0].setText(String.valueOf(2));
            szachownica[6][4].setBackground(czarny);
            szachownica[6][4].setText(String.valueOf(0));
            szachownica[6][6].setBackground(czarny);
            szachownica[6][6].setText(String.valueOf(1));
        }
        //plansza numer trzy
        if (numerPlanszy == 2) {
            szachownica[1][3].setBackground(czarny);
            szachownica[2][2].setBackground(czarny);
            szachownica[2][2].setText(String.valueOf(2));
            szachownica[2][4].setBackground(czarny);
            szachownica[2][4].setText(String.valueOf(4));
            szachownica[3][1].setBackground(czarny);
            szachownica[3][1].setText(String.valueOf(1));
            szachownica[3][5].setBackground(czarny);
            szachownica[3][5].setText(String.valueOf(4));
            szachownica[4][2].setBackground(czarny);
            szachownica[4][2].setText(String.valueOf(2));
            szachownica[4][4].setBackground(czarny);
            szachownica[4][4].setText(String.valueOf(3));
            szachownica[5][3].setBackground(czarny);
            szachownica[5][3].setText(String.valueOf(2));
        }
        //plansza numer cztery
        if (numerPlanszy == 3) {
            szachownica[0][5].setBackground(czarny);
            szachownica[0][5].setText(String.valueOf(2));
            szachownica[1][0].setBackground(czarny);
            szachownica[1][0].setText(String.valueOf(0));
            szachownica[2][2].setBackground(czarny);
            szachownica[2][2].setText(String.valueOf(0));
            szachownica[2][4].setBackground(czarny);
            szachownica[2][4].setText(String.valueOf(0));
            szachownica[4][2].setBackground(czarny);
            szachownica[4][2].setText(String.valueOf(0));
            szachownica[4][4].setBackground(czarny);
            szachownica[4][4].setText(String.valueOf(2));
            szachownica[5][6].setBackground(czarny);
            szachownica[6][1].setBackground(czarny);
            szachownica[6][1].setText(String.valueOf(2));
        }
        //plansza numer pięć
        if (numerPlanszy == 4) {
            szachownica[0][0].setBackground(czarny);
            szachownica[0][0].setText(String.valueOf(1));
            szachownica[0][1].setBackground(czarny);
            szachownica[0][4].setBackground(czarny);
            szachownica[0][6].setBackground(czarny);
            szachownica[1][6].setBackground(czarny);
            szachownica[1][6].setText(String.valueOf(0));
            szachownica[2][0].setBackground(czarny);
            szachownica[2][0].setText(String.valueOf(1));
            szachownica[3][3].setBackground(czarny);
            szachownica[3][3].setText(String.valueOf(0));
            szachownica[4][6].setBackground(czarny);
            szachownica[4][6].setText(String.valueOf(0));
            szachownica[5][0].setBackground(czarny);
            szachownica[6][0].setBackground(czarny);
            szachownica[6][2].setBackground(czarny);
            szachownica[6][2].setText(String.valueOf(3));
            szachownica[6][5].setBackground(czarny);
            szachownica[6][6].setBackground(czarny);
        }
        //plansza numer sześć
        if (numerPlanszy == 5) {
            szachownica[0][2].setBackground(czarny);
            szachownica[0][4].setBackground(czarny);
            szachownica[1][1].setBackground(czarny);
            szachownica[1][5].setBackground(czarny);
            szachownica[1][5].setText(String.valueOf(4));
            szachownica[2][0].setBackground(czarny);
            szachownica[2][0].setText(String.valueOf(0));
            szachownica[2][6].setBackground(czarny);
            szachownica[3][3].setBackground(czarny);
            szachownica[3][3].setText(String.valueOf(0));
            szachownica[4][0].setBackground(czarny);
            szachownica[4][0].setText(String.valueOf(1));
            szachownica[4][6].setBackground(czarny);
            szachownica[5][1].setBackground(czarny);
            szachownica[5][5].setBackground(czarny);
            szachownica[6][2].setBackground(czarny);
            szachownica[6][2].setText(String.valueOf(2));
            szachownica[6][4].setBackground(czarny);
            szachownica[6][4].setText(String.valueOf(2));
        }
        //plansza numer siedem
        if (numerPlanszy == 6) {
            szachownica[0][3].setBackground(czarny);
            szachownica[0][3].setText(String.valueOf(1));
            szachownica[0][4].setBackground(czarny);
            szachownica[0][4].setText(String.valueOf(1));
            szachownica[2][0].setBackground(czarny);
            szachownica[3][0].setBackground(czarny);
            szachownica[3][0].setText(String.valueOf(0));
            szachownica[3][6].setBackground(czarny);
            szachownica[3][6].setText(String.valueOf(2));
            szachownica[4][6].setBackground(czarny);
            szachownica[6][2].setBackground(czarny);
            szachownica[6][2].setText(String.valueOf(0));
            szachownica[6][3].setBackground(czarny);
            szachownica[6][3].setText(String.valueOf(1));
        }
        //plansza numer osiem
        if (numerPlanszy == 7) {
            szachownica[0][1].setBackground(czarny);
            szachownica[0][1].setText(String.valueOf(3));
            szachownica[0][4].setBackground(czarny);
            szachownica[1][6].setBackground(czarny);
            szachownica[2][0].setBackground(czarny);
            szachownica[2][0].setText(String.valueOf(0));
            szachownica[4][6].setBackground(czarny);
            szachownica[5][0].setBackground(czarny);
            szachownica[5][0].setText(String.valueOf(1));
            szachownica[6][2].setBackground(czarny);
            szachownica[6][5].setBackground(czarny);
            szachownica[6][5].setText(String.valueOf(3));
        }
        //plansza numer dziewięć
        if (numerPlanszy == 8) {
            szachownica[0][2].setBackground(czarny);
            szachownica[0][2].setText(String.valueOf(1));
            szachownica[2][3].setBackground(czarny);
            szachownica[2][3].setText(String.valueOf(3));
            szachownica[2][6].setBackground(czarny);
            szachownica[3][2].setBackground(czarny);
            szachownica[3][4].setBackground(czarny);
            szachownica[3][4].setText(String.valueOf(2));
            szachownica[4][0].setBackground(czarny);
            szachownica[4][3].setBackground(czarny);
            szachownica[4][3].setText(String.valueOf(4));
            szachownica[6][4].setBackground(czarny);
            szachownica[6][4].setText(String.valueOf(1));
        }
        //plansza numer dziesięć
        if (numerPlanszy == 9) {
            szachownica[0][3].setBackground(czarny);
            szachownica[1][1].setBackground(czarny);
            szachownica[1][4].setBackground(czarny);
            szachownica[1][4].setText(String.valueOf(0));
            szachownica[1][5].setBackground(czarny);
            szachownica[1][5].setText(String.valueOf(0));
            szachownica[2][1].setBackground(czarny);
            szachownica[3][0].setBackground(czarny);
            szachownica[3][0].setText(String.valueOf(2));
            szachownica[3][6].setBackground(czarny);
            szachownica[4][5].setBackground(czarny);
            szachownica[4][5].setText(String.valueOf(1));
            szachownica[5][1].setBackground(czarny);
            szachownica[5][1].setText(String.valueOf(2));
            szachownica[5][2].setBackground(czarny);
            szachownica[5][2].setText(String.valueOf(1));
            szachownica[5][5].setBackground(czarny);
            szachownica[6][3].setBackground(czarny);
            szachownica[6][3].setText(String.valueOf(0));
        }
        //plansza numer jedenaście
        if (numerPlanszy == 10) {
            szachownica[0][3].setBackground(czarny);
            szachownica[0][3].setText(String.valueOf(2));
            szachownica[2][2].setBackground(czarny);
            szachownica[2][4].setBackground(czarny);
            szachownica[2][4].setText(String.valueOf(0));
            szachownica[3][0].setBackground(czarny);
            szachownica[3][0].setText(String.valueOf(1));
            szachownica[3][6].setBackground(czarny);
            szachownica[3][6].setText(String.valueOf(2));
            szachownica[4][2].setBackground(czarny);
            szachownica[4][2].setText(String.valueOf(3));
            szachownica[4][4].setBackground(czarny);
            szachownica[4][4].setText(String.valueOf(0));
            szachownica[6][3].setBackground(czarny);
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void startThread() {
        panelSzachownicy.startThread();
    }

    public void sprawdzWynik() {
        panelSzachownicy.sprawdzWynik();
    }

    public final Color czarny = new Color(0, 0, 0);
    JButton[][] szachownica = new JButton[7][7];
    JButton sprawdz = new JButton("Sprawdź wynik");
    private PanelSzachownicy panelSzachownicy = new PanelSzachownicy();
    public Color mojColor1 = new Color(255, 255, 0);
    public Color mojColor2 = new Color(255, 254, 0);
    Random generator = new Random();
    int numerPlanszy;
    public JOptionPane tekstWygranej = new JOptionPane();
    class PanelSzachownicy extends JPanel {
        public class ButtonRunnable implements Runnable {
            private boolean timeToQuit = false;
            @Override
            public void run() {
                try {
                    while (!timeToQuit) {
                        for (int p = 0; p < 7; p++) {
                            for (int o = 0; o < 7; o++) {
                                // Wyłączanie żarówki
                                if (szachownica[p][o].getModel().isPressed() && Color.GREEN.equals(szachownica[p][o].getBackground())) {
                                    for (int m = 0; m < 7; m++) {
                                        if (!Color.GREEN.equals(szachownica[m][o].getBackground()) && !czarny.equals(szachownica[m][o].getBackground()) && mojColor1.equals(szachownica[m][o].getBackground())) {
                                            szachownica[m][o].setBackground(Color.WHITE);
                                        } else if (!Color.GREEN.equals(szachownica[m][o].getBackground()) && !czarny.equals(szachownica[m][o].getBackground()) && mojColor2.equals(szachownica[m][o].getBackground())) {
                                            szachownica[m][o].setBackground(mojColor1);
                                        }
                                    }
                                    for (int m = 0; m < 7; m++) {
                                        if (!Color.GREEN.equals(szachownica[p][m].getBackground()) && !czarny.equals(szachownica[p][m].getBackground()) && mojColor1.equals(szachownica[p][m].getBackground())) {
                                            szachownica[p][m].setBackground(Color.white);
                                        } else if (!Color.GREEN.equals(szachownica[p][m].getBackground()) && !czarny.equals(szachownica[p][m].getBackground()) && mojColor2.equals(szachownica[p][m].getBackground())) {
                                            szachownica[p][m].setBackground(mojColor1);
                                        }
                                    }
                                    szachownica[p][o].setBackground(Color.WHITE);
                                    Thread.sleep(200);
                                }
                                //Włączanie żarówki
                                if (szachownica[p][o].getModel().isPressed() && !mojColor1.equals(szachownica[p][o].getBackground()) && !mojColor2.equals(szachownica[p][o].getBackground()) && !czarny.equals(szachownica[p][o].getBackground())) {
                                    for (int u = 0; u < 7; u++) {
                                        if (!Color.GREEN.equals(szachownica[u][o].getBackground()) && !czarny.equals(szachownica[u][o].getBackground()) && mojColor1.equals(szachownica[u][o].getBackground())) {
                                            szachownica[u][o].setBackground(mojColor2);
                                        } else if (!Color.GREEN.equals(szachownica[u][o].getBackground()) && !czarny.equals(szachownica[u][o].getBackground()) && !mojColor1.equals(szachownica[u][o].getBackground()) && !mojColor2.equals(szachownica[u][o].getBackground())) {
                                            szachownica[u][o].setBackground(mojColor1);
                                        }
                                        else if (czarny.equals(szachownica[u][o].getBackground()) && u > p)
                                            break;
                                        else if (czarny.equals(szachownica[u][o].getBackground()) && u < p)
                                            for (int q = 1; q < u + 1; q++){
                                                if(mojColor1.equals(szachownica[u-q][o].getBackground()))
                                                    szachownica[u-q][o].setBackground(Color.WHITE);
                                            }

                                    }
                                    for (int u = 0; u < 7; u++) {
                                        if (!Color.GREEN.equals(szachownica[p][u].getBackground()) && !czarny.equals(szachownica[p][u].getBackground()) && mojColor1.equals(szachownica[p][u].getBackground())) {
                                            szachownica[p][u].setBackground(mojColor2);
                                        } else if (!Color.GREEN.equals(szachownica[p][u].getBackground()) && !czarny.equals(szachownica[p][u].getBackground()) && !mojColor1.equals(szachownica[p][u].getBackground()) && !mojColor2.equals(szachownica[p][u].getBackground())) {
                                            szachownica[p][u].setBackground(mojColor1);
                                        }
                                        else if (czarny.equals(szachownica[p][u].getBackground()) && u > o)
                                            break;
                                        else if (czarny.equals(szachownica[p][u].getBackground()) && u < o)
                                            for (int q = 1; q < u + 1; q++){
                                                if(mojColor1.equals(szachownica[p][u-q].getBackground()))
                                                    szachownica[p][u-q].setBackground(Color.WHITE);
                                            }
                                    }
                                    szachownica[p][o].setBackground(Color.GREEN);
                                    Thread.sleep(200);
                                }
                            }
                        }
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

        public void sprawdzWynik() {
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // warunki sprawdzające wynik dla wylosowanej planszy
            if (numerPlanszy == 0) {
                if (Color.GREEN.equals(szachownica[0][2].getBackground()) && Color.GREEN.equals(szachownica[0][5].getBackground()) && Color.GREEN.equals(szachownica[1][0].getBackground())
                        && Color.GREEN.equals(szachownica[1][6].getBackground()) && Color.GREEN.equals(szachownica[2][1].getBackground()) && Color.GREEN.equals(szachownica[3][0].getBackground())
                        && Color.GREEN.equals(szachownica[3][4].getBackground()) && Color.GREEN.equals(szachownica[4][1].getBackground()) && Color.GREEN.equals(szachownica[5][5].getBackground())
                        && Color.GREEN.equals(szachownica[6][3].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 1) {
                if (Color.GREEN.equals(szachownica[1][1].getBackground()) && Color.GREEN.equals(szachownica[0][3].getBackground()) && Color.GREEN.equals(szachownica[1][5].getBackground()) &&
                        Color.GREEN.equals(szachownica[2][0].getBackground()) && Color.GREEN.equals(szachownica[3][2].getBackground()) && Color.GREEN.equals(szachownica[3][4].getBackground()) &&
                        Color.GREEN.equals(szachownica[4][5].getBackground()) && Color.GREEN.equals(szachownica[5][0].getBackground()) && Color.GREEN.equals(szachownica[5][6].getBackground()) &&
                        Color.GREEN.equals(szachownica[6][1].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 2) {
                if (Color.GREEN.equals(szachownica[0][1].getBackground()) && Color.GREEN.equals(szachownica[1][2].getBackground()) && Color.GREEN.equals(szachownica[1][4].getBackground()) &&
                        Color.GREEN.equals(szachownica[2][3].getBackground()) && Color.GREEN.equals(szachownica[2][5].getBackground()) && Color.GREEN.equals(szachownica[3][4].getBackground()) &&
                        Color.GREEN.equals(szachownica[3][6].getBackground()) && Color.GREEN.equals(szachownica[4][1].getBackground()) && Color.GREEN.equals(szachownica[4][5].getBackground()) &&
                        Color.GREEN.equals(szachownica[5][2].getBackground()) && Color.GREEN.equals(szachownica[5][4].getBackground()) && Color.GREEN.equals(szachownica[6][0].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 3) {
                if (Color.GREEN.equals(szachownica[0][4].getBackground()) && Color.GREEN.equals(szachownica[0][6].getBackground()) && Color.GREEN.equals(szachownica[1][3].getBackground()) &&
                        Color.GREEN.equals(szachownica[3][1].getBackground()) && Color.GREEN.equals(szachownica[4][5].getBackground()) && Color.GREEN.equals(szachownica[5][4].getBackground()) &&
                        Color.GREEN.equals(szachownica[6][0].getBackground()) && Color.GREEN.equals(szachownica[6][2].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 4) {
                if (Color.GREEN.equals(szachownica[0][3].getBackground()) && Color.GREEN.equals(szachownica[1][0].getBackground()) && Color.GREEN.equals(szachownica[2][4].getBackground()) &&
                        Color.GREEN.equals(szachownica[3][5].getBackground()) && Color.GREEN.equals(szachownica[4][0].getBackground()) && Color.GREEN.equals(szachownica[5][2].getBackground()) &&
                        Color.GREEN.equals(szachownica[6][1].getBackground()) && Color.GREEN.equals(szachownica[6][3].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 5) {
                if (Color.GREEN.equals(szachownica[0][0].getBackground()) && Color.GREEN.equals(szachownica[0][3].getBackground()) && Color.GREEN.equals(szachownica[0][5].getBackground()) &&
                        Color.GREEN.equals(szachownica[1][4].getBackground()) && Color.GREEN.equals(szachownica[1][6].getBackground()) && Color.GREEN.equals(szachownica[2][5].getBackground()) &&
                        Color.GREEN.equals(szachownica[3][1].getBackground()) && Color.GREEN.equals(szachownica[3][6].getBackground()) && Color.GREEN.equals(szachownica[4][2].getBackground()) &&
                        Color.GREEN.equals(szachownica[5][0].getBackground()) && Color.GREEN.equals(szachownica[5][6].getBackground()) && Color.GREEN.equals(szachownica[6][1].getBackground()) &&
                        Color.GREEN.equals(szachownica[6][3].getBackground()) && Color.GREEN.equals(szachownica[6][5].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 6) {
                if (Color.GREEN.equals(szachownica[0][2].getBackground()) && Color.GREEN.equals(szachownica[1][4].getBackground()) && Color.GREEN.equals(szachownica[2][6].getBackground()) &&
                        Color.GREEN.equals(szachownica[3][5].getBackground()) && Color.GREEN.equals(szachownica[4][1].getBackground()) && Color.GREEN.equals(szachownica[5][3].getBackground()) &&
                        Color.GREEN.equals(szachownica[6][0].getBackground()) && Color.GREEN.equals(szachownica[6][6].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 7) {
                if (Color.GREEN.equals(szachownica[0][0].getBackground()) && Color.GREEN.equals(szachownica[0][2].getBackground()) && Color.GREEN.equals(szachownica[0][6].getBackground()) &&
                        Color.GREEN.equals(szachownica[1][1].getBackground()) && Color.GREEN.equals(szachownica[3][6].getBackground()) && Color.GREEN.equals(szachownica[4][3].getBackground()) &&
                        Color.GREEN.equals(szachownica[5][5].getBackground()) && Color.GREEN.equals(szachownica[6][0].getBackground()) && Color.GREEN.equals(szachownica[6][4].getBackground()) &&
                        Color.GREEN.equals(szachownica[6][6].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 8) {
                if (Color.GREEN.equals(szachownica[0][1].getBackground()) && Color.GREEN.equals(szachownica[0][4].getBackground()) && Color.GREEN.equals(szachownica[1][3].getBackground()) &&
                        Color.GREEN.equals(szachownica[2][2].getBackground()) && Color.GREEN.equals(szachownica[3][0].getBackground()) && Color.GREEN.equals(szachownica[3][3].getBackground()) &&
                        Color.GREEN.equals(szachownica[3][6].getBackground()) && Color.GREEN.equals(szachownica[4][2].getBackground()) && Color.GREEN.equals(szachownica[4][4].getBackground()) &&
                        Color.GREEN.equals(szachownica[5][3].getBackground()) && Color.GREEN.equals(szachownica[6][0].getBackground()) && Color.GREEN.equals(szachownica[6][5].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 9) {
                if (Color.GREEN.equals(szachownica[0][1].getBackground()) && Color.GREEN.equals(szachownica[0][6].getBackground()) && Color.GREEN.equals(szachownica[2][0].getBackground()) &&
                        Color.GREEN.equals(szachownica[2][3].getBackground()) && Color.GREEN.equals(szachownica[3][1].getBackground()) && Color.GREEN.equals(szachownica[4][2].getBackground()) &&
                        Color.GREEN.equals(szachownica[4][6].getBackground()) && Color.GREEN.equals(szachownica[5][0].getBackground()) && Color.GREEN.equals(szachownica[5][4].getBackground()) &&
                        Color.GREEN.equals(szachownica[6][1].getBackground()) && Color.GREEN.equals(szachownica[6][5].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");
                }
            }
            if (numerPlanszy == 10) {
                if (Color.GREEN.equals(szachownica[0][2].getBackground()) && Color.GREEN.equals(szachownica[0][5].getBackground()) && Color.GREEN.equals(szachownica[1][3].getBackground()) &&
                        Color.GREEN.equals(szachownica[2][0].getBackground()) && Color.GREEN.equals(szachownica[2][6].getBackground()) && Color.GREEN.equals(szachownica[3][2].getBackground()) &&
                        Color.GREEN.equals(szachownica[4][1].getBackground()) && Color.GREEN.equals(szachownica[4][6].getBackground()) && Color.GREEN.equals(szachownica[5][2].getBackground()) &&
                        Color.GREEN.equals(szachownica[6][0].getBackground()) && Color.GREEN.equals(szachownica[6][4].getBackground())) {
                    tekstWygranej.showMessageDialog(null, "WYGRAŁEŚ!!!!");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                }
            }
        }
        private ButtonRunnable r = new ButtonRunnable();
        private Thread t = new Thread(r);
        public void startThread() { t.start();
        }
    }
}