/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio03;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author COMPUTER
 */
public class VectorAlumnos {

    private Alumno vector[];
    private int totalElementos;

    public VectorAlumnos() {
        vector = new Alumno[50];
        totalElementos = 0;
    }

    public VectorAlumnos(int limite) {
        vector = new Alumno[limite];
        totalElementos = 0;
    }

    public boolean agregar(Alumno valor) {
        if (totalElementos < vector.length) {
            vector[totalElementos] = valor;
            totalElementos++;
            return true;
        } else {
            return false;
        }
    }

    public Alumno devolverElemento(int indice) {
        return vector[indice];
    }

    public int getTotalElementos() {
        return totalElementos;
    }

    public void mostrar(DefaultTableModel modelo) {
        Object datos[][] = new Object[totalElementos][2];
        String titulos[] = {"NOMBRE", "NOTA"};
        for (int i = 0; i < totalElementos; i++) {
            datos[i][0] = vector[i].getNombre();
            datos[i][1] = vector[i].getPromedio();
        }
        modelo.setDataVector(datos, titulos);
    }

    public void ordenamientoQuickSortPromedio(Alumno v[], int left, int right) {
        int i = left, j = right;
        Alumno x, temp;
        x = v[(left + right) / 2];

        do {
            while (v[i].getPromedio() < x.getPromedio() && i < right) {
                i++;
            }
            while (v[j].getPromedio() > x.getPromedio() && j > left) {
                j--;
            }
            if (i <= j) {
                temp = v[i];
                v[i] = v[j];
                v[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (i < right) {
            ordenamientoQuickSortPromedio(v, i, right);
        }
        if (left < j) {
            ordenamientoQuickSortPromedio(v, left, j);
        }
    }

    public void ordenamientoQuickSortPromedio() {
        ordenamientoQuickSortPromedio(vector, 0, totalElementos - 1);
    }

    public int busquedaLinealRecursiva(Alumno v[], int n, double valor) {
        if (n == 0) {
            return -1;
        } else {
            if (v[n - 1].getPromedio() == valor) {
                return n - 1;
            } else {
                return busquedaLinealRecursiva(v, n - 1, valor);
            }
        }
    }

    public int busquedaLinealRecursiva(double valor) {
        return busquedaLinealRecursiva(vector, totalElementos, valor);
    }

    public Alumno[] getVector() {
        return vector;
    }
}
