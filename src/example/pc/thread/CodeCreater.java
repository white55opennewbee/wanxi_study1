package example.pc.thread;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CodeCreater {
    public String getCode(){
        //code源去除1,0和I,O；
        String codeSource = "QWERTYUPASDFGHJKLZXCVBNM23456789";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i<4;i++){
            buffer.append(codeSource.charAt(random.nextInt(codeSource.length())));
        }
        return buffer.toString();
    }

    public BufferedImage changeToBufferedImage(String code){
        Random random = new Random();
        BufferedImage image = new BufferedImage(75,28,BufferedImage.TYPE_INT_RGB);
        Graphics graphic = image.getGraphics();

        graphic.setColor(new Color(240,240,240));

        graphic.fillRect(0,0,75,28);
        graphic.setFont(new Font("宋体",Font.BOLD,16));

        graphic.setColor(new Color(0,0,0));

        for(int i = 0 ;i<4;i++){
            graphic.setColor(new Color(random.nextInt(120),random.nextInt(120),random.nextInt(120)));
            graphic.drawString(code.charAt(i)+"",16*i+random.nextInt(16),15+random.nextInt(10));
            if(i % 2 == 0) {//画线
                graphic.setColor(new Color(random.nextInt(120), random.nextInt(120), random.nextInt(120)));
                graphic.drawLine(random.nextInt(75), random.nextInt(28), random.nextInt(75), random.nextInt(28));
            }

        }
        return image;
    }

}
