package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {

    //atributos de cada objeto
    private int dia;
    private int mes;
    private int annio;
    private int diaSem;
    private String mesSt;
    private String fechaSt;
    private Date fechaDt;

    //atributos de la clase
    private static SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat FormatoFechaSt = new SimpleDateFormat("dd-MMMM-yyyy");
    private static SimpleDateFormat FormatoDia = new SimpleDateFormat("dd");
    private static SimpleDateFormat FormatoDiaSem = new SimpleDateFormat("u");
    private static SimpleDateFormat FormatoMes = new SimpleDateFormat("MM");
    private static SimpleDateFormat FormatoMesSt = new SimpleDateFormat("MMMM");
    private static SimpleDateFormat FormatoAnnio = new SimpleDateFormat("yyyy");
    

    //metodos de cada objeto
    public Fecha(int dia, int mes, int annio) throws ParseException {
        fechaDt = FormatoFecha.parse(dia + "-" + mes + "-" + annio);
    }

    public Fecha(int dia, String mesSt, int annio) throws ParseException {
        fechaDt = FormatoFechaSt.parse(dia + "-" + mesSt + "-" + annio);
    }
    
    public Fecha(Date dt){
        fechaDt = dt;
    }
    
    public Fecha(String dt) throws ParseException{
        fechaDt = FormatoFechaSt.parse(dt);
    }

    public int getDia() {
        dia = Integer.parseInt(FormatoDia.format(this.fechaDt));
        return dia;
    }

    public int getMes() {
        mes = Integer.parseInt(FormatoMes.format(this.fechaDt));
        return mes;
    }

    public String getMesSt() {
        mesSt = FormatoMesSt.format(this.fechaDt);
        return mesSt;
    }

    public int getAnnio() {
        annio = Integer.parseInt(FormatoAnnio.format(this.fechaDt));
        return annio;
    }

    public String getFechaSt(){
        fechaSt = FormatoFechaSt.format(this.fechaDt);
        return fechaSt;
    }
    
    public Date getFechaDt() {
        return fechaDt;
    }
    
    public int getDiaSemana(){
        diaSem = Integer.parseInt(FormatoDiaSem.format(this.fechaDt));
        return diaSem;
    }
    
    public Fecha sumarDias(Fecha fecha, int dias){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha.fechaDt);
        cal.add(Calendar.DAY_OF_YEAR, dias);
        return new Fecha(cal.getTime());
    }

}
