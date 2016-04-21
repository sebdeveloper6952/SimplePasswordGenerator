package sebasarriola.simplepasswordgenerator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.CheckBox;
import android.widget.EditText;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the toolbar
        Toolbar myToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // crear fuente de texto chilera
        final Typeface face = Typeface.createFromAsset(getAssets(), "fonts/8bitOperatorPlus-Regular.ttf");

        // textview de longitud
        TextView textoLongitud = (TextView)findViewById(R.id.textoLongitud);
        textoLongitud.setTypeface(face);

        // crear objeto Generator
        final Generator gen = new Generator(0);

        // crear boton de generar
        Button botonGenerar = (Button)findViewById(R.id.botonGenerar);
        botonGenerar.setTypeface(face);

        // crear boton de guardar
        Button botonGuardar = (Button)findViewById(R.id.botonGuardar);
        botonGuardar.setTypeface(face);

        // crear la barra que sirve para especificar la longitud de clave
        final SeekBar barraLongitud = (SeekBar)findViewById(R.id.barraLongitud);


        // creara la pantalla donde se visualiza el valor de la longitud
        final TextView pantallaLongitud = (TextView)findViewById(R.id.pantallaLongitud);
        // iniciar el valor de la pantalla de longitud
        pantallaLongitud.setText(Integer.toString(barraLongitud.getProgress()));

        // crear event listeners para checkboxes
        final CheckBox numCheckbox = (CheckBox)findViewById(R.id.numCheckbox);
        final CheckBox simCheckbox = (CheckBox)findViewById(R.id.simCheckbox);


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
        botonGenerar.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView outputScreen = (TextView)findViewById(R.id.pantallaClave);
                        outputScreen.setTypeface(face);
                        outputScreen.setText(gen.GenerarClave(barraLongitud.getProgress() + 8, numCheckbox.isChecked(), simCheckbox.isChecked()));
                    }
                }
        );

    }
}
