/*
3. Crear una clase Tiempo, con atributos hora, minuto y segundo, que pueda ser construida indicando los tres atributos, 
solo la hora y minuto o solo la hora. Crear además los métodos necesarios para modificar la hora en cualquier 
momento de forma manual. Mantenga la integridad de los datos en todo momento. Crear una clase (JFrame Form) 
Prueba_Tiempo que prueba una hora concreta y la modifique a su gusto mostrándola por pantalla (utilizando JTable, 
utilice con JPoPMenu las opciones de modificar y eliminar, además utilice archivo de texto en Java 
para almacenar y cargar la información).
 */
package tiempo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Tiempo {
    //atributos
    int hr, min, seg;
    
    //metodo constructor
    Tiempo(){
        
    }
    
    //metodos getter y setter
    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
    
    //creando archivo txt para almacenar los datos ingresados
    public void crearArchivo(JTable jtab){
        try{
           String fileRectangulo = "D:\\Documents\\NetBeansProjects\\Tiempo\\src\\tiempo\\datos.txt";
           BufferedWriter bfw = new BufferedWriter(new FileWriter(fileRectangulo));
            for (int i = 0; i < jtab.getColumnCount(); i++) {
                bfw.write(jtab.getColumnName(i) + "      ");
            }
            bfw.write("\n");
            for (int i = 0; i < jtab.getRowCount(); i++) {
                for (int j = 0; j < jtab.getColumnCount(); j++) {
                    bfw.write(jtab.getValueAt(i, j).toString() + "           ");
                }
                bfw.newLine();
            }
            bfw.close();
            JOptionPane.showMessageDialog(null, "El archivo fue creado correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el archivo." + e.getMessage());
        }
    }
    
    //llenar tabla con los registros
    public void llenarTabla(int hora, int minuto, int segundo, JTable tabla) {
        int h = 0, m = 0, s = 0;
        boolean ok = false;
        try {

            if (ok == false) {
                //validar hora (formato de 24 hrs)
                if (hora >= 0 && hora <= 23) {
                    setHr(hora);
                    h=1;
                } else {
                    JOptionPane.showMessageDialog(null, "Hora fuera del formato esperado", "ERROR", JOptionPane.ERROR_MESSAGE);
                    h=0;
                }
                if (minuto >= 0 && minuto <= 59) {
                    setMin(minuto);
                    m=1;
                } else {
                    JOptionPane.showMessageDialog(null, "Minutos fuera de rango", "ERROR", JOptionPane.ERROR_MESSAGE);
                    m=0;
                }
                if (segundo >= 0 && segundo <= 3599) {
                    setSeg(segundo);
                    s=1;
                } else {
                    JOptionPane.showMessageDialog(null, "Segundos fuera de rango", "ERROR", JOptionPane.ERROR_MESSAGE);
                    s=0;
                }
            }
               if (h==1 && m==1 && s==1) {
                DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
                Object nuevaTab[] = {hora, minuto, segundo};
                tb.addRow(nuevaTab);
                JOptionPane.showMessageDialog(null, "Registro Añadido exitosamente");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se pudo añadir " + e.getMessage());
        }
    }


    // Eliminar datos de una tabla
    public void eliminaRegistro(JTable tabla){
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        if (tabla.getSelectedRow()>=0){
            tb.removeRow(tabla.getSelectedRow());
        } 
    }
    
    //guardar datos modificados
    public void guardarDatosModificados(JTable tabla, int filaSelec, int hora, int minuto, int segundo){
        int h = 0, m = 0, s = 0;
        boolean ok = false;
        try {

            if (ok == false) {
                //validar hora (formato de 24 hrs)
                if (hora >= 0 && hora <= 23) {
                    setHr(hora);
                    h=1;
                } else {
                    JOptionPane.showMessageDialog(null, "Hora fuera del formato esperado", "ERROR", JOptionPane.ERROR_MESSAGE);
                    h=0;
                }
                if (minuto >= 0 && minuto <= 59) {
                    setMin(minuto);
                    m=1;
                } else {
                    JOptionPane.showMessageDialog(null, "Minutos fuera de rango", "ERROR", JOptionPane.ERROR_MESSAGE);
                    m=0;
                }
                if (segundo >= 0 && segundo <= 3599) {
                    setSeg(segundo);
                    s=1;
                } else {
                    JOptionPane.showMessageDialog(null, "Segundos fuera de rango", "ERROR", JOptionPane.ERROR_MESSAGE);
                    s=0;
                }
            }
               if (h==1 && m==1 && s==1) {
                tabla.setValueAt(hora, filaSelec, 0);
                tabla.setValueAt(minuto, filaSelec, 1);
                tabla.setValueAt(segundo, filaSelec, 2);
                JOptionPane.showMessageDialog(null, "Registro Modificado exitosamente");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
