package fpscala.datastructures

/*
  - Declaring the abstract interface List with no methods.
  - Sealed means that the implementation of the trait must be in this file.
 */
sealed trait List[+A]