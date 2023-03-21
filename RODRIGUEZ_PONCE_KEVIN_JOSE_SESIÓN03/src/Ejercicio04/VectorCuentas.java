/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author COMPUTER
 */
public class VectorCuentas {

    private Cuenta vector[];
    private int totalElementos;

    public VectorCuentas() {
        vector = new Cuenta[50];
        totalElementos = 0;
    }

    public VectorCuentas(int limite) {
        vector = new Cuenta[limite];
        totalElementos = 0;
    }

    public boolean agregar(Cuenta valor) {
        if (totalElementos < vector.length) {
            vector[totalElementos] = valor;
            totalElementos++;
            return true;
        } else {
            return false;
        }
    }

    public Cuenta devolverElemento(int indice) {
        return vector[indice];
    }

    public int getTotalElementos() {
        return totalElementos;
    }

    public void mostrar(DefaultTableModel modelo) {
        Object datos[][] = new Object[totalElementos][3];
        String titulos[] = {"CÓDIGO", "NOMBRE", "SALDO"};
        for (int i = 0; i < totalElementos; i++) {
            datos[i][0] = vector[i].getCodigo();
            datos[i][1] = vector[i].getNombre();
            datos[i][2] = vector[i].getSaldo();
        }
        modelo.setDataVector(datos, titulos);
    }

    public void ordenamientoQuickSortNombre(Cuenta v[], int left, int right){
        int i=left , j=right;
        Cuenta x, temp;
        x = v[(left+right)/2];
        
        do{
            while(v[i].getNombre().compareTo(x.getNombre())<0&& i<right) i++;
            while(v[j].getNombre().compareTo(x.getNombre())>0 && j>left) j--;
            if(i<=j){
                temp = v[i];
                v[i]=v[j];
                v[j]= temp;
                i++;
                j--;
            }
        } while(i<=j);
        if(i<right) ordenamientoQuickSortNombre(v,i,right);
        if(left<j) ordenamientoQuickSortNombre(v,left,j);
    }
    
    public void ordenamientoQuickSortNombre(){
        ordenamientoQuickSortNombre(vector,0,totalElementos-1);
    }

    public int busquedaBinariaRecursiva(Cuenta[] v, String valor, int inicio, int fin) {

        if (inicio <= fin) {
            int centro = (inicio + fin) / 2;
            
            if(valor.compareTo(v[centro].getNombre())==0){
                return centro;
            
            }else{
                if(v[centro].getNombre().compareTo(valor)<0){
                    return busquedaBinariaRecursiva(v, valor, centro+1, fin);
                }
                else{
                    return busquedaBinariaRecursiva(v, valor, inicio, centro-1);
                }
            }
        }
        else{
            return -1;
        }
    }

    public int busquedaBinariaRecursiva(String valor) {
        return busquedaBinariaRecursiva(vector, valor, 0, totalElementos-1);
    }

    public Cuenta[] getVector() {
        return vector;
    }
}
