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
                    System.out.println("Inserta un nif para un profesor");
                    String nif = sc.next();
                    sc.nextLine();
                    if (!p.validarNIFProfe(nif)) {
                        do {
                            System.out.println("Inserta un nif valido");
                            nif = sc.next();
                        } while (!p.validarNIFProfe(nif));
                    }
                    System.out.println("Introduce el nombre profesor");
                    String nom = sc.next();
                    sc.nextLine();
                    System.out.println("Introduce el apellido de un profesor");
                    String ape=sc.next();
                    sc.nextLine();
                    String nomape=nom.concat(" "+ape);
                    if (!p.validarNomComProfe(nomape)) {
                        do {
                            System.out.println("Introduce el nombre profesor");
                            nom = sc.next();
                            sc.nextLine();
                            System.out.println("Introduce el apellido de un profesor");
                            ape=sc.next();
                            sc.nextLine();
                            nomape=nom.concat(" "+ape);
                        } while (!p.validarNomComProfe(nomape));
                    }
                    System.out.println("Introduce la fecha de nacimiento de un profesor(xx/xx/xxxx)");
                    String fecnaProfe = sc.next();
                    sc.nextLine();
                    if (!p.validarFechNaProfe(fecnaProfe)) {
                        do {
                            System.out.println("Introduce la fecha de nacimiento de un profesor(xx/xx/xxxx)");
                            fecnaProfe = sc.next();
                            sc.nextLine();
                        } while (!p.validarFechNaProfe(fecnaProfe));
                    }
                        System.out.println("Introduce un telefono para un profesor");
                        String tel = sc.next();
                        sc.nextLine();
                        if (!p.validfarTelProfe(tel)) {
                            do {
                                System.out.println("Introduce un telefono para un profesor");
                                tel = sc.next();
                                sc.nextLine();
                            } while (!p.validfarTelProfe(tel));
                        }
                        System.out.println("Introduce una calle para un profesor");
                        String calle = sc.next();
                        sc.nextLine();
                        if (!p.validarCalle(calle)) {
                            do {
                                System.out.println("Introduce un calle para un profesor");
                                calle = sc.next();
                                sc.nextLine();
                            } while (!p.validarCalle(calle));
                        }
                        System.out.println("Introduce un numero de postigo para un profesor");
                        String numpos = sc.next();
                        sc.nextLine();
                        if (!p.validarNumPostigo(numpos)) {
                            do {
                                System.out.println("Introduce un numero de postigo para un profesor");
                                numpos = sc.next();
                                sc.nextLine();
                            } while (!p.validarNumPostigo(numpos));
                        }
                        System.out.println("Introduce un codigo de asignatura para un profesor");
                        int codas = sc.nextInt();
                        sc.nextLine();
                        if (!p.validarCodAsig(codas)) {
                            do {
                                System.out.println("Introduce un codigo de asignatura para un profesor");
                                codas = sc.nextInt();
                                sc.nextLine();
                            } while (!p.validarCodAsig(codas));
                        }
                        Profesor pepe = new Profesor(nif, fecnaProfe, nomape, tel, calle, numpos, codas);
                        p.addNewProfe(pepe);
                        break;
                case 2:
                    System.out.println("Introduce el nif del profesor que quieres eliminar");
                    String stutu=sc.next();
                    sc.nextLine();
                    if (p.queryProfe(stutu)!=null){
                        p.removeProfe(p.queryProfe(stutu));
                    } else {
                        System.out.println("El profesor con ese nif no esta en tu lista");
                    }
                    break;
                case 3:
                    System.out.println("Introduce el nif del profesor que quieres actualizar");
                    String nifo=sc.next();
                    sc.nextLine();
                    if (p.queryProfe(nifo)!=null){
                        p.removeProfe(p.queryProfe(nifo));
                        System.out.println("Inserta un nif para un profesor");
                        String nifi = sc.next();
                        sc.nextLine();
                        if (!p.validarNIFProfe(nifi)) {
                            do {
                                System.out.println("Inserta un nif valido");
                                nifi = sc.next();
                            } while (!p.validarNIFProfe(nifi));
                        }
                        System.out.println("Introduce el nombre profesor");
                        String nomo = sc.next();
                        sc.nextLine();
                        System.out.println("Introduce el apellido de un profesor");
                        String apeo=sc.next();
                        sc.nextLine();
                        String nomapeo=nomo.concat(" "+apeo);
                        if (!p.validarNomComProfe(nomapeo)) {
                            do {
                                System.out.println("Introduce el nombre profesor");
                                nomo = sc.next();
                                sc.nextLine();
                                System.out.println("Introduce el apellido de un profesor");
                                apeo=sc.next();
                                sc.nextLine();
                                nomapeo=nomo.concat(" "+apeo);
                            } while (!p.validarNomComProfe(nomapeo));
                        }
                        System.out.println("Introduce la fecha de nacimiento de un profesor(xx/xx/xxxx)");
                        String fecnaProfeo = sc.next();
                        sc.nextLine();
                        if (!p.validarFechNaProfe(fecnaProfeo)) {
                            do {
                                System.out.println("Introduce la fecha de nacimiento de un profesor(xx/xx/xxxx)");
                                fecnaProfeo = sc.next();
                                sc.nextLine();
                            } while (!p.validarFechNaProfe(fecnaProfeo));
                        }
                        System.out.println("Introduce un telefono para un profesor");
                        String telo = sc.next();
                        sc.nextLine();
                        if (!p.validfarTelProfe(telo)) {
                            do {
                                System.out.println("Introduce un telefono para un profesor");
                                telo = sc.next();
                                sc.nextLine();
                            } while (!p.validfarTelProfe(telo));
                        }
                        System.out.println("Introduce una calle para un profesor");
                        String calleo = sc.next();
                        sc.nextLine();
                        if (!p.validarCalle(calleo)) {
                            do {
                                System.out.println("Introduce un calle para un profesor");
                                calleo = sc.next();
                                sc.nextLine();
                            } while (!p.validarCalle(calleo));
                        }
                        System.out.println("Introduce un numero de postigo para un profesor");
                        String numposo = sc.next();
                        sc.nextLine();
                        if (!p.validarNumPostigo(numposo)) {
                            do {
                                System.out.println("Introduce un numero de postigo para un profesor");
                                numposo = sc.next();
                                sc.nextLine();
                            } while (!p.validarNumPostigo(numposo));
                        }
                        System.out.println("Introduce un codigo de asignatura para un profesor");
                        int codaso = sc.nextInt();
                        sc.nextLine();
                        if (!p.validarCodAsig(codaso)) {
                            do {
                                System.out.println("Introduce un codigo de asignatura para un profesor");
                                codaso = sc.nextInt();
                                sc.nextLine();
                            } while (!p.validarCodAsig(codaso));
                        }
                        Profesor pepeo = new Profesor(nifo, fecnaProfeo, nomapeo, telo, calleo, numposo, codaso);
                        p.addNewProfe(pepeo);
                    } else {
                        System.out.println("El profesor con ese nif no esta en tu lista");
                    }
                    break;
                case 4:
                    System.out.println("Introduce el nif del profesor que quieres eliminar");
                    String pp=sc.next();
                    sc.nextLine();
                    if (p.queryProfe(pp)!=null){
                        System.out.println(p.queryProfe(pp));
                    } else {
                        System.out.println("El profesor con ese nif no esta en tu lista");
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

