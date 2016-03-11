package piconot.external

import picolib.semantics._

//sealed abstract class Expr;

case class StateStruct(name: State, rules: List[PartialRule])
case class PartialRule(block: List[MoveDirection], open: List[MoveDirection], move: MoveDirection, toState: State)
