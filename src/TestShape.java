import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class TestShape extends JFrame {
    Random ran = new Random();
    Vector<JLabel> picture = new Vector<>();
    public TestShape() {
        setBounds(50,50,1400,920);
    }


    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    public void createAnimation(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            System.out.println(file.getName());
            JLabel temp = new JLabel(new ImageIcon((path + '\\' + file.getName())));
            picture.add(temp);
        }

    }

    public void playAnimation() throws InterruptedException {
        while (true) {
            for (int i = 0; i < picture.size(); i++) {
                add(picture.get(i));
                picture.get(i).repaint();
                Thread.sleep(75);
                setVisible(true);
                remove(picture.get(i));
            }
        }
    }

    public void createRandomShape() {
        int r = ran.nextInt(40);
        float red = ran.nextFloat();
        float green = ran.nextFloat();
        float blue = ran.nextFloat();
        Color randomColor = new Color(red, green, blue);
        int randomShape = ran.nextInt(4);

        JPanel temp = new JPanel() {
         @Override
         public void paint(Graphics g) {
             g.setColor(randomColor);
             if(randomShape == 0) {
                 g.fillOval(ran.nextInt(getWidth()), ran.nextInt(getHeight()), r, r);
             } else if (randomShape == 1) {
                 g.fillRect(ran.nextInt(getWidth()), ran.nextInt(getHeight()), r, r);
             } else if (randomShape == 2) {
                 g.fillRoundRect(ran.nextInt(getWidth()), ran.nextInt(getHeight()), r, r, ran.nextInt(getWidth()), ran.nextInt(getHeight()));
             }
         }
        };
        add(temp);
        setVisible(true);
    }

    public void insertImage(String path) {
        System.out.println("read");

        JLabel temp = new JLabel(new ImageIcon((path)));
        add(temp);
        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        TestShape shap = new TestShape();
        shap.setVisible(true);
        for(int i = 0; i < 200;i++) {
            shap.createRandomShape();
        }
        shap.repaint();

        TestShape shape2 = new TestShape();
        shape2.setVisible(true);
        shape2.insertImage(new Scanner(System.in).next());
        shape2.setVisible(true);
        shape2.revalidate();
        shape2.repaint();
        shape2.setVisible(true);


        TestShape shape3 = new TestShape();
        shape3.setVisible(true);
        shape3.createAnimation(new Scanner(System.in).next());
        shape3.setVisible(true);
        shape3.playAnimation();
    }
}
