import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
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
        System.out.println("5 imprimir lista de profesores en formato xml en un archivo de texto");
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
        try {
            PrintStream xd=new PrintStream("C:/Users/adria/OneDrive/Escritorio/profes/profes.txt");
            xd.println("<profesores>");
            for (Profesor p:profesores){
                Class<?> c=p.getClass();
                xd.println("  <profesor>");
                for (int i=0;i<c.getDeclaredFields().length-1;i++) {
                    xd.println("\t"+ "   <"+c.getDeclaredFields()[i].getName()+ ">"+c.getDeclaredFields()[i].get(p)+"</"+c.getDeclaredFields()[i].getName()+">");
                }
                xd.println("  </profesor>");
            }
            xd.println("</profesores>");
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    @Override
    public String toString() {
        return "   <profesor>"+'\n'+
                "          <nifProfe>"+NIFProfe+"</nifProfe>"+'\n'+
                "          <FechNaProfe>"+FechNaProfe+"</FechNaProfe>"+'\n'+
                "          <nomComProfe>"+NomComProfe+"</nomComProfe>"+'\n'+
                "          <TelProfe>"+TelProfe+"</TelProfe>"+'\n'+
                "          <Calle>"+calle+"</Calle>"+'\n'+
                "          <NumPostigo>"+NumPostigo+"</NumPostigo>"+'\n'+
                "          <CodAsig>"+CodAsig+"</CodAsig>"+'\n'+
                "  </profesor>";
    }

    public String getNIFProfe() {
        return NIFProfe;
    }

    public boolean validarNIFProfe(String NIFProfe) {
        if (NIFProfe.matches("\\d{7}\\w[A-Za-z]")){
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
        if (nomComProfe.isEmpty()){
            System.out.println("El nombre no puede estar vacio");
            return false;
        }
        for (char d:nomComProfe.toCharArray()){
            if (!Character.isLetter(d)&& d!=' '){
                System.out.println("Error, el nombre solo puede tener letras y espacios");
                return false;
            }
        }
        return true;
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
        if (calle.isEmpty()){
            System.out.println("La calle no puede estar vacia");
            return false;
        }
        for (char d:calle.toCharArray()){
            if (!Character.isLetter(d)&& d!=' '){
                System.out.println("Error, la calle solo puede tener letras y espacios");
                return false;
            }
        }
        return true;
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
        String pasado=String.valueOf(codAsig);
        if (pasado.matches("\\d+")){
            this.CodAsig=codAsig;
            return true;
        } else {
            return false;
        }

    }

    public Profesor insertarProfe(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Inserta un nif para un profesor(8 digitos y una letra[A-Z])");
        String nif = sc.nextLine();
        if (!validarNIFProfe(nif)) {
            do {
                System.out.println("Inserta un nif valido(8 digitos y una letra[A-Z])");
                nif = sc.nextLine();
            } while (!validarNIFProfe(nif));
        }
        for (Profesor profesor:profesores){
            if (Objects.equals(nif, profesor.NIFProfe)){
                do {
                    System.out.println("Inserta un nif valido o que no este en tu lista");
                    nif=sc.nextLine();
                }while (Objects.equals(nif, profesor.NIFProfe)||!validarNIFProfe(nif));
            }
        }
        System.out.println("Introduce el nombre profesor(Solo letras)");
        String nom = sc.nextLine();
        if (!validarNomComProfe(nom)) {
            do {
                System.out.println("Introduce el nombre profesor(Solo letras)");
                nom = sc.nextLine();
            } while (!validarNomComProfe(nom));
        }
        System.out.println("Introduce la fecha de nacimiento de un profesor(xx/xx/xxxx)");
        String fecnaProfe = sc.nextLine();
        if (!validarFechNaProfe(fecnaProfe)) {
            do {
                System.out.println("Introduce la fecha de nacimiento de un profesor(xx/xx/xxxx)");
                fecnaProfe = sc.nextLine();
            } while (!validarFechNaProfe(fecnaProfe));
        }
        System.out.println("Introduce un telefono para un profesor(9 digitos)");
        String tel = sc.nextLine();
        if (!validfarTelProfe(tel)) {
            do {
                System.out.println("Introduce un telefono para un profesor(9 digitos)");
                tel = sc.nextLine();
            } while (!validfarTelProfe(tel));
        }
        System.out.println("Introduce una calle para un profesor(Solo letras)");
        String calle = sc.nextLine();
        if (!validarCalle(calle)) {
            do {
                System.out.println("Introduce un calle para un profesor(Solo letras)");
                calle = sc.nextLine();
            } while (!validarCalle(calle));
        }
        System.out.println("Introduce un numero de postigo para un profesor(numeros y una letra como maximo)");
        String numpos = sc.nextLine();
        if (!validarNumPostigo(numpos)) {
            do {
                System.out.println("Introduce un numero de postigo para un profesor(numeros y una letra como maximo)");
                numpos = sc.nextLine();
            } while (!validarNumPostigo(numpos));
        }
        int codas2=0;
        boolean boo=true;
        do {
            try{
                System.out.println("Introduce un codigo de asignatura para un profesor(solo digitos)");
                codas2 = sc.nextInt();
                sc.nextLine();
                boo=false;
            }catch (InputMismatchException e){
                System.out.println("error");
                sc.nextLine();
            }
        } while (boo);


        Profesor pepe = new Profesor(nif, fecnaProfe, nom, tel, calle, numpos, codas2);
        return pepe;

    }

}
