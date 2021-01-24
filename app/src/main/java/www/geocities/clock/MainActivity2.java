package www.geocities.clock;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity
{
    private Button button50;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button50 = (Button) findViewById(R.id.change2);

        button50.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity();
            }
        });

        final Handler handler=new Handler();
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                Calendar c = Calendar.getInstance();

                int hrs = c.get(Calendar.HOUR_OF_DAY);
                int mnts = c.get(Calendar.MINUTE);

                String time = String.format("%02d:%02d", hrs, mnts);
                TextView text = (TextView) findViewById(R.id.text);
                text.setText(time);

                String date = getMonth(c.get(Calendar.MONTH)) + " " + c.get(Calendar.DAY_OF_MONTH);
                TextView monthDay = (TextView) findViewById(R.id.monthDay);
                monthDay.setText(date);

                String week = getDayOfWeek(c.get(Calendar.DAY_OF_WEEK));;
                TextView weekDay = (TextView) findViewById(R.id.weekDay);
                weekDay.setText(week);

                String year = c.get(Calendar.YEAR) + "";
                TextView Year = (TextView) findViewById(R.id.year);
                Year.setText(year);

                handler.postDelayed(this,500);
            }
        });
    }

    public void openActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public String getMonth(int value)
    {
        String month = "";
        switch (value)
        {
            case 1:
                month = "JAN";
                break;
            case 2:
                month = "FEB";
                break;
            case 3:
                month = "MAR";
                break;
            case 4:
                month = "APR";
                break;
            case 5:
                month = "MAY";
                break;
            case 6:
                month = "JUNE";
                break;
            case 7:
                month = "JULY";
                break;
            case 8:
                month = "AUG";
                break;
            case 9:
                month = "SEPT";
                break;
            case 10:
                month = "OCT";
                break;
            case 11:
                month = "NOV";
                break;
            case 12:
                month = "DEC";
                break;
        }
        return month;
    }

    public String getDayOfWeek(int value)
    {
        String day = "";
        switch (value)
        {
            case 1:
                day = "SUNDAY";
                break;
            case 2:
                day = "MONDAY";
                break;
            case 3:
                day = "TUESDAY";
                break;
            case 4:
                day = "WEDNESDAY";
                break;
            case 5:
                day = "THURSDAY";
                break;
            case 6:
                day = "FRIDAY";
                break;
            case 7:
                day = "SATURDAY";
                break;
        }
        return day;
    }
}
