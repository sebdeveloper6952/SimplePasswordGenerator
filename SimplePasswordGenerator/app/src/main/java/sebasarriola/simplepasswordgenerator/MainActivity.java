package sebasarriola.simplepasswordgenerator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.EditText;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // crear fuente de texto chilera
        final Typeface face = Typeface.createFromAsset(getAssets(), "fonts/8bitOperatorPlus-Regular.ttf");

        // textview de longitud
        TextView textoLongitud = (TextView)findViewById(R.id.textoLongitud);
        textoLongitud.setTypeface(face);

        // crear objeto Generator
        final Generator gen = new Generator(0);

        // crear boton de generar
        Button generateButton = (Button)findViewById(R.id.botonGenerar);
        generateButton.setTypeface(face);

        // crear la barra que sirve para especificar la longitud de clave
        final SeekBar barraLongitud = (SeekBar)findViewById(R.id.barraLongitud);

        // creara la pantalla donde se visualiza el valor de la longitud
        final TextView pantallaLongitud = (TextView)findViewById(R.id.pantallaLongitud);

        // iniciar el valor de la pantalla de longitud
        pantallaLongitud.setText(Integer.toString(barraLongitud.getProgress()));

        // crear event listener para que la barra de longitud actualice su valor en la pantalla de longitud
        barraLongitud.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener()
                {
                    int progress = 0;
                    public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser)
                    {
                        progress = progresValue + 8;
                        pantallaLongitud.setText(Integer.toString(barraLongitud.getProgress() + 8));
                    }
                    public void onStartTrackingTouch(SeekBar seekBar)
                    {
                        // metodo necesario
                    }
                    public void onStopTrackingTouch(SeekBar seekBar)
                    {
                        // metodo necesario
                    }
                }
        );


        // crear event listener para el click en el boton de generar
        generateButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView outputScreen = (TextView)findViewById(R.id.pantallaClave);
                        outputScreen.setTypeface(face);
                        outputScreen.setText(gen.GenerarClave(barraLongitud.getProgress() + 8));
                    }
                }
        );
    }
}
