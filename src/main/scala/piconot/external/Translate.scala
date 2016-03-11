package piconot.external

import picolib.semantics._

object Translate {
  def convertAST(lst: List[StateStruct]): List[Rule] = lst.map(convertStruct).flatten
  
  def convertStruct(struct: StateStruct): List[Rule] = struct.rules map { mkRule(struct.name, _) }
  
  def mkRule(state: State, prule: PartialRule): Rule = {
    val surroundings = mkSurroundings(prule.block, prule.open)
    Rule(state, surroundings, prule.move, prule.toState)
  }
  
  case class ArrowConflictException(msg: String) extends Exception(msg)
  
  def mkSurroundings(block: List[MoveDirection], open: List[MoveDirection]): Surroundings = {
    val surr = List(North, East, West, South) map { x =>
      (block.contains(x),open.contains(x)) match {
        case (true, false)  => Blocked
        case (false, true)  => Open
        case (false, false) => Anything
        case (true,true)    => throw ArrowConflictException("ERROR: Arrow Conflict!")
      }
    }
    Surroundings(surr(0), surr(1), surr(2), surr(3))
  }
  
}