/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endecription;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Chathura
 */
public class EnCrpt {
    
    
    public void readTxt(String path,javax.swing.JTextArea txtBox) throws FileNotFoundException{
            
        FileReader file = new FileReader(path);
        BufferedReader bf = null;
        String line;
        try {
            bf = new BufferedReader(file);
        } catch (Exception e) {
            System.out.println("file not found");
            System.exit(0);
        }
        try {
            while ((line = bf.readLine()) != null) {
                txtBox.append(line + "\n");
            }
        } catch (IOException iOException) {
            System.out.println(iOException);
        }
    }
    public String replace(String s){    // a replace by 15th char from a,thatz mean p
    
        char[] oldChar = s.toCharArray();
        char[] newChar = new char[oldChar.length];
        for(int i=0;i<oldChar.length;i++){
            int ch = (int) oldChar[i];
            if (ch == 10){
                newChar[i] = oldChar[i];
            }
            else if ((int)oldChar[i]<112){
                newChar[i] = (char) (oldChar[i] + 15);
            }
            else{
                    newChar[i] = (char) ((oldChar[i] + 15)-127 + 32); //32 to 127
            }
        }

        String rep = new String(newChar);
        return rep;
    
    }
    public String transpos(String line){  //reverse the tokens
    
        String enil1 = new StringBuffer(line).reverse().toString();
        
        return enil1;
    }
    
    public int cnvrtKey(String s1){
    
        char[] ch = s1.toCharArray();
        int key = 0,ascii,asciiL,count = 0 ;
        String s = "";
        asciiL = (int) ch[ch.length-1];
        for(int j = 0; j < Integer.toBinaryString(asciiL).length();j++){    // counting #of 1's in binary form of last char
            if(Integer.toBinaryString(asciiL).charAt(j) == '1'){
                count++;
            }
        }
        for(int i = 0; i < ch.length -1; i++){
        
            ascii = (int) ch[i];
            s = s + Integer.toBinaryString(ascii).charAt(count);
        }
        return key = Integer.parseInt(s, 2);

    }
    public String cmbineWithKey(String s,int key){
        String s1 = "";
        int ke=0,a = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            ke = (int) ch[i];
                a = ke ^ key;
                ch[i] = (char) a;
            
        }
        return s1 = String.valueOf(ch);

    }
    

    
    public String readLines(javax.swing.JTextArea jTextArea,int key){

        int x = key ^ 61;
        String s,msg = "";
        String str = jTextArea.getText();
        if(str.charAt(str.length()-1) != '\n'){
            str = str + '\n';
        }
        String[] arr1 = str.split(Character.toString((char) x));
        String[] arr2 = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            s = this.transpos(this.replace(arr1[i]));
            arr2[i] = this.cmbineWithKey(s,key);
        }
        for (int b = 0; b < arr2.length; b++){
        
            msg = msg + arr2[b] + ".";
        
        }
        return msg.substring(1, msg.length()-1);
    }
    
}
