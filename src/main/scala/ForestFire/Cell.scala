package ForestFire

sealed trait CellState

case object Empty extends CellState
case object Tree extends CellState
case object Fire extends CellState


