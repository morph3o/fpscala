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
}
