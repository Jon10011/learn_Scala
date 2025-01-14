package com.songdong.day06

object MixInDemo01 {
  def main(args: Array[String]): Unit = {
    // 这时 FF 是这样 形式
    class FF extends EE with CC with DD
    /**
      * 调用当前类的超类构造器
      * 第一个特质的父特质构造器
      * 第一个特质构造器
      * 第二个特质构造器的父特质构造器, 如果已经执行过， 就不再执行
      * 第二个特质构造器
      * .......重复 4,5 的步骤(如果有第 3 个，第 4 个特质) 当前类构造器 [案例演示]
      */
    //1. E...
    //2. A...
    //3. B....
    //4. C....
    //5. D....
    //6. F....
    val ff1 = new FF()
    println(ff1)

    //这时我们是动态混入
    /**
      * 先创建 new KK 对象，然后再混入其它特质
      * 调用当前类的超类构造器
      * 当前类构造器
      * 第一个特质构造器的父特质构造器
      * 第一个特质构造器.
      * 第二个特质构造器的父特质构造器, 如果已经执行过，就不再执行 第二个特质构造器
      * .......重复 5,6 的步骤(如果有第 3 个，第 4 个特质)
      * 当前类构造器 [案例演示]
    */
    //1. E...
    //2. K....
    //3. A...
    //4. B
    //5. C
    //6. D
    println("=======================")
    val ff2 = new KK with CC with DD
    println (ff2)
  }
}

trait AA {
  println("A...")
}

trait BB extends AA {
  println("B....")
}

trait CC extends BB {
  println("C....")
}

trait DD extends BB {
  println("D....")
}

class EE { //普通类
  println("E...")
}

class FF extends EE with CC with DD { //先继承了 EE 类，然后再继承 CC 和 DD
  println("F....")
}

class KK extends EE { //KK 直接继承了普通类 EE
  println("K....")
}