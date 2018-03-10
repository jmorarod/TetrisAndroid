package cr.ac.jmoraroditcr.tetrisandroid;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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
    private int score = 0;

    public void onClickBtnReplay(View view){
        restart();
    }

    public void onClickBtnDown(View view){
        try {
            moveDown();
        }catch (Exception ex){}
    }
    public void onClickBtnRotate(View view){
        try {
            rotateFigure();
        }catch (Exception ex){}
    }
    public void onClickBtnRight(View view){
        try {
            moveRight();
        }catch (Exception ex){}
    }
    public void onClickBtnLeft(View view){
        try {
            moveLeft();
        }catch (Exception ex){}

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 10; j++){
                gameMatrix[i][j] = 0;
            }
        }
        final GridLayout grid = findViewById(R.id.tetrisGrid);
        ImageView newView;

        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++){
                newView = new ImageView(this);



                if(i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    newView.setImageResource(R.color.gray);
                }
                else
                    newView.setImageResource(R.color.black);

                GridLayout.Spec rowSpan = GridLayout.spec(i,1);
                GridLayout.Spec colSpan = GridLayout.spec(j,1);
                GridLayout.LayoutParams gridLayoutParam = new GridLayout.LayoutParams(rowSpan, colSpan);
                gridLayoutParam.width = 90;
                gridLayoutParam.height = 60;
                gridLayoutParam.rightMargin = 0;
                gridLayoutParam.topMargin = 0;

                gridLayoutParam.columnSpec = colSpan;
                gridLayoutParam.rowSpec = rowSpan;

                grid.addView(newView, gridLayoutParam);

            }
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if(!figurePlaying) {
                    currentFigure = ThreadLocalRandom.current().nextInt(1, 8);
                    figurePlaying = true;
                    Log.d("figure", currentFigure+"");
                    switch (currentFigure) {

                        case 1:// l

                            if (gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
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
                            } else
                                lost_game = true;

                            break;
                        case 2: //J
                            if (gameMatrix[0][4] == 0 && gameMatrix[1][3] == 0
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
                            } else
                                lost_game = true;
                            break;
                        case 3: //L
                            if (gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
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
                            } else
                                lost_game = true;
                            break;
                        case 4: //O
                            if (gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
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
                            } else
                                lost_game = true;
                            break;
                        case 5: //S
                            if (gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
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
                            } else
                                lost_game = true;
                            break;
                        case 6: //T
                            if (gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
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
                            } else
                                lost_game = true;
                            break;
                        case 7: //Z
                            if (gameMatrix[0][4] == 0 && gameMatrix[0][5] == 0
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
                            } else
                                lost_game = true;
                            break;
                    }/*
                    if (!movingPiece)
                        moveDown();
                    */
                }else{
                    if(!lost_game) {
                        int[][] position = copyMatrix(currentPosition);
                        boolean movedDown = moveDown();
                        if (!movedDown) {
                            currentPosition = position;
                            figurePlaying = false;
                            setCurrentFigure();
                            checkCompletedRows();
                        }
                        if (checkCollision(currentPosition)) {
                            //Log.d("Collition","Collition");
                            currentPosition = position;
                            figurePlaying = false;
                            setCurrentFigure();
                        }

                    }
                }
                if(!lost_game)
                    updateGridLayout();
                else{
                    RelativeLayout relativeLayout = findViewById(R.id.loseLayout);
                    relativeLayout.setVisibility(View.VISIBLE);
                    relativeLayout.setAlpha(0.9f);
                    grid.setAlpha(0.5f);
                    grid.setClickable(false);
                    RelativeLayout relativeLayout1 = findViewById(R.id.btnLayout);
                    relativeLayout1.setClickable(false);
                }

                /*
                for(int i = 0; i < 21; i++){
                    for (int j = 0 ; j<10;j++){
                        Log.d("Value",gameMatrix[i][j]+"");
                    }
                    Log.d("nextRow","nextRow");
                }*/
                handler.postDelayed(this, 1000);

            }

        };
        handler.post(runnable);

    }
    public void restart(){
        RelativeLayout relativeLayout = findViewById(R.id.loseLayout);
        relativeLayout.setVisibility(View.INVISIBLE);
        GridLayout grid = findViewById(R.id.tetrisGrid);
        grid.setAlpha(1f);
        grid.setClickable(true);
        RelativeLayout relativeLayout1 = findViewById(R.id.btnLayout);
        relativeLayout1.setClickable(true);
        gameMatrix = new int[21][10];//hay dos filas escondidas
        figurePlaying = false;
        currentFigure = -1;
        currentPosition = new int[4][2];
        lost_game = false;
        movingPiece = false;
        score = 0;
        TextView view = findViewById(R.id.txtScore);
        view.setText("0");
    }
    public void setCurrentFigure(){
        for(int i = 0; i < 4; i++) {
            gameMatrix[currentPosition[i][0]][currentPosition[i][1]] = currentFigure;

        }
    }
    public void checkCompletedRows(){
        boolean notComplete = false;

        for(int i = 0; i < 4; i++){
            int currentRow = currentPosition[i][0];
            for(int j = 0; j < 10; j++){
                if(gameMatrix[currentRow][j] == 0)
                    notComplete = true;
            }
            if(!notComplete){
                Log.d("info","clearRow");
                score++;
                TextView view = findViewById(R.id.txtScore);
                view.setText(score+"");
                int previousRow = currentRow - 1;
                for(int j = 0; j < 10; j++){
                    gameMatrix[currentRow][j] = gameMatrix[previousRow][j];
                    gameMatrix[previousRow][j] = 0;
                }
            }
            notComplete = false;
        }
    }
    public void updateGridLayout(){
        GridLayout grid = findViewById(R.id.tetrisGrid);
        for(int i = 1; i < grid.getRowCount() - 1; i++)
            for(int j = 1; j < grid.getColumnCount() - 1; j++){


                    ImageView view = (ImageView) grid.getChildAt(i * grid.getColumnCount() + j);

                    if (gameMatrix[i + 1][j - 1] == 0)
                        view.setImageResource(R.color.black);
                    else if (gameMatrix[i + 1][j - 1] == -1)
                        view.setImageResource(R.color.colorPrimary);
                    else
                        view.setImageResource(R.color.colorAccent);


            }
    }
    public int[][] copyMatrix(int[][] matrix)
    {
        int[][] result = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++)

                result[i] = matrix[i].clone();

        return result;
    }
    private void moveLeft(){
        movingPiece = true;
        GridLayout grid = findViewById(R.id.tetrisGrid);
        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();
        int[][] position = copyMatrix(currentPosition);
        for(int i = 0 ; i < 4 ; i++)
        {
            int row = currentPosition[i][0];
            int column = currentPosition[i][1];
            if(column - 1 >= 0 && (gameMatrix[row][column - 1] == 0 || gameMatrix[row][column - 1] == -1))
                currentPosition[i][1] -= 1;
            else {
                currentPosition = position;
                return;
            }
        }
        for(int i = 0; i < 4; i++){
                int row = currentPosition[i][0];
                int column = currentPosition[i][1];
                if(!posInFigure(row,column+1))
                    gameMatrix[row][column + 1] = 0;
                gameMatrix[row][column] = -1;

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
        int[][] position = copyMatrix(currentPosition);
        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();
        for(int i = 0 ; i < 4 ; i++)
        {
            int row = currentPosition[i][0];
            int column = currentPosition[i][1];
            if((column + 1 < cols) && (gameMatrix[row][column + 1] == 0 || gameMatrix[row][column + 1] == -1))
                currentPosition[i][1] += 1;
            else {
                currentPosition = position;
                return;
            }
        }
        for(int i = 0; i < 4; i++){
            int row = currentPosition[i][0];
            int column = currentPosition[i][1];
            if(!posInFigure(row,column-1))
                gameMatrix[row][column - 1] = 0;
            gameMatrix[row][column] = -1;

        }
        /*
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++){
                if(gameMatrix[i][j] == -1  && (j + 1 < cols)) {
                    gameMatrix[i][j+1]= -1 ;
                    gameMatrix[i][j]= 0;
                }
            }*/
        movingPiece = false;

    }
    private boolean moveDown(){

        movingPiece = true;
        GridLayout grid = findViewById(R.id.tetrisGrid);
        int[][] position = copyMatrix(currentPosition);
        for(int i = 0 ; i < 4 ; i++)
        {
            int row = currentPosition[i][0];
            int column = currentPosition[i][1];
            if((row + 1 < 21) && (gameMatrix[row + 1][column] == 0 || gameMatrix[row + 1][column] == -1))
                currentPosition[i][0] += 1;
            else {
                currentPosition = position;
                return false;
            }
        }
        for(int i = 0; i < 4; i++){
            int row = currentPosition[i][0];
            int column = currentPosition[i][1];
            if(!posInFigure(row-1,column))
                gameMatrix[row - 1][column ] = 0;
            gameMatrix[row][column] = -1;

        }
        /*
        for(int i = 0; i < 21; i++)
            for(int j = 0; j < 10; j++){
                if(i+1 >= 21)
                    return false;
                if(gameMatrix[i][j] == -1) {
                    gameMatrix[i+1][j]= -1 ;
                    gameMatrix[i][j]= 0;
                }
            }*/
        movingPiece = false;
        return true;
    }
    private boolean posInFigure(int row, int column){
        for(int i = 0; i < 4; i++)
            if(row == currentPosition[i][0] && column == currentPosition[i][1])
                return true;
        return false;

    }
    private void rotateFigure(){
        movingPiece = true;
        GridLayout grid = findViewById(R.id.tetrisGrid);
        boolean cancelRotate = false;
        final int cols = grid.getColumnCount();
        final int rows = grid.getRowCount();

        int position[][] =copyMatrix(currentPosition);
        int pivot[] = new int[2];
        switch (currentFigure) {
            case 5: //S
                pivot = currentPosition[1];
                break;
            case 6://T
                pivot = currentPosition[0];
                break;
            case 7://
                pivot = currentPosition[2];
                break;
            case 3://o
                return;
            default:
                pivot = currentPosition[0];
                break;

        }
        int rotatedBlock[] = new int[2];
        for(int i = 0; i < 4; i++) {


            rotatedBlock = getRotatedBlock(currentPosition[i][0],
                    currentPosition[i][1], pivot[0], pivot[1]);
            if (checkCollision(rotatedBlock)) {
                Log.d("collition","cancel rotate");
                cancelRotate = true;
                break;
            }
            currentPosition[i] = rotatedBlock;
        }
        if(cancelRotate)
            currentPosition = position;
        else{
            for(int i = 0; i < 4; i++) {
                gameMatrix[position[i][0]][position[i][1]] = 0;
            }
        }
        movingPiece = false;
    }
    private int[] getRotatedBlock(int x1, int y1, int px, int py){
        int[] rotatedPos = new int[2];
        rotatedPos[0] = y1 + px - py;
        rotatedPos[1] = px + py - x1 - 1;
        return rotatedPos;

    }
    private boolean checkCollision(int[] position){
        if(gameMatrix[position[0]][position[1]] != 0 && gameMatrix[position[0]][position[1]] != -1){
            Log.d("if","first if");
            return true;
        }else
            if(position[0] > 21 || position[1]<0 || position[1]>10)
                return true;
        return false;
    }
    private boolean checkCollision(int[][] position){
        int[] block1 = position[0];
        int[] block2 = position[1];
        int[] block3 = position[2];
        int[] block4 = position[3];
        if(gameMatrix[block1[0]][block1[1]] != 0 && gameMatrix[block1[0]][block1[1]] != -1)
            return true;
        else
            if(gameMatrix[block2[0]][block2[1]] != 0 && gameMatrix[block2[0]][block2[1]] != -1)
                return true;
            else
                if (gameMatrix[block3[0]][block3[1]] != 0 && gameMatrix[block3[0]][block3[1]] != -1)
                    return true;
                else
                    if(gameMatrix[block4[0]][block4[1]] != 0 && gameMatrix[block4[0]][block4[1]] != -1)
                        return true;
        return false;

    }
}
