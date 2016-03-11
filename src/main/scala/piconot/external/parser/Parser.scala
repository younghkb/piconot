package piconot.external.parser

import scala.util.parsing.combinator._
import piconot.external._
import picolib.semantics._

object PicoParser extends JavaTokenParsers with PackratParsers {
  
  // for parsing comments
  override protected val whiteSpace = """(\s|#.*)+""".r
  
  def apply(s: String): ParseResult[List[StateStruct]] = parseAll(program,s)
  
  def program: PackratParser[List[StateStruct]] = struct*
  
  def struct: PackratParser[StateStruct] =
    "State" ~ state ~ ":" ~ prules ^^
      {case "State" ~ n ~ ":" ~ r => StateStruct(n,r)}
  
  def prules: PackratParser[List[PartialRule]] = prule*
  
  def prule: PackratParser[PartialRule] =
    arrows ~ "," ~ arrows ~ "=>" ~ arrow ~ "," ~ state ^^
      {case b ~ "," ~ o ~ "=>" ~ m ~ "," ~ s => PartialRule(b,o,m,s)}
  
  def arrows: PackratParser[List[MoveDirection]] = arrow*
  
  def arrow: PackratParser[MoveDirection] = (
        ("↑" ^^^ North)
      | ("→" ^^^ East)
      | ("←" ^^^ West)
      | ("↓" ^^^ South)
      | ("." ^^^ StayHere)
   )
   
  def state: PackratParser[State] = """\d\d?""".r ^^ State
}