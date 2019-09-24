package com.atguigu.bigData.dataStructure

import scala.util.control.Breaks

object LinkedList {
  def main(args: Array[String]): Unit = {
    val node = new LinkedListWithNode
    node.addEle(new Node(1,"zhangsan",20))
    node.addEle(new Node(3,"wangwu",25))
    node.addEle(new Node(2,"lisi",30))
    node.addEle(new Node(4,"lisi",30))
    node.addEle(new Node(5,"lisi",30))
    node.addEle(new Node(6,"lisi",30))
    node.addEle(new Node(7,"lisi",30))

    node.scan()
    println("__________________")
    node.delete(1)
    node.scan()
  }
}

class LinkedListWithNode{
  private val head = new Node(-1,"",0)
  var tmp=head
  var length=0



  //找到最后一个元素的位置，tmp
  def addEle(ele:Node): Unit ={
    Breaks.breakable(
      while(true){
        if(tmp.next==null){
          Breaks.break()
        }
        tmp=tmp.next
      }
    )
    tmp.next=ele
    length+=1
  }

  def scan(): Unit ={
    tmp=head.next
    while(tmp!=null){
      print(tmp)
      tmp=tmp.next
    }
  }



  def delete(id:Int): Boolean ={
    tmp=head
    var flag=false
    Breaks.breakable(
      while(tmp.next.id!=id||tmp.next.next!=null){
        if(tmp.next.id==id){
          flag=true
          Breaks.break()
        }
        tmp=tmp.next
      }
    )

    if(flag){
      tmp.next=tmp.next.next
      length-=1
      true
    }else if(tmp.next.id==id){
      tmp.next=null
      length-=1
      true
    }else{
      false
    }

  }

}

class Node(var id:Int,var name:String,var age:Int){
  var next:Node=_

  override def toString: String = {
    "id="+id+",name="+name+",age="+age+"\n"
  }
}