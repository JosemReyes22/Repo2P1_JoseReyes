/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repo2p1_josereyes;

/**
 *
 * @author josem
 */
import java.util.Random;
import java.util.Scanner;
public class Repo2P1_JoseReyes {

    /**
     * @param args the command line arguments
     */
    static Scanner r = new Scanner(System.in);
        static Random ran = new Random();
        static int opt=0;
    public static void main(String[] args) {
        // TODO code application logic here
        //El static otp lo use para 1ue cuando genere una matriz dependiendo de la opcion elegida en el menu lo llene de 0 a 100 o de 0 9
        int menu=1;
        while(menu==1){
            System.out.println("\nMenu Principal");
            System.out.println("1.Turing\n2.Numero Magico\n3.Arreglo mayor\n4.Salir");
            int op=r.nextInt();
            switch(op){
                case 1:{
                    System.out.println("Ingrese el tamano del arreglo");
                    int tam= r.nextInt();
                    Turing turing= new Turing(tam);
                    imprimir3(turing.getarreglo());
                    System.out.println("Ingrese instrucciones ejemplo rxlxxlrx");
                    String instu=r.next().toUpperCase();
                    int[] matriz=turing.Instructiones(instu);
                    System.out.println(imprimir(matriz));
                }break;
                case 3:{
                    System.out.print("Ingrese M:");
                    int M= r.nextInt();
                    System.out.print("Ingrese N:");
                    int N= r.nextInt();
                    opt=1;
                    int[][]MatrizFinal=llenado(M,N);
                    System.out.println("Matriz Generada:\n"+imprimir(MatrizFinal));
                    int[]mayor=ArregloMayor(MatrizFinal);
                    imprimir2(mayor);
                }break;
                case 2:{
                    System.out.print("Ingrese M:");
                    int M= r.nextInt();
                    System.out.print("Ingrese N:");
                    int N= r.nextInt();
                    int[][]MatrizFinal=llenado(M,N);
                    int total = sumMultMatriz(MatrizFinal);
                    System.out.println("Total: "+total);
                    System.out.println("Matriz Generada:\n"+imprimir(MatrizFinal));
                }break;
                case 4:{
                    menu=0;
                    System.out.println("---Programa finalizado---");
                }break;
                default:
                    System.out.println("Opcion no valida...");
            }
        }
    }// hice tres metodos el de imprimir, generador de matriz y la del ejecicio suma mult y el retorno
    public static int sumMultMatriz(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int exteriorSum = 0;
        int interiorMul = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m-1 || j == n-1) {
                    exteriorSum += matrix[i][j];
                } else {
                    interiorMul *= matrix[i][j];
                }
            }
        }
        System.out.println("Suma: "+exteriorSum);
        System.out.println("Multiplicacion: "+interiorMul);
        return exteriorSum + interiorMul;
    }
    public static int[][] llenado(int filas,int columnas){
        int[][]temp=new int[filas][columnas];
        if(opt==1){
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    temp[i][j]=1+ran.nextInt(99);
                }
            }
            opt=0;
        }else{
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    temp[i][j]=ran.nextInt(9);
                }
            }
        }
        return temp;
    }
    public static String imprimir(int matriz [][]){
        String matri="";
        for (int i = 0; i < matriz.length; i++) {
            for (int j=0;j<matriz[i].length;j++){   
                matri+="["+matriz[i][j]+"]";
            }
            matri+="\n";
        }
        return matri;
      }
    
    public static int[]ArregloMayor(int matriz[][]){
        int[]mayor=new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(mayor[i]<matriz[i][j]){
                    mayor[i]=matriz[i][j];
                }
            }
        }
        return mayor;
    }
    
    
    public static void imprimir2(int[] matriz){
    System.out.println("Numero mayor de cada fila");
    for (int i = 0; i < matriz.length; i++) {
        System.out.print("[" + matriz[i] + "]");
    }
    System.out.println(); 
     }
    public static void imprimir3(int[] matriz){
    System.out.println("Numero mayor de cada fila");
    for (int i = 0; i < matriz.length; i++) {
        System.out.print("[" + matriz[i] + "]");
    }
    System.out.println(); 
    }
    
    public static String imprimir(int[] matrizs) {
       String resultado = "";
    for (int i = 0; i < matrizs.length; i++) {
        if (matrizs[i] != 0) { // Agregar condición para ignorar los ceros
            resultado += matrizs[i];
            if (i != matrizs.length - 1) {
                resultado += " ";
            }
        }
    }
    return resultado;
    }
}
