package ForestFire

import org.scalatest.FunSpec

class GrowerSpec extends FunSpec {
    describe("Evolve") {
      describe("when a tree should be grown") {
        val board = Board(1)
        val sut = new Grower(() => true)
        val evolve = () => sut.Evolve(board, 0, 0)

        it("should return CellState of Tree") {
          assert(evolve().contains(Tree))
        }
      }

      describe("when a tree should not be grown") {
        val board = Board(1)
        val sut = new Grower(() => false)
        val evolve = () => sut.Evolve(board, 0, 0)

        it("should return nothing") {
          assert(evolve().isEmpty)
        }
      }
    }
}
