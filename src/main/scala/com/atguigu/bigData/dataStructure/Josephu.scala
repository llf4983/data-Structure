package com.atguigu.bigData.dataStructure

import scala.util.control.Breaks

object Josephu {
  def main(args: Array[String]): Unit = {
    val list = new LoopLinkedList(12)
    list.runGame(3,5)
  }
}

class LoopLinkedList(n:Int){
  var head:Nodee=_
  var tmp:Nodee=_
//  var node:Nodee=_

  for(i <- 0 until n){
    if(i==0){
      head=new Nodee(1)
      tmp=head
      head.next=head
    }else{
//      tmp=head
      tmp.next=new Nodee(i+1)
      tmp=tmp.next
      tmp.next=head
    }
  }


  def runGame(m:Int,k:Int): Unit ={
    tmp=head
    //找到第一个数的上一个数
    Breaks.breakable(
      while (tmp.next.ele!=m){
        if(tmp.next==head){
          print("no element")
          Breaks.break()
        }
        tmp=tmp.next

      }
    )
//找到要删除元素的上一个元素

    while (tmp.next!=tmp) {
      for (i <- 0 until k - 1) {
        tmp = tmp.next
      }
      println(tmp.next.ele)
      tmp.next = tmp.next.next
    }
  }

}

class Nodee(var ele:Int){
//  var ele:Int=_
  var next:Nodee=_
}