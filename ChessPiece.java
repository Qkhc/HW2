// @author Elijah Holmberg and Bobby Mushkot
public class ChessPiece {
    
    public int col;
    public int row;
    public char color;
    public boolean black;
    public boolean white;
    public ChessPiece next;
    
    public ChessPiece(int col, int row, char color){
        this.black = false;
        this.white = false;
        this.col = col;
        this.row = row;
        this.color = color;
        if(Character.isUpperCase(color))
            this.black = true;
        else
            this.white = true;
        next = null;
    }
    
    public boolean isAttacking(ChessPiece c){
        return false;
    }
    
    @Override
    public String toString(){
        return this.color+" "+ this.col+" "+this.row;
    }
}

