package sebasarriola.simplepasswordgenerator;

/**
 * Created by gaming on 4/16/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashScreen extends Activity {

    private static int splashScreenTimer = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/8bitOperatorPlus-Regular.ttf");
        TextView textoSplash = (TextView)findViewById(R.id.textoSplash);
        textoSplash.setTypeface(face);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, splashScreenTimer);
    }
}
