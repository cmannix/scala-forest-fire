import ForestFire._

object Main extends App {
  var board = Board(10)
  val fireProbability = 0.7
  val treeProbability = 0.5

  for {
    i <- 1 to 100
  } {
    board = board evolve(generateEvolutionFunction(Grower(treeProbability), Burner(fireProbability), Destroyer()))
    printIteration(i)
    printBoardToConsole(board)
  }

  private def generateEvolutionFunction(onEmpty: CellEvolver,
                                        onTree: CellEvolver,
                                        onFire: CellEvolver)
  = (b: Board, i: Int, j: Int) => {
    b.get(i, j) match {
      case Some(value) => value match {
        case Fire => onFire.Evolve(b, i, j)
        case Empty => onEmpty.Evolve(b, i, j)
        case Tree => onTree.Evolve(b, i, j)
        case _ => Some(Empty)
      }
    }
  }



  private def printIteration(i: Int): Unit = {
    println()
    Console.print("-" * 100)
    println()
    println(s"Iteration: $i")
    println()
  }

  private def printBoardToConsole(board: Board): Unit = {
    for {
      i <- 0 until board.Size
      j <- 0 until board.Size
    } {
      val printVal = board.get(i, j) match {
        case Some(Tree) => "T"
        case Some(Empty) => "O"
        case Some(Fire) => "*"
        case _ => "O"
      }

      if (j == board.Size - 1) {
        Console.println(printVal)
      } else {
        Console.print(printVal)
      }
    }
  }
}
