package practica2;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * En esta clase implementaran los metodos para cada filtro.
 * 
 * @author usr
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
     * Aplica el filtro tonos de gris en la mitad de una imagen.
     * @param imagen La imagen a la que le aplicaremos el filtro.
     * @param opcion Mitad en que aplicará el filtro.
     * @return La nueva imagen con el filtro aplicado.
     */
    public BufferedImage tonosDeGrisMitad(BufferedImage imagen, String opcion){
        
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
                inf = (int)(imagen.getHeight()/2);
                izq = 0;
                der = imagen.getWidth();
                
                break;
                
            case "inf":
            
                sup = (int)(imagen.getHeight()/2);
                inf = imagen.getHeight();
                izq = 0;
                der = imagen.getWidth();
                
                break;
                
            case "izq":
                
                sup = 0;
                inf = imagen.getHeight();
                izq = 0;
                der = (int)(imagen.getWidth()/2);
                
                break;
                
            default:
                
                sup = 0;
                inf = imagen.getHeight();
                izq = (int)(imagen.getWidth()/2);
                der = imagen.getWidth();
                
                break;
                
        }

        Color rgb;
        
        int a, r, g, b;

        //Coloreado de gris en la parte deseada de la imagen.
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
     * Aumento de brillo a una imagen.
     * @param imagen La imagen a la que se le aumentará el brillo.
     * @return La nueva imagen más brillante.
     */
    public BufferedImage aumentarBrillo(BufferedImage imagen){

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
                
                if(r < 246){
                    r += 10;
                } else {
                    r = 255;
                }
                
                if(g < 246){
                    g += 10;
                } else {
                    g = 255;
                }
                
                if(b < 246){
                    b += 10;
                } else {
                    b = 255;
                }

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
    
}
