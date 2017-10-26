// @author Elijah Holmberg and Bobby Mushkot
public class Bishop extends ChessPiece{
   
    public Bishop(int col, int row, char color){
        super(col, row, color);
    }
    @Override 
    public boolean isAttacking(ChessPiece c){
        return Math.abs(c.col - col) == Math.abs(c.row - row);
    }
}