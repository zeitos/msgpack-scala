package org.msgpack

import annotation.{Ignore, NotNullable, Index, Message}

/**
 * To test primitive types
 * User: takeshita
 * Create: 11/10/12 23:18
 */
@Message
class PrimitiveTypes{

  var intVal : Int = 1
  var longVal : Long = 2
  var shortVal : Short = 3
  var byteVal : Byte = 4
  var floatVal : Float = 5.0f
  var doubleVal : Double = 6.0
}



@Message
class Indexing{

  @Index(2)
  var two : Int = 0
  var one : Int = 0
  var three : Int = 0
  @Index(0)
  var zero : Int = 0
}

/**
 * For checking indexing
 */
@Message
class IndexingMirror{

  var zero : Int = 0
  var one : Int = 0
  var two : Int = 0
  var three : Int = 0
}


class RootClass{
  var rootName : String = "rootClass"
  var rootNum : Int = 234
}

trait RootTrait{
  var rootTraitName : String = "root"
  var rootTraitNum : Int = 23
}

@Message
class Inherit extends RootClass with RootTrait{

  var targetClassName : String = "targetClass"
}
@Message
class CustomGetterSetter{

  private var _myNumber : Int = 0

  def myNumber : Int = _myNumber
  def myNumber_=( v:  Int) : Unit = _myNumber = v
}

@Message
class OverloadVars{

  private var _id : Long = 0

  def id_=( v : String) = _id = v.toLong
  def id_=( v : Long) = _id = v
  def id : Long = _id
  def id_=(obj : Any) = _id = obj.toString.toLong
}

@Message
class Options{

  @NotNullable
  var name : String = ""

  @Ignore
  var ignoreNum : Int = 452
}

object WithCompanion{
  def apply() = new WithCompanion2()
}

@Message
class WithCompanion(var name : String){

}

@Message
class WithCompanion2 extends WithCompanion("hoge")

@Message
class ConstructorOverload(var name : String){

  def this() = this("fuga")
}

@Message
class ReferSelfClass(var name : String){

  def this() = this("")

  var myClass : ReferSelfClass = null
  var myList : List[ReferSelfClass] = List()
  var myMap : Map[String,ReferSelfClass] = Map.empty

}

@Message
class CycleA{
  var name : String = ""
  var cycleB : CycleB = new CycleB()
}

@Message
class CycleB{
  var cycleA : CycleA = null
  var cycleC : CycleC = new CycleC()
}

@Message
class CycleC{
  var cycleA : CycleA = null
}