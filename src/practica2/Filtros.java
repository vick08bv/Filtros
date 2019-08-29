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
    
}
