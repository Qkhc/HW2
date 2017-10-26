// @author Elijah Holmberg and Bobby Mushkot
public class King extends ChessPiece{
   
    public King(int col, int row, char color){
        super (col, row, color);
    }
    
    @Override
     public boolean isAttacking(ChessPiece c){
        return Math.abs(row-c.row) == 1 || Math.abs(col-c.col) == 1;
    }
}