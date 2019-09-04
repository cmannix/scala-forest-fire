package ForestFire
import scala.language.postfixOps

object Board {
  def apply(size: Int): Board = new Board(size)
}

class Board(s: Int) {
  val Size: Int = s
  private val board = Array.ofDim[CellState](s, s)

  def get(i: Int, j: Int): Some[CellState] = {
    if (i < 0 | i >= Size | j < 0 | j >= Size) None
    Some(board(i)(j))
  }

  /** Gets cells in the Moore neighbourhood (3x3 grid centered on cell at i,j) */
  def neighbours(i: Int, j: Int): Array[CellState] = board slice(j - 1, j + 2) map(_.slice(i - 1, i + 2)) flatten

  def evolve(evolutionFunc: (Board, Int, Int) => Option[CellState]): Board = {
    val newBoard = Board(Size)

    for {
      i <- 0 until Size
      j <- 0 until Size
    } {
      val currentCell = this.board(i)(j)
      evolutionFunc(this, i, j) match {
        case Some(value) => newBoard.set(i, j, value)
        case None => newBoard.set(i, j, currentCell)
      }
    }
    newBoard
  }

  private def set(x: Int, y: Int, value: CellState) { board(x)(y) = value }
}
