/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author Priyansh
 */
public class Que1 {

    /**
     * @param args the command line arguments
     */
    static Boy boy[]=new Boy[9];/**Array of Object for Boys*/
    static Girl girl[]=new Girl[6];/**Array of Object for Girls*/
    static int a,b;
    
    public static void main(String[] args) {
        try {
            
            a=0;
            File fl=new File("boy.csv");
            BufferedReader br= new BufferedReader(new FileReader(fl));
            String str;
            str=br.readLine();
            while(str!=null){
                
                String bf[]=str.split(",");
                boy[a]=new Boy();
                
                boy[a].name=bf[0];
                boy[a].att=Integer.parseInt(bf[1]);
                boy[a].iq=Integer.parseInt(bf[2]);
                boy[a].budget=Double.parseDouble(bf[3]);
                boy[a].min_att=Integer.parseInt(bf[4]);
                boy[a].gf=bf[5];
                boy[a].stat=bf[6];
                
               //System.out.println(str);
                a++;
                str=br.readLine();
                
            }
            br.close();
        }
        catch (Exception e){
                System.out.println(e.getMessage());
        }
        try {
            
            b=0;
            File fl=new File("girl.csv");
            BufferedReader br= new BufferedReader(new FileReader(fl));
            String str;
            str=br.readLine();
            while(str!=null){
                String gf[]=str.split(",");
                Girl[] g;
                girl[b]=new Girl();
                girl[b].name=gf[0];
                girl[b].att=Integer.parseInt(gf[1]);
                girl[b].iq=Integer.parseInt(gf[2]);
                girl[b].main_bud=Double.parseDouble(gf[3]);
                girl[b].bf=gf[4];
                girl[b].stat=gf[5];
                //System.out.println(str);
                str=br.readLine();
                b++;
            }
            br.close();
        }
        catch (Exception e){
                System.out.println(e.getMessage());
        }
        check(boy,girl);
         
    }
  
   
   

   static void check(Boy[] boy, Girl[] girl) {
        int i,j;
         // System.out.println(boy[0].name);
        for (i=0;i<boy.length;i++){
            for(j=0;j<girl.length;j++){
               if(boy[i].budget>=girl[j].main_bud && boy[i].min_att<=girl[j].att && boy[i].stat.equals("single")&&girl[j].equals("single") ){
                    boy[i].gf=girl[j].name;
                    girl[j].bf=boy[i].name;
                    boy[i].stat=girl[j].stat="committed";
                    
                    System.out.println(boy[i].name+"is committed with"+girl[j].name);
                }
            
            }
        }
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

   
