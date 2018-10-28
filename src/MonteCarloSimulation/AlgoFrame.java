package MonteCarloSimulation;
import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    // data
//    private Circle circle;
//    private LinkedList<Point> points;
    /*
    * After encapsulate Circle and Points to MonteCarloPiData,
    * We only need MonteCarloPiData
    * No need to create two private object circle and points
    * */
    private MonteCarloPiData data;

//    public void render(Circle circle, LinkedList<Point> points){
//        this.circle = circle;
//        this.points = points;
//        repaint();
//    }

    public void render(MonteCarloPiData data) {
        this.data = data;
        repaint(0);
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // Double Buffer
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // Anti-Aliasing
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // Plotting
            Circle circle = data.getCircle();
            AlgoVisHelper.setStrokeWidth(g2d, 3);
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);
            AlgoVisHelper.strokeCircle(g2d, circle.getX(), circle.getY(), circle.getR());


//            for(int i = 0 ; i < points.size() ; i ++){
//                Point p = points.get(i);
//                if(circle.contain(p))
//                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
//                else
//                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Green);
//
//                AlgoVisHelper.fillCircle(g2d, p.x, p.y, 3);
//            }

            for (int i = 0 ; i < data.getPointsNumber() ; i++) {
                Point p = data.getPoints(i);
                if (circle.contain(p)) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                }
                else {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Green);
                }
                AlgoVisHelper.fillCircle(g2d, p.x, p.y, 3);
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}