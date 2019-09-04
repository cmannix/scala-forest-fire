package ForestFire

object Destroyer {
  def apply() = new Destroyer()
}

class Destroyer() extends CellEvolver {
  override def Evolve(b: Board, i: Int, j: Int): Option[CellState] = Some(Empty)
}