/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author dianam
 */
public class Calculadora extends javax.swing.JFrame {
    private String ecuacion;
    private double num;
    //private boolean resp;
    /**
     * Creates new form Calculadora
     */
    public Calculadora() {
        super("Calculadora");
        initComponents();
        setSize(500,500);
        this.setLocationRelativeTo(null);
        setResizable(false);
        //setIconImage(new ImageIcon(getClass().getResource("/images/icono2.png")).getImage());
    }
     
    /**
     * Metodo que determina la jerarquia de un operador. 
     * @param orig pila que contiene los simbolos de los operadores.
     * @param oc pila que contiene la expresion postfija.
     * @param signo String que representa el simbolo del operador con el que se va a comparar.
     */
        public static void resuelveJerarquia(ArrayStack<String> orig,ArrayStack<String> oc,String signo){
            //ArrayStack<String> aux=new ArrayStack();
           if(!oc.isEmpty())
                switch(signo){
                    case"*": 
                        if(oc.peek().equals("*") || oc.peek().equals("/"))
                            while(!oc.isEmpty() &&(oc.peek().equals("*") || oc.peek().equals("/")) && !oc.peek().equals("(") )
                                orig.push(oc.pop());
                        break;
                    case"/":
                        if(oc.peek().equals("*") || oc.peek().equals("/") && !oc.peek().equals("("))
                            while(!oc.isEmpty())
                                orig.push(oc.pop());
                        break;
                    default:
                        while(!oc.isEmpty() && !oc.peek().equals("("))
                            orig.push(oc.pop());
                        break; 
                } 
        }
    
     /**
     * Metodo destructivo que recibe una cadena de tipo String, que representa una ecuacion, y pasa la expresion de infija a postfija. 
     * Se hace uso de la funcion split, para que vacie el contenido de la cadena en una arreglo. 
     * Se va checando cada casilla del arreglo y realizando las operaciones segun el simbolo que sea. 
     * @param cadena String que representa una ecuacion o expresion que se encuentra en forma infija. 
     * @return cadena String en forma postfija. 
    */   
    public static String InfijaPostfija(String cadena){
        String resp=" ";
        
        //Con la funcion split se introduce el contenido de una cadena en un arreglo y se usa como parametro el tipo de simbolo que elimina de la cadena
        //Esto se realiza para separar los terminos.
        String[] arre=cadena.split("\\s");
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
                case"^":
                    signos.push(arre[i]);
                    pot++;
                    break;
                case"*":
                    resuelveJerarquia(posfija,signos,"*");
                    signos.push(arre[i]);
                    break;
                case"/":
                    resuelveJerarquia(posfija,signos,"/");
                    signos.push(arre[i]);
                    break;
                case"+":
                    resuelveJerarquia(posfija,signos,"+");
                    signos.push(arre[i]);
                    break;
                case"-":
                    resuelveJerarquia(posfija,signos,"-");
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
            resp= resp+signos.pop()+" ";

        return resp;
    }

