/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endecription;

/**
 *
 * @author Chathura
 */
public class DeCrpt {
    
    EnCrpt fn = new EnCrpt();
        public String extFromKey(String s,int key){
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
    public String bkToNormal(String s){    // a replace by 15th char from a,thatz mean p
    
        char[] oldChar = s.toCharArray();
        char[] newChar = new char[oldChar.length];
        for(int i=0;i<oldChar.length;i++){
            int ch = (int) oldChar[i];
            if (ch == 10){
                newChar[i] = oldChar[i];
            }
            else if ((int)oldChar[i]>46){
                newChar[i] = (char) (oldChar[i] - 15);
            }
            else{
                    newChar[i] = (char) (127 - (15 - ((oldChar[i] - 32)))); //32 to 127
            }
        }

        String rep = new String(newChar);
        return rep;
    
    }
    
    public String readLines(javax.swing.JTextArea jTextArea,int key){

        String s,msg = "";
        System.out.println(key);
        String[] arr1 = jTextArea.getText().split("\\.");
        String[] arr2 = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            s = fn.transpos(this.extFromKey(jTextArea.getText(),key));
            arr2[i] = this.bkToNormal(s);
        }
        for (int b = 0; b < arr2.length; b++){
        
            msg = msg + arr2[b] + ".";
        
        }
        return msg;
    }
}
