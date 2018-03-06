package cr.ac.jmoraroditcr.tetrisandroid;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    private int[][] gameMatrix = new int[21][10];//hay dos filas escondidas
    private boolean figurePlaying = false;
    private int currentFigure = -1;
    private int[][] currentPosition = new int[4][2];
    private boolean lost_game = false;
    private boolean movingPiece = false;
    private int figureAngle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 19; j++){
                gameMatrix[i][j] = 0;
            }
        }
        GridLayout grid = findViewById(R.id.tetrisGrid);
        ImageView newView;

        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++){
                newView = new ImageView(this);
                newView.setImageResource(R.color.colorAccent);





                if(i == 0 || i == rows - 1) {
                    Log.d("color","gray");
                    newView.setBackgroundColor(Color.GRAY);
                }
                else
                    newView.setBackgroundColor(Color.BLACK);
                Log.d("i and j", "i:"+i + " j:"+j);
                GridLayout.Spec rowSpan = GridLayout.spec(i,1);
                GridLayout.Spec colSpan = GridLayout.spec(j,1);
                GridLayout.LayoutParams gridLayoutParam = new GridLayout.LayoutParams(rowSpan, colSpan);
                gridLayoutParam.width = 8;
                gridLayoutParam.height = 5;
                grid.addView(newView, gridLayoutParam);

            }

        //timer
        Timer timing = new Timer();
        timing.schedule(new TimerTask() {

            @Override
            public void run() {

                if(!figurePlaying) {
                    currentFigure = ThreadLocalRandom.current().nextInt(1, 8);
                    figurePlaying = true;
                }
                switch (currentFigure){
                    case 1:// l

                        if(gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
                                && gameMatrix[0][6] == 0 && gameMatrix[0][7] == 0) {

                            currentPosition[0][0] = 0;
                            currentPosition[0][1] = 4;
                            currentPosition[1][0] = 0;
                            currentPosition[1][1] = 5;
                            currentPosition[2][0] = 0;
                            currentPosition[2][1] = 6;
                            currentPosition[3][0] = 0;
                            currentPosition[3][1] = 7;
                            gameMatrix[0][4] = -1;
                            gameMatrix[0][5] = -1;
                            gameMatrix[0][6] = -1;
                            gameMatrix[0][7] = -1;
                        }else
                            lost_game = true;

                        break;
                    case 2: //J
                        if(gameMatrix[0][4] == 0 && gameMatrix[1][3] == 0
                                && gameMatrix[1][5] == 0 && gameMatrix[1][6] == 0) {

                            currentPosition[0][0] = 0;
                            currentPosition[0][1] = 4;
                            currentPosition[1][0] = 1;
                            currentPosition[1][1] = 4;
                            currentPosition[2][0] = 1;
                            currentPosition[2][1] = 5;
                            currentPosition[3][0] = 1;
                            currentPosition[3][1] = 6;
                            gameMatrix[0][4] = -1;
                            gameMatrix[1][4] = -1;
                            gameMatrix[1][5] = -1;
                            gameMatrix[1][6] = -1;
                        }else
                            lost_game = true;
                        break;
                    case 3: //L
                        if(gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
                                && gameMatrix[0][6] == 0 && gameMatrix[0][7] == 0) {

                            currentPosition[0][0] = 0;
                            currentPosition[0][1] = 6;
                            currentPosition[1][0] = 1;
                            currentPosition[1][1] = 4;
                            currentPosition[2][0] = 1;
                            currentPosition[2][1] = 5;
                            currentPosition[3][0] = 1;
                            currentPosition[3][1] = 6;
                            gameMatrix[0][6] = -1;
                            gameMatrix[1][4] = -1;
                            gameMatrix[1][5] = -1;
                            gameMatrix[1][6] = -1;
                        }else
                            lost_game = true;
                        break;
                    case 4: //O
                        if(gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
                                && gameMatrix[0][6] == 0 && gameMatrix[0][7] == 0) {

                            currentPosition[0][0] = 0;
                            currentPosition[0][1] = 4;
                            currentPosition[1][0] = 0;
                            currentPosition[1][1] = 5;
                            currentPosition[2][0] = 1;
                            currentPosition[2][1] = 4;
                            currentPosition[3][0] = 1;
                            currentPosition[3][1] = 5;
                            gameMatrix[0][4] = -1;
                            gameMatrix[0][5] = -1;
                            gameMatrix[1][4] = -1;
                            gameMatrix[1][5] = -1;
                        }else
                            lost_game = true;
                        break;
                    case 5: //S
                        if(gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
                                && gameMatrix[0][6] == 0 && gameMatrix[0][7] == 0) {

                            currentPosition[0][0] = 1;
                            currentPosition[0][1] = 4;
                            currentPosition[1][0] = 1;
                            currentPosition[1][1] = 5;
                            currentPosition[2][0] = 0;
                            currentPosition[2][1] = 5;
                            currentPosition[3][0] = 0;
                            currentPosition[3][1] = 6;
                            gameMatrix[1][4] = -1;
                            gameMatrix[1][5] = -1;
                            gameMatrix[0][5] = -1;
                            gameMatrix[0][6] = -1;
                        }else
                            lost_game = true;
                        break;
                    case 6: //T
                        if(gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
                                && gameMatrix[0][6] == 0 && gameMatrix[0][7] == 0) {

                            currentPosition[0][0] = 0;
                            currentPosition[0][1] = 5;
                            currentPosition[1][0] = 1;
                            currentPosition[1][1] = 4;
                            currentPosition[2][0] = 1;
                            currentPosition[2][1] = 5;
                            currentPosition[3][0] = 1;
                            currentPosition[3][1] = 6;
                            gameMatrix[0][5] = -1;
                            gameMatrix[1][4] = -1;
                            gameMatrix[1][5] = -1;
                            gameMatrix[1][6] = -1;
                        }else
                            lost_game = true;
                        break;
                    case 7: //Z
                        if(gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
                                && gameMatrix[0][6] == 0 && gameMatrix[0][7] == 0) {

                            currentPosition[0][0] = 0;
                            currentPosition[0][1] = 4;
                            currentPosition[1][0] = 0;
                            currentPosition[1][1] = 5;
                            currentPosition[2][0] = 1;
                            currentPosition[2][1] = 5;
                            currentPosition[3][0] = 1;
                            currentPosition[3][1] = 6;
                            gameMatrix[0][4] = -1;
                            gameMatrix[0][5] = -1;
                            gameMatrix[1][5] = -1;
                            gameMatrix[1][6] = -1;
                        }else
                            lost_game = true;
                        break;
                }
                if(!movingPiece)
                    moveDown();



            }
        }, 100);
    }
    private void moveLeft(){
        movingPiece = true;
        GridLayout grid = findViewById(R.id.tetrisGrid);
        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();

        for(int i = 0 ; i < 4 ; i++)
        {
            if(currentPosition[i][1] - 1 >= 0)
                currentPosition[i][1] -= 1;
            else
                return;
        }
        for(int i = 0; i < 4; i++){
                gameMatrix[currentPosition[i][0]][currentPosition[i][1] + 1] = 0;
                gameMatrix[currentPosition[i][0]][currentPosition[i][1] ] = -1;

        }

        /*
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++){
                if(gameMatrix[i][j] == -1  && (j-1 >= 0)) {
                    gameMatrix[i][j-1]= -1 ;
                    gameMatrix[i][j]= 0;
                }
            }*/
        movingPiece = false;

    }
    private void moveRight(){
        movingPiece = true;
        GridLayout grid = findViewById(R.id.tetrisGrid);

        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++){
                if(gameMatrix[i][j] == -1  && (j + 1 < cols)) {
                    gameMatrix[i][j+1]= -1 ;
                    gameMatrix[i][j]= 0;
                }
            }
        movingPiece = false;

    }
    private void moveDown(){
        movingPiece = true;
        GridLayout grid = findViewById(R.id.tetrisGrid);
        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++){
                if(gameMatrix[i][j] == -1 && (i+1 < rows)) {
                    gameMatrix[i+1][j]= -1 ;
                    gameMatrix[i][j]= 0;
                }
            }
        movingPiece = false;
    }
    private void rotateFigure(){
        movingPiece = true;
        GridLayout grid = findViewById(R.id.tetrisGrid);
        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();
        figureAngle++;
        switch (currentFigure){
            case 1://l
                int currentBlock = 0;
                for(int i = 0; i < rows; i++)
                    for(int j = 0; j < cols; j++){
                        switch (figureAngle){
                            case 0:

                        }

                    }

        }
        movingPiece = false;
    }
}
