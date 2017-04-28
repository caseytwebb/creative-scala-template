/**
  * Created by caseywebb on 4/25/17.
  */

import doodle.core._

object Chapter8 {

  //Testing fig 8.3
  val dot = Image.circle(5).lineWidth(3).lineColor(Color.crimson)
  val squareDots =
    dot.at(0, 0).
      on(dot.at(0, 100)).
      on(dot.at(100, 100)).
      on(dot.at(100, 0))


  // Fig 8.7
  def almondCircle(n: Int) = Image.circle(n * 10) lineColor Color.blanchedAlmond.spin(Angle(n * 5))

  def concentricShapes(count: Int, singleShape: Int => Image): Image = count match {
    case 0 => Image.empty
    case n => singleShape(n) on concentricShapes(n-1, singleShape) }

  val fig87 = concentricShapes(10, almondCircle _)
}
