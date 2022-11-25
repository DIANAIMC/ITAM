/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraproyecto;

/**
 *
 * @author dianam
 */
public class Caratula1 extends javax.swing.JFrame {
    private String ecuacion;
    private double num;
    /**
     * Creates new form Caratula
     */
    public Caratula1() {
        super("Calculadora");
        initComponents();
        setSize(500,500);
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    
    //Después de dar un resultado, al picar una tecla, eliminar este
    //boton deletep
    
    /**
     * Método que determina la jerarquía de un operador.
     * @param simb pila que contiene los simbolos de los operadores.
     * @param post pila que contiene la expresion postfija.
     * @param sig String que representa el simbolo del operador con el que se va a comparar.
     */
    public static void jerarquiaOperaciones(ArrayStack<String> simb,ArrayStack<String> post,String sig){ 
        if(!post.isEmpty())
            switch(sig){
                case"x": 
                    if(post.peek().equals("x") || post.peek().equals("÷"))
                        while(!post.isEmpty() &&(post.peek().equals("x") || post.peek().equals("÷")) && !post.peek().equals("(") )
                            simb.push(post.pop());
                    break;
                case"÷":
                    if(post.peek().equals("x") || post.peek().equals("÷") && !post.peek().equals("("))
                        while(!post.isEmpty())
                            simb.push(post.pop());
                    break;
                default:
                    while(!post.isEmpty() && !post.peek().equals("("))
                        simb.push(post.pop());
                    break; 
            }
        }
     
    /**
     * Método destructivo que recibe una cadena infija de tipo String, que representa una ecuacion, y pasa la expresion de infija a postfija. 
     * Se hace uso de la función split, para que vacie el contenido de la infija en una arreglo. 
     * Se va checando cada casilla del arreglo y realizando las operaciones segun el símbolo que sea. 
     * @param infija String que representa una ecuacion o expresion que se encuentra en forma infija. 
     * @return res String en forma postfija
     */
    
    public static String InfijaPostfija(String infija){
        String res=" ";
        
        //Con la funcion split se introduce el contenido de una cadena en un arreglo y se usa como parametro el tipo de simbolo que elimina de la cadena
        //Esto se realiza para separar los terminos.
        String[] arre=infija.split("\\s");
        int i=0;
        int pot=0;
        ArrayStack<String> signos=new ArrayStack();
        ArrayStack<String> posfija=new ArrayStack();
        
        //En el ciclo se va revisando el arreglo y se van asignando las operaciones pertinentes, segun el simbolo que sea.
        while(i<arre.length){
            switch(arre[i]){
                case"(": 
                    signos.push(arre[i]);
                    break;
                case")": 
                    while(!signos.isEmpty() && !signos.peek().equals("(")){
                       
                        posfija.push(signos.pop());  
                    }
                    signos.pop();
                    break;
                case"x":
                    jerarquiaOperaciones(posfija,signos,"x");
                    signos.push(arre[i]);
                    break;
                case"÷":
                    jerarquiaOperaciones(posfija,signos,"÷");
                    signos.push(arre[i]);
                    break;
                case"+":
                    jerarquiaOperaciones(posfija,signos,"+");
                    signos.push(arre[i]);
                    break;
                case"-":
                    jerarquiaOperaciones(posfija,signos,"-");
                    signos.push(arre[i]);
                    break;   
                default:
                    posfija.push(arre[i]);
                    if(pot!=0){
                        posfija.push(signos.pop());
                        pot--;
                    }
                    break;
            }
            i++;
        }
        
        //Se termina de vaciar la pila de signos para terminar la notacion posfija.
        while(!signos.isEmpty())
            posfija.push(signos.pop());
        
        //Se voltea la pila posfija para poder tener el primer temrino hasta arriba.
        while(!posfija.isEmpty())
            signos.push(posfija.pop());
        
        //Se van sacando los elementos de la pila, mientras se concatenan a una cadena, para regresar la ecuacion original en forma posfija.
        while(!signos.isEmpty())
            res= res+signos.pop()+" ";

        return res;    
    }

    /**
     *Metodo que recibe una cadena de tipo String, que se encuentra de forma infija, y revisa que la infija tenga un balanceo correcto de signos.
     * El metodo descarta posibles errores de sintaxis como: operadores juntos, signos al final o al inicio de la expresion, etc. 
     * @param infija String que representa una ecuacion o expresion, en forma infija. 
     * @return boolean res, true si el numero de signos es valido y false si no lo es.
     */
    public static boolean revisaSignos(String infija){
        boolean res=true;
        boolean prim=false, sec=false;
        String[] arre=infija.split("\\s");
        int i=1;
        int x=0;
        int c=arre.length-1;
        
        //Comienza discriminando el caso en que el primer termino de la ecaucion o el ultimo sean operadores.
        if((arre[x].equals("+") || arre[x].equals("-") || arre[x].equals("x") || arre[x].equals("÷")) ||
            (arre[c].equals("+") || arre[c].equals("-") || arre[c].equals("x") || arre[c].equals("÷")))
            res=false;
        
        //En caso contrario 
        else{
            
            //Se recorre el arreglo y si se encuentra algun caso en que se encuentren 2 operadores juntos se sale del ciclo.
            while(i<arre.length && !prim && !sec){
                
                //Se comienza el ciclo en la segunda posicion del arreglo, checando si el anterior elemento es un operador y si esto se cumple 
                // cambia la variable auxiliar a true.
                if(arre[x].equals("+") || arre[x].equals("-") || arre[x].equals("x") || arre[x].equals("÷"))
                    prim=true;
                if(arre[i].equals("+") || arre[i].equals("-") || arre[i].equals("x") || arre[i].equals("÷"))
                    sec=true;
                
                //En caso de que alguna de las dos sea falsa se reinician las auxiliares en falso, sino se sale del ciclo.
                if(prim==false || sec==false){
                    prim=false;
                    sec=false;
                }
                i++;
                x++;
            }
                
            // Por ultimo se comprueba si se salio antes de terminar de recorrer el arreglo para modificar o no el boolean.
            if(i<arre.length)
                res=false;
        }
        return res;
    }

    /**
     *Metodo que evalua una expresion, posfija, para poder hacer las operaciones correspondientes y asi devolver un valor numerico.
     * @param posfija String que representa una expresion en forma posfija.
     * @return double que representa el valor de la expresion dada como parametro. 
     */
   public static double resuelveEcuacion(String posfija){
       double res;
       double aux1,aux2;
       String[] arre=posfija.split("\\s");
       ArrayStack<String> ecuacion=new ArrayStack();
       ArrayStack<String> ecuacion1=new ArrayStack();
       
        //Primeramente se llena una pila con los datos del arreglo.
        for (String arre1 : arre) {
            ecuacion.push(arre1);
        }
       
       //Se invierte la pila para tener la ecuacion como era originalmente
       while(!ecuacion.isEmpty()){
           ecuacion1.push(ecuacion.pop());
       }
       
       //Mientras la pila no este vacia va a realizar las operaciones pertinentes.
       while(!ecuacion1.isEmpty()){
           
           //Si el primer termino de la pila no es un operador se mete en otra pila.
           if(!ecuacion1.peek().equals("+") && !ecuacion1.peek().equals("-") && !ecuacion1.peek().equals("x") &&
                   !ecuacion1.peek().equals("÷")){
              ecuacion.push(ecuacion1.pop());
           }
           
           //De lo contrario se sacan los dos primeros terminos de la segunda pila y se realiza el caso que inda la pila original
           //guardando el resultado en la seugnda pila.
           else{
               aux1=Double.parseDouble(ecuacion.pop());
               
               aux2=Double.parseDouble(ecuacion.pop());
               
                switch(ecuacion1.peek()){
                    
                    case "+":
                        res=aux1+aux2;
                        ecuacion.push(res+"");
                        break;
                    case "-":
                        res=aux2-aux1;
                        ecuacion.push(res+"");
                        break;
                     case "x":
                        res=aux1*aux2;
                        ecuacion.push(res+"");
                        break;
                     case "÷":
                        res=aux2/aux1;
                        ecuacion.push(res+"");
                        break;
                }
                ecuacion1.pop();
           }
           
       }
       
       //Finalmente se saca el unico temrino de la segunda pila que es el resultado final
       res=Double.parseDouble(ecuacion.pop());
       return res;
   }
   
    /**
     *Metodo que revisa que en la expresion dada tenga un equilibrio de parentesis.
     * @param infija Sting de una expersion que se encuentra en forma infija.
     * @return boolean que regresa true si el balanceo de parentesis es correcto, si no regresa false.
     */
    public static boolean analisisParentesis(String infija){
        ArrayStack<String> pila=new ArrayStack();
        String[] arre=infija.split("\\s");
        int i=0;
        int a=0,b=0;
        String temp;
        boolean res=false,aux=true;
        while(i<arre.length && aux){
            if(arre[i].equals("(")){
                pila.push("(");
                temp="(";
                a=i;
            }
            else if(arre[i].equals(")")){
                if(a==i-1){
                    aux=false;
                }
                else if(!pila.isEmpty() && pila.peek().equals("("))
                    pila.pop();
                else
                    aux=false;
            }
            i++;
        }
        if(pila.isEmpty() && aux)
            res=true;
        return res;
                    
                    
    }
    
    
    public void enableOperators(boolean res){
        btnSum.setEnabled(res);
        btnMult.setEnabled(res);
        btnDiv.setEnabled(res);
        btnRest.setEnabled(res);
        btnPt.setEnabled(res);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnIgual = new javax.swing.JButton();
        btnSum = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnMult = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btnRest = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        btnPard = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnPari = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnPt = new javax.swing.JButton();
        btnCsig = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });

        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnIgual.setText("=");
        btnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualActionPerformed(evt);
            }
        });

        btnSum.setText("+");
        btnSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumActionPerformed(evt);
            }
        });

        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnMult.setText("x");
        btnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultActionPerformed(evt);
            }
        });

        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnDiv.setText("÷");
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });

        btnRest.setText("—");
        btnRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestActionPerformed(evt);
            }
        });

        jButton9.setText("9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setText("8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton0.setText("0");
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });

        btnPard.setText(")");
        btnPard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPardActionPerformed(evt);
            }
        });

        jButton7.setText("7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btnPari.setText("(");
        btnPari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPariActionPerformed(evt);
            }
        });

        btnDel.setText("DEL");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnPt.setText(".");
        btnPt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPtActionPerformed(evt);
            }
        });

        btnCsig.setText("(-)");
        btnCsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCsigActionPerformed(evt);
            }
        });

        jLabel1.setText("BIENVENIDO A TU CALCULADORA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPari, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnPard, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRest, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSum, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCsig, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCsig, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"1");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultActionPerformed
       enableOperators(false);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+" x ");
    }//GEN-LAST:event_btnMultActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"2");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"3");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"4");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"0");
    }//GEN-LAST:event_jButton0ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"5");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"6");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"7");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"8");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       enableOperators(true);
       ecuacion=txt1.getText();
       txt1.setText(ecuacion+"9");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnPariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPariActionPerformed
        ecuacion=txt1.getText();
        txt1.setText(ecuacion+"( ");
    }//GEN-LAST:event_btnPariActionPerformed

    private void btnPardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPardActionPerformed
        ecuacion=txt1.getText();
        txt1.setText(ecuacion+") ");
    }//GEN-LAST:event_btnPardActionPerformed

    private void btnSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumActionPerformed
        enableOperators(false);
        ecuacion=txt1.getText();
        txt1.setText(ecuacion+" + ");
    }//GEN-LAST:event_btnSumActionPerformed

    private void btnRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestActionPerformed
        enableOperators(false);
        ecuacion=txt1.getText();
        txt1.setText(ecuacion+" - ");
    }//GEN-LAST:event_btnRestActionPerformed

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivActionPerformed
        enableOperators(false);
        ecuacion=txt1.getText();
        txt1.setText(ecuacion+" ÷ ");
    }//GEN-LAST:event_btnDivActionPerformed

    private void btnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualActionPerformed
    if(analisisParentesis(txt1.getText()))
        if(revisaSignos(txt1.getText())){
            try{
                ecuacion =InfijaPostfija(txt1.getText());
                num=resuelveEcuacion(ecuacion);
                txt1.setText(num+"");
            }
            catch(Exception e){
            txt1.setText("Error en sintaxis o la ecuacion esta vacia");
            }
        }
        else
            txt1.setText("Error en balanceo de signos");
    else
        txt1.setText("Error en balanceo de parentesis");                                            

    }//GEN-LAST:event_btnIgualActionPerformed

    private void btnPtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPtActionPerformed
        enableOperators(false);
        ecuacion=txt1.getText();
        txt1.setText(ecuacion+".");
    }//GEN-LAST:event_btnPtActionPerformed

    private void btnCsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCsigActionPerformed
        ecuacion=txt1.getText();
        txt1.setText(ecuacion+"-");
    }//GEN-LAST:event_btnCsigActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        txt1.setText("");
    }//GEN-LAST:event_btnDelActionPerformed

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caratula1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Caratula1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCsig;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnIgual;
    private javax.swing.JButton btnMult;
    private javax.swing.JButton btnPard;
    private javax.swing.JButton btnPari;
    private javax.swing.JButton btnPt;
    private javax.swing.JButton btnRest;
    private javax.swing.JButton btnSum;
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt1;
    // End of variables declaration//GEN-END:variables
}

