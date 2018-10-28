package MonteCarloSimulation;

import java.awt.*;
/*
* If we set 50,000 points in visualization program, the computer
* cannot handle that much points in UI since plotting points in
* UI consumes huge resources.
* However, Monte Carlo Simulation needs large amount of simulations
* to achieve accurate results.
*
* This console program only simulates data, and there's no UI displayed.
* Therefore, we can let this program handle more simulations each time to
* get more accurate value of Pi.
*
* */
public class MonteCarloExperiment {

    private int squareSide; // Length of the Square Side
    private int N;
    private int outputInterval = 100;

    public MonteCarloExperiment(int squareSide, int N) {
        if (squareSide <= 0 || N <= 0) {
            throw new IllegalArgumentException("Squareside and N must larger than 0.");
        }
        this.squareSide = squareSide;
        this.N = N;
    }

    public void setOutputInterval(int outputInterval) {
        if (outputInterval <= 0) {
            throw new IllegalArgumentException("Output Interval Must be Larger than 0.");
        }
        this.outputInterval = outputInterval;
    }

    public void run() {
        Circle circle = new Circle(squareSide/2, squareSide/2, squareSide/2);
        MonteCarloPiData data = new MonteCarloPiData(circle);

        for (int i = 0 ; i < N ; i++) {
            if (i % outputInterval == 0) {
                System.out.println(data.estimatePi());
            }
            int x = (int)(Math.random() * squareSide);
            int y = (int)(Math.random() * squareSide);
            data.addPoint(new Point(x, y));
        }
    }

    public static void main(String[] args) {

        int squareSide = 800;
        int N = 10000000;

        MonteCarloExperiment exp = new MonteCarloExperiment(squareSide, N);
        exp.setOutputInterval(10000);
        exp.run();
    }
}
