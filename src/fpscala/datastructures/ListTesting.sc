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
}
