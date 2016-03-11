package piconot.internal

import picolib.semantics._

class API(val mazeFilename: String) {
  case class PartialRule(surroundings: Surroundings, moveDirection: MoveDirection, endState: State) {
    def mkRule(startState: State) = Rule(startState, surroundings, moveDirection, endState) 
  }
  
  def arrowMapper(f: IndexedSeq[Boolean], s: IndexedSeq[Boolean], i: Int) = {
    (f(i), s(i)) match {
      case (true,false)  => Open
      case (false,true)  => Blocked
      case (false,false) => Anything
      case (true,true)   => throw new Exception("Dup arrows") //ERROR
    }
  }
  
  def parse(line: String) {
    val s0 = line.split("=>") map {x => x.trim}
    val s1 = s0(0).split(",") map {x => x.trim}
    val s2 = s0(1).split(",") map {x => x.trim}
    
    val open    = s1(0)
    val blocked = s1(1)
    val dir     = s2(0)(0)
    val nState  = s2(0)
    
    val error = "↑→←↓" map {x: Char => open.indexOf(x) != -1 && blocked.indexOf(x) != -1}
    
    // error handle
    
    val op = "↑→←↓" map {x: Char => open.indexOf(x)    != -1}
    val bk = "↑→←↓" map {x: Char => blocked.indexOf(x) != -1}
    
    val v0 = arrowMapper(op,bk,0)
    val v1 = arrowMapper(op,bk,1)
    val v2 = arrowMapper(op,bk,2)
    val v3 = arrowMapper(op,bk,3)
    
    val surr    = Surroundings(v0, v1, v2, v3)
    val moveDir = dir match {
      case '↑' => North
      case '→' => East
      case '←' => West
      case '↓' => South
    }
    val eState = State(nState)
    
    PartialRule(surr,moveDir,eState)
    
    //PartialRule()
    
    //"↑→↓←"
  }
  
  class StateStructure(stateName: String) {
    var rules = List()
    def ::(rule: String*) {
      
    }
    
    def |(rule: String) {
    }
  }
  
  case class PartialRuleStructure(block: String, open: String, move: MoveDirection, next: State) 

}