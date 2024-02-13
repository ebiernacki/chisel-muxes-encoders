package MuxDeMux

import chisel3._
import chisel3.util._

//Fill in the Mux2to1 and Mux4to1 to handle any inputs of width n bits give a singular output based on the select signals 
//

class Mux2to1(n: Int) extends Module { //2:1
	val io = IO(new Bundle {
		val sel        = Input(UInt(1.W))
		val d1         = Input(UInt(n.W))
		val d2         = Input(UInt(n.W))
		val out        = Output(UInt(n.W))
	})

}
 

class Mux4to1(n: Int) extends Module { //4:1
    val io = IO(new Bundle {
        val s0         = Input(UInt(1.W))
        val s1         = Input(UInt(1.W))
        val d1         = Input(UInt(n.W))
        val d2         = Input(UInt(n.W))
        val d3         = Input(UInt(n.W))
        val d4         = Input(UInt(n.W))
        val out        = Output(UInt(n.W))
    })


}
























/* 
Demux 1:2

	val notSel = ~io.sel

	val vect = VecInit(Seq.fill(n)(0.U(1.W)))

	for(i <- 0 until n){
		var t1 = io.d1(i) & notSel 
		var t2 = io.d2(i) & io.sel 
		var b1 = t1 | t2
		vect(i) := b1
	}

	io.out := vect.asUInt 

    io.out := Mux(io.sel.asBool, io.d2, io.d1) //this works too obviously 


    //this ALSO works
    io.out := io.d1
    switch (io.sel) {
        is (0.U) { io.out := io.d1}
        is (1.U) { io.out := io.d2}
    }

 */

 /* 
Demux 1:4
    val m1 = Module(new Mux2to1(n))
    val m2 = Module(new Mux2to1(n))

    m1.io.sel := io.s0
    m2.io.sel := io.s0

    m1.io.d1 := io.d1
    m1.io.d2 := io.d2

    m2.io.d1 := io.d3
    m2.io.d2 := io.d4

    val m3 = Module(new Mux2to1(n))
    m3.io.sel := io.s1

    m3.io.d1 := m1.io.out
    m3.io.d2 := m2.io.out

    io.out := m3.io.out


    woah this works too
    io.out := Mux(io.s1.asBool, Mux(io.s0.asBool, io.d4, io.d3), Mux(io.s0.asBool, io.d2, io.d1))



    //this also works
    val sel = Cat(io.s1, io.s0)

    io.out := io.d1
    switch (sel) {
        is (0.U) { io.out := io.d1}
        is (1.U) { io.out := io.d2}
        is (2.U) { io.out := io.d3}
        is (3.U) { io.out := io.d4}
    }
 */