/**
  * Created by caseywebb on 4/6/17.
  */
import doodle.core.Color
import doodle.core.Image._

object Chapter4 {

  // 4.3 Streets ahead

  //triangle on top of square with square in
  val house = rectangle(20, 40) fillColor Color.black on rectangle(120, 80) fillColor Color.red below triangle(120, 40) fillColor Color.grey

  // circle with rectangle
  val tree = circle(50) fillColor Color.green above rectangle(20, 50) fillColor Color.brown

  val street = rectangle(30, 10) fillColor Color.black beside
    rectangle(80, 10) fillColor Color.yellow beside
    rectangle(30, 10) fillColor Color.black beside
    rectangle(80, 10) fillColor Color.yellow above
    rectangle(219, 10) fillColor Color.black

  val property = house beside tree above street

  val all_the_properties = property beside property beside property

}
