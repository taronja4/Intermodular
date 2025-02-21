import java.util.InputMismatchException;
import java.util.Scanner;

public class mianPro {
    public static void main(String[] args) {
        boolean boo=true;
        Profesor p=new Profesor();
        Scanner sc=new Scanner(System.in);
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
                        p.printProfes();
                        break;
                    default:
                        System.out.println("Introduce un numero valido");
                        sc.nextLine();
                }
        }while (boo);
    }
}
