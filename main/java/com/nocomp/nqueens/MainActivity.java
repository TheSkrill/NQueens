package com.nocomp.nqueens;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int tag,i,row,col,crown;
    int rowno,colno,r,c,newtag;
    String width;
    boolean gameIsActive = true;

    public void dropin(View view) {

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        ImageView counter = (ImageView) view;

        tag = Integer.parseInt(counter.getTag().toString());
        if(crown==3)
        {
            counter.setImageResource(R.drawable.crown);
            gameIsActive = false;

            LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
            layout.setVisibility(View.VISIBLE);
        }

        if(counter.isEnabled() && gameIsActive)
        {

            counter.setImageResource(R.drawable.crown);
            crown++;

            colno = tag % 10;
            rowno = tag / 10;

            Log.i("Row",Integer.toString(rowno));
            Log.i("Col", Integer.toString(colno));

            r = rowno*10;
            c = colno;
            //Disabling Rows
            for (i = 0; i <=3; i++) {

                newtag = r + (i);
                Log.i("Newtag_Row",Integer.toString(newtag));


                ImageView x = (ImageView) gridLayout.findViewWithTag(Integer.toString(newtag));
                x.setEnabled(false);
            }

            //Disabling Columns
            for(i=0;i<=3;i++)
            {
                newtag = (i*10) + c;
                Log.i("Newtag_Col",Integer.toString(newtag));

                ImageView x = (ImageView) gridLayout.findViewWithTag(Integer.toString(newtag));
                x.setEnabled(false);
            }

            //Disabling Diagonals
            row = rowno;
            col = colno;

            while(row!=-1 && col!=-1)
            {
                newtag = (row*10) +(col);
                Log.i("Cols",Integer.toString(newtag));

                ImageView x = (ImageView) gridLayout.findViewWithTag(Integer.toString(newtag));
                x.setEnabled(false);

                row--;
                col--;

            }
            row = rowno;
            col = colno;

            while(row<=3 && col<=3)
            {
                newtag = (row*10) +(col);
                Log.i("Cols",Integer.toString(newtag));

                ImageView x = (ImageView) gridLayout.findViewWithTag(Integer.toString(newtag));
                x.setEnabled(false);

                row++;
                col++;

            }

            row = rowno;
            col = colno;
            while(row!=-1 && col!=-1 && col<=3)
            {
                newtag = (row*10) +(col);
                Log.i("Cols",Integer.toString(newtag));

                ImageView x = (ImageView) gridLayout.findViewWithTag(Integer.toString(newtag));
                x.setEnabled(false);

                row--;
                col++;
            }

            row = rowno;
            col = colno;
            while(row!=-1 && col!=-1 && row<=3)
            {
                newtag = (row*10) +(col);
                Log.i("Cols",Integer.toString(newtag));

                ImageView x = (ImageView) gridLayout.findViewWithTag(Integer.toString(newtag));
                x.setEnabled(false);

                row++;
                col--;
            }

        }
        else if(!counter.isEnabled())
        {
            Toast.makeText(this, "CONFLICT", Toast.LENGTH_SHORT).show();
        }


      //gridLayout.findViewWithTag(newtag);

    }

    public void playAgain(View view)
    {
        gameIsActive = true;
        crown=0;

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        layout.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
            ((ImageView)gridLayout.getChildAt(i)).setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crown = 0;

        /*int i;
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(i=0;i<gridLayout.getChildCount();i++)
        {
            ((ImageView)gridLayout.getChildAt(i)).setEnabled(true);
        }*/
    }
}
