package ForestFire

import org.scalatest.FunSpec

class DestroyerSpec extends FunSpec {
  describe("Evolve") {
    val board = Board(1)
    val sut = new Destroyer()
    val evolve = () => sut.Evolve(board, 0, 0)

    it("should always return CellState of Empty") {
      assert(evolve().contains(Empty))
    }
  }
}
