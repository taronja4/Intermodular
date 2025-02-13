import java.util.ArrayList;
import java.util.Scanner;

public class Profesor {
    String NIFProfe;
    String FechNaProfe;
    String NomComProfe;
    String TelProfe;
    String calle;
    String NumPostigo;
    int CodAsig;
    ArrayList<Profesor> profesores=new ArrayList<>();


    public Profesor(){

    }
    public Profesor(String NIFProfe, String fechNaProfe, String nomComProfe, String telProfe, String calle, String numPostigo, int codAsig) {
        this.NIFProfe = NIFProfe;
        FechNaProfe = fechNaProfe;
        NomComProfe = nomComProfe;
        TelProfe = telProfe;
        this.calle = calle;
        NumPostigo = numPostigo;
        CodAsig = codAsig;
    }

    public void menu(){
        System.out.println("0. salir");
        System.out.println("1. añadir nuevo profesor");
        System.out.println("2. eliminar profesor");
        System.out.println("3. Actualizar profesor");
        System.out.println("4. Buscar profe por nif");
        System.out.println("5 imprimir lista de profesores");
    }

    private int findProfe(Profesor po){
        if (profesores.contains(po)){
            return profesores.indexOf(po);
        }
        return -1;
    }

    private int findProfe(String nifProfe){
        if (profesores.equals(nifProfe)){
            return 1;
        }
        return -1;
    }

    public boolean addNewProfe(Profesor pro){
        if (findProfe(pro)<=0){
            profesores.add(pro);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateProfe(Profesor antiguo,Profesor nuevo){
        if (findProfe(antiguo)>=0){
            if (findProfe(nuevo)<=0){
                profesores.remove(antiguo);
                profesores.add(nuevo);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean removeProfe(Profesor poo){
        if (findProfe(poo)>=0){
            profesores.remove(poo);
            return true;
        } else {
            return false;
        }
    }

    public Profesor queryProfe(String nif){
        for (Profesor co:profesores){
            if (nif.equals(co.getNIFProfe())){
                return co;
            }
        }
        return null;
    }

    public void printProfes(){
        int cont=1;
        System.out.println("Lista de profesores");
        for (Profesor pro:profesores){
            System.out.println(cont+" "+pro);
        }
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "NIFProfe='" + NIFProfe + '\'' +
                ", FechNaProfe='" + FechNaProfe + '\'' +
                ", NomComProfe='" + NomComProfe + '\'' +
                ", TelProfe='" + TelProfe + '\'' +
                ", calle='" + calle + '\'' +
                ", NumPostigo='" + NumPostigo + '\'' +
                ", CodAsig=" + CodAsig +
                '}';
    }

    public String getNIFProfe() {
        return NIFProfe;
    }

    public boolean validarNIFProfe(String NIFProfe) {
        if (NIFProfe.matches("\\d{7}\\w[A-Z]")){
            this.NIFProfe=NIFProfe;
            return true;
        } else {
            return false;
        }
    }

    public String getFechNaProfe() {
        return FechNaProfe;
    }

    public boolean validarFechNaProfe(String fechNaProfe) {

        if (fechNaProfe.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}")) {
            String[] partido = fechNaProfe.split("/");
            int dia = Integer.parseInt(partido[0]);
            if (dia > 31 || dia <= 0) {
                return false;
            } else {
                int mes = Integer.parseInt(partido[1]);
                if (mes > 12) {
                   return false;
                } else {
                    int anyo = Integer.parseInt(partido[2]);
                    if (anyo > 2025 || anyo < 1930) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
            }
        else {
            return false;
        }
    }

    public String getNomComProfe() {
        return NomComProfe;
    }

    public boolean validarNomComProfe(String nomComProfe) {
        if (nomComProfe.matches("\\w[A-Za-z]+"+" "+"\\w[A-Za-z]+")){
            this.NomComProfe=nomComProfe;
            return true;
        } else {
            return false;
        }
    }

    public String getTelProfe() {
        return TelProfe;
    }

    public boolean validfarTelProfe(String telProfe) {
        if (telProfe.matches("\\d{9}")){
            this.TelProfe=telProfe;
            return true;
        }else {
            return false;
        }
    }

    public String getCalle() {
        return calle;
    }

    public boolean validarCalle(String calle) {
        if (calle.matches("\\w[A-Za-z]+")){
            this.calle=calle;
           return true;
        } else {
            return false;
        }
    }

    public String getNumPostigo() {
        return NumPostigo;
    }

    public boolean validarNumPostigo(String numPostigo) {
        if (numPostigo.matches("\\d+\\w?")){
            this.NumPostigo=numPostigo;
            return true;
        } else {
            return false;
        }
    }

    public int getCodAsig() {
        return CodAsig;
    }

    public boolean validarCodAsig(int codAsig) {
        if (codAsig>0){
            this.CodAsig=codAsig;
            return true;
        } else {
            return false;
        }
    }
}
