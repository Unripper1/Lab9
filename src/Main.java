
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
class Shape extends JComponent {
}
class Four extends Shape{
    Random random=new Random();
    float r = random.nextFloat();
    float g = random.nextFloat();
    float b = random.nextFloat();
    Color c = new Color(r,g,b);
    int x1= random.nextInt(500);
    int x2=random.nextInt(500);
    int x3=random.nextInt(500);
    int x4=random.nextInt(500);
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setPaint(c);
        g2d.drawRect(x1,x2,x3,x4);
    }

}

class Circle extends Shape{
    Random random=new Random();
    float r = random.nextFloat();
    float g = random.nextFloat();
    float b = random.nextFloat();
    Color c = new Color(r,g,b);
    int x1=random.nextInt(500);
    int x2=random.nextInt(500);
    int x3=random.nextInt(500);
    int x4=random.nextInt(500);
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setPaint(c);
        g2d.drawOval(x1,x2,x3,x4);
    }
}
public class Main extends JFrame{
    private Circle circle;
    private Four rect;
    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setResizable(false);
        JPanel panel = new JPanel();
        JButton button = new JButton("START");
        button.setSize(200, 200);
        panel.add(button);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                for (int i = 0; i < 20; i++){
                    switch((int)(Math.random()*2)) {
                        case 0:
                            circle = new Circle();
                            add(circle);
                            break;
                        case 1:
                            rect = new Four();
                            add(rect);
                            break;
                    }
                    setVisible(true);

                }
            }
        };
        button.addActionListener(actionListener);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}