public class Profesor {
    String NIFProfe;
    String FechNaProfe;
    String NomComProfe;
    String TelProfe;
    String calle;
    String NumPostigo;
    int CodAsig;

    public Profesor(String NIFProfe, String fechNaProfe, String nomComProfe, String telProfe, String calle, String numPostigo, int codAsig) {
        this.NIFProfe = NIFProfe;
        FechNaProfe = fechNaProfe;
        NomComProfe = nomComProfe;
        TelProfe = telProfe;
        this.calle = calle;
        NumPostigo = numPostigo;
        CodAsig = codAsig;
    }

    public String getNIFProfe() {
        return NIFProfe;
    }

    public void validarNIFProfe(String NIFProfe) {
        if (NIFProfe.matches("\\d{7}\\w[A-Z]")){
            this.NIFProfe=NIFProfe;
            System.out.println("El NIF es correcto");
        } else {
            System.out.println("El NIF no es valido");
        }
    }

    public String getFechNaProfe() {
        return FechNaProfe;
    }

    public void validarFechNaProfe(String fechNaProfe) {

        if (fechNaProfe.matches("\\d{2}" + "/" + "\\d{2}" + "/" + "\\d{4}")) {
            String[] partido = fechNaProfe.split("/");
            int dia = Integer.parseInt(partido[0]);
            if (dia > 31 || dia <= 0) {
                System.out.println("El dia de la fecha no es correcto");
            } else {
                int mes = Integer.parseInt(partido[1]);
                if (mes > 12) {
                    System.out.println("El mes de la fecha no es correcto");
                } else {
                    int anyo = Integer.parseInt(partido[2]);
                    if (anyo > 2025 || anyo < 1930) {
                        System.out.println("El año de la fecha no es valido");
                    } else {
                        System.out.println("La fecha es correcta");
                    }
                }
            }
            }
        else {
            System.out.println("La fecha no es valida");
        }
    }

    public String getNomComProfe() {
        return NomComProfe;
    }

    public void validarNomComProfe(String nomComProfe) {
        if (nomComProfe.matches("\\w[A-Za-z]+"+" "+"\\w[A-Za-z]+")){
            this.NomComProfe=nomComProfe;
            System.out.println("El nombre es correcto");
        } else {
            System.out.println("El nombre no es valido");
        }
    }

    public String getTelProfe() {
        return TelProfe;
    }

    public void validfarTelProfe(String telProfe) {
        if (telProfe.matches("\\d{9}")){
            this.TelProfe=telProfe;
            System.out.println("El telefono es correcto");
        }else {
            System.out.println("El telefono no es valido");
        }
    }

    public String getCalle() {
        return calle;
    }

    public void validarCalle(String calle) {
        if (calle.matches("\\w[A-Za-z]+")){
            this.calle=calle;
            System.out.println("La calle es correcta");
        } else {
            System.out.println("La calle no es valida");
        }
    }

    public String getNumPostigo() {
        return NumPostigo;
    }

    public void validarNumPostigo(String numPostigo) {
        if (numPostigo.matches("\\d+\\w?")){
            this.NumPostigo=numPostigo;
            System.out.println("El numero de postigo es correcto");
        } else {
            System.out.println("El numero del postigo no es valido");
        }
    }

    public int getCodAsig() {
        return CodAsig;
    }

    public void validarCodAsig(int codAsig) {
        if (codAsig>0){
            this.CodAsig=codAsig;
            System.out.println("El codigo de la asignatura es correcto");
        } else {
            System.out.println("El codigo de la asignatura no es valido");
        }
    }
}
