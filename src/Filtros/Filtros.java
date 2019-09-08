package Filtros;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Métodos para cada filtro.
 * @author Méndez Oliveros Victor Hugo
 */
public class Filtros {
    
    /**
     * Aplica el filtro tonos de gris a una imagen.
     * @param imagen La imagen a la que le aplicaremos el filtro.
     * @return La nueva imagen con el filtro aplicado.
     */
    public BufferedImage tonosDeGris(BufferedImage imagen){
        // Creamos un buffer donde colocaremos la nueva imagen.
        BufferedImage nueva = new BufferedImage(imagen.getWidth(),imagen.getHeight(), BufferedImage.TYPE_INT_RGB);
        // Aqui guardaremos el color de cada pixel.
        Color rgb;
        // Los componentes de cada pixel.
        // a - Componente alpha (Transparencias).
        // r - Componente rojo.
        // g - Componente verde.
        // b - Componente azul.
        int a, r, g, b;
        // Recorremos pixel por pixel.
        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){
                // Obtenemos el color del pixel en la posicion (x, y).
                rgb = new Color(imagen.getRGB(x, y));
                // Obtenemos cada componente.
                a = rgb.getAlpha();
                r = rgb.getRed();
                g = rgb.getGreen();
                b = rgb.getBlue();
                // Una imagen en gises se obtiene al obtener el promedio de los 3
                // componenetes y colocarlo en el pixel de la nueva imagen.
                int promedio = (r + g + b) / 3;
                // Creamos el nuevo color.
                // El componente alpha nunca se ve a modificar.
                Color c = new Color(promedio, promedio, promedio, a);
                // Aplicamos el nuevo color en la misma posicion.
                nueva.setRGB(x, y, c.getRGB());
            }
        }
        
        return nueva;
    }
    
    /**
     * Aplica el filtro tonos de gris en cierta parte de una imagen.
     * @param imagen La imagen a la que le aplicaremos el filtro.
     * @param opcion Parte en que se aplicará el filtro.
     * @param porcentaje Porcentaje de aplicación del filtro.
     * @return La nueva imagen con el filtro aplicado.
     */
    public BufferedImage tonosDeGrisParcial(BufferedImage imagen, 
                                   String opcion, int porcentaje){
        
        BufferedImage nueva = new BufferedImage(
            imagen.getWidth(),imagen.getHeight(), 
                     BufferedImage.TYPE_INT_RGB);
        
        //Coloreado de la imagen original.
        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){

                nueva.setRGB(x, y, imagen.getRGB(x, y));
                
            }
        }
        
        //Control del rango en que se aplicarán los tonos grises.
        int sup, inf, izq, der;
        
        switch (opcion) {
        
            case "sup":
                
                sup = 0;
                inf = (int)((porcentaje*imagen.getHeight())/100);
                izq = 0;
                der = imagen.getWidth();
                
                break;
                
            case "inf":
            
                sup = (int)(((100 - porcentaje)*imagen.getHeight())/100);
                inf = imagen.getHeight();
                izq = 0;
                der = imagen.getWidth();
                
                break;
                
            case "izq":
                
                sup = 0;
                inf = imagen.getHeight();
                izq = 0;
                der = (int)((porcentaje*imagen.getWidth())/100);
                
                break;
                
            default:
                
                sup = 0;
                inf = imagen.getHeight();
                izq = (int)(((100 - porcentaje)*imagen.getWidth())/100);
                der = imagen.getWidth();
                
                break;
                
        }

        Color rgb;
        
        int a, r, g, b;

        //Coloreado de gris sólo en la parte deseada de la imagen.
        for(int y = sup; y < inf; y++){
            for(int x = izq; x < der; x++){

                rgb = new Color(imagen.getRGB(x, y));
                
                a = rgb.getAlpha();
                r = rgb.getRed();
                g = rgb.getGreen();
                b = rgb.getBlue();

                int promedio = (r + g + b) / 3;

                Color c = new Color(promedio, promedio, promedio, a);
                
                nueva.setRGB(x, y, c.getRGB());
            }
        }
        
        return nueva;
        
    }
    
    /**
     * Aplica el filtro de color seleccionado a la imagen.
     * @param imagen La imagen a la que le aplicaremos el filtro.
     * @param color Color elegido´para el filtro.
     * @return La nueva imagen con el filtro aplicado.
     */
    public BufferedImage filtroColor(BufferedImage imagen, String color){
        
        BufferedImage nueva = new BufferedImage(
            imagen.getWidth(),imagen.getHeight(), 
                     BufferedImage.TYPE_INT_RGB);
        
        Color rgb;
        
        switch (color) {
            
            case "rojo":
                for(int y = 0; y < imagen.getHeight(); y++){
                    for(int x = 0; x < imagen.getWidth(); x++){
                        
                        rgb = new Color(imagen.getRGB(x, y));
                        Color c = new Color(rgb.getRed(), 0, 0, rgb.getAlpha());
                        nueva.setRGB(x, y, c.getRGB());
                        
                    }
                }
                
                return nueva;
                
            case "verde":
                
                for(int y = 0; y < imagen.getHeight(); y++){
                    for(int x = 0; x < imagen.getWidth(); x++){
                        
                        rgb = new Color(imagen.getRGB(x, y));
                        Color c = new Color(0, rgb.getGreen(), 0, rgb.getAlpha());
                        nueva.setRGB(x, y, c.getRGB());
                        
                    }
                }
                
                return nueva;
                
            //Filtro azul.
            default:
                
                for(int y = 0; y < imagen.getHeight(); y++){
                    for(int x = 0; x < imagen.getWidth(); x++){
                        
                        rgb = new Color(imagen.getRGB(x, y));
                        Color c = new Color(0, 0, rgb.getBlue(), rgb.getAlpha());
                        nueva.setRGB(x, y, c.getRGB());
                        
                    }
                }
                
                return nueva;
                
        }
     
    }
    
    /**
     * Cambia el brillo de una imagen.
     * @param imagen La imagen a la que se le cambiará el brillo.
     * @param valor Porcentaje de cambio del brillo.
     * @return La nueva imagen con un cambio en el brillo.
     */
    public BufferedImage cambiarBrillo(BufferedImage imagen, int valor){

        BufferedImage nueva = new BufferedImage(
                imagen.getWidth(),imagen.getHeight(), 
                BufferedImage.TYPE_INT_RGB);
        
        Color rgb;

        int a, r, g, b;

        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){

                rgb = new Color(imagen.getRGB(x, y));

                a = rgb.getAlpha();
                r = rgb.getRed();
                g = rgb.getGreen();
                b = rgb.getBlue();
                
                /*El porcentaje de cambio de brillo se aplica 
                  sobre los valores de la imagen original.
                  Si el valor es positivo, se aumenta el brillo,
                  si es negativo, se reduce.*/
                
                r = (int)(r*(100 + valor)/100);
                g = (int)(g*(100 + valor)/100);
                b = (int)(b*(100 + valor)/100);
                
                if(r > 255){r = 255;}
                if(g > 255){g = 255;}
                if(b > 255){b = 255;}
                
                Color c = new Color(r, g, b, a);

                nueva.setRGB(x, y, c.getRGB());
                
            }
        }
        
        return nueva;
        
    }
    
    /**
     * Negativo de una imagen.
     * @param imagen La imagen a aplicarle el negativo.
     * @return Imagen en negativo.
     */
    public BufferedImage filtroNegativo(BufferedImage imagen){

        BufferedImage nueva = new BufferedImage(
                imagen.getWidth(),imagen.getHeight(), 
                BufferedImage.TYPE_INT_RGB);
        
        Color rgb;

        int a, r, g, b;

        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){

                rgb = new Color(imagen.getRGB(x, y));

                a = rgb.getAlpha();
                r = rgb.getRed();
                g = rgb.getGreen();
                b = rgb.getBlue();

                Color c = new Color(255-r, 255-g, 255-b, a);

                nueva.setRGB(x, y, c.getRGB());
                
            }
            
        }
        
        return nueva;
        
    }
    
    /**
     * Releja la imagen en el sentido deseado.
     * @param imagen La imagen a reflejar.
     * @param opcion Tipo de reflejado.
     * @return Imagen reflejada.
     */
    public BufferedImage reflejarImagen(BufferedImage imagen, String opcion){
        
        BufferedImage nueva = new BufferedImage(
            imagen.getWidth(),imagen.getHeight(), 
                     BufferedImage.TYPE_INT_RGB);
        
        //Tamño de la imagen.
        int height = imagen.getHeight();
        int width = imagen.getWidth();
        
        switch (opcion) {
   
            case "horizontal":
                
                for(int y = 0; y < height; y++){
                    for(int x = 0; x < width; x++){
                
                        nueva.setRGB(width-x-1, y, imagen.getRGB(x, y));
                
                    }
            
                }
        
                return nueva;
                
            case "vertical":
                
                for(int y = 0; y < height; y++){
                    for(int x = 0; x < width; x++){
                
                        nueva.setRGB(x, height-y-1, imagen.getRGB(x, y));
                
                    }
            
                }
                
                return nueva;
                
            /*El reflejo diagonal no es más que uno horizontal 
              seguido de uno vertical (o viceversa)*/
            default:
                
                for(int y = 0; y < height; y++){
                    for(int x = 0; x < width; x++){
                
                        nueva.setRGB(width-x-1, height-y-1, imagen.getRGB(x, y));
                
                    }
            
                }
        
                return nueva;
                
        }
        
    }
    
    /**
     * Filtro color sepia a una imagen.
     * @param imagen La imagen a la que se le aplicará el filtro.
     * @return La nueva imagen con el filtro aplicado.
     */
    public BufferedImage filtroSepia(BufferedImage imagen){

        BufferedImage nueva = new BufferedImage(
                imagen.getWidth(),imagen.getHeight(), 
                BufferedImage.TYPE_INT_RGB);
        
        Color rgb;

        int a, r, g, b;

        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){

                rgb = new Color(imagen.getRGB(x, y));

                a = rgb.getAlpha();
                r = rgb.getRed();
                g = rgb.getGreen();
                b = rgb.getBlue();
                
                if(r < 136){
                    r += 120;
                } else {
                    r = 255;
                }
                
                if(g < 196){
                    g += 60;
                } else {
                    g = 255;
                }

                Color c = new Color(r, g, b, a);

                nueva.setRGB(x, y, c.getRGB());
                
            }
        }
        
        return nueva;
        
    }
    
    /**
     * Filtro de luz negra a una imagen.
     * @param imagen La imagen a la que se le aplicará el filtro.
     * @return La nueva imagen con el filtro aplicado.
     */
    public BufferedImage luzNegra(BufferedImage imagen){

        BufferedImage nueva = new BufferedImage(
                imagen.getWidth(),imagen.getHeight(), 
                BufferedImage.TYPE_INT_RGB);
        
        Color rgb;

        int a, r, g, b;
        int intensidad = 4;
        int luminancia;

        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){

                rgb = new Color(imagen.getRGB(x, y));

                a = rgb.getAlpha();
                r = rgb.getRed();
                g = rgb.getGreen();
                b = rgb.getBlue();
                
                luminancia = (int)(0.3*r + 0.59*g + 0.11*b);
                
                r = intensidad*(r - luminancia);
                g = intensidad*(g - luminancia);
                b = intensidad*(b - luminancia);
                
                if(r < 0){r=0;}
                if(g < 0){g=0;}
                if(b < 0){b=0;}
                if(r > 255){r=255;}
                if(g > 255){g=255;}
                if(b > 255){b=255;}

                Color c = new Color(r, g, b, a);

                nueva.setRGB(x, y, c.getRGB());
                
            }
        }
        
        return nueva;
        
    }
    
    /**
     * Pixeleado de una imagen.
     * @param imagen La imagen a pixelear.
     * @param porcentaje Porcentaje de pixeleado.
     * @return La nueva imagen.
     */
    public BufferedImage pixelearImagen(BufferedImage imagen, int porcentaje){

        /*Se define el porcentaje de pixeleado como el inverso de
          los "pixeles" por lado que tendrá la nueva imagen.
          (Regiones con el mismo color)*/
        
        BufferedImage nueva = new BufferedImage(
                imagen.getWidth(),imagen.getHeight(), 
                BufferedImage.TYPE_INT_RGB);
        
        /*Cálculo del tamaño de las regiones 
          que se tornaran en un solo color.*/
        int tamanoVertical = (int)((porcentaje*imagen.getHeight())/100);
        int tamanoHorizontal = (int)((porcentaje*imagen.getWidth())/100);
        
        /*Si el porcentaje es cero o muy pequeño y los tamaños de las
          regiones se vuelven nulos, no se aplica filtro alguno y sólo
          se copia la imagen.*/
        if((tamanoVertical == 0) || (tamanoHorizontal == 0)){
        
            //Coloreado de la imagen original.
            for(int y = 0; y < imagen.getHeight(); y++){
                for(int x = 0; x < imagen.getWidth(); x++){

                    nueva.setRGB(x, y, imagen.getRGB(x, y));
                
                }
            }
            
            return nueva;
        
        }
        
        Color rgb;

        //Colores del pixel actual.
        int a, r, g, b;
        //Colores acumulados por todas los pixeles de la región.
        int aT, rT, gT, bT;
        //Cantidad de pixeles en cada región. 
        int pixeles;
        
        //Iteración a través de cada región.
        for(int y = 0; y < imagen.getHeight(); y += tamanoVertical){
            for(int x = 0; x < imagen.getWidth(); x += tamanoHorizontal){
                
                aT = 0;
                rT = 0;
                gT = 0;
                bT = 0;
                pixeles = 0;
                
                //Obtención de los colores de los pixeles en cada región.
                for(int v = 0; v < tamanoVertical; v++){
                    for(int u = 0; u < tamanoHorizontal; u++){
                        
                       if(((v + y) >= imagen.getHeight()) || 
                          ((u + x) >= imagen.getWidth())){
                           break;
                       }
                       
                       rgb = new Color(imagen.getRGB(u + x, v + y));

                        a = rgb.getAlpha();
                        r = rgb.getRed();
                        g = rgb.getGreen();
                        b = rgb.getBlue();

                        aT += a;
                        rT += r;
                        gT += g;
                        bT += b;
                        
                        pixeles++;
                        
                    }  
                }
                
                Color c = new Color((int)(rT/pixeles), 
                                    (int)(gT/pixeles), 
                                    (int)(bT/pixeles), 
                                    (int)(aT/pixeles));
                
                //Coloreado de igual color, de los pixeles de la región.
                for(int v = 0; v < tamanoVertical; v++){
                    for(int u = 0; u < tamanoHorizontal; u++){
                        
                        if(((v + y) >= imagen.getHeight()) || 
                           ((u + x) >= imagen.getWidth())){
                           break;
                        }

                        nueva.setRGB(u + x, v + y, c.getRGB());
                        
                    }  
                }
                    
            }
        }
        
        return nueva;
        
    }
    
    /**
     * Oculta un código en la imagen dada.
     * @param imagen Imagen dada.
     * @param codigo Codigo a ocultar.
     * @return Imagen con el código oculto.
     */
    public BufferedImage ocultarCodigo(BufferedImage imagen, String codigo){
        
        /*
         * Para introducir un código en la imagen, se marcarán ciertos
         * pixeles aleatorios de la imagen, para luego introducir el 
         * código en el pixel contiguo. Para no ensuciar el código, se
         * limpierán los pixeles de la imagen antes de marcarla, para
         * que no indiquen, erróneamente, que ahí hay código.
         */
        
        BufferedImage nueva = new BufferedImage(
                imagen.getWidth(),imagen.getHeight(), 
                BufferedImage.TYPE_INT_RGB);
        
        Color rgb, c;

        int a, r, g, b;
        
        //Coloreado de la imagen original y limpia de pixeles.
        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){

                if(this.pixelMarcado(imagen, x, y)){

                    rgb = new Color(imagen.getRGB(x, y));
                    
                    a = rgb.getAlpha();
                    r = rgb.getRed();
                    g = rgb.getGreen();
                    b = rgb.getBlue();
                    
                    c = new Color(r, g - 1, b, a);

                    nueva.setRGB(x, y, c.getRGB());
                    
                } else {
                    
                    rgb = new Color(imagen.getRGB(x, y));
                    nueva.setRGB(x, y, rgb.getRGB());
                    
                }
                
            }
        }
        
        //Posiciones donde se ocultará el código.
        ArrayList<Integer> posiciones = new ArrayList<>
                        ((int)(codigo.length()/3 + 1));
        
        //Caracter actual del código.
        int caracter = 0;
        //Posición donde se colocará el carácter.
        int posicion = 0;
        //Pixel actual.
        int pixel = 0;
        
        //Elección de pixeles aleatorios para incrustar el código.
        for(int i = 0; i < (int)(codigo.length()/3 + 1); i++){
        
            posicion = (int)(Math.random()*
            imagen.getHeight()*(imagen.getWidth() - 1));
            
            if(posiciones.contains(posicion) ||
               posiciones.contains(posicion + 1) ||
               posiciones.contains(posicion + imagen.getWidth()) || 
               posiciones.contains(posicion + imagen.getWidth() + 1)){
            
                i--;
                continue;
            
            }
            
            posiciones.add(posicion);
        
        }
        
        /*Se recorre la imagen para añadir 
          el código en los pixeles seleccionados.*/
        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){

                if(posiciones.contains(pixel)){
                    
                    //Modificación de los pixeles guía.
                    
                    /*El método usado para marcar los pixeles es, 
                      alterar el pixel elegido aletoriamente, el 
                      de la derecha y el de "abajo" (x, y+1), para ser 
                      leídos con los dígitos en que terminan sus compo-
                      nentes de cada color, para luego
                      insertar el código en el pixel con las coordenadas
                      (x+1, y+1).*/
                    
                    rgb = new Color(imagen.getRGB(x, y));
                    
                    r = rgb.getRed();
                    g = rgb.getGreen();
                    b = rgb.getBlue();
                    
                    c = new Color(r - (r%10) + 3, g - (g%10) + 4, b - (b%10) + 5, 255);
                    
                    nueva.setRGB(x, y, c.getRGB());
                    
                    rgb = new Color(imagen.getRGB(x + 1, y));
                    
                    r = rgb.getRed();
                    g = rgb.getGreen();
                    b = rgb.getBlue();
                    
                    c = new Color(r - (r%10) + 5, g - (g%10) + 4, b - (b%10) + 3, 255);
                    
                    nueva.setRGB(x + 1, y, c.getRGB());
                    
                    rgb = new Color(imagen.getRGB(x, y + 1));
                    
                    r = rgb.getRed();
                    g = rgb.getGreen();
                    b = rgb.getBlue();
                    
                    c = new Color(r - (r%10) + 5, g - (g%10) + 3, b - (b%10) + 4, 255);
                    
                    nueva.setRGB(x, y + 1, c.getRGB());
                    
                    //Modificación del pixel con un trozo de código.
                    rgb = new Color(imagen.getRGB(x + 1, y + 1));
                    
                    a = rgb.getAlpha();
                    
                    if(caracter < codigo.length()){
                        r = (int)(codigo.charAt(caracter));
                        caracter++;
                    } else {                
                        r = 32; 
                    }
                    
                    if(caracter < codigo.length()){
                        g = (int)(codigo.charAt(caracter));
                        caracter++;  
                    } else {
                        g = 32; 
                    }
                    
                    if(caracter < codigo.length()){
                        b = (int)(codigo.charAt(caracter));
                        caracter++;
                    } else {
                        b = 32;
                    }
                    
                    if(r>255){r=32;}
                    if(g>255){g=32;}
                    if(b>255){b=32;}
                    
                    c = new Color(r, g, b, a);
                    
                    nueva.setRGB(x + 1, y + 1, c.getRGB());
                    
                }
               
                pixel++;
                
            }        
        }
        
        return nueva;
            
    }

    
    /**
     * Mostrar un código oculto en la imagen dada.
     * @param imagen Imagen dada.
     * @return Mensaje oculto.
     */
    public String mostrarCodigo(BufferedImage imagen){
        
        Color rgb;
        String cadena = "";

        int a, r, g, b;
        
        int pixel = 0;

        /*Búsqueda en la imagen de pixeles marcados para poder 
          extraer la información.*/
        
        for(int y = 0; y < imagen.getHeight(); y++){
            for(int x = 0; x < imagen.getWidth(); x++){

                if(this.pixelMarcado(imagen, x, y)){
                    
                    rgb = new Color(imagen.getRGB(x + 1, y + 1));

                    r = rgb.getRed();
                    g = rgb.getGreen();
                    b = rgb.getBlue();
                    
                    //Reunión del mensaje.
                    
                    cadena += String.format("%s%s%s",(char)(r), 
                                          (char)(g), (char)(b));
                    
                }
                
                pixel++;
                
            }
            
        }

        return  cadena;
    
    }
    
    /**
     * Verifica si los pixeles de una imagen está marcados (código).
     * @param imagen Imagen en donde buscar.
     * @param x Coordenada horizontal del pixel.
     * @param y Coordenada vertical del pixel.
     * @return Revisa si el pixel está marcado.
     */
    public boolean pixelMarcado(BufferedImage imagen, int x, int y){
        
        if((x >= imagen.getWidth() - 1) || (y >= imagen.getHeight() - 1)){
            
            return false;
            
        }
        
        Color rgb;
        
        int a, r, g, b;
        
        /*Si el pixel actual, el de abajo y el de a lado están marcados,
          es porque el de abajo y a lado tiene un pedazo de código*/
        
        rgb = new Color(imagen.getRGB(x, y));

                a = rgb.getAlpha();
                r = rgb.getRed();
                g = rgb.getGreen();
                b = rgb.getBlue();

                if(((r % 10) == 3) && ((g % 10) == 4) && 
                    ((b % 10) == 5) && (a == 255)){
                    
                    rgb = new Color(imagen.getRGB(x + 1, y));

                    a = rgb.getAlpha();
                    r = rgb.getRed();
                    g = rgb.getGreen();
                    b = rgb.getBlue();
                    
                    if(((r % 10) == 5) && ((g % 10) == 4) && 
                       ((b % 10) == 3) && (a == 255)){
                        
                        rgb = new Color(imagen.getRGB(x, y + 1));

                        a = rgb.getAlpha();
                        r = rgb.getRed();
                        g = rgb.getGreen();
                        b = rgb.getBlue();
                        
                        if(((r % 10) == 5) && ((g % 10) == 3) && 
                           ((b % 10) == 4) && (a == 255)){
                   
                            return true;
                    
                        }
                        
                    }
                        
                }
        
        return false;
    
    }
    
}
