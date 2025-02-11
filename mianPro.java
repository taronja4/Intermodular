public class mianPro {
    public static void main(String[] args) {

        Profesor calvo=new Profesor("12345678P","31/02/2012","ckyutdyhbvjk","123456789","palr8ano","12E",23);
        calvo.validarNIFProfe(calvo.NIFProfe);
        calvo.validarNomComProfe(calvo.NomComProfe);
        calvo.validfarTelProfe(calvo.TelProfe);
        calvo.validarCalle(calvo.calle);
        calvo.validarNumPostigo(calvo.NumPostigo);
        calvo.validarCodAsig(calvo.CodAsig);
        calvo.validarFechNaProfe(calvo.FechNaProfe);

    }
}
