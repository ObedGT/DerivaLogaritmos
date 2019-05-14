package e.proyecto.derivalogaritmos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView lblOp;
    private TextView lblExponente;
    private TextView lblExponente2;
    private String contenido;
    private int signos=0; //Determina que operacion se esta usando
    private int espacio=0;
    private int llenaEspacio=0;
    private int xlog=0;
    private int lognepe=0;
    private boolean exp=false;


    private Button btnSuma;
    private Button btnResta;
    private ImageButton btnIgual;
    private ImageButton btnBorrar;
    private Button btnX;
    private Button btnLog;
    private Button btnLn;
    private Button btnBorrarTodo;

    private ImageButton cero;
    private ImageButton uno;
    private ImageButton dos;
    private ImageButton tres;
    private ImageButton cuatro;
    private ImageButton cinco;
    private ImageButton seis;
    private ImageButton siete;
    private ImageButton ocho;
    private ImageButton nueve;
    private Button parentesis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conversion de variables
        lblOp = (TextView) findViewById(R.id.lblOperacion);
        lblExponente = (TextView) findViewById(R.id.lblExponente);
        lblExponente2 = (TextView) findViewById(R.id.lblExponente2);
        btnSuma = (Button) findViewById (R.id.btnSuma);
        btnResta = (Button) findViewById (R.id.btnResta);
        btnIgual = (ImageButton) findViewById (R.id.btnIgual);
        btnBorrar = (ImageButton) findViewById (R.id.btnBorrar);
        btnBorrarTodo = (Button) findViewById (R.id.btnBorrarTodo);
        btnX = (Button) findViewById (R.id.btnX);
        btnLog = (Button) findViewById (R.id.btnLog);
        btnLn = (Button) findViewById (R.id.btnLn);

        cero= (ImageButton) findViewById (R.id.cero);
        uno= (ImageButton) findViewById (R.id.uno);
        dos= (ImageButton) findViewById (R.id.dos);
        tres= (ImageButton) findViewById (R.id.tres);
        cuatro= (ImageButton) findViewById (R.id.cuatro);
        cinco= (ImageButton) findViewById (R.id.cinco);
        seis= (ImageButton) findViewById (R.id.seis);
        siete= (ImageButton) findViewById (R.id.siete);
        ocho= (ImageButton) findViewById (R.id.ocho);
        nueve= (ImageButton) findViewById (R.id.nueve);
        parentesis = (Button) findViewById (R.id.parentesis);

        //Definiendoles action listener, accion al tocarlas
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnBorrarTodo.setOnClickListener(this);
        btnX.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnLn.setOnClickListener(this);


        cero.setOnClickListener(this);
        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        siete.setOnClickListener(this);
        ocho.setOnClickListener(this);
        nueve.setOnClickListener(this);
        parentesis.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnSuma) {
            signos++;
            espacio+=3;
            lblOp.setText(lblOp.getText() + "+");
        }

        if (id == R.id.btnResta) {
            signos++;
            espacio+=3;
            lblOp.setText(lblOp.getText() + "-");
        }

        if (id == R.id.btnX) {
            if(exp){
                exp=false;
                espacio+=llenaEspacio;
                llenaEspacio=0;
                xlog=0;
                truefalse(1);

            }
            else{
                lblOp.setText(lblOp.getText() + "x");
                if (lognepe==1) espacio+=2;
                else espacio+=3;
                exp=true;
                xlog=1;
                btnLog.setEnabled(false);
                truefalse(2);
            }

        }

        if (id == R.id.btnLog) {
            if(exp){
                exp=false;
                espacio+=llenaEspacio;
                llenaEspacio=0;
                xlog=0;
                lblOp.setText(lblOp.getText() + "(");
                espacio+=3;
                truefalse(1);

            }
            else{
                lblOp.setText(lblOp.getText() + "Log");
                espacio+=10;
                lognepe=1;
                exp=true;
                xlog=2;
                btnX.setEnabled(false);
                truefalse(2);
            }
        }
        if (id == R.id.btnLn) {
            lblOp.setText(lblOp.getText() + "Ln(");
            espacio+=9;
            lognepe=2;
        }


        /*if(id == R.id.btnBorrar){
            contenido = (String) lblOp.getText();
            if (contenido.length()!=0){
                contenido=contenido.substring(0, contenido.length() - 1);
                lblOp.setText(contenido);
                try{
                    int prueba = Integer.valueOf(contenido); //si se borró un signo, el numero se podra convertir
                    signos =0;                                //en entero, entonces signo = 0 porque no hay signo
                }
                catch(NumberFormatException Error){
                }
            }
        }*/


        if (id == R.id.btnBorrarTodo) {
            lblOp.setText("");
            lblExponente.setText("");
            lblExponente2.setText("");
            espacio=0;
            signos = 0;
            xlog=0;
            lognepe=0;
            truefalse(1);
            btnLog.setEnabled(true);
            btnLn.setEnabled(true);

        }
