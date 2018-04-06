package histogramas;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.jfree.ui.RefineryUtilities;


public class Main {
    public static void main(String[] args) throws IOException{
    	
    	JFileChooser Destino = new JFileChooser();
    	Destino.setDialogTitle("Selecione a imagem para análise...");
    	Destino.showOpenDialog(Destino);
    	File file = new File(Destino.getSelectedFile().getAbsolutePath());
        BufferedImage img = ImageIO.read(file);
        int width = img.getWidth();
        int height = img.getHeight();
        int CountAll = 0;
        int CountPreto = 0;
        int CountBranco = 0;
        int CountCinza = 0;
        int CountCinzaEscuro = 0;
        int CountCinzaClaro = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
            	Color Pixel = new Color(img.getRGB(i, j));
            	
            	 if((Pixel.getRed() == Pixel.getGreen()) && (Pixel.getRed() == Pixel.getBlue())){
            		 
            		 if(Pixel.getRed() == 0){
            			 CountPreto++;
            		 } else if (Pixel.getRed() >= 1 && Pixel.getRed() < 85){
            			 CountCinzaEscuro++;
            		 } else if (Pixel.getRed() >= 85 && Pixel.getRed() < 170){
            			 CountCinza++;
            		 } else if (Pixel.getRed() >= 170 && Pixel.getRed() < 255){
            			 CountCinzaClaro++;
            		 } else if (Pixel.getRed() == 255){
            			 CountBranco++;            		 }
            		 
 
            	CountAll++;                    
               }

            }
        }
     
        System.out.println("Quantidade de pixels em escala Preto e Branco: " + CountAll 
        		+ "\nQuantidade de pixels pretos: " + CountPreto
        		+ "\nQuantidade de pixels cinza escuros: " + CountCinzaEscuro
        		+ "\nQuantidade de pixels cinzas: " + CountCinza
        		+ "\nQuantidade de pixels cinza claros: " + CountCinzaClaro
        		+ "\nQuantidade de pixels brancos: " + CountBranco
        		
        		);
        
      //Gerando Histograma
        BarChart chart = new BarChart("Dados da imagem selecionada", "Escala de cinza da imagem", CountPreto, CountCinzaEscuro, CountCinza, CountCinzaClaro, CountBranco);
        chart.pack( );        
        RefineryUtilities.centerFrameOnScreen( chart );        
        chart.setVisible( true );
        
        //Gerando gráfico de pizza
//        PieChart demo = new PieChart("Escala de Cinza", "Escala de cinza da imagem selecionada", CountPreto, CountBranco, CountCinza);
//        demo.pack();
//        demo.setVisible(true);
        
      

    }
}
