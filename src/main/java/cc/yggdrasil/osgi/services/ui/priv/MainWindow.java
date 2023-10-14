package cc.yggdrasil.osgi.services.ui.priv;

import cc.yggdrasil.osgi.services.ui.Content;
import cc.yggdrasil.osgi.services.ui.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@org.osgi.service.component.annotations.Component
public class MainWindow extends JFrame implements cc.yggdrasil.osgi.services.ui.Container, Content, Menu
{
    private static int DEFAULT_WINDOW_X_POS = 100;
    private static int DEFAULT_WINDOW_Y_POS = 100;
    private static int DEFAULT_WINDOW_WIDTH = 600;
    private static int DEFAULT_WINDOW_HEIGHT = 400;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private JDesktopPane desktopPane;

    public MainWindow()
    {
        setLayout(null);

        setBounds(DEFAULT_WINDOW_X_POS, DEFAULT_WINDOW_Y_POS, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        setMinimumSize(new Dimension(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @org.osgi.service.component.annotations.Activate
    public void initialize()
    {
        logger.info("Initializing main window...");

        desktopPane = new JDesktopPane();

        JMenuBar menuBar = new JMenuBar();

        //Set up the lone menu.
        JMenu menu = new JMenu("Document");
        menu.setMnemonic(KeyEvent.VK_D);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        getContentPane();

        JLabel label = new JLabel("Frame 1  contents...");
        JButton button = new JButton("Button 1");

        label.setBounds(50, 50, 200, 50);
        button.setBounds(50, 100, 200, 50);

        JInternalFrame frame1 = new JInternalFrame("Frame 1", true, true, true,
                true);
        frame1.setBounds(0, 0, 250, 250);
        frame1.getContentPane().add(label);
        frame1.getContentPane().add(button);
        frame1.setBackground(Color.LIGHT_GRAY);

        frame1.pack();
        frame1.setVisible(true);

        desktopPane.add(frame1);
        desktopPane.setBackground(Color.GRAY);

        setContentPane(desktopPane);
    }

    /** {@inheritDoc} */
    public void display()
    {
        logger.info("Displaying main window...");

        pack();
        setVisible(true);
    }
}
