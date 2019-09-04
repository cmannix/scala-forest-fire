package ForestFire

import org.scalatest.FunSpec

class BurnerSpec extends FunSpec {

  describe("Evolve") {
    describe("when neighbours are on fire") {
      describe("and should not start new fire") {
        val board = Board(3).evolve(Grower(1).Evolve).evolve(Burner(1).Evolve)
        val sut = new Burner(() => false)
        val evolve = () => sut.Evolve(board, 1, 1)

        it ("should return CellState of Fire") {
          assert(evolve().contains(Fire))
        }
      }

      describe("and should start new fire") {
        val board = Board(3).evolve(Grower(1).Evolve).evolve(Burner(1).Evolve)
        val sut = new Burner(() => true)
        val evolve = () => sut.Evolve(board, 1, 1)

        it ("should return CellState of Fire") {
          assert(evolve().contains(Fire))
        }
      }
    }

    describe("when neighbours are not on fire") {
      describe("and should not start new fire") {
        val board = Board(3).evolve(Grower(1).Evolve)
        val sut = new Burner(() => false)
        val evolve = () => sut.Evolve(board, 1, 1)
        it ("should return nothing") {
          assert(evolve().isEmpty)
        }
      }

      describe("and should start new fire") {
        val board = Board(3).evolve(Grower(1).Evolve)
        val sut = new Burner(() => true)
        val evolve = () => sut.Evolve(board, 1, 1)

        it ("should return CellState of Fire") {
          assert(evolve().contains(Fire))
        }
      }
    }
  }
}
