/*
*
*/



package MuxDeMux

import chisel3._
import chisel3.util._

class Mux(width: Int) extends Module { //2:1
	val io = IO(new Bundle {
		val sel        = Input(UInt(1.W))
		val d1         = Input(UInt(width.W))
		val d2         = Input(UInt(width.W))
		val out        = Output(UInt(width.W))
	})

	// val notSel = ~io.sel

	// val vect = VecInit(Seq.fill(width)(0.U(1.W)))

	// for(i <- 0 until width){
	// 	var t1 = io.d1(i) & notSel 
	// 	var t2 = io.d2(i) & io.sel 
	// 	var b1 = t1 | t2
	// 	vect(i) := b1
	// }

	// io.out := vect.asUInt 

    //io.out := Mux(io.sel.asBool, io.d2, io.d1) //this works too obviously 


    //this ALSO works
    io.out := io.d1
    switch (io.sel) {
        is (0.U) { io.out := io.d1}
        is (1.U) { io.out := io.d2}
        // is ("b0100".U) { io.b := "b10".U}
        // is ("b1000".U) { io.b := "b11".U}
    }
}
 

class Mux4to1(width: Int) extends Module { //4:1
    val io = IO(new Bundle {
        val s0         = Input(Bool())
        val s1         = Input(Bool())
        val d1         = Input(UInt(width.W))
        val d2         = Input(UInt(width.W))
        val d3         = Input(UInt(width.W))
        val d4         = Input(UInt(width.W))
        val out        = Output(UInt(width.W))
    })

    // val m1 = Module(new Mux(width))
    // val m2 = Module(new Mux(width))

    // m1.io.sel := io.s0
    // m2.io.sel := io.s0

    // m1.io.d1 := io.d1
    // m1.io.d2 := io.d2

    // m2.io.d1 := io.d3
    // m2.io.d2 := io.d4

    // val m3 = Module(new Mux(width))
    // m3.io.sel := io.s1

    // m3.io.d1 := m1.io.out
    // m3.io.d2 := m2.io.out

    // io.out := m3.io.out


    //woah this works too
    //io.out := Mux(io.s1.asBool, Mux(io.s0.asBool, io.d4, io.d3), Mux(io.s0.asBool, io.d2, io.d1))



    //this also works
    val sel = Cat(io.s1.asUInt, io.s0.asUInt)

    io.out := io.d1
    switch (sel) {
        is (0.U) { io.out := io.d1}
        is (1.U) { io.out := io.d2}
        is (2.U) { io.out := io.d3}
        is (3.U) { io.out := io.d4}
    }

}