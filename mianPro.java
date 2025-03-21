import java.util.InputMismatchException;
import java.util.Scanner;

public class mianPro {
    public static void main(String[] args) {
        boolean boo=true;
        Profesor p=new Profesor();
        Scanner sc=new Scanner(System.in);

        Profesor p1=new Profesor("23478954P","1985-01-10","María López","600123456","Gran Vía","12",1);
        Profesor p2=new Profesor("27350978U","1978-05-23","Juan García","600234567","Paseo del prado","5B",2);
        Profesor p3=new Profesor("62354692E","1982-11-02","Lucía Pérez","600345678","Calle Alcalá","3A",3);
        Profesor p4=new Profesor("23810293B","1990-07-19","Pedro Sánchez","600456789","Avenida America","49",4);
        Profesor p5=new Profesor("12930865L","1987-03-29","Ana Martínez","600567890","Calle Serrano","8",5);
        p.addNewProfe(p1);
        p.addNewProfe(p2);
        p.addNewProfe(p3);
        p.addNewProfe(p4);
        p.addNewProfe(p5);
        do {
                p.menu();
                int opcion=sc.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("chau,adeu");
                        boo = false;
                        break;
                    case 1:
                        p.addNewProfe(p.insertarProfe());
                        break;
                    case 2:
                        if (p.profesores.isEmpty()){
                            System.out.println("No hay profesores en tu lista");
                        } else {
                            System.out.println("Introduce el nif del profesor que quieres eliminar");
                            String stutu=sc.next();
                            sc.nextLine();
                            if (p.queryProfe(stutu)!=null){
                                p.removeProfe(p.queryProfe(stutu));
                            } else {
                                System.out.println("El profesor con ese nif no esta en tu lista");
                            }
                        }
                        break;
                    case 3:
                        if (p.profesores.isEmpty()){
                            System.out.println("No hay profesores en tu lista");
                        } else {
                            System.out.println("Introduce el nif del profesor que quieres actualizar");
                            String nifo=sc.next();
                            sc.nextLine();
                            if (p.queryProfe(nifo)!=null){
                                p.updateProfe(p.queryProfe(nifo),p.insertarProfe());
                            } else {
                                System.out.println("El profesor con ese nif no esta en tu lista");
                            }
                        }
                        break;
                    case 4:
                        if (p.profesores.isEmpty()){
                            System.out.println("No hay profesores en tu lista");
                        } else {
                            System.out.println("Introduce el nif del profesor que quieres buscar");
                            String pp=sc.next();
                            sc.nextLine();
                            if (p.queryProfe(pp)!=null){
                                System.out.println(p.queryProfe(pp));
                            } else {
                                System.out.println("El profesor con ese nif no esta en tu lista");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("<profesores>");
                        p.printProfes();
                        System.out.println("</profesores>");
                        break;
                    default:
                        System.out.println("Introduce un numero valido");
                        sc.nextLine();
                }
        }while (boo);
    }
}

