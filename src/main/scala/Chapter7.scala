import doodle.core.{Angle, Color, Image}

/**
  * Created by caseywebb on 4/18/17.
  */
object Chapter7 {

  // Guess the result!

  /*
  "abcd" match {
    case "bcde" => 0
    case "cdef" => 1
    case "abcd" => 2
  }
      --> 2

  1 match {
    case 0 => "zero"
    case 1 => "one"
    case 1 => "two"
  }

  --> "one"

  1 match {
    case n => n + 1
    case 1 => 1000
  }

  --> 2

  1 match {
    case a => a
    case b => b + 1
    case c => c * 2
  }

  --> 1
*/

  // Calculate the crosses

  val circleSize = 40
  val aCircle = Image.circle(circleSize)

  def makeCross(count: Int): Image =
    count match {
      case 0 => aCircle
      case n => aCircle beside (aCircle above makeCross(n - 1) above aCircle) beside aCircle
    }

  // Chessboard
  //  Assume you start with a chunk of 4 squares with red in the top left corner
  //    each iteration through the natural numbers adds 3 chunks around in clockwise order

  val chessSquare = Image.rectangle(20, 20)
  val redChessSquare = chessSquare fillColor (Color.red)
  val blackChessSquare = chessSquare fillColor (Color.black)

  val chessBoardPiece = (redChessSquare beside blackChessSquare) above (blackChessSquare beside redChessSquare)

  def makeChessBoard(count: Int): Image =
    count match {
      case 0 => chessBoardPiece
      case n =>
        val chessBoardChunk = makeChessBoard(n - 1)
        (chessBoardChunk beside chessBoardChunk) above (chessBoardChunk beside chessBoardChunk)

    }


  // Sierpinkski Triangle
  //  1) make 1 triangle
  //  2) each loop is just stacking together the three triangles
  //  3) the base case needs to be stacking the first three

  val baseTriangle = Image.triangle(10, 7)

  //pulling this out so not duplicated across cases
  def sierpinkskize(triangle: Image) = {
    (triangle beside triangle) below triangle
  }

  def makeSierpinkskiTriangle(count: Int): Image =
    count match {
      case 0 => sierpinkskize(baseTriangle)
      case n =>
        val priorTriangle = makeSierpinkskiTriangle(n - 1)
        sierpinkskize(priorTriangle)
    }


  // Gradient boxes
  def gradientBoxes(count: Int, color: Color): Image =
    count match {
      case 0 => Image.empty
      case n => Image.rectangle(30, 30) fillColor color beside gradientBoxes(n - 1, color.spin(Angle(5)))
    }

  // Concentric circles
  def concentricCircles(count: Int, size: Int): Image =
    count match {
      case 0 => Image.empty
      case n => Image.circle(size) fillColor Color.blue on concentricCircles(n - 1, size + 10)
    }

  // Chessboard with improved scoping
  def makeChessBoardBetterScoping(count: Int): Image = {
    val chessSquare = Image.rectangle(20, 20)
    val redChessSquare = chessSquare fillColor (Color.red)
    val blackChessSquare = chessSquare fillColor (Color.black)
    val chessBoardPiece = (redChessSquare beside blackChessSquare) above (blackChessSquare beside redChessSquare)

    def loop(count: Int): Image =
      count match {
        case 0 => chessBoardPiece
        case n =>
          val chessBoardChunk = makeChessBoard(n - 1)
          (chessBoardChunk beside chessBoardChunk) above (chessBoardChunk beside chessBoardChunk)
      }

    loop(count)
  }


}

