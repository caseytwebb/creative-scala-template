/**
  * Created by caseywebb on 5/9/17.
  */

import cats.instances.map
import doodle.core._
import doodle.syntax._
import doodle.core.Point._
import doodle.core.PathElement._
import doodle.core.Image._

object Chapter9 {

  // Recreate figure 9.2
  val triangle =
    closedPath(List(
      lineTo(cartesian(0, 100)),
      lineTo(cartesian(50, 50)),
      lineTo(cartesian(0, 0))
    ))


  val square =
    closedPath(List(
      moveTo(polar(50, 45.degrees)),
      lineTo(polar(50, 135.degrees)),
      lineTo(polar(50, 225.degrees)),
      lineTo(polar(50, 315.degrees))
    ))

  def style(image: Image): Image =
    image.
      lineWidth(6.0).
      lineColor(Color.royalBlue).
      fillColor(Color.skyBlue)

  // TODO: Right now the alignment between then needs refinement
  val polys = style(triangle beside square)


  // Recreate figure 9.2... WITH CURVES!
  val curveTriangle =
    closedPath(List(
      curveTo(Point(0,0), Point(5,50), Point(0,100)),
      curveTo(Point(0,100), Point(25,60), Point(50,50)),
      curveTo(Point(50,50), Point(25,40), Point(0,0))
    ))


  // TODO: Right now the alignment between then needs refinement
  val curvy = style(curveTriangle)

  ///////////////// Playing with lists of natural numbers //////////////////
  def ones(n: Int): List[Int] =

    n match {
      case 0 => Nil
      case _ => 1 :: ones(n - 1)

    }


  def descending(start: Int): List[Int] =

    start match {
      case 0 => List()
      case _ => start :: descending(start - 1)
    }


  def double(list: List[Int]): List[Int] =

    list match {
      case Nil => List()
      case hd :: tl => hd * 2 :: double(tl)
    }

  def reverse[A](list: List[A]): List[A] =

    list match {
      case Nil => List()
      case hd :+ tl => tl :: reverse(hd)
    }

  def onesMap(n: Int): List[Int] =
    (0 until n).toList.map(x => 1)


  //////// Stars section //////
  def star(sides: Int, skip: Int, radius: Double): Image = {

    // Make a list of lines and then connect them to make stars


    val rotation = 360.degrees * skip / sides

    val start = moveTo(polar(radius, 0.degrees))

    val elements = (1 until sides).toList map { index =>
      val point = polar(radius, rotation * index)
      lineTo(point)
    }
    closedPath(start :: elements) lineWidth 2

  }



  }
