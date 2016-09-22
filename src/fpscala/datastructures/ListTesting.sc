import fpscala.datastructures.Cons

object ListTesting {
  import fpscala.datastructures.List

  println(List.x)

  val list1 = List(1,2,3)
  val listEmpty = Nil

  List.tail(list1)
  list1

  List.setHead(0, list1)
  list1

  List.drop(list1, 10)

  List.dropWhile(list1, (x: Int) => x > 1)


  List.init(list1)
  List.init2(list1)
  list1

  List.sum2(list1)
  List.product2(List(1.0,2.0,3.0))

  List.length(list1)
  List.length(List(1))

  List.sum3(list1)
  List.product3(List(1.0,2.0,3.0))
  List.length2(list1)

  List.reverse(list1)


  println("Testing the new foldRightViaFoldLeft")
  List.sum22(list1)
  List.product22(List(1.0,2.0,3.0))
  List.length22(list1)

  println("Testing the new foldLeftViaFoldRight")
  List.sum33(list1)
  List.product33(List(1.0,2.0,3.0))
  List.length33(list1)

  println("Testing append")
  List.append(List(1,2,3), List(4,5,6))
  List.appendUsingFoldLeft(List(1,2,3), List(4,5,6))
  List.appendUsingFoldLeftAccordingToBook(List(1,2,3), List(4,5,6))

  List.foldLeft(List(1,2,3), 0)((x,y) => y)

  val t = List(List(1,2,3),List(4,5,6),List(7,8,9))
  List.concat(List(List(1,2,3),List(4,5,6),List(7,8,9)))

  List.addOne(list1)
  list1
}
