package ForestFire

import scala.util.Random

class Burner(shouldBurn: () => Boolean) extends CellEvolver {
  override def Evolve(b: Board, i: Int, j: Int): Option[CellState] = {
    if (b.neighbours(i, j).contains(Fire)) Some(Fire) else if (shouldBurn()) Some(Fire) else None
  }
}

object Burner {
  def apply(fireProbability: Double) = new Burner(() => Random.nextDouble() <= fireProbability)
}