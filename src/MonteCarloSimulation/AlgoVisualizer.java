package MonteCarloSimulation;
import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;

public class AlgoVisualizer {

    private static int DELAY = 40;

//    private Circle circle;
//    private int insideCircle = 0;// the number of points inside the circle
//    private LinkedList<Point> points;
    private MonteCarloPiData data;
    private AlgoFrame frame;
    private int N;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        if(sceneWidth != sceneHeight)
            throw new IllegalArgumentException("This demo must be run in a square window!");

        this.N = N;

        Circle circle = new Circle(sceneWidth/2, sceneHeight/2, sceneWidth/2);
        LinkedList<Point> points = new LinkedList<>();
        data = new MonteCarloPiData(circle);

        // Initialize UI
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get Pi with Monte Carlo", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    public void run(){

        for(int i = 0 ; i < N ; i ++){

            // redering once per 100-time simulation (speed up the simulation)
            if (i % 100 == 0) {
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                System.out.println(data.estimatePi());

//                if (points.size() != 0) {
//                    int circleArea = insideCircle;
//                    int squareArea = points.size();
//                    double piEstimation = 4 * (double)circleArea / squareArea;
//                    System.out.println(piEstimation);
//                }
            }

        // slow simulation
//        frame.render(circle, points);
//        AlgoVisHelper.pause(DELAY);
//
//
//        if (points.size() != 0) {
//            int circleArea = insideCircle;
//            int squareArea = points.size();
//            double piEstimation = 4 * (double)circleArea / squareArea;
//            System.out.println(piEstimation);
//        }

            int x = (int)(Math.random() * frame.getCanvasWidth());
            int y = (int)(Math.random() * frame.getCanvasHeight());

//            Point p = new Point(x, y);
//            points.add(p);
//            if (circle.contain(p)) {
//                insideCircle++;
//            }
            data.addPoint(new Point(x, y));
        }

    }


}