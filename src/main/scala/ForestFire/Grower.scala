package ForestFire

import scala.util.Random

object Grower {
  def apply(growProbability: Double) = {
    new Grower(() => Random.nextDouble() <= growProbability)
  }
}

class Grower(shouldGrow: () => Boolean) extends CellEvolver {
  override def Evolve(b: Board, i: Int, j: Int): Option[CellState] = if (shouldGrow()) Some(Tree) else None
}