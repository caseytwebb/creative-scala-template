/**
  * Created by caseywebb on 4/25/17.
  */

import doodle.core._
import doodle.syntax._

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


  import cats.Monoid
  import cats.implicits._

  implicit object pointInstance extends Monoid[Point] {
    def empty = Point.zero
    def combine(x: Point, y: Point): Point =
      Point(x.x + y.x, x.y + y.y)
  }

  val circle: Double => (Angle => Point) =
    (frequency: Double) => (a: Angle) => Point.polar(1.0, a * frequency)
  val scale: Double => (Point => Point) =
    (r: Double) => (pt: Point) => Point(pt.x * r, pt.y * r)

  val curve: Double => Angle => Point =
    (r: Double) =>
      (circle(1) andThen scale(r)) |+| (circle(6) andThen scale(r / 2)) |+| (circle(14) andThen scale(r / 3))


  // Don't copy after here --------------

  val sample: Int => (Angle => Image) => Image =
    (n: Int) => {
      val step = Angle.one / n
      (parametric: (Angle => Image)) => {
        def loop(count: Int): Image =
          count match {
            case 0 => Image.empty
            case n => parametric(step * n) on loop(n - 1)
          }

        loop(n)
      }
    }

  val style: Point => Image = {
    val c = curve(0.53)
    (pt: Point) => {
      val color = c(pt.angle)
      Image.circle(3).
        at(pt.toVec).
        lineColor(Color.royalBlue).
        fillColor(Color.hsla(color.angle, color.r.normalized, 0.7.normalized, 0.5.normalized))
    }
  }

  val image = sample.apply(500).apply(curve(200) andThen style)



}
