/**
  * Created by caseywebb on 4/17/17.
  */
import doodle.core.{Color, Image}
import doodle.core.Image._
import doodle.syntax._

object Chapter6 {

  // sweet boxes
  def boxes(color: Color): Image = {
    val box =
      Image.rectangle(40, 40).
        lineWidth(5.0). lineColor(Color.mistyRose.spin(30.degrees)). fillColor(Color.mistyRose)
    box beside box beside box beside box beside box }


}
