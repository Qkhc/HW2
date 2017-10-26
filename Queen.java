//@author Elijah Holmberg and Bobby Muhskot
public class Queen extends ChessPiece {
    
    public Queen(int col, int row, char color){
        super (col, row, color);
    }
    
    @Override
    public boolean isAttacking(ChessPiece c){
        if (row == c.row || col == c.col)
            return true;
        else if (Math.abs(c.col - col) == Math.abs(c.row - row))
            return true;
        return false;  
    }
}
