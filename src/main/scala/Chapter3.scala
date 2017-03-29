/**
  * Created by caseywebb on 3/29/17.
  */
import doodle.core.Image._

object Chapter3 {

  // Create circles that are 1, 10, and 100 units wide. Now draw them!
  val circle1 = circle(1)
  // ...

 //What is the type of a circle? A rectangle? A triangle?
  // All are of type Image: ex: type circle(10)


  // 3.5.1
  val target = circle(50) fillColor Color.red on circle(100) fillColor Color.white on circle(200) fillColor Color.red

  // 3.5.2
  // TODO: Add the stand to the bottom using "below" ect

}
