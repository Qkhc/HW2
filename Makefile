JAVASRC    = Chessboard.java ChessPiece.java Queen.java King.java Knight.java Bishop.java Rook.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = Chessboard
CLASSES    = Chessboard.class ChessPiece.class Queen.class King.class Knight.class Bishop.class Rook.class
JARFILE    = Chessboard.jar
XTRAS      = input.txt analysis.txt

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE) $(XTRAS)
