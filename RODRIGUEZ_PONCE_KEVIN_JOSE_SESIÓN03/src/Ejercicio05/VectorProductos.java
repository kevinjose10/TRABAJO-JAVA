/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio05;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author COMPUTER
 */
public class VectorProductos {

    private Producto vector[];
    private int totalElementos;

    public VectorProductos() {
        vector = new Producto[50];
        totalElementos = 0;
    }

    public VectorProductos(int limite) {
        vector = new Producto[limite];
        totalElementos = 0;
    }

    public boolean agregar(Producto valor) {
        if (totalElementos < vector.length) {
            vector[totalElementos] = valor;
            totalElementos++;
            return true;
        } else {
            return false;
        }
    }

    public Producto devolverElemento(int indice) {
        return vector[indice];
    }

    public int getTotalElementos() {
        return totalElementos;
    }

    public void mostrar(DefaultTableModel modelo) {
        Object datos[][] = new Object[totalElementos][5];
        String titulos[] = {"CÓDIGO", "DESCRIPCIÓN", "PRECIO", "STOCK", "CATEGORÍA"};
        for (int i = 0; i < totalElementos; i++) {
            datos[i][0] = vector[i].getCodigo();
            datos[i][1] = vector[i].getDescripcion();
            datos[i][2] = vector[i].getPrecio();
            datos[i][3] = vector[i].getStock();
            datos[i][4] = vector[i].getCategoria();
        }
        modelo.setDataVector(datos, titulos);
    }

    public void ordenamientoQuickSortCodigo(Producto v[], int left, int right) {
        int i = left, j = right;
        Producto x, temp;
        x = v[(left + right) / 2];

        do {
            while(v[i].getCodigo().compareTo(x.getCodigo())<0&& i<right) i++;
            while(v[j].getCodigo().compareTo(x.getCodigo())>0 && j>left) j--;

            if (i <= j) {
                temp = v[i];
                v[i] = v[j];
                v[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (i < right) {
            ordenamientoQuickSortCodigo(v, i, right);
        }
        if (left < j) {
            ordenamientoQuickSortCodigo(v, left, j);
        }
    }

    public void ordenamientoQuickSortCodigo() {
        ordenamientoQuickSortCodigo(vector, 0, totalElementos - 1);
    }

    public int busquedaSecuencialRecursiva(Producto v[], int n, String valor) {
        if (n == 0) {
            return -1;
        } else {
            if (valor.compareTo(v[n - 1].getCodigo()) == 0) {
                return n - 1;
            } else {
                return busquedaSecuencialRecursiva(v, n - 1, valor);
            }
        }
    }

    public int busquedaSecuencialRecursiva(String valor) {
        return busquedaSecuencialRecursiva(vector, totalElementos, valor);

    }

    public Producto[] getVector() {
        return vector;
    }
}
