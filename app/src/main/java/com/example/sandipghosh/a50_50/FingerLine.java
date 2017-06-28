package com.example.sandipghosh.a50_50;

import android.content.Context;
import android.graphics.*;
import android.graphics.Paint.Style;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.widget.FrameLayout;


import java.util.ArrayList;
import java.util.List;

import static com.example.sandipghosh.a50_50.MainActivity.text1;
import static com.example.sandipghosh.a50_50.MainActivity.text2;


/**
 * Created by sandipghosh on 22/06/17.
 */

public class FingerLine extends View {
    private final Paint mPaint;
    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private float total;
    private float area;

    private float mean = (float) 1.7321;

    public static List<Point> pointsList = new ArrayList<Point>();

    private int min_distance = 100;

    public FingerLine(Context context) {
        this(context, null);
    }

    public FingerLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Style.STROKE);
        mPaint.setColor(Color.RED);
    }


    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(Config.startX, Config.startY, Config.endX, Config.endY, mPaint);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Config.startX = event.getX();
                Config.startY = event.getY();
              //  pointsList.add(new Point((int) event.getX(), (int) event.getY()));
                text1.setText("");
                text2.setText("");
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                Config.endX = event.getX();
                Config.endY = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                Config.endX = event.getX();
                Config.endY = event.getY();

               // float deltaX = Config.startX - Config.endX;
                float deltaY = Config.startY - Config.endY;

              //  if(Config.endY+Config.getTop>Config.getBottom) {

                //    Config.endY = Config.getBottom;
               // }
                if(Config.endX<0) {

                    Config.endX = 0;

                }

                if(Config.startY<0) {

                    Config.startY = 0;
                }
                if(Config.startY+Config.getTop>Config.getBottom) {

                    Config.startY = Config.getBottom;
                }

                if(Config.startX<0) {

                    Config.startX = Config.getLeft;
                }
                if(Config.endX+Config.getLeft>Config.getRight) {

                   Config.endX = Config.getRight- Config.getLeft;

                }

                if(Config.endX<0) {
                    Config.endX = Config.getLeft;
                }

                if(Config.startX+Config.getLeft>Config.getRight) {

                    Config.startX = Config.getRight;
                }

               // pointsList.add(new Point((int) event.getX(), (int) event.getY()));

                Log.i("Image1endx", String.valueOf(Config.endX));
                Log.i("Image1endy", String.valueOf(Config.endY));
                Log.i("Image1startx", String.valueOf(Config.startX));
                Log.i("Image1starty", String.valueOf(Config.startY));
                invalidate();

              /*  //HORIZONTAL SCROLL
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    if (Math.abs(deltaX) > min_distance) {
                        // left or right
                        if (deltaX < 0) {
                           // this.onLeftToRightSwipe();
                            Config.direction = "LR";
                        }
                        if (deltaX > 0) {
                            //this.onRightToLeftSwipe();
                            Config.direction = "RL";
                        }
                    } else {
                        //not long enough swipe...
                        Config.direction = "";
                    }
                }
                //VERTICAL SCROLL
                else {
                    if (Math.abs(deltaY) > min_distance) {
                        // top or down
                        if (deltaY < 0) {
                            // this.onTopToBottomSwipe();
                            Config.direction = "TB";
                        }
                        if (deltaY > 0) {
                            // this.onBottomToTopSwipe();
                            Config.direction = "BT";
                        }
                    } else {
                        //not long enough swipe...
                        Config.direction = "";
                    }
                }*/

                //calculateVolume();
                float y = calculate();

                Log.i("Image1", String.valueOf(y));
                Log.i("Image1Direc",Config.direction);
                break;
        }
        return true;
    }

    public float calculate() {

      /*  float YTop,YButtom,XLeft,XRight;

        if (Config.direction.equals("TB")) {

            if((Config.startX<Config.getLeft) && (Config.startY<Config.getTop)) {

            } else if((Config.startX>Config.getRight) && (Config.startY>=Config.getBottom)) {

            } else {

                YTop = Config.startY - Config.getTop;

                Config.startY = Config.startY - YTop;

                YButtom = Config.endY - Config.getBottom;

                Config.endY = Config.endY - YButtom;
            }

        } else if(Config.direction.equals("BT")) {

            YTop = Config.startY - Config.getBottom;

            Config.startY = Config.startY - YTop;

            YButtom = Config.endY - Config.getTop;

            Config.endY = Config.endY - YButtom;
        } else if (Config.direction.equals("LR")) {

            XLeft = Config.startX - Config.getLeft;

            Config.startX = Config.startX - XLeft;


            XRight = Config.endX - Config.getRight;

            Config.endX = Config.endX - XRight;


        } else if (Config.direction.equals("RL")) {

            XLeft = Config.startX - Config.getRight;

            Config.startX = Config.startX - XLeft;

            XRight = Config.endX - Config.getLeft;

            Config.endX = Config.endX - XRight;

        }*/

       /* if((Config.startX<Config.getLeft) && (Config.getBottom<Config.endY))  {

            float Xdata = Config.startY - Config.getTop;

            Config.startY = Config.startX - Xdata;

            float Ydata = Config.endY - Config.getBottom;

            Config.endY = Config.endY - Ydata;


        } else if((Config.startY>Config.getBottom) && (Config.endX<Config.getTop)) {

            float Xdata = Config.startX - Config.getBottom;

            Config.startY = Config.startX - Xdata;

            float Ydata = Config.endY - Config.getTop;

            Config.endY = Config.endY - Ydata;

        }*/

     //  if(Config.startX>Config.getLeft) {

        //   Xdata = Config.startY - Config.getBottom;

          //  Config.startY = Config.startY - Xdata;

         //  Ydata = Config.endY - Config.getTop;

        //    Config.endY = Config.endY - Ydata;

    /*   }  else if((Config.startX<Config.getBottom) && (Config.startX>Config.getTop) && (Config.startX<Config.getLeft)) {

           Xdata = Config.startX - Config.getLeft;

           Config.startX = Config.startX-Xdata;

           Ydata = Config.endY - Config.getRight;

           Config.endY = Config.endY - Ydata;


       } else if((Config.startX<Config.getBottom) && (Config.startX>Config.getTop) && (Config.startX>Config.getRight)) {

           Xdata = Config.startX - Config.getRight;

           Config.startX = Config.startX-Xdata;

           Xdata = Config.startY - Config.getBottom;

           Config.startY = Config.startY - Xdata;

           Ydata = Config.endY - Config.getLeft;

           Config.endY = Config.endY - Ydata;

           Ydata = Config.endX - Config.getLeft;

           Config.endX = Config.endX - Ydata;

       }else if((Config.startX<Config.getTop) && (Config.endY>Config.getBottom)) {

           Xdata =  Config.getTop - Config.startY;

           Config.startY = Config.startY + Xdata;

           Xdata = Config.getLeft - Config.startX;

           Config.startX = Config.startX+Xdata;

           Ydata = Config.endY - Config.getBottom;

           Config.endY = Config.endY - Ydata;

           Ydata = Config.endX - Config.getRight;

           Config.endX = Config.endX - Ydata;




       } else if(Config.startX>Config.getBottom) {

           Xdata = Config.startX - Config.getBottom;

           Config.startY = Config.startX - Xdata;

           Ydata = Config.endY - Config.getTop;

           Config.endY = Config.endY - Ydata;



       }*/

        pointsList.clear();

        pointsList.add(new Point((int) Config.getLeft, (int) Config.getTop));
        pointsList.add(new Point((int) Config.getRight, (int)Config.getTop));
        pointsList.add(new Point((int) Config.getLeft , (int) Config.getBottom));
        pointsList.add(new Point((int) Config.getRight, (int) Config.getBottom));

        area = 0;


        for (int i = 0; i < pointsList.size(); i++) {
            float addX = pointsList.get(i).x;
            float addY = pointsList.get(i == pointsList.size() - 1 ? 0 : i + 1).y;
            float subX = pointsList.get(i == pointsList.size() - 1 ? 0 : i + 1).x;
            float subY = pointsList.get(i).y;
            area = (float) (area+ (addX * addY * 0.5));
            area = (float) (area - (subX * subY * 0.5));
        }

        area = 40000;



        pointsList.clear();

        pointsList.add(new Point((int) Config.getLeft, (int) Config.getTop));
        pointsList.add(new Point((int) Config.getLeft, (int)Config.getBottom));
        pointsList.add(new Point((int) Config.startX+Config.getLeft, (int) Config.startY+Config.getTop));
        pointsList.add(new Point((int) Config.endX+Config.getLeft, (int) Config.endY+Config.getTop));

        total = 0;


        for (int i = 0; i < pointsList.size(); i++) {
            float addX = pointsList.get(i).x;
            float addY = pointsList.get(i == pointsList.size() - 1 ? 0 : i + 1).y;
            float subX = pointsList.get(i == pointsList.size() - 1 ? 0 : i + 1).x;
            float subY = pointsList.get(i).y;
            total = (float) (total+ (addX * addY * 0.5));
            total = (float) (total - (subX * subY * 0.5));
        }

       // total = total + pointsList.get(pointsList.size()-1).x * pointsList.get(0).y;
       // total = total - pointsList.get(0).x * pointsList.get(pointsList.size()-1).y;

        float data = (Math.abs(total)/area)*100;

        text1.setText(String.valueOf(data));
        text2.setText(String.valueOf((100-data)));

        Log.i("Image1Sizee", String.valueOf(data));

        pointsList.clear();

        return Math.abs(total);
    }

    private void calculateVolume() {

        if((Config.getLeft > Config.startX) && (Config.getRight<Config.endY)) {



        } else if((Config.startX>Config.getLeft) && (Config.endX>Config.getLeft) && (Config.startX<Config.getRight/2) && (Config.endX<Config.getRight/2)) {


            float Xdata = Config.startY - Config.getBottom;

            Config.startY = Config.startY - Xdata;

            float Ydata = Config.endY - Config.getTop;

            Config.endY = Config.endY - Ydata;

            Xdata = Config.endX - Config.getLeft;

            Xdata = Xdata*Xdata;


            float totalArea = 200*200;

            float multi1 = (Xdata/totalArea)*100;

          //  text1.setText(String.valueOf((int) (multi1)));

          //  text2.setText(String.valueOf((int) (100-multi1)));

            Log.i("Image1%", String.valueOf(multi1));

        } else if ((Config.startX>Config.getLeft) && (Config.endX>Config.getLeft) && (Config.startX>Config.getRight/2) && (Config.endX>Config.getRight/2)) {

            float Xdata = Config.startY - Config.getBottom;

            Config.startY = Config.startY - Xdata;

            float Ydata = Config.endY - Config.getTop;

            Config.endY = Config.endY - Ydata;

            Xdata = Config.getRight-Config.endX;

            Xdata = Xdata*Xdata;



            float totalArea = 200*200;

            float multi1 = (Xdata/totalArea)*100;

           // text1.setText(String.valueOf((int) (multi1)));

           // text1.setLayoutParams(layoutParams);

           // text2.setText(String.valueOf((int) (100-multi1)));

            Log.i("Image1%", String.valueOf(multi1));
        }

    }
}
