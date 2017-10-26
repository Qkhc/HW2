//@author Elijah Holmberg and Bobby Mushkot
public class Knight extends ChessPiece{
    
    public Knight(int col, int row, char color){
        super (col, row, color);
    }
    
    @Override
     public boolean isAttacking(ChessPiece c){
        if (Math.abs(row-c.row) == 2 && Math.abs(col-c.col) == 1)
            return true;
        else if (Math.abs(row-c.row) == 1 && Math.abs(col-c.col) == 2)
            return true;
        return false;
    }
}