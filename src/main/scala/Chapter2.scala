/**
  * Created by caseywebb on 3/27/17.
  */
class Chapter2 {

}

object Chapter2 {
  // 2.4.0.1
  val get42 = 100 + 42 - 100

  // 2.4.0.2
  val appendStrings1 = "hello" ++ "world!"

  val appendStrings2 = "hello".++("world!")

  // 2.4.0.3
  // will be true if precedence works as I expect
  val precedenceTest = 3 * (4 + 5) == 27

  // 2.4.0.4
  // .. tinkered with these...

  // 2.4.0.5
  // The processor on the computer I'm working on is 64bit architecture which means the most possible digits it can represent is limited by
  // that size.  within the 64 bits it  also has to deal with representing decimal points and positive / negative which cuts down
  // on resolution as well.  Holding an exact representation of something like pi would take more then the available space

  // 2.4.0.6
  //  Good question - Not sure but thoughts I'm having are things like libraries to organize and make expressions re-usable and collections
  //  framework to organize values (but maybe this is just another type?)

}
