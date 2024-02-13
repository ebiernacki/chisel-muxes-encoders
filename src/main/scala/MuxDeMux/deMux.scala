package MuxDeMux

import chisel3._
import chisel3.util._

//Fill in the deMux1to2 and deMux1to4 to handle an input of width n bits and drive the correct output based on the select signals 
//
class deMux1to2(width: Int) extends Module { //1to2 
    val io = IO(new Bundle {
        val sel        = Input(UInt(1.W))
        val in         = Input(UInt(width.W))
        val d1         = Output(UInt(width.W))
        val d2         = Output(UInt(width.W))
    })

    // val notSel = ~io.sel

    // val vectd1 = VecInit(Seq.fill(width)(0.U(1.W)))
    // val vectd2 = VecInit(Seq.fill(width)(0.U(1.W)))

    // for(i <- 0 until width){
    //     vectd1(i) := notSel & io.in(i)
    //     vectd2(i) := io.sel & io.in(i)
    // }

    // io.d1 := vectd1.asUInt
    // io.d2 := vectd2.asUInt

    //also works
    // io.d1 := Mux(io.sel === false.B, io.in, 0.U)
    // io.d2 := Mux(io.sel === true.B, io.in, 0.U)


    //also works
    io.d1 := 0.U
    io.d2 := 0.U
    switch(io.sel) {
        is(0.U) {
            io.d1 := io.in
        }
        is(1.U) {
            io.d2 := io.in
        }
    }


}


class deMux1to4(width: Int) extends Module { //1to4
    val io = IO(new Bundle {
        val s0         = Input(UInt(1.W))
        val s1         = Input(UInt(1.W))
        val in         = Input(UInt(width.W))
        val d1         = Output(UInt(width.W))
        val d2         = Output(UInt(width.W))
        val d3         = Output(UInt(width.W))
        val d4         = Output(UInt(width.W))
    })

    // val dm1 = Module(new deMux1to2(width))

    // dm1.io.sel := io.s1
    // dm1.io.in := io.in

    // val dm2 = Module(new deMux1to2(width))
    // val dm3 = Module(new deMux1to2(width))

    // dm2.io.sel := io.s0
    // dm3.io.sel := io.s0

    // dm2.io.in := dm1.io.d1
    // dm3.io.in := dm1.io.d2

    // io.d1 := dm2.io.d1
    // io.d2 := dm2.io.d2

    // io.d3 := dm3.io.d1
    // io.d4 := dm3.io.d2


    //also works
    // val sel = Cat(io.s1, io.s0)
    // io.d1 := Mux(sel === 0.U, io.in, 0.U)
    // io.d2 := Mux(sel === 1.U, io.in, 0.U)
    // io.d3 := Mux(sel === 2.U, io.in, 0.U)
    // io.d4 := Mux(sel === 3.U, io.in, 0.U)
    

    //also works
    io.d1 := 0.U
    io.d2 := 0.U
    io.d3 := 0.U
    io.d4 := 0.U
    val sel = Cat(io.s1, io.s0)
    switch(sel) {
        is(0.U) { io.d1 := io.in }
        is(1.U) { io.d2 := io.in }
        is(2.U) { io.d3 := io.in }
        is(3.U) { io.d4 := io.in }
    }
}