//es para escribir los numeros y el punto
        if (id == R.id.cero) {
            if (exp) operacion(0);
            else{
                lblOp.setText(lblOp.getText() + "0");
                espacio+=3;
            }
        }
        if (id == R.id.uno) {
            if (exp) operacion(1);
            else{
                lblOp.setText(lblOp.getText() + "1");
                espacio+=3;
            }
        }
        if (id == R.id.dos) {
            if (exp) operacion(2);
            else{
                lblOp.setText(lblOp.getText() + "2");
                espacio+=3;
            }
        }
        if (id == R.id.tres) {
            if (exp) operacion(3);
            else{
                lblOp.setText(lblOp.getText() + "3");
                espacio+=3;
            }
        }
        if (id == R.id.cuatro) {
            if (exp) operacion(4);
            else{
                lblOp.setText(lblOp.getText() + "4");
                espacio+=3;
            }
        }
        if (id == R.id.cinco) {
            if (exp) operacion(5);
            else{
                lblOp.setText(lblOp.getText() + "5");
                espacio+=3;
            }
        }
        if (id == R.id.seis) {
            if (exp) operacion(6);
            else{
                lblOp.setText(lblOp.getText() + "6");
                espacio+=3;
            }
        }
        if (id == R.id.siete) {
            if (exp) operacion(7);
            else{
                lblOp.setText(lblOp.getText() + "7");
                espacio+=3;
            }
        }
        if (id == R.id.ocho) {
            if (exp) operacion(8);
            else{
                lblOp.setText(lblOp.getText() + "8");
                espacio+=3;
            }
        }
        if (id == R.id.nueve) {
            if (exp) operacion(9);
            else{
                lblOp.setText(lblOp.getText() + "9");
                espacio+=3;
            }
        }

        if (id == R.id.parentesis) {
            lblOp.setText(lblOp.getText() + ")");
        }



        if(id == R.id.btnIgual) {
            lblOp.setText("Te la kreiste weee xdxd");
            Toast msjError = Toast.makeText(getApplicationContext(), "Te la kreiste weee xdxd x2", Toast.LENGTH_SHORT);
        }
        /*
            double respuesta=0;
            contenido = (String) lblOp.getText();
            try {
                if (signo == 1) {
                    String[] cadena = contenido.split("\\+");
                    respuesta = Double.parseDouble(cadena[0]) + Double.parseDouble(cadena[1]);
                } else if (signo == 2) {
                    String[] cadena = contenido.split("-");
                    respuesta = Double.parseDouble(cadena[0]) - Double.parseDouble(cadena[1]);
                }
                lblOp.setText(Double.toString(respuesta));
                signo=0;
            }
            catch(Exception e){
                lblOp.setText("");
                Toast msjError = Toast.makeText(getApplicationContext(), "Syntax Error", Toast.LENGTH_SHORT);
                msjError.setGravity(Gravity.CENTER, 0, 0);
                msjError.show();
                signo =0;
            }

            contenido = (String) lblOp.getText();
            int pasatiempo = 1+1;
        }*/
    }

    void operacion (int num){
        lblOp.setText(lblOp.getText()+" ");
        llenaEspacio+=2;
        if (xlog ==1){
            lblExponente.setText(lblExponente.getText()+espacioExponentes(lblExponente.length()));
            lblExponente.setText(lblExponente.getText()+""+num);
        }
        else if (xlog ==2){
            lblExponente2.setText(lblExponente2.getText()+espacioExponentes(lblExponente2.length()));
            lblExponente2.setText(lblExponente2.getText()+""+num);
        }
    }

    String espacioExponentes(int lblength){
        String texto="";
        int space = espacio-lblength;
        for (int i=0; i<=space; i++){
            texto=texto+" ";
        }
        return texto;
    }

    void truefalse (int vf){
        if (vf==1){
            btnResta.setEnabled(true);
            btnSuma.setEnabled(true);
            btnX.setEnabled(true);
            parentesis.setEnabled(true);
        }
        else{
            btnResta.setEnabled(false);
            btnSuma.setEnabled(false);
            btnLn.setEnabled(false);
            parentesis.setEnabled(false);
        }

    }
}
