package MuxDeMux

import chisel3._
import chisel3.util._

//Fill in the Mux2to1 and Mux4to1 to handle any inputs of width n bits give a singular output based on the select signals 
class Mux2to1(n: Int) extends Module { 
	val io = IO(new Bundle {
		val sel        = Input(UInt(1.W))
		val d1         = Input(UInt(n.W))
		val d2         = Input(UInt(n.W))
		val out        = Output(UInt(n.W))
	})



}
 
//Fill in Mux4to1 from Mux2to1s
class Mux4to1(n: Int) extends Module {
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