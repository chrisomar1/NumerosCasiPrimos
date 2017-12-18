/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeroscasiprimos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ChristianOmar
 */
public class NumerosCasiPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num1,num2,cuantos,cont=0; //Variable num1=recibe el limite inf del rango,
                                      //Variable num2=recibe el limite superior del rango,
                                      //Variable cuantos = recibe cuantos rangos evaluará la aplicación,
                                      //Variable que contará cuantos rangos ya se han evaluado.
        Scanner entrada = new Scanner(System.in); //Objeto que permitirá leer datos del usuario desde consola
        //System.out.println("Cuantos rangos deseas evaluar:");
        cuantos = entrada.nextInt();  //Variable que lee un numero desde consola ingresado por el usuario
        
        //System.out.println(esPrimo(num));
        while(cont<cuantos)           //Realiza la evaluación de rangos mientras variable cont sea menor a variable cuantos
        {
            //System.out.println("Dame un numero: ");
            num1 = entrada.nextInt(); //Almacena en num1 el limite inferior que ingresa el usuario
            //System.out.println("Dame otro numero: ");
            num2 = entrada.nextInt(); //Almacena en num2 el limite superior que ingresa el usuario
            esPrimo(num1,num2);       //Evalúa que numeros dentro del rango ingresado son primos
            cont++;                   //Incrementa en 1 la variable cont
        }
        
        
        
    }
    
   /* public static boolean esPrimo(int numero){
        
             int contador = 2;
boolean primo=true;
 
while ((primo) && (contador!=numero)){
  if (numero % contador == 0)
    primo = false;
  contador++;
    
    }
    return primo;
}*/
  public static void esPrimo(int rInicial, int rFinal)
  {
       int i,j;
       boolean esPrimo;
       ArrayList<Integer> lista = new ArrayList<Integer>();
       ArrayList<Integer> lista2 = new ArrayList<Integer>();
            for(i = rInicial;i <= rFinal;i++){
            //recorro ciclo tantas veces como necesite(<= es para incluir el valor de rFinal)
                esPrimo=true;// i es primo hasta que se demuestre lo contrario
                    for(j = 2;j < i;j++){
                          //no coloque j = 1 porque ya sabemos que todo numero es divisible por 1.
                          /*j < i es para no incluir el numero a evaluar, pues todo numero es divisible
                            por si mismo.*/
                            if(i % j == 0){//Si además del 1 y el mismo hay otro divisor, ya no es primo.
                            //% devuelve el residuo de i/j
                                esPrimo = false;//se demostró que i no es primo.
                            }
                    }
                            if(esPrimo){//Si es primo lo imprimo.
                            //System.out.println(i);
                            lista.add(i);
                            }
                            else
                            {
                            lista2.add(i);
                            }
            } 
  
        //System.out.println(lista.size());
        //System.out.println(lista.size());
        casiPrimo(lista,lista2);
  
  }

public static void casiPrimo(ArrayList<Integer> list1, ArrayList<Integer> list2)
{
    int contador=0;
    int contadorCasiPrimo=0;
    int residuo=0;
    
    for(int x = 0; x < list2.size(); x++)
    {
       for(int y = 0; y < list1.size(); y++) 
       {
           if(list1.get(y)!=1)
           {
           residuo = list2.get(x) % list1.get(y);
           if(residuo==0)
           {
               contador++;
           }
           }

       }
       if(contador==1)
       {
         contadorCasiPrimo++;  
       }
        contador=0;   
    }
    
    System.out.println("El numero de casi primos es: "+contadorCasiPrimo);
   
}

}
