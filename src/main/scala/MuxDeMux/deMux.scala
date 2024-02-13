package MuxDeMux

import chisel3._
import chisel3.util._

//Fill in the deMux1to2 to handle an input of width n bits and drive the correct output based on the select signals 

class deMux1to2(width: Int) extends Module { 
    val io = IO(new Bundle {
        val sel        = Input(UInt(1.W))
        val in         = Input(UInt(width.W))
        val d1         = Output(UInt(width.W))
        val d2         = Output(UInt(width.W))
    })

   

}

//Fill in deMux1to4 using deMux1to2's
class deMux1to4(width: Int) extends Module { 
    val io = IO(new Bundle {
        val s0         = Input(UInt(1.W))
        val s1         = Input(UInt(1.W))
        val in         = Input(UInt(width.W))
        val d1         = Output(UInt(width.W))
        val d2         = Output(UInt(width.W))
        val d3         = Output(UInt(width.W))
        val d4         = Output(UInt(width.W))
    })




  
}