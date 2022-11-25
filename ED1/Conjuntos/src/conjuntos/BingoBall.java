/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conjuntos;

/**
 *
 * @author agomezdg
 */
public class BingoBall {
    private int number;
    private char letter;

    public BingoBall(int num) {
        this.number=num;
        if(num<=15)
            letter='B';
        else if(num<=30)
            letter='I';
        else if(num<=45)
            letter='N';
        else if(num<=60)
            letter='G';
        else
            letter='O';
    }

    public char getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BingoBall other = (BingoBall) obj;
        if (this.number != other.number) {
            return false;
        }
        if (this.letter != other.letter) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.number;
        hash = 97 * hash + this.letter;
        return hash;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder("");
        
        sb.append(letter+" "+number);
        
        return sb.toString();
    }
}
