package RandomMoneyGiving;

import java.util.Arrays;
import java.awt.*;

public class AlgoVisualizer {

    private static int DELAY = 10;
    private int[] money;
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        money = new int[100];
        for(int i = 0 ; i < money.length ; i ++)
            money[i] = 100;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Money Problem", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // Animation Logic
    public void run(){

        while(true){

            Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            // k < 5 means the animation is running 5 times as the normal speed
            for (int k = 0 ; k < 5 ; k++) {
                for(int i = 0 ; i < money.length; i ++){
                    if(money[i] > 0){
                        int j = (int)(Math.random() * money.length);
                        money[i] -= 1;
                        money[j] += 1;
                    }
                }
            }

        }
    }


}