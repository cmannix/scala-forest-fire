package ForestFire

trait CellEvolver {
  def Evolve(b: Board, i: Int, j: Int): Option[CellState]
}
