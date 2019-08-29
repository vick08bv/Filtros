package practica2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author usr
 */
public class Practica2 extends javax.swing.JFrame {
    
    // Lista donde iremos guardando el procesamiento de las imagenes.
    private List<BufferedImage> imagenes;
    // Nos permite saber en que indice de la lista estamos.
    private int index;
    // Aqui se guardara la imagen.
    private BufferedImage imagenOriginal;
    // El nombre de la imagen.
    private String nombre;
    // El formato de la imagen.
    private String formato;
    // Registra si hay cambios sin guardar.
    private boolean cambios;
    // Objeto que nos permitira aplicar los filtros.
    private Filtros f;

    /**
     * Creates new form Practica2
     */
    public Practica2() {
        initComponents();
        // Objeto de tipo Filtros.
        f = new Filtros();
        // Titulo de la ventana.
        setTitle("MiniPhotoShop");
        // Colocamos al centro de la pantalla.
        setLocationRelativeTo(null);
        // Evitamos que se maximice la ventana.
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagen = new javax.swing.JLabel();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        filtros = new javax.swing.JMenu();
        tonosGris = new javax.swing.JMenu();
        grisesMitad = new javax.swing.JMenuItem();
        grisesTodo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eliminar.setText("Eliminar");

        archivo.setText("Archivo");

        abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        archivo.add(abrir);

        guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        archivo.add(guardar);

        salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        archivo.add(salir);

        jMenuBar1.add(archivo);

        filtros.setText("Filtros");

        tonosGris.setText("Tonos de Gris");

        grisesMitad.setText("La mitad");
        tonosGris.add(grisesMitad);

        grisesTodo.setText("Todo");
        grisesTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grisesTodoActionPerformed(evt);
            }
        });
        tonosGris.add(grisesTodo);

        filtros.add(tonosGris);

        jMenuBar1.add(filtros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(anterior)
                        .addGap(39, 39, 39)
                        .addComponent(eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(siguiente))
                    .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(siguiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(anterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.out.println("Adios");
        // Termina la ejecucion del programa.
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        // Objeto que nos permitira abrir una ventana de seleccion.
        JFileChooser chooser = new JFileChooser();
        // Colocamos un titulo a la ventana.
        chooser.setDialogTitle("Abrir imagen");
        // Filtramos los archivos para solo mostrar aquellos que queramos abrir.
        // En este caso, solo aquellos que sean de tipo imagen.
        chooser.setFileFilter(new FileNameExtensionFilter("Image File", "png", "PNG", "jpg", "JPG", "jpeg", "JPEG", "bmp", "BMP"));
        
        // Mostramos la ventana y vemos si la opcion fue aceptar.      
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            // Tomamos el archivo seleccionado.
            File selectedFile = chooser.getSelectedFile();
            try{
                if(selectedFile != null){
                    // Obtenemos el nombre de la imagen.
                    nombre = selectedFile.getName();
                    // Obtenemos su formato.
                    formato = nombre.split("\\.")[1];
                    // Leemos la imagen.
                    imagenOriginal = ImageIO.read(selectedFile);
                    // Cremos una nueva lista para la imagen seleccionada.
                    imagenes = new ArrayList<>();
                    // Agregamos la imagen a la lista.
                    imagenes.add(imagenOriginal);
                    // Inicializamos el indice en la posicion 0.
                    index = 0;
                    // Hay cambios sin guardar.
                    cambios = true;
                    // Colocamos la imagen en el label de la interfaz.
                    imagen.setIcon(new ImageIcon(imagenOriginal.getScaledInstance(imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
                    // Activamos el boton de guardar y el menu de filtros.
                    guardar.setEnabled(true);
                    filtros.setEnabled(true);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        // Objeto que nos permitira desplejar los directorios.
        JFileChooser chooser = new JFileChooser();
        // Colocamos un titulo a la ventana,
        chooser.setDialogTitle("Guardar imagen");
        // Colocamos un nombre por default (El usuario lo puede modificar).
        chooser.setSelectedFile(new File(nombre));
        // Mostramos la ventana y vemos si la opcion fue guardar.
        if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            // Guardamos la imagen.
            try {
                ImageIO.write(imagenOriginal, formato, new File(chooser.getSelectedFile().getAbsolutePath()));
                // Ya no hay cambios sin guardar.
                cambios = false;
            } catch (IOException ex) {
                System.out.println("Failed to save image!");
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void grisesTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grisesTodoActionPerformed
        
        // Guardarmos la imagen editada en el buferredImage.
        imagenOriginal = f.tonosDeGris(imagenOriginal);
        // Agregamos la nueva imagen a la lista.
        imagenes.add(imagenOriginal);
        // Aumentamos los indices.
        index++;
        // Colocamos la imagen en la interfaz.
        imagen.setIcon(new ImageIcon(imagenOriginal.getScaledInstance(imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_grisesTodoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Practica2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practica2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practica2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practica2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practica2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrir;
    private javax.swing.JButton anterior;
    private javax.swing.JMenu archivo;
    private javax.swing.JButton eliminar;
    private javax.swing.JMenu filtros;
    private javax.swing.JMenuItem grisesMitad;
    private javax.swing.JMenuItem grisesTodo;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JLabel imagen;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem salir;
    private javax.swing.JButton siguiente;
    private javax.swing.JMenu tonosGris;
    // End of variables declaration//GEN-END:variables
}