    /**
     *Metodo que recibe una cadena de tipo String, que se encuentra de forma infija, y revisa que la cadena tenga un balanceo correcto de signos.
     * El metodo descarta posibles errores de sintaxis como: operadores juntos, signos al final o al inicio de la expresion, etc. 
     * @param cadena String que representa una ecuacion o expresion, en forma infija. 
     * @return boolean resp, true si el numero de signos es valido y false si no lo es.
     */
    public static boolean revisaSignos(String cadena){
        boolean resp=true;
        boolean prim=false, sec=false;
        String[] arre=cadena.split("\\s");
        int i=1;
        int x=0;
        int c=arre.length-1;
        
        //Comienza discriminando el caso en que el primer termino de la ecaucion o el ultimo sean operadores.
        if((arre[x].equals("+") || arre[x].equals("-") || arre[x].equals("*") || arre[x].equals("/") ||
                        arre[x].equals("^")) || (arre[c].equals("+") || arre[c].equals("-") || 
                arre[c].equals("*") || arre[c].equals("/") || arre[c].equals("^")))
            resp=false;
        
        //En caso contrario 
        else{
            
            //Se recorre el arreglo y si se encuentra algun caso en que se encuentren 2 operadores juntos se sale del ciclo.
            while(i<arre.length && !prim && !sec){
                
                //Se comienza el ciclo en la segunda posicion del arreglo, checando si el anterior elemento es un operador y si esto se cumple 
                // cambia la variable auxiliar a true.
                if(arre[x].equals("+") || arre[x].equals("-") || arre[x].equals("*") || arre[x].equals("/") ||
                        arre[x].equals("^") )
                    prim=true;
                if(arre[i].equals("+") || arre[i].equals("-") || arre[i].equals("*") || arre[i].equals("/") ||
                        arre[i].equals("^") )
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
                resp=false;
        }
        return resp;
    }

    /**
     *Metodo que evalua una expresion, posfija, para poder hacer las operaciones correspondientes        y asi devolver un valor numerico.
     * @param cadena String que representa una expresion en forma posfija.
     * @return double que representa el valor de la expresion dada como parametro. 
     */
   public static double resuelveEcuacion(String cadena){
       double resp=0.0;
       double aux1,aux2;
       String[] arre=cadena.split("\\s");
       ArrayStack<String> ecuacion=new ArrayStack();
       ArrayStack<String> ecuacion1=new ArrayStack();
       
       //Primeramente se llena una pila con los datos del arreglo.
       for(int i=0;i<arre.length;i++)
           ecuacion.push(arre[i]);
       
       //Se invierte la pila para tener la ecuacion como era originalmente
       while(!ecuacion.isEmpty()){
           ecuacion1.push(ecuacion.pop());
       }
       
       //Mientras la pila no este vacia va a realizar las operaciones pertinentes.
       while(!ecuacion1.isEmpty()){
           
           //Si el primer termino de la pila no es un operador se mete en otra pila.
           if(!ecuacion1.peek().equals("+") && !ecuacion1.peek().equals("-") && !ecuacion1.peek().equals("*") &&
                   !ecuacion1.peek().equals("/") && !ecuacion1.peek().equals("^")){
              ecuacion.push(ecuacion1.pop());
           }
           
           //De lo contrario se sacan los dos primeros terminos de la segunda pila y se realiza el caso que inda la pila original
           //guardando el resultado en la seugnda pila.
           else{
               aux1=Double.parseDouble(ecuacion.pop());
               
               aux2=Double.parseDouble(ecuacion.pop());
               
                switch(ecuacion1.peek()){
                    
                    case "+":
                        resp=aux1+aux2;
                        ecuacion.push(resp+"");
                        break;
                    case "-":
                        resp=aux2-aux1;
                        ecuacion.push(resp+"");
                        break;
                     case "*":
                        resp=aux1*aux2;
                        ecuacion.push(resp+"");
                        break;
                     case "/":
                        resp=aux2/aux1;
                        ecuacion.push(resp+"");
                        break;
                     default:
                        resp=Math.pow(aux2, aux1);
                        ecuacion.push(resp+"");
                        break;
                }
                ecuacion1.pop();
           }
           
       }
       
       //Finalmente se saca el unico temrino de la segunda pila que es el resultado final
       resp=Double.parseDouble(ecuacion.pop());
       return resp;
   }
   
    /**
     *Metodo que revisa que en la expresion dada tenga un equilibrio de parentesis.
     * @param cadena Sting de una expersion que se encuentra en forma infija.
     * @return boolean que regresa true si el balanceo de parentesis es correcto, si no regresa false.
     */
    public static boolean analisisParentesis(String cadena){
        ArrayStack<String> pila=new ArrayStack();
        String[] arre=cadena.split("\\s");
        int i=0;
        int a=0,b=0;
        String temp;
        boolean resp=false,aux=true;
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
            resp=true;
        return resp;
                    
    }
    
    public void enableOperators(boolean resp){
        btSum.setEnabled(resp);
        btMulti.setEnabled(resp);
        btDiv.setEnabled(resp);
        btRest.setEnabled(resp);
        btPow.setEnabled(resp);
        btPunto.setEnabled(resp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        tfEcuacion = new javax.swing.JTextField();
        btIgual = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt0 = new javax.swing.JButton();
        btClean = new javax.swing.JButton();
        btPow = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btParIzq = new javax.swing.JButton();
        btParDer = new javax.swing.JButton();
        btSum = new javax.swing.JButton();
        btRest = new javax.swing.JButton();
        btMulti = new javax.swing.JButton();
        btDiv = new javax.swing.JButton();
        btPunto = new javax.swing.JButton();
        btNegativo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setOpaque(false);

        tfEcuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEcuacionActionPerformed(evt);
            }
        });

