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
                            if(esPrimo){//Si es primo 
                            //System.out.println(i);
                            lista.add(i);    //lo añadimos a una lista que contendrá solamente numeros primos (lista)
                            }
                            else
                            {
                            lista2.add(i);   //Si no es primo lo añadimos a una lista que contendrá solamente numeros no primos (lista2)
                            }
            } 
  
        //System.out.println(lista.size());
        //System.out.println(lista.size());
        casiPrimo(lista,lista2);   //Envío como parametros ambas listas; la que contiene numeros primos y la que contiene numeros no primos a la funcion casiPrimo(l1,l2)
                                   //Funcion que determina que cuenta cuantos números de la lista de no primos son casi primos.
  }

public static void casiPrimo(ArrayList<Integer> list1, ArrayList<Integer> list2) //Funcion que cuenta cuantos numeros de la lista de no primos son casi primos y recibe la lista de numeros primos y la lista de numeros no primos
{
    int contador=0; //Variable contador que verifica cuantos numeros primos dividen exactamente a cada uno de los numeros no primos
    int contadorCasiPrimo=0; //Variable que lleva una cuenta del numero total de numeros casi primos encontrados en la lista de numeros no primos
    int residuo=0;  //Almacena el residuo de la division de un numero no primo entre numero primo
    
    for(int x = 0; x < list2.size(); x++) //Ciclo for que ayuda a recorrer la lista de numeros no primos
    {
       for(int y = 0; y < list1.size(); y++) //Ciclo for que ayuda a recorrer la lista de numeros primos
       {
           if(list1.get(y)!=1)     //Si el numero primo que se encuentra en la lista es diferente a uno; haz lo siguiente!
           {
           residuo = list2.get(x) % list1.get(y); //Obtener el residuo del numero no primo en la posición x de lista de nums no primos entre el numero primo en la posicion y de la lista de nums primos
           if(residuo==0) //Si residuo es igual igual a cero
           {
               contador++;  //Incrementa la variable contador en 1; esto quiere decir que se ha encontrado un numero primo que divide exactamente a un numero no primo
           }
           }

       }
       if(contador==1)  //Si contador es igual igual a 1
       {
         contadorCasiPrimo++;  //Hemos encontrado un numero casi primo y aumentamos la variable contadorCasiPrimo en 1 unidad.
       }
        contador=0;   //Regresamos la variable contador a cero ya que en el próximo ciclo dividirá el próximo número no primo de la lista entre todos los números primos de la otra lista.
    }
    
    System.out.println("El numero de casi primos es: "+contadorCasiPrimo); //Imprime en consola el número de casi primos que se encontró en dicho rango.
   
}

}
