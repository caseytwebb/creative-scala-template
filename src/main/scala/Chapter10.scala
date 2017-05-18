/**
  * Created by caseywebb on 5/16/17.
  */

import doodle.core._
import doodle.syntax._
import doodle.turtle._
import doodle.turtle.Instruction._

object Chapter10 {

  //Turtle Polygons
  def polygon(sides: Int, sideLength: Double): Image = {

    // NOTE: I don't really get this - had to take it from the answers to the exercises
    val turnSize = Angle.one / sides

    //Note: This approach works but feels a bit cludgy - I looked at the answer in the book appendix
    //  and it looks nicer.  It feels like there should be a cleaner way to do it with a map type thing though?
    val instructions = (1 until 2 * sides + 1).toList.map( index => if (index % 2 == 1) turn(turnSize) else forward(sideLength))

    Turtle.draw(instructions = instructions)

  }

  // The Square Spiral
  def squareSpiral(initialSideLen: Int, sideLenGrowth: Int, maxSideLen: Int, rotation: Int): Image = {

    val rotationAngle = Angle(rotation)

    def instructionGenerator(sideLen: Int):List[Instruction] = {

      sideLen match {
        case x if x >= maxSideLen => Nil
        case _ => forward(sideLen) :: turn(rotationAngle) :: instructionGenerator(sideLen + sideLenGrowth)
      }
    }

    Turtle.draw(instructionGenerator(initialSideLen))

  }


  // Turtle vs Polar w/ map and range
  // It seems like the reason you can't use the range + map paradigm because with turtle its not a 'natural numbers' problem -
  //    aka you need two instructions (turn & forward) so it's not quite the same pattern as when points are abstracted and make it match up

  // flatMap exercises
  def double[A](inputList: List[A]) = {

    inputList.flatMap{x => List(x, x)}

  }

  def nothing[A](inputList: List[A]) = inputList.flatMap{ x => List.empty }


  def rewrite(instructions: List[Instruction], rule: Instruction => List[Instruction]): List[Instruction] = {

    instructions.flatMap( instruction =>
      instruction match {
          //NOTE: I had to get this case statement from the answers... I don't think I fully get the pattern matching thing
        case Branch(i) => List(branch(rewrite(i, rule):_*))
        case i => rule(i)
      })

  }

  def iterate(steps: Int, seed: List[Instruction], rule: Instruction => List[Instruction]): List[Instruction] = {

    steps match {
      case 0 => seed
      case n => iterate(steps - 1, rewrite(seed, rule), rule)
    }

  }

  // Plants and Other Creations
  def basicL(stepSize: Int, numBranches: Int): Image = {

    // Starting with simple rule
    // NOTE: This isn't quite right -- the stepsize needs to increase as the step incrementor goes up but not sure the right way to pass that information through 
    def rule(i: Instruction): List[Instruction] =
      i match {
        case Forward(_) => List(branch(turn(45.degrees),
                                  forward(stepSize)),
                                branch(turn(-45.degrees),
                                  forward(stepSize)),
                                forward(stepSize*3))
        case other => List(other)
      }

    val instructions = iterate(numBranches, List(Forward(stepSize)),rule)

    Turtle.draw(instructions)
  }

  def rule(i: Instruction): List[Instruction] =
    i match {
      case Forward(_) => List(branch(turn(45.degrees),
        forward(5)),
        branch(turn(-45.degrees),
          forward(5)))
      case other => List(other)
    }

}
