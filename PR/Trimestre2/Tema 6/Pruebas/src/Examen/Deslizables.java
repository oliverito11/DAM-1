package Examen;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

 class Deslizables {


    public Deslizables() {

        // La ventana
        JFrame ventana = new JFrame("Imagen");

        // El panel de scroll
        JScrollPane scroll = new JScrollPane();

        // La etiqueta.
        JLabel etiqueta = new JLabel();

        // Se carga la imagen, con path absoluto para evitar problemas y debe

        Icon imagen = new ImageIcon ("./fotos/paisaje1.jpg");

        // Se mete la imagen en el label
        etiqueta.setIcon (imagen);

        // Se mete el label en el scroll
        scroll.setViewportView(etiqueta);

        // Se mete el scroll en la ventana
        ventana.getContentPane().add(scroll);



        // Y se visualiza todo.
        ventana.setSize(200,200);
        ventana.setVisible(true);
    }





    public static void main(String[] args) {
        new Deslizables();
    }

}