        btIgual.setBackground(new java.awt.Color(255, 255, 255));
        btIgual.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btIgual.setText("=");
        btIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIgualActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);

        bt7.setBackground(new java.awt.Color(102, 102, 255));
        bt7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt7.setForeground(new java.awt.Color(255, 255, 255));
        bt7.setText("7");
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });

        bt8.setBackground(new java.awt.Color(51, 153, 255));
        bt8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt8.setForeground(new java.awt.Color(255, 255, 255));
        bt8.setText("8");
        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });

        bt9.setBackground(new java.awt.Color(153, 255, 102));
        bt9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt9.setForeground(new java.awt.Color(255, 255, 255));
        bt9.setText("9");
        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });

        bt4.setBackground(new java.awt.Color(102, 153, 255));
        bt4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt4.setForeground(new java.awt.Color(255, 255, 255));
        bt4.setText("4");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });

        bt5.setBackground(new java.awt.Color(0, 153, 153));
        bt5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt5.setForeground(new java.awt.Color(255, 255, 255));
        bt5.setText("5");
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });

        bt6.setBackground(new java.awt.Color(51, 204, 0));
        bt6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt6.setForeground(new java.awt.Color(255, 255, 255));
        bt6.setText("6");
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });

        bt1.setBackground(new java.awt.Color(0, 153, 102));
        bt1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt1.setForeground(new java.awt.Color(255, 255, 255));
        bt1.setText("1");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        bt2.setBackground(new java.awt.Color(0, 153, 102));
        bt2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt2.setForeground(new java.awt.Color(255, 255, 255));
        bt2.setText("2");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        bt3.setBackground(new java.awt.Color(204, 204, 0));
        bt3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt3.setForeground(new java.awt.Color(255, 255, 255));
        bt3.setText("3");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        bt0.setBackground(new java.awt.Color(0, 153, 153));
        bt0.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        bt0.setForeground(new java.awt.Color(255, 255, 255));
        bt0.setText("0");
        bt0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt0ActionPerformed(evt);
            }
        });

        btClean.setBackground(new java.awt.Color(0, 102, 51));
        btClean.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btClean.setForeground(new java.awt.Color(255, 255, 255));
        btClean.setText("C");
        btClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCleanActionPerformed(evt);
            }
        });

        btPow.setBackground(new java.awt.Color(255, 51, 51));
        btPow.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btPow.setForeground(new java.awt.Color(255, 255, 255));
        btPow.setText("^");
        btPow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btClean, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btPow, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClean, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPow, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setOpaque(false);

        btParIzq.setBackground(new java.awt.Color(255, 204, 0));
        btParIzq.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btParIzq.setForeground(new java.awt.Color(255, 255, 255));
        btParIzq.setText("(");
        btParIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParIzqActionPerformed(evt);
            }
        });

        btParDer.setBackground(new java.awt.Color(255, 51, 102));
        btParDer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btParDer.setForeground(new java.awt.Color(255, 255, 255));
        btParDer.setText(")");
        btParDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParDerActionPerformed(evt);
            }
        });

        btSum.setBackground(new java.awt.Color(255, 102, 102));
        btSum.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btSum.setForeground(new java.awt.Color(255, 255, 255));
        btSum.setText("+");
        btSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSumActionPerformed(evt);
            }
        });

        btRest.setBackground(new java.awt.Color(204, 0, 153));
        btRest.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btRest.setForeground(new java.awt.Color(255, 255, 255));
        btRest.setText("-");
        btRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRestActionPerformed(evt);
            }
        });

        btMulti.setBackground(new java.awt.Color(255, 102, 51));
        btMulti.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btMulti.setForeground(new java.awt.Color(255, 255, 255));
        btMulti.setText("*");
        btMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMultiActionPerformed(evt);
            }
        });

        btDiv.setBackground(new java.awt.Color(255, 153, 153));
        btDiv.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btDiv.setForeground(new java.awt.Color(255, 255, 255));
        btDiv.setText("/");
        btDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDivActionPerformed(evt);
            }
        });

        btPunto.setBackground(new java.awt.Color(255, 51, 51));
        btPunto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btPunto.setForeground(new java.awt.Color(255, 255, 255));
        btPunto.setText(".");
        btPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPuntoActionPerformed(evt);
            }
        });

        btNegativo.setBackground(new java.awt.Color(255, 102, 204));
        btNegativo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btNegativo.setForeground(new java.awt.Color(255, 255, 255));
        btNegativo.setText("(-)");
        btNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNegativoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btParIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btParDer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btSum, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRest, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btPunto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btNegativo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btParIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btParDer, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSum, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRest, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPunto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNegativo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfEcuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfEcuacion, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(btIgual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(40, 60, 440, 340);

       // jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FONDO-DE-RESERVA-DE-GARANTÍA-EDUCATIVA-INED21.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-220, -40, 900, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEcuacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEcuacionActionPerformed
        
    }//GEN-LAST:event_tfEcuacionActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"1");   
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"2");
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
       enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"3");
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"4");
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"5");
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"6");
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed
        enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"7");
    }//GEN-LAST:event_bt7ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed
        enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"8");
    }//GEN-LAST:event_bt8ActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed
        enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"9");
    }//GEN-LAST:event_bt9ActionPerformed

    private void btRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRestActionPerformed
        
        enableOperators(false);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+" - ");
    }//GEN-LAST:event_btRestActionPerformed

    private void bt0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt0ActionPerformed
       enableOperators(true);
        ecuacion=tfEcuacion.getText();
       tfEcuacion.setText(ecuacion+"0"); 
    }//GEN-LAST:event_bt0ActionPerformed

    private void btCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCleanActionPerformed
        tfEcuacion.setText("");
    }//GEN-LAST:event_btCleanActionPerformed

    private void btSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSumActionPerformed
        enableOperators(false);
        ecuacion=tfEcuacion.getText();
        tfEcuacion.setText(ecuacion+" + ");
    }//GEN-LAST:event_btSumActionPerformed

    private void btMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMultiActionPerformed
        enableOperators(false);
        ecuacion=tfEcuacion.getText();
        tfEcuacion.setText(ecuacion+" * ");
    }//GEN-LAST:event_btMultiActionPerformed

    private void btDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDivActionPerformed
        enableOperators(false);
        ecuacion=tfEcuacion.getText();
        tfEcuacion.setText(ecuacion+" / ");
    }//GEN-LAST:event_btDivActionPerformed

    private void btParIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParIzqActionPerformed
        ecuacion=tfEcuacion.getText();
        tfEcuacion.setText(ecuacion+"( ");
    }//GEN-LAST:event_btParIzqActionPerformed

    private void btParDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParDerActionPerformed
        ecuacion=tfEcuacion.getText();
        tfEcuacion.setText(ecuacion+" )");
    }//GEN-LAST:event_btParDerActionPerformed

    private void btPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPuntoActionPerformed
        enableOperators(false);
        ecuacion=tfEcuacion.getText();
        tfEcuacion.setText(ecuacion+".");
    }//GEN-LAST:event_btPuntoActionPerformed

    private void btNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNegativoActionPerformed
        ecuacion=tfEcuacion.getText();
        tfEcuacion.setText(ecuacion+"-");
    }//GEN-LAST:event_btNegativoActionPerformed

    private void btPowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPowActionPerformed
        enableOperators(false);
        ecuacion=tfEcuacion.getText();
        tfEcuacion.setText(ecuacion+" ^ ");
    }//GEN-LAST:event_btPowActionPerformed

    private void btIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIgualActionPerformed
    if(analisisParentesis(tfEcuacion.getText()))
            if(revisaSignos(tfEcuacion.getText())){
                try{
                    ecuacion =InfijaPostfija(tfEcuacion.getText());
                    num=resuelveEcuacion(ecuacion);
                    tfEcuacion.setText(num+"");
                }
                catch(Exception e){
                tfEcuacion.setText("Error en sintaxis o la ecuacion esta vacia");
            }
            }
            else
                tfEcuacion.setText("Error en balanceo de signos");
        else
            tfEcuacion.setText("Error en balanceo de parentesis");       
    }//GEN-LAST:event_btIgualActionPerformed

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
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Calculadora().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt0;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton btClean;
    private javax.swing.JButton btDiv;
    private javax.swing.JButton btIgual;
    private javax.swing.JButton btMulti;
    private javax.swing.JButton btNegativo;
    private javax.swing.JButton btParDer;
    private javax.swing.JButton btParIzq;
    private javax.swing.JButton btPow;
    private javax.swing.JButton btPunto;
    private javax.swing.JButton btRest;
    private javax.swing.JButton btSum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfEcuacion;
    // End of variables declaration//GEN-END:variables
}

