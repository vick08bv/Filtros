package Filtros;

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
 * Interfaz.
 * @author Méndez Oliveros Victor Hugo
 */
public class Interfaz extends javax.swing.JFrame {
    
    /**
     *Lista donde iremos guardando el procesamiento de las imagenes.
     */
    private List<BufferedImage> imagenes;
    
    /**
     * Nos permite saber en que indice de la lista estamos.
     */
    private int indice;
    
    /**
     * Aqui se guardara la imagen.
     */
    private BufferedImage imagenActual;
    
    /**
     * El nombre de la imagen.
     */
    private String nombre;
    
    /**
     * El formato de la imagen.
     */
    private String formato;
    
    /**
     * Registra si hay cambios sin guardar.
     */
    private boolean cambios;
    
    /**
     * Objeto que nos permitira aplicar los filtros.
     */
    private Filtros filtro;

    /**
     * Creates new form Practica2
     */
    public Interfaz() {
        initComponents();
        // Objeto de tipo Filtros.
        filtro = new Filtros();
        // Titulo de la ventana.
        setTitle("Mini Photoshop");
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
        deslizador = new javax.swing.JSlider();
        Menu = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        filtros = new javax.swing.JMenu();
        filtroColor = new javax.swing.JMenu();
        filtroRojo = new javax.swing.JMenuItem();
        filtroVerde = new javax.swing.JMenuItem();
        filtroAzul = new javax.swing.JMenuItem();
        filtroSepia = new javax.swing.JMenuItem();
        negativo = new javax.swing.JMenuItem();
        luzNegra = new javax.swing.JMenuItem();
        tonosGris = new javax.swing.JMenu();
        mitadGris = new javax.swing.JMenu();
        superiorGris = new javax.swing.JMenuItem();
        inferiorGris = new javax.swing.JMenuItem();
        izquierdaGris = new javax.swing.JMenuItem();
        derechaGris = new javax.swing.JMenuItem();
        grisesTodo = new javax.swing.JMenuItem();
        brillo = new javax.swing.JMenu();
        aumentarBrillo = new javax.swing.JMenuItem();
        disminuirBrillo = new javax.swing.JMenuItem();
        reflejo = new javax.swing.JMenu();
        reflejoHorizontal = new javax.swing.JMenuItem();
        reflejoVertical = new javax.swing.JMenuItem();
        reflejoDiagonal = new javax.swing.JMenuItem();
        pixelear = new javax.swing.JMenuItem();
        esteganografia = new javax.swing.JMenu();
        ocultarCodigo = new javax.swing.JMenuItem();
        mostrarCodigo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        imagen.setBackground(new java.awt.Color(153, 255, 255));

        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        anterior.setEnabled(false);
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        siguiente.setEnabled(false);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        deslizador.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        deslizador.setMajorTickSpacing(10);
        deslizador.setMinorTickSpacing(1);
        deslizador.setPaintLabels(true);
        deslizador.setPaintTicks(true);
        deslizador.setSnapToTicks(true);
        deslizador.setToolTipText("");

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

        Menu.add(archivo);

        filtros.setText("Filtros");
        filtros.setEnabled(false);

        filtroColor.setText("Filtros de color");

        filtroRojo.setText("Rojo");
        filtroRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroRojoActionPerformed(evt);
            }
        });
        filtroColor.add(filtroRojo);

        filtroVerde.setText("Verde");
        filtroVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroVerdeActionPerformed(evt);
            }
        });
        filtroColor.add(filtroVerde);

        filtroAzul.setText("Azul");
        filtroAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroAzulActionPerformed(evt);
            }
        });
        filtroColor.add(filtroAzul);

        filtroSepia.setText("Sepia");
        filtroSepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroSepiaActionPerformed(evt);
            }
        });
        filtroColor.add(filtroSepia);

        negativo.setText("Negativo");
        negativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativoActionPerformed(evt);
            }
        });
        filtroColor.add(negativo);

        luzNegra.setText("Luz negra");
        luzNegra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luzNegraActionPerformed(evt);
            }
        });
        filtroColor.add(luzNegra);

        filtros.add(filtroColor);

        tonosGris.setText("Tonos de Gris");

        mitadGris.setText("Parcial");

        superiorGris.setText("Superior %");
        superiorGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superiorGrisActionPerformed(evt);
            }
        });
        mitadGris.add(superiorGris);

        inferiorGris.setText("Inferior %");
        inferiorGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inferiorGrisActionPerformed(evt);
            }
        });
        mitadGris.add(inferiorGris);

        izquierdaGris.setText("Izquierda %");
        izquierdaGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izquierdaGrisActionPerformed(evt);
            }
        });
        mitadGris.add(izquierdaGris);

        derechaGris.setText("Derecha %");
        derechaGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derechaGrisActionPerformed(evt);
            }
        });
        mitadGris.add(derechaGris);

        tonosGris.add(mitadGris);

        grisesTodo.setText("Total");
        grisesTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grisesTodoActionPerformed(evt);
            }
        });
        tonosGris.add(grisesTodo);

        filtros.add(tonosGris);

        brillo.setText("Brillo");

        aumentarBrillo.setText("Aumentar brillo %");
        aumentarBrillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aumentarBrilloActionPerformed(evt);
            }
        });
        brillo.add(aumentarBrillo);

        disminuirBrillo.setText("Disminuir brillo %");
        disminuirBrillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disminuirBrilloActionPerformed(evt);
            }
        });
        brillo.add(disminuirBrillo);

        filtros.add(brillo);

        reflejo.setText("Reflejo");

        reflejoHorizontal.setText("Horizontal");
        reflejoHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reflejoHorizontalActionPerformed(evt);
            }
        });
        reflejo.add(reflejoHorizontal);

        reflejoVertical.setText("Vertical");
        reflejoVertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reflejoVerticalActionPerformed(evt);
            }
        });
        reflejo.add(reflejoVertical);

        reflejoDiagonal.setText("Diagonal");
        reflejoDiagonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reflejoDiagonalActionPerformed(evt);
            }
        });
        reflejo.add(reflejoDiagonal);

        filtros.add(reflejo);

        pixelear.setText("Pixelear %");
        pixelear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pixelearActionPerformed(evt);
            }
        });
        filtros.add(pixelear);

        esteganografia.setText("Esteganografía");

        ocultarCodigo.setText("Ocultar código");
        ocultarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultarCodigoActionPerformed(evt);
            }
        });
        esteganografia.add(ocultarCodigo);

        mostrarCodigo.setText("Mostrar código");
        mostrarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarCodigoActionPerformed(evt);
            }
        });
        esteganografia.add(mostrarCodigo);

        filtros.add(esteganografia);

        Menu.add(filtros);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(deslizador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)))
                        .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deslizador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(eliminar)))
                .addGap(15, 15, 15))
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
        chooser.setFileFilter(new FileNameExtensionFilter(
        "Image File", "png", "PNG", "jpg", "JPG", "jpeg", "JPEG", "bmp", "BMP"));
        
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
                    imagenActual = ImageIO.read(selectedFile);
                    // Cremos una nueva lista para la imagen seleccionada.
                    imagenes = new ArrayList<>();
                    // Agregamos la imagen a la lista.
                    imagenes.add(imagenActual);
                    // Inicializamos el indice en la posicion 0.
                    indice = 0;
                    // Hay cambios sin guardar.
                    cambios = true;
                    // Colocamos la imagen en el label de la interfaz.
                    imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                                       imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
                    // Activamos el boton de guardar y el menu de filtros.
                    guardar.setEnabled(true);
                    filtros.setEnabled(true);
                    anterior.setEnabled(true);
                    siguiente.setEnabled(true);
                    eliminar.setEnabled(true);
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
                ImageIO.write(imagenes.get(indice), formato, 
                new File(chooser.getSelectedFile().getAbsolutePath()));
                // Ya no hay cambios sin guardar.
                cambios = false;
            } catch (IOException ex) {
                System.out.println("Failed to save image!");
            }
        }
        
    }//GEN-LAST:event_guardarActionPerformed
    private void grisesTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grisesTodoActionPerformed
        
        // Guardarmos la imagen editada en el buferredImage.
        imagenActual = filtro.tonosDeGris(imagenes.get(indice));
        // Aumentamos los indices.
        indice++;
        // Agregamos la nueva imagen a la lista.
        imagenes.add(indice, imagenActual);
        // Colocamos la imagen en la interfaz.
        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_grisesTodoActionPerformed
    private void pixelearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pixelearActionPerformed

        imagenActual = filtro.pixelearImagen(
            imagenes.get(indice), deslizador.getValue());

        indice++;

        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                        imagen.getWidth(), -1, Image.SCALE_SMOOTH)));

    }//GEN-LAST:event_pixelearActionPerformed
    private void filtroRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroRojoActionPerformed

        imagenActual = filtro.filtroColor(imagenes.get(indice), "rojo");
        
        indice++;

        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_filtroRojoActionPerformed
    private void filtroVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroVerdeActionPerformed
        
        imagenActual = filtro.filtroColor(imagenes.get(indice), "verde");
  
        indice++;
        
        imagenes.add(indice, imagenActual);


        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_filtroVerdeActionPerformed
    private void filtroAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroAzulActionPerformed
        
        imagenActual = filtro.filtroColor(imagenes.get(indice), "azul");

        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_filtroAzulActionPerformed
    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
   
        if(indice > 0){
        
            indice--;

            imagen.setIcon(new ImageIcon(imagenes.get(indice).getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));

        }

    }//GEN-LAST:event_anteriorActionPerformed
    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        
        if(indice < imagenes.size()-1){

            indice++;

            imagen.setIcon(new ImageIcon(imagenes.get(indice).getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));

        }
        
    }//GEN-LAST:event_siguienteActionPerformed
    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        
        if(imagenes.size() == 1){

            guardar.setEnabled(false);
            filtros.setEnabled(false);
            anterior.setEnabled(false);
            siguiente.setEnabled(false);
            eliminar.setEnabled(false);
            imagen.setIcon(null);
        
        } else {
        
                imagenes.remove(indice);
                
                if(indice == imagenes.size()){
                    indice--;
                }
                
                imagen.setIcon(new ImageIcon(imagenes.get(indice).getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
            
        }
        
    }//GEN-LAST:event_eliminarActionPerformed
    private void superiorGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superiorGrisActionPerformed
        
        imagenActual = filtro.tonosDeGrisParcial(imagenes.get(indice),
                                        "sup", deslizador.getValue());
                    
        indice++;

        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_superiorGrisActionPerformed
    private void inferiorGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inferiorGrisActionPerformed
        
        imagenActual = filtro.tonosDeGrisParcial(imagenes.get(indice), 
                                        "inf", deslizador.getValue());
        
        indice++;
        
        imagenes.add(indice, imagenActual);
        
        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_inferiorGrisActionPerformed
    private void izquierdaGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izquierdaGrisActionPerformed
        
        imagenActual = filtro.tonosDeGrisParcial(imagenes.get(indice), 
                                        "izq", deslizador.getValue());
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_izquierdaGrisActionPerformed
    private void derechaGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derechaGrisActionPerformed
        
        imagenActual = filtro.tonosDeGrisParcial(imagenes.get(indice), 
                                        "der", deslizador.getValue());
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_derechaGrisActionPerformed
    private void aumentarBrilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aumentarBrilloActionPerformed
        
        imagenActual = filtro.aumentarBrillo(imagenes.get(indice), 
                                           deslizador.getValue());
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_aumentarBrilloActionPerformed
    private void negativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativoActionPerformed
        
        imagenActual = filtro.filtroNegativo(imagenes.get(indice));
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_negativoActionPerformed
    private void reflejoHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflejoHorizontalActionPerformed
        
        imagenActual = filtro.reflejarImagen(imagenes.get(indice), "horizontal");
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_reflejoHorizontalActionPerformed
    private void reflejoVerticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflejoVerticalActionPerformed
        
        imagenActual = filtro.reflejarImagen(imagenes.get(indice), "vertical");
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_reflejoVerticalActionPerformed
    private void reflejoDiagonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflejoDiagonalActionPerformed
        
        imagenActual = filtro.reflejarImagen(imagenes.get(indice), "diagonal");
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_reflejoDiagonalActionPerformed
    private void filtroSepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroSepiaActionPerformed
        
        imagenActual = filtro.filtroSepia(imagenes.get(indice));
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_filtroSepiaActionPerformed
    private void luzNegraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luzNegraActionPerformed
        
        imagenActual = filtro.luzNegra(imagenes.get(indice));
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_luzNegraActionPerformed
    private void mostrarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarCodigoActionPerformed
        
        String cadena = filtro.mostrarCodigo(imagenes.get(indice));
        
        JOptionPane.showMessageDialog(null, cadena, "Código", 
                                  JOptionPane.PLAIN_MESSAGE);
        
    }//GEN-LAST:event_mostrarCodigoActionPerformed
    private void ocultarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultarCodigoActionPerformed
        
        String codigo = JOptionPane.showInputDialog(null, null , 
                "Introducir Código", JOptionPane.PLAIN_MESSAGE);
                
        imagenActual = filtro.ocultarCodigo(imagenes.get(indice), codigo);
                
        indice++;
        
        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
                          imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
        
    }//GEN-LAST:event_ocultarCodigoActionPerformed
    private void disminuirBrilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disminuirBrilloActionPerformed
        
        imagenActual = filtro.disminuirBrillo(imagenes.get(indice), 
                                            deslizador.getValue());

        indice++;

        imagenes.add(indice, imagenActual);

        imagen.setIcon(new ImageIcon(imagenActual.getScaledInstance(
            imagen.getWidth(), -1, Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_disminuirBrilloActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem abrir;
    private javax.swing.JButton anterior;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenuItem aumentarBrillo;
    private javax.swing.JMenu brillo;
    private javax.swing.JMenuItem derechaGris;
    private javax.swing.JSlider deslizador;
    private javax.swing.JMenuItem disminuirBrillo;
    private javax.swing.JButton eliminar;
    private javax.swing.JMenu esteganografia;
    private javax.swing.JMenuItem filtroAzul;
    private javax.swing.JMenu filtroColor;
    private javax.swing.JMenuItem filtroRojo;
    private javax.swing.JMenuItem filtroSepia;
    private javax.swing.JMenuItem filtroVerde;
    private javax.swing.JMenu filtros;
    private javax.swing.JMenuItem grisesTodo;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JLabel imagen;
    private javax.swing.JMenuItem inferiorGris;
    private javax.swing.JMenuItem izquierdaGris;
    private javax.swing.JMenuItem luzNegra;
    private javax.swing.JMenu mitadGris;
    private javax.swing.JMenuItem mostrarCodigo;
    private javax.swing.JMenuItem negativo;
    private javax.swing.JMenuItem ocultarCodigo;
    private javax.swing.JMenuItem pixelear;
    private javax.swing.JMenu reflejo;
    private javax.swing.JMenuItem reflejoDiagonal;
    private javax.swing.JMenuItem reflejoHorizontal;
    private javax.swing.JMenuItem reflejoVertical;
    private javax.swing.JMenuItem salir;
    private javax.swing.JButton siguiente;
    private javax.swing.JMenuItem superiorGris;
    private javax.swing.JMenu tonosGris;
    // End of variables declaration//GEN-END:variables

}